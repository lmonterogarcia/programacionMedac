package controllers.configuracion.productos;

import java.sql.*;
import java.util.*;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.Type;

import controllers.Controller;
import models.productos.Pack;
import models.productos.PackProducto;
import models.productos.Producto;

public class PackProductoController {

	public boolean add(List<PackProducto> lPackProducto) {
		boolean bExito = false;
		if (lPackProducto != null) {

			Gson oGson = new Gson();
			String json = "[";
			for (PackProducto oPackProducto : lPackProducto) {
				json += oGson.toJson(oPackProducto) + ",";
			}
			json = json.substring(0, (json.length() - 1)) + "]";

			

			/*
			 * String json = ("\"[{\"PackProducto\":["); for (PackProducto oPackProducto :
			 * lPackProducto) { json += "{\"sNombrePack\":\"" +
			 * oPackProducto.getoPack().getsNombrePack() + "\",\"sNombreProducto\":\"" +
			 * oPackProducto.getoProducto().getsNombreProducto() + "\"},"; } json =
			 * json.substring(0, (json.length() - 1)) + "]}]\"";
			 */

			System.out.println(json);
			bExito = Controller.executeProcedure(json, "{call pack_producto_create(?)}");

		}
		return bExito;
	}

	public boolean remove(PackProducto oPackProducto) {
		boolean bExito = false;
		if (oPackProducto != null && oPackProducto.getoPack().getsNombrePack() != null
				&& oPackProducto.getoProducto().getsNombreProducto() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPackProducto) + "]";

			bExito = Controller.executeProcedure(json, "{call pack_producto_remove(?)}");

		}
		return bExito;
	}

	public boolean update(PackProducto oPackProducto) {
		boolean bExito = false;
		if (oPackProducto != null && oPackProducto.checkPackProducto()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPackProducto) + "]";

			bExito = Controller.executeProcedure(json, "{call pack_producto_update(?)}");

		}
		return bExito;
	}

	public PackProducto searchByPk(PackProducto oPackProducto) {
		PackProducto oProdcutoResult = null;
		if (oPackProducto != null && oPackProducto.getoPack().getsNombrePack() != null
				&& oPackProducto.getoProducto().getsNombreProducto() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPackProducto) + "]";
			/*
			 * Type listType = new TypeToken<ArrayList<PackProducto>>() {}.getType();
			 * ArrayList<PackProducto> yourClassList = new Gson().fromJson(jsonArray,
			 * listType);
			 * 
			 * ArrayList<PackProducto> sampleList = new ArrayList<PackProducto>(); json =
			 * new Gson().toJson(sampleList);
			 */
			try {

				CallableStatement statement = Controller.getConnection()
						.prepareCall("{call pack_producto_search_by(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oProdcutoResult = new PackProducto(new Pack(rs.getString(1)), new Producto(rs.getString(2)));
				}
				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex);
			}
		}

		return oProdcutoResult;
	}

	public Pack searchByPack(Pack oPack) {
		Pack oPackResult = null;
		if (oPack != null && oPack.getsNombrePack() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPack) + "]";

			try {

				CallableStatement statement = Controller.getConnection()
						.prepareCall("{call search_by(?,'sNombrePack','Pack_Producto','nombrePack')}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oPackResult = new Pack(rs.getString(1));

				}
				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex);
			}
		}

		return oPackResult;
	}

	public List<PackProducto> listar(String sNombrePack) {
		String sProcedure = "{call pack_producto_listar('Pack_Producto','" + sNombrePack + "')}";
		List<PackProducto> lPackProductos = new ArrayList<PackProducto>();
		try {

			CallableStatement statement = Controller.getConnection().prepareCall(sProcedure);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				PackProducto oPackProducto = new PackProducto(new Pack(rs.getString(1)), new Producto(rs.getString(2)));
				lPackProductos.add(oPackProducto);
			}
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
		return lPackProductos;
	}
}
