/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.test;

import cr.ac.una.prograIV.aerolineaUNA.bl.VueloBL;
import cr.ac.una.prograIV.aerolineaUNA.dao.ReservaDAO;
import cr.ac.una.prograIV.aerolineaUNA.dao.VueloDAO;
import cr.ac.una.prograIV.aerolineaUNA.domain.Asiento;
import cr.ac.una.prograIV.aerolineaUNA.domain.Avion;
import cr.ac.una.prograIV.aerolineaUNA.domain.Equipaje;
import cr.ac.una.prograIV.aerolineaUNA.domain.Horario;
import cr.ac.una.prograIV.aerolineaUNA.domain.Pago;
import cr.ac.una.prograIV.aerolineaUNA.domain.Reserva;
import cr.ac.una.prograIV.aerolineaUNA.domain.Ruta;
import cr.ac.una.prograIV.aerolineaUNA.domain.Usuario;
import cr.ac.una.prograIV.aerolineaUNA.domain.Vuelo;
import java.util.Date;

public class VueloTest {

    public static void main(String[] args) {
        /*Avion a = new Avion("002", 360, "747", "Boeing", 4, 40);
        Horario h = new Horario("003", new Date(), new Date());
        Ruta r = new Ruta("004", a, h, "costa rica", "mexico", 100);

        Asiento as = new Asiento("4f", "a", 10, "economica", true);
        Equipaje e = new Equipaje(1, 2);
        Pago p = new Pago(2, 550, "dolar", "paypal");
        Usuario u = new Usuario("002", "pass", "bryan", "marin", "leon",
                "brmarin@gmail.com", new Date(), "heredia", 22448877, "86568543", "administrador");
        Reserva reserva = new Reserva(1, as, e, p, u, "vuelo1");
        
        Vuelo v = new Vuelo("003", reserva, r);
        VueloDAO vDao = new VueloDAO();
        vDao.save(v);*/
        
        /*VueloBL bl = new VueloBL();
        Avion a = new Avion("002", 360, "747", "Boeing", 4, 40);
        Horario h = new Horario("003", new Date(), new Date());
        Ruta r = new Ruta("004", a, h, "costa rica", "mexico", 100);

        Asiento as = new Asiento("4f", "a", 10, "economica", true);
        Equipaje e = new Equipaje(1, 2);
        Pago p = new Pago(2, 550, "dolar", "paypal");
        Usuario u = new Usuario("002", "pass", "bryan", "marin", "leon",
                "brmarin@gmail.com", new Date(), "heredia", 22448877, "86568543", "administrador");
        Reserva reserva = new Reserva(1, as, e, p, u, "vuelo1");
        
        Vuelo v1 = new Vuelo("003", reserva, r);
        bl.merge(v1);*/
    }
}
