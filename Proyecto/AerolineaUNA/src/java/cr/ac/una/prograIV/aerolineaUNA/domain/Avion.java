package cr.ac.una.prograIV.aerolineaUNA.domain;
// Generated 24/04/2017 03:51:21 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Avion 
 */
public class Avion  implements java.io.Serializable {


     private String idAvion;
     private String modelo;
     private String ano;
     private String marca;
     private int cantidadFila;
     private int cantidadAsientosFila;
     private List<Ruta> rutas ;

    public Avion() {
    }

	
    public Avion(String idAvion,String ano, String modelo, String marca, int cantidadFila, int cantidadAsientosFila) {
        this.idAvion = idAvion;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.cantidadFila = cantidadFila;
        this.cantidadAsientosFila = cantidadAsientosFila;
    }
    public Avion(String idAvion, String ano, String modelo, String marca,int cantidadFila, int cantidadAsientosFila, List<Ruta> rutas) {
       this.idAvion = idAvion;
       this.modelo = modelo;
       this.marca = marca;
       this.ano = ano;
       this.cantidadFila = cantidadFila;
       this.cantidadAsientosFila = cantidadAsientosFila;
       this.rutas = rutas;
    }
   
    public String getIdAvion() {
        return this.idAvion;
    }
    
    public void setIdAvion(String idAvion) {
        this.idAvion = idAvion;
    }
   
    
   
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
     public String getAno() {
        return this.ano;
    }
    
    public void setAno(String ano) {
        this.ano = ano;
    }
    public int getCantidadFila() {
        return this.cantidadFila;
    }
    
    public void setCantidadFila(int cantidadFila) {
        this.cantidadFila = cantidadFila;
    }
    public int getCantidadAsientosFila() {
        return this.cantidadAsientosFila;
    }
    
    public void setCantidadAsientosFila(int cantidadAsientosFila) {
        this.cantidadAsientosFila = cantidadAsientosFila;
    }
    public List<Ruta> getRutas() {
        return this.rutas;
    }
    
    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
    }




}


