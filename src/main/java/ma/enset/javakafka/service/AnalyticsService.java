package ma.enset.javakafka.service;

import ma.enset.javakafka.controller.AnalyticsController;
import ma.enset.javakafka.model.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Service
public class AnalyticsService {

    private final Map<String, Long> pageViewCount = new HashMap<>();

    @Bean
    public Consumer<PageEvent> analytics() {
        return event -> {
            // Count page views
            pageViewCount.merge(event.getPage(), 1L, Long::sum);

            // Update controller data for REST API
            AnalyticsController.updatePageView(event.getPage(), pageViewCount.get(event.getPage()));

            System.out.println("📊 Real-time Analytics:");
            System.out.println("   Page: " + event.getPage());
            System.out.println("   Total views: " + pageViewCount.get(event.getPage()));
            System.out.println("------------------------");
        };
    }
}