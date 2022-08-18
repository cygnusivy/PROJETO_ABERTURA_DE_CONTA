package com.example.bank_blue.dto;

import com.example.bank_blue.model.Cliente;
import com.example.bank_blue.model.Conta;
import com.example.bank_blue.model.Endereco;
import com.example.bank_blue.model.InformacoesSociodemograficas;
import com.example.bank_blue.service.ClienteService;
import com.example.bank_blue.service.ContaService;
import com.example.bank_blue.service.EnderecoService;
import com.example.bank_blue.service.InformacoesSociodemograficasService;
import org.springframework.stereotype.Component;

@Component
public class DtoChange {

    private final EnderecoService enderecoService;
    private final ContaService contaService;
    private final ClienteService clienteService;
    private final InformacoesSociodemograficasService informacoesSociodemograficasService;

    public DtoChange(EnderecoService enderecoService, ContaService contaService, ClienteService clienteService, InformacoesSociodemograficasService informacoesSociodemograficasService) {
        this.enderecoService = enderecoService;
        this.contaService = contaService;
        this.clienteService = clienteService;
        this.informacoesSociodemograficasService = informacoesSociodemograficasService;
    }

    //Endereco
    public Endereco EnderecoDtoToEndereco(EnderecoDto enderecoDto){
        Endereco endereco = new Endereco(enderecoDto.getId(), enderecoDto.getNumero(), enderecoDto.getRua(),
                enderecoDto.getBairro(), enderecoDto.getCidade(), enderecoDto.getUf(), enderecoDto.getComplemento(), enderecoDto.getCep());
        return endereco;
    }
    public EnderecoDto EnderecoToEnderecoDto(Endereco endereco){
        EnderecoDto enderecoDto = new EnderecoDto(endereco.getId(), endereco.getNumero(), endereco.getRua(),
                endereco.getBairro(), endereco.getCidade(), endereco.getUf(), endereco.getComplemento(),
                endereco.getCep());
        return enderecoDto;
    }

    //Informacoes Sociodemograficas
    public InformacoesSociodemograficas informacoesDtoToInformacoes(InformacoesDemograficasDto informacoesDemograficasDto){
        InformacoesSociodemograficas informacoesSociodemograficas = new InformacoesSociodemograficas(informacoesDemograficasDto.getId(),
                informacoesDemograficasDto.getGenero(), informacoesDemograficasDto.getCorRaca(), informacoesDemograficasDto.getEstadoCivil(),
                informacoesDemograficasDto.getFormacao());
        return informacoesSociodemograficas;
    }

    public InformacoesDemograficasDto informacoesToInformacoesDto(InformacoesSociodemograficas informacoesSociodemograficas){
        InformacoesDemograficasDto informacoesDemograficasDtoc = new InformacoesDemograficasDto(informacoesSociodemograficas.getId(),
                informacoesSociodemograficas.getGenero(), informacoesSociodemograficas.getCorRaca(), informacoesSociodemograficas.getEstadoCivil(),
                informacoesSociodemograficas.getFormacao());
        return informacoesDemograficasDtoc;
    }
    //Cliente
    public Cliente ClienteDtoToCliente(ClienteDto clienteDto){
        Endereco endereco = this.enderecoService.selecionarEndereco(clienteDto.getEndereco_id());
        InformacoesSociodemograficas informacoesSociodemograficas = this.informacoesSociodemograficasService.selecionarPeloId(clienteDto.getInformacoes_id());
        Cliente cliente = new Cliente(clienteDto.getId(), clienteDto.getTitular(), clienteDto.getDataNascimento(),
                clienteDto.getCpfCnpj(), clienteDto.getCodigoTipoCliente(), endereco, informacoesSociodemograficas);
        return cliente;
    }

    public ClienteDto ClienteToClienteDto(Cliente cliente){
        ClienteDto clienteDto = new ClienteDto(cliente.getId(), cliente.getTitular(), cliente.getDataNascimento(),
                cliente.getCpfCnpj(), cliente.getCodigoTipoCliente(), cliente.getEndereco().getId(), cliente.getInformacoesSociodemograficas().getId());
        return clienteDto;
    }

    //Conta
    public Conta ContaDtoToConta(ContaDto contaDto){
        Cliente cliente = this.clienteService.selecionarClientePeloId(contaDto.getTitular_id());
        Conta conta = new Conta(contaDto.getId(), contaDto.getNumeroConta(), contaDto.getNumeroAgencia(), cliente,
                contaDto.getSaldo(), contaDto.getCodigoTipoConta());
        return conta;
    }

    public ContaDto ContaToContato(Conta conta){
        ContaDto contaDto = new ContaDto(conta.getId(), conta.getNumeroConta(), conta.getNumeroAgencia(),
                conta.getTitular().getId(), conta.getSaldo(), conta.getCodigoTipoConta());
        return contaDto;
    }
}