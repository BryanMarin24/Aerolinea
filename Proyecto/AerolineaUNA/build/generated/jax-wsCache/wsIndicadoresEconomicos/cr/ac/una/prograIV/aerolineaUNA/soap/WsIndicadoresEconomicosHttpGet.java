
package cr.ac.una.prograIV.aerolineaUNA.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebService(name = "wsIndicadoresEconomicosHttpGet", targetNamespace = "http://ws.sdde.bccr.fi.cr")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WsIndicadoresEconomicosHttpGet {


    /**
     * Obtiene los valores del indicador económico deseado (DataSet) para un rango de fecha determinado con formato dd/mm/yyyy (día/mes/año). Parámetros de entrada: Código del indicador, Fecha de inicio de tipo string , Fecha final de tipo string, Nombre de la persona que utiliza el servicio y el indicador (S = Si o N = No) para indicar si desea o no obtener los subniveles del indicador a consultar. Retorna un DataSet con los siguientes campos: Código de la variable tipo string, fecha tipo date y el valor tipo numéric. TODOS los campos son obligatorios, de no integresar algunos de los parámetros el valor de retorno del servicio será Nothing. 
     * 
     * @param tcFechaInicio
     * @param tcNombre
     * @param tnSubNiveles
     * @param tcIndicador
     * @param tcFechaFinal
     * @return
     *     returns cr.ac.una.prograIV.aerolineaUNA.soap.DataSet
     */
    @WebMethod(operationName = "ObtenerIndicadoresEconomicos")
    @WebResult(name = "DataSet", targetNamespace = "http://ws.sdde.bccr.fi.cr", partName = "Body")
    public DataSet obtenerIndicadoresEconomicos(
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "tcIndicador")
        String tcIndicador,
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "tcFechaInicio")
        String tcFechaInicio,
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "tcFechaFinal")
        String tcFechaFinal,
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "tcNombre")
        String tcNombre,
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "tnSubNiveles")
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
    @WebMethod(operationName = "ObtenerIndicadoresEconomicosXML")
    @WebResult(name = "string", targetNamespace = "http://ws.sdde.bccr.fi.cr", partName = "Body")
    public String obtenerIndicadoresEconomicosXML(
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "tcIndicador")
        String tcIndicador,
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "tcFechaInicio")
        String tcFechaInicio,
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "tcFechaFinal")
        String tcFechaFinal,
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "tcNombre")
        String tcNombre,
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "tnSubNiveles")
        String tnSubNiveles);

}
