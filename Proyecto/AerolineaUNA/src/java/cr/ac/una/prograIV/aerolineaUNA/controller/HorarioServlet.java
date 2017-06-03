/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.controller;

import com.google.gson.Gson;
import cr.ac.una.prograIV.aerolineaUNA.bl.HorarioBL;
import cr.ac.una.prograIV.aerolineaUNA.bl.RutaBL;
import cr.ac.una.prograIV.aerolineaUNA.domain.Horario;
import cr.ac.una.prograIV.aerolineaUNA.domain.Ruta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elberth
 */
public class HorarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //String para guardar el JSON generaro por al libreria GSON
            String json;
            
            //Se crea el objeto Persona
            Horario p = new Horario();

            //Se crea el objeto de la logica de negocio
            HorarioBL pBL = new HorarioBL();
                 
            Ruta r = new Ruta();
            RutaBL rBL = new RutaBL();
            
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
                case "consultarHorarios":
                    json = new Gson().toJson(pBL.findAll(Horario.class.getName()));
                    out.print(json);
                    break;
                case "eliminarHorario":
                        String id1 = request.getParameter("idHorario"); 
                        p.setIdHorario(id1);                   
                       
                    
                       //Se elimina el objeto
                        pBL.delete(p);
                          

                        //Se imprime la respuesta con el response
                        out.print("El Horario fue eliminado correctamente");
                 
                    break;
                    
                case "consultarHorarioByID":
                    //se consulta la persona por ID
                    String id = request.getParameter("idHorario");
                    p = pBL.findById(id);
                    
                    //se pasa la informacion del objeto a formato JSON
                    json = new Gson().toJson(p);
                    out.print(json);
                    break;
//                    
//                    
                case "agregarHorario": case "modificarHorario":

                    //Se llena el objeto con los datos enviados por AJAX por el metodo post
                    p.setIdHorario(request.getParameter("idHorario"));
                    p.setDia(request.getParameter("dia"));
                    p.setHora(request.getParameter("hora"));
                    
                    
                    if(accion.equals("agregarHorario")){ //es insertar personas
                        //Se guarda el objeto
                        pBL.save(p);
                        

                        //Se imprime la respuesta con el response
                        out.print("C~El horario fue ingresado correctamente");
                        
                    }else{//es modificar persona
                        //Se guarda el objeto
                        pBL.merge(p);
                        

                        //Se imprime la respuesta con el response
                        out.print("C~El horario fue modificado correctamente");
                    }
                    
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
