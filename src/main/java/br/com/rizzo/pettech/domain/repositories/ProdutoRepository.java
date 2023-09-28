package br.com.rizzo.pettech.domain.repositories;

import br.com.rizzo.pettech.domain.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository  extends JpaRepository<ProdutoEntity, UUID> {
}
