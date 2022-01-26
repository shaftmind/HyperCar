package br.com.hyper.HyperCar.car.resource;

import br.com.hyper.HyperCar.car.mapper.CarroToCarroVO;
import br.com.hyper.HyperCar.car.request.CarroRequest;
import br.com.hyper.HyperCar.data.model.entity.Carro;
import br.com.hyper.HyperCar.exception.ResourceNoContentException;
import br.com.hyper.HyperCar.car.service.ICarroService;
import br.com.hyper.HyperCar.data.vo.CarroVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private ICarroService service;

    @Autowired
    private CarroToCarroVO carroMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CarroVO> getTodosCarros(){
        List<Carro> todosCarros = service.trazerTodosCarros();
        if (todosCarros.isEmpty()){
            throw  new ResourceNoContentException("Nenhum Carro encontrado");
        }
        return carroMapper.mapList(todosCarros);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarroVO getCarro(@PathVariable int id){
        Optional<Carro> carro = service.buscarCarro(id);
        if (!carro.isPresent()){
            throw new ResourceNoContentException("Nenhum Carro encontrado");
        }
        return carroMapper.map(carro.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarroVO postCarro(@RequestBody CarroRequest car){

        return carroMapper.map(service.salvarCarro(car));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarroVO putCarro(@RequestBody CarroRequest car, @PathVariable int id){
        Carro carAtualizado = service.editarCarro(car, id);
        if (car != null){
            return carroMapper.map(carAtualizado);
        }
        else {
            throw new ResourceNoContentException("Carro não encontrado");
        }

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarro(@PathVariable int id){
        service.deletarCarro(id);
    }


}
