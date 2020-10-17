package br.com.tst.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tst.domain.Veiculo;

@Repository
public interface VeiculoRep extends JpaRepository<Veiculo, Long> {

	Veiculo save(Optional<Veiculo> newObj);

}
