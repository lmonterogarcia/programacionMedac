package models.lugar;

import models.IPlantilla;

public class Provincia implements IProvincia, IPlantilla{
    
    //PK
    private String sNombreProvincia;

    // ###Contructores###

    public Provincia(String sNombreProvincia) {
        this.setsNombreProvincia(sNombreProvincia);
    }

    // ###GET and SET###

    public String getsNombreProvincia() {
        return sNombreProvincia;
    }

    public void setsNombreProvincia(String sNombreProvincia) {
        if (sNombreProvincia != null && !sNombreProvincia.isEmpty() && sNombreProvincia.length() <= BMAXNOMBRELUGAR) {
            this.sNombreProvincia = sNombreProvincia;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkProvincia(){
        boolean booExito = false;
        if (this.getsNombreProvincia() != null && !sNombreProvincia.isEmpty()) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sNombreProvincia == null) ? 0 : sNombreProvincia.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        Provincia oProvincia = (Provincia) obj;
        if (oProvincia.getsNombreProvincia() != null && this.getsNombreProvincia() != null && this.getsNombreProvincia().equals(oProvincia.getsNombreProvincia())) {
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (this.checkProvincia()) {
            sMensaje += "\n Provincia: " + this.getsNombreProvincia();
        }
        return sMensaje;
    }
}
