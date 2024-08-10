package br.com.bodegami.cadastro.utils.exception.interceptor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseError {

    private String timestamp;
    private int status;
    private String path;
    private String error;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ErrorField> errors;

}
