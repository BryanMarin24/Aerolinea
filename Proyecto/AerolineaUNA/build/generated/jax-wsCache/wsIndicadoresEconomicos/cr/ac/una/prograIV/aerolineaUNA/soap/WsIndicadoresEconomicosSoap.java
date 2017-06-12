
package cr.ac.una.prograIV.aerolineaUNA.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebService(name = "wsIndicadoresEconomicosSoap", targetNamespace = "http://ws.sdde.bccr.fi.cr")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WsIndicadoresEconomicosSoap {


    /**
     * Obtiene los valores del indicador económico deseado (DataSet) para un rango de fecha determinado con formato dd/mm/yyyy (día/mes/año). Parámetros de entrada: Código del indicador, Fecha de inicio de tipo string , Fecha final de tipo string, Nombre de la persona que utiliza el servicio y el indicador (S = Si o N = No) para indicar si desea o no obtener los subniveles del indicador a consultar. Retorna un DataSet con los siguientes campos: Código de la variable tipo string, fecha tipo date y el valor tipo numéric. TODOS los campos son obligatorios, de no integresar algunos de los parámetros el valor de retorno del servicio será Nothing. 
     * 
     * @param tcFechaInicio
     * @param tcNombre
     * @param tnSubNiveles
     * @param tcIndicador
     * @param tcFechaFinal
     * @return
     *     returns cr.ac.una.prograIV.aerolineaUNA.soap.ObtenerIndicadoresEconomicosResponse.ObtenerIndicadoresEconomicosResult
     */
    @WebMethod(operationName = "ObtenerIndicadoresEconomicos", action = "http://ws.sdde.bccr.fi.cr/ObtenerIndicadoresEconomicos")
    @WebResult(name = "ObtenerIndicadoresEconomicosResult", targetNamespace = "http://ws.sdde.bccr.fi.cr")
    @RequestWrapper(localName = "ObtenerIndicadoresEconomicos", targetNamespace = "http://ws.sdde.bccr.fi.cr", className = "cr.ac.una.prograIV.aerolineaUNA.soap.ObtenerIndicadoresEconomicos")
    @ResponseWrapper(localName = "ObtenerIndicadoresEconomicosResponse", targetNamespace = "http://ws.sdde.bccr.fi.cr", className = "cr.ac.una.prograIV.aerolineaUNA.soap.ObtenerIndicadoresEconomicosResponse")
    public cr.ac.una.prograIV.aerolineaUNA.soap.ObtenerIndicadoresEconomicosResponse.ObtenerIndicadoresEconomicosResult obtenerIndicadoresEconomicos(
        @WebParam(name = "tcIndicador", targetNamespace = "http://ws.sdde.bccr.fi.cr")
        String tcIndicador,
        @WebParam(name = "tcFechaInicio", targetNamespace = "http://ws.sdde.bccr.fi.cr")
        String tcFechaInicio,
        @WebParam(name = "tcFechaFinal", targetNamespace = "http://ws.sdde.bccr.fi.cr")
        String tcFechaFinal,
        @WebParam(name = "tcNombre", targetNamespace = "http://ws.sdde.bccr.fi.cr")
        String tcNombre,
        @WebParam(name = "tnSubNiveles", targetNamespace = "http://ws.sdde.bccr.fi.cr")
        String tnSubNiveles);

    /**
     * Obtiene los valores del indicador económico (XML) deseado para un rango de fecha determinado con formato dd/mm/yyyy (día/mes/año). Parámetros de entrada: Código del indicador, Fecha de inicio de tipo string , Fecha final de tipo string, Nombre de la persona que utiliza el servicio y el indicador (S = Si o N = No) para indicar si desea o no obtener los subniveles del indicador a consultar. Retorna un DataSet con los siguientes campos: Código de la variable tipo string, fecha tipo date y el valor tipo numéric. TODOS los campos son obligatorios, de no integresar algunos de los parámetros el valor de retorno del servicio será Nothing. 
     * 
     * @param tcFechaInicio
     * @param tcNombre
     * @param tnSubNiveles
     * @param tcIndicador
     * @param tcFechaFinal
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ObtenerIndicadoresEconomicosXML", action = "http://ws.sdde.bccr.fi.cr/ObtenerIndicadoresEconomicosXML")
    @WebResult(name = "ObtenerIndicadoresEconomicosXMLResult", targetNamespace = "http://ws.sdde.bccr.fi.cr")
    @RequestWrapper(localName = "ObtenerIndicadoresEconomicosXML", targetNamespace = "http://ws.sdde.bccr.fi.cr", className = "cr.ac.una.prograIV.aerolineaUNA.soap.ObtenerIndicadoresEconomicosXML")
    @ResponseWrapper(localName = "ObtenerIndicadoresEconomicosXMLResponse", targetNamespace = "http://ws.sdde.bccr.fi.cr", className = "cr.ac.una.prograIV.aerolineaUNA.soap.ObtenerIndicadoresEconomicosXMLResponse")
    public String obtenerIndicadoresEconomicosXML(
        @WebParam(name = "tcIndicador", targetNamespace = "http://ws.sdde.bccr.fi.cr")
        String tcIndicador,
        @WebParam(name = "tcFechaInicio", targetNamespace = "http://ws.sdde.bccr.fi.cr")
        String tcFechaInicio,
        @WebParam(name = "tcFechaFinal", targetNamespace = "http://ws.sdde.bccr.fi.cr")
        String tcFechaFinal,
        @WebParam(name = "tcNombre", targetNamespace = "http://ws.sdde.bccr.fi.cr")
        String tcNombre,
        @WebParam(name = "tnSubNiveles", targetNamespace = "http://ws.sdde.bccr.fi.cr")
        String tnSubNiveles);

}
