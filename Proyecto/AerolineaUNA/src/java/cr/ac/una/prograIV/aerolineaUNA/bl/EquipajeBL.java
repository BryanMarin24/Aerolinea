/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  cr.ac.una.prograIV.aerolineaUNA.bl;

import  cr.ac.una.prograIV.aerolineaUNA.domain.Equipaje;
import java.util.List;

/**
 *
 * @author 
 */
public class EquipajeBL extends BaseBL implements IBaseBL<Equipaje, Integer>{
    public EquipajeBL() {
        super();
    }
    @Override
    public void save(Equipaje o) {
        if(this.findById(o.getIdEquipaje())== null){
            this.getDao(o.getClass().getName()).save(o);
        } else {
            System.out.println("Error el equipaje exixste");
        }
        
        
    }
    @Override
    public Equipaje merge(Equipaje o) {
        return (Equipaje) this.getDao(o.getClass().getName()).merge(o);
    }
    @Override
    public void delete(Equipaje o) {

        this.getDao(o.getClass().getName()).delete(o);
    }
    
    @Override
    public Equipaje findById(Integer o) {
        return (Equipaje) this.getDao(Equipaje.class.getName()).findById(o);
    }
    
    @Override
    public List<Equipaje> findAll(String className) {
        return this.getDao(className).findAll();
    }

    @Override
    public List<Equipaje> find(String className, Integer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
