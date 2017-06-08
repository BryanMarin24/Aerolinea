/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.dao;

import cr.ac.una.prograIV.aerolineaUNA.domain.Reserva;
import cr.ac.una.prograIV.aerolineaUNA.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author juanp
 */
public class ReservaDAO extends HibernateUtil implements IBaseDAO<Reserva , Integer>{

     @Override
    public void save(Reserva o) {
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
    public Reserva merge(Reserva o) {
        try {
            iniciarOperacion();
            o= (Reserva)getSesion().merge(o);
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
    public void delete(Reserva o) {
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
    public Reserva findById(Integer id) {
        Reserva reserva = null;
       try {
            iniciarOperacion();
            reserva=(Reserva) getSesion().get(Reserva.class, id);
        } 
        finally{
            getSesion().close();
        }
       return reserva;
    }

    @Override
    public List<Reserva> findAll() {
       List<Reserva> listaReservas;
       try {
            iniciarOperacion();
            listaReservas=getSesion().createQuery("from Reserva").list();
        } 
        finally{
            getSesion().close();
        }
       return listaReservas;
    }

    @Override
    public List<Reserva> find(Integer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
