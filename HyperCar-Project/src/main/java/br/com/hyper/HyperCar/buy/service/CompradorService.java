package br.com.hyper.HyperCar.buy.service;
import br.com.hyper.HyperCar.buy.mapper.CompradorToCompradorVO;
import br.com.hyper.HyperCar.buy.request.CompradorRequest;
import br.com.hyper.HyperCar.data.model.entity.Comprador;
import br.com.hyper.HyperCar.data.model.repository.CompradorRepository;
import br.com.hyper.HyperCar.data.vo.CompradorVO;
import br.com.hyper.HyperCar.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompradorService implements ICompradorService {

    @Autowired
    private CompradorRepository compradorRepository;

    @Autowired
    private CompradorToCompradorVO compradorMapper;

    @Override
    public Page<CompradorVO> trazerTodosCompradores(Pageable pageable) {
         return compradorRepository.findAll(pageable).map(this::toCompradorVO);
    }
    public CompradorVO toCompradorVO(Comprador comprador){
       return compradorMapper.map(comprador);
    }
    @Override
    public Optional<Comprador> buscarComprador(Integer id) {
        return compradorRepository.findByIdAndAtivo(id, true);
    }

    @Override
    public Comprador salvarComprador(CompradorRequest request) {
        Comprador comprador = new Comprador();
        return  compradorRepository.save(setarInformacoes(request, comprador));
    }

    public Comprador setarInformacoes(CompradorRequest request, Comprador comprador){
        comprador.setCpf(request.getCpf());
        comprador.setAtivo(request.getAtivo());
        comprador.setDataNascimento(request.getDataNascimento());
        comprador.setEnderecoFk(request.getEnderecoFk());
        comprador.setNome(request.getNome());
        comprador.setSobrenome(request.getSobrenome());
        return comprador;
    }

    @Override
    public Comprador editarComprador(CompradorRequest comprador, Integer id) {
        Comprador compradorAtualizado = compradorRepository.findByIdAndAtivo(id, true)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID"));
            return compradorRepository.save(setarInformacoes(comprador, compradorAtualizado));
    }

    @Override
    public void deletarComprador(Integer id) {
        Comprador compradorDeletado = compradorRepository.findByIdAndAtivo(id,true)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID"));
            compradorDeletado.setAtivo(false);
            compradorRepository.save(compradorDeletado);

    }
}
