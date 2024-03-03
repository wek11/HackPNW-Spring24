package com.guumibears.guumibearsPNW.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.guumibears.guumibearsPNW.domain.Answer;
import com.guumibears.guumibearsPNW.domain.dto.AnswerDto;
import com.guumibears.guumibearsPNW.mappers.Mapper;

@Component
public class AnswerMapperimpl implements Mapper<Answer, AnswerDto>{
    private ModelMapper modelMapper;
    public AnswerMapperimpl (ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public AnswerDto mapTo(Answer answer){
        return modelMapper.map(answer, AnswerDto.class);
    }

    @Override
    public Answer mapFrom(AnswerDto answerDto){
        return modelMapper.map(answerDto , Answer.class);
    }
}
