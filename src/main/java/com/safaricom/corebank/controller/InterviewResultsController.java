package com.safaricom.corebank.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safaricom.corebank.dto.InterviewResultRequest;
import com.safaricom.corebank.model.InterviewResults;
import com.safaricom.corebank.repository.InterviewResultsRepository;
import com.safaricom.corebank.service.InterviewResultsService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/interview-results")
@RequiredArgsConstructor
public class InterviewResultsController {

    private final InterviewResultsService interviewResultsService;
    private final InterviewResultsRepository interviewResultsRepository;


     /**
     * Create a new interview result.
     * @param interviewResultDto
     * @return
     */

    @PostMapping("/createInterviewResults")
    public ResponseEntity<InterviewResultRequest> createInterviewResult(@Valid @RequestBody InterviewResultRequest interviewResultRequest) {

        InterviewResultRequest createdInterviewResult = interviewResultsService.createInterviewResult(interviewResultRequest);
        return ResponseEntity.ok(createdInterviewResult);
    }


    /**
     * Get all interview results.
     * @return
     */
    @GetMapping("/getAllInterviewResults")
    public ResponseEntity<List<InterviewResultRequest>> getAllInterviewResults() {

        List<InterviewResultRequest> interviewResults = interviewResultsService.getAllInterviewResults();
        return ResponseEntity.ok(interviewResults);
    }

    /**
     * Delete result by candate name
     */
    @DeleteMapping("/deleteResultByName")
    public ResponseEntity<Void> deleteInterviewResultByCandidateName(@RequestBody String candidateName) {
        interviewResultsService.deleteInterviewResultByCandidateName(candidateName);
        return ResponseEntity.noContent().build();
    }


    /*
     * Update candidate score by candidate name
     */
    @PutMapping("/updateCandidateScore")
    public ResponseEntity<InterviewResultRequest> updateInterviewResult(@Valid @RequestBody InterviewResultRequest interviewResultRequest) {
        InterviewResultRequest updatedInterviewResult = interviewResultsService.updateInterviewResult(interviewResultRequest);
        return ResponseEntity.ok(updatedInterviewResult);
    }

    /**
     * Get candiate by name
     */
    public ResponseEntity<InterviewResults> getInterviewResultByCandidateName(@RequestBody String candidateName) {
        InterviewResults interviewResult = interviewResultsRepository.findByCandidateName(candidateName);
        return ResponseEntity.ok(interviewResult);
    }


     /*
     * Find all successful candidates only
     */
    public List<InterviewResultRequest> findByIsSuccessfulCandidates(){
        return interviewResultsService.findByIsSuccessfulCandidates();
    }
}
