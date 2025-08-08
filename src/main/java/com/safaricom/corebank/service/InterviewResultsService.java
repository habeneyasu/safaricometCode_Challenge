package com.safaricom.corebank.service;

import java.util.List;

import com.safaricom.corebank.dto.InterviewResultRequest;
import com.safaricom.corebank.model.InterviewResults;

public interface InterviewResultsService {

    
    /**
     * Create a new interview result.
     * @param interviewResultDto
     * @return
     */

    InterviewResultRequest createInterviewResult(InterviewResultRequest interviewResultRequest);

       
   /*
    * Get all interview results.
    * @return
    */
    List<InterviewResultRequest> getAllInterviewResults();

    /**
     * Delete interview result by candidate name
     * @param candidateName
     */
    void deleteInterviewResultByCandidateName(String candidateName);


    /*
     * Update interview result by candidate name
     */
    InterviewResultRequest updateInterviewResult(InterviewResultRequest interviewResultRequest);


     /*
     * Find all successful candidates only
     */
    List<InterviewResultRequest> findByIsSuccessfulTrue();



    



}
