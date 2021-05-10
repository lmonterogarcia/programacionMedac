package controllers.personas;


import models.lugar.Lugar;
import models.personas.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.google.gson.Gson;

import controllers.Controller;

public class ClienteController implements controllers.ICrudController<Cliente> {

	/*
	 * ######## # CRUD # ########
	 */
	public boolean add(Cliente oCliente) {
		boolean bExito = false;
		if (oCliente != null && oCliente.checkCliente()) {

			try {
				Statement stmt = Controller.getConnection().createStatement();

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
				sSQL += ",";

				if (oCliente.getoLugar() != null && oCliente.getoLugar().getiIdLugar() != -1) {
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
				System.out.println(e);
				bExito = false;
			}
		}
		return bExito;
	}

	public boolean remove(Cliente oCliente) {
		boolean bExito = false;
		if (oCliente != null && oCliente.getoUsuario().getsEmail() != null) {

			try {
				Statement stmt = Controller.getConnection().createStatement();

				String sSQL = "DELETE FROM Cliente WHERE emailUsuario = ";
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

	public boolean update(Cliente oCliente) {
		boolean bExito = false;
		if (oCliente != null && oCliente.checkCliente()) {

			try {
				Statement stmt = Controller.getConnection().createStatement();

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

                sSQL += "idLugar = ";
				if (oCliente.getoLugar().getiIdLugar() > 0) {
					sSQL += "'" + oCliente.getoLugar().getiIdLugar() + "'";
				} else {
					sSQL += "NULL";
				}

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

	public Cliente searchByPk(Cliente oCliente) {
		Cliente oClienteResult = null;
		String sSQL = "SELECT * FROM Cliente WHERE emailUsuario = '" + oCliente.getoUsuario().getsEmail() + "'";

		try {
			Statement stmt = Controller.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sSQL);
			if (rs.next()) {
				oClienteResult = new Cliente(rs.getInt(1));
				oClienteResult.setoFechaCreacion(rs.getTimestamp(2).toLocalDateTime()); 
				oClienteResult.setsDniContacto(rs.getString(3));
				oClienteResult.setsNombreContacto(rs.getString(4));
				oClienteResult.setsApellido1Contacto(rs.getString(5));
                oClienteResult.setsApellido2Contacto(rs.getString(6));
                oClienteResult.setsTelefonoContacto(rs.getString(7));
                oClienteResult.setoFechaNacimientoContacto(rs.getDate(8) != null ? rs.getDate(8).toLocalDate() : null);
				oClienteResult.setoUsuario(new Usuario(rs.getString(9)));
				oClienteResult.setoLugar(new Lugar(rs.getInt(10), null, null));
			}
			stmt.close();
		} catch (SQLException e) {
			oClienteResult = null;
		}

		return oClienteResult;
	}

	public Cliente searchById(Cliente oCliente) {
		
		Cliente oClienteResult = null;
		if (oCliente !=  null && oCliente.getiIdContacto() > 0) {
			String json = "[{\"iIdContacto\":" + oCliente.getiIdContacto() + "}]";

			try {
				CallableStatement statement = Controller.getConnection()
							.prepareCall("{call search_by(?,'iIdContacto','Cliente','idCliente')}");
					statement.setString(1, json);
	
					ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oClienteResult = new Cliente(rs.getInt(1));
					oClienteResult.setoFechaCreacion(rs.getTimestamp(2).toLocalDateTime()); 
					oClienteResult.setsDniContacto(rs.getString(3));
					oClienteResult.setsNombreContacto(rs.getString(4));
					oClienteResult.setsApellido1Contacto(rs.getString(5));
					oClienteResult.setsApellido2Contacto(rs.getString(6));
					oClienteResult.setsTelefonoContacto(rs.getString(7));
					oClienteResult.setoFechaNacimientoContacto(rs.getDate(8) != null ? rs.getDate(8).toLocalDate() : null);
					oClienteResult.setoUsuario(new Usuario(rs.getString(9)));
					oClienteResult.setoLugar(new Lugar(rs.getInt(10), null, null));
				}
				statement.close();
			} catch (SQLException e) {
				oClienteResult = null;
			}
		}

		return oClienteResult;
	}

	public List<Cliente> listar(){
		List<Cliente> lClientes = new ArrayList<Cliente>();
		try {

			CallableStatement statement = Controller.getConnection().prepareCall("{call listar('Cliente')}");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Cliente oCliente = new Cliente(rs.getInt(1));
				oCliente.setsDniContacto(rs.getString(3));
				oCliente.setsNombreContacto(rs.getString(4));
				oCliente.setsApellido1Contacto(rs.getString(5));
				oCliente.setsTelefonoContacto(rs.getString(7));
				oCliente.setoUsuario(new Usuario(rs.getString(9)));
				lClientes.add(oCliente);
			}
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
		return lClientes;
	}

}
