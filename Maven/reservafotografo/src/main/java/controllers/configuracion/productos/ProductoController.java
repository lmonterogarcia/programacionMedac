package controllers.configuracion.productos;

import java.sql.*;
import java.util.*;

import com.google.gson.Gson;

import controllers.Controller;
import models.productos.Producto;

public class ProductoController {
    
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

			bExito = Controller.executeProcedure(json, "{call remove(?,'sNombreProducto','Producto','nombreProducto')}");
			
		}
		return bExito;
    }

    public boolean update(Producto oProducto) {
        boolean bExito = false;
		if (oProducto != null && oProducto.checkProducto()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oProducto) + "]";

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

				CallableStatement statement = Controller.getConnection().prepareCall("{call search_by(?,'sNombreProducto','Producto','nombreProducto')}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oProdcutoResult = new Producto(oProducto.getsNombreProducto());
					oProdcutoResult.setfPrecioProducto(rs.getFloat(2));
					oProdcutoResult.setfCosteProducto(rs.getFloat(3));
					oProdcutoResult.setsProveedorProducto(rs.getString(4));
					oProdcutoResult.setsDescripcionProducto(rs.getString(5));
				}
				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex);
			}
		}

		return oProdcutoResult;
    }

	public List<Producto> listar(){
		List<Producto> lProductos = new ArrayList<Producto>();
		try {

			CallableStatement statement = Controller.getConnection().prepareCall("{call listar('Producto')}");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Producto oProducto = new Producto(rs.getString(1));
				oProducto.setfPrecioProducto(rs.getFloat(2));
				oProducto.setfCosteProducto(rs.getFloat(3));
				oProducto.setsProveedorProducto(rs.getString(4));
				oProducto.setsDescripcionProducto(rs.getString(5));
				lProductos.add(oProducto);
			}
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
		return lProductos;
	}
}
