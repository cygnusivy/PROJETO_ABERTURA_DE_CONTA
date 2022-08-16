package com.example.bank_blue.controller;

import com.example.bank_blue.dto.ClienteDto;
import com.example.bank_blue.dto.DtoChange;
import com.example.bank_blue.model.Cliente;
import com.example.bank_blue.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final DtoChange dtoChange;

    public ClienteController(ClienteService clienteService, DtoChange dtoChange) {
        this.clienteService = clienteService;
        this.dtoChange = dtoChange;
    }

    @PostMapping("/salvar")
    public ResponseEntity salvarCliente(@RequestBody ClienteDto clienteDto){
        Cliente cliente = this.dtoChange.ClienteDtoToCliente(clienteDto);
        this.clienteService.salvarCliente(cliente);
        return new ResponseEntity("Cliente cadastrado com sucesso", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity selecionarClientePeloId(@PathVariable("id") Integer idCliente){
        Cliente cliente = this.clienteService.selecionarClientePeloId(idCliente);
        ClienteDto clienteDto = this.dtoChange.ClienteToClienteDto(cliente);
        return new ResponseEntity(clienteDto, HttpStatus.OK);
    }

    @GetMapping
    public List<ClienteDto> clienteList(){
        List<ClienteDto> clienteDtoLis = this.clienteService.clienteList().stream()
                .map(x -> this.dtoChange.ClienteToClienteDto(x))
                .collect(Collectors.toList());
        return clienteDtoLis;
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarCliente(@PathVariable("id") Integer idCliente, @RequestBody ClienteDto clienteDto){
        Cliente cliente = this.dtoChange.ClienteDtoToCliente(clienteDto);
        this.clienteService.atualizarClientePeloId(idCliente, cliente);
        return new ResponseEntity(cliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarClientePeloId(@PathVariable("id") Integer id){
        this.clienteService.deletarClientePeloId(id);
        return new ResponseEntity("Cliente deletado com sucesso", HttpStatus.OK);
    }
}