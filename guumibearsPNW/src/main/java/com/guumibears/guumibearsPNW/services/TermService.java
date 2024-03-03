package com.guumibears.guumibearsPNW.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guumibears.guumibearsPNW.domain.Term;
@Service
public interface TermService {
    public Term createTerm(Term term);

    public Term findTermById(Long id);

    public List<Term> findAll();
}
