package com.example.bank_blue.exception;

public class ClienteJaPossuiContaCadastradaException extends RuntimeException {

    public ClienteJaPossuiContaCadastradaException(){
        super("Cliente já possui conta cadastrada");
    }
}