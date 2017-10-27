package com.pod.producerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagePushService {
	
	  @Autowired
	  private KafkaTemplate<String, String> kafkaTemplate;
	  	
	public void pushMessage(String topic, String payload) {
		kafkaTemplate.send(topic, payload);
	}
}
