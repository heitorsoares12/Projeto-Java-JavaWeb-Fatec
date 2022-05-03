/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controledepessoa.util;

import br.com.controledepessoa.util.ConnectionFactory;
import java.sql.Connection;

/**
 *
 * @author Heitor
 */
public class TestarConexao {
    //Classe Java Principal
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Connection conn = ConnectionFactory.conectar();
            System.out.println("Conectado com Sucesso");
        }catch(Exception ex){
            System.out.println("Nao conectou \n Erro" + ex.getMessage());
        }
    }
    
}
