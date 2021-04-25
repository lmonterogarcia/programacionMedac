package controllers.configuracion;

import java.sql.Connection;

import controllers.configuracion.productos.ProductoPackCtrl;
import controllers.configuracion.tipoAndEstado.TipoAndEstadoCtrl;
// import models.lugar.Lugar;
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
    public Empresa searchEmpresa(Empresa oEmpresa, Connection oConnection) {
        Empresa oEmpresaResult = oEmpresaCtrl.searchByPk(oEmpresa, oConnection);
        if (oEmpresaResult != null) {
            //Cambiar cuando se puedeimplemente lugar!!!!!!!!!!!!!!!!!!!!!! METER LA BUSQUEDA DE DATOS LUGAR
        }
        return oEmpresaResult;
    }
}
