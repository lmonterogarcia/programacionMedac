package controllers.sesiones;

import models.sesion.Sesion;

public class SesionesController {
    
    private SesionController oSesionCtrl;
    private PedidoController oPedidoCtrl;
    private FotografoSesionController oFotografoSesionCtrl;
    private ParticipanteSesionController oParticipanteSesionCtrl;
    private ProductoSesionController oProductoSesionCtrl;
    private PackSesionController oPackSesionCtrl;

    public SesionesController (){
        oSesionCtrl = new SesionController();
        oPedidoCtrl = new PedidoController();
        oFotografoSesionCtrl = new FotografoSesionController();
        oParticipanteSesionCtrl = new ParticipanteSesionController();
        oProductoSesionCtrl = new ProductoSesionController();
        oPackSesionCtrl = new PackSesionController();
    }

    public SesionController getoSesionCtrl() {
        return oSesionCtrl;
    }

    public PedidoController getoPedidoCtrl() {
        return oPedidoCtrl;
    }

    public FotografoSesionController getoFotografoSesionCtrl() {
        return oFotografoSesionCtrl;
    }

    public ParticipanteSesionController getoParticipanteSesionCtrl() {
        return oParticipanteSesionCtrl;
    }

    public ProductoSesionController getoProductoSesionCtrl() {
        return oProductoSesionCtrl;
    }

    public PackSesionController getoPackSesionCtrl() {
        return oPackSesionCtrl;
    }

    // ###### SESION ######

    public Sesion searchSesion(Sesion oSesion){
        Sesion oSesionResult = getoSesionCtrl().searchByPk(oSesion);
        if (oSesionResult != null) {
            oSesionResult.setoPedido(getoPedidoCtrl().searchByPk(oSesionResult.getoPedido()));
        }

        return oSesionResult;
    }
}
