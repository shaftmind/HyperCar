package br.com.hyper.HyperCar.service.impl;

import br.com.hyper.HyperCar.Entity.Carro;
import br.com.hyper.HyperCar.Repository.CarroRepository;
import br.com.hyper.HyperCar.service.ICarroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroImplementacaoService implements ICarroService {

    @Autowired
    private CarroRepository carroRepository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<Carro> trazerTodosCarros() {
        return carroRepository.findAll();
    }

    @Override
    public Carro buscarCarro(Integer id) {
        Optional<Carro> carro = carroRepository.findById(id);
        if (carro.isPresent()){
            return carro.get();

        }
        return null;
    }

    @Override
    public void salvarCarro(Carro car) {
        carroRepository.save(car);
    }

    @Override
    public void editarCarro(Carro car, Integer id) {
        Optional<Carro> carroAtualizar = carroRepository.findById(id);
        if (carroAtualizar.isPresent()){
            Carro carAtt = carroAtualizar.get();
            carAtt.setAno(car.getAno());
            carAtt.setAtivo(true);
            carAtt.setCor(car.getCor());
            carAtt.setEstado(car.getEstado());
            carAtt.setFabricante(car.getFabricante());
            carAtt.setModelo(car.getModelo());
            carAtt.setPlaca(car.getPlaca());
            carAtt.setPreco(car.getPreco());
            carroRepository.save(car);
        }
    }

    @Override
    public void deletarCarro(Integer id) {
        Optional<Carro> carroASerDeletado = carroRepository.findById(id);
        if (carroASerDeletado.isPresent()){
            Carro carroDeletado = carroASerDeletado.get();
            carroDeletado.setAtivo(false);
            carroRepository.save(carroDeletado);
        }
    }
}
