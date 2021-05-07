package controllers.configuracion.tipoAndEstado;

public class TipoAndEstadoController {
    
    private EstadoController oEstadoCtrl;
    private TipoSesionController oTipoSesionCtrl;

    public TipoAndEstadoController(){

        oEstadoCtrl = new EstadoController();
        oTipoSesionCtrl = new TipoSesionController();
    }

    public EstadoController getoEstadoCtrl() {
        return oEstadoCtrl;
    }

    public TipoSesionController getoTipoSesionCtrl() {
        return oTipoSesionCtrl;
    }
}
