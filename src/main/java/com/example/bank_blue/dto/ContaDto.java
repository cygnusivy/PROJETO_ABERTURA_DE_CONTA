package com.example.bank_blue.dto;

import com.example.bank_blue.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ContaDto {

    @NotBlank
    private Integer id;
    @NotBlank
    private String numeroConta;
    @NotBlank
    private String numeroAgencia;
    @NotBlank
    private Integer titular_id;
    @NotBlank
    private BigDecimal saldo;
    @NotBlank
    private String codigoTipoConta;
}