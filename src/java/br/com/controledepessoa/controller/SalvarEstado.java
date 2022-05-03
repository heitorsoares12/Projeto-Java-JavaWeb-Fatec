/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controledepessoa.controller;

import br.com.controledepessoa.dao.EstadoDAOImpl;
import br.com.controledepessoa.dao.GenericDAO;
import br.com.controledepessoa.model.Estado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Heitor
 */
@WebServlet(name = "SalvarEstado", urlPatterns = {"/SalvarEstado"})
public class SalvarEstado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Processa Requissicao e Resposta;
        //RECUPERANDO OS DADOS QUE VEM PELO REQUEST
        Estado oEstado = new Estado();//Instancia de um objeto
        
        oEstado.setNomeEstado(request.getParameter("nomeEstado"));
        oEstado.setSiglaEstado(request.getParameter("siglaEstado"));
        
        String mensagem ="";
        
        //Processar a informacao Armazenas os dados
        try{
        GenericDAO dao = new EstadoDAOImpl();
        if(dao.cadastrar(oEstado)){//Chama o metodo que ja retorna Boolean(V ou F)
            mensagem = oEstado.getSiglaEstado() + ", Cadastrado com Sucesso";
        }else{
            mensagem = "Erro no cadastro do estado" +oEstado.getSiglaEstado();
        }
            
        }catch(Exception ex){
            System.out.println("Erro no Servlest SalvarEstado \n Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        request.setAttribute("mensagem" , mensagem);
        //Saida - Retorno
        request.getRequestDispatcher("ListarEstado").forward(request, response);
    }
        
        
        
        
        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
