/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controledepessoa.controller;

import br.com.controledepessoa.dao.CidadeDAOImpl;
import br.com.controledepessoa.dao.EstadoDAOImpl;
import br.com.controledepessoa.dao.GenericDAO;
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

@WebServlet(name = "CarregarCidade", urlPatterns = {"/CarregarCidade"})
public class CarregarCidade extends HttpServlet {

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
       int idCidade = Integer.parseInt(request.getParameter("idcidadecarregar"));

        try{
            GenericDAO dao = new CidadeDAOImpl();//Add Import
            request.setAttribute("oCidade", dao.carregar(idCidade));
            request.getRequestDispatcher("ListarCidade").forward(request, response);
        }catch(Exception ex){
            System.out.println("Erro no Servlet CarregarCidade");
            ex.printStackTrace();
        }
        }
        }

