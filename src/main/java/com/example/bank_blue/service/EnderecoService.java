package com.example.bank_blue.service;

import com.example.bank_blue.exception.EnderecoNaoEncontradoExcepion;
import com.example.bank_blue.model.Endereco;
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

    public Endereco salvarEndereco(Endereco endereco){
        LOGGER.info("Início do método salvar - Endereco");
            this.enderecoRepository.save(endereco);
            LOGGER.info("Endereco salvo com sucesso");
        return endereco;
    }

    public Endereco selecionarEndereco(Integer id) {
        LOGGER.info("Selecionando Endereco pelo ID {}", id);
        return this.enderecoRepository.findEnderecoById(id).orElseThrow(EnderecoNaoEncontradoExcepion::new);
    }

    public List<Endereco> listarEndereco(){
        return this.enderecoRepository.findAll();
    }

    public Endereco atualizarEndereco(Integer id, Endereco enderecoRequest){
        LOGGER.info("Atualizando endereco pelo ID {}", id);
        var endereco = this.selecionarEndereco(id);
        endereco.setCep(enderecoRequest.getCep());
        endereco.setNumero(enderecoRequest.getNumero());
        endereco.setComplemento(enderecoRequest.getComplemento());
        this.enderecoRepository.save(endereco);
        LOGGER.info("Endereço atualizado com sucesso");
        return endereco;
    }

    public Endereco deletarEndereco(Integer id){
        LOGGER.info("Início do método deletar Endereço");
        var endereco = selecionarEndereco(id);
        this.enderecoRepository.delete(endereco);
        LOGGER.info("Endereco deletado com sucesso");
        return endereco;
    }
}