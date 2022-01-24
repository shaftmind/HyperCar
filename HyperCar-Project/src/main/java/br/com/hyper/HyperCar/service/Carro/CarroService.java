package br.com.hyper.HyperCar.service.Carro;

import br.com.hyper.HyperCar.car.request.CarroRequest;
import br.com.hyper.HyperCar.data.model.entity.Carro;
import br.com.hyper.HyperCar.data.model.repository.CarroRepository;
import br.com.hyper.HyperCar.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  CarroService implements ICarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Override
    public List<Carro> trazerTodosCarros() {
        return carroRepository.findByAtivo(true);
    }

    @Override
    public Optional<Carro> buscarCarro(Integer id) {
        return carroRepository.findByIdAndAtivo(id, true);

    }

    @Override
    public Carro salvarCarro(CarroRequest car) {
        Carro carroEntity = new Carro();
        return carroRepository.save(setarInformacoesCarro(car, carroEntity));
    }
    public Carro setarInformacoesCarro(CarroRequest request, Carro car){
        car.setAtivo(car.getAtivo());
        car.setAno(car.getAno());
        car.setCor(car.getCor());
        car.setEstado(car.getEstado());
        car.setFabricante(car.getFabricante());
        car.setModelo(car.getModelo());
        car.setPlaca(car.getPlaca());
        car.setPreco(car.getPreco());
        return car;
    }
    @Override
    public Carro editarCarro(CarroRequest car, Integer id) {
        Optional<Carro> carro = carroRepository.findById(id);
        if (!carro.isPresent()){
            return null;
        }
        else {
            Carro carroEntity = new Carro();
            return carroRepository.save(setarInformacoesCarro(car, carroEntity));
        }
    }

    @Override
    public void deletarCarro(Integer id) {
        Carro entity = carroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID"));

        entity.setAtivo(false);
        carroRepository.save(entity);
    }
}
