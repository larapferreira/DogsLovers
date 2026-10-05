package com.example.dogslovers;

public class Cachorro {

    private String nome;
    private String raca;
    private String descricao;
    private String imagem;

    public Cachorro(String nome, String raca,
                    String descricao, String imagem) {
        this.nome = nome;
        this.raca = raca;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImagem() {
        return imagem;
    }
}
