package com.tutorial.student_service.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.concurrent.ExecutionException;
import com.tutorial.student_service.models.SendResponse;
import com.tutorial.student_service.models.StudentPersonalDetailsDto;
import com.tutorial.student_service.models.StudentPlacement;
import com.tutorial.student_service.util.ParallelService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;


@RestController
@RequestMapping("/student")
public class StudentServiceController {
	
	@Autowired
	private WebClient.Builder builder;
	
	@Autowired
	private ParallelService parallelService;
	
	@Autowired
	SendResponse response;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceController.class);
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public SendResponse getPlacementDetails(@PathVariable("id") String id){
		
		SendResponse details = null;
		try {
			logger.info("Retrieving profile details");
			details = builder.build().get().uri("http://localhost:8080/placement-event/" + id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(SendResponse.class).block();
	
			System.out.println(details.getData());
		}
		catch(Exception e) {
			logger.error("Error while retreiving profile details");
			throw e;
		}
		logger.info("Successfully received profile details");
		return details;
	}
	
	
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String getMessage() {
		logger.info("Displayed message successfully");
		return "Hello World";
	}
	
	@RequestMapping(value = "college/{collegeId}", method = RequestMethod.GET)
	public SendResponse studentPlacementDetails(@PathVariable("collegeId") String collegeId) throws Exception {
		logger.info("Parallelizing the two APIs");
		Mono<SendResponse> placementDetails = parallelService.getPlacementDetails(collegeId).subscribeOn(Schedulers.elastic());
		Mono<ResponseEntity<List<StudentPersonalDetailsDto>>> studentDetails = parallelService.getStudentDetails(collegeId).subscribeOn(Schedulers.elastic());
		Object[] ob = new Object[2];
		
		try {
			StudentPlacement studentPlacement = Mono.zip(placementDetails, studentDetails, StudentPlacement::new).block();
			ob[0] = studentPlacement.response();
			ob[1] = studentPlacement.student().getBody();
			response.setData("response", ob);
			
		} catch(Exception e) {
			logger.error("Error occurred while sending response", e);
			e.printStackTrace();
		}
		return response;
		}

	
}
