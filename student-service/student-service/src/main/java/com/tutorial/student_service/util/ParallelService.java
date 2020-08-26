package com.tutorial.student_service.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.tutorial.student_service.controllers.StudentServiceController;
import com.tutorial.student_service.models.SendResponse;
import com.tutorial.student_service.models.StudentPersonalDetailsDto;

import reactor.core.publisher.Mono;

@Service
public class ParallelService {

	@Autowired
	private WebClient.Builder builder;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceController.class);
	
	public Mono<SendResponse> getPlacementDetails(String collegeId) {	
		logger.info("Calling placement microservice");
		Mono<SendResponse> placementDetails = null;
		
		try {
			placementDetails = builder.build().get().uri("http://localhost:8080/placement-event/all/placements/" + collegeId).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(SendResponse.class);
		} catch(Exception e) {
			logger.error("Error occurred while calling placement microservice", e);
			throw e;
		}
	
	return placementDetails;
	}
	
	public Mono<ResponseEntity<List<StudentPersonalDetailsDto>>> getStudentDetails(String collegeId) {
		logger.info("Calling student microservice");
		Mono<ResponseEntity<List<StudentPersonalDetailsDto>>> studentDetails = null;
		
		try {	
			studentDetails = builder.build().get().uri("http://localhost:8220/student/all/student/" + collegeId).accept(MediaType.APPLICATION_JSON).retrieve().toEntityList(StudentPersonalDetailsDto.class);
		} catch(Exception e) {
			logger.error("Error occurred while calling student microservice", e);
		throw e;
	}
		
		return studentDetails;
	}
}
