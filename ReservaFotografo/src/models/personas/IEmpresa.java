package models.personas;

import models.lugar.Lugar;

public interface IEmpresa {
    
    public String getsCifNif();
    public void setsCifNif(String sCifNif);
    public String getsNombreEmpresa();
    public void setsNombreEmpresa(String sNombreEmpresa);
    public Lugar getoLugar();
    public void setoLugar(Lugar oLugar);
    public String getsEmailEmpresa();
    public void setsEmailEmpresa(String sEmailEmpresa);
    public String getsTelefonoEmrpesa();
    public void setsTelefonoEmrpesa(String sTelefonoEmrpesa);
    
    public boolean checkEmpresa();
    public int hashCode();
    public boolean equals(Object obj);
    public String toString();
}
