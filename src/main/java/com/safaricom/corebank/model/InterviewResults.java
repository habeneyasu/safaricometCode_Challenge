package com.safaricom.corebank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "interview_results")
@Getter
@Setter
public class InterviewResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "candidate_name", unique = true, length = 50)
    private String candidateName;

    @Column(name = "candidate_score", precision = 5, scale = 2)
    private BigDecimal candidateScore;


    // @NotNull
    // @DecimalMin("0.00") @DecimalMax("100.00")
    // @Column(name = "candidate_score", precision = 5, scale = 2)
    // private double candidateScore;

    @Column(name = "is_successful", columnDefinition = "boolean default false")
    private boolean isSuccessful;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    
}
