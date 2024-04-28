package ua.dmjdev.dto;

import java.util.List;
import java.util.Map;

public enum CoursePart {
    BEGINNER_1(EnglishLevel.BEGINNER, "Вивчимо найважливіше",
            Map.of(
                    Rule.PRONOUNS, List.of(LessonTheme.USAGE_OF_SUBSTITUTES, LessonTheme.AVOIDANCE_OF_REPETITIONS, LessonTheme.ENHANCEMENT_OF_CONNECTION_IN_TEXT),
                    Rule.TO_BE, List.of(LessonTheme.VERB_TO_BE_IN_ENGLISH, LessonTheme.DESCRIPTION_OF_PERSONS_AND_OBJECTS, LessonTheme.CONFIRMATION_OF_FACTS),
                    Rule.WORD_ORDER, List.of(LessonTheme.CORRECT_WORD_ORDER, LessonTheme.FORMATION_OF_MEANINGFUL_SENTENCES, LessonTheme.AVOIDANCE_OF_MISUNDERSTANDINGS_IN_SPEECH),
                    Rule.ARTICLES, List.of(LessonTheme.USAGE_OF_ARTICLES, LessonTheme.TYPES_OF_ARTICLES)
            )),
    BEGINNER_2(EnglishLevel.BEGINNER, "Про актуальне",
            Map.of(
                    Rule.PRESENT_SIMPLE, List.of(LessonTheme.DESCRIPTION_OF_REGULAR_ACTIONS, LessonTheme.DAILY_ROUTINE_AND_HABITS, LessonTheme.GENERAL_FACTS_AND_TRUTH),
                    Rule.PREPOSITIONS, List.of(LessonTheme.USAGE_OF_PREPOSITIONS, LessonTheme.SPATIAL_AND_TEMPORAL_ORIENTATION, LessonTheme.CONNECTION_BETWEEN_OBJECTS),
                    Rule.PRESENT_CONTINUOUS, List.of(LessonTheme.ACTIONS_HAPPENING_NOW, LessonTheme.FUTURE_PLANS_AND_ARRANGEMENTS, LessonTheme.UNSTABLE_SITUATIONS),
                    Rule.THERE_IS_THERE_ARE, List.of(LessonTheme.DESCRIPTION_OF_OBJECTS_AVAILABILITY, LessonTheme.DESCRIPTION_OF_LOCATION, LessonTheme.ESTABLISHMENT_OF_FACTS)
            )),
    BEGINNER_3(EnglishLevel.BEGINNER, "Згадаємо минуле",
            Map.of(
                    Rule.PAST_SIMPLE, List.of(LessonTheme.DESCRIPTION_OF_PAST_EVENTS, LessonTheme.USAGE_OF_REGULAR_AND_IRREGULAR_VERBS, LessonTheme.COMPLETED_ACTIONS_IN_THE_PAST),
                    Rule.IRREGULAR_VERBS, List.of(LessonTheme.IRREGULAR_VERBS, LessonTheme.DESCRIPTION_OF_PERSONAL_ACTIONS, LessonTheme.USAGE_IN_SPOKEN_LANGUAGE),
                    Rule.PAST_CONTINUOUS, List.of(LessonTheme.ACTIONS_IN_PROGRESS_IN_THE_PAST, LessonTheme.COMPARISON_OF_EVENTS_IN_THE_PAST, LessonTheme.DESCRIPTION_OF_ACTION_DURATION)

            )),
    BEGINNER_4(EnglishLevel.BEGINNER, "Легко й просто",
            Map.of(
                    Rule.SOME_ANY_NO, List.of(LessonTheme.USAGE_OF_SOME_ANY_NO, LessonTheme.INDICATION_OF_QUANTITY_AND_AVAILABILITY, LessonTheme.AVOIDANCE_OF_AMBIGUITIES),
                    Rule.DEGREE_OF_COMPARISON, List.of(LessonTheme.DEGREE_OF_COMPARISON, LessonTheme.COMPARISON_OF_OBJECTS_BY_CHARACTERISTICS, LessonTheme.ENHANCEMENT_OF_COMPARISONS),
                    Rule.ADVERBS, List.of(LessonTheme.USAGE_OF_ADVERBS, LessonTheme.DESCRIPTION_OF_ACTIONS_AND_CIRCUMSTANCES, LessonTheme.ENHANCEMENT_OF_EXPRESSION)
            )),
    BEGINNER_5(EnglishLevel.BEGINNER, "Збудуємо майбутнє",
            Map.of(
                    Rule.FUTURE_SIMPLE, List.of(LessonTheme.FUTURE_EVENTS, LessonTheme.PLANS_AND_ARRANGEMENTS_IN_THE_FUTURE, LessonTheme.PREDICTIONS_AND_POSSIBLE_OUTCOMES),
                    Rule.TO_BE_GOING_TO, List.of(LessonTheme.FUTURE_PLANS, LessonTheme.REPLACEMENT_OF_SIMPLE_FUTURE_WITH_TO_BE_GOING_TO, LessonTheme.INTENTIONS_AND_PLANS),
                    Rule.PRESENT_PERFECT, List.of(LessonTheme.ACTIONS_THAT_HAVE_OCCURRED_BEFORE_THE_SPEAKING_MOMENT, LessonTheme.USAGE_OF_PRESENT_PERFECT_WITH_ALREADY_YET_JUST, LessonTheme.EXPERIENCE_AND_RESULTS),
                    Rule.INFINITIVE, List.of(LessonTheme.IMPERSONAL_INFINITIVE, LessonTheme.USAGE_OF_TO_PLUS_VERB, LessonTheme.INFINITIVE_AS_SUBJECT_OR_ADVERB),
                    Rule.GERUND, List.of(LessonTheme.GERUND, LessonTheme.USAGE_OF_ING_FORM, LessonTheme.GERUND_AS_SUBJECT_OBJECT_OR_ADVERB)
            )),
    BEGINNER_6(EnglishLevel.BEGINNER, "Модальні дєслова",
            Map.of(
                    Rule.MODAL_VERBS_MUST, List.of(LessonTheme.VERB_MUST, LessonTheme.ENHANCEMENT_OF_OBLIGATION, LessonTheme.NECESSITY_AND_OBLIGATION),
                    Rule.MODAL_VERBS_HAVE_TO, List.of(LessonTheme.VERB_HAVE_TO, LessonTheme.OBLIGATIONS_AND_NECESSITY, LessonTheme.DIFFERENCES_BETWEEN_MUST_AND_HAVE_TO),
                    Rule.MODAL_VERBS_SHOULD, List.of(LessonTheme.VERB_SHOULD, LessonTheme.RECOMMENDATIONS_AND_ADVICE, LessonTheme.SOFT_OBLIGATION)
            )),

    INTERMEDIATE_1(EnglishLevel.INTERMEDIATE, "Основи продвинутого рівня",
            Map.of(
                    Rule.CONDITIONALS, List.of(LessonTheme.CONDITIONAL_SENTENCES, LessonTheme.USAGE_OF_IF_CONSTRUCTIONS, LessonTheme.EXPRESSION_OF_CONDITIONS_AND_THEIR_RESULTS),
                    Rule.USED_TO, List.of(LessonTheme.USAGE_OF_USED_TO, LessonTheme.DESCRIPTION_OF_PAST_HABITS_AND_SITUATIONS, LessonTheme.COMPARISON_OF_USED_TO_AND_WOULD),
                    Rule.QUESTION_TAGS, List.of(LessonTheme.TAG_QUESTIONS, LessonTheme.ADDITION_OF_TAGS_TO_SENTENCES, LessonTheme.AFFIRMATION_OR_NEGATION)
            )),
    INTERMEDIATE_2(EnglishLevel.INTERMEDIATE, "Трішки зламаємо мізки",
            Map.of(
                    Rule.PAST_PERFECT, List.of(LessonTheme.PAST_PERFECT, LessonTheme.EVENTS_THAT_HAPPENED_BEFORE_A_SPECIFIC_POINT_IN_THE_PAST, LessonTheme.COMPARISON_OF_PAST_PERFECT_AND_PAST_SIMPLE),
                    Rule.AGREEMENT_OF_TENSES, List.of(LessonTheme.SEQUENCE_OF_TENSES, LessonTheme.CONNECTION_OF_TENSES_IN_COMPLEX_SENTENCES, LessonTheme.CORRECT_USAGE_OF_TENSES),
                    Rule.PRESENT_PERFECT_CONTINUOUS, List.of(LessonTheme.PRESENT_PERFECT_CONTINUOUS, LessonTheme.ACTIONS_IN_PROGRESS_UP_TO_THE_PRESENT_MOMENT, LessonTheme.COMPARISON_OF_PRESENT_PERFECT_CONTINUOUS_AND_PRESENT_PERFECT),
                    Rule.PASSIVE_VOICE, List.of(LessonTheme.PASSIVE_VOICE, LessonTheme.ACTIVE_AND_PASSIVE_VERBAL_STATEMENTS, LessonTheme.CONSTRUCTION_OF_PASSIVE_CONSTRUCTIONS)
            )),
    INTERMEDIATE_3(EnglishLevel.INTERMEDIATE, "Модальні дієслова",
            Map.of(
                    Rule.MODAL_VERBS_CAN_COULD, List.of(LessonTheme.MODAL_VERBS_CAN_AND_COULD, LessonTheme.PERMISSION_AND_POSSIBILITY, LessonTheme.POSSIBLE_PAST),
                    Rule.MODAL_VERBS_MAY_MIGHT, List.of(LessonTheme.MODAL_VERBS_MAY_AND_MIGHT, LessonTheme.POSSIBILITIES_AND_INDEFINITENESS, LessonTheme.POSSIBILITIES_AND_PERMISSIONS)
            )),
    ADVANCED_1(EnglishLevel.ADVANCED, "Останній крок",
            Map.of(
                    Rule.PUNCTUATION, List.of(LessonTheme.PUNCTUATION, LessonTheme.USAGE_OF_PUNCTUATION_MARKS, LessonTheme.RULES_OF_TEXT_FORMATTING),
                    Rule.FUTURE_PERFECT_CONTINUOUS, List.of(LessonTheme.FUTURE_PERFECT_CONTINUOUS, LessonTheme.EVENTS_THAT_WILL_CONTINUE_UP_TO_A_SPECIFIC_POINT_IN_THE_FUTURE, LessonTheme.COMPARISON_OF_FUTURE_PERFECT_CONTINUOUS_AND_FUTURE_PERFECT),
                    Rule.FUTURE_IN_THE_PAST, List.of(LessonTheme.FUTURE_IN_THE_PAST, LessonTheme.EXPRESSION_OF_FUTURE_EVENTS_FROM_A_PAST_PERSPECTIVE, LessonTheme.CONDITIONAL_CONSTRUCTIONS_FROM_THE_PAST_FOR_THE_FUTURE)
            ));
    

    private EnglishLevel englishLevel;
    private String description;
    private Map<Rule, List<LessonTheme>> lessonThemes;

    CoursePart(EnglishLevel englishLevel, String description, Map<Rule, List<LessonTheme>> lessonThemes) {
        this.englishLevel = englishLevel;
        this.description = description;
        this.lessonThemes = lessonThemes;
    }
    }
