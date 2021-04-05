package models.sesion;

import models.IPlantilla;

public class Estado implements IEstado, IPlantilla{
    
    //PK
    private String sNombreEstado;

    // ###Contructores###

    public Estado(String sNombreEstado) {
        setsNombreEstado(sNombreEstado);
    }

    // ###GET and SET###

    public String getsNombreEstado() {
        return sNombreEstado;
    }

    public void setsNombreEstado(String sNombreEstado) {
        if (sNombreEstado != null && !sNombreEstado.isEmpty() && sNombreEstado.length() < BMAXNOMBRE ){
            this.sNombreEstado = sNombreEstado;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkEstado() {
        boolean booExito = false;
        if (sNombreEstado != null && !sNombreEstado.isEmpty()){
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sNombreEstado == null) ? 0 : sNombreEstado.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        Estado oEstado = (Estado) obj;
        if (oEstado != null && this.getsNombreEstado() != null && this.getsNombreEstado().equals(oEstado.getsNombreEstado())) {
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (checkEstado()) {
            sMensaje +="\n## Estado ##";
            sMensaje +="\n Nombre: " + this.getsNombreEstado();
        }
        return sMensaje;
    }

}
