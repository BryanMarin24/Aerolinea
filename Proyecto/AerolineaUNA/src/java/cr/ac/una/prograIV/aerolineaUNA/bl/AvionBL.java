/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  cr.ac.una.prograIV.aerolineaUNA.bl;

import  cr.ac.una.prograIV.aerolineaUNA.domain.Avion;
import java.util.List;

/**
 *
 * 
 */
public class AvionBL extends BaseBL implements IBaseBL<Avion, String>{
    public AvionBL() {
        super();
    }
    @Override
    public void save(Avion o) {
        if(this.findById(o.getIdAvion())== null){
            this.getDao(o.getClass().getName()).save(o);
        } else {
            System.out.println("Error el Avion existe");
        }
        
        
    }
    @Override
    public Avion merge(Avion o) {
        return (Avion) this.getDao(o.getClass().getName()).merge(o);
    }
    @Override
    public void delete(Avion o) {
 
        this.getDao(o.getClass().getName()).delete(o);
    }
    
    @Override
    public Avion findById(String o) {
        return (Avion) this.getDao(Avion.class.getName()).findById(o);
    }
    
    @Override
    public List<Avion> findAll(String className) {
        return this.getDao(className).findAll();
    }

    @Override
    public List<Avion> find(String className, String o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
