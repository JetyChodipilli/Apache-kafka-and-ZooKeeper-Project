# Apache-kafka-and-ZooKeeper-Project
Apache Kafka is a distributed event streaming platform developed by LinkedIn and later open-sourced through the Apache Software Foundation. It is designed to handle real-time data feeds with high throughput, fault tolerance, and scalability, making it ideal for applications that require processing large amounts of real-time data across distributed systems.

Components of Apache Kafka:
Producer: Publishes (writes) data to Kafka topics. Producers send records to a topic, which can be consumed by one or more consumers.
Consumer: Reads data from Kafka topics. Consumers can subscribe to one or multiple topics and read messages in the order they were stored.
Broker: A Kafka server that stores data and serves as an intermediary between producers and consumers. Brokers handle the storage and replication of data, ensuring reliability and fault tolerance.
Topic: A category or feed name to which messages are published. Topics can have multiple partitions, which allows for parallelism and higher throughput.
Partition: Each topic can be divided into partitions. Partitions allow Kafka to split data across multiple brokers, providing scalability by allowing parallel processing of data.
Zookeeper (often replaced by KRaft): Used traditionally for managing metadata and cluster information, although Kafka has developed its own metadata management system, KRaft, to handle this natively.

Producer:
Step1) Download apache kafka from https://kafka.apache.org/downloads.
Step2) Extract all files and add its Path in System varibles in your PC and also add c:\\windows\system32\wbem path too.
Step3)Start Zookeeper as Bootstrap server by running the below commands
 C:\Kafka\bin\windows\zookeeper-server-start.bat C:\Kafka\config\zookeeper.properties
Step4) Start the Kafka server by running these commands in command prompt
C:\Kafka\bin\windows\kafka-server-start.bat C:\Kafka\config\server.properties
Step5)And Follow the code and run it browser by 
 http://localhost:4041/RestKafkaApp/send?message=hello (to send message) you can send multiple messages by changing message in context path.
 http://localhost:4041/RestKafkaApp/seeAll (to read All message)
