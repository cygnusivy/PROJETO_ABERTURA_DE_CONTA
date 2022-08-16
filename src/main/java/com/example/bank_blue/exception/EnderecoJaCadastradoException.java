package com.example.bank_blue.exception;

public class EnderecoJaCadastradoException extends RuntimeException {

    public EnderecoJaCadastradoException(){
        super("Endereco já cadastrado");
    }
}