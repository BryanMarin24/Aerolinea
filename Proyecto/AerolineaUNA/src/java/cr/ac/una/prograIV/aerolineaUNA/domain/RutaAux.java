/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.domain;

/**
 *
 * @author juanp
 */
public class RutaAux  implements java.io.Serializable {


     private String idRuta;
     private String idAvion;
     private String idHorario;
     private String origen;
     private String destino;
     private float costo;
     private int horas;
     private int minutos;
     

    public RutaAux() {
    }

	
    public RutaAux(String idRuta, String avion, String horario, String origen, String destino, float costo,int horas,int minutos) {
        this.idRuta = idRuta;
        this.idAvion = avion;
        this.idHorario = horario;
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
        this.horas = horas;
        this.minutos = minutos;
    }
}
