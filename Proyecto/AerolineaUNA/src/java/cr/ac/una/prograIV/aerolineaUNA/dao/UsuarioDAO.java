/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.dao;

import cr.ac.una.prograIV.aerolineaUNA.domain.Usuario;
import cr.ac.una.prograIV.aerolineaUNA.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author juanp
 */
public class UsuarioDAO extends HibernateUtil implements IBaseDAO<Usuario,String>{

    @Override
    public void save(Usuario o) {
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
    public Usuario merge(Usuario o) {
        try {
            iniciarOperacion();
            o= (Usuario)getSesion().merge(o);
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
    public void delete(Usuario o) {
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
    public Usuario findById(String id) {
        Usuario usuario = null;
       try {
            iniciarOperacion();
            usuario=(Usuario) getSesion().get(Usuario.class, id);
        } 
        finally{
            getSesion().close();
        }
       return usuario;
    }

    @Override
    public List<Usuario> findAll() {
       List<Usuario> listaUsuarios;
       try {
            iniciarOperacion();
            listaUsuarios=getSesion().createQuery("from Usuario").list();
        } 
        finally{
            getSesion().close();
        }
       return listaUsuarios;
    }

    @Override
    public List<Usuario> find(String o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario consultar(String a, String b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
