package br.com.hyper.HyperCar.Controller;

import br.com.hyper.HyperCar.Entity.Comprador;
import br.com.hyper.HyperCar.service.Comprador.ICompradorService;
import br.com.hyper.HyperCar.vo.CompradorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/coompradores")
public class CompradorController {

    @Autowired
    private ICompradorService service;

    @GetMapping
    public ResponseEntity getTodosCompradores(){

        return ResponseEntity.status(200).body(service.trazerTodosCompradores());
    }

    @GetMapping("/{id}")
    public ResponseEntity getComprador(@PathVariable int id){
        if(service.buscarComprador(id) == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(service.buscarComprador(id));
    }

    @PostMapping
    public ResponseEntity postComprador(@RequestBody CompradorVO comprador){

        service.salvarComprador(comprador);
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    public ResponseEntity putComprador(@RequestBody CompradorVO comprador){

        service.salvarComprador(comprador);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteComprador(@PathVariable int id){

        service.deletarComprador(id);
        return ResponseEntity.status(200).build();
    }
}
