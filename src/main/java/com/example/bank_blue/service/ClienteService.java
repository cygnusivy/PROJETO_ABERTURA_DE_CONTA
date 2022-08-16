package com.example.bank_blue.service;

import com.example.bank_blue.exception.ClienteJaCadastradoException;
import com.example.bank_blue.exception.ClienteNaoEncontradoException;
import com.example.bank_blue.model.Cliente;
import com.example.bank_blue.repository.ClienteRepository;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final Logger LOGGER = LoggerFactory.getLogger(EnderecoService.class);
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
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

    public Cliente selecionarClientePeloId(Integer id){
        LOGGER.info("Selecionando cliente pelo ID {}", id);
        return this.clienteRepository.findClienteById(id).orElseThrow(ClienteNaoEncontradoException::new);
    }

    public List<Cliente> clienteList(){
        LOGGER.info("Listando todos os clientes");
        return this.clienteRepository.findAll();
    }

    public Cliente atualizarClientePeloId(Integer id, Cliente clienteRequest){
        LOGGER.info("Início do método atualizar Cliente");
        var cliente = this.selecionarClientePeloId(id);
        cliente.setTitular(clienteRequest.getTitular());
        cliente.setDataNascimento(clienteRequest.getDataNascimento());
        cliente.setEndereco(cliente.getEndereco());
        this.clienteRepository.save(cliente);
        LOGGER.info("Cliente {} alterado com sucesso", cliente.getTitular());
        return cliente;
    }

    public Cliente deletarClientePeloId(Integer id){
        LOGGER.info("Início do método deletar Cliente");
        var cliente = this.selecionarClientePeloId(id);
        this.clienteRepository.delete(cliente);
        LOGGER.info("Cliente deletado com sucesso");
        return cliente;
    }
}