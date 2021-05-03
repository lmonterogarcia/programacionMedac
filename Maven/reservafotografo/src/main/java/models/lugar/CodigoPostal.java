package models.lugar;

import models.IPlantilla;

public class CodigoPostal implements ICodigoPostal, IPlantilla {
    
    //PK
    private String sReferenciaCodigoPostal;

    // ###Contructores###

    public CodigoPostal(String sReferenciaCodigoPostal) {
        this.setsReferenciaCodigoPostal(sReferenciaCodigoPostal);
    }

    // ###GET and SET###

    public String getsReferenciaCodigoPostal() {
        return sReferenciaCodigoPostal;
    }

    public void setsReferenciaCodigoPostal(String sReferenciaCodigoPostal) {
        if (sReferenciaCodigoPostal != null && !sReferenciaCodigoPostal.isEmpty() && sReferenciaCodigoPostal.length() <= BMAXNOMBRELARGO) {
            this.sReferenciaCodigoPostal = sReferenciaCodigoPostal;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkCodigoPostal(){
        boolean booExito = false;
        if (this.getsReferenciaCodigoPostal() != null && !sReferenciaCodigoPostal.isEmpty()) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sReferenciaCodigoPostal == null) ? 0 : sReferenciaCodigoPostal.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        CodigoPostal oCodigoPostal = (CodigoPostal) obj;
        if (oCodigoPostal.getsReferenciaCodigoPostal() != null && this.getsReferenciaCodigoPostal() != null && this.getsReferenciaCodigoPostal().equals(oCodigoPostal.getsReferenciaCodigoPostal())) {
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (this.checkCodigoPostal()) {
            sMensaje += "\n Codigo postal: " + this.getsReferenciaCodigoPostal();
        }
        return sMensaje;
    }
}
