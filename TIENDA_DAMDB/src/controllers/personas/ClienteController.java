package controllers.personas;

import java.util.*;
import models.*;
import java.sql.*;
import com.google.gson.*;

public class ClienteController {

	private List<Cliente> lClientes;

	public ClienteController() {
		lClientes = new ArrayList<Cliente>();
	}

	public List<Cliente> getLista() {
		return lClientes;
	}

	public void setLista(List<Cliente> lClientes) {
		this.lClientes = lClientes;
	}

	/*
	 * ######## # CRUD # ########
	 */
	public boolean executeProcedure(String json, String sFunction, Connection oConnection) {

		boolean bExito = false;

		try {

			CallableStatement statement = oConnection.prepareCall(sFunction);
			statement.setString(1, json);

			statement.execute();
			statement.close();

			bExito = true;

		} catch (SQLException ex) {
			bExito = false;
		}

		return bExito;

	}

	public boolean add(Cliente oCliente, Connection oConnection) {
		boolean bExito = false;
		if (oCliente != null && oCliente.checkCliente()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oCliente) + "]";

			bExito = executeProcedure(json, "{call cliente_create(?)}", oConnection);

		}
		return bExito;
	}

	public boolean update(Cliente oCliente, Connection oConnection) {
		boolean bExito = false;
		if (oCliente != null && oCliente.checkCliente()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "UPDATE Cliente SET ";

				sSQL += "sNombre = ";
				if (oCliente.getsNombre() != null) {
					sSQL += "'" + oCliente.getsNombre() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += "sApellidos = ";
				if (oCliente.getsApellidos() != null) {
					sSQL += "'" + oCliente.getsApellidos() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += "sDireccion = ";
				if (oCliente.getsDireccion() != null) {
					sSQL += "'" + oCliente.getsDireccion() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += "sTelefono = ";
				if (oCliente.getsTelefono() != null) {
					sSQL += "'" + oCliente.getsTelefono() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += "sEmail = ";
				if (oCliente.getoUsuario().getsEmail() != null) {
					sSQL += "'" + oCliente.getoUsuario().getsEmail() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				sSQL += "sNumeroDireccion = ";
				if (oCliente.getsNumeroDireccion() != null) {
					sSQL += "'" + oCliente.getsNumeroDireccion() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += " WHERE sDni = '" + oCliente.getsDni() + "'";

				if (stmt.executeUpdate(sSQL) > 0) {
					bExito = true;
				}
				stmt.close();
			} catch (SQLException e) {
				bExito = false;
			}
		}
		return bExito;
	}

	public List<Cliente> readAll() {
		return this.getLista();
	}

	public Cliente searchByPk(Cliente oCliente, Connection oConnection) {
		Cliente oClienteResult = null;
		if (oCliente != null && oCliente.getsDni() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oCliente) + "]";

			try {

				CallableStatement statement = oConnection.prepareCall("{call cliente_search_by_pk(?)}");
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

	public List<Cliente> searchByDireccion(String sDireccion, Connection oConnection) {
		List<Cliente> oListaClientes = new ArrayList<Cliente>();
		String sSQL = "SELECT sDni, sNombre, sApellidos FROM Cliente WHERE sDireccion = '" + sDireccion + "'";

		try {
			Statement stmt = oConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sSQL);
			while (rs.next()) {
				Cliente oClienteResult = new Cliente(rs.getString(1));
				oClienteResult.setsNombre(rs.getString(2));
				oClienteResult.setsApellidos(rs.getString(3));
				oListaClientes.add(oClienteResult);
			}
			stmt.close();
		} catch (SQLException e) {
			oListaClientes = null;
		}

		return oListaClientes;
	}

}
