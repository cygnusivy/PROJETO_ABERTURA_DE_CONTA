package com.example.bank_blue.exception;

public class ContaJaCadastradaException extends RuntimeException {

    public ContaJaCadastradaException(){
        super("Conta já cadastrada");
    }
}