/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controledepessoa.dao;

import br.com.controledepessoa.model.Cidade;
import br.com.controledepessoa.model.Estado;
import br.com.controledepessoa.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Heitor
 */
public class CidadeDAOImpl implements GenericDAO {
    
     private Connection conn;//add importação
    
    public CidadeDAOImpl() throws Exception {
        try{
            this.conn = ConnectionFactory.conectar();
            System.out.println("Conectado com sucesso");
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }



    @Override
    public Boolean cadastrar(Object object) {
        Cidade oCidade =(Cidade) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO cidade(nomecidade, idestado) VALUES (?, ?); ";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oCidade.getNomeCidade());
            //parametro chave
            stmt.setInt(2, oCidade.getEstado().getIdEstado());
            stmt.execute();
            return true;    
        }catch(Exception ex){
            System.out.println("Erro ao cadastrarEstado \n Erro:"+ ex.getMessage());
            ex.printStackTrace();//detalha o erro.
            return false;
        }finally{
            //e executado de qualquer forma. //obrigatoriamente devemos fechar a conexão e os parametros.
            try{
            ConnectionFactory.fechar(conn, stmt, null); 
        }catch(Exception ex){
                System.out.println("Erro ao fechar parametros de conexão Erro:" +ex.getMessage());
                ex.printStackTrace();
        }
      }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT idcidade, nomecidade, siglaestado, nomeestado "
                + " from estado, cidade"
                + " where cidade.idestado = estado.idestado"; 
        
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cidade oCidade = new Cidade();
                oCidade.setIdCidade(rs.getInt("idcidade"));
                oCidade.setNomeCidade(rs.getString("nomecidade"));
                oCidade.setEstado( new Estado(rs.getString("nomeestado"), rs.getString("siglaestado")));
               
                resultado.add(oCidade);
            }
        }catch(SQLException ex){
          System.out.println("Erro ao listar cidade \n ERRO:" + ex.getMessage());
          ex.printStackTrace();
      }finally{
          try {
              ConnectionFactory.fechar(conn, stmt, rs); 
      }catch(Exception ex){
              System.out.println("Erro ao fechar parametros de conexão \n ERRO:" + ex.getMessage());
              ex.printStackTrace();
        }
    }
    return resultado; 
    }

    @Override
    public void excluir(int idObject) {
         PreparedStatement stmt = null;
        String sql = "DELETE FROM cidade WHERE idcidade=?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Erro no ExcluirCidadeDAOImpl: " + ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.fechar(conn, stmt, null);
            }catch(Exception ex){
                System.out.println("Erro ao fechar conexão: " +ex.getMessage());
                ex.printStackTrace();
        }
      }
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cidade oCidade = null;

        String sql = " SELECT idcidade, nomecidade, siglaestado, nomeestado, cidade.idestado"
                + " FROM estado, cidade"
                + " WHERE cidade.idestado = estado.idestado "
                + " AND cidade.idcidade = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            if (rs.next()) {
                oCidade = new Cidade();
                oCidade.setIdCidade(rs.getInt("idcidade"));
                oCidade.setNomeCidade(rs.getString("nomecidade"));

                Estado oEstado = new Estado(rs.getInt("idestado"),
                        rs.getString("nomeestado"),
                        rs.getString("siglaestado"));
                oCidade.setEstado(oEstado);

            }
        } catch (SQLException ex) {
            System.out.println("Erro ao Carregar EstadoDAOImpl"
                    + " \n Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.fechar(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar Conexão: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return oCidade;
    }

    @Override
    public Boolean alterar(Object object) {
        Cidade oCidade = (Cidade) object;
        PreparedStatement stmt = null;
        String sql = "UPDATE cidade SET"
                + " nomecidade = ?,"
                + " idestado = ?"
                + " WHERE idcidade = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oCidade.getNomeCidade());

            stmt.setInt(2, oCidade.getEstado().getIdEstado());
            stmt.setInt(3, oCidade.getIdCidade());
            stmt.execute();
            return true;

        } catch (Exception ex) {
            System.out.println("Erro ao alterarCidade (DAO) \n Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {

            try {
                ConnectionFactory.fechar(conn, stmt, null);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar parametros de conexão Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}

