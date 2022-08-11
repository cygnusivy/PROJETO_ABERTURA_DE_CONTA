package com.example.bank_blue.service;

import com.example.bank_blue.exception.ClienteJaCadastradoException;
import com.example.bank_blue.exception.ClienteNaoEncontradoException;
import com.example.bank_blue.model.clienteModel.Cliente;
import com.example.bank_blue.repository.ClienteRepository;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class ClienteService {

    private final Logger LOGGER = LoggerFactory.getLogger(EnderecoService.class);
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente selecionarClientePeloId(long id){
        LOGGER.info("Selecionando cliente pelo ID {}", id);
        return this.clienteRepository.findClienteById(id).orElseThrow(ClienteNaoEncontradoException::new);
    }
    public Cliente selecionarClientePeloCpfCnpj(String cpfCnpj){
        LOGGER.info("Selecionando cliente pelo CPF/CNPJ {}", cpfCnpj);
        return this.clienteRepository.findClienteByCpfCnpj(cpfCnpj).orElseThrow(ClienteNaoEncontradoException::new);
    }

    public List<Cliente> clienteList(){
        LOGGER.info("Listando todos os clientes");
        return this.clienteRepository.findAll();
    }

    public Cliente salvarCliente(Cliente cliente){
        LOGGER.info("Início do método salvar Cliente");
        if(!this.clienteRepository.existsByCpfCnpj(cliente.getCpfCnpj())){
            this.clienteRepository.save(cliente);
            LOGGER.info("Cliente {} salvo com sucesso", cliente.getTitular());
        }else{
            throw new ClienteJaCadastradoException();
        }
        return cliente;
    }

    public Cliente atualizarClientePfPeloCpfCnpj(long id, Cliente clienteRequest){
        LOGGER.info("Início do método atualizar Cliente");
        var cliente = this.selecionarClientePeloCpfCnpj(clienteRequest.getCpfCnpj());
        cliente.setTitular(clienteRequest.getTitular());
        cliente.setDataNascimento(clienteRequest.getDataNascimento());
        this.clienteRepository.save(cliente);
        LOGGER.info("Cliente {} alterado com sucesso", cliente.getTitular());
        return cliente;
    }

    public Cliente deletarClientePeloCpfCnpj(String cpfCnpj){
        LOGGER.info("Início do método deletar Cliente");
        var cliente = this.selecionarClientePeloCpfCnpj(cpfCnpj);
        this.clienteRepository.delete(cliente);
        LOGGER.info("Cliente deletado com sucesso");
        return cliente;
    }
}
