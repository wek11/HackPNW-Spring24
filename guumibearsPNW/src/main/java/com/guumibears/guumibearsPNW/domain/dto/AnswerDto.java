package com.guumibears.guumibearsPNW.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerDto{
    private Long id;
    private Long term_id;
    private String text;
}