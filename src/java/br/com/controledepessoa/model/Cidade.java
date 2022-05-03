/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controledepessoa.model;

/**
 *
 * @author Heitor
 */
public class Cidade {
    
    private Integer idCidade;
    private String nomeCidade;
    //Declarar associação
    private Estado estado;

    public Cidade() {
    }

    public Cidade(Integer idCidade, String nomeCidade, Estado estado) {
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
        this.estado = estado;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
}
