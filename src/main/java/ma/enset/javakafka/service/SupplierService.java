package ma.enset.javakafka.service;

import ma.enset.javakafka.model.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.function.Supplier;

@Service
public class SupplierService {

    private final Random random = new Random();
    private final String[] users = {"user1", "user2", "user3", "user4", "user5"};
    private final String[] pages = {"/home", "/products", "/cart", "/checkout", "/profile"};
    private final String[] actions = {"VIEW", "CLICK", "SCROLL", "HOVER"};

    @Bean
    public Supplier<PageEvent> supplier() {
        return () -> {
            PageEvent event = new PageEvent(
                    users[random.nextInt(users.length)],
                    pages[random.nextInt(pages.length)],
                    actions[random.nextInt(actions.length)],
                    System.currentTimeMillis(),
                    random.nextInt(10000) // 0-10 seconds
            );

            System.out.println("📤 Generated: " + event);
            return event;
        };
    }
}