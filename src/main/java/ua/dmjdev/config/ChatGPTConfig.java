package ua.dmjdev.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@PropertySource("application.properties")
public class ChatGPTConfig {
    @Value("${openai.url}")
    private String url;
    // TODO: 08.04.2024 Get API Key
    @Value("${openai.token}")
    private String token;
}