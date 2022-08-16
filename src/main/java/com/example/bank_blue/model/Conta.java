package com.example.bank_blue.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CONTA")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Column(name = "NUMERO_CONTA")
    @NotBlank(message = "Campo numeroConta não pode ser nulo")
    private String numeroConta;

    @Setter
    @Column(name = "NUMERO_AGENCIA")
    @NotBlank(message = "Campo numeroAgencia não pode ser nulo")
    private String numeroAgencia;

    @Setter
    @JoinColumn(name = "TITULAR_ID", nullable = false)
    @OneToOne
    private Cliente titular;

    @Column(name = "SALDO_CONTA")
    private BigDecimal saldo;

    @Setter
    @Column(name = "CODIGO_TIPO_DE_CONTA")
    @NotBlank(message = "Campo codigoTipoConta não pode ser nulo")
    private String codigoTipoConta;

    public Conta(Cliente titular, String codigoTipoConta){
        this.titular = titular;
        this.codigoTipoConta = codigoTipoConta;
    }

    public BigDecimal setSaldo(BigDecimal valorDepositado){
       return this.saldo.add(valorDepositado);
    }

    @Override
    public String toString(){
        return "------ Dados da Conta ------" + "\n\r" +
                "ID Conta: " + this.id + "\n\r" +
                "Cliente: " + this.titular.getTitular() + "\n\r" +
                "Número da Conta: " + this.numeroConta + "\n\r" +
                "Agência: " + this.numeroAgencia + "\n\r" +
                "Cliente: " + this.titular.getTitular() + "\n\r";
    }
}