/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Bean.AutoBean;
import DAO.AutoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LugoD
 */
@WebServlet(name = "ActualizarAuto", urlPatterns = {"/ActualizarAuto"})
public class ActualizarAuto extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        String op = request.getParameter("op");
        System.out.println(op);

        String IRA = "";
        if (op.equalsIgnoreCase("enviar")) {
            int id = Integer.parseInt(request.getParameter("codigo"));
            System.out.println("id :" + id);
            AutoDao dao = new AutoDao();
            AutoBean bean = new AutoBean();
            bean = dao.consultarAutosId(id);
            System.out.println(bean.getModelo());
            request.setAttribute("auto", bean);
            IRA = "/ActualizarAuto.jsp";
        } else if (op.equalsIgnoreCase("Modificar")) {
            System.out.println("TTTTT");
            AutoBean bean = new AutoBean();
            bean.setClave(Integer.parseInt(request.getParameter("id")));            
            bean.setNombre(request.getParameter("Nombre"));
            bean.setModelo(Integer.parseInt(request.getParameter("Modelo")));
            bean.setMarca(request.getParameter("Marca"));
            AutoDao daoA = new AutoDao();
            boolean rs = daoA.ActualizarAutos(bean);
            request.setAttribute("TF", rs);
            System.out.println(rs);
            IRA = "/Alerta.jsp";
        }
        this.getServletConfig().getServletContext().getRequestDispatcher(IRA).forward(request, response);

        
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
