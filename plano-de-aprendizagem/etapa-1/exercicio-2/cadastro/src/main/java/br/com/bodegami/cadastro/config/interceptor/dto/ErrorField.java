package br.com.bodegami.cadastro.config.interceptor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorField {

    private String field;
    private String error;

}
