package controllers.personas;

import java.util.*;
import models.*;
import java.sql.*;

public class ClienteController implements controllers.ICrudController<Cliente> {

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
	public boolean add(Cliente oCliente, Connection oConnection) {
		boolean bExito = false;
		if (oCliente != null && oCliente.checkCliente()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "INSERT INTO Cliente VALUES (";
				if (oCliente.getsDni() != null) {
					sSQL += "'" + oCliente.getsDni() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getsNombre() != null) {
					sSQL += "'" + oCliente.getsNombre() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getsApellidos() != null) {
					sSQL += "'" + oCliente.getsApellidos() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getsDireccion() != null) {
					sSQL += "'" + oCliente.getsDireccion() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getsTelefono() != null) {
					sSQL += "'" + oCliente.getsTelefono() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getoUsuario().getsEmail() != null) {
					sSQL += "'" + oCliente.getoUsuario().getsEmail() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getsNumeroDireccion() != null) {
					sSQL += "'" + oCliente.getsNumeroDireccion() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += ")";

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

	public boolean remove(Cliente oCliente, Connection oConnection) {
		boolean bExito = false;
		if (oCliente != null && oCliente.getsDni() != null) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "DELETE FROM Cliente WHERE dni = ";
				if (oCliente.getsDni() != null) {
					sSQL += "'" + oCliente.getsDni() + "'";
				} else {
					sSQL += "NULL";
				}

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

				sSQL += " WHERE dni = " + oCliente.getsDni();

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
		String sSQL = "SELECT * FROM Cliente WHERE sDni = '" + oCliente.getsDni() + "'";

		try {
			Statement stmt = oConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sSQL);
			if (rs.next()) {
				oClienteResult = new Cliente(oCliente.getsDni());
				oClienteResult.setsNombre(rs.getString(2));
				oClienteResult.setsApellidos(rs.getString(3));
				oClienteResult.setsDireccion(rs.getString(4));
				oClienteResult.setsTelefono(rs.getString(5));
				oClienteResult.setoUsuario(new Usuario(rs.getString(6)));
				oClienteResult.setsNumeroDireccion(rs.getString(7));
			}
			stmt.close();
		} catch (SQLException e) {
			oClienteResult = null;
		}

		return oClienteResult;
	}

}
