package com.meli.futebol.dto;

import lombok.Data;

@Data
public class BaseResponseDTO {
    private int status;
    private String mensagem;
    private Object data;

    public BaseResponseDTO(int status, String mensagem, Object data) {
        this.status = status;
        this.mensagem = mensagem;
        this.data = data;
    }

}