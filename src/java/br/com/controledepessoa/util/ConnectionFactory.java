/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controledepessoa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Heitor
 */
public class ConnectionFactory {
    //Sempre adicionar a biblioteca do driver do JDBC(Ficar atento a versao)
    //Botao Direito em Biblioteca >> Add Jar/Pasta
   
    //Conexao
    public static Connection conectar() throws Exception{
        String url = "jdbc:postgresql://localhost:5432/bdpessoa"; //Indicar o caminho do BD
        String user = "postgres"; //Usuario
        String passoword = "123456";
   
        //Tratamento de Excessoes/Erro
        
        try{ //Tentar
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, passoword);
        }catch(Exception ex){ //Excessao
            throw new Exception ("Erro ao conectar no BD \n" + ex.getMessage());
        }
    }
    
    //Fecha a conexao
    public static void fechar(Connection conn, Statement stmt, ResultSet rs) throws Exception{
        try{
            if(conn!=null) conn.close();//conn se for diferente de nula ele fecha a conexao
            if(stmt!=null) stmt.close();//stmt manipula o sql, e se estiver preenchido tbm vai ser fechado
            if(rs!=null) rs.close();//rs armazena os dados da consulta no BD
        }catch(Exception ex){
            throw new Exception("Erro ao fechar parametros de conexao" + ex.getMessage());
        }
        
    }
}

