# Kafka Spring Cloud Stream Demo

Real-time event streaming and data analytics using Apache Kafka and Spring Cloud Stream.

## Project Structure

- **Producer Service**: REST API to publish events to Kafka
- **Consumer Service**: Consumes and processes Kafka messages
- **Supplier Service**: Auto-generates data streams
- **Stream Processor**: Real-time analytics with Kafka Streams
- **Web Dashboard**: Live data visualization

## Technologies

- Apache Kafka 4.1.0
- Spring Boot 3.x
- Spring Cloud Stream
- Docker & Docker Compose
- Kafka Streams

## Setup

### Part 1: Local Kafka
```bash
# Start ZooKeeper
bin/zookeeper-server-start.sh config/zookeeper.properties

# Start Kafka
bin/kafka-server-start.sh config/server.properties
```

### Part 2: Docker
```bash
docker-compose up -d
```

### Part 3: Run Services
```bash
mvn spring-boot:run
```

## Topics

- `test-topic` - General testing
- `events` - Producer events
- `analytics` - Stream processing results

## License

MIT