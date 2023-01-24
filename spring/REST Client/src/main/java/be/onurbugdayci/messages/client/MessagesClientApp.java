package be.onurbugdayci.messages.client;

import be.onurbugdayci.messages.domain.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MessagesClientApp {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.requestFactory(
                        HttpComponentsClientHttpRequestFactory::new)
                .basicAuthentication("user", "password").build();
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(MessagesClientApp.class, args);
        MessagesClient messagesClient =
                ctx.getBean(MessagesClient.class);
        Message message = messagesClient.getMessageById(1);
        System.out.println(message.getText());
    }
}
