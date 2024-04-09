package ua.dmjdev.service;

import org.springframework.stereotype.Service;
import ua.dmjdev.dto.Rule;
import ua.dmjdev.models.usr.RuleProgress;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
public class RuleProgressService {
    private static final byte MINIMUM_PROGRESS_THRESHOLD = 4;

    public Rule fetchWeaklyLearnedRule(List<RuleProgress> ruleProgressList) {
        for (RuleProgress ruleProgress : ruleProgressList) {
            if (ruleProgress.getProgress() < MINIMUM_PROGRESS_THRESHOLD) {
                return ruleProgress.getRule();
            }
        }
        return ruleProgressList.get(new Random().nextInt(ruleProgressList.size())).getRule();
    }

    public Rule fetchLongUnstudiedRule(List<RuleProgress> ruleProgressList) {
        List<RuleProgress> sortedByLastSuccessfulAttemptDateTime = ruleProgressList.stream()
                .sorted(Comparator.comparing(RuleProgress::getLastSuccessfulAttemptDateTime)).toList();
        return sortedByLastSuccessfulAttemptDateTime.get(new Random().nextInt(ruleProgressList.size() / 2)).getRule();
    }
}
