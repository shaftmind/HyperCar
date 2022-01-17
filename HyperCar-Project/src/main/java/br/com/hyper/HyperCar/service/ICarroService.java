package br.com.hyper.HyperCar.service;

import br.com.hyper.HyperCar.Entity.Carro;
import br.com.hyper.HyperCar.vo.CarroVO;

import java.util.List;

public interface ICarroService {

    List<CarroVO> trazerTodosCarros();
    CarroVO buscarCarro(Integer id);
    CarroVO salvarCarro(CarroVO car);
    CarroVO editarCarro(CarroVO car, Integer id);
    void deletarCarro(Integer id);
}
