/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.controller;

import com.google.gson.Gson;
import cr.ac.una.prograIV.aerolineaUNA.bl.AvionBL;
import cr.ac.una.prograIV.aerolineaUNA.bl.HorarioBL;
import cr.ac.una.prograIV.aerolineaUNA.bl.RutaBL;
import cr.ac.una.prograIV.aerolineaUNA.domain.Avion;
import cr.ac.una.prograIV.aerolineaUNA.domain.Horario;
import cr.ac.una.prograIV.aerolineaUNA.domain.Ruta;
import cr.ac.una.prograIV.aerolineaUNA.domain.RutaAux;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RutaServlet extends HttpServlet {

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
            Ruta p = new Ruta();

            //Se crea el objeto de la logica de negocio
            RutaBL pBL = new RutaBL();

            /**
             * ********************
             */
            Horario h = new Horario();
            HorarioBL hBL = new HorarioBL();
            /**
             * ********************
             */

            /**
             * ********************
             */
            Avion a = new Avion();
            AvionBL aBL = new AvionBL();
            /**
             * ********************
             */

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
                case "consultarRutas":
                    List<RutaAux> lrAux = new ArrayList<RutaAux>();
                    List<Ruta> lr = pBL.findAll(Ruta.class.getName());
                    for (int i = 0; i < lr.size(); i++) {
                        String idrut =lr.get(i).getIdRuta();
                        String idav =lr.get(i).getAvion().getIdAvion();
                        String idhor =lr.get(i).getHorario().getIdHorario();
                        float cost =lr.get(i).getCosto();
                        String org =lr.get(i).getOrigen();
                        String dest =lr.get(i).getDestino();
                        int hora =lr.get(i).getHoras();
                        int min =lr.get(i).getMinutos();
                        lrAux.add(new RutaAux(idrut,idav,idhor,org,dest,cost,hora,min));
                    }
                    json = new Gson().toJson(lrAux);
                    out.print(json);
                    break;
                case "eliminarRuta":
                    String id1 = request.getParameter("idRuta");
                    p.setIdRuta(id1);

                    /**
                     * ************************
                     */
                    List<Horario> lh = hBL.findAll(Horario.class.getName());
                    /**
                     * ************************
                     */

                    /**
                     * ************************
                     */
                    List<Avion> la = aBL.findAll(Avion.class.getName());
                    /**
                     * ************************
                     */

                    //Se elimina el objeto
                    pBL.delete(p);

                    //Se imprime la respuesta con el response
                    out.print("La Ruta fue eliminada correctamente");

                    break;

                case "consultarRutaByID":
                    //se consulta la persona por ID
                    String id = request.getParameter("idRuta");
                    p = pBL.findById(id);

                    //se pasa la informacion del objeto a formato JSON
                    json = new Gson().toJson(p);
                    out.print(json);
                    break;
//                    
//                    
                case "agregarRuta":
                case "modificarRuta":

                    //Se llena el objeto con los datos enviados por AJAX por el metodo post
                    p.setIdRuta(request.getParameter("idRuta"));
                    p.setOrigen(request.getParameter("origen"));
                    p.setDestino(request.getParameter("destino"));
                    p.setCosto(Float.parseFloat(request.getParameter("costo")));
                    p.setHoras(Integer.parseInt(request.getParameter("horas")));
                    p.setMinutos(Integer.parseInt(request.getParameter("minutos")));
                    Horario hor = hBL.findById(request.getParameter("idHorario"));
                    p.setHorario(hor);
                    Avion av = aBL.findById(request.getParameter("idAvion"));
                    p.setAvion(av);

                    if (accion.equals("agregarRuta")) { //es insertar personas
                        //Se guarda el objeto
                        pBL.save(p);

//                        /******************/
//                        String idh = request.getParameter("idHorario");
//                        h = hBL.findById(idh);
//                        h.setRutas((List<Ruta>) p);
//                        hBL.merge(h);
//                        /******************/
//                        
//                         /******************/
//                        String ida = request.getParameter("idAvion");
//                        a = aBL.findById(ida);
//                        a.setRutas((List<Ruta>) p);
//                        aBL.merge(a);
//                        /******************/
                        //Se imprime la respuesta con el response
                        out.print("C~La ruta fue ingresada correctamente");

                    } else {//es modificar persona
                        //Se guarda el objeto
                        pBL.merge(p);

                        //Se imprime la respuesta con el response
                        out.print("C~La ruta fue modificada correctamente");
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
