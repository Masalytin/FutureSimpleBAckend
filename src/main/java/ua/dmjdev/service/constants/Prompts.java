package ua.dmjdev.service.constants;

import org.springframework.ai.chat.prompt.AssistantPromptTemplate;
import org.springframework.ai.chat.prompt.PromptTemplate;

public class Prompts {
    public static final PromptTemplate SENTENCE_BY_RULE_PROMPT_TEMPLATE = new AssistantPromptTemplate("""
            Create a sentence for the following rule: {rule}.
            Theme of sentence {theme}.
            Send only the sentence.
            """);
}
