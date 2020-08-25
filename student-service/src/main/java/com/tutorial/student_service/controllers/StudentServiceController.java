package com.tutorial.student_service.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.tutorial.student_service.filter.ParallelService;
import com.tutorial.student_service.models.PlacementDetails;
import com.tutorial.student_service.models.PlacementEventDetails;
import com.tutorial.student_service.models.Result;
import com.tutorial.student_service.models.SendResponse;
import com.tutorial.student_service.models.StudentRequestPlacementEventDto;
import com.tutorial.student_service.models.StudentSgpaDto;
import com.tutorial.student_service.models.UserCredentials;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.val;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/student")
public class StudentServiceController<R> {
	
	@Autowired
	private WebClient.Builder builder;
	
	@Autowired
	private ParallelService parallelService;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceController.class);

	private static final Mono StudentSgpaDto = null;
	
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
	
	@RequestMapping(value = "eligibility", method = RequestMethod.POST)
	public SendResponse checkEligibility(@RequestParam("usn") String USN, @RequestParam("id") String collegeId, @RequestParam("status") String status) throws InterruptedException, ExecutionException {

//		Mono<SendResponse> response = parallelService.aaa(collegeId);
		Mono<StudentSgpaDto> cgpa = parallelService.getCGPA(USN);
//		Flux.merge(response, cgpa).subscribe(System.out::println);
		
//		Object data = Mono.zip(response, cgpa).map(tuple -> {
//            res.setRes(tuple.getT1());
//    		res.setCGPA(tuple.getT2());
//    		return res;
//        }).block();
		
		StudentRequestPlacementEventDto deets = new StudentRequestPlacementEventDto();
		deets.setStudentCgpa(cgpa.block().getStudentCGPA());
		deets.setCollegeId(collegeId);
		deets.setPlacementEventStatus(status);
		SendResponse stu = builder.build().post().uri("http://localhost:8080/all/student").body(BodyInserters.fromObject(deets)).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(SendResponse.class).block();
		
		return stu;
		
		}

	
}
