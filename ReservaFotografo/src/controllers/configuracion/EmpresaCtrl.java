package controllers.configuracion;

import java.sql.*;

import com.google.gson.Gson;

import models.lugar.Lugar;
import models.personas.Empresa;

public class EmpresaCtrl implements controllers.ICrudController<Empresa>{



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


    public boolean add(Empresa oEmpresa, Connection oConnection) {
        boolean bExito = false;
		if (oEmpresa != null && oEmpresa.checkEmpresa()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEmpresa) + "]";

			bExito = executeProcedure(json, "{call empresa_create(?)}", oConnection);
			
		}
		return bExito;
    }

    public boolean remove(Empresa oEmpresa, Connection oConnection) {
        boolean bExito = false;
		if (oEmpresa != null && oEmpresa.getsCifNif() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEmpresa) + "]";

			bExito = executeProcedure(json, "{call empresa_remove(?)}", oConnection);
			
		}
		return bExito;
    }

    @Override
    public boolean update(Empresa oEmpresa, Connection oConnection) {
        boolean bExito = false;
		if (oEmpresa != null && oEmpresa.checkEmpresa()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEmpresa) + "]";

			bExito = executeProcedure(json, "{call empresa_update(?)}", oConnection);
			
		}
		return bExito;
    }

    @Override
    public Empresa searchByPk(Empresa oEmpresa, Connection oConnection) {
        Empresa oEmpresaResult = null;
		if (oEmpresa != null && oEmpresa.getsCifNif() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEmpresa) + "]";

			try {

				CallableStatement statement = oConnection.prepareCall("{call empresa_search_by_pk(?)}");
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
