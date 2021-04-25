package controllers.configuracion.productos;

public class PackCtrl {
    
    public boolean add(Estado oEstado, Connection oConnection) {
        boolean bExito = false;
		if (oEstado != null && oEstado.checkEstado()) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEstado) + "]";

			bExito = Controller.executeProcedure(json, "{call estado_create(?)}", oConnection);
			
		}
		return bExito;
    }

    public boolean remove(Estado oEstado, Connection oConnection) {
        boolean bExito = false;
		if (oEstado != null && oEstado.getsNombreEstado() != null) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEstado) + "]";

			bExito = Controller.executeProcedure(json, "{call estado_remove(?)}", oConnection);
			
		}
		return bExito;
    }

    public boolean update(Estado oNuevoEstado, Estado oAntiguoEstado, Connection oConnection) {
        boolean bExito = false;
		if (oNuevoEstado != null && oNuevoEstado.checkEstado() && searchByPk(oNuevoEstado, oConnection) == null ) {

			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oNuevoEstado) + "," + oGson.toJson(oAntiguoEstado) + "]";

			bExito = Controller.executeProcedure(json, "{call estado_update(?)}", oConnection);
			
		}
		return bExito;
    }

    public Estado searchByPk(Estado oEstado, Connection oConnection) {
        Estado oEmpresaResult = null;
		if (oEstado != null && oEstado.getsNombreEstado() != null) {
			Gson oGson = new Gson();
			String json = "[" + oGson.toJson(oEstado) + "]";

			try {

				CallableStatement statement = oConnection.prepareCall("{call estado_search_by_pk(?)}");
				statement.setString(1, json);

				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					oEmpresaResult = new Estado(oEstado.getsNombreEstado());
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
