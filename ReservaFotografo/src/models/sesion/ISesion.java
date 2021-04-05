package models.sesion;

import java.time.*;

import models.lugar.Lugar;
import models.personas.Cliente;

public interface ISesion {

    public int getiIdSesion();
    public void setiIdSesion(int iIdSesion);
    public Cliente getoCliente();
    public void setoCliente(Cliente oCliente);
    public Pedido getoPedido();
    public void setoPedido(Pedido oPedido);
    public LocalDate getoFechaSesion();
    public void setoFechaSesion(LocalDate oFechaSesion);
    public LocalTime getoHoraSesion();
    public void setoHoraSesion(LocalTime oHoraSesion);
    public Lugar getoLugar();
    public void setoLugar(Lugar oLugar);
    public EstadoTipoSesion getoEstadoTipoSesion();
    public void setoEstadoTipoSesion(EstadoTipoSesion oEstadoTipoSesion);

    public boolean checkSesion();
    public int hashCode();
    public boolean equals(Object obj);
    public String toString();
}
