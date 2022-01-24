package br.com.hyper.HyperCar.service.Comprador;

import br.com.hyper.HyperCar.buy.request.CompradorRequest;
import br.com.hyper.HyperCar.data.model.entity.Comprador;
import br.com.hyper.HyperCar.data.vo.CompradorVO;

import java.util.List;
import java.util.Optional;

public interface ICompradorService {

    List<Comprador> trazerTodosCompradores();
    Optional<Comprador> buscarComprador(Integer id);
    Comprador salvarComprador(CompradorRequest comprador);
    Comprador editarComprador(CompradorRequest comprador, Integer id);
    void deletarComprador(Integer id);
}
