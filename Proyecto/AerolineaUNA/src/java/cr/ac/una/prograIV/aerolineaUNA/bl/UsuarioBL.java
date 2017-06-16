
package  cr.ac.una.prograIV.aerolineaUNA.bl;

import  cr.ac.una.prograIV.aerolineaUNA.domain.Usuario;
import java.util.List;


public class UsuarioBL extends BaseBL implements IBaseBL<Usuario, String>{
    public UsuarioBL() {
        super();
    }
    @Override
    public void save(Usuario o) {
        if(this.findById(o.getIdUsuario())== null){
            this.getDao(o.getClass().getName()).save(o);
        } else {
            System.out.println("Error el Usuario existe");
        }
        
        
    }
    @Override
    public Usuario merge( Usuario o) {
        return (Usuario) this.getDao(o.getClass().getName()).merge(o);
    }
    @Override
    public void delete(Usuario o) {
 
        this.getDao(o.getClass().getName()).delete(o);
    }
    
    @Override
    public Usuario findById(String o) {
        return (Usuario) this.getDao(Usuario.class.getName()).findById(o);
    }
    
    public Usuario consultarUsuario(String correo) {
        return  (Usuario) this.getDao(Usuario.class.getName()).consultar(correo);
    }
    
    public List<Usuario> find(String className, String nombre) {
        return this.getDao(className).find(nombre);
    }
    
    @Override
    public List<Usuario> findAll(String className) {
        return this.getDao(className).findAll();
    }
    
}
