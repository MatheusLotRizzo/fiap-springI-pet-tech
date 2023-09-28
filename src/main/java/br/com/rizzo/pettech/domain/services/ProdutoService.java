package br.com.rizzo.pettech.domain.services;

import br.com.rizzo.pettech.domain.dto.ProdutoDTO;
import br.com.rizzo.pettech.domain.repositories.ProdutoRepository;
import br.com.rizzo.pettech.domain.entities.ProdutoEntity;
import br.com.rizzo.pettech.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Collection<ProdutoDTO> findAll() {
        return produtoRepository.findAll().stream().map(this::toProdutoDto).collect(Collectors.toList());
    }

    public ProdutoDTO findById(UUID id) {
        return toProdutoDto(produtoRepository.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado")));
    }

    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        ProdutoEntity produtoEntity = toProdutoEntity(produtoDTO);
        return toProdutoDto(produtoRepository.save(produtoEntity));
    }

    public ProdutoDTO update(UUID id, ProdutoDTO produtoDTO) {
        Optional<ProdutoEntity> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            ProdutoEntity produtoAtualizado = produto.get();
            produtoAtualizado.setNome(produtoDTO.nome());
            produtoAtualizado.setDescricao(produtoDTO.descricao());
            produtoAtualizado.setPreco(produtoDTO.preco());
            produtoAtualizado.setUrlDaImagem(produtoDTO.urlDaImagem());
            return toProdutoDto(produtoRepository.save(produtoAtualizado));
        }
        throw new NotFoundException("Produto não encontrado");
    }

    public void delete(UUID id) {
        produtoRepository.deleteById(id);
    }

    private ProdutoDTO toProdutoDto(ProdutoEntity produtoEntity) {
        return new ProdutoDTO(
                produtoEntity.getId(),
                produtoEntity.getNome(),
                produtoEntity.getDescricao(),
                produtoEntity.getPreco(),
                produtoEntity.getUrlDaImagem()
        );
    }

    private ProdutoEntity toProdutoEntity(ProdutoDTO produtoDTO) {
        return new ProdutoEntity(
                produtoDTO.id(),
                produtoDTO.nome(),
                produtoDTO.descricao(),
                produtoDTO.preco(),
                produtoDTO.urlDaImagem()
        );
    }
}