package com.example.bank_blue.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class InformacoesDemograficasDto {

    @NotBlank
    private Integer id;

    @Column
    private String genero;

    @Column
    private String corRaca;

    @Column
    private String estadoCivil;

    @Column
    private String formacao;
}
