package com.example.bank_blue.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TB_INF_DEMOGRAFICAS")
public class InformacoesSociodemograficas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String genero;

    @Column
    private String corRaca;

    @Column(name = "ESTADO_CIVIL")
    private String estadoCivil;

    @Column
    private String formacao;

    @Override
    public String toString() {
        return "InformacoesSociodemograficas{" +
                "id=" + id +
                ", genero='" + genero + '\'' +
                ", corRaca='" + corRaca + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", formacao='" + formacao + '\'' +
                '}';
    }
}
