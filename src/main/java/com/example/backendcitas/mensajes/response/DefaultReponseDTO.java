package com.example.backendcitas.mensajes.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultReponseDTO implements Serializable {

    private final static long serialVersionUID = 1L;

    private String code;

    private String message;

    private Object data;
}
