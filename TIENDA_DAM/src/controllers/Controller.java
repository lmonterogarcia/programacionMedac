package controllers;

import models.Cliente;

public class Controller {

	private UsuarioController oUserCtrl;
	private ClienteController oClientCtrl;
	
	public Controller() {
		oUserCtrl = new UsuarioController();
		oClientCtrl = new ClienteController();
	}

	public UsuarioController getoUserCtrl() {
		return oUserCtrl;
	}

	public ClienteController getoClientCtrl() {
		return oClientCtrl;
	}
	
	public boolean addCliente(Cliente oCliente) {
		boolean bExito = false;
		if(oUserCtrl.add(oCliente.getoUsuario())) {
			if(oClientCtrl.add(oCliente)) {
				bExito = true;
			}else {
				oUserCtrl.remove(oCliente.getoUsuario());
			}
		}		
		return bExito;	
	}
	
	public boolean removeCliente(Cliente oCliente) {
		boolean bExito = false;
		if(oUserCtrl.remove(oCliente.getoUsuario())) {
			if(oClientCtrl.remove(oCliente)) {
				bExito = true;
			}else {
				oUserCtrl.add(oCliente.getoUsuario());
			}
		}		
		return bExito;	
	}
}
