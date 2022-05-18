/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.av1.control;

import ifc.edu.br.av1.c.model.Carro;
import ifc.edu.br.av1.c.model.Pessoa;
import ifc.edu.br.av1.dao.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author andrei
 */

@WebServlet(name = "Geral", urlPatterns = {"/Geral"})
public class Geral extends HttpServlet {
    DAO dao = new DAO();

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
        if (request.getParameter("visualizar") != null) {
            request.setAttribute("pessoas", dao.consultarPessoas());
            getServletContext().getRequestDispatcher("/pessoas.jsp").forward(request, response);
        } else if (request.getParameter("cadastroPessoa") != null) {
            request.setAttribute("carros", dao.consultarCarros());
            getServletContext().getRequestDispatcher("/cadastroPessoa.jsp").forward(request, response);
        } else if (request.getParameter("cadastroCarro") != null) {
            getServletContext().getRequestDispatcher("/cadastroCarro.jsp").forward(request, response);
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
        processRequest(request, response);
        if ("pessoa".equals(request.getParameter("parent"))) {
            Pessoa p = new Pessoa();
            p.setNome(request.getParameter("nome"));
            p.setEmail(request.getParameter("email"));
            p.setPeso(validaFloat(request.getParameter("peso")));
            p.setCarro(dao.consultarCarro(validaLong(request.getParameter("carros"))));
            dao.inserirPessoa(p);
        } else if ("carro".equals(request.getParameter("parent"))) {
            Carro c = new Carro();
            c.setNome(request.getParameter("nome"));
            dao.inserirCarro(c);    
        }
        request.setAttribute("msg", "Cadastro realizado com sucesso!");
        getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);
    }
    
    private Float validaFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch(Exception e) {
            return 0F;
        }
    }
    
    private Long validaLong(String s) {
        try {
            return Long.parseLong(s);
        } catch(Exception e) {
            return 0L;
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