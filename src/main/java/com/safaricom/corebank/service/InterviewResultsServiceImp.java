package com.safaricom.corebank.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.safaricom.corebank.dto.InterviewResultRequest;
import com.safaricom.corebank.model.InterviewResults;
import com.safaricom.corebank.repository.InterviewResultsRepository;

@Service
public class InterviewResultsServiceImp implements InterviewResultsService {

    private final InterviewResultsRepository interviewResultsRepository;

    public InterviewResultsServiceImp(InterviewResultsRepository interviewResultsRepository) {
        this.interviewResultsRepository = interviewResultsRepository;
    }

    /**
     * Create a new interview result.
     * @param interviewResultDto
     * @return
     */

    public InterviewResultRequest createInterviewResult(InterviewResultRequest interviewResultRequest) {

        InterviewResults interviewResults=new InterviewResults();

        interviewResults.setCandidateName(interviewResultRequest.getCandidateName());
        interviewResults.setCandidateScore(interviewResultRequest.getCandidateScore());
        interviewResults.setSuccessful(interviewResultRequest.isSuccessful());
        interviewResults.setCreatedAt(LocalDateTime.now());
        interviewResults.setUpdatedAt(LocalDateTime.now());

        interviewResultsRepository.save(interviewResults);

        return interviewResultRequest;
    }

    /*
    * Get all interview results.
    * @return
    */
    public List<InterviewResultRequest> getAllInterviewResults(){
        
        List<InterviewResults> interviewResultsList = interviewResultsRepository.findAll(); 
        return interviewResultsList.stream()
                .map(interviewResult -> {
                    InterviewResultRequest request = new InterviewResultRequest();
                    request.setCandidateName(interviewResult.getCandidateName());
                    request.setCandidateScore(interviewResult.getCandidateScore());
                    request.setSuccessful(interviewResult.isSuccessful());
                    return request;
                })
                .toList();
    }

      /**
     * Delete interview result by candidate name
     * @param candidateName
     */
    public void deleteInterviewResultByCandidateName(String candidateName){
        InterviewResults interviewResults = interviewResultsRepository.findByCandidateName(candidateName);
        if (interviewResults != null) {
            interviewResultsRepository.delete(interviewResults);
        }
    }


    /*
     * Update interview result by candidate name
     */
    public InterviewResultRequest updateInterviewResult(InterviewResultRequest interviewResultRequest) {
        InterviewResults interviewResults = interviewResultsRepository.findByCandidateName(interviewResultRequest.getCandidateName());
        if (interviewResults != null) {
            interviewResults.setCandidateScore(interviewResultRequest.getCandidateScore());
            interviewResults.setSuccessful(interviewResultRequest.isSuccessful());
            interviewResults.setUpdatedAt(LocalDateTime.now());
            interviewResultsRepository.save(interviewResults);
        }
        return interviewResultRequest;
    }


      /*
     * Find all successful candidates only
     */
    public List<InterviewResultRequest> findByIsSuccessfulCandidates(){
        List<InterviewResults> successfulResults = interviewResultsRepository.findByIsSuccessfulTrue();
        return successfulResults.stream()
                .map(interviewResult -> {
                    InterviewResultRequest request = new InterviewResultRequest();
                    request.setCandidateName(interviewResult.getCandidateName());
                    request.setCandidateScore(interviewResult.getCandidateScore());
                    request.setSuccessful(interviewResult.isSuccessful());
                    return request;
                })
                .toList();
    }


} 
