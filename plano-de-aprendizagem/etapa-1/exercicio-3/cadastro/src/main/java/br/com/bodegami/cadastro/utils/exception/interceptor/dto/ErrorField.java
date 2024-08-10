package br.com.bodegami.cadastro.utils.exception.interceptor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorField {

    private String field;
    private String error;

}
