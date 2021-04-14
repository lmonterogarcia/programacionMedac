package controllers.personas;

import models.personas.*;
import java.sql.*;

public class PersonasController {

    private UsuarioController oUserCtrl;
    private ClienteController oClientCtrl;

    public PersonasController() {
        oUserCtrl = new UsuarioController();
        oClientCtrl = new ClienteController();
    }

    public UsuarioController getoUserCtrl() {
        return oUserCtrl;
    }

    public ClienteController getoClientCtrl() {
        return oClientCtrl;
    }

    /*
     * # CONTROLLER METHODS
     */
    public boolean addCliente(Cliente oCliente, Connection oConnection) {
        boolean bExito = false;
        if (oUserCtrl.add(oCliente.getoUsuario(), oConnection)) {
            if (oClientCtrl.add(oCliente, oConnection)) {
                bExito = true;
            } else {
                oUserCtrl.remove(oCliente.getoUsuario(), oConnection);
            }
        }
        return bExito;
    }

    public boolean removeCliente(Cliente oCliente, Connection oConnection) {
        boolean bExito = false;
        Cliente oClienteRecuperado = searchCliente(oCliente, oConnection);
        if (oClientCtrl.remove(oCliente, oConnection)) {
            if (oUserCtrl.remove(oClienteRecuperado.getoUsuario(), oConnection)) {
                bExito = true;
            } else {
                addCliente(oClienteRecuperado, oConnection);
            }
            
        }
        return bExito;
    }

    public Cliente searchCliente(Cliente oCliente, Connection oConnection) {
        return oClientCtrl.searchByPk(oCliente, oConnection);
    }
}
