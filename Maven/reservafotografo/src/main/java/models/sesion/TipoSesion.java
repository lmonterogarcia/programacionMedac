package models.sesion;

import models.IPlantilla;

public class TipoSesion implements ITipoSesion, IPlantilla{
    
    //PK
    private String sNombreTipoSesion;
    //N
    private short shDuracionTipoSesion; // EN MINUTOS

    // ###Contructores###

    public TipoSesion(String sNombreTipoSesion) {
        setsNombreTipoSesion(sNombreTipoSesion);
    }

    public TipoSesion(String sNombreTipoSesion, short shDuracionTipoSesion) {
        setsNombreTipoSesion(sNombreTipoSesion);
        setShDuracionTipoSesion(shDuracionTipoSesion);
    }

    // ###GET and SET###

    public String getsNombreTipoSesion() {
        return sNombreTipoSesion;
    }

    public void setsNombreTipoSesion(String sNombreTipoSesion) {
        if (sNombreTipoSesion != null && !sNombreTipoSesion.isEmpty() && sNombreTipoSesion.length() < BMAXNOMBRELARGO){
            this.sNombreTipoSesion = sNombreTipoSesion;
        }
    }

    public short getShDuracionTipoSesion() {
        return shDuracionTipoSesion;
    }

    public void setShDuracionTipoSesion(short shDuracionTipoSesion) {
        if (shDuracionTipoSesion > 0 && shDuracionTipoSesion < SHMAXDURACION) {
            this.shDuracionTipoSesion = shDuracionTipoSesion;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkTipoSesion(){
        boolean booExito = false;
        if (sNombreTipoSesion != null) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sNombreTipoSesion == null) ? 0 : sNombreTipoSesion.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        TipoSesion oTipoSesion = (TipoSesion) obj;
        if (oTipoSesion != null && this.getsNombreTipoSesion() !=  null && this.getsNombreTipoSesion().equals(oTipoSesion.getsNombreTipoSesion())) {
            booExito = true;
        }
        return booExito;
    }

    @Override
    public String toString() {
        String sMensaje = "";
        if (checkTipoSesion()) {
            sMensaje += "\n## Tipo Sesion ##";
            sMensaje += "\n Nombre: " + this.getsNombreTipoSesion();
            if (shDuracionTipoSesion > 0 && shDuracionTipoSesion < SHMAXDURACION) {
                sMensaje += "\n Duracion: " + this.getShDuracionTipoSesion() + " minutos";
            }
        }
        return sMensaje;
    }
    
}
