package com.meli.futebol.controller;

public class ExeptionPersonalizada extends RuntimeException{

    private int status;

    public ExeptionPersonalizada(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
