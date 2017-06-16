package cr.ac.una.prograIV.aerolineaUNA.dao;


import java.util.List;

public interface IBaseDAO<T, K> {

    public abstract void save(T o);

    public abstract T merge(T o);

    public abstract void delete(T o);

    public abstract T findById(K key);
    
    public abstract List<T> find (K o);

    public abstract List<T> findAll();
    
    public abstract T consultar(K o);
}
