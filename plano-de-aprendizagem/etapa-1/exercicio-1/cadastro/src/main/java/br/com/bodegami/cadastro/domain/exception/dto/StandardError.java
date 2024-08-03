package br.com.bodegami.cadastro.domain.exception.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class StandardError {

    private String timestamp;
    private int status;
    private String path;
    private String error;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ErrorField> errors;

    public StandardError() {
    }

    public StandardError(String timestamp, int status, String path, String error, List<ErrorField> errors) {
        this.timestamp = timestamp;
        this.status = status;
        this.path = path;
        this.error = error;
        this.errors = errors;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<ErrorField> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorField> errors) {
        this.errors = errors;
    }
}
