package models.personas;

import models.lugar.Lugar;

public class Empresa {
    
    //PK
    private String sCifNif;
    //NN
    private String sNombreEmpresa;
    private Lugar oLugar;
    //N
    private String sEmailEmpresa;
    private String sTelefonoEmrpesa;
    
    
    // ###Contructores###
    public Empresa(String sCifNif) {
        this.sCifNif = sCifNif;
    }

    public Empresa(String sCifNif, String sNombreEmpresa, Lugar oLugar) {
        this.sCifNif = sCifNif;
        this.sNombreEmpresa = sNombreEmpresa;
        this.oLugar = oLugar;
    }

    public Empresa(String sCifNif, String sNombreEmpresa, Lugar oLugar, String sEmailEmpresa, String sTelefonoEmrpesa) {
        this.sCifNif = sCifNif;
        this.sNombreEmpresa = sNombreEmpresa;
        this.oLugar = oLugar;
        this.sEmailEmpresa = sEmailEmpresa;
        this.sTelefonoEmrpesa = sTelefonoEmrpesa;
    }
    
    // ###GET and SET###
    
    public String getsCifNif() {
        return sCifNif;
    }

    public void setsCifNif(String sCifNif) {
        this.sCifNif = sCifNif;
    }

    public String getsNombreEmpresa() {
        return sNombreEmpresa;
    }

    public void setsNombreEmpresa(String sNombreEmpresa) {
        this.sNombreEmpresa = sNombreEmpresa;
    }

    public Lugar getoLugar() {
        return oLugar;
    }

    public void setoLugar(Lugar oLugar) {
        this.oLugar = oLugar;
    }

    public String getsEmailEmpresa() {
        return sEmailEmpresa;
    }

    public void setsEmailEmpresa(String sEmailEmpresa) {
        this.sEmailEmpresa = sEmailEmpresa;
    }

    public String getsTelefonoEmrpesa() {
        return sTelefonoEmrpesa;
    }

    public void setsTelefonoEmrpesa(String sTelefonoEmrpesa) {
        this.sTelefonoEmrpesa = sTelefonoEmrpesa;
    }

    // ###Metodos de esta clase###

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sCifNif == null) ? 0 : sCifNif.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empresa other = (Empresa) obj;
        if (sCifNif == null) {
            if (other.sCifNif != null)
                return false;
        } else if (!sCifNif.equals(other.sCifNif))
            return false;
        return true;
    }
}
