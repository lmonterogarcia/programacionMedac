package controllers.configuracion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

			bExito = Controller.executeProcedure(json, "{call remove(?,'sCifNif','Empresa','cifNif')}");
			
		}
		return bExito;
    }

    public boolean update(Empresa oEmpresa) {
        boolean bExito = false;
		if (oEmpresa != null && oEmpresa.checkEmpresa()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEmpresa) + "]";

			bExito = Controller.executeProcedure(json, "{call empresa_update(?)}");
			
		}
		return bExito;
    }

    public Empresa searchByPk(Empresa oEmpresa) {
        Empresa oEmpresaResult = null;
		if (oEmpresa != null && oEmpresa.getsCifNif() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEmpresa) + "]";

			try {

				CallableStatement statement = Controller.getConnection().prepareCall("{call search_by(?,'sCifNif','Empresa','cifNif')}");
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

	public List<Empresa> listar(){
		List<Empresa> lEmpresas = new ArrayList<Empresa>();
		try {

			CallableStatement statement = Controller.getConnection().prepareCall("{call listar('Empresa')}");
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Empresa oEmpresa = new Empresa(rs.getString(1));
				oEmpresa.setsNombreEmpresa(rs.getString(2));
				oEmpresa.setsEmailEmpresa(rs.getString(3));
				oEmpresa.setsTelefonoEmrpesa(rs.getString(4));
				oEmpresa.setoLugar(new Lugar(rs.getInt(5)));
				lEmpresas.add(oEmpresa);
			}
			statement.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
		return lEmpresas;
	}
    
}
