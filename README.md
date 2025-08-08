# Interview Results API

Simple API to manage candidate interview results

## Endpoints 

###  Create Result
`POST /api/v1/interview-results/createInterviewResults`  
 Submit a new interview result  
 Validates score (0-100) and required fields  

###  Get All Results 
`GET /api/v1/interview-results/getAllInterviewResults`  
 Returns all candidate results  

### 🔍 Find Candidate  by name
`GET /api/v1/interview-results/getInterviewResultByCandidateName`  

### 🎯 Successful Candidates  
`GET /api/v1/interview-results/findByIsSuccessfulCandidates`  
🏆 Returns only candidates who passed (isSuccessful=true)  

### ✏️ Update Score  
`PUT /api/v1/interview-results/updateCandidateScore`  
📈 Modify a candidate's score  

### 🗑️ Delete Result  
`DELETE /api/v1/interview-results/deleteResultByName`  
❌ Remove result by candidate name  


```json
{
  "candidateName": "Jane Doe",
  "candidateScore": 85.5,
  "isSuccessful": true
}


To get all interview results with succssful 
select * from interview_results where is_successful = true

To insert into the interview_results
 insert into interview_results (candidate_name, candidate_score, successful)
    values (?, ?, ?, );
