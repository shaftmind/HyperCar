package br.com.hyper.HyperCar.Repository;

import br.com.hyper.HyperCar.Entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    List<Endereco> findByAtivo(Boolean ativo);
    Optional<Endereco> findByIdAndAtivo(Integer id, Boolean ativo);
    List<Endereco> findByCepAndAtivo(String cep, Boolean ativo);
    List<Endereco> findByEstado(String estado);
    List<Endereco> findByCidade(String cidade);
    List<Endereco> findByBairro(String bairro);
}
