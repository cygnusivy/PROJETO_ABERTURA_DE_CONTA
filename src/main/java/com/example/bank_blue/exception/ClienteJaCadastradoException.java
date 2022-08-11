package com.example.bank_blue.exception;

public class ClienteJaCadastradoException extends RuntimeException {

    public ClienteJaCadastradoException(){
        super("Cliente já cadastrado, insira um CPF/CNPJ válidos");
    }
}
