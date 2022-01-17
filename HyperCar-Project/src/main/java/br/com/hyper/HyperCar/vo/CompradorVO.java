package br.com.hyper.HyperCar.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CompradorVO {

    private String cpf;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private Integer sobrenome;

    @NotNull
    @NotBlank
    private String enderecoFk;

    @NotNull
    @NotBlank
    private LocalDate dataNascimento;

    @NotNull
    @NotBlank
    private Boolean ativo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(Integer sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEnderecoFk() {
        return enderecoFk;
    }

    public void setEnderecoFk(String enderecoFk) {
        this.enderecoFk = enderecoFk;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
