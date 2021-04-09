package models.sesion;

import models.IPlantilla;
import models.personas.Empresa;

public class Pedido implements IPedido, IPlantilla{
    
    //PK
    private int iIdPedido;
    //NN
    private boolean booPagado;
    private Empresa oEmpresa;

    // ###Contructores###

    public Pedido(int iIdPedido) {
        this.setiIdPedido(iIdPedido);
    }

    public Pedido(boolean booPagado, Empresa oEmpresa) {
        this.setiIdPedido(1);
        this.setBooPagado(booPagado);
        this.setoEmpresa(oEmpresa);
    }

    // ###GET and SET###

    public int getiIdPedido() {
        return iIdPedido;
    }

    public void setiIdPedido(int iIdPedido) {
        if (this.iIdPedido >= 0 && this.iIdPedido <= IMAXIDS) {
            this.iIdPedido = iIdPedido;
        }
    }

    public boolean isBooPagado() {
        return booPagado;
    }

    public void setBooPagado(boolean booPagado) {
        if (booPagado != this.isBooPagado()) {
            this.booPagado = booPagado;
        }
    }

    public Empresa getoEmpresa() {
        return oEmpresa;
    }

    public void setoEmpresa(Empresa oEmpresa) {
        if (oEmpresa != null) {
            this.oEmpresa = oEmpresa;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkPedido() {
        boolean booExito = false;
        if (this.getiIdPedido() > 0 && this.getiIdPedido() < IMAXIDS && this.getoEmpresa() !=  null) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + iIdPedido;
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        Pedido oPedido = (Pedido) obj;
        if (oPedido != null && this.getiIdPedido() > 0 && this.getiIdPedido() < IMAXIDS && oPedido.getiIdPedido() == this.getiIdPedido()) {
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (checkPedido()) {
            sMensaje += "\n## Pedido ##";
            sMensaje += "\n Id: " + this.getiIdPedido();
            if (this.isBooPagado()) {
                sMensaje += "\n Pagado: Si";
            } else{
                sMensaje += "\n Pagado: No";
            }
            sMensaje += oEmpresa.toString();
        }
        return sMensaje;
    }
    
}
