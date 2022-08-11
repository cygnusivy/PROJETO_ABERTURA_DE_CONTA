package com.example.bank_blue.service;

import com.example.bank_blue.exception.ContaNaoEncontradaExcepion;
import com.example.bank_blue.model.endereco.Endereco;
import com.example.bank_blue.repository.EnderecoRepository;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(EnderecoService.class);

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco selecionarEndereco(long id) {
        LOGGER.info("Selecionando Conta pelo ID {}", id);
        return this.enderecoRepository.findEnderecoById(id).orElseThrow(ContaNaoEncontradaExcepion::new);
    }
    public List<Endereco> listarEndereco(){
        return this.enderecoRepository.findAll();
    }

    public Endereco salvarEndereco(Endereco endereco){
        LOGGER.info("Início do método salvar - Endereco");
            this.enderecoRepository.save(endereco);
            LOGGER.info("Endereco salvo com sucesso");
        return endereco;
    }

    public Endereco atualizarEndereco(long id, Endereco enderecoRequest){
        LOGGER.info("Atualizando endereco pelo ID {}", id);
        var endereco = this.selecionarEndereco(id);
        endereco.setCep(enderecoRequest.getCep());
        endereco.setNumero(enderecoRequest.getNumero());
        endereco.setComplemento(enderecoRequest.getComplemento());
        this.salvarEndereco(endereco);
        LOGGER.info("Endereço atualizado com sucesso");
        return endereco;
    }

    public Endereco deletarEndereco(long id){
        LOGGER.info("Início do método deletar Endereço");
        var endereco = selecionarEndereco(id);
        this.enderecoRepository.delete(endereco);
        LOGGER.info("Endereco deletado com sucesso");
        return endereco;
    }
}