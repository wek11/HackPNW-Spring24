package com.guumibears.guumibearsPNW.services;



import java.util.List;

import org.springframework.stereotype.Service;

import com.guumibears.guumibearsPNW.domain.Answer;

@Service
public interface AnswerService{

    public Answer createAnswer(Answer answer);

    public Answer findAnswerById(Long id);
    
    public List<Answer> findAll();
}
