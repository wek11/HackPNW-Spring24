package com.guumibears.guumibearsPNW.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "terms")
public class Term {
    @Id
    private Long id;
    //answer_id should be the same as id so the cards are linked
    private Long answer_id;
    private String text;
}
