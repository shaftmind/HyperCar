package br.com.hyper.HyperCar.Controller;

import br.com.hyper.HyperCar.Entity.Endereco;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/enderecos")
public class EnderecoController {

    @GetMapping
    public ResponseEntity getTodosEnderecos(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity getEndereco(@PathVariable int id){
        return null;
    }

    @PostMapping
    public ResponseEntity postEndereco(@RequestBody Endereco endereco){
        return null;
    }

    @PutMapping
    public ResponseEntity putEndereco(@RequestBody Endereco endereco){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEndereco(@PathVariable int id){
        return null;
    }
}
