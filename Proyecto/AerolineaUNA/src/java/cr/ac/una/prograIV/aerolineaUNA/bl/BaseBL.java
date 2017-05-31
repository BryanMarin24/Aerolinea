/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.bl;

import cr.ac.una.prograIV.aerolineaUNA.dao.IBaseDAO;
import cr.ac.una.prograIV.aerolineaUNA.dao.*;
import java.util.LinkedHashMap;

/**
 *
 * @author chgari
 */
public class BaseBL {
    private final LinkedHashMap<String, IBaseDAO> daos;

    public BaseBL() {
        daos = new LinkedHashMap();
        daos.put("cr.ac.una.prograIV.aerolineaUNA.domain.Avion", new AvionDAO());
        daos.put("cr.ac.una.prograIV.aerolineaUNA.domain.Equipaje", new EquipajeDAO());
        daos.put("cr.ac.una.prograIV.aerolineaUNA.domain.Asiento", new AsientoDAO());
        daos.put("cr.ac.una.prograIV.aerolineaUNA.domain.Horario", new HorarioDAO());
        daos.put("cr.ac.una.prograIV.aerolineaUNA.domain.Pago", new PagoDAO());
        daos.put("cr.ac.una.prograIV.aerolineaUNA.domain.Reserva", new ReservaDAO());
        daos.put("cr.ac.una.prograIV.aerolineaUNA.domain.Ruta", new RutaDAO());
        daos.put("cr.ac.una.prograIV.aerolineaUNA.domain.Usuario", new UsuarioDAO());
        daos.put("cr.ac.una.prograIV.aerolineaUNA.domain.Vuelo", new VueloDAO());
    }
  
    
    public IBaseDAO getDao(String className){
        return daos.get(className);
    }
}
