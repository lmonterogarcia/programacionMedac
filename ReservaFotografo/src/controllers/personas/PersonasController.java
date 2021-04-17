package controllers.personas;

import models.personas.*;
import java.sql.*;

public class PersonasController {

    private UsuarioController oUserCtrl;
    private ClienteController oClientCtrl;
    private FotografoController oFotografoCtrl;
    private ParticipanteController oParticipanteCtrl;

    public PersonasController() {
        oUserCtrl = new UsuarioController();
        oClientCtrl = new ClienteController();
        oFotografoCtrl = new FotografoController();
        oParticipanteCtrl = new ParticipanteController();
    }

    public UsuarioController getoUserCtrl() {
        return oUserCtrl;
    }
    public FotografoController getoFotografoCtrl() {
        return oFotografoCtrl;
    }

    public ClienteController getoClientCtrl() {
        return oClientCtrl;
    }

    public ParticipanteController getoParticipanteCtrl() {
        return oParticipanteCtrl;
    }

    /*
     * # CONTROLLER METHODS CLIENTE Y USUARIO
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

    public Usuario searchUsuario(Cliente oCliente, Connection oConnection) {
        return oUserCtrl.searchByPk(oCliente.getoUsuario(), oConnection);
    }



    /*
     * # CONTROLLER METHODS FOTOGRAFO
     */
    public boolean addFotografo(Fotografo oFotografo, Connection oConnection) {
        return oFotografoCtrl.add(oFotografo, oConnection);
    }

    public boolean removeFotografo(Fotografo oFotografo, Connection oConnection) {
        return oFotografoCtrl.remove(oFotografo, oConnection);
    }

    public Fotografo searchFotografo(Fotografo oFotografo, Connection oConnection) {
        return oFotografoCtrl.searchByPk(oFotografo, oConnection);
    }



     /*
     * # CONTROLLER METHODS PARTICIPANTE
     */
    public boolean addParticipante(Participante oParticipante, Connection oConnection) {
        return oParticipanteCtrl.add(oParticipante, oConnection);
    }

    public boolean removeParticipante(Participante oParticipante, Connection oConnection) {
        return oParticipanteCtrl.remove(oParticipante, oConnection);
    }

    public Participante searchParticipante(Participante oParticipante, Connection oConnection) {
        return oParticipanteCtrl.searchByPk(oParticipante, oConnection);
    }

    
}
