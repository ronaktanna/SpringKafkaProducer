package com.pod.producerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pod.producerservice.service.KafkaMessagePushService;

@RequestMapping("/kafkaproducer")
@RestController
public class RestApiController {
	
	@Autowired
	KafkaMessagePushService kafkaMessagePushService;
	
	@RequestMapping(value = "/pushmessage", method = RequestMethod.POST)
	public ResponseEntity<String> pushMessagesToTopic(@RequestBody String message) {
		try {
			kafkaMessagePushService.pushMessage("test", message);
			return new ResponseEntity<String>("Done", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>("Exception Occured", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
