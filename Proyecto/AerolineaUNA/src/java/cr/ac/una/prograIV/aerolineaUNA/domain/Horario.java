package cr.ac.una.prograIV.aerolineaUNA.domain;
// Generated 24/04/2017 03:51:21 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Horario generated by hbm2java
 */
public class Horario  implements java.io.Serializable {


     private String idHorario;
     private String dia;
     private String hora;
     private List<Ruta> rutas ;

    public Horario() {
    }

	
    public Horario(String idHorario, String dia, String hora) {
        this.idHorario = idHorario;
        this.dia = dia;
        this.hora = hora;
    }
    public Horario(String idHorario, String dia, String hora, List<Ruta> rutas) {
       this.idHorario = idHorario;
       this.dia = dia;
       this.hora = hora;
       this.rutas = rutas;
    }
   
    public String getIdHorario() {
        return this.idHorario;
    }
    
    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }
    public String getDia() {
        return this.dia;
    }
    
    public void setDia(String dia) {
        this.dia = dia;
    }
    public String getHora() {
        return this.hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    public List<Ruta> getRutas() {
        return this.rutas;
    }
    
    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
    }




}

