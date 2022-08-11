package com.example.bank_blue.controller;

import com.example.bank_blue.model.endereco.Endereco;
import com.example.bank_blue.service.EnderecoService;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;


    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping("/salva")
    public ResponseEntity salvaEndereco(@RequestBody Endereco endereco){
        this.enderecoService.salvarEndereco(endereco);
        return new ResponseEntity("Endereco salvo com sucesso", HttpStatus.CREATED);
    }

    @GetMapping
    public List<Endereco> enderecoList(){
        return this.enderecoService.listarEndereco();
    }
    @GetMapping("/{id}")
    public ResponseEntity selecionarProfessorById(@PathVariable("id") long idEndereco){
        Endereco endereco = this.enderecoService.selecionarEndereco(idEndereco);
        return new ResponseEntity(endereco, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarEndereco(@PathVariable("id") long idEndereco, @RequestBody Endereco endereco){
        var endereco1 = this.enderecoService.atualizarEndereco(idEndereco, endereco);
        return new ResponseEntity(endereco1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarEndereco(@PathVariable("id") long idEndereco){
        this.enderecoService.deletarEndereco(idEndereco);
        return new ResponseEntity("Endereco deletado com sucesso", HttpStatus.OK);
    }
}
