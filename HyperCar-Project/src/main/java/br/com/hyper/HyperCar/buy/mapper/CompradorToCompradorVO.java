package br.com.hyper.HyperCar.buy.mapper;

import br.com.hyper.HyperCar.configuration.DefaultResponseMapperConfig;
import br.com.hyper.HyperCar.data.model.entity.Comprador;
import br.com.hyper.HyperCar.data.vo.CompradorVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", config = DefaultResponseMapperConfig.class)
public interface CompradorToCompradorVO {

//    @Mapping(source = "nomeComprador", target = "comprador.nome") // mapeando campos com nome diferente
//    @Mapping(target = "nomeComprador", source = "comprador.nome", ignore = true) // caso queira ignorar o nome do comprador
    CompradorVO map(Comprador comprador);
}
