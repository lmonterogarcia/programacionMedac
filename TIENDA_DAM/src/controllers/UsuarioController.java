package controllers;

import java.util.*;
import models.*;

public class UsuarioController {

	private List<Usuario> lUsuarios;

	public UsuarioController() {
		lUsuarios = new ArrayList<Usuario>();
	}

	public List<Usuario> getlUsuarios() {
		return lUsuarios;
	}

	public void setlUsuarios(List<Usuario> lUsuarios) {
		this.lUsuarios = lUsuarios;
	}

	/*
	 * ######## # CRUD # ########
	 */
	public boolean addUsuario(Usuario oUsuario) {
		boolean bExito = false;
		if (oUsuario.checkUsuario() && !this.getlUsuarios().contains(oUsuario)) {
			this.getlUsuarios().add(oUsuario);
			bExito = true;
		}
		return bExito;
	}

}
