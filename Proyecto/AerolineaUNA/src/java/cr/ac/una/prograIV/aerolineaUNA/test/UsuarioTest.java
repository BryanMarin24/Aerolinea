/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.prograIV.aerolineaUNA.test;

import cr.ac.una.prograIV.aerolineaUNA.bl.UsuarioBL;
import cr.ac.una.prograIV.aerolineaUNA.dao.UsuarioDAO;
import cr.ac.una.prograIV.aerolineaUNA.domain.Usuario;
import java.util.Date;

public class UsuarioTest {

    public static void main(String[] args) {

        Usuario u = new Usuario("009", "pass", "bryan", "marin", "leon", "brmarin@gmail", new Date(38787), "heredia", 22448877, "86568543","gij");
        UsuarioDAO uDao = new UsuarioDAO();
        uDao.save(u);
         UsuarioBL bl = new UsuarioBL();
         Usuario p1 = new  Usuario("004", "pass", "bryan", "marin", "leon", "brmarin@gmail.com", new Date(), "heredia", 22448877, "86568543","admi");
         bl.merge(p1);
    }
}
