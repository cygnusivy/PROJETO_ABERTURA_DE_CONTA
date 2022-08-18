package com.example.bank_blue.controller;

import com.example.bank_blue.dto.DtoChange;
import com.example.bank_blue.dto.InformacoesDemograficasDto;
import com.example.bank_blue.model.InformacoesSociodemograficas;
import com.example.bank_blue.service.InformacoesSociodemograficasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("demograficas")
public class InformacoesSociodemograficasController {

    private final InformacoesSociodemograficasService informacoesSociodemograficasService;
    private final DtoChange dtoChange;

    public InformacoesSociodemograficasController(InformacoesSociodemograficasService informacoesSociodemograficasService, DtoChange dtoChange) {
        this.informacoesSociodemograficasService = informacoesSociodemograficasService;
        this.dtoChange = dtoChange;
    }

    @GetMapping
    List<InformacoesDemograficasDto> informacoesDtoList(){
        List<InformacoesDemograficasDto> list = this.informacoesSociodemograficasService.list().stream()
                .map(x -> this.dtoChange.informacoesToInformacoesDto(x))
                .collect(Collectors.toList());
        return list;
    }

    @GetMapping("/{id}")
    public ResponseEntity selecionarInformacoesPeloId(@PathVariable("id") Integer idInformacoes){
        InformacoesSociodemograficas informacoesSociodemograficas = this.informacoesSociodemograficasService.selecionarPeloId(idInformacoes);
        InformacoesDemograficasDto informacoesDemograficasDto = this.dtoChange.informacoesToInformacoesDto(informacoesSociodemograficas);
        return new ResponseEntity(informacoesDemograficasDto, HttpStatus.OK);
    }
}
