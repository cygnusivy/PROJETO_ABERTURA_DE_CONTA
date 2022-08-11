package com.example.bank_blue.exception;

public class ContaNaoEncontradaExcepion extends RuntimeException{
    public ContaNaoEncontradaExcepion(){
        super("Conta não encontrada, insira um ID ou número da conta válidos");
    }
}
