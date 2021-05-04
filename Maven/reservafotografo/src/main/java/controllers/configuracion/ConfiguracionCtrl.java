package controllers.configuracion;

import controllers.configuracion.lugar.LugarCtrl;
import controllers.configuracion.productos.ProductoPackCtrl;
import controllers.configuracion.tipoAndEstado.TipoAndEstadoCtrl;
import models.lugar.Lugar;
import models.personas.Empresa;

public class ConfiguracionCtrl {
    
    private EmpresaCtrl oEmpresaCtrl;
    private LugarCtrl oLugarCtrl;
    private ProductoPackCtrl oProductoPackCtrl;
    private TipoAndEstadoCtrl oTipoAndEstadoCtrl;

    public ConfiguracionCtrl(){

        oEmpresaCtrl = new EmpresaCtrl();
        oLugarCtrl = new LugarCtrl();
        oProductoPackCtrl = new ProductoPackCtrl();
        oTipoAndEstadoCtrl = new TipoAndEstadoCtrl();
    }

    public EmpresaCtrl getoEmpresaCtrl() {
        return oEmpresaCtrl;
    }

    public LugarCtrl getoLugarCtrl() {
        return oLugarCtrl;
    }

    public ProductoPackCtrl getoProductoPackCtrl() {
        return oProductoPackCtrl;
    }

    public TipoAndEstadoCtrl getoTipoAndEstadoCtrl() {
        return oTipoAndEstadoCtrl;
    }
    
    /*
     * # CONTROLLER METHODS EMPRESA
     */
    public boolean createEmpresa(Empresa oEmpresa){
        boolean booExito = false;
        int iIdLugar;
        Lugar oLugar = oLugarCtrl.searchByDireccion(oEmpresa.getoLugar());

        if (oLugar != null) {
            iIdLugar = oLugar.getiIdLugar();
        } else {
            iIdLugar = oLugarCtrl.add(oEmpresa.getoLugar());
        }

        if (iIdLugar > 0) {
            oEmpresa.getoLugar().setiIdLugar(iIdLugar);
            if (oEmpresaCtrl.add(oEmpresa)) {
                booExito = true;
            }
        }
        return booExito;
    }

    public boolean updateEmpresa(Empresa oEmpresa) {
        boolean booExito = false;
        Lugar oLugar = oLugarCtrl.searchByDireccion(oEmpresa.getoLugar());

        if (oLugar == null) {
            oLugarCtrl.update(oEmpresa.getoLugar());
        } 
            if (oEmpresaCtrl.update(oEmpresa)) {
                booExito = true;
            }
        return booExito;
    }

    public Empresa searchEmpresa(Empresa oEmpresa) {
        Empresa oEmpresaResult = oEmpresaCtrl.searchByPk(oEmpresa);
        if (oEmpresaResult != null) {
            oEmpresaResult.setoLugar(oLugarCtrl.searchByPk(oEmpresaResult.getoLugar()));
        }
        return oEmpresaResult;
    }
}
