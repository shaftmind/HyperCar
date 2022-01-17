package br.com.hyper.HyperCar.service.impl;

import br.com.hyper.HyperCar.Entity.Comprador;
import br.com.hyper.HyperCar.Repository.CompradorRepository;
import br.com.hyper.HyperCar.converter.DozerConverter;
import br.com.hyper.HyperCar.exception.ResourceNotFoundException;
import br.com.hyper.HyperCar.service.ICompradorService;
import br.com.hyper.HyperCar.vo.CompradorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradorImplemetacaoService implements ICompradorService {

    @Autowired
    private CompradorRepository compradorRepository;

    @Override
    public List<CompradorVO> trazerTodosCompradores() {
        return DozerConverter.parseListObjects(compradorRepository.findByAtivo(true), CompradorVO.class);
    }

    @Override
    public CompradorVO buscarComprador(Integer id) {
        Comprador entity = compradorRepository.findByIdAndAtivo(id, true)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID"));

        return DozerConverter.parseObject(entity, CompradorVO.class);
    }

    @Override
    public CompradorVO salvarComprador(CompradorVO comprador) {
        Comprador entity = DozerConverter.parseObject(comprador, Comprador.class);
        compradorRepository.save(entity);
        return DozerConverter.parseObject(entity, CompradorVO.class);
    }

    @Override
    public CompradorVO editarComprador(CompradorVO comprador, Integer id) {
        Comprador compradorAtualizado = compradorRepository.findByIdAndAtivo(id, true)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID"));

            compradorAtualizado.setAtivo(true);
            compradorAtualizado.setCpf(comprador.getCpf());
            compradorAtualizado.setDataNascimento(comprador.getDataNascimento());
            compradorAtualizado.setEnderecoFk(comprador.getEnderecoFk());
            compradorAtualizado.setNome(comprador.getNome());
            compradorAtualizado.setSobrenome(comprador.getSobrenome());
            return DozerConverter.parseObject(compradorRepository.save(compradorAtualizado), CompradorVO.class);

    }

    @Override
    public void deletarComprador(Integer id) {
        Comprador compradorDeletado = compradorRepository.findByIdAndAtivo(id,true)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID"));

            compradorDeletado.setAtivo(false);
            compradorRepository.save(compradorDeletado);

    }
}
