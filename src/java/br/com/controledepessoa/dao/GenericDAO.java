/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controledepessoa.dao;

import java.util.List;

/**
 *
 * @author Heitor
 */
public interface GenericDAO {
    //Contem os metodos que sao comuns a todas as classes
    //CRUD - Cadastrar, listar, alterar e excluir;
    
    //assinatura dos metodos
    //metododeacesso tiporetorno nome(parametros){}
    
    public Boolean cadastrar(Object Object);
    public List<Object> listar(); //add importacao Java.util.list
    public void excluir(int idObject);
    //Alterar depende de buscar os dados anteriormente
    public Object carregar (int idObject);
    public Boolean alterar(Object Object);
    
}
