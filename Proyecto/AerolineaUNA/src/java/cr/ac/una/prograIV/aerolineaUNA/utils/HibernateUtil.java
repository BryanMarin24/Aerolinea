
package cr.ac.una.prograIV.aerolineaUNA.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private Session sesion;
    private Transaction transac;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure(/*"hibernate.cfg.xml"*/).buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        transac = sesion.beginTransaction();
    }

    public void manejarExeption(HibernateException he) throws HibernateException {
        transac.rollback();
        throw new HibernateException("Se generó un error con la base de datos, por favor contácte al administrador", he);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSesion() {
        return sesion;
    }

    public void setSesion(Session sesion) {
        this.sesion = sesion;
    }

    public Transaction getTransac() {
        return transac;
    }

    public void setTransac(Transaction transac) {
        this.transac = transac;
    }

}
