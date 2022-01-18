package br.com.hyper.HyperCar.service.Carro;

import br.com.hyper.HyperCar.Entity.Carro;
import br.com.hyper.HyperCar.Repository.CarroRepository;
import br.com.hyper.HyperCar.converter.DozerConverter;
import br.com.hyper.HyperCar.exception.ResourceNotFoundException;
import br.com.hyper.HyperCar.service.Carro.ICarroService;
import br.com.hyper.HyperCar.vo.CarroVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  CarroService implements ICarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Override
    public List<CarroVO> trazerTodosCarros() {
        return DozerConverter.parseListObjects(carroRepository.findByAtivo(true), CarroVO.class);
    }

    @Override
    public CarroVO buscarCarro(Integer id) {
        Carro entity = carroRepository.findByIdAndAtivo(id, true)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));

    return DozerConverter.parseObject(entity, CarroVO.class);
    }

    @Override
    public CarroVO salvarCarro(CarroVO car) {
        Carro entity = DozerConverter.parseObject(car, Carro.class);
        CarroVO vo = DozerConverter.parseObject(carroRepository.save(entity), CarroVO.class);
        return vo;
    }

    @Override
    public CarroVO editarCarro(CarroVO car, Integer id) {
        Carro entity = carroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
        entity.setAno(car.getAno());
        entity.setAtivo(true);
        entity.setCor(car.getCor());
        entity.setEstado(car.getEstado());
        entity.setFabricante(car.getFabricante());
        entity.setModelo(car.getModelo());
        entity.setPlaca(car.getPlaca());
        entity.setPreco(car.getPreco());

//        CarroVO vo = DozerConverter.parseObject
//                (carroRepository.save(DozerConverter.parseObject(car, Carro.class)), CarroVO.class);

        CarroVO vo = DozerConverter.parseObject(carroRepository.save(entity), CarroVO.class);
        return vo;
    }

    @Override
    public void deletarCarro(Integer id) {
        Carro entity = carroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));

        entity.setAtivo(false);
        carroRepository.save(entity);
    }
}
