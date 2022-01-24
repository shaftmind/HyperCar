package br.com.hyper.HyperCar.user.resource;

import br.com.hyper.HyperCar.data.model.entity.Endereco;
import br.com.hyper.HyperCar.exception.ResourceNoContentException;
import br.com.hyper.HyperCar.exception.ResourceNotFoundException;
import br.com.hyper.HyperCar.service.Endereco.IEnderecoService;
import br.com.hyper.HyperCar.data.vo.EnderecoVO;
import br.com.hyper.HyperCar.user.mapper.EnderecoToEnderecoVO;
import br.com.hyper.HyperCar.user.request.EnderecoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController()
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private IEnderecoService service;

    @Autowired
    private EnderecoToEnderecoVO enderecoMapper;

    @GetMapping
    @ResponseStatus(OK)
    public List<EnderecoVO> getTodosEnderecos(){
        List<Endereco> todosEnderecos = service.trazerTodosEnderecos();
        if (todosEnderecos.isEmpty()){
            throw new ResourceNoContentException("Nenhum Endereço encontrado");
        }
        return enderecoMapper.mapList(todosEnderecos);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public EnderecoVO getEndereco(@PathVariable int id){
        Endereco enderecoPesquisado = service.buscarEndereco(id).orElseThrow(() ->
            new ResourceNoContentException("Endereço não encontrado"));
        return enderecoMapper.map(enderecoPesquisado);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public EnderecoVO postEndereco(@RequestBody EnderecoRequest endereco){
        return enderecoMapper.map(service.salvarEndereco(endereco));
    }

    @PutMapping("/{id}")
    @ResponseStatus(CREATED)
    public EnderecoVO putEndereco(@RequestBody EnderecoRequest endereco, @PathVariable int id){
        Endereco enderecoAtualizar = service.editarEndereco(endereco, id)
                .orElseThrow(() -> new ResourceNoContentException("Endereço não encontrado"));
            return enderecoMapper.map(enderecoAtualizar);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteEndereco(@PathVariable int id){
        service.deletarEndereco(id).orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado"));
    }
}
