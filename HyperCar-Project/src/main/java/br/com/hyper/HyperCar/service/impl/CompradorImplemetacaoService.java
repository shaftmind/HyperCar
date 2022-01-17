package br.com.hyper.HyperCar.service.impl;

import br.com.hyper.HyperCar.Entity.Comprador;
import br.com.hyper.HyperCar.Repository.CompradorRepository;
import br.com.hyper.HyperCar.exception.ResourceNotFoundException;
import br.com.hyper.HyperCar.service.ICompradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradorImplemetacaoService implements ICompradorService {

    @Autowired
    private CompradorRepository compradorRepository;

    @Override
    public List<Comprador> trazerTodosCompradores() {
        return compradorRepository.findAll();
    }

    @Override
    public Comprador buscarComprador(Integer id) {
        return compradorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID"));
    }

    @Override
    public void salvarComprador(Comprador car) {
        compradorRepository.save(car);
    }

    @Override
    public void editarComprador(Comprador car, Integer id) {
        Comprador compradorAtualizado = compradorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID"));

            compradorAtualizado.setAtivo(true);
            compradorAtualizado.setCpf(car.getCpf());
            compradorAtualizado.setDataNascimento(car.getDataNascimento());
            compradorAtualizado.setEnderecoFk(car.getEnderecoFk());
            compradorAtualizado.setNome(car.getNome());
            compradorAtualizado.setSobrenome(car.getSobrenome());
            compradorRepository.save(compradorAtualizado);

    }

    @Override
    public void deletarComprador(Integer id) {
        Comprador compradorDeletado = compradorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID"));

            compradorDeletado.setAtivo(false);
            compradorRepository.save(compradorDeletado);

    }
}
