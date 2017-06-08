/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.dao;

import cr.ac.una.prograIV.aerolineaUNA.domain.Asiento;
import cr.ac.una.prograIV.aerolineaUNA.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author juanp
 */
public class AsientoDAO extends HibernateUtil implements IBaseDAO< Asiento, String>{

    @Override
    public void save(Asiento o) {
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
    public Asiento merge(Asiento o) {
        try {
            iniciarOperacion();
            o= (Asiento)getSesion().merge(o);
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
    public void delete(Asiento o) {
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
    public Asiento findById(String id) {
        Asiento asiento = null;
       try {
            iniciarOperacion();
            asiento=(Asiento) getSesion().get(Asiento.class, id);
        } 
        finally{
            getSesion().close();
        }
       return asiento;
    }

    @Override
    public List<Asiento> findAll() {
       List<Asiento> listaAsientos;
       try {
            iniciarOperacion();
            listaAsientos=getSesion().createQuery("from Asiento").list();
        } 
        finally{
            getSesion().close();
        }
       return listaAsientos;
    }

    @Override
    public List<Asiento> find(String o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
