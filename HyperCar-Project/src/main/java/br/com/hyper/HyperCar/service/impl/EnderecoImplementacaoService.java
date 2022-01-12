package br.com.hyper.HyperCar.service.impl;

import br.com.hyper.HyperCar.Entity.Carro;
import br.com.hyper.HyperCar.Entity.Endereco;
import br.com.hyper.HyperCar.Repository.CarroRepository;
import br.com.hyper.HyperCar.Repository.EnderecoRepository;
import br.com.hyper.HyperCar.service.IEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoImplementacaoService implements IEnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public List<Endereco> trazerTodosEnderecos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco buscarEndereco(Integer id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isPresent()){
            return endereco.get();

        }
        return null;
    }

    @Override
    public void salvarEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    @Override
    public void editarEndereco(Endereco endereco, Integer id) {
        Optional<Endereco> enderecoAtualizar = enderecoRepository.findById(id);
        if (enderecoAtualizar.isPresent()){
            Endereco enderecoAtualizado = enderecoAtualizar.get();
            enderecoAtualizado.setAtivo(true);
            enderecoAtualizado.setBairro(endereco.getBairro());
            enderecoAtualizado.setCep(endereco.getCep());
            enderecoAtualizado.setCidade(endereco.getCidade());
            enderecoAtualizado.setEstado(endereco.getEstado());
            enderecoAtualizado.setRua(endereco.getRua());
            enderecoAtualizado.setNumero(endereco.getNumero());
            enderecoRepository.save(enderecoAtualizado);
        }
    }

    @Override
    public void deletarEndereco(Integer id) {
        Optional<Endereco> enderecoASerDeletado = enderecoRepository.findById(id);
        if (enderecoASerDeletado.isPresent()){
            Endereco enderecoDeletado = enderecoASerDeletado.get();
            enderecoDeletado.setAtivo(false);
            enderecoRepository.save(enderecoDeletado);
        }
    }
}
