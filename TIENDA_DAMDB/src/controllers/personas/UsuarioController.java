package controllers.personas;

import java.util.*;
import models.*;
import java.sql.*;
import com.google.gson.*;

public class UsuarioController {

	private List<Usuario> lUsuarios;

	public UsuarioController() {
		lUsuarios = new ArrayList<Usuario>();
	}

	public List<Usuario> getLista() {
		return lUsuarios;
	}

	public void setLista(List<Usuario> lUsuarios) {
		this.lUsuarios = lUsuarios;
	}

	/*
	 * ######## # CRUD # ########
	 */
	public boolean executeProcedure(String json, String sFunction, Connection oConnection) {

		boolean bExito = false;

		try {

			CallableStatement statement = oConnection.prepareCall(sFunction);
			statement.setString(1, json);
			if (statement.executeUpdate() > 0) {
				bExito = true;
			}
			statement.close();

		} catch (SQLException ex) {
			bExito = false;
		}

		return bExito;

	}

	public boolean remove(Usuario oUsuario, Connection oConnection) {

		boolean bExito = false;
		if (oUsuario != null && oUsuario.getsEmail() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oUsuario) + "]";
			bExito = executeProcedure(json, "{call cliente_delete(?)}", oConnection);
		}
		return bExito;
	}

	public boolean update(Usuario oUsuario, Connection oConnection) {
		boolean bExito = false;
		if (oUsuario != null && oUsuario.checkUsuario()) {

			try {
				Statement stmt = oConnection.createStatement();

				String sSQL = "UPDATE Usuario SET password = ";
				if (oUsuario.getsPassword() != null) {
					sSQL += "'" + oUsuario.getsPassword() + "'";
				} else {
					sSQL += "NULL";
				}

				sSQL += " WHERE email = ";
				if (oUsuario.getsEmail() != null) {
					sSQL += "'" + oUsuario.getsEmail() + "'";
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

	public List<Usuario> readAll() {
		return this.getLista();
	}

	public Usuario searchByPk(Usuario oUsuario, Connection oConnection) {
		Usuario oUsuarioResult = null;
		String sSQL = "SELECT * FROM Usuario WHERE email = '" + oUsuario.getsEmail() + "'";

		try {
			Statement stmt = oConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sSQL);
			if (rs.next()) {
				oUsuarioResult = new Usuario(oUsuario.getsEmail());
				oUsuarioResult.setsPassword(rs.getString(2));
			}
			stmt.close();
		} catch (SQLException e) {
			oUsuarioResult = null;
		}

		return oUsuarioResult;
	}
}
