package br.com.hyper.HyperCar.Repository;

import br.com.hyper.HyperCar.Entity.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompradorRepository extends JpaRepository<Comprador, Integer> {
}
