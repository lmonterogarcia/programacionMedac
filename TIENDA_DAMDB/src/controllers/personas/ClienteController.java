package controllers.personas;

import java.util.*;
import models.*;
import java.sql.*;
import com.google.gson.*;
import controllers.Controller;

public class ClienteController {

	public boolean add(Cliente oCliente) {
		boolean bExito = false;
		if (oCliente != null && oCliente.checkCliente()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oCliente) + "]";

			bExito = Controller.executeProcedure(json, "{call cliente_create(?)}");

		}
		return bExito;
	}

	public boolean update(Cliente oCliente) {
		boolean bExito = false;
		if (oCliente != null && oCliente.checkCliente()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oCliente) + "]";

			bExito = Controller.executeProcedure(json, "{call cliente_update(?)}");
		}
		return bExito;
	}

	public List<Cliente> readAll() {
		List<Cliente> lClientes = new ArrayList<Cliente>();

		try {

			CallableStatement statement = Controller.getConnection().prepareCall("{call cliente_search_all()}");

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Cliente oCliente = new Cliente(rs.getString(1));
				oCliente.setsNombre(rs.getString(2));
				oCliente.setsApellidos(rs.getString(3));
				oCliente.setsDireccion(rs.getString(4));
				oCliente.setsTelefono(rs.getString(5));
				oCliente.setoUsuario(new Usuario(rs.getString(6)));
				oCliente.setsNumeroDireccion(rs.getString(7));
				lClientes.add(oCliente);
			}

			statement.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return lClientes;
	}

	public Cliente searchByPk(Cliente oCliente) {
		Cliente oClienteResult = null;
		if (oCliente != null && oCliente.getsDni() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oCliente) + "]";

			try {

				CallableStatement statement = Controller.getConnection().prepareCall("{call cliente_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oClienteResult = new Cliente(oCliente.getsDni());
					oClienteResult.setsNombre(rs.getString(2));
					oClienteResult.setsApellidos(rs.getString(3));
					oClienteResult.setsDireccion(rs.getString(4));
					oClienteResult.setsTelefono(rs.getString(5));
					oClienteResult.setoUsuario(new Usuario(rs.getString(6)));
					oClienteResult.setsNumeroDireccion(rs.getString(7));
				}

				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return oClienteResult;
	}

	public List<Cliente> searchByDireccion(String sDireccion) {
		List<Cliente> lClientes = new ArrayList<Cliente>();
		if (sDireccion != null && !sDireccion.equals("")) {

			String json = "[{\"sDireccion\":\"" + sDireccion + "\"}]";

			try {

				CallableStatement statement = Controller.getConnection()
						.prepareCall("{call cliente_search_by_direccion(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					Cliente oCliente = new Cliente(rs.getString(1));
					oCliente.setsNombre(rs.getString(2));
					oCliente.setsApellidos(rs.getString(3));
					oCliente.setsDireccion(rs.getString(4));
					oCliente.setsTelefono(rs.getString(5));
					oCliente.setoUsuario(new Usuario(rs.getString(6)));
					oCliente.setsNumeroDireccion(rs.getString(7));
					lClientes.add(oCliente);
				}

				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return lClientes;
	}

}
