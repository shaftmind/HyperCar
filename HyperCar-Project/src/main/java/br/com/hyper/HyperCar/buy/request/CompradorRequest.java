package br.com.hyper.HyperCar.buy.request;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


public class CompradorRequest {

    @NotEmpty
    private String cpf;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sobrenome;

    @NotEmpty
    private String enderecoFk;

    private LocalDate dataNascimento;

    private Boolean ativo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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
