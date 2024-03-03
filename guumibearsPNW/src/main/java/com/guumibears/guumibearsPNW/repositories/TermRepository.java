package com.guumibears.guumibearsPNW.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guumibears.guumibearsPNW.domain.Term;

@Repository
public interface TermRepository extends CrudRepository<Term, Long> {
    
}
