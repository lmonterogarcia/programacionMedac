package controllers.sesiones;

import java.sql.*;
import java.util.*;

import com.google.gson.Gson;

import controllers.Controller;
import models.personas.Empresa;
import models.sesion.Pedido;

public class PedidoController {
    
    public int add(Pedido oPedido) {
		
		int iIdPedido = -1;
        if (oPedido != null && oPedido.checkPedido()) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oPedido) + "]";

            try {

                CallableStatement statement = Controller.getConnection()
                        .prepareCall("{call pedido_create(?)}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    iIdPedido = rs.getInt(1);
                }
                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println(ex);
            }

        }
        return iIdPedido;
	}

	public boolean remove(Pedido oPedido) {
		boolean bExito = false;
		if (oPedido != null && oPedido.getiIdPedido() > 0) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPedido) + "]";

			bExito = Controller.executeProcedure(json, "{call remove(?,'iIdPedido','Pedido','idPedido')}");

		} 
		return bExito;
	}

	public boolean update(Pedido oPedido) {
		boolean bExito = false;
		if (oPedido != null && oPedido.checkPedido()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPedido) + "]";

			bExito = Controller.executeProcedure(json, "{call pedido_update(?)}");

		}
		return bExito;
	}

	public Pedido searchByPk(Pedido oPedido) {
		Pedido oPedidoResult = null;
		if (oPedido != null && oPedido.getiIdPedido() > 0) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oPedido) + "]";

			try {

				CallableStatement statement = Controller.getConnection()
						.prepareCall("{call search_by(?,'iIdPedido','Pedido','idPedido')}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oPedidoResult = new Pedido(oPedido.getiIdPedido());
					oPedidoResult.setBooPagado(rs.getBoolean(2));
					oPedidoResult.setoEmpresa(new Empresa (rs.getString(3)));
				}
				statement.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(ex);
			}
		}

		return oPedidoResult;
	}

	public List<Pedido> listar() {
		List<Pedido> lPedidos = new ArrayList<Pedido>();
		try {

			CallableStatement statement = Controller.getConnection().prepareCall("{call listar('Pedido')}");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Pedido oPedido = new Pedido(rs.getInt(1));
                oPedido.setBooPagado(rs.getBoolean(2));
                oPedido.setoEmpresa(new Empresa (rs.getString(3)));
				lPedidos.add(oPedido);
			}
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
		return lPedidos;
	}
}
