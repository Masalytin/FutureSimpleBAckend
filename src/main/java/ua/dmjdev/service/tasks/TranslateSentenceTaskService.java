package ua.dmjdev.service.tasks;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;
import ua.dmjdev.dto.Language;
import ua.dmjdev.dto.Rule;
import ua.dmjdev.models.tasks.Task;
import ua.dmjdev.models.tasks.grammar.TranslateSentence;
import ua.dmjdev.models.usr.User;
import ua.dmjdev.repos.TranslateSentenceTaskRepository;
import ua.dmjdev.service.TranslateService;
import ua.dmjdev.service.UserService;
import ua.dmjdev.util.PromptsUtil;

@Service
public class TranslateSentenceTaskService {
    final double CHANCE_TRANSLATE_TASK_FROM_DB = 0.3;
    private final ChatClient chatClient;
    private final UserService userService;
    private final TranslateService translateService;
    private final TranslateSentenceTaskRepository translateSentenceTaskRepository;

    public TranslateSentenceTaskService(ChatClient chatClient, UserService userService, TranslateService translateService,
                                        TranslateSentenceTaskRepository translateSentenceTaskRepository) {
        this.chatClient = chatClient;
        this.userService = userService;
        this.translateService = translateService;
        this.translateSentenceTaskRepository = translateSentenceTaskRepository;
    }

    public TranslateSentence getRandomForUser(User user) {
        if (Math.random() < CHANCE_TRANSLATE_TASK_FROM_DB) {
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
        AssistantMessage assistantMessage = new AssistantMessage(String.format(PromptsUtil.SENTENCE_BY_RULE_PROMPT_FORMAT,
                rule));
        OpenAiChatOptions chatOptions = new OpenAiChatOptions();
        chatOptions.setModel("gpt-4");
        chatOptions.setTemperature(0.8f);
        chatOptions.setMaxTokens(50);
        chatOptions.setTopP(1f);
        String generatedSentence = chatClient.call(new Prompt(assistantMessage, chatOptions)).getResult().getOutput().getContent();
        result.setSentence(generatedSentence);
        result.setTranslate(translateService.translate(generatedSentence, Language.EN, Language.UK));
        return result;
    }

    public Task getByRule(Rule rule) {
        if (Math.random() < CHANCE_TRANSLATE_TASK_FROM_DB) {
            return translateSentenceTaskRepository.findRandomByRule(rule);
        } else {
            return generateTaskByRule(rule);
        }
    }
}
