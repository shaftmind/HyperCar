package br.com.hyper.HyperCar.car.request;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class CarroRequest {

    @NotEmpty
    private String modelo;

    @NotEmpty
    private Integer ano;

    @NotEmpty
    @Positive
    private Double preco;

    @NotEmpty
    private String fabricante;

    @NotEmpty
    private String cor;

    @NotEmpty
    private String placa;

    @NotEmpty
    private String estado;

    @NotEmpty
    private Boolean ativo;

    public String getModelo() {
        return modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public Double getPreco() {
        return preco;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getCor() {
        return cor;
    }

    public String getPlaca() {
        return placa;
    }

    public String getEstado() {
        return estado;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
