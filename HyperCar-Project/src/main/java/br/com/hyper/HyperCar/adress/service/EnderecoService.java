package br.com.hyper.HyperCar.adress.service;

import br.com.hyper.HyperCar.data.model.entity.Endereco;
import br.com.hyper.HyperCar.data.model.repository.EnderecoRepository;
import br.com.hyper.HyperCar.adress.request.EnderecoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService implements IEnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public List<Endereco> trazerTodosEnderecos() {
        return enderecoRepository.findByAtivo(true);
    }

    @Override
    public Optional<Endereco> buscarEndereco(Integer id) {
        return enderecoRepository.findByIdAndAtivo(id, true);

    }

    @Override
    public Endereco salvarEndereco(EnderecoRequest endereco) {
        Endereco enderecoEntity = new Endereco();
        return enderecoRepository.save(setarInformacoesEndereco(endereco, enderecoEntity));
    }
    public Endereco setarInformacoesEndereco(EnderecoRequest request, Endereco enderecoEntity){
        enderecoEntity.setAtivo(request.getAtivo());
        enderecoEntity.setBairro(request.getBairro());
        enderecoEntity.setCep(request.getCep());
        enderecoEntity.setCidade(request.getCidade());
        enderecoEntity.setEstado(request.getEstado());
        enderecoEntity.setNumero(request.getNumero());
        enderecoEntity.setRua(request.getRua());
        return enderecoEntity;
    }

    @Override
    public Optional<Endereco> editarEndereco(EnderecoRequest endereco, Integer id) {
        Optional<Endereco> enderecoAtualizar = enderecoRepository.findByIdAndAtivo(id , true);
        if (!enderecoAtualizar.isPresent()){
            return null;
        }
        else {
            enderecoRepository.save(setarInformacoesEndereco(endereco, enderecoAtualizar.get()));
            return  enderecoAtualizar;
        }
    }

    @Override
    public Optional<Endereco> deletarEndereco(Integer id) {
        Optional<Endereco> enderecoExcluir = enderecoRepository.findByIdAndAtivo(id, true);
        if (!enderecoExcluir.isPresent()){
            return null;
        }
        else {
            enderecoExcluir.get().setAtivo(false);
            enderecoRepository.save(enderecoExcluir.get());
            return enderecoExcluir;
        }
    }
}
