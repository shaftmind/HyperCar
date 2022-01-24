package br.com.hyper.HyperCar.service.Endereco;

import br.com.hyper.HyperCar.data.model.entity.Endereco;
import br.com.hyper.HyperCar.data.vo.EnderecoVO;
import br.com.hyper.HyperCar.user.request.EnderecoRequest;

import java.util.List;
import java.util.Optional;

public interface IEnderecoService {

    List<Endereco> trazerTodosEnderecos();
    Optional<Endereco> buscarEndereco(Integer id);
    Endereco salvarEndereco(EnderecoRequest endereco);
    Optional<Endereco> editarEndereco(EnderecoRequest endereco, Integer id);
    Optional<Endereco> deletarEndereco(Integer id);

}
