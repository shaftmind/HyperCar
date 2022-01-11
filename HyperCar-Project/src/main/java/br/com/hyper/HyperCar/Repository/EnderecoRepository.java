package br.com.hyper.HyperCar.Repository;

import br.com.hyper.HyperCar.Entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
