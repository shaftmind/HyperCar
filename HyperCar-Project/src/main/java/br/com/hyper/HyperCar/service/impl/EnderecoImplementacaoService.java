package br.com.hyper.HyperCar.service.impl;

import br.com.hyper.HyperCar.Entity.Carro;
import br.com.hyper.HyperCar.Entity.Endereco;
import br.com.hyper.HyperCar.Repository.CarroRepository;
import br.com.hyper.HyperCar.Repository.EnderecoRepository;
import br.com.hyper.HyperCar.converter.DozerConverter;
import br.com.hyper.HyperCar.exception.ResourceNotFoundException;
import br.com.hyper.HyperCar.service.IEnderecoService;
import br.com.hyper.HyperCar.vo.EnderecoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoImplementacaoService implements IEnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public List<EnderecoVO> trazerTodosEnderecos() {
        return DozerConverter.parseListObjects(enderecoRepository.findByAtivo(true), EnderecoVO.class);
    }

    @Override
    public EnderecoVO buscarEndereco(Integer id) {
        Endereco entity = enderecoRepository.findByIdAndAtivo(id, true).orElseThrow(() ->
                new ResourceNotFoundException("Nenhum registro encontrado para este ID"));
        return DozerConverter.parseObject(entity, EnderecoVO.class);
    }

    @Override
    public EnderecoVO salvarEndereco(EnderecoVO endereco) {
        Endereco entity = DozerConverter.parseObject(endereco, Endereco.class);
        enderecoRepository.save(entity);
        return endereco;
    }

    @Override
    public EnderecoVO editarEndereco(EnderecoVO endereco, Integer id) {
        Endereco entity = enderecoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Nenhum registro encontrado para este ID"));

        entity.setAtivo(true);
        entity.setBairro(endereco.getBairro());
        entity.setCep(endereco.getCep());
        entity.setCidade(endereco.getCidade());
        entity.setEstado(endereco.getEstado());
        entity.setRua(endereco.getRua());
        entity.setNumero(endereco.getNumero());
        return DozerConverter.parseObject(enderecoRepository.save(entity), EnderecoVO.class);

    }

    @Override
    public void deletarEndereco(Integer id) {
        Endereco entity = enderecoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Nenhum registro encontrado para este ID"));
        entity.setAtivo(false);
        enderecoRepository.save(entity);
    }
}
