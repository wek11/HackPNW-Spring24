package com.guumibears.guumibearsPNW.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TermDto {
    private Long id;
    private Long answer_id;
    private String text;
}
