package ua.dmjdev.service;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.AssistantPromptTemplate;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;
import ua.dmjdev.dto.Rule;
import ua.dmjdev.models.TranslateTask;
import ua.dmjdev.models.usr.User;
import ua.dmjdev.repos.TranslateTaskRepository;

import java.util.*;

@Service
public class TranslateTaskService {
    private final ChatClient chatClient;
    private final UserService userService;
    private final PromptTemplate SENTENCE_BY_RULE_PROMPT_TEMPLATE = new AssistantPromptTemplate("Create a sentence for the following rule: {rule}. Send only the sentence.");
    private final TranslateTaskRepository translateTaskRepository;

    public TranslateTaskService(ChatClient chatClient, UserService userService,
                                TranslateTaskRepository translateTaskRepository) {
        this.chatClient = chatClient;
        this.userService = userService;
        this.translateTaskRepository = translateTaskRepository;
    }

    public TranslateTask generateRandomTaskForUser(User user) {
        TranslateTask generateTask = generateTaskByRule(userService.getRuleForNewTaskForUser(user));
        translateTaskRepository.save(generateTask);
        return generateTask;
    }

    public TranslateTask generateTaskByRule(Rule rule) {
        TranslateTask result = new TranslateTask();
        result.setRule(rule);
        String generatedSentence = chatClient.call(SENTENCE_BY_RULE_PROMPT_TEMPLATE.create(Map.of("rule", rule))).getResult().getOutput().getContent();
        result.setContent(generatedSentence);
        return result;
    }

    public void shuffleWords(String[] words) {
        List<String> wordList = Arrays.asList(words);
        Collections.shuffle(wordList, new Random());
        wordList.toArray(words);
    }
}
