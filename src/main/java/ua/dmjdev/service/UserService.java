package ua.dmjdev.service;

import org.springframework.stereotype.Service;
import ua.dmjdev.dto.Rule;
import ua.dmjdev.models.dictionary.Word;
import ua.dmjdev.models.dictionary.WordProgress;
import ua.dmjdev.models.usr.RuleProgress;
import ua.dmjdev.models.usr.User;
import ua.dmjdev.repos.UserRepository;

import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class UserService {
    private final RuleProgressService ruleProgressService;
    private final NPLService nplService;
    private final WordService wordService;
    private final UserRepository repository;

    public UserService(RuleProgressService ruleProgressService, NPLService nplService, WordService wordService, UserRepository repository) {
        this.ruleProgressService = ruleProgressService;
        this.nplService = nplService;
        this.wordService = wordService;
        this.repository = repository;
    }

    public void addUserWordsProgressFromSentence(User user, String sentence) {
        Set<String> words = nplService.getWordsFromSentence(sentence);
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

    public void addNewWordForUser(User user, String newWord) {
        Word word = wordService.saveWord(newWord);
        user.getDictionary().add(new WordProgress(word));
        repository.save(user);
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
