package com.safaricom.corebank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safaricom.corebank.model.InterviewResults;

@Repository
public interface InterviewResultsRepository  extends JpaRepository<InterviewResults, Long> {


    /*
     * Get interview result by candidate name.
     */
    InterviewResults findByCandidateName(String candidateName);
    
    /*
     * Find all successful candidates only
     */
    List<InterviewResults> findByIsSuccessfulTrue();
}
