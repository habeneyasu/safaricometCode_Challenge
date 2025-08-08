package com.safaricom.corebank.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterviewResultRequest {

    private String candidateName;
    private BigDecimal candidateScore;
    private boolean isSuccessful;

}
