package com.projectjava.produtosApi.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto") // também não é necessário
public class Produto {
    @Id
    @Column(name = "id") // não é necessário colocar nas colunas que tem o mesmo nome no bd
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name= "descricao")
    private String descricao;

    @Column(name = "preco")
    private Double preco;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
