package ua.dmjdev.service;

import org.springframework.stereotype.Service;
import ua.dmjdev.dto.Rule;
import ua.dmjdev.models.usr.User;

import java.util.Random;

@Service
public class UserService {
    private final RuleProgressService ruleProgressService;

    public UserService(RuleProgressService ruleProgressService) {
        this.ruleProgressService = ruleProgressService;
    }

    public Rule getRuleForNewTaskForUser(User user) {
        int randomValueFromZeroToHundred = new Random().nextInt(100);
        if (randomValueFromZeroToHundred < 30) {
            return ruleProgressService.fetchLongUnstudiedRule(user.getProgressList());
        } else {
            return ruleProgressService.fetchWeaklyLearnedRule(user.getProgressList());
        }
    }
}
