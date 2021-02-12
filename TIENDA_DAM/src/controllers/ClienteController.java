package controllers;

import java.util.*;
import models.*;

public class ClienteController implements ICrudController<Cliente> {

	private List<Cliente> lClientes;

	public ClienteController() {
		lClientes = new ArrayList<Cliente>();
	}

	public List<Cliente> getLista() {
		return lClientes;
	}

	public void setLista(List<Cliente> lClientes) {
		this.lClientes = lClientes;
	}

	/*
	 * ######## # CRUD # ########
	 */
	public boolean add(Cliente oCliente) {
		boolean bExito = false;
		if (oCliente != null && oCliente.checkCliente() && !this.getLista().contains(oCliente)) {
			this.getLista().add(oCliente);
			bExito = true;
		}
		return bExito;
	}
	
	public boolean remove(Cliente oCliente) {
		boolean bExito = false;
		if(oCliente != null && oCliente.getsDni() != null) {
			bExito = this.getLista().remove(oCliente); 
		}
		return bExito;
	}
	
	public boolean update(Cliente oCliente) {
		boolean bExito = false;
		if(oCliente != null) {
			Cliente oClienteModificado = this.getLista().set(searchPosition(oCliente), oCliente);
			if(oClienteModificado != null && oClienteModificado.equals(oCliente)) {
				bExito = true;
			}
		}	
		return bExito;
	}
	
	public List<Cliente> readAll(){
		return this.getLista();
	}
	
	
	public int searchPosition(Cliente oCliente) {
		int iPosicion = -1;
		int iContador = 0;
		while(iContador < this.getLista().size() && iPosicion == -1) {
			if(this.getLista().get(iContador).equals(oCliente)) {
				iPosicion = iContador;
			}
			iContador++;
		}
		return iPosicion;
	}
	
	

}
