/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.dao;

import cr.ac.una.prograIV.aerolineaUNA.domain.Pago;
import cr.ac.una.prograIV.aerolineaUNA.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author juanp
 */
public class PagoDAO extends HibernateUtil implements IBaseDAO< Pago , Integer> {

    @Override
    public void save(Pago o) {
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
    public Pago merge(Pago o) {
        try {
            iniciarOperacion();
            o= (Pago)getSesion().merge(o);
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
    public void delete(Pago o) {
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
    public Pago findById(Integer id) {
        Pago pago = null;
       try {
            iniciarOperacion();
            pago=(Pago) getSesion().get(Pago.class, id);
        } 
        finally{
            getSesion().close();
        }
       return pago;
    }

    @Override
    public List<Pago> findAll() {
       List<Pago> listaPagos;
       try {
            iniciarOperacion();
            listaPagos=getSesion().createQuery("from Pago").list();
        } 
        finally{
            getSesion().close();
        }
       return listaPagos;
    }

    @Override
    public List<Pago> find(Integer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pago consultar(Integer a, Integer b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
