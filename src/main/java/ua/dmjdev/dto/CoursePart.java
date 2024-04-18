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
                    Rule.PRESENT_SIMPLE, List.of("Опис регулярних дій", "Повсякденні рутина та звички", "Загальні факти та правдивість"),
                    Rule.PREPOSITIONS, List.of("Використання прийменників", "Орієнтація в просторі та часі", "Зв'язок між предметами"),
                    Rule.PRESENT_CONTINUOUS, List.of("Дії, що відбуваються зараз", "Майбутні плани та домовленості", "Нестабільні ситуації"),
                    Rule.THERE_IS_THERE_ARE, List.of("Опис наявності предметів", "Опис місця розташування", "З'ясування фактів")
            )),
    BEGINNER_3(EnglishLevel.BEGINNER, "Згадаємо минуле",
            Map.of(
                    Rule.PAST_SIMPLE, List.of("Опис минулих подій", "Використання звичайних та неправильних дієслів", "Завершені дії в минулому"),
                    Rule.IRREGULAR_VERBS, List.of("Неправильні дієслова", "Опис особистих дій", "Використання в розмовному мовленні"),
                    Rule.PAST_CONTINUOUS, List.of("Дії в процесі у минулому", "Порівняння подій у минулому", "Опис тривалості дій")

            )),
    BEGINNER_4(EnglishLevel.BEGINNER, "Легко й просто",
            Map.of(
                    Rule.SOME_ANY_NO, List.of("Використання some, any, no", "Позначення кількості та наявності", "Уникання неоднозначностей"),
                    Rule.DEGREE_OF_COMPARISON, List.of("Ступені порівняння", "Порівняння предметів за характеристиками", "Підсилення порівнянь"),
                    Rule.ADVERBS, List.of("Майбутні події", "Плани та домовленості у майбутньому", "Прогнози та можливі результати")
            )),
    BEGINNER_5(EnglishLevel.BEGINNER, "Збудуємо майбутнє",
            Map.of(
                    Rule.FUTURE_SIMPLE, List.of("Майбутні події", "Плани та домовленості у майбутньому", "Прогнози та можливі результати"),
                    Rule.TO_BE_GOING_TO, List.of("Майбутні плани", "Заміна будущого простого на to be going to", "Наміри та плани"),
                    Rule.PRESENT_PERFECT, List.of("Дії, що відбулися до моменту говоріння", "Використання present perfect з already, yet, just", "Досвід та результати"),
                    Rule.INFINITIVE, List.of("Безособовий інфінітив", "Використання to + дієслово", "Інфінітив у функції підмета або обставини"),
                    Rule.GERUND, List.of("Герундій", "Використання -ing форми", "Герундій у функції підмета, об'єкта або обставини")
            )),
    BEGINNER_6(EnglishLevel.BEGINNER, "Модальні дєслова",
            Map.of(
                    Rule.MODAL_VERBS_MUST, List.of("Дієслово must", "Підсилення невід'ємності", "Доцільність та необхідність"),
                    Rule.MODAL_VERBS_HAVE_TO, List.of("Дієслово have to", "Зобов'язання та необхідність", "Відмінності між must та have to"),
                    Rule.MODAL_VERBS_SHOULD, List.of("Дієслово should", "Рекомендації та поради", "М'яке зобов'язання")
            )),

    INTERMEDIATE_1(EnglishLevel.INTERMEDIATE, "Основи продвинутого рівня",
            Map.of(
                    Rule.CONDITIONALS, List.of("Умовні речення", "Використання if-конструкцій", "Вираження умов та їх результатів"),
                    Rule.USED_TO, List.of("Використання used to", "Опис минулих звичок та ситуацій", "Порівняння used to та would"),
                    Rule.QUESTION_TAGS, List.of("Тегові питання", "Додавання тегів до речень", "Підтвердження або заперечення")
            )),
    INTERMEDIATE_2(EnglishLevel.INTERMEDIATE, "Трішки зламаємо мізки",
            Map.of(
                    Rule.PAST_PERFECT, List.of("Past Perfect", "Події, які відбулися до певного моменту в минулому", "Порівняння Past Perfect та Past Simple"),
                    Rule.AGREEMENT_OF_TENSES, List.of("Узгодження часів", "Зв'язок часів у складних реченнях", "Правильне використання часів"),
                    Rule.PRESENT_PERFECT_CONTINUOUS, List.of("Present Perfect Continuous", "Дії, що тривають до моменту говоріння", "Порівняння Present Perfect Continuous та Present Perfect"),
                    Rule.PASSIVE_VOICE, List.of("Passive Voice", "Активне та пасивне дієприкметникове становище", "Побудова пасивних конструкцій")
            )),
    INTERMEDIATE_3(EnglishLevel.INTERMEDIATE, "Модальні дієслова",
            Map.of(
                    Rule.MODAL_VERBS_CAN_COULD, List.of("Модальні дієслова can та could", "Можливості та дозволи", "Можливе минуле"),
                    Rule.MODAL_VERBS_MAY_MIGHT, List.of("Модальні дієслова may та might", "Можливості та невизначеність", "Дозвіл та можливість")
            )),
    ADVANCED_1(EnglishLevel.ADVANCED, "Останній крок",
            Map.of(
                    Rule.PUNCTUATION, List.of("Пунктуація", "Використання розділових знаків", "Правила оформлення текстів"),
                    Rule.FUTURE_PERFECT_CONTINUOUS, List.of("Future Perfect Continuous", "Події, які триватимуть до певного моменту у майбутньому", "Порівняння Future Perfect Continuous та Future Perfect"),
                    Rule.FUTURE_IN_THE_PAST, List.of("Future in the Past", "Вираження майбутньої події з погляду минулого", "Умовні конструкції минулого для майбутнього"),
                    Rule.CONDITIONAL_PERFECT, List.of("Conditional Perfect", "Умовне дієслово з минулого в Perfect", "Вирази умови для умовного Perfect"),
                    Rule.INVERSION, List.of("Inversion", "Обернення порядку слів для наголосу чи стилістичних ефектів", "Правила та вживання інверсії в англійській мові"),
                    Rule.PARALLELISM, List.of("Parallelism", "Паралелізм у реченнях для збереження стилістичної рівноваги", "Використання паралелізму для покращення зрозумілості тексту")
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
