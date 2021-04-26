package controllers.personas;

import models.Cliente;
import models.Usuario;

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

    public Cliente searchCliente(Cliente oCliente) {
        Cliente oClienteRes = oClientCtrl.searchByPk(oCliente);
        if (oClienteRes != null) {
            Usuario oUsuario = oUserCtrl.searchByPk(oClienteRes.getoUsuario());
            oClienteRes.setoUsuario(oUsuario);
        }
        return oClienteRes;
    }

    public Usuario searchUserByDni(Cliente oCliente) {
        Cliente oClienteRes = oClientCtrl.searchByPk(oCliente);
        Usuario oUsuario = null;
        if (oClienteRes != null) {
            oUsuario = oUserCtrl.searchByPk(oClienteRes.getoUsuario());
        }
        return oUsuario;
    }
}
