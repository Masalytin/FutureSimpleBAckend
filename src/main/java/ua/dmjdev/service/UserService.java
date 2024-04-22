package ua.dmjdev.service;

import org.springframework.stereotype.Service;
import ua.dmjdev.dto.Rule;
import ua.dmjdev.models.dictionary.Word;
import ua.dmjdev.models.dictionary.WordProgress;
import ua.dmjdev.models.dictionary.WordsSet;
import ua.dmjdev.models.usr.RuleProgress;
import ua.dmjdev.models.usr.User;
import ua.dmjdev.repos.UserRepository;
import ua.dmjdev.repos.WordProgressRepository;
import ua.dmjdev.util.NPLUtil;

import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class UserService {
    private final RuleProgressService ruleProgressService;
    private final WordService wordService;
    private final UserRepository repository;
    private final WordProgressRepository wordProgressRepository;

    public UserService(RuleProgressService ruleProgressService, WordService wordService, UserRepository repository,
                       WordProgressRepository wordProgressRepository) {
        this.ruleProgressService = ruleProgressService;
        this.wordService = wordService;
        this.repository = repository;
        this.wordProgressRepository = wordProgressRepository;
    }

    //TODO May it not be needed
    public void addUserWordsProgressFromSentence(User user, String sentence) {
        Set<String> words = NPLUtil.getWordsFromSentence(sentence);
        for (WordProgress wordProgress : user.getDictionary()) {
            String word = wordProgress.getWord().getName();
            if (words.contains(word)) {
                wordProgress.incProgress();
                words.remove(word);
                if (words.isEmpty())
                    break;
            }
        }
        for (String word : words) {
            addNewWordForUser(user, word);
        }
    }

    public void addWordFromWordsSetToUserDictionary(User user, WordsSet wordsSet) {
        if (!user.getAddedWordsSets().contains(wordsSet)) {
            for (Word word : wordsSet.getWords()) {
                addNewWordForUser(user, word.getName());
            }
        }
        user.getAddedWordsSets().add(wordsSet);
        repository.save(user);
    }

    public void addNewWordForUser(User user, String newWord) {
        Word word = wordService.saveWord(newWord);
        if (!wordProgressRepository.existsByUserAndWordName(user, newWord)) {
            user.getDictionary().add(new WordProgress(word));
            repository.save(user);
        }
    }

    public List<RuleProgress> getActualRuleProgressesForUser(User user) {
        List<Rule> actualRules = user.getEnglishLevel().getCurrentAndLessLevelsRules();
        return user.getRuleProgressList().stream().filter(rp -> actualRules.contains(rp.getRule())).toList();
    }

    public Rule getRuleForTaskForUser(User user) {
        int randomValueFromZeroToHundred = new Random().nextInt(100);
        if (randomValueFromZeroToHundred < 30) {
            return ruleProgressService.fetchLongUnstudiedRule(getActualRuleProgressesForUser(user));
        } else {
            return ruleProgressService.fetchWeaklyLearnedRule(getActualRuleProgressesForUser(user));
        }
    }
}
