package br.com.rizzo.pettech.services;

import br.com.rizzo.pettech.entities.ProdutoEntity;
import br.com.rizzo.pettech.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Collection<ProdutoEntity> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<ProdutoEntity> findById(UUID id) {
        return produtoRepository.findById(id);
    }

    public ProdutoEntity save(ProdutoEntity produtoEntity) {
        return produtoRepository.save(produtoEntity);
    }

    public ProdutoEntity update(UUID id, ProdutoEntity produtoEntity){
        Optional<ProdutoEntity> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            ProdutoEntity produtoAtualizado = produto.get();
            produtoAtualizado.setNome(produtoEntity.getNome());
            produtoAtualizado.setDescricao(produtoEntity.getDescricao());
            produtoAtualizado.setPreco(produtoEntity.getPreco());
            produtoAtualizado.setUrlDaImagem(produtoEntity.getUrlDaImagem());
            return produtoRepository.save(produtoAtualizado);
        }
        return null;
    }

    public void delete(UUID id) {
        produtoRepository.deleteById(id);
    }
}