/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cr.ac.una.prograIV.aerolineaUNA.bl.PagoBL;
import cr.ac.una.prograIV.aerolineaUNA.domain.Pago;
import cr.ac.una.prograIV.aerolineaUNA.soap.WsIndicadoresEconomicos;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import javassist.convert.Transformer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Elberth
 */
public class PagoServlet extends HttpServlet {
@WebServiceRef(wsdlLocation = "WEB-INF/wsdl/wsIndicadoresEconomicos.asmx.wsdl")
    private WsIndicadoresEconomicos service;
    
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
            Pago p = new Pago();

            //Se crea el objeto de la logica de negocio
            PagoBL pBL = new PagoBL();

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
               
                    
                case "consultarTipoCambio":
                    QName portQName = new QName("http://ws.sdde.bccr.fi.cr" , "wsIndicadoresEconomicosSoap12");
                    String req = "<ObtenerIndicadoresEconomicosXML  xmlns=\"http://ws.sdde.bccr.fi.cr\"><tcIndicador>317</tcIndicador><tcFechaInicio>06/06/2017</tcFechaInicio><tcFechaFinal>06/06/2017</tcFechaFinal><tcNombre>Compra</tcNombre><tnSubNiveles>N</tnSubNiveles></ObtenerIndicadoresEconomicosXML>";
                    
                    try { // Call Web Service Operation
                        
                        //******************************************************
                        //Consulta del servicio Web
                        //******************************************************
                        Dispatch<Source> sourceDispatch = null;
                        sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
                        Source result = sourceDispatch.invoke(new StreamSource(new StringReader(req)));
                        
                        //******************************************************
                        //Convertir la consulta a XML
                        //******************************************************
                        StreamResult xmlOutput=new StreamResult(new StringWriter());
                        javax.xml.transform.Transformer transformer=TransformerFactory.newInstance().newTransformer();
                        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","2");
                        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
                        transformer.transform(result,xmlOutput);
                        
                        String XMLResult = xmlOutput.getWriter().toString();
                        out.print(XMLResult);
                        
                                
                    } catch (Exception ex) {
                        out.print("E~Error a la hora de consultar el SOA");
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
