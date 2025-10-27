package ma.enset.javakafka.service;

import ma.enset.javakafka.model.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class ConsumerService {

    @Bean
    public Consumer<Event> consumer() {
        return event -> {
            System.out.println("==================");
            System.out.println("Received Event:");
            System.out.println("ID: " + event.getId());
            System.out.println("Message: " + event.getMessage());
            System.out.println("Timestamp: " + event.getTimestamp());
            System.out.println("==================");
        };
    }
}