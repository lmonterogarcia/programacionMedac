package controllers.configuracion.tipoAndEstado;

import java.sql.*;
import java.util.*;
import com.google.gson.Gson;

import controllers.Controller;
import models.sesion.TipoSesion;

public class TipoSesionController {
    
    // ###### CRUD ######

    public boolean add(TipoSesion oTipoSesion) {
        boolean bExito = false;
		if (oTipoSesion != null && oTipoSesion.checkTipoSesion()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oTipoSesion) + "]";

			bExito = Controller.executeProcedure(json, "{call tipo_sesion_create(?)}");
			
		}
		return bExito;
    }

    public boolean remove(TipoSesion oTipoSesion) {
        boolean bExito = false;
		if (oTipoSesion != null && oTipoSesion.getsNombreTipoSesion() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oTipoSesion) + "]";

			bExito = Controller.executeProcedure(json, "{call remove(?,'sNombreTipoSesion','TipoSesion','nombreTipoSesion')}");
			
		}
		return bExito;
    }

    public boolean update(TipoSesion oTipoSesion) {
        boolean bExito = false;
		if (oTipoSesion != null && oTipoSesion.checkTipoSesion()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oTipoSesion) + "]";

			bExito = Controller.executeProcedure(json, "{call tipo_sesion_update(?)}");
			
		}
		return bExito;
    }

    public TipoSesion searchByPk(TipoSesion oTipoSesion) {
        TipoSesion oEmpresaResult = null;
		if (oTipoSesion != null && oTipoSesion.getsNombreTipoSesion() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oTipoSesion) + "]";

			try {

				CallableStatement statement = Controller.getConnection().prepareCall("{call search_by(?,'sNombreTipoSesion','TipoSesion','nombreTipoSesion')}");
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

	public List<TipoSesion> listar(){
		List<TipoSesion> lTipoSesiones = new ArrayList<TipoSesion>();
		try {

			CallableStatement statement = Controller.getConnection().prepareCall("{call listar('TipoSesion')}");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TipoSesion oTipoSesion = new TipoSesion(rs.getString(1));
				oTipoSesion.setShDuracionTipoSesion(rs.getShort(2));
				lTipoSesiones.add(oTipoSesion);
			}
			statement.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
		return lTipoSesiones;
	}
}
