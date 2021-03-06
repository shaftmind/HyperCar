package br.com.hyper.HyperCar.data.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CarroVO {


    private Integer id;

    @NotNull
    private String modelo;

    @NotNull
    private Integer ano;

    @NotNull
    @Positive
    private Double preco;

    @NotNull
    private String fabricante;

    @NotNull
    private String cor;

    @NotNull
    private String placa;

    @NotNull
    private String estado;

    @NotNull
    private Boolean ativo;


    public Integer getId() {

        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
