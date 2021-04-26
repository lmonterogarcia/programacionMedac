package controllers.configuracion.productos;

import java.sql.*;

import com.google.gson.Gson;

import controllers.Controller;
import models.productos.Producto;

public class ProductoCtrl {
    
    public boolean add(Producto oProducto) {
        boolean bExito = false;
		if (oProducto != null && oProducto.checkProducto()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oProducto) + "]";

			bExito = Controller.executeProcedure(json, "{call producto_create(?)}");
			
		}
		return bExito;
    }

    public boolean remove(Producto oProducto) {
        boolean bExito = false;
		if (oProducto != null && oProducto.getsNombreProducto() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oProducto) + "]";

			bExito = Controller.executeProcedure(json, "{call producto_remove(?)}");
			
		}
		return bExito;
    }

    public boolean update(Producto oNuevoProducto, Producto oAntiguoProducto) {
        boolean bExito = false;
		if (oNuevoProducto != null && oNuevoProducto.checkProducto() && searchByPk(oNuevoProducto) == null ) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oNuevoProducto) + "," + oGson.toJson(oAntiguoProducto) + "]";

			bExito = Controller.executeProcedure(json, "{call producto_update(?)}");
			
		}
		return bExito;
    }

    public Producto searchByPk(Producto oProducto) {
        Producto oProdcutoResult = null;
		if (oProducto != null && oProducto.getsNombreProducto() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oProducto) + "]";

			try {

				CallableStatement statement = Controller.getConnection().prepareCall("{call producto_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oProdcutoResult = new Producto(oProducto.getsNombreProducto());
				}
				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex);
			}
		}

		return oProdcutoResult;
    }
}
