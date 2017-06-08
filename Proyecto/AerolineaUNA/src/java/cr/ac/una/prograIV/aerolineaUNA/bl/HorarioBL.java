/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  cr.ac.una.prograIV.aerolineaUNA.bl;

import  cr.ac.una.prograIV.aerolineaUNA.domain.Horario;
import java.util.List;

/**
 *
 * 
 */
public class HorarioBL extends BaseBL implements IBaseBL<Horario, String>{
    public HorarioBL() {
        super();
    }
    @Override
    public void save(Horario o) {
        if(this.findById(o.getIdHorario())== null){
            this.getDao(o.getClass().getName()).save(o);
        } else {
            System.out.println("Error el horario exixste");
        }
        
        
    }
    @Override
    public Horario merge(Horario o) {
        return (Horario) this.getDao(o.getClass().getName()).merge(o);
    }
    @Override
    public void delete(Horario o) {
 
        this.getDao(o.getClass().getName()).delete(o);
    }
    
    @Override
    public Horario findById(String o) {
        return (Horario) this.getDao(Horario.class.getName()).findById(o);
    }
    
    @Override
    public List<Horario> findAll(String className) {
        return this.getDao(className).findAll();
    }

    @Override
    public List<Horario> find(String className, String o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
