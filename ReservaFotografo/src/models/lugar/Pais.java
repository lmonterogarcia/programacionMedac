package models.lugar;

import models.IPlantilla;

public class Pais implements IPais, IPlantilla{
    
    //PK
    private String sNombrePais;
    
    // ###Contructores###

    public Pais(String sNombrePais) {
        this.setsNombrePais(sNombrePais);
    }

    // ###GET and SET###

    public String getsNombrePais() {
        return sNombrePais;
    }

    public void setsNombrePais(String sNombrePais) {
        if (sNombrePais != null && !sNombrePais.isEmpty() && sNombrePais.length() <= BMAXNOMBRELUGAR) {
            this.sNombrePais = sNombrePais;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkPais(){
        boolean booExito = false;
        if (this.getsNombrePais() != null && !sNombrePais.isEmpty()) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sNombrePais == null) ? 0 : sNombrePais.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        Pais oPais = (Pais) obj;
        if (oPais.getsNombrePais() != null && this.getsNombrePais() != null && this.getsNombrePais().equals(oPais.getsNombrePais())) {
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (this.checkPais()) {
            sMensaje += "\n Pais: " + this.getsNombrePais();
        }
        return sMensaje;
    }
}
