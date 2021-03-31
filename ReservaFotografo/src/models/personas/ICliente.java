package models.personas;

import models.lugar.Lugar;

public interface ICliente extends IContacto {

    public Usuario getoUsuario();
    public void setoUsuario(Usuario oUsuario);
    public Lugar getoLugar();
    public void setoLugar(Lugar oLugar);

    public boolean checkCliente();
	public boolean equals(Object obj);
    public String toString();
}
