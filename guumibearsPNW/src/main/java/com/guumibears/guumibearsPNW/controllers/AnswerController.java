package com.guumibears.guumibearsPNW.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guumibears.guumibearsPNW.domain.Answer;
import com.guumibears.guumibearsPNW.domain.dto.AnswerDto;
import com.guumibears.guumibearsPNW.mappers.Mapper;
import com.guumibears.guumibearsPNW.services.AnswerService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class AnswerController {
    
    private AnswerService answerService; 
    private Mapper<Answer, AnswerDto> answerMapper;

    public AnswerController(AnswerService answerService, Mapper<Answer, AnswerDto> answerMapper){
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }

    @PostMapping(path = "/answers")
    public ResponseEntity<AnswerDto> createAnswer(@RequestBody AnswerDto answerDto){
        Answer answer = answerMapper.mapFrom(answerDto);
        Answer savedAnswer = answerService.createAnswer(answer);
        return new ResponseEntity<>(answerMapper.mapTo(savedAnswer), HttpStatus.CREATED);
    } 

    @GetMapping(path = "/answers")
    public List<AnswerDto> findAll(){
        List<Answer> answers = answerService.findAll();
        return answers.stream().map(answerMapper::mapTo).collect(Collectors.toList());
    }
    
}
