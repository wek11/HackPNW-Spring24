package com.guumibears.guumibearsPNW.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.guumibears.guumibearsPNW.domain.Term;
import com.guumibears.guumibearsPNW.domain.dto.TermDto;
import com.guumibears.guumibearsPNW.mappers.Mapper;

@Component
public class TermMapperimpl implements Mapper<Term, TermDto> {
    private ModelMapper modelMapper;
    public TermMapperimpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public TermDto mapTo(Term term){
        return modelMapper.map(term, TermDto.class);
    }

    public Term mapFrom(TermDto termDto){
       return modelMapper.map(termDto, Term.class);
    }
    
}
