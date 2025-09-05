# ⚡ Apache Kafka and ZooKeeper Real-Time Streaming Project

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-green.svg)
![Kafka](https://img.shields.io/badge/ApacheKafka-3.x-orange.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

## 📖 Overview

This project demonstrates a real-time event streaming application using **Apache Kafka**, a distributed streaming platform designed for high-throughput, fault-tolerant, and scalable data processing. It includes:

- Kafka with **ZooKeeper** for metadata management  
- A **Spring Boot REST API** to send and read messages from Kafka topics  
- Real-time data streaming suitable for large-scale applications

---

## 🧩 Apache Kafka Components

- **Producer**: Publishes messages to Kafka topics  
- **Consumer**: Reads messages from Kafka topics  
- **Broker**: Kafka server that stores and manages data  
- **Topic**: Logical feed name for messages, divided into partitions  
- **Partition**: Enables parallel processing across brokers  
- **ZooKeeper**: Manages metadata and cluster coordination *(used in this project)*

---

## 🧰 Technologies Used

- **Platform**: Apache Kafka 3.x  
- **Metadata Management**: ZooKeeper  
- **Language**: Java 17  
- **Framework**: Spring Boot  
- **Build Tool**: Maven  
- **Testing Tool**: Postman or browser  
- **Dependencies**: Kafka Clients, Spring Kafka, Spring Web, Lombok

---

## 📁 Project Structure

```text
kafka-zookeeper-project/
├── src/main/java/com/ccp/
│   ├── RestKafkaApp.java        # Spring Boot application
│   ├── producer/
│   │   └── KafkaProducer.java   # Kafka Producer logic
│   ├── consumer/
│   │   └── KafkaConsumer.java   # Kafka Consumer logic
├── src/main/resources/
│   └── application.properties   # Configuration
├── kafka/
│   ├── bin/windows/             # Kafka & ZooKeeper scripts
│   └── config/                  # server.properties, zookeeper.properties
├── assets/                      # Images (logo, diagrams)
└── README.md
```

---

## 🛠️ Prerequisites

- Java 17+  
- Maven 3.6+  
- Apache Kafka (download from [kafka.apache.org](https://kafka.apache.org/downloads))  
- ZooKeeper (included with Kafka)  
- Postman or browser  
- Windows environment *(adjust for Linux/macOS)*

---

## ⚙️ Setup Instructions

### 📦 Download and Install Kafka

1. Download Kafka from [kafka.apache.org/downloads](https://kafka.apache.org/downloads)  
2. Extract to `C:\Kafka`  
3. Add `C:\Kafka\bin\windows` and `C:\Windows\System32\wbem` to your system PATH

### ▶️ Start ZooKeeper

```bash
C:\Kafka\bin\windows\zookeeper-server-start.bat C:\Kafka\config\zookeeper.properties
```

Keep the terminal running.

### ▶️ Start Kafka Server

```bash
C:\Kafka\bin\windows\kafka-server-start.bat C:\Kafka\config\server.properties
```

Keep the terminal running.

### 📥 Clone the Repository

```bash
git clone <repository-url>
cd kafka-zookeeper-project
```

### 🔧 Configure Spring Boot

Update `src/main/resources/application.properties`:

```properties
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.consumer.group-id=my-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer
server.port=4041
```

### 🏗️ Build the Project

```bash
mvn clean install
```

### ▶️ Run the Application

```bash
mvn spring-boot:run
```

---

## 📡 Usage

### 🔧 Send Messages to Kafka

```http
GET http://localhost:4041/RestKafkaApp/send?message=hello
```

Replace `hello` with any message:

```http
GET http://localhost:4041/RestKafkaApp/send?message=test_message
```

### 📥 Read All Messages

```http
GET http://localhost:4041/RestKafkaApp/seeAll
```

### 🧪 Test with Postman

- **Send Message**: `GET /RestKafkaApp/send?message=hello`  
- **Read Messages**: `GET /RestKafkaApp/seeAll`  
- *(Import Postman collection if provided)*

---

## 📌 Sample API Endpoints

### 📨 Send Message

```http
GET /RestKafkaApp/send?message={message}
```

**Example**:  
`http://localhost:4041/RestKafkaApp/send?message=hello`

**Response**:  
Confirmation of message sent to Kafka topic

### 📖 Read All Messages

```http
GET /RestKafkaApp/seeAll
```

**Response**:  
List of all messages in the topic

---

## 🧭 Architecture Diagram

> *(Add your diagram image to `assets/` and embed it here)*

---

## 📝 Notes

- ZooKeeper must run before Kafka  
- Adjust `server.properties` and `zookeeper.properties` for custom settings  
- Add brokers/partitions to scale Kafka  
- Modern Kafka supports **KRaft** (no ZooKeeper), but this project uses ZooKeeper for compatibility

---

## 🛠️ Troubleshooting

| Issue                     | Solution                                                                 |
|---------------------------|--------------------------------------------------------------------------|
| ZooKeeper/Kafka Not Starting | Verify PATH includes `C:\Kafka\bin\windows` and configs are correct     |
| Port Conflicts            | Ensure ports `2181` (ZooKeeper) and `9092` (Kafka) are free              |
| REST API Errors           | Confirm Spring Boot runs on port `4041` and Kafka is reachable           |
| README Wrapping           | Use LF line endings and proper Markdown formatting                       |

```bash
sed -i 's/\r$//' README.md
git add README.md
git commit -m "Fix line endings"
git push origin main
```

---

## 🚀 Future Enhancements

- Add authentication with Spring Security  
- Use multiple topics for different message types  
- Persist messages to a database  
- Deploy with Docker  
- Monitor Kafka with Prometheus and Grafana

---

## 🤝 Contributing

Contributions are welcome! Submit pull requests or open issues for bugs, improvements, or new features.

---

## 📜 License

This project is licensed under the **MIT License**.
