/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.test;

import cr.ac.una.prograIV.aerolineaUNA.bl.AsientoBL;
import cr.ac.una.prograIV.aerolineaUNA.dao.AsientoDAO;
import cr.ac.una.prograIV.aerolineaUNA.domain.Asiento;
import cr.ac.una.prograIV.aerolineaUNA.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

public class AsientoTest {

    public static void main(String[]arg) {
        /*Asiento a = new Asiento("4f", "a", 10, "economica", true);
         AsientoDAO aDAO = new AsientoDAO();
         aDAO.save(a);*/

 //  Asiento a = new Asiento("3f", "a", 10, "economica", true);
        // AsientoDAO aDAO = new AsientoDAO();
        //aDao.merge(a);
//    Asiento a =new Asiento();
//    a.setIdAvion("4f");
//    AsientoDAO aDao = new AsientoDAO();
//    aDao.delete(a);
//    AsientoDAO aDao =new AsientoDAO();
//    Asiento a = aDao.findById("3f");
        //System.out.println(a.getIdAsiento() + a.getLetraFila() + a.getNumeroFila()+ a.getClase() + a.getEstado());
//    
/*
         AsientoDAO aDao = new AsientoDAO();
         List<Asiento> a = aDao.findAll();
         for(int i= 0;i<a.size();i++)
         System.out.println(a.get(i).getIdAsiento()+ " " + a.get(i).getLetraFila() + " " + a.get(i).getNumeroFila() + " " + a.get(i).getClase()+ " " + a.get(i).getEstado());
         */
        
         /*AsientoBL bl = new AsientoBL();
         Asiento p1 = new  Asiento("4f", "a", 10, "economica", true);
         bl.merge(p1);
          
         */
    }
}
