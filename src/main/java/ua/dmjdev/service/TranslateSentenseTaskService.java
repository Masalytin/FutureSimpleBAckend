package ua.dmjdev.service;

import org.springframework.ai.chat.ChatClient;
import org.springframework.stereotype.Service;
import ua.dmjdev.dto.Language;
import ua.dmjdev.dto.Rule;
import ua.dmjdev.models.tasks.TranslateSentence;
import ua.dmjdev.models.usr.User;
import ua.dmjdev.repos.TranslateSentenceTaskRepository;
import ua.dmjdev.service.constants.Prompts;

import java.util.*;

@Service
public class TranslateSentenseTaskService {
    private final ChatClient chatClient;
    private final UserService userService;
    private final TranslateService translateService;
    private final TranslateSentenceTaskRepository translateSentenceTaskRepository;

    public TranslateSentenseTaskService(ChatClient chatClient, UserService userService, TranslateService translateService,
                                        TranslateSentenceTaskRepository translateSentenceTaskRepository) {
        this.chatClient = chatClient;
        this.userService = userService;
        this.translateService = translateService;
        this.translateSentenceTaskRepository = translateSentenceTaskRepository;
    }

    public TranslateSentence getRandomForUser(User user) {
        if (new Random().nextInt(0, 100) < 30) {
            return translateSentenceTaskRepository.findRandomByRule(userService.getRuleForTaskForUser(user));
        } else {
            return generateRandomTaskForUser(user);
        }
    }

    public TranslateSentence generateRandomTaskForUser(User user) {
        TranslateSentence generateTask = generateTaskByRule(userService.getRuleForTaskForUser(user));
        translateSentenceTaskRepository.save(generateTask);
        return generateTask;
    }

    public TranslateSentence generateTaskByRule(Rule rule) {
        TranslateSentence result = new TranslateSentence();
        result.setRule(rule);
        String generatedSentence = chatClient.call(Prompts.SENTENCE_BY_RULE_PROMPT_TEMPLATE.create(Map.of("rule", rule))).getResult().getOutput().getContent();
        result.setContent(generatedSentence);
        result.setTranslate(translateService.translate(generatedSentence, Language.EN, Language.UK));
        return result;
    }
}
