package com.example.bank_blue.dto;

import com.example.bank_blue.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@AllArgsConstructor
public class ClienteDto {

    @NotBlank
    private Integer id;
    @NotBlank
    private String titular;
    @Column
    private Date dataNascimento;
    @NotBlank
    private String cpfCnpj;
    @NotBlank
    private char codigoTipoCliente;
    @NotBlank
    private Integer endereco_id;
}