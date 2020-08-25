package com.tutorial.student_service.filter;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.tutorial.student_service.models.SendResponse;
import com.tutorial.student_service.models.StudentSgpaDto;

import reactor.core.publisher.Mono;

@Service
public class ParallelService {

	@Autowired
	private WebClient.Builder builder;
	
	public Mono<SendResponse> aaa(String id) {	
	Mono<SendResponse> d = builder.build().get().uri("http://localhost:8080/placement-event/" + id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(SendResponse.class);
	return d;
	}
	
	public Mono<StudentSgpaDto> getCGPA(String st) {
		Mono<StudentSgpaDto> cgpa = builder.build().get().uri("http://localhost:8220/student-grade/" + st).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(StudentSgpaDto.class);
		return cgpa;
	}
}
