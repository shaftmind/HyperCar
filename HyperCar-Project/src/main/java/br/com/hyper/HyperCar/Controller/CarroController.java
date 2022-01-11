package br.com.hyper.HyperCar.Controller;

import br.com.hyper.HyperCar.Entity.Carro;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/carros")
public class CarroController {

    @GetMapping
    public ResponseEntity getTodosCarros(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity getCarro(@PathVariable int id){
        return null;
    }

    @PostMapping
    public ResponseEntity postCarro(@RequestBody Carro car){
        return null;
    }

    @PutMapping
    public ResponseEntity putCarro(@RequestBody Carro car){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarro(@PathVariable int id){
        return null;
    }


}
