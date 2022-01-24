package br.com.hyper.HyperCar.user.request;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class EnderecoRequest {

    @NotEmpty
    private String rua;

    @NotEmpty
    @Positive
    private Integer numero;

    @NotEmpty
    private String bairro;

    @NotEmpty
    private String cidade;

    @NotEmpty
    private String estado;

    @NotEmpty
    private String cep;

    @NotEmpty
    private Boolean ativo;

    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
