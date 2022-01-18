package br.com.hyper.HyperCar.Controller;

import br.com.hyper.HyperCar.Entity.Carro;
import br.com.hyper.HyperCar.service.Carro.ICarroService;
import br.com.hyper.HyperCar.vo.CarroVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private ICarroService service;

    @GetMapping
    public ResponseEntity getTodosCarros(){

        return ResponseEntity.status(200).body(service.trazerTodosCarros());
    }

    @GetMapping("/{id}")
    public ResponseEntity getCarro(@PathVariable int id){

        if (service.buscarCarro(id) == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(service.buscarCarro(id));
    }

    @PostMapping
    public ResponseEntity postCarro(@RequestBody CarroVO car){

        service.salvarCarro(car);
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    public ResponseEntity putCarro(@RequestBody CarroVO car){
        service.editarCarro(car, car.getId());
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarro(@PathVariable int id){

        service.deletarCarro(id);
        return ResponseEntity.status(200).build();
    }


}
