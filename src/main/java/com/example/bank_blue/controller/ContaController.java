package com.example.bank_blue.controller;

import com.example.bank_blue.model.contaModel.Conta;
import com.example.bank_blue.model.endereco.Endereco;
import com.example.bank_blue.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping("/salvar")
    public ResponseEntity salvarConta(@RequestBody Conta conta){
        this.contaService.salvarConta(conta);
        return new ResponseEntity("Conta salva com sucesso", HttpStatus.CREATED);
    }

    @GetMapping
    public List<Conta> contaList(){
        return this.contaService.listarContas();
    }
}