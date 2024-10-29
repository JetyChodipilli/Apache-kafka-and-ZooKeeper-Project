package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class Msp10KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Msp10KafkaApplication.class, args);
	}

}
