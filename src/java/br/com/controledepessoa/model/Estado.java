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
public class Estado {
    //Definir as caracteristicas...
    private int idEstado;
    private String nomeEstado;
    private String siglaEstado;
    
    //Gerar Contrutor 
    //Primeiro sem marcar nenhuma caixinha, depois com todas marcadas (vazio e cheio)
    //Botao Direito >> Inseriri Codigo >> Construtor

    public Estado() {
    }

    public Estado(int idEstado, String nomeEstado, String siglaEstado) {
        this.idEstado = idEstado;
        this.nomeEstado = nomeEstado;
        this.siglaEstado = siglaEstado;
    }
    //acesso aos Atributos  - Get e SET
    //Botao Direito >> Refatorar >> Encapsular Campos
    //OU
    //Botao Direito >> Inseriri Codigo >> Getters & Setters

    public Estado(int idEstado) {
        this.idEstado = idEstado;
    }

    public Estado(String nomeEstado, String siglaEstado) {
        this.nomeEstado = nomeEstado;
        this.siglaEstado = siglaEstado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    
    
    
    
}
