package controllers.personas;

import models.personas.*;

public class PersonasController {

    private UsuarioController oUserCtrl;
    private ClienteController oClientCtrl;
    //private FotografoController oFotografoCtrl;
    //private ParticipanteController oParticipanteCtrl;

    public PersonasController() {
        oUserCtrl = new UsuarioController();
        oClientCtrl = new ClienteController();
        //oFotografoCtrl = new FotografoController();
        //oParticipanteCtrl = new ParticipanteController();
    }

    public UsuarioController getoUserCtrl() {
        return oUserCtrl;
    }

    public ClienteController getoClientCtrl() {
        return oClientCtrl;
    }

    /*
    public FotografoController getoFotografoCtrl() {
        return oFotografoCtrl;
    }

    public ParticipanteController getoParticipanteCtrl() {
        return oParticipanteCtrl;
    }
    */

    /*
     * # CONTROLLER METHODS CLIENTE Y USUARIO
     */
    public boolean addCliente(Cliente oCliente) {
        boolean bExito = false;
        if (oUserCtrl.add(oCliente.getoUsuario())) {
            if (oClientCtrl.add(oCliente)) {
                bExito = true;
            } else {
                oUserCtrl.remove(oCliente.getoUsuario());
            }
        }
        return bExito;
    }

    public boolean removeCliente(Cliente oCliente) {
        boolean bExito = false;
        Cliente oClienteRecuperado = searchCliente(oCliente);
        if (oClientCtrl.remove(oCliente)) {
            if (oUserCtrl.remove(oClienteRecuperado.getoUsuario())) {
                bExito = true;
            } else {
                addCliente(oClienteRecuperado);
            }
            
        }
        return bExito;
    }

    public boolean updateCliente(Cliente oCliente) {
		boolean booExito = false;
		if (getoClientCtrl().update(oCliente)) {
			if (getoUserCtrl().update(oCliente.getoUsuario())) {
				booExito = true;
			}
		}
		return booExito;
	}

    public Cliente searchCliente(Cliente oCliente) {
        return oClientCtrl.searchByPk(oCliente);
    }

    public Usuario searchUsuario(Cliente oCliente) {
        return oUserCtrl.searchByPk(oCliente.getoUsuario());
    }



    /*
     * # CONTROLLER METHODS FOTOGRAFO

    public boolean addFotografo(Fotografo oFotografo) {
        return oFotografoCtrl.add(oFotografo);
    }

    public boolean removeFotografo(Fotografo oFotografo) {
        return oFotografoCtrl.remove(oFotografo);
    }

    public Fotografo searchFotografo(Fotografo oFotografo) {
        return oFotografoCtrl.searchByPk(oFotografo);
    }*/



    /*
    * # CONTROLLER METHODS PARTICIPANTE
    
    public boolean addParticipante(Participante oParticipante) {
        return oParticipanteCtrl.add(oParticipante);
    }

    public boolean removeParticipante(Participante oParticipante) {
        return oParticipanteCtrl.remove(oParticipante);
    }

    public Participante searchParticipante(Participante oParticipante) {
        return oParticipanteCtrl.searchByPk(oParticipante);
    }*/

    
}
