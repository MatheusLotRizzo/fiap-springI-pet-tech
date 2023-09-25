package br.com.rizzo.pettech.repositories;

import br.com.rizzo.pettech.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository  extends JpaRepository<ProdutoEntity, UUID> {
}
