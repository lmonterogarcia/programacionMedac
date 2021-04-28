package controllers.configuracion.tipoAndEstado;

import java.sql.*;
import java.util.*;

import com.google.gson.Gson;

import controllers.Controller;
import models.sesion.Estado;

public class EstadoCtrl {
    
    // ###### CRUD ######

    public boolean add(Estado oEstado) {
        boolean bExito = false;
		if (oEstado != null && oEstado.checkEstado()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEstado) + "]";

			bExito = Controller.executeProcedure(json, "{call estado_create(?)}");
			
		}
		return bExito;
    }

    public boolean remove(Estado oEstado) {
        boolean bExito = false;
		if (oEstado != null && oEstado.getsNombreEstado() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEstado) + "]";

			bExito = Controller.executeProcedure(json, "{call remove(?,'sNombreEstado','Estado','nombreEstado')}");
			
		}
		return bExito;
    }

    public boolean update(Estado oNuevoEstado, Estado oAntiguoEstado) {
        boolean bExito = false;
		if (oNuevoEstado != null && oNuevoEstado.checkEstado() && searchByPk(oNuevoEstado) == null ) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oNuevoEstado) + "," + oGson.toJson(oAntiguoEstado) + "]";

			bExito = Controller.executeProcedure(json, "{call estado_update(?)}");
			
		}
		return bExito;
    }

    public Estado searchByPk(Estado oEstado) {
        Estado oEmpresaResult = null;
		if (oEstado != null && oEstado.getsNombreEstado() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEstado) + "]";

			try {

				CallableStatement statement = Controller.getConnection().prepareCall("{call search_by(?,'sNombreEstado','Estado','nombreEstado')}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oEmpresaResult = new Estado(oEstado.getsNombreEstado());
				}
				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex);
			}
		}

		return oEmpresaResult;
    }

	public List<Estado> listar(){
		List<Estado> lEstados = new ArrayList<Estado>();
		try {

			CallableStatement statement = Controller.getConnection().prepareCall("{call listar('Estado')}");
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Estado oEstado = new Estado(rs.getString(1));
				lEstados.add(oEstado);
			}
			statement.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
		return lEstados;
	}
}
