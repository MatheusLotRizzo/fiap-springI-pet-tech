package br.com.rizzo.pettech.repositories;

import br.com.rizzo.pettech.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository  extends JpaRepository<Produto, UUID> {
}
