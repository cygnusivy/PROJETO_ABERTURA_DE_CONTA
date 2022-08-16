package com.example.bank_blue.exception;

public class EnderecoNaoEncontradoExcepion extends RuntimeException{
    public EnderecoNaoEncontradoExcepion(){
        super("Endereço não encontrado, insira um ID válido");
    }
}
