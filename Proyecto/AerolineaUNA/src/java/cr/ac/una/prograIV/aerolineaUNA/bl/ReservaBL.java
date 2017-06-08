/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  cr.ac.una.prograIV.aerolineaUNA.bl;

import  cr.ac.una.prograIV.aerolineaUNA.domain.Reserva;
import java.util.List;

/**
 *
 * @author 
 */
public class ReservaBL extends BaseBL implements IBaseBL<Reserva, Integer>{
    public ReservaBL() {
        super();
    }
    @Override
    public void save(Reserva o) {
        if(this.findById(o.getIdReserva())== null){
            this.getDao(o.getClass().getName()).save(o);
        } else {
            System.out.println("Error el reserv a exixste");
        }
        
        
    }
    @Override
    public Reserva merge(Reserva o) {
        return (Reserva) this.getDao(o.getClass().getName()).merge(o);
    }
    @Override
    public void delete(Reserva o) {

        this.getDao(o.getClass().getName()).delete(o);
    }
    
    @Override
    public Reserva findById(Integer o) {
        return (Reserva) this.getDao(Reserva.class.getName()).findById(o);
    }
    
    @Override
    public List<Reserva> findAll(String className) {
        return this.getDao(className).findAll();
    }

    @Override
    public List<Reserva> find(String className, Integer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
