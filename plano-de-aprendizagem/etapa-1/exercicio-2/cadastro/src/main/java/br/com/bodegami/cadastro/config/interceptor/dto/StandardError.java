package br.com.bodegami.cadastro.config.interceptor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

    private String timestamp;
    private int status;
    private String path;
    private String error;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ErrorField> errors;

}
