package com.example.bank_blue.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TB_INF_SDEMOGRAFICAS")
public class InformacoesSociodemograficas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String genero;

    @Column(name = "COR_RACA")
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
