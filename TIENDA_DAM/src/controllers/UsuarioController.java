package controllers;

import java.util.*;
import models.*;

public class UsuarioController implements ICrudController<Usuario> {

	private List<Usuario> lUsuarios;

	public UsuarioController() {
		lUsuarios = new ArrayList<Usuario>();
	}

	public List<Usuario> getLista() {
		return lUsuarios;
	}

	public void setLista(List<Usuario> lUsuarios) {
		this.lUsuarios = lUsuarios;
	}

	/*
	 * ######## # CRUD # ########
	 */
	public boolean add(Usuario oUsuario) {
		boolean bExito = false;
		if (oUsuario.checkUsuario() && !this.getLista().contains(oUsuario)) {
			this.getLista().add(oUsuario);
			bExito = true;
		}
		return bExito;
	}
	
	public boolean remove(Usuario oUsuario) {
		boolean bExito = false;
		if(oUsuario != null && oUsuario.getsEmail() != null) {
			bExito = this.getLista().remove(oUsuario); 
		}
		return bExito;
	}
	
	public boolean update(Usuario oUsuario) {
		boolean bExito = false;
		if(oUsuario != null) {
			Usuario oUsuarioModificado = this.getLista().set(searchPosition(oUsuario), oUsuario);
			if(oUsuarioModificado != null && oUsuarioModificado.equals(oUsuario)) {
				bExito = true;
			}
		}	
		return bExito;
	}
	
	public List<Usuario> readAll(){
		return this.getLista();
	}
	
	
	public int searchPosition(Usuario oUsuario) {
		int iPosicion = -1;
		int iContador = 0;
		while(iContador < this.getLista().size() && iPosicion == -1) {
			if(this.getLista().get(iContador).equals(oUsuario)) {
				iPosicion = iContador;
			}
			iContador++;
		}
		return iPosicion;
	}
}
