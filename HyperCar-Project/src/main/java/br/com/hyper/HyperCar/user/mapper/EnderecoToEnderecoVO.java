package br.com.hyper.HyperCar.user.mapper;

import br.com.hyper.HyperCar.configuration.DefaultResponseMapperConfig;
import br.com.hyper.HyperCar.data.model.entity.Endereco;
import br.com.hyper.HyperCar.data.vo.EnderecoVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", config = DefaultResponseMapperConfig.class)
public interface EnderecoToEnderecoVO {
    EnderecoVO map (Endereco endereco);
    List<EnderecoVO> mapList (List<Endereco> listEndereco);
}
