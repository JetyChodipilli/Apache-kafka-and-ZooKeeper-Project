package com.jt.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jt.consumer.MessageStore;
import com.jt.producer.MessageProducer;

@RestController
public class KafkaMessageController {
	@Autowired
	private MessageProducer producer;
	@Autowired
	private MessageStore store;
	
	@GetMapping("/send")
	public String sendMessage(@RequestParam("message") String message) {
		String status=producer.sendMessage(message);
		return "<h1>"+status+"</h1>";
	}
	@GetMapping("/readAll")
	public String fetcgMessage() {
		return "<h1>"+store.getAllMessage()+"</h1>";
	}
}
