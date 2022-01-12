package br.com.hyper.HyperCar.service;

import br.com.hyper.HyperCar.Entity.Carro;
import br.com.hyper.HyperCar.Entity.Comprador;

import java.util.List;

public interface ICompradorService {

    List<Comprador> trazerTodosCompradores();
    Comprador buscarComprador(Integer id);
    void salvarComprador(Comprador car);
    void editarComprador(Comprador car, Integer id);
    void deletarComprador(Integer id);
}
