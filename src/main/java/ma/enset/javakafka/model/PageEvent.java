package ma.enset.javakafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageEvent {
    private String userId;
    private String page;
    private String action; // VIEW, CLICK, SCROLL, etc.
    private long timestamp;
    private long duration; // time spent in milliseconds
}