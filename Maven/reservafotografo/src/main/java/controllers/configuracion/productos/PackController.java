package controllers.configuracion.productos;

import java.sql.*;
import java.util.*;

import com.google.gson.Gson;

import controllers.Controller;
import models.productos.Pack;

public class PackController {
    
    public boolean add(Pack oPack) {
        boolean bExito = false;
		if (oPack != null && oPack.checkPack()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPack) + "]";

			bExito = Controller.executeProcedure(json, "{call pack_create(?)}");
			
		}
		return bExito;
    }

    public boolean remove(Pack oPack) {
        boolean bExito = false; 
		if (oPack != null && oPack.getsNombrePack() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPack) + "]";

			bExito = Controller.executeProcedure(json, "{call remove(?,'sNombrePack','Pack','nombrePack')}");
			
		}
		return bExito;
    }

    public boolean update(Pack oPack) {
        boolean bExito = false;
		if (oPack != null && oPack.checkPack()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPack) + "]";

			bExito = Controller.executeProcedure(json, "{call pack_update(?)}");
			
		}
		return bExito;
    }

    public Pack searchByPk(Pack oPack) {
        Pack oPackResult = null;
		if (oPack != null && oPack.getsNombrePack() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPack) + "]";

			try {

				CallableStatement statement = Controller.getConnection().prepareCall("{call search_by(?,'sNombrePack','Pack','nombrePack')}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oPackResult = new Pack(oPack.getsNombrePack());
					oPackResult.setfPrecioPack(rs.getFloat(2));
					oPackResult.setsDescripcionPack(rs.getString(3));

				}
				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex);
			}
		}

		return oPackResult;
    }

	public List<Pack> listar(){
		List<Pack> lPacks = new ArrayList<Pack>();
		try {

			CallableStatement statement = Controller.getConnection().prepareCall("{call listar('Pack')}");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Pack oPack = new Pack(rs.getString(1));
				oPack.setfPrecioPack(rs.getFloat(2));
				oPack.setsDescripcionPack(rs.getString(3));
				lPacks.add(oPack);
			}
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
		return lPacks;
	}
}
