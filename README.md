To get all interview results with succssful 
select * from interview_results where is_successful = true

To insert into the interview_results
 insert into interview_results (candidate_name, candidate_score, successful)
    values (?, ?, ?, );
