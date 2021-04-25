package controllers.configuracion.tipoAndEstado;

import java.sql.*;
import com.google.gson.Gson;

import controllers.Controller;
import models.sesion.TipoSesion;

public class TipoSesionCtrl {
    
    // ###### CRUD ######

    public boolean add(TipoSesion oTipoSesion, Connection oConnection) {
        boolean bExito = false;
		if (oTipoSesion != null && oTipoSesion.checkTipoSesion()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oTipoSesion) + "]";

			bExito = Controller.executeProcedure(json, "{call tipo_sesion_create(?)}", oConnection);
			
		}
		return bExito;
    }

    public boolean remove(TipoSesion oTipoSesion, Connection oConnection) {
        boolean bExito = false;
		if (oTipoSesion != null && oTipoSesion.getsNombreTipoSesion() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oTipoSesion) + "]";

			bExito = Controller.executeProcedure(json, "{call tipo_sesion_remove(?)}", oConnection);
			
		}
		return bExito;
    }

    public boolean update(TipoSesion oTipoSesion, Connection oConnection) {
        boolean bExito = false;
		if (oTipoSesion != null && oTipoSesion.checkTipoSesion()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oTipoSesion) + "]";

			bExito = Controller.executeProcedure(json, "{call tipo_sesion_update(?)}", oConnection);
			
		}
		return bExito;
    }

    public TipoSesion searchByPk(TipoSesion oTipoSesion, Connection oConnection) {
        TipoSesion oEmpresaResult = null;
		if (oTipoSesion != null && oTipoSesion.getsNombreTipoSesion() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oTipoSesion) + "]";

			try {

				CallableStatement statement = oConnection.prepareCall("{call tipo_sesion_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oEmpresaResult = new TipoSesion(oTipoSesion.getsNombreTipoSesion());
					oEmpresaResult.setShDuracionTipoSesion(rs.getShort(2));
				}
				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex);
			}
		}

		return oEmpresaResult;
    }
}
