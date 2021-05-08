package controllers.configuracion.tipoAndEstado;

import java.sql.*;
import java.util.*;

import com.google.gson.Gson;

import controllers.Controller;
import models.sesion.Estado;
import models.sesion.EstadoTipoSesion;
import models.sesion.TipoSesion;

public class EstadoTipoSesionController {

	public boolean add(List<EstadoTipoSesion> lEstadoTipoSesion) {
		boolean bExito = false;
		if (lEstadoTipoSesion.size() > 0) {

			Gson oGson = new Gson();
			String json = "[";
			for (EstadoTipoSesion oEstadoTipoSesion : lEstadoTipoSesion) {
				json += oGson.toJson(oEstadoTipoSesion) + ",";
			}
			json = json.substring(0, (json.length() - 1)) + "]";
			bExito = Controller.executeProcedure(json, "{call estado_tiposesion_create(?)}");

		}
		return bExito;
	}

	public boolean remove(EstadoTipoSesion oEstadoTipoSesion) {
		boolean bExito = false;
		if (oEstadoTipoSesion != null && oEstadoTipoSesion.getoEstado().checkEstado()
				&& oEstadoTipoSesion.getoTipoSesion().getsNombreTipoSesion() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEstadoTipoSesion) + "]";

			bExito = Controller.executeProcedure(json, "{call estado_tiposesion_remove(?)}");

		}
		return bExito;
	}

	public boolean update(EstadoTipoSesion oEstadoTipoSesion1, EstadoTipoSesion oEstadoTipoSesion2) {
		boolean bExito = false;
		if (oEstadoTipoSesion1 != null && oEstadoTipoSesion1.getoEstado().checkEstado()
				&& oEstadoTipoSesion1.getoTipoSesion().getsNombreTipoSesion() != null
				&& oEstadoTipoSesion2.getoEstado().checkEstado()
				&& oEstadoTipoSesion2.getoTipoSesion().getsNombreTipoSesion() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEstadoTipoSesion1) + "," + oGson.toJson(oEstadoTipoSesion2) + "]";

			bExito = Controller.executeProcedure(json, "{call estado_tiposesion_update(?)}");

		}
		return bExito;
	}

	public EstadoTipoSesion searchByPk(EstadoTipoSesion oEstadoTipoSesion) {
		EstadoTipoSesion oEstadoTipoSesionResult = null;
		if (oEstadoTipoSesion != null && oEstadoTipoSesion.getoEstado().checkEstado()
				&& oEstadoTipoSesion.getoTipoSesion().getsNombreTipoSesion() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEstadoTipoSesion) + "]";
			try {

				CallableStatement statement = Controller.getConnection()
						.prepareCall("{call estado_tiposesion_search_by(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oEstadoTipoSesionResult = new EstadoTipoSesion(new Estado(rs.getString(1)),
							new TipoSesion(rs.getString(2)));
					oEstadoTipoSesionResult.setbOrden(rs.getByte(3));
				}
				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex);
			}
		}

		return oEstadoTipoSesionResult;
	}

	public TipoSesion searchByTipoSesion(TipoSesion oTipoSesion) {
		TipoSesion oTipoSesionResult = null;
		if (oTipoSesion != null && oTipoSesion.getsNombreTipoSesion() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oTipoSesion) + "]";

			try {

				CallableStatement statement = Controller.getConnection()
						.prepareCall("{call search_by(?,'sNombreTipoSesion','Estado_TipoSesion','nombreTipoSesion')}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oTipoSesionResult = new TipoSesion(rs.getString(1));
				}
				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex);
			}
		}

		return oTipoSesionResult;
	}

	public List<EstadoTipoSesion> listar(String sNombreTipoSesion) {
		String sProcedure = "{call estado_tiposesion_listar('Estado_TipoSesion','" + sNombreTipoSesion + "')}";
		List<EstadoTipoSesion> lEstadoTipoSesions = new ArrayList<EstadoTipoSesion>();
		try {

			CallableStatement statement = Controller.getConnection().prepareCall(sProcedure);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				EstadoTipoSesion oEstadoTipoSesionResult = new EstadoTipoSesion(new Estado(rs.getString(1)),
						new TipoSesion(rs.getString(2)));
				oEstadoTipoSesionResult.setbOrden(rs.getByte(3));
				lEstadoTipoSesions.add(oEstadoTipoSesionResult);
			}
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
		return lEstadoTipoSesions;
	}

	public byte getProximoOrden(TipoSesion oTipoSesion) {
		String sProcedure = "{call estado_tiposesion_proximo_orden('Estado_TipoSesion','"
				+ oTipoSesion.getsNombreTipoSesion() + "')}";
		byte bOrdenResult = 0;
		try {

			CallableStatement statement = Controller.getConnection().prepareCall(sProcedure);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				bOrdenResult = rs.getByte(1);
			}
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
		return (byte) (bOrdenResult + 1);
	}
}
