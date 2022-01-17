package br.com.hyper.HyperCar.service.Endereco;

import br.com.hyper.HyperCar.Entity.Carro;
import br.com.hyper.HyperCar.Entity.Endereco;
import br.com.hyper.HyperCar.vo.EnderecoVO;

import java.util.List;

public interface IEnderecoService {

    List<EnderecoVO> trazerTodosEnderecos();
    EnderecoVO buscarEndereco(Integer id);
    EnderecoVO salvarEndereco(EnderecoVO endereco);
    EnderecoVO editarEndereco(EnderecoVO endereco, Integer id);
    void deletarEndereco(Integer id);

}
