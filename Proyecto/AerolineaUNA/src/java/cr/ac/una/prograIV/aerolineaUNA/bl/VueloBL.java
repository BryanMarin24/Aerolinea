/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  cr.ac.una.prograIV.aerolineaUNA.bl;

import  cr.ac.una.prograIV.aerolineaUNA.domain.Vuelo;
import java.util.List;

/**
 *
 * 
 */
public class VueloBL extends BaseBL implements IBaseBL<Vuelo, String>{
    public VueloBL() {
        super();
    }
    @Override
    public void save(Vuelo o) {
        if(this.findById(o.getIdVuelo())== null){
            this.getDao(o.getClass().getName()).save(o);
        } else {
            System.out.println("Error el Vuelo existe");
        }
        
        
    }
    @Override
    public Vuelo merge(Vuelo o) {
        return (Vuelo) this.getDao(o.getClass().getName()).merge(o);
    }
    @Override
    public void delete(Vuelo o) {
 
        this.getDao(o.getClass().getName()).delete(o);
    }
    
    @Override
    public Vuelo findById(String o) {
        return (Vuelo) this.getDao(Vuelo.class.getName()).findById(o);
    }
    
    @Override
    public List<Vuelo> findAll(String className) {
        return this.getDao(className).findAll();
    }
    
}
