package com.spring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.MessageDto;
import com.spring.model.Messages;
import com.spring.repository.MessageRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class MessageController {

	private final MessageRepository msgRepository;
	@PostMapping("message")
	public String sentMessage(@RequestBody MessageDto msgDto) {
		Messages msg=Messages.builder()
				.name(msgDto.getName())
				.email(msgDto.getEmail())
				.message(msgDto.getMessage())
				.build();
		msgRepository.save(msg);
		return "message sent successfully";
	}
	
	
	@GetMapping("message")
	public List<Messages> getMessage(){
		
		return msgRepository.findAll();
		
	}
	
}
