package models.lugar;

import models.IPlantilla;

public class Localidad implements ILocalidad, IPlantilla{
    
    //PK
    private String sNombreLocalidad;

    // ###Contructores###

    public Localidad(String sNombreLocalidad) {
        this.setsNombreLocalidad(sNombreLocalidad);
    }

    // ###GET and SET###

    public String getsNombreLocalidad() {
        return sNombreLocalidad;
    }

    public void setsNombreLocalidad(String sNombreLocalidad) {
        if (sNombreLocalidad != null && !sNombreLocalidad.isEmpty() && sNombreLocalidad.length() <= BMAXNOMBRELUGAR) {
            this.sNombreLocalidad = sNombreLocalidad;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkLocalidad(){
        boolean booExito = false;
        if (this.getsNombreLocalidad() != null && !sNombreLocalidad.isEmpty()) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sNombreLocalidad == null) ? 0 : sNombreLocalidad.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        Localidad oLocalidad = (Localidad) obj;
        if (oLocalidad.getsNombreLocalidad() != null && this.getsNombreLocalidad() != null && this.getsNombreLocalidad().equals(oLocalidad.getsNombreLocalidad())) {
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (this.checkLocalidad()) {
            sMensaje += "\n Localidad: " + this.getsNombreLocalidad();
        }
        return sMensaje;
    }
}
