package models.sesion;

import java.time.*;

import models.IPlantilla;
import models.lugar.Lugar;
import models.personas.Cliente;

public class Sesion implements ISesion, IPlantilla{
    
    //PK
    private int iIdSesion;
    //NN
    Cliente oCliente;
    Pedido oPedido;
    //N
    LocalDate oFechaSesion;
    LocalTime oHoraSesion;
    Lugar oLugar;
    EstadoTipoSesion oEstadoTipoSesion;
    
    // ###Contructores###

    public Sesion(int iIdSesion) {
        setiIdSesion(iIdSesion);
    }

    public Sesion(int iIdSesion, Cliente oCliente, Pedido oPedido) {
        setiIdSesion(1);
        setoCliente(oCliente);
        setoPedido(oPedido);
    }

    public Sesion(int iIdSesion, Cliente oCliente, Pedido oPedido, LocalDate oFechaSesion, LocalTime oHoraSesion,
            Lugar oLugar, EstadoTipoSesion oEstadoTipoSesion) {
        setiIdSesion(1);
        setoCliente(oCliente);
        setoPedido(oPedido);
        setoFechaSesion(oFechaSesion);
        setoHoraSesion(oHoraSesion);
        setoLugar(oLugar);
        setoEstadoTipoSesion(oEstadoTipoSesion);
    }

    // ###GET and SET###

    public int getiIdSesion() {
        return iIdSesion;
    }

    public void setiIdSesion(int iIdSesion) {
        if (this.iIdSesion >= 0 && this.iIdSesion <= IMAXIDS) {
            this.iIdSesion = iIdSesion;
        }
    }

    public Cliente getoCliente() {
        return oCliente;
    }

    public void setoCliente(Cliente oCliente) {
        if (oCliente != null) {
            this.oCliente = oCliente;
        }
    }

    public Pedido getoPedido() {
        return oPedido;
    }

    public void setoPedido(Pedido oPedido) {
        if (oPedido != null) {
            this.oPedido = oPedido;
        }
    }

    public LocalDate getoFechaSesion() {
        return oFechaSesion;
    }

    public void setoFechaSesion(LocalDate oFechaSesion) {
        if (oFechaSesion != null && oFechaSesion.isAfter(LocalDate.now())) {
            this.oFechaSesion = oFechaSesion;
        }
    }

    public LocalTime getoHoraSesion() {
        return oHoraSesion;
    }

    public void setoHoraSesion(LocalTime oHoraSesion) {
        if (oHoraSesion != null && oHoraSesion.isAfter(LocalTime.now())) {
            this.oHoraSesion = oHoraSesion;
        }
    }

    public Lugar getoLugar() {
        return oLugar;
    }

    public void setoLugar(Lugar oLugar) {
        if (oLugar != null) {
            this.oLugar = oLugar;
        }
    }

    public EstadoTipoSesion getoEstadoTipoSesion() {
        return oEstadoTipoSesion;
    }

    public void setoEstadoTipoSesion(EstadoTipoSesion oEstadoTipoSesion) {
        if (oEstadoTipoSesion != null) {
            this.oEstadoTipoSesion = oEstadoTipoSesion;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkSesion(){
        boolean booExito = false;
        if (this.iIdSesion >= 0 && this.iIdSesion <= IMAXIDS && oCliente != null && oPedido != null) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + iIdSesion;
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        Sesion oSesion = (Sesion) obj;
        if (oSesion != null && this.getiIdSesion() >= 0 && this.getiIdSesion() <= IMAXIDS && oSesion.getiIdSesion() ==  this.getiIdSesion()) {
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (checkSesion()) {
            sMensaje += "\n## Sesion ##";
            sMensaje += oPedido.toString();
            sMensaje += oCliente.toString();
            if (oFechaSesion != null) {
                sMensaje += "\n Fecha: " + this.oFechaSesion.getDayOfMonth() + "/"
                + this.oFechaSesion.getMonth() + "/" + this.oFechaSesion.getYear(); 
            }
            if (oHoraSesion != null) {
                sMensaje += "\n Hora: " + oHoraSesion.getHour() + ":" + oHoraSesion.getMinute();
            }
            if (oLugar != null) {
                sMensaje += oLugar.toString();
            }
            if (oEstadoTipoSesion != null) {
                sMensaje += oEstadoTipoSesion.toString();
            }
        }
        return sMensaje;
    }
    
}
