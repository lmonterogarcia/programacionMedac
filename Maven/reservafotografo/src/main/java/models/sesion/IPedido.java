package models.sesion;

import models.personas.Empresa;

public interface IPedido {

    public int getiIdPedido();
    public void setiIdPedido(int iIdPedido);
    public boolean isBooPagado();
    public void setBooPagado(boolean booPagado);
    public Empresa getoEmpresa();
    public void setoEmpresa(Empresa oEmpresa);
    
    public boolean checkPedido();
    public int hashCode();
    public boolean equals(Object obj);
    public String toString();
}
