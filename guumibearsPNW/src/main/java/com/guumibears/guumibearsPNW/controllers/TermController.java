package com.guumibears.guumibearsPNW.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guumibears.guumibearsPNW.domain.Term;
import com.guumibears.guumibearsPNW.domain.dto.TermDto;
import com.guumibears.guumibearsPNW.mappers.Mapper;
import com.guumibears.guumibearsPNW.services.TermService;
@RestController
public class TermController {
    private TermService termService;
    private Mapper<Term, TermDto> termMapper;
    public TermController(TermService termService, Mapper<Term, TermDto> termMapper){
        this.termService = termService;
        this.termMapper = termMapper;
    }
    @PostMapping(path = "/terms")
    public ResponseEntity<TermDto> createTerm(@RequestBody TermDto termDto){
        Term term = termMapper.mapFrom(termDto);
        Term savedTerm = termService.createTerm(term);
        return new ResponseEntity<>(termMapper.mapTo(savedTerm), HttpStatus.CREATED);
    }

    @GetMapping(path = "/terms")
    public List<TermDto> getAllTerms(){
        List<Term> terms = termService.findAll();
        return terms.stream().map(termMapper::mapTo).collect(Collectors.toList());
    }

}
