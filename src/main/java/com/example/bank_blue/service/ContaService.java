package com.example.bank_blue.service;

import com.example.bank_blue.exception.ContaJaCadastradaException;
import com.example.bank_blue.exception.ContaNaoEncontradaExcepion;
import com.example.bank_blue.model.Conta;
import com.example.bank_blue.repository.ContaRepository;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(ContaService.class);

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta salvarConta(Conta conta){
        LOGGER.info("Início do método salvar - Conta");
        if(!this.contaRepository.existsById(conta.getId())){
            this.contaRepository.save(conta);
            LOGGER.info("Conta salva com sucesso");
        }else{
            throw new ContaJaCadastradaException();
        }
        return conta;
    }

    public Conta selecionarConta(Integer id) {
        LOGGER.info("Selecionando Conta pelo ID {}", id);
        return this.contaRepository.findContaById(id).orElseThrow(ContaNaoEncontradaExcepion::new);
    }

    public List<Conta> listarContas(){
        return this.contaRepository.findAll();
    }

    public Conta atualizarConta(Integer id, Conta contaRequest){
        LOGGER.info("Início do método atualizar Conta");
        var conta = this.selecionarConta(id);
        conta.setTitular(contaRequest.getTitular());
        this.contaRepository.save(conta);
        LOGGER.info("Conta atualizada com sucesso");
        return conta;
    }

    public Conta deletarConta(Integer id){
        LOGGER.info("Início do metodo deletar Conta");
        var conta = selecionarConta(id);
        this.contaRepository.delete(conta);
        LOGGER.info("Conta deletada com sucesso");
        return conta;
    }
}