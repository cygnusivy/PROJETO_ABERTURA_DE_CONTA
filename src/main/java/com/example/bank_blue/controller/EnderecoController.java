package com.example.bank_blue.controller;

import com.example.bank_blue.dto.DtoChange;
import com.example.bank_blue.dto.EnderecoDto;
import com.example.bank_blue.model.Endereco;
import com.example.bank_blue.service.EnderecoService;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;
    private final DtoChange dtoChange;

    public EnderecoController(EnderecoService enderecoService, DtoChange dtoChange) {
        this.enderecoService = enderecoService;
        this.dtoChange = dtoChange;
    }

    @PostMapping("/salvar")
    public ResponseEntity salvaEndereco(@RequestBody EnderecoDto enderecoDto){
        Endereco endereco = this.dtoChange.EnderecoDtoToEndereco(enderecoDto);
        this.enderecoService.salvarEndereco(endereco);
        return new ResponseEntity("Endereco salvo com sucesso", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity selecionarProfessorById(@PathVariable("id") Integer idEndereco){
        Endereco endereco = this.enderecoService.selecionarEndereco(idEndereco);
        EnderecoDto enderecoDto = this.dtoChange.EnderecoToEnderecoDto(endereco);
        return new ResponseEntity(enderecoDto, HttpStatus.OK);
    }

    @GetMapping
    public List<EnderecoDto> enderecoDto(){
        List<EnderecoDto> list = this.enderecoService.listarEndereco().stream()
                .map(x -> this.dtoChange.EnderecoToEnderecoDto(x))
                .collect(Collectors.toList());
        return list;
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarEndereco(@PathVariable("id") Integer idEndereco, @RequestBody EnderecoDto enderecoDto){
        Endereco endereco = this.dtoChange.EnderecoDtoToEndereco(enderecoDto);
        this.enderecoService.atualizarEndereco(idEndereco, endereco);
        return new ResponseEntity("Endereco atualizado com sucesso", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarEndereco(@PathVariable("id") Integer idEndereco){
        this.enderecoService.deletarEndereco(idEndereco);
        return new ResponseEntity("Endereco deletado com sucesso", HttpStatus.OK);
    }
}
