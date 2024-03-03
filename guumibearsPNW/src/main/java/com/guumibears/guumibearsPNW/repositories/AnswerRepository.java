package com.guumibears.guumibearsPNW.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guumibears.guumibearsPNW.domain.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{

    
}
