package models.lugar;

import models.IPlantilla;

public class Pais implements IPais, IPlantilla{
    
    //PK
    private String sNombrePais;
    //N
    private short shCodigoInternacional;
    private String sSiglasPais;
    
    // ###Contructores###

    public Pais(String sNombrePais) {
        this.setsNombrePais(sNombrePais);
    }

    public Pais(String sNombrePais, short shCodigoInternacional, String sSiglasPais) {
        this.setsNombrePais(sNombrePais);
        this.setShCodigoInternacional(shCodigoInternacional);
        this.setsSiglasPais(sSiglasPais);
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

    public short getShCodigoInternacional() {
        return shCodigoInternacional;
    }

    public void setShCodigoInternacional(short shCodigoInternacional) {
        if (shCodigoInternacional >= 0 && String.valueOf(shCodigoInternacional).length() <= BMAXCODIGOINT) {
            this.shCodigoInternacional = shCodigoInternacional;
        }
    }

    public String getsSiglasPais() {
        return sSiglasPais;
    }

    public void setsSiglasPais(String sSiglasPais) {
        if (sSiglasPais != null && !sSiglasPais.isEmpty() && sSiglasPais.length() == BMAXSIGLASPAIS) {
            this.sSiglasPais = sSiglasPais;
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
            if (shCodigoInternacional >= 0) {
                sMensaje += "\n Codigo Internacional: " + this.getShCodigoInternacional();
            }
            if (sSiglasPais != null && !sSiglasPais.isEmpty()) {
                sMensaje += "\n Siglas del Pais: " + this.getsSiglasPais();
            }
        }
        return sMensaje;
    }
}
