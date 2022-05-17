/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.av1.control;

import ifc.edu.br.av1.c.model.Carro;
import ifc.edu.br.av1.c.model.Pessoa;
import ifc.edu.br.av1.dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author andre
 */

@WebServlet(name = "Geral", urlPatterns = {"/Geral"})
public class Geral extends HttpServlet {
    DAO dao = new DAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        if (request.getParameter("visualizar") != null) {
            request.setAttribute("pessoas", dao.consultarPessoas());
            getServletContext().getRequestDispatcher("/listar.jsp").forward(request, response);
        } else if (request.getParameter("cadastroPessoa") != null) {
            request.setAttribute("carros", dao.consultarCarros());
            getServletContext().getRequestDispatcher("/cadastro.jsp").forward(request, response);
        } else if (request.getParameter("cadastroCarros") != null) {
            getServletContext().getRequestDispatcher("/cadastroCarros.jsp").forward(request, response);
        }
    }

 
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
        } else if ("Carro".equals(request.getParameter("parent"))) {
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
