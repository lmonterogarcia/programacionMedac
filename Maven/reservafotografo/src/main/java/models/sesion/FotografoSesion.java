package models.sesion;

import models.personas.Fotografo;

public class FotografoSesion implements IFotografoSesion {

    // PK
    private Fotografo oFotografo;
    private Sesion oSesion;

    // ###Contructores###
    public FotografoSesion(Fotografo oFotografo, Sesion oSesion) {
        this.setoFotografo(oFotografo);
        this.setoSesion(oSesion);
    }
    // ###GET and SET###

    public Fotografo getoFotografo() {
        return oFotografo;
    }

    public void setoFotografo(Fotografo oFotografo) {
        if (oFotografo != null) {
            this.oFotografo = oFotografo;
        }
    }

    public Sesion getoSesion() {
        return oSesion;
    }

    public void setoSesion(Sesion oSesion) {
        if (oSesion != null) {
            this.oSesion = oSesion;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkFotografoSesion() {
        boolean booExito = false;
        if (this.getoFotografo().checkFotografo() && this.getoSesion().checkSesion()) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((oSesion == null) ? 0 : oSesion.hashCode());
        result = prime * result + ((oFotografo == null) ? 0 : oFotografo.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        FotografoSesion oFotografoSesion = (FotografoSesion) obj;
        if (oFotografoSesion.getoFotografo() != null && oFotografoSesion.getoSesion() != null && this != null
                && oFotografoSesion.getoFotografo().equals(this.getoFotografo())
                && oFotografoSesion.getoSesion().equals(this.getoSesion())) {
            booExito = true;
        }
        return booExito;
    }
}
