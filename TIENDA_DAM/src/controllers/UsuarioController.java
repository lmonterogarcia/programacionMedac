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
	
	public boolean removeUsuario(Usuario oUsuario) {
		boolean bExito = false;
		if(oUsuario != null && oUsuario.getsEmail() != null) {
			bExito = this.getlUsuarios().remove(oUsuario); 
		}
		return bExito;
	}
	
	public boolean updateUsuario(Usuario oUsuario) {
		boolean bExito = false;
		if(oUsuario != null) {
			Usuario oUsuarioModificado = this.getlUsuarios().set(searchUsuario(oUsuario), oUsuario);
			if(oUsuarioModificado != null && oUsuarioModificado.equals(oUsuario)) {
				bExito = true;
			}
		}	
		return bExito;
	}
	
	
	public int searchUsuario(Usuario oUsuario) {
		int iPosicion = -1;
		int iContador = 0;
		while(iContador < this.getlUsuarios().size() && iPosicion == -1) {
			if(this.getlUsuarios().get(iContador).equals(oUsuario)) {
				iPosicion = iContador;
			}
			iContador++;
		}
		return iPosicion;
	}
	
	

}
