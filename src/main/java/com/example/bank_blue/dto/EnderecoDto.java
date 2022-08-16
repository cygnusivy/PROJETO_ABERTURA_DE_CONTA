package com.example.bank_blue.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class EnderecoDto {

    @NotBlank
    private Integer id;
    @NotBlank
    private long numero;
    @NotBlank
    private String rua;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String uf;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cep;
}