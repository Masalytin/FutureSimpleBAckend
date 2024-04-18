package ua.dmjdev.dto;

import java.util.Map;

public enum CoursePart {
    BEGINNER_1(EnglishLevel.BEGINNER, "Вивчимо найважливіше",
            Map.of(
                    Rule.PRONOUNS, 2,
                    Rule.TO_BE, 2,
                    Rule.WORD_ORDER, 2
            )),
    BEGINNER_2(EnglishLevel.BEGINNER, "Про актуальне",
            Map.of(
                    Rule.PRESENT_SIMPLE, 2,
                    Rule.PREPOSITIONS, 2,
                    Rule.PRESENT_CONTINUOUS, 2,
                    Rule.THERE_IS_THERE_ARE, 2
            )),
    BEGINNER_3(EnglishLevel.BEGINNER, "Згадаємо минуле",
            Map.of(
                    Rule.PAST_SIMPLE, 2,
                    Rule.IRREGULAR_VERBS, 2,
                    Rule.PAST_CONTINUOUS, 2

            )),
    BEGINNER_4(EnglishLevel.BEGINNER, "Легко й просто",
            Map.of(
                    Rule.SOME_ANY_NO, 2,
                    Rule.DEGREE_OF_COMPARISON, 2,
                    Rule.ADVERBS, 2
            )),
    BEGINNER_5(EnglishLevel.BEGINNER, "Збудуємо майбутнє",
            Map.of(
                    Rule.FUTURE_SIMPLE, 2,
                    Rule.TO_BE_GOING_TO, 2,
                    Rule.PRESENT_PERFECT, 2,
                    Rule.INFINITIVE, 2,
                    Rule.GERUND, 2
            )),
    BEGINNER_6(EnglishLevel.BEGINNER, "Модальні дєслова",
            Map.of(
                    Rule.MODAL_VERBS_MUST, 2,
                    Rule.MODAL_VERBS_HAVE_TO, 2,
                    Rule.MODAL_VERBS_SHOULD, 2
            )),

    INTERMEDIATE_1(EnglishLevel.INTERMEDIATE, "Основи продвинутого рівня",
            Map.of(
                    Rule.CONDITIONALS, 3,
                    Rule.USED_TO, 2,
                    Rule.QUESTION_TAGS, 2
            )),
    INTERMEDIATE_3(EnglishLevel.INTERMEDIATE, "Модальні дієслова",
            Map.of(
                    Rule.MODAL_VERBS_CAN_COULD, 2,
                    Rule.MODAL_VERBS_MAY_MIGHT, 2
            )),
    INTERMEDIATE_2(EnglishLevel.INTERMEDIATE, "Трішки зламаємо мізки",
            Map.of(
                    Rule.PAST_PERFECT, 2,
                    Rule.AGREEMENT_OF_TENSES, 2,
                    Rule.PRESENT_PERFECT_CONTINUOUS, 2,
                    Rule.PASSIVE_VOICE, 2
            )),
    ADVANCED_1(EnglishLevel.ADVANCED, "Останній крок",
            Map.of(
                    Rule.PUNCTUATION, 5,
                    Rule.FUTURE_PERFECT_CONTINUOUS, 5,
                    Rule.FUTURE_IN_THE_PAST, 5
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
