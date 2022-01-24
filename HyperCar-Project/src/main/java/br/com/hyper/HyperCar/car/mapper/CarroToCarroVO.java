package br.com.hyper.HyperCar.car.mapper;

import br.com.hyper.HyperCar.configuration.DefaultResponseMapperConfig;
import br.com.hyper.HyperCar.data.model.entity.Carro;
import br.com.hyper.HyperCar.data.vo.CarroVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", config = DefaultResponseMapperConfig.class)
public interface CarroToCarroVO {
    CarroVO map(Carro car);
    List<CarroVO> mapList(List<Carro> listCar);
}
