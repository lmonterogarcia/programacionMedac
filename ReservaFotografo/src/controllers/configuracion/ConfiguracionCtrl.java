package controllers.configuracion;

import java.sql.Connection;

import controllers.configuracion.tipoAndEstado.TipoAndEstadoCtrl;
import models.lugar.Lugar;
import models.personas.Empresa;

public class ConfiguracionCtrl {
    
    private EmpresaCtrl oEmpresaCtrl;
    private LugarCtrl oLugarCtrl;
    private ProductosCtrl oProductoCtrl;
    private TipoAndEstadoCtrl oTipoAndEstadoCtrl;

    public ConfiguracionCtrl(){

        oEmpresaCtrl = new EmpresaCtrl();
        oLugarCtrl = new LugarCtrl();
        oProductoCtrl = new ProductosCtrl();
        oTipoAndEstadoCtrl = new TipoAndEstadoCtrl();
    }

    public EmpresaCtrl getoEmpresaCtrl() {
        return oEmpresaCtrl;
    }

    public LugarCtrl getoLugarCtrl() {
        return oLugarCtrl;
    }

    public ProductosCtrl getoProductoCtrl() {
        return oProductoCtrl;
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
