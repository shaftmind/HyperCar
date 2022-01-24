package br.com.hyper.HyperCar.data.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String cpf;


    private String nome;

    private String sobrenome;


    private String enderecoFk;


    private LocalDate dataNascimento;

    private Boolean ativo;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSobrenome() {
        return sobrenome;
    }


    public void setSobrenome(String sobrenome) {
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
