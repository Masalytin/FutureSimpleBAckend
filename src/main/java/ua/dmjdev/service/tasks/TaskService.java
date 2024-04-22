package ua.dmjdev.service.tasks;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ua.dmjdev.dto.Rule;
import ua.dmjdev.models.tasks.listening.ListenSentence;
import ua.dmjdev.models.tasks.Task;
import ua.dmjdev.models.usr.User;
import ua.dmjdev.service.TranslateService;

@Service
public class TaskService {
    private TranslateSentenceTaskService translateSentenceTaskService;


    public TaskService(TranslateSentenceTaskService translateSentenceTaskService) {
        this.translateSentenceTaskService = translateSentenceTaskService;
    }


    public Task getTaskByRule(@NotNull Class<? extends  Task> taskClass, Rule rule, User user) {
        if (taskClass.equals(TranslateService.class)) {
            return translateSentenceTaskService.getByRule(rule);
        } else if (taskClass.equals(ListenSentence.class)) {

        }

        return null;
    }
}
