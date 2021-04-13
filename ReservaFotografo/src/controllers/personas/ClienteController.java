package controllers.personas;

import java.util.*;

import models.lugar.Lugar;
import models.personas.*;
import java.sql.*;
import java.sql.Date;

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

				String sSQL = "INSERT INTO Cliente VALUES (NULL,";
				
                if (oCliente.getoFechaCreacion() != null) {
					sSQL += "'" + Timestamp.valueOf(oCliente.getoFechaCreacion()) + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

                if (oCliente.getsDniContacto() != null) {
					sSQL += "'" + oCliente.getsDniContacto() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getsNombreContacto() != null) {
					sSQL += "'" + oCliente.getsNombreContacto() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getsApellido1Contacto() != null) {
					sSQL += "'" + oCliente.getsApellido1Contacto() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

                if (oCliente.getsApellido2Contacto() != null) {
					sSQL += "'" + oCliente.getsApellido2Contacto() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

                if (oCliente.getsTelefonoContacto() != null) {
					sSQL += "'" + oCliente.getsTelefonoContacto() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

                if (oCliente.getoFechaNacimientoContacto() != null) {
					sSQL += "'" + Date.valueOf(oCliente.getoFechaNacimientoContacto()) + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oCliente.getoUsuario().getsEmail() != null) {
					sSQL += "'" + oCliente.getoUsuario().getsEmail() + "'";
				} else {
					sSQL += "NULL";
				}

				if (oCliente.getoLugar().getiIdLugar() != -1) {
					sSQL += "'" + oCliente.getoLugar().getiIdLugar() + "'";
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
		if (oCliente != null && oCliente.getoUsuario().getsEmail() != null) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "DELETE FROM Cliente WHERE dni = ";
				if (oCliente.getoUsuario().getsEmail() != null) {
					sSQL += "'" + oCliente.getoUsuario().getsEmail() + "'";
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

                sSQL += "dniCliente = ";
                if (oCliente.getsDniContacto() != null) {
					sSQL += "'" + oCliente.getsDniContacto() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

                sSQL += "nombreCliente = ";
				if (oCliente.getsNombreContacto() != null) {
					sSQL += "'" + oCliente.getsNombreContacto() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

                sSQL += "apellido1Cliente = ";
				if (oCliente.getsApellido1Contacto() != null) {
					sSQL += "'" + oCliente.getsApellido1Contacto() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

                sSQL += "apellido2Cliente = ";
                if (oCliente.getsApellido2Contacto() != null) {
					sSQL += "'" + oCliente.getsApellido2Contacto() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

                sSQL += "telefonoCliente = ";
                if (oCliente.getsTelefonoContacto() != null) {
					sSQL += "'" + oCliente.getsTelefonoContacto() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

                sSQL += "fechaNacimiento = ";
                if (oCliente.getoFechaNacimientoContacto() != null) {
					sSQL += "'" + Date.valueOf(oCliente.getoFechaNacimientoContacto()) + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

                sSQL += "emailUsuario = ";
				if (oCliente.getoUsuario().getsEmail() != null) {
					sSQL += "'" + oCliente.getoUsuario().getsEmail() + "'";
				} else {
					sSQL += "NULL";
				}

                sSQL += "idLugar = ";
				if (oCliente.getoLugar().getiIdLugar() != -1) {
					sSQL += "'" + oCliente.getoLugar().getiIdLugar() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += ")";

				sSQL += " WHERE emailUsuario = '" + oCliente.getoUsuario().getsEmail() + "'";

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
		String sSQL = "SELECT * FROM Cliente WHERE emailUsuario = '" + oCliente.getoUsuario().getsEmail() + "'";

		try {
			Statement stmt = oConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sSQL);
			if (rs.next()) {
				oClienteResult = new Cliente(Integer.parseInt(rs.getString(1)));
				oClienteResult.setoFechaCreacion(rs.getTimestamp(2).toLocalDateTime()); 
				oClienteResult.setsDniContacto(rs.getString(3));
				oClienteResult.setsNombreContacto(rs.getString(4));
				oClienteResult.setsApellido1Contacto(rs.getString(5));
                oClienteResult.setsApellido2Contacto(rs.getString(2));
                oClienteResult.setsTelefonoContacto(rs.getString(2));
                oClienteResult.setoFechaNacimientoContacto(rs.getDate(2).toLocalDate());
				oClienteResult.setoUsuario(new Usuario(rs.getString(6)));
				oClienteResult.setoLugar(new Lugar(Integer.parseInt(rs.getString(7)), null, null));
			}
			stmt.close();
		} catch (SQLException e) {
			oClienteResult = null;
		}

		return oClienteResult;
	}

}
