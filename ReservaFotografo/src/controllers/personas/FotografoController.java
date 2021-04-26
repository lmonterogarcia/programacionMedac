package controllers.personas;

import java.sql.*;

import controllers.Controller;
import controllers.ICrudController;
import models.personas.Fotografo;

public class FotografoController implements ICrudController<Fotografo>{
    
    /*
	 * ######## # CRUD # ########
	 */
	public boolean add(Fotografo oFotografo) {
		boolean bExito = false;
		if (oFotografo != null && oFotografo.checkFotografo()) {

			try {
				Statement stmt = Controller.getConnection().createStatement();

				String sSQL = "INSERT INTO Fotografo VALUES (";

                if (oFotografo.getsDniFotografo() != null) {
					sSQL += "'" + oFotografo.getsDniFotografo() + "'";
				} else {
					sSQL += "NULL";
				}
				sSQL += ",";

				if (oFotografo.getsNombreFotografo() != null) {
					sSQL += "'" + oFotografo.getsNombreFotografo() + "'";
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

	public boolean remove(Fotografo oFotografo) {
		boolean bExito = false;
		if (oFotografo != null) {
			try {
				Statement stmt = Controller.getConnection().createStatement();

				String sSQL = "DELETE FROM Fotografo WHERE dniFotografo = ";
				if (oFotografo.getsDniFotografo() != null) {
					sSQL += "'" + oFotografo.getsDniFotografo() + "'";
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

	public boolean update(Fotografo oFotografo) {
		boolean bExito = false;
		if (oFotografo != null && oFotografo.checkFotografo()) {

			try {
				Statement stmt = Controller.getConnection().createStatement();

				String sSQL = "UPDATE Fotografo SET ";

                sSQL += "nombreFotografo = ";
				if (oFotografo.getsNombreFotografo() != null) {
					sSQL += "'" + oFotografo.getsNombreFotografo() + "'";
				} else {
					sSQL += "NULL";
				}
				
				sSQL += " WHERE dniFotografo = '" + oFotografo.getsDniFotografo() + "'";

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

	public Fotografo searchByPk(Fotografo oFotografo) {
		Fotografo oFotografoResult = null;
		String sSQL = "SELECT * FROM Fotografo WHERE dniFotografo = '" + oFotografo.getsDniFotografo() + "'";

		try {
			Statement stmt = Controller.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sSQL);
			if (rs.next()) {
				oFotografoResult = new Fotografo(oFotografo.getsDniFotografo());
				oFotografoResult.setsNombreFotografo(rs.getString(2));
			}
			stmt.close();
		} catch (SQLException e) {
			oFotografoResult = null;
		}

		return oFotografoResult;
	}
}
