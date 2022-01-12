package br.com.hyper.HyperCar.service;

import br.com.hyper.HyperCar.Entity.Carro;

import java.util.List;

public interface ICarroService {

    List<Carro> trazerTodosCarros();
    Carro buscarCarro(Integer id);
    void salvarCarro(Carro car);
    void editarCarro(Carro car, Integer id);
    void deletarCarro(Integer id);
}
