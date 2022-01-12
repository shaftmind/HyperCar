package br.com.hyper.HyperCar.service.impl;

import br.com.hyper.HyperCar.Entity.Carro;
import br.com.hyper.HyperCar.Entity.Comprador;
import br.com.hyper.HyperCar.Entity.Endereco;
import br.com.hyper.HyperCar.Repository.CarroRepository;
import br.com.hyper.HyperCar.Repository.CompradorRepository;
import br.com.hyper.HyperCar.service.ICompradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompradorImplemetacaoService implements ICompradorService {

    private CompradorRepository compradorRepository;

    @Override
    public List<Comprador> trazerTodosCompradores() {
        return compradorRepository.findAll();
    }

    @Override
    public Comprador buscarComprador(Integer id) {
        Optional<Comprador> endereco = compradorRepository.findById(id);
        if (endereco.isPresent()){
            return endereco.get();
        }
        return null;
    }

    @Override
    public void salvarComprador(Comprador car) {
        compradorRepository.save(car);
    }

    @Override
    public void editarComprador(Comprador car, Integer id) {
        Optional<Comprador> compradorAtualizar = compradorRepository.findById(id);
        if(compradorAtualizar.isPresent()){
            Comprador compradorAtualizado = compradorAtualizar.get();
            compradorAtualizado.setAtivo(true);
            compradorAtualizado.setCpf(car.getCpf());
            compradorAtualizado.setDataNascimento(car.getDataNascimento());
            compradorAtualizado.setEnderecoFk(car.getEnderecoFk());
            compradorAtualizado.setNome(car.getNome());
            compradorAtualizado.setSobrenome(car.getSobrenome());
            compradorRepository.save(compradorAtualizado);
        }
    }

    @Override
    public void deletarComprador(Integer id) {
        Optional<Comprador> compradorASerDeletado = compradorRepository.findById(id);
        if (compradorASerDeletado.isPresent()){
            Comprador compradorDeletado = compradorASerDeletado.get();
            compradorDeletado.setAtivo(false);
            compradorRepository.save(compradorDeletado);
        }
    }
}
