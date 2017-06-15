/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.dao;

import cr.ac.una.prograIV.aerolineaUNA.domain.Horario;
import cr.ac.una.prograIV.aerolineaUNA.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author juanp
 */
public class HorarioDAO extends HibernateUtil implements IBaseDAO<Horario , String>{

    @Override
    public void save(Horario o) {
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
    public Horario merge(Horario o) {
        try {
            iniciarOperacion();
            o= (Horario)getSesion().merge(o);
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
    public void delete(Horario o) {
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
    public Horario findById(String id) {
        Horario horario = null;
       try {
            iniciarOperacion();
            horario=(Horario) getSesion().get(Horario.class, id);
        } 
        finally{
            getSesion().close();
        }
       return horario;
    }

    @Override
    public List<Horario> findAll() {
       List<Horario> listaHorarios;
       try {
            iniciarOperacion();
            listaHorarios=getSesion().createQuery("from Horario").list();
        } 
        finally{
            getSesion().close();
        }
       return listaHorarios;
    }

    @Override
    public List<Horario> find(String o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Horario consultar(String a, String b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
