package controllers.configuracion;

import java.sql.*;

import com.google.gson.Gson;

import controllers.*;
import models.lugar.Lugar;
import models.personas.Empresa;

public class EmpresaCtrl implements controllers.ICrudController<Empresa>{



    // ###### CRUD ######

    public boolean add(Empresa oEmpresa) {
        boolean bExito = false;
		if (oEmpresa != null && oEmpresa.checkEmpresa()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEmpresa) + "]";

			bExito = Controller.executeProcedure(json, "{call empresa_create(?)}");
			
		}
		return bExito;
    }

    public boolean remove(Empresa oEmpresa) {
        boolean bExito = false;
		if (oEmpresa != null && oEmpresa.getsCifNif() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEmpresa) + "]";

			bExito = Controller.executeProcedure(json, "{call empresa_remove(?)}");
			
		}
		return bExito;
    }

    @Override
    public boolean update(Empresa oEmpresa) {
        boolean bExito = false;
		if (oEmpresa != null && oEmpresa.checkEmpresa()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEmpresa) + "]";

			bExito = Controller.executeProcedure(json, "{call empresa_update(?)}");
			
		}
		return bExito;
    }

    @Override
    public Empresa searchByPk(Empresa oEmpresa) {
        Empresa oEmpresaResult = null;
		if (oEmpresa != null && oEmpresa.getsCifNif() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEmpresa) + "]";

			try {

				CallableStatement statement = Controller.getConnection().prepareCall("{call empresa_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oEmpresaResult = new Empresa(oEmpresa.getsCifNif());
					oEmpresaResult.setsNombreEmpresa(rs.getString(2));
					oEmpresaResult.setsEmailEmpresa(rs.getString(3));
					oEmpresaResult.setsTelefonoEmrpesa(rs.getString(4));
					oEmpresaResult.setoLugar(new Lugar(rs.getInt(5)));
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
