package br.com.hyper.HyperCar.Controller;

import br.com.hyper.HyperCar.Entity.Comprador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/coompradores")
public class CompradorController {

    @GetMapping
    public ResponseEntity getTodosCompradores(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity getComprador(@PathVariable int id){
        return null;
    }

    @PostMapping
    public ResponseEntity postComprador(@RequestBody Comprador comprador){
        return null;
    }

    @PutMapping
    public ResponseEntity putComprador(@RequestBody Comprador comprador){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteComprador(@PathVariable int id){
        return null;
    }
}
