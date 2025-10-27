package ma.enset.javakafka.service;

import ma.enset.javakafka.model.PageEvent;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.function.Function;

//@Service
public class StreamProcessorService {

    @Bean
    public Function<KStream<String, PageEvent>, KStream<String, Long>> processor() {
        return input -> input
                .map((key, value) -> new KeyValue<>(value.getPage(), value))
                .groupByKey(Grouped.with(Serdes.String(), null))
                .windowedBy(TimeWindows.ofSizeWithNoGrace(Duration.ofSeconds(10)))
                .count(Materialized.as("page-count-store"))
                .toStream()
                .map((windowedKey, count) -> {
                    String page = windowedKey.key();
                    System.out.println("📊 Analytics: Page " + page + " -> " + count + " views");
                    return new KeyValue<>(page, count);
                });
    }
}