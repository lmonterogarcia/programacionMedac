package controllers.configuracion.tipoAndEstado;

public class TipoAndEstadoController {
    
    private EstadoController oEstadoCtrl;
    private TipoSesionController oTipoSesionCtrl;
    private EstadoTipoSesionController oEstadoTipoSesionCtrl;

    public TipoAndEstadoController(){

        oEstadoCtrl = new EstadoController();
        oTipoSesionCtrl = new TipoSesionController();
        oEstadoTipoSesionCtrl = new EstadoTipoSesionController();
    }

    public EstadoController getoEstadoCtrl() {
        return oEstadoCtrl;
    }

    public TipoSesionController getoTipoSesionCtrl() {
        return oTipoSesionCtrl;
    }

    public EstadoTipoSesionController getoEstadoTipoSesionCtrl() {
        return oEstadoTipoSesionCtrl;
    }
}
