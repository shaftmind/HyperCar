package br.com.hyper.HyperCar.Repository;

import br.com.hyper.HyperCar.Entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
}
