package models.sesion;

import models.IPlantilla;

public class EstadoTipoSesion implements IEstadoTipoSesion, IPlantilla {

    // PK
    private Estado oEstado;
    private TipoSesion oTipoSesion;
    // NN
    private byte bOrden;

    // ###Contructores###

    public EstadoTipoSesion(Estado oEstado, TipoSesion oTipoSesion) {
        setoTipoSesion(oTipoSesion);
        setoEstado(oEstado);
    }

    public EstadoTipoSesion(Estado oEstado, TipoSesion oTipoSesion, byte bOrden) {
        setoTipoSesion(oTipoSesion);
        setoEstado(oEstado);
        setbOrden(bOrden);
    }

    // ###GET and SET###

    public TipoSesion getoTipoSesion() {
        return oTipoSesion;
    }

    public void setoTipoSesion(TipoSesion oTipoSesion) {
        if (oTipoSesion != null) {
            this.oTipoSesion = oTipoSesion;
        }
    }

    public Estado getoEstado() {
        return oEstado;
    }

    public void setoEstado(Estado oEstado) {
        if (oEstado != null) {
            this.oEstado = oEstado;
        }
    }

    public short getbOrden() {
        return bOrden;
    }

    public void setbOrden(byte bOrden) {
        if (bOrden > 0 && bOrden < BMAXORDEN) {
            this.bOrden = bOrden;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkEstadoTipoSesion() {
        boolean booExito = false;
        if (oEstado.checkEstado() && oTipoSesion.checkTipoSesion() && bOrden > 0 && bOrden < BMAXORDEN) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bOrden;
        result = prime * result + ((oEstado == null) ? 0 : oEstado.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        EstadoTipoSesion oEstadoTipoSesion = (EstadoTipoSesion) obj;
        if (oEstadoTipoSesion != null && this != null
                && this.getoEstado().getsNombreEstado().equals(oEstadoTipoSesion.getoEstado().getsNombreEstado())
                && this.getoTipoSesion().getsNombreTipoSesion()
                        .equals(oEstadoTipoSesion.getoTipoSesion().getsNombreTipoSesion())) {
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (checkEstadoTipoSesion()) {
            sMensaje += oTipoSesion.toString() + oEstado.toString();
            sMensaje += "\n Orden: " + this.getbOrden();
        }
        return sMensaje;
    }
}
