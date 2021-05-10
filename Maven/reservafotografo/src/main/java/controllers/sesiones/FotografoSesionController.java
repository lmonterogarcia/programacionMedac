package controllers.sesiones;

import java.sql.*;
import java.util.*;

import com.google.gson.Gson;

import controllers.Controller;
import models.personas.Fotografo;
import models.sesion.FotografoSesion;
import models.sesion.Sesion;

public class FotografoSesionController {
    public boolean add(List<FotografoSesion> lFotografoSesion) {
		boolean bExito = false;
		if (lFotografoSesion.size() > 0) {

			Gson oGson = new Gson();
			String json = "[";
			for (FotografoSesion oFotografoSesion : lFotografoSesion) {
				json += oGson.toJson(oFotografoSesion) + ",";
			}
			json = json.substring(0, (json.length() - 1)) + "]";
			bExito = Controller.executeProcedure(json, "{call fotografo_sesion_create(?)}");

		}
		return bExito;
	}

	public boolean remove(FotografoSesion oFotografoSesion) {
		boolean bExito = false;
		if (oFotografoSesion != null && oFotografoSesion.getoSesion().getiIdSesion() > 0
				&& oFotografoSesion.getoFotografo().getsNombreFotografo() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oFotografoSesion) + "]";

			bExito = Controller.executeProcedure(json, "{call fotografo_sesion_remove(?)}");

		}
		return bExito;
	}

	public FotografoSesion searchByPk(FotografoSesion oFotografoSesion) {
		FotografoSesion oFotografoResult = null;
		if (oFotografoSesion != null && oFotografoSesion.getoSesion().getiIdSesion() > 0
				&& oFotografoSesion.getoFotografo().getsNombreFotografo() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oFotografoSesion) + "]";
			try {

				CallableStatement statement = Controller.getConnection()
						.prepareCall("{call fotografo_sesion_search_by(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oFotografoResult = new FotografoSesion(new Fotografo(rs.getString(2)), new Sesion(rs.getInt(1)));
				}
				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex);
			}
		}

		return oFotografoResult;
	}

	public Sesion searchBySesion(Sesion oSesion) {
		Sesion oSesionResult = null;
		if (oSesion != null && oSesion.getiIdSesion() > 0) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oSesion) + "]";

			try {

				CallableStatement statement = Controller.getConnection()
						.prepareCall("{call search_by(?,'iIdSesion','Sesion_Fotografo','idSesion')}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oSesionResult = new Sesion(rs.getInt(1));
				}
				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex);
			}
		}

		return oSesionResult;
	}

	public List<FotografoSesion> listar(String iIdSesion) {
		String sProcedure = "{call fotografo_sesion_listar('Sesion_Fotografo','" + iIdSesion + "')}";
		List<FotografoSesion> lFotografoSesions = new ArrayList<FotografoSesion>();
		try {

			CallableStatement statement = Controller.getConnection().prepareCall(sProcedure);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				FotografoSesion oFotografoSesion = new FotografoSesion(new Fotografo(rs.getString(2)), new Sesion(rs.getInt(1)));
				lFotografoSesions.add(oFotografoSesion);
			}
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
		return lFotografoSesions;
	}
}
