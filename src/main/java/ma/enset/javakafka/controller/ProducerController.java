package ma.enset.javakafka.controller;

import ma.enset.javakafka.model.Event;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/events")
public class ProducerController {

    private final StreamBridge streamBridge;

    public ProducerController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @PostMapping
    public String sendEvent(@RequestBody String message) {
        Event event = new Event(
                UUID.randomUUID().toString(),
                message,
                System.currentTimeMillis()
        );

        streamBridge.send("producer-out-0", event);
        return "Event sent: " + event.getId();
    }
}