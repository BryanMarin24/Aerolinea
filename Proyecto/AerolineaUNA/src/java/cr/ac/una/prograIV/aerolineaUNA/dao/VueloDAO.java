/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.dao;

import cr.ac.una.prograIV.aerolineaUNA.domain.Vuelo;
import cr.ac.una.prograIV.aerolineaUNA.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author juanp
 */
public class VueloDAO extends HibernateUtil implements IBaseDAO< Vuelo , String> {

    @Override
    public void save(Vuelo o) {
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
    public Vuelo merge(Vuelo o) {
        try {
            iniciarOperacion();
            o= (Vuelo)getSesion().merge(o);
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
    public void delete(Vuelo o) {
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
    public Vuelo findById(String id) {
        Vuelo vuelo = null;
       try {
            iniciarOperacion();
            vuelo=(Vuelo) getSesion().get(Vuelo.class, id);
        } 
        finally{
            getSesion().close();
        }
       return vuelo;
    }

    @Override
    public List<Vuelo> findAll() {
       List<Vuelo> listaVuelos;
       try {
            iniciarOperacion();
            listaVuelos=getSesion().createQuery("from Vuelo").list();
        } 
        finally{
            getSesion().close();
        }
       return listaVuelos;
    }
    
}
