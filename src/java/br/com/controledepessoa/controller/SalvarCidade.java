/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controledepessoa.controller;

import br.com.controledepessoa.dao.CidadeDAOImpl;
import br.com.controledepessoa.dao.GenericDAO;
import br.com.controledepessoa.model.Cidade;
import br.com.controledepessoa.model.Estado;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Heitor
 */
@WebServlet(name = "SalvarCidade", urlPatterns = {"/SalvarCidade"})
public class SalvarCidade extends HttpServlet {

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
            throws ServletException, IOException, Exception {
     
        //recuperar os dados do FRONT
        Cidade oCidade = new Cidade();

        oCidade.setNomeCidade(request.getParameter("nomecidade"));

        oCidade.setEstado(new Estado(Integer.parseInt(request.getParameter("idestado"))));
        String mensagem="";
        try{
            GenericDAO dao = new CidadeDAOImpl();

            if(request.getParameter("idcidade").equals("")){
                if(dao.cadastrar(oCidade))
                {
                    mensagem = "Cidade cadastrada com Sucesso!";
                }
                else
                {
                    mensagem = "erro ao cadastrar Cidade";
                }
            }else{
                oCidade.setIdCidade(Integer.parseInt(request.getParameter("idcidade")));
                if(dao.alterar(oCidade)){
                    mensagem = "cidade alterada com sucesso!";
                }
                else{
                    mensagem = "Erro ao alterar Cidade";
                }
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("ListarCidade").forward(request, response);

        } catch(Exception ex){
            System.out.println("Problemas no Servlet SalvarCidade");
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SalvarCidade.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SalvarCidade.class.getName()).log(Level.SEVERE, null, ex);
        }
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
