package ma.enset.javakafka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    // This will be shared with AnalyticsService
    private static final Map<String, Long> pageViewCount = new HashMap<>();

    public static void updatePageView(String page, Long count) {
        pageViewCount.put(page, count);
    }

    @GetMapping("/page-views")
    public Map<String, Long> getPageViews() {
        return new HashMap<>(pageViewCount);
    }
}