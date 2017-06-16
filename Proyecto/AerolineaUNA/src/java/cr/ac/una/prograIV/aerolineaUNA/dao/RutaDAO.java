/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.dao;

import cr.ac.una.prograIV.aerolineaUNA.domain.Ruta;
import cr.ac.una.prograIV.aerolineaUNA.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author juanp
 */
public class RutaDAO extends HibernateUtil implements IBaseDAO< Ruta, String> {

    @Override
    public void save(Ruta o) {
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
    public Ruta merge(Ruta o) {
        try {
            iniciarOperacion();
            o= (Ruta)getSesion().merge(o);
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
    public void delete(Ruta o) {
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
    public Ruta findById(String id) {
        Ruta ruta = null;
       try {
            iniciarOperacion();
            ruta=(Ruta) getSesion().get(Ruta.class, id);
        } 
        finally{
            getSesion().close();
        }
       return ruta;
    }

    @Override
    public List<Ruta> findAll() {
       List<Ruta> listaRutas;
       try {
            iniciarOperacion();
            listaRutas=getSesion().createQuery("from Ruta").list();
        } 
        finally{
            getSesion().close();
        }
       return listaRutas;
    }

    @Override
    public List<Ruta> find(String o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ruta consultar(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
