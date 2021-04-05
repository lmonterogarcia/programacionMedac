package models.sesion;

import models.productos.Pack;

public class PackSesion implements IPackSesion{
    
    // PK
    private Pack oPack;
    private Sesion oSesion;

    // ###Contructores###
    public PackSesion(Pack oPack, Sesion oSesion) {
        this.setoPack(oPack);
        this.setoSesion(oSesion);
    }
    // ###GET and SET###

    public Pack getoPack() {
        return oPack;
    }

    public void setoPack(Pack oPack) {
        if (oPack != null) {
            this.oPack = oPack;
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

    public boolean checkPackSesion() {
        boolean booExito = false;
        if (this.getoPack().checkPack() && this.getoSesion().checkSesion()) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((oSesion == null) ? 0 : oSesion.hashCode());
        result = prime * result + ((oPack == null) ? 0 : oPack.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        PackSesion oPackSesion = (PackSesion) obj;
        if (oPackSesion.getoPack() != null && oPackSesion.getoSesion() != null
                && this.getoPack().getiIdPack() == oPackSesion.getoPack().getiIdPack()
                && this.getoSesion().getiIdSesion() == oPackSesion.getoSesion().getiIdSesion()) {
            booExito = true;
        }
        return booExito;
    }
}
