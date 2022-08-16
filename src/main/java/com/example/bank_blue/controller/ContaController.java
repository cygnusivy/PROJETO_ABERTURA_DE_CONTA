package com.example.bank_blue.controller;

import com.example.bank_blue.dto.ContaDto;
import com.example.bank_blue.dto.DtoChange;
import com.example.bank_blue.model.Conta;
import com.example.bank_blue.service.ContaService;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/conta")
public class ContaController {

    private final ContaService contaService;
    private final DtoChange dtoChange;

    public ContaController(ContaService contaService, DtoChange dtoChange) {
        this.contaService = contaService;
        this.dtoChange = dtoChange;
    }

    @PostMapping("/salvar")
    public ResponseEntity salvarConta(@RequestBody ContaDto contaDto){
        Conta conta = this.dtoChange.ContaDtoToConta(contaDto);
        this.contaService.salvarConta(conta);
        return new ResponseEntity("Conta salva com sucesso", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity selecionarContaPeloId(@PathVariable("id") Integer idConta){
        Conta conta = this.contaService.selecionarConta(idConta);
        ContaDto contaDto = this.dtoChange.ContaToContato(conta);
        return new ResponseEntity(contaDto, HttpStatus.OK);
    }

    @GetMapping
    public List<ContaDto> contaList(){
        List<ContaDto> contaDtoList = this.contaService.listarContas().stream()
                .map(x -> this.dtoChange.ContaToContato(x))
                .collect(Collectors.toList());
        return  contaDtoList;
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarConta(@PathVariable("id") Integer idConta, @RequestBody ContaDto contaDto){
        Conta conta = this.dtoChange.ContaDtoToConta(contaDto);
        this.contaService.atualizarConta(idConta, conta);
        return new ResponseEntity(conta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarConta(@PathVariable("id") Integer idConta){
        this.contaService.deletarConta(idConta);
        return new ResponseEntity("Deletando conta", HttpStatus.OK);
    }
}