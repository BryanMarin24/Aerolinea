/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.dao;

import cr.ac.una.prograIV.aerolineaUNA.domain.Equipaje;
import cr.ac.una.prograIV.aerolineaUNA.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author juanp
 */
public class EquipajeDAO extends HibernateUtil implements IBaseDAO<Equipaje , Integer> {

     @Override
    public void save(Equipaje o) {
        try{
            iniciarOperacion();
            getSesion().save(o);
            getTransac().commit();
        }
        catch(HibernateException he){
            manejarExeption(he);
            throw he;
        }finally{
            getSesion().close();
        }
    }

    @Override
    public Equipaje merge(Equipaje o) {
        try {
            iniciarOperacion();
            o= (Equipaje)getSesion().merge(o);
            getTransac().commit();
        } catch (HibernateException he) {
            manejarExeption(he);
            throw he;
        }
        finally{
            getSesion().close();
        }
        return o;
    }

    @Override
    public void delete(Equipaje o) {
        try {
            iniciarOperacion();
            getSesion().delete(o);
            getTransac().commit();
        } catch (HibernateException he) {
           manejarExeption(he);
            throw he;
        }
        finally{
            getSesion().close();
        }
    }

    @Override
    public Equipaje findById(Integer id) {
        Equipaje equipaje = null;
       try {
            iniciarOperacion();
            equipaje=(Equipaje) getSesion().get(Equipaje.class, id);
        } 
        finally{
            getSesion().close();
        }
       return equipaje;
    }

    @Override
    public List<Equipaje> findAll() {
       List<Equipaje> listaEquipajes;
       try {
            iniciarOperacion();
            listaEquipajes=getSesion().createQuery("from Equipaje").list();
        } 
        finally{
            getSesion().close();
        }
       return listaEquipajes;
    }

    @Override
    public List<Equipaje> find(Integer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Equipaje consultar(Integer a, Integer b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
