package br.com.hyper.HyperCar.car.service;

import br.com.hyper.HyperCar.car.request.CarroRequest;
import br.com.hyper.HyperCar.data.model.entity.Carro;

import java.util.List;
import java.util.Optional;

public interface ICarroService {

    List<Carro> trazerTodosCarros();
    Optional<Carro> buscarCarro(Integer id);
    Carro salvarCarro(CarroRequest car);
    Carro editarCarro(CarroRequest car, Integer id);
    void deletarCarro(Integer id);
}
