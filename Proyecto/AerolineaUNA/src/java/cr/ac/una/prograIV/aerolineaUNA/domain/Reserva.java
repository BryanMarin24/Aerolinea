package cr.ac.una.prograIV.aerolineaUNA.domain;
// Generated 24/04/2017 03:51:21 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;


public class Reserva  implements java.io.Serializable {


     private int idReserva;
     private Asiento asiento;
     private Pago pago;
     private Usuario usuario;
     private String observaciones;
     private Set<Vuelo> vuelos = new HashSet<Vuelo>(0);

    public Reserva() {
    }

	
    public Reserva(int idReserva, Asiento asiento, Pago pago, Usuario usuario, String observaciones) {
        this.idReserva = idReserva;
        this.asiento = asiento;
        
        this.pago = pago;
        this.usuario = usuario;
        this.observaciones = observaciones;
    }
    public Reserva(int idReserva, Asiento asiento, Pago pago, Usuario usuario, String observaciones, Set<Vuelo> vuelos) {
       this.idReserva = idReserva;
       this.asiento = asiento;
      
       this.pago = pago;
       this.usuario = usuario;
       this.observaciones = observaciones;
       this.vuelos = vuelos;
    }
   
    public int getIdReserva() {
        return this.idReserva;
    }
    
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    public Asiento getAsiento() {
        return this.asiento;
    }
    
    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }
    
    public Pago getPago() {
        return this.pago;
    }
    
    public void setPago(Pago pago) {
        this.pago = pago;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public Set<Vuelo> getVuelos() {
        return this.vuelos;
    }
    
    public void setVuelos(Set<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }




}


