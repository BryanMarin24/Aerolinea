/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.dao;

import cr.ac.una.prograIV.aerolineaUNA.domain.Avion;
import cr.ac.una.prograIV.aerolineaUNA.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;


public class AvionDAO extends HibernateUtil implements IBaseDAO<Avion,String>{

     @Override
    public void save(Avion o) {
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
    public Avion merge(Avion o) {
        try {
            iniciarOperacion();
            o= (Avion)getSesion().merge(o);
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
    public void delete(Avion o) {
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
    public Avion findById(String id) {
        Avion avion = null;
       try {
            iniciarOperacion();
            avion=(Avion) getSesion().get(Avion.class, id);
        } 
        finally{
            getSesion().close();
        }
       return avion;
    }

    @Override
    public List<Avion> findAll() {
       List<Avion> listaAviones;
       try {
            iniciarOperacion();
            listaAviones=getSesion().createQuery("from Avion").list();
        } 
        finally{
            getSesion().close();
        }
       return listaAviones;
    }

    @Override
    public List<Avion> find(String o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Avion consultar(String a, String b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
