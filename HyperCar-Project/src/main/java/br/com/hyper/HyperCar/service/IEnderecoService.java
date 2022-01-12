package br.com.hyper.HyperCar.service;

import br.com.hyper.HyperCar.Entity.Carro;
import br.com.hyper.HyperCar.Entity.Endereco;

import java.util.List;

public interface IEnderecoService {

    List<Endereco> trazerTodosEnderecos();
    Endereco buscarEndereco(Integer id);
    void salvarEndereco(Endereco endereco);
    void editarEndereco(Endereco endereco, Integer id);
    void deletarEndereco(Integer id);

}
