package controllers.configuracion.tipoAndEstado;

import java.sql.*;
import com.google.gson.Gson;
import models.sesion.TipoSesion;

public class TipoSesionCtrl {
    
    // ###### CRUD ######

    public boolean executeProcedure(String json, String sFunction, Connection oConnection) {

		boolean bExito = false;

		try {

			CallableStatement statement = oConnection.prepareCall(sFunction);
			statement.setString(1, json);

			statement.execute();
			statement.close();

			bExito = true;

		} catch (SQLException ex) {
			System.out.println(ex);
            bExito = false;
		}

		return bExito;

	}


    public boolean add(TipoSesion oTipoSesion, Connection oConnection) {
        boolean bExito = false;
		if (oTipoSesion != null && oTipoSesion.checkTipoSesion()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oTipoSesion) + "]";

			bExito = executeProcedure(json, "{call tipo_sesion_create(?)}", oConnection);
			
		}
		return bExito;
    }

    public boolean remove(TipoSesion oTipoSesion, Connection oConnection) {
        boolean bExito = false;
		if (oTipoSesion != null && oTipoSesion.getsNombreTipoSesion() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oTipoSesion) + "]";

			bExito = executeProcedure(json, "{call tipo_sesion_remove(?)}", oConnection);
			
		}
		return bExito;
    }

    public boolean update(TipoSesion oTipoSesion, Connection oConnection) {
        boolean bExito = false;
		if (oTipoSesion != null && oTipoSesion.checkTipoSesion()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oTipoSesion) + "]";

			bExito = executeProcedure(json, "{call tipo_sesion_update(?)}", oConnection);
			
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
