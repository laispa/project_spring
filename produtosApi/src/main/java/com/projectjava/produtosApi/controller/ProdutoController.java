package com.projectjava.produtosApi.controller;

import com.projectjava.produtosApi.model.Produto;
import com.projectjava.produtosApi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto Recebido " + produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id); // melhor gerar no sql
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}") // o / é opcional
    public Produto obterPorId(@PathVariable("id") String id){
//        Optional<Produto> produto = produtoRepository.findById(id); // optional pois pode ser que o produto não exista, é só usar .var
//        return produto.isPresent() ? produto.get() : null;
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizar (@PathVariable("id") String id,
                           @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){
        return produtoRepository.findByNome(nome);
    }



}
