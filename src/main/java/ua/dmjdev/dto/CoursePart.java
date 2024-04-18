package ua.dmjdev.dto;

import java.util.Map;

public enum CoursePart {
    MAIN_TITLES(EnglishLevel.BEGINNER, "",
            Map.of(
                    Rule.PRONOUNS, 2,
                    Rule.TO_BE, 2
            ));

    private EnglishLevel englishLevel;
    private String description;
    private Map<Rule, Integer> lessonsCount;

    CoursePart(EnglishLevel englishLevel, String description, Map<Rule, Integer> lessonsCount) {
        this.englishLevel = englishLevel;
        this.description = description;
        this.lessonsCount = lessonsCount;
    }
}
