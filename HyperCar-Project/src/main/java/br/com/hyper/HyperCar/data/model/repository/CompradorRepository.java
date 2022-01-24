package br.com.hyper.HyperCar.data.model.repository;

import br.com.hyper.HyperCar.data.model.entity.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompradorRepository extends JpaRepository<Comprador, Integer> {

    List<Comprador> findByAtivo(Boolean ativo);
    Optional<Comprador> findByIdAndAtivo(Integer id, Boolean ativo);
    List<Comprador> findByNomeLike(String nome);
    List<Comprador> findByCpf(String cpf);
}
