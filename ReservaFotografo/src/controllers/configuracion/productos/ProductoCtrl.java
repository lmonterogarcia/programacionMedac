package controllers.configuracion.productos;

import java.sql.*;

import com.google.gson.Gson;

import controllers.Controller;
import models.productos.Producto;

public class ProductoCtrl {
    
    public boolean add(Producto oProducto, Connection oConnection) {
        boolean bExito = false;
		if (oProducto != null && oProducto.checkProducto()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oProducto) + "]";

			bExito = Controller.executeProcedure(json, "{call producto_create(?)}", oConnection);
			
		}
		return bExito;
    }

    public boolean remove(Producto oProducto, Connection oConnection) {
        boolean bExito = false;
		if (oProducto != null && oProducto.getsNombreProducto() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oProducto) + "]";

			bExito = Controller.executeProcedure(json, "{call producto_remove(?)}", oConnection);
			
		}
		return bExito;
    }

    public boolean update(Producto oNuevoProducto, Producto oAntiguoProducto, Connection oConnection) {
        boolean bExito = false;
		if (oNuevoProducto != null && oNuevoProducto.checkProducto() && searchByPk(oNuevoProducto, oConnection) == null ) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oNuevoProducto) + "," + oGson.toJson(oAntiguoProducto) + "]";

			bExito = Controller.executeProcedure(json, "{call producto_update(?)}", oConnection);
			
		}
		return bExito;
    }

    public Producto searchByPk(Producto oProducto, Connection oConnection) {
        Producto oEmpresaResult = null;
		if (oProducto != null && oProducto.getsNombreProducto() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oProducto) + "]";

			try {

				CallableStatement statement = oConnection.prepareCall("{call producto_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oEmpresaResult = new Producto(oProducto.getsNombreProducto());
				}
				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex);
			}
		}

		return oEmpresaResult;
    }
}
