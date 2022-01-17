package br.com.hyper.HyperCar.service.Comprador;

import br.com.hyper.HyperCar.Entity.Carro;
import br.com.hyper.HyperCar.Entity.Comprador;
import br.com.hyper.HyperCar.vo.CompradorVO;

import java.util.List;

public interface ICompradorService {

    List<CompradorVO> trazerTodosCompradores();
    CompradorVO buscarComprador(Integer id);
    CompradorVO salvarComprador(CompradorVO comprador);
    CompradorVO editarComprador(CompradorVO comprador, Integer id);
    void deletarComprador(Integer id);
}
