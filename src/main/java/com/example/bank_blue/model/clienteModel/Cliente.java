package com.example.bank_blue.model.clienteModel;

import com.example.bank_blue.model.endereco.Endereco;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TITULAR")
    @NotBlank(message = "Campo titular não pode ser nulo")
    private String titular;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @Column(name = "CPF_CNPJ")
    @NotBlank(message = "Campo cpf_cnpj não pode ser nulo")
    @Length(max = 18, message = "Quantidade máxima de caracteres exedida")
    private String cpfCnpj;

    @Column(name = "CODIGO_TIPO_CLIENTE")
    private CodigoTipoCliente codigoTipoCliente;

    @JoinColumn(name = "ENDERECO_ID", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Cliente(String titular, String cpfCnpj, Endereco endereco, CodigoTipoCliente codigoTipoCliente) {
        this.titular = titular;
        this.cpfCnpj = cpfCnpj;
        this.codigoTipoCliente = codigoTipoCliente;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "===== Cliente =====" + "\n\r" +
                "ID: " + id + "\n\r" +
                "TITULAR: " + titular + "\n\r" +
                "DATA DE NASCIMENTO" + dataNascimento +"\n\r" +
                "CPF/CNPJ" + cpfCnpj + "\n\r" +
                "TIPO DE CLIENTE" + codigoTipoCliente +"\n\r" +
                "ENDEREÇO" + endereco.getRua() + ", " + endereco.getNumero() + ". " + endereco.getBairro() + "," + endereco.getCidade() + " - " + endereco.getUf();
    }
}