# Kafka Spring Cloud Stream Demo

Real-time event streaming and analytics application using Apache Kafka and Spring Cloud Stream.

## Demo Video

🎥 **[Watch Demo Video](#)** *(ressources/tp1-kafka-streams-demo.webm)*

---

## Project Structure
```
src/main/java/ma/enset/javakafka/
├── JavaKafkaApplication.java           # Main application entry point
├── controller/
│   ├── ProducerController.java         # POST /api/events - Manual event publishing
│   └── AnalyticsController.java        # GET /api/analytics/page-views - Analytics data
├── service/
│   ├── ConsumerService.java            # Consumes and logs events from 'events' topic
│   ├── SupplierService.java            # Auto-generates PageEvents every 2 seconds
│   └── AnalyticsService.java           # Real-time analytics - counts page views
├── model/
│   ├── Event.java                      # Basic event model
│   └── PageEvent.java                  # User activity model (userId, page, action, duration)
└── resources/
    ├── application.yml                 # Kafka and Spring Cloud Stream configuration
    └── static/index.html               # Live analytics dashboard with bar chart
```

---

## Components

| Component | Description |
|-----------|-------------|
| **ProducerController** | REST API to manually send events to Kafka |
| **ConsumerService** | Listens to `events` topic and logs messages |
| **SupplierService** | Automatically generates random PageEvents every 2 seconds |
| **AnalyticsService** | Processes data stream and counts page views by page |
| **AnalyticsController** | Exposes analytics data as JSON for dashboard |
| **Dashboard** | Live visualization with auto-updating bar chart |

---

## Technologies

- **Apache Kafka 4.1.0** (KRaft mode)
- **Spring Boot 3.5.7**
- **Spring Cloud Stream 4.3.0**
- **Docker & Docker Compose**
- **Maven + Lombok**

---

## Quick Start
```bash
# 1. Start Kafka
docker compose up -d

# 2. Start Spring Boot application
mvn spring-boot:run

# 3. Open dashboard
http://localhost:8080
```

---

## Kafka Topics

- **events** - Producer/Consumer communication
- **data-stream** - Auto-generated PageEvents → Analytics processing

---

## Usage

### View Live Dashboard
```
http://localhost:8080
```
Displays real-time bar chart of page views (updates every 2 seconds)

---

## Architecture
```
┌──────────────────┐      ┌─────────────┐      ┌─────────────────┐
│ ProducerController│─────▶│Kafka: events│─────▶│ ConsumerService │
│   (REST API)     │      └─────────────┘      │  (logs events)  │
└──────────────────┘                            └─────────────────┘

┌──────────────────┐      ┌──────────────┐      ┌──────────────────┐
│ SupplierService  │─────▶│Kafka: data-  │─────▶│ AnalyticsService │
│ (auto-gen every  │      │    stream    │      │ (count views)    │
│    2 seconds)    │      └──────────────┘      └────────┬─────────┘
└──────────────────┘                                     │
                                                         ▼
                                             ┌─────────────────────┐
                                             │  Web Dashboard      │
                                             │  (live bar chart)   │
                                             └─────────────────────┘
```

---

## Features

✅ REST API for manual event publishing  
✅ Auto-generated data stream  
✅ Real-time data analytics  
✅ Live web dashboard with visualization  
✅ Docker-based Kafka setup

---

## License

MIT