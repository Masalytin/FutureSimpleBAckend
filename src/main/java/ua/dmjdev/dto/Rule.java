package ua.dmjdev.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Rule {
    SUBJECT_VERB_AGREEMENT(EnglishLevel.A0),
    VERB_TENSES(EnglishLevel.A0),
    ARTICLES(EnglishLevel.A0),
    PREPOSITIONS(EnglishLevel.A0),
    PRONOUNS(EnglishLevel.A0),
    ADJECTIVE_ORDER(EnglishLevel.A0),
    CONDITIONALS(EnglishLevel.A0),
    PASSIVE_VOICE(EnglishLevel.A0),
    REPORTED_SPEECH(EnglishLevel.A0),
    MODALS(EnglishLevel.A0),
    GERUNDS_AND_INFINITIVES(EnglishLevel.A0),
    ARTICLES_WITH_PROPER_NOUNS(EnglishLevel.A0),
    COMPARATIVES_AND_SUPERLATIVES(EnglishLevel.A0),
    NOUN_PLURALS(EnglishLevel.A0),
    CONJUNCTIONS(EnglishLevel.A0),
    IRREGULAR_VERBS(EnglishLevel.A0),
    COUNTABLE_AND_UNCOUNTABLE_NOUNS(EnglishLevel.A0),
    DIRECT_AND_INDIRECT_OBJECTS(EnglishLevel.A0),
    NEGATION(EnglishLevel.A0),
    QUESTION_FORMS(EnglishLevel.A0),
    RELATIVE_CLAUSES(EnglishLevel.A0),
    PHRASAL_VERBS(EnglishLevel.A0),
    PRESENT_SIMPLE(EnglishLevel.A0),
    PRESENT_CONTINUOUS(EnglishLevel.A0),
    PRESENT_PERFECT(EnglishLevel.A0),
    PAST_SIMPLE(EnglishLevel.A0),
    PAST_CONTINUOUS(EnglishLevel.A0),
    PAST_PERFECT(EnglishLevel.A0),
    FUTURE_SIMPLE(EnglishLevel.A0),
    FUTURE_CONTINUOUS(EnglishLevel.A0),
    FUTURE_PERFECT(EnglishLevel.A0);
    private EnglishLevel LEVEL;

    Rule(EnglishLevel LEVEL) {
        this.LEVEL = LEVEL;
    }

    public EnglishLevel getLEVEL() {
        return this.LEVEL;
    }

    public static List<Rule> getValuesByLevel(EnglishLevel level) {
        return Arrays.stream(values()).filter(r -> r.LEVEL.equals(level)).toList();
    }

    public static List<Rule> getValueLessOrEqualLevel(EnglishLevel level) {
        return Arrays.stream(values()).filter(r -> r.LEVEL.ordinal() <= level.ordinal()).toList();
    }
}

