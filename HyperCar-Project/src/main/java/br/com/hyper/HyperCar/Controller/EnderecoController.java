package br.com.hyper.HyperCar.Controller;

import br.com.hyper.HyperCar.Entity.Endereco;
import br.com.hyper.HyperCar.service.Endereco.IEnderecoService;
import br.com.hyper.HyperCar.vo.EnderecoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private IEnderecoService service;

    @GetMapping
    public ResponseEntity getTodosEnderecos(){

        return ResponseEntity.status(200).body(service.trazerTodosEnderecos());
    }

    @GetMapping("/{id}")
    public ResponseEntity getEndereco(@PathVariable int id){

        if (service.buscarEndereco(id) == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(service.buscarEndereco(id));
    }

    @PostMapping
    public ResponseEntity postEndereco(@RequestBody EnderecoVO endereco){

        service.salvarEndereco(endereco);
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    public ResponseEntity putEndereco(@RequestBody EnderecoVO endereco){

        service.editarEndereco(endereco, endereco.getId());
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEndereco(@PathVariable int id){

        service.deletarEndereco(id);
        return ResponseEntity.status(200).build();
    }
}
