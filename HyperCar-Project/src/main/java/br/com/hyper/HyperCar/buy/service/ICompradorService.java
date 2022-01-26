package br.com.hyper.HyperCar.buy.service;

import br.com.hyper.HyperCar.buy.request.CompradorRequest;
import br.com.hyper.HyperCar.data.model.entity.Comprador;
import br.com.hyper.HyperCar.data.vo.CompradorVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICompradorService {

    Page<CompradorVO> trazerTodosCompradores(Pageable pageable);
    Optional<Comprador> buscarComprador(Integer id);
    Comprador salvarComprador(CompradorRequest comprador);
    Comprador editarComprador(CompradorRequest comprador, Integer id);
    void deletarComprador(Integer id);
}
