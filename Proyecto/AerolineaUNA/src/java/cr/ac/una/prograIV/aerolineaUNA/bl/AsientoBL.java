
package  cr.ac.una.prograIV.aerolineaUNA.bl;

import  cr.ac.una.prograIV.aerolineaUNA.domain.Asiento;
import java.util.List;


public class AsientoBL extends BaseBL implements IBaseBL<Asiento, String>{
    public AsientoBL() {
        super();
    }
    @Override
    public void save(Asiento o) {
        if(this.findById(o.getIdAsiento())== null){
            this.getDao(o.getClass().getName()).save(o);
        } else {
            System.out.println("Error el Asiento exixste");
        }
        
        
    }
    @Override
    public Asiento merge(Asiento o) {
        return (Asiento) this.getDao(o.getClass().getName()).merge(o);
    }
    @Override
    public void delete(Asiento o) {

        this.getDao(o.getClass().getName()).delete(o);
    }
    
    @Override
    public Asiento findById(String o) {
        return (Asiento) this.getDao(Asiento.class.getName()).findById(o);
    }
    
    @Override
    public List<Asiento> findAll(String className) {
        return this.getDao(className).findAll();
    }

    @Override
    public List<Asiento> find(String className, String o) {
        return null;
    }
    
}
