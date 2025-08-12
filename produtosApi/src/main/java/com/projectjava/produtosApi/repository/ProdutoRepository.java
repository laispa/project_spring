package com.projectjava.produtosApi.repository;

import com.projectjava.produtosApi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProdutoRepository extends JpaRepository <Produto, String> {

    List<Produto> findByNome(String nome); // importante usar o Nome maisculo para pegar o getNome;
}
