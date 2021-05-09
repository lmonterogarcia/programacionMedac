package controllers.configuracion;

import controllers.configuracion.lugar.LugarController;
import controllers.configuracion.productos.ProductosController;
import controllers.configuracion.tipoAndEstado.TipoAndEstadoController;
import models.lugar.Lugar;
import models.personas.Empresa;

public class ConfiguracionController {
    
    private EmpresaController oEmpresaCtrl;
    private LugarController oLugarCtrl;
    private ProductosController oProductosCtrl;
    private TipoAndEstadoController oTipoAndEstadoCtrl;

    public ConfiguracionController(){

        oEmpresaCtrl = new EmpresaController();
        oLugarCtrl = new LugarController();
        oProductosCtrl = new ProductosController();
        oTipoAndEstadoCtrl = new TipoAndEstadoController();
    }

    public EmpresaController getoEmpresaCtrl() {
        return oEmpresaCtrl;
    }

    public LugarController getoLugarCtrl() {
        return oLugarCtrl;
    }

    public ProductosController getoProductosCtrl() {
        return oProductosCtrl;
    }

    public TipoAndEstadoController getoTipoAndEstadoCtrl() {
        return oTipoAndEstadoCtrl;
    }
    
    /*
     * # CONTROLLER METHODS EMPRESA
     */
    public boolean createEmpresa(Empresa oEmpresa){

        boolean booExito = false;
		int iIdLugar;
		Lugar oLugar;

		if (oEmpresa.getoLugar() != null) {
			oLugar = getoLugarCtrl().searchByDireccion(oEmpresa.getoLugar());
			if (oLugar != null) {
				iIdLugar = oLugar.getiIdLugar();
			} else {
				iIdLugar = getoLugarCtrl().add(oEmpresa.getoLugar());
			}

			oEmpresa.getoLugar().setiIdLugar(iIdLugar);
		}

		if (getoEmpresaCtrl().add(oEmpresa)) {
			booExito = true;
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

    public boolean addSitio(Lugar oLugar) {
        boolean booExito = false;
        int idLugar = getoLugarCtrl().add(oLugar);
        if (idLugar > 0) {
            booExito = true;
        }
        return booExito;
    }
}
