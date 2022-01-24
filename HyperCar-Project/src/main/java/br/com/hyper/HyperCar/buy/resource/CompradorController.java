package br.com.hyper.HyperCar.buy.resource;

import br.com.hyper.HyperCar.buy.mapper.CompradorToCompradorVO;
import br.com.hyper.HyperCar.buy.request.CompradorRequest;
import br.com.hyper.HyperCar.data.model.entity.Comprador;
import br.com.hyper.HyperCar.exception.ResourceNotFoundException;
import br.com.hyper.HyperCar.service.Comprador.ICompradorService;
import br.com.hyper.HyperCar.data.vo.CompradorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/compradores")
//@RequiredArgsConstructor //faz um construtor com o atributo service, faz a injeção de dependencia
public class CompradorController {

    @Autowired
    private ICompradorService service;

    @Autowired
    private CompradorToCompradorVO compradorMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CompradorVO> getTodosCompradores(){
        return service.trazerTodosCompradores().stream().map(compradorMapper::map).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CompradorVO getComprador(@PathVariable int id){
        Optional<Comprador> comprador = Optional.ofNullable(service.buscarComprador(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID")));
        return compradorMapper.map(comprador.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CompradorVO postComprador(@RequestBody CompradorRequest comprador){
        return compradorMapper.map(service.salvarComprador(comprador));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CompradorVO putComprador(@RequestBody CompradorRequest comprador, @PathVariable Integer id){

        return compradorMapper.map(service.editarComprador(comprador, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComprador(@PathVariable int id){
        service.deletarComprador(id);
    }
}
