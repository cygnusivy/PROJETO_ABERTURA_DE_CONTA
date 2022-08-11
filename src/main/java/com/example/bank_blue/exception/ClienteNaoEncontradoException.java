package com.example.bank_blue.exception;

public class ClienteNaoEncontradoException extends RuntimeException {
    public ClienteNaoEncontradoException(){
        super ("Cliente não foi encontrado, insira um ID ou CPF?CNPJ válidos");
    }
}
