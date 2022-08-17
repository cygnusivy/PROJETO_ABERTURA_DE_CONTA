package com.example.bank_blue.service;

import com.example.bank_blue.exception.EnderecoJaCadastradoException;
import com.example.bank_blue.exception.EnderecoNaoEncontradoExcepion;
import com.example.bank_blue.model.InformacoesSociodemograficas;
import com.example.bank_blue.repository.InformacoesSociodemograficaRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InformacoesSociodemograficasService {

    private final InformacoesSociodemograficaRepository informacoesSociodemograficaRepository;


    public InformacoesSociodemograficasService(InformacoesSociodemograficaRepository informacoesSociodemograficaRepository) {
        this.informacoesSociodemograficaRepository = informacoesSociodemograficaRepository;
    }

    public InformacoesSociodemograficas salvarInformacoes(InformacoesSociodemograficas informacoesSociodemograficas){
        log.info("Inciando método salvarInformacoes");
        if(!this.informacoesSociodemograficaRepository.existsById(informacoesSociodemograficas.getId())) {
            this.informacoesSociodemograficaRepository.save(informacoesSociodemograficas);
            log.info("Salvando informações sociodemográficas");
        }else{
            throw new EnderecoJaCadastradoException();
        }
        return informacoesSociodemograficas;
    }

    public InformacoesSociodemograficas selecionarPeloId(Integer id){
        log.info("Iniciando método selecionar selecionarPeloId {}", id);
        return this.informacoesSociodemograficaRepository.findById(id).orElseThrow(EnderecoNaoEncontradoExcepion::new);
    }

    public List<InformacoesSociodemograficas> list(){
        log.info("Listando todos os registros de informações sociodemográficas");
        return this.informacoesSociodemograficaRepository.findAll();
    }

    public InformacoesSociodemograficas atualizarInformacoesPeloId(Integer id, InformacoesSociodemograficas informacoesSociodemograficasRequest){
        log.info("Inciando método atualizarInformacoesPeloId {}", id);
        var informacoes = this.selecionarPeloId(id);
        informacoes.setCorRaca(informacoesSociodemograficasRequest.getCorRaca());
        informacoes.setFormacao(informacoesSociodemograficasRequest.getFormacao());
        informacoes.setEstadoCivil(informacoesSociodemograficasRequest.getEstadoCivil());
        informacoes.setGenero(informacoesSociodemograficasRequest.getGenero());
        this.informacoesSociodemograficaRepository.save(informacoes);
        return informacoes;
    }

    public InformacoesSociodemograficas deletarInformacoesPeloId(Integer id){
        log.info("Início do método deletarInformacoesPeloId {}", id);
        var informacoes = this.selecionarPeloId(id);
        this.informacoesSociodemograficaRepository.delete(informacoes);
        log.info("Informações deletadas com sucesso para o id {}", id);
        return informacoes;
    }
}
