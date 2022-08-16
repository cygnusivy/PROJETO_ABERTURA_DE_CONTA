package com.example.bank_blue.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NUMERO")
    //@NotBlank(message = "Campo número não pode ser nulo")
    private long numero;

    @Column(name = "RUA")
    @NotBlank(message = "Campo rua não pode ser nulo")
    private String rua;

    @Column(name = "BAIRRO")
    @NotBlank(message = "Campo bairro não pode ser nulo")
    private String bairro;

    @Column(name = "CIDADE")
    @NotBlank(message = "Campo Cidade não pode ser nulo")
    private String cidade;

    @Column(name = "UF")
    @NotBlank(message = "Campo uf não pode ser nulo")
    private String uf;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "CEP")
    @NotBlank(message = "Campo cep não pode ser nulo")
    private String cep;

    @Override
    public String toString() {
        return "===== Endereco =====" + "\n\r" +
                "ID: " + id + "\n\r" +
                "NUMERO:" + numero + "\n\r" +
                "RUA: " + rua + "\n\r" +
                "BAIRRO: " + bairro + "\n\r" +
                "CIDADE: " + cidade + "\n\r" +
                "UF: " + uf + "\n\r" +
                "COMPLEMENTO: " + complemento + "\n\r" +
                "CEP: " + cep;
    }
}
