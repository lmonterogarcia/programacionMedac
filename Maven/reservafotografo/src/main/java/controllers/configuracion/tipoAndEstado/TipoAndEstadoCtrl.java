package controllers.configuracion.tipoAndEstado;

public class TipoAndEstadoCtrl {
    
    private EstadoCtrl oEstadoCtrl;
    private TipoSesionCtrl oTipoSesionCtrl;

    public TipoAndEstadoCtrl(){

        oEstadoCtrl = new EstadoCtrl();
        oTipoSesionCtrl = new TipoSesionCtrl();
    }

    public EstadoCtrl getoEstadoCtrl() {
        return oEstadoCtrl;
    }

    public TipoSesionCtrl getoTipoSesionCtrl() {
        return oTipoSesionCtrl;
    }
}
