package controllers.configuracion.productos;

import java.sql.*;

import com.google.gson.Gson;

import controllers.Controller;
import models.productos.Pack;

public class PackCtrl {
    
    public boolean add(Pack oPack, Connection oConnection) {
        boolean bExito = false;
		if (oPack != null && oPack.checkPack()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPack) + "]";

			bExito = Controller.executeProcedure(json, "{call pack_create(?)}", oConnection);
			
		}
		return bExito;
    }

    public boolean remove(Pack oPack, Connection oConnection) {
        boolean bExito = false;
		if (oPack != null && oPack.getsNombrePack() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPack) + "]";

			bExito = Controller.executeProcedure(json, "{call pack_remove(?)}", oConnection);
			
		}
		return bExito;
    }

    public boolean update(Pack oNuevoPack, Pack oAntiguoPack, Connection oConnection) {
        boolean bExito = false;
		if (oNuevoPack != null && oNuevoPack.checkPack() && searchByPk(oNuevoPack, oConnection) == null ) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oNuevoPack) + "," + oGson.toJson(oAntiguoPack) + "]";

			bExito = Controller.executeProcedure(json, "{call pack_update(?)}", oConnection);
			
		}
		return bExito;
    }

    public Pack searchByPk(Pack oPack, Connection oConnection) {
        Pack oEmpresaResult = null;
		if (oPack != null && oPack.getsNombrePack() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPack) + "]";

			try {

				CallableStatement statement = oConnection.prepareCall("{call pack_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oEmpresaResult = new Pack(oPack.getsNombrePack());
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
