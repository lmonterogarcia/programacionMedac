package models.personas;

import java.util.regex.Pattern;
import models.IPlantilla;
import models.lugar.Lugar;

public class Empresa implements IEmpresa, IPlantilla{
    
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
        setsCifNif(sCifNif);
    }

    public Empresa(String sCifNif, String sNombreEmpresa, Lugar oLugar) {
        setsCifNif(sCifNif);
        setsNombreEmpresa(sNombreEmpresa);
        setoLugar(oLugar);
    }

    public Empresa(String sCifNif, String sNombreEmpresa, String sEmailEmpresa, String sTelefonoEmrpesa, Lugar oLugar) {
        setsCifNif(sCifNif);
        setsNombreEmpresa(sNombreEmpresa);
        setoLugar(oLugar);
        setsEmailEmpresa(sEmailEmpresa);
        setsTelefonoEmrpesa(sTelefonoEmrpesa);
    }
    
    // ###GET and SET###
    
    public String getsCifNif() {
        return sCifNif;
    }

    public void setsCifNif(String sCifNif) {
        if (sCifNif != null && !sCifNif.isEmpty() && sCifNif.length() <= BMAXDNI && Pattern.matches(SPATRONDNI, sCifNif) ){
            this.sCifNif = sCifNif;
        }
        this.sCifNif = sCifNif;
    }

    public String getsNombreEmpresa() {
        return sNombreEmpresa;
    }

    public void setsNombreEmpresa(String sNombreEmpresa) {
        if (sNombreEmpresa != null && !sNombreEmpresa.isEmpty() && sNombreEmpresa.length() < BMAXNOMBRELARGO ){
            this.sNombreEmpresa = sNombreEmpresa;
        }
    }

    public Lugar getoLugar() {
        return oLugar;
    }

    public void setoLugar(Lugar oLugar) {
        if (oLugar !=null) {
            this.oLugar = oLugar;  
        }
    }

    public String getsEmailEmpresa() {
        return sEmailEmpresa;
    }

    public void setsEmailEmpresa(String sEmailEmpresa) {
        if (sEmailEmpresa != null && !sEmailEmpresa.isEmpty() && sEmailEmpresa.length() < BMAXEMAIL && Pattern.matches(SPATRONEMAIL, sEmailEmpresa)) {
            this.sEmailEmpresa = sEmailEmpresa;
        }
    }

    public String getsTelefonoEmrpesa() {
        return sTelefonoEmrpesa;
    }

    public void setsTelefonoEmrpesa(String sTelefonoEmrpesa) {
        if (sTelefonoEmrpesa != null && !sTelefonoEmrpesa.isEmpty() && sTelefonoEmrpesa.length() == BMAXTELEFONO && Pattern.matches(SPATRONTELEFONO, sTelefonoEmrpesa)){
            this.sTelefonoEmrpesa = sTelefonoEmrpesa;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkEmpresa(){
        boolean booExito = false;
        if (this.getsCifNif() != null && !this.getsCifNif().isEmpty() && this.getsNombreEmpresa() != null && !this.getsNombreEmpresa().isEmpty() && this.oLugar != null) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sCifNif == null) ? 0 : sCifNif.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        Empresa oEmpresa = (Empresa) obj;
        if (oEmpresa != null && getsCifNif() != null && getsCifNif().equals(oEmpresa.getsCifNif())) {
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (checkEmpresa()) {
            sMensaje += "## Empresa ##";
            sMensaje += "\n Cif o Nif: " + getsCifNif();
            sMensaje += "\n Nombre: " + getsNombreEmpresa();
            if (sEmailEmpresa != null) {
                sMensaje += "\n Email: " + getsEmailEmpresa();
            }
            if (sTelefonoEmrpesa != null) {
                sMensaje += "\n Telefono: " + getsTelefonoEmrpesa();
            }
            sMensaje += " #Dirección# " + oLugar.toString();
        }
        return sMensaje;
    }
}
