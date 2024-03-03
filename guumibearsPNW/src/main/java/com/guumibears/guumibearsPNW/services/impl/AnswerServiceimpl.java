package com.guumibears.guumibearsPNW.services.impl;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.guumibears.guumibearsPNW.domain.Answer;
import com.guumibears.guumibearsPNW.repositories.AnswerRepository;
import com.guumibears.guumibearsPNW.services.AnswerService;

@Service
public class AnswerServiceimpl implements AnswerService{

    private AnswerRepository answerRepository;

    public AnswerServiceimpl(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

    public Answer createAnswer(Answer answer){
        return answerRepository.save(answer);
        
    }

    public Answer findAnswerById(Long id){
        return answerRepository.findById(id).get();
    }

    public List<Answer> findAll(){
        return StreamSupport.stream(answerRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
    }
    
}
