package controllers.configuracion;

import java.sql.*;

import com.google.gson.Gson;

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

    @Override
    public boolean remove(Empresa oEmpresa, Connection oConnection) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Empresa oEmpresa, Connection oConnection) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Empresa searchByPk(Empresa oEmpresa, Connection oConnection) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
