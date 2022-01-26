package br.com.hyper.HyperCar.data.model.repository;

import br.com.hyper.HyperCar.data.model.entity.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CompradorRepository extends PagingAndSortingRepository<Comprador, Integer> {

    List<Comprador> findByAtivo(Boolean ativo);
    Optional<Comprador> findByIdAndAtivo(Integer id, Boolean ativo);
    List<Comprador> findByNomeLike(String nome);
    List<Comprador> findByCpf(String cpf);
}
