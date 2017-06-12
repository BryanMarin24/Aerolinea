/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.controller;

import cr.ac.una.prograIV.aerolineaUNA.bl.UsuarioBL;
import cr.ac.una.prograIV.aerolineaUNA.domain.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elberth
 */
public class UsuarioServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            try {
                //String para guardar el JSON generaro por al libreria GSON
                String json;

                //Se crea el objeto Persona
                Usuario p = new Usuario();

                //Se crea el objeto de la logica de negocio
                UsuarioBL pBL = new UsuarioBL();

                //Se hace una pausa para ver el modal
                Thread.sleep(1000);

                //**********************************************************************
                //se toman los datos de la session
                //**********************************************************************
                HttpSession session = request.getSession();

                //**********************************************************************
                //se consulta cual accion se desea realizar
                //**********************************************************************
                String accion = request.getParameter("accion");
                switch (accion) {

                    case "agregarUsuario":

                        //Se llena el objeto con los datos enviados por AJAX por el metodo post
                        p.setIdUsuario(request.getParameter("IdUsuario"));
                        p.setCorreo(request.getParameter("correo"));
                        p.setContraseña(request.getParameter("password"));
                        p.setNombre(request.getParameter("nombre"));
                        p.setApellido1(request.getParameter("apellido1"));
                        p.setApellido2(request.getParameter("apellido2"));
                        p.setTelefonoCelular(request.getParameter("telefono1"));
                        p.setTelefonoLocal(Integer.parseInt(request.getParameter("telefono2")));
                        p.setDireccion(request.getParameter("direccion"));
                        //Guardar Correctamente en la base de datos
                        String fechatxt = request.getParameter("fechaNacimiento");
                        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        Date date = format.parse(fechatxt);
                        p.setFechaNacimiento(date);
                        p.setTipo(request.getParameter("tipo"));

                        pBL.save(p);

                        //Se imprime la respuesta con el response
                        out.print("C~La persona fue modificada correctamente");

                        break;

                    default:
                        out.print("E~No se indico la acción que se desea realizare");
                        break;
                }

            } catch (NumberFormatException e) {
                out.print("E~" + e.getMessage());
            } catch (Exception e) {
                out.print("E~" + e.getMessage());
            }
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
