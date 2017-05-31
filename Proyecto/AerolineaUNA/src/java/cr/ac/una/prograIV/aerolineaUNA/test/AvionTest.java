/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.test;

import cr.ac.una.prograIV.aerolineaUNA.bl.AvionBL;
import cr.ac.una.prograIV.aerolineaUNA.bl.EquipajeBL;
import cr.ac.una.prograIV.aerolineaUNA.dao.AvionDAO;
import cr.ac.una.prograIV.aerolineaUNA.domain.Avion;
import cr.ac.una.prograIV.aerolineaUNA.domain.Equipaje;
import java.util.List;


public class AvionTest {
   public static void main(String[]arg){
     
  Avion a =new Avion("002747","Boe","Boeing","Boeing",4,10);
  AvionDAO aDao =new AvionDAO();
  aDao.save(a);
   
 //  Avion a =new Avion("001",360,"737","Boeing",4,40);
   // AvionDAO aDao =new AvionDAO();
  //aDao.merge(a);
    
//    Avion a =new Avion();
//    a.setIdAvion("002");
//    AvionDAO aDao =new AvionDAO();
//    aDao.delete(a);
   
//    AvionDAO aDao =new AvionDAO();
//    Avion a = aDao.findById("001");
//    System.out.println(a.getIdAvion()+ " " + a.getIdCapacidad() + " " + a.getModelo() + " " + a.getMarca()+ " " + a.getCantidadFila() + " " + a.getCantidadAsientosFila());
//    
/*
    AvionDAO aDao =new AvionDAO();
    List<Avion> a = aDao.findAll();
    for(int i= 0;i<a.size();i++)
     System.out.println(a.get(i).getIdAvion()+ " " + a.get(i).getIdCapacidad() + " " + a.get(i).getModelo() + " " + a.get(i).getMarca()+ " " + a.get(i).getCantidadFila() + " " + a.get(i).getCantidadAsientosFila());
*/
  
//        AvionBL bl = new AvionBL();
//        Avion p1 = new  Avion("004",360,"747","Boeing",4,40);
//        bl.merge(p1);
//          
//          
    
        
      
    }
}
