/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  cr.ac.una.prograIV.aerolineaUNA.bl;

import  cr.ac.una.prograIV.aerolineaUNA.domain.Pago;
import java.util.List;

/**
 *
 * @author 
 */
public class PagoBL extends BaseBL implements IBaseBL<Pago, Integer>{
    public PagoBL() {
        super();
    }
    @Override
    public void save(Pago o) {
        if(this.findById(o.getIdPago())== null){
            this.getDao(o.getClass().getName()).save(o);
        } else {
            System.out.println("Error el Pago exixste");
        }
        
        
    }
    @Override
    public Pago merge(Pago o) {
        return (Pago) this.getDao(o.getClass().getName()).merge(o);
    }
    @Override
    public void delete(Pago o) {

        this.getDao(o.getClass().getName()).delete(o);
    }
    
    @Override
    public Pago findById(Integer o) {
        return (Pago) this.getDao(Pago.class.getName()).findById(o);
    }
    
    @Override
    public List<Pago> findAll(String className) {
        return this.getDao(className).findAll();
    }

    @Override
    public List<Pago> find(String className, Integer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
