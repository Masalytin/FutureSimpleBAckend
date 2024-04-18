package ua.dmjdev.dto;

import java.util.List;
import java.util.Map;

public enum CoursePart {
    BEGINNER_1(EnglishLevel.BEGINNER, "Вивчимо найважливіше",
            Map.of(
                    Rule.PRONOUNS, List.of("Використання замісників", "Уникання повторів в мовленні", "Підсилення зв'язку в тексті"),
                    Rule.TO_BE, List.of("Дієслово 'бути' в англійській", "Опис особи та предметів", "Підтвердження фактів"),
                    Rule.WORD_ORDER, List.of("Правильний порядок слів", "Формування змістовних речень", "Уникання недорозумінь у мовленні")
            )),
    BEGINNER_2(EnglishLevel.BEGINNER, "Про актуальне",
            Map.of(
                    Rule.PRESENT_SIMPLE, List.of(),
                    Rule.PREPOSITIONS, List.of(),
                    Rule.PRESENT_CONTINUOUS, List.of(),
                    Rule.THERE_IS_THERE_ARE, List.of()
            )),
    BEGINNER_3(EnglishLevel.BEGINNER, "Згадаємо минуле",
            Map.of(
                    Rule.PAST_SIMPLE, List.of(),
                    Rule.IRREGULAR_VERBS, List.of(),
                    Rule.PAST_CONTINUOUS, List.of()

            )),
    BEGINNER_4(EnglishLevel.BEGINNER, "Легко й просто",
            Map.of(
                    Rule.SOME_ANY_NO, List.of(),
                    Rule.DEGREE_OF_COMPARISON, List.of(),
                    Rule.ADVERBS, List.of()
            )),
    BEGINNER_5(EnglishLevel.BEGINNER, "Збудуємо майбутнє",
            Map.of(
                    Rule.FUTURE_SIMPLE, List.of(),
                    Rule.TO_BE_GOING_TO, List.of(),
                    Rule.PRESENT_PERFECT, List.of(),
                    Rule.INFINITIVE, List.of(),
                    Rule.GERUND, List.of()
            )),
    BEGINNER_6(EnglishLevel.BEGINNER, "Модальні дєслова",
            Map.of(
                    Rule.MODAL_VERBS_MUST, List.of(),
                    Rule.MODAL_VERBS_HAVE_TO, List.of(),
                    Rule.MODAL_VERBS_SHOULD, List.of()
            )),

    INTERMEDIATE_1(EnglishLevel.INTERMEDIATE, "Основи продвинутого рівня",
            Map.of(
                    Rule.CONDITIONALS, List.of(),
                    Rule.USED_TO, List.of(),
                    Rule.QUESTION_TAGS, List.of()
            )),
    INTERMEDIATE_2(EnglishLevel.INTERMEDIATE, "Трішки зламаємо мізки",
            Map.of(
                    Rule.PAST_PERFECT, List.of(),
                    Rule.AGREEMENT_OF_TENSES, List.of(),
                    Rule.PRESENT_PERFECT_CONTINUOUS, List.of(),
                    Rule.PASSIVE_VOICE, List.of()
            )),
    INTERMEDIATE_3(EnglishLevel.INTERMEDIATE, "Модальні дієслова",
            Map.of(
                    Rule.MODAL_VERBS_CAN_COULD, List.of(),
                    Rule.MODAL_VERBS_MAY_MIGHT, List.of()
            )),
    ADVANCED_1(EnglishLevel.ADVANCED, "Останній крок",
            Map.of(
                    Rule.PUNCTUATION, List.of(),
                    Rule.FUTURE_PERFECT_CONTINUOUS, List.of(),
                    Rule.FUTURE_IN_THE_PAST, List.of()
            ));
    

    private EnglishLevel englishLevel;
    private String description;
    private Map<Rule, List<String>> lessonThemes;

    CoursePart(EnglishLevel englishLevel, String description, Map<Rule, List<String>> lessonThemes) {
        this.englishLevel = englishLevel;
        this.description = description;
        this.lessonThemes = lessonThemes;
    }
    }
