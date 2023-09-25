package br.com.rizzo.pettech.resources;

import br.com.rizzo.pettech.entities.ProdutoEntity;
import br.com.rizzo.pettech.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Collection<ProdutoEntity>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutoEntity>> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoEntity> save(@RequestBody ProdutoEntity produtoEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> update(@PathVariable UUID id, @RequestBody ProdutoEntity produtoEntity) {
        return ResponseEntity.ok(produtoService.update(id, produtoEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}