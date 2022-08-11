package com.example.bank_blue.service;

import com.example.bank_blue.exception.ClienteJaPossuiContaCadastradaException;
import com.example.bank_blue.exception.ContaNaoEncontradaExcepion;
import com.example.bank_blue.model.contaModel.Conta;
import com.example.bank_blue.repository.ClienteRepository;
import com.example.bank_blue.repository.ContaRepository;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(ContaService.class);

    public ContaService(ContaRepository contaRepository, ClienteRepository clienteRepository) {
        this.contaRepository = contaRepository;
        this.clienteRepository = clienteRepository;
    }

    public Conta selecionarConta(long id){
        LOGGER.info("Selecionando Conta pelo ID {}", id);
        return this.contaRepository.findContaById(id).orElseThrow(ContaNaoEncontradaExcepion::new);
    }

    public Conta selecionarContaByNumeroDaConta(String numeroConta){
        LOGGER.info("Selecionando Conta pelo numeroDaConta{}", numeroConta);
        return this.contaRepository.findContaByNumeroConta(numeroConta).orElseThrow(ContaNaoEncontradaExcepion::new);
    }

    public List<Conta> listarContas(){
        return this.contaRepository.findAll();
    }

    public Conta salvarConta(Conta conta){
        LOGGER.info("Início do método salvar - Conta");
        if(!this.contaRepository.existsById(conta.getId())){
            this.contaRepository.save(conta);
            LOGGER.info("Professor salvo com sucesso");
        }else{
            throw new ClienteJaPossuiContaCadastradaException();
        }

        return conta;
    }

    public Conta atualizarConta(String numero, Conta contaRequest){
        LOGGER.info("Início do método atualizar Conta");
        var conta = this.selecionarContaByNumeroDaConta(numero);
        conta.setTitular(contaRequest.getTitular());
        this.salvarConta(conta);
        LOGGER.info("Conta atualizada com sucesso");
        return conta;
    }

    public Conta deletarConta(long id){
        LOGGER.info("Início do metodo deletar Conta");
        var conta = this.selecionarConta(id);
        this.contaRepository.delete(conta);
        LOGGER.info("Conta deletada com sucesso");
        return conta;
    }
}