package com.guumibears.guumibearsPNW.services.impl;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.guumibears.guumibearsPNW.domain.Term;
import com.guumibears.guumibearsPNW.repositories.TermRepository;
import com.guumibears.guumibearsPNW.services.TermService;

@Service
public class TermServiceimpl implements TermService{

    private TermRepository termRepository;

    public TermServiceimpl(TermRepository termRepository){
        this.termRepository = termRepository;
    }

    public Term createTerm(Term term){
        return termRepository.save(term);
        
    }

    public Term findTermById(Long id){
        return termRepository.findById(id).get();
    }

    public List<Term> findAll(){
        return StreamSupport.stream(termRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
    }
    
}
