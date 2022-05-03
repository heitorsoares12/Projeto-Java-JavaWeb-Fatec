/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controledepessoa.dao;

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
public class EstadoDAOImpl implements GenericDAO {
    
    private Connection conn;//add importacao java.sql.connection

    //Construtor cria em memoria tudo que esta dentro

    public EstadoDAOImpl() throws Exception {
        //conecte no banco
        try{
            this.conn = ConnectionFactory.conectar();
            System.out.println("Conectado com Sucesso");
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
    
    
    @Override
    public Boolean cadastrar(Object object) {
        //Indicar o tipo do Object
        
       Estado oEstado = (Estado) object;
        //indicar que nos vamos manipular o SQL
        
        PreparedStatement stmt = null; //add import java.sql.preparedstatement
        
        //Criar SQL
        String sql = "INSERT INTO estado(siglaestado, nomeestado) "
                   + "values (?, ?);";//as interrogacao sao parametros...
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, oEstado.getSiglaEstado());
            stmt.setString(2, oEstado.getNomeEstado());
            stmt.execute();//Executa o comando SQL dentro da conexao (BD) informado
            return true;
        }catch(Exception ex){
            System.out.println("Erro ao cadastrar Estado \n Erro:" +ex.getMessage());
            ex.printStackTrace();//detalha o erro
            return false;
        }finally{
            //o codigo vai ser executado de qualquer forma //Obrigatoriamente devemos fechar a conexao e o parametros
            try{
               ConnectionFactory.fechar(conn, stmt, null); 
            }catch(Exception ex){
                System.out.println("Erro ao fechar parametro de conexao \n Erro: "+ex.getMessage());
                ex.printStackTrace();
            }
            
        }
        
    }

    @Override
    public List<Object> listar() {
        //Prepara oque sera utilizado
        PreparedStatement stmt = null; //Todas as vezes eu declaro o stmt
        ResultSet rs = null;//Armazena os dados //Add importacao import java.sql.ResultSet;
        //Criar Vetor
        List<Object> resultado = new ArrayList<>();//add importacao java.util.ArrayList;
        
        String sql = "SELECT * FROM ESTADO";//Lista todos os estados
        //Executa de fato dentro do try
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();//Executa a consulta e armazena dentro do rs
            
            //Extracao dos dados do rs e passa para array
            while(rs.next()){
                Estado oEstado = new Estado();
                //Objeto.setAtributo(rs.getTipo("nomecoluna"); - nome coluna igual esta banco
                oEstado.setIdEstado(rs.getInt("idestado"));
                oEstado.setNomeEstado(rs.getString("nomeestado"));
                oEstado.setSiglaEstado(rs.getString("siglaestado"));
                resultado.add(oEstado);
            }
        }catch(SQLException ex){
            System.out.println("Erro ao lista Estado \n Erro: " +ex.getMessage());
            ex.printStackTrace();
        }finally{
        //Fecha a conexao
        try{
        ConnectionFactory.fechar(conn, stmt, rs);
        }catch(Exception ex){
            System.out.println("Erro ao fecha parametros de conexao \n Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        }
        return resultado;
        
        
        
    }

    @Override
    public void excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM estado WHERE idestado=?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Erro no ExcluirEstadoDAOImpl: " + ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.fechar(conn, stmt, null);
            }catch(Exception ex){
                System.out.println("Erro ao fechar conexao: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int idObject) {
       PreparedStatement stmt= null;
       ResultSet rs = null;
       Estado oEstado = null;
       String sql = "SELECT * FROM estado WHERE idestado=?";
       
       try{
           stmt = conn.prepareStatement(sql);
           stmt.setInt(1, idObject);
           rs = stmt.executeQuery();
           
           if(rs.next())
           {
               oEstado = new Estado();
               oEstado.setIdEstado(rs.getInt("idestado"));
               oEstado.setNomeEstado(rs.getString("nomeestado"));
               oEstado.setSiglaEstado(rs.getString("siglaestado"));
           }          
       }catch(SQLException ex)
       {
           System.out.println("Errro ao carregar EstadoDAOImpl" + " \n Erro: " + ex.getMessage());
           ex.printStackTrace();
       }finally
       {
           try
           {
               ConnectionFactory.fechar(conn, stmt, rs);
           }catch(Exception ex)
           {
               System.out.println("Erro ao fechar Conexao: " + ex.getMessage());
               ex.printStackTrace();
           }
       }
       return oEstado;  
    }

    @Override
    public Boolean alterar(Object Object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
