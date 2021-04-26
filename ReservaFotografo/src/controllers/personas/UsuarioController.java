package controllers.personas;

import models.personas.*;

import java.sql.*;

import controllers.Controller;

public class UsuarioController implements controllers.ICrudController<Usuario> {

	/*
	 * ######## # CRUD # ########
	 */
	public boolean add(Usuario oUsuario) {
		boolean bExito = false;
		if (oUsuario != null && oUsuario.checkUsuario()) {

			try {
				Statement stmt = Controller.getConnection().createStatement();

				String sSQL = "INSERT INTO Usuario VALUES (";
				if (oUsuario.getsEmail() != null) {
					sSQL += "'" + oUsuario.getsEmail() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oUsuario.getsPassword() != null) {
					sSQL += "'" + oUsuario.getsPassword() + "'";
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

	public boolean remove(Usuario oUsuario) {

		boolean bExito = false;
		if (oUsuario != null && oUsuario.getsEmail() != null) {

			try {
				Statement stmt = Controller.getConnection().createStatement();

				String sSQL = "DELETE FROM Usuario WHERE emailUsuario = ";
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

	public boolean update(Usuario oUsuario) {
		boolean bExito = false;
		if (oUsuario != null && oUsuario.checkUsuario()) {

			try {
				Statement stmt = Controller.getConnection().createStatement();
				
				String sSQL = "UPDATE Usuario SET passUsuario = ";
				if (oUsuario.getsPassword() != null) {
					sSQL += "'" + oUsuario.getsPassword() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += " WHERE emailUsuario = '" + oUsuario.getsEmail() + "'"; 
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

	public Usuario searchByPk(Usuario oUsuario) {
		Usuario oUsuarioResult = null;
		String sSQL = "SELECT * FROM Usuario WHERE emailUsuario = '" + oUsuario.getsEmail() + "'";

		try {
			Statement stmt = Controller.getConnection().createStatement();
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
