package br.com.hyper.HyperCar.Repository;

import br.com.hyper.HyperCar.Entity.Carro;
import br.com.hyper.HyperCar.Entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Integer> {

    List<Carro> findByAtivo(Boolean ativo);
    Optional<Carro> findByIdAndAtivo(Integer id, Boolean ativo);
    List<Carro> findByModeloLike(String modelo);
    List<Carro> findByAno(String ano);
    List<Carro> findByModeloAndAno(String modelo, String ano); // pesquisando pelo modelo e ano
    List<Carro> findByFabricante(String fabricante);
}
