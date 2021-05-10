package controllers.sesiones;

import java.sql.*;
import java.util.*;

import controllers.Controller;
import models.productos.Producto;
import models.sesion.ProductoSesion;
import models.sesion.Sesion;

public class ProductoSesionController {

    public boolean add(List<ProductoSesion> lProductoSesion) {
        boolean bExito = false;
        if (lProductoSesion.size() > 0) {

            String json = "[";
            for (ProductoSesion oProductoSesion : lProductoSesion) {
                json += "{\"iIdSesion\":" + oProductoSesion.getoSesion().getiIdSesion() + ",\"nombreProducto\":\""
                        + oProductoSesion.getoProducto().getsNombreProducto() + "\"},";
            }
            json = json.substring(0, (json.length() - 1)) + "]";
            bExito = Controller.executeProcedure(json, "{call Producto_sesion_create(?)}");

        }
        return bExito;
    }

    public boolean remove(ProductoSesion oProductoSesion) {
        boolean bExito = false;
        if (oProductoSesion != null && oProductoSesion.getoSesion().getiIdSesion() > 0
                && oProductoSesion.getoProducto().getsNombreProducto() != null) {

            String json = "[{\"iIdSesion\":" + oProductoSesion.getoSesion().getiIdSesion() + ",\"nombreProducto\":\""
                    + oProductoSesion.getoProducto().getsNombreProducto() + "\"}]";

            bExito = Controller.executeProcedure(json, "{call Producto_sesion_remove(?)}");

        }
        return bExito;
    }

    public ProductoSesion searchByPk(ProductoSesion oProductoSesion) {
        ProductoSesion oProductoResult = null;
        if (oProductoSesion != null && oProductoSesion.getoSesion().getiIdSesion() > 0
                && oProductoSesion.getoProducto().getsNombreProducto() != null) {

            String json = "[{\"iIdSesion\":" + oProductoSesion.getoSesion().getiIdSesion() + ",\"nombreProducto\":\""
                    + oProductoSesion.getoProducto().getsNombreProducto() + "\"}]";
            try {

                CallableStatement statement = Controller.getConnection()
                        .prepareCall("{call Producto_sesion_search_by(?)}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    oProductoResult = new ProductoSesion(new Sesion(rs.getInt(1)), new Producto(rs.getString(2)));
                }
                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println(ex);
            }
        }

        return oProductoResult;
    }

    public Sesion searchBySesion(Sesion oSesion) {
        Sesion oSesionResult = null;
        if (oSesion != null && oSesion.getiIdSesion() > 0) {
            String json = "[{\"iIdSesion\":" + oSesion.getiIdSesion() + "}]";

            try {

                CallableStatement statement = Controller.getConnection()
                        .prepareCall("{call search_by(?,'iIdSesion','Producto_Sesion','idSesion')}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    oSesionResult = new Sesion(rs.getInt(1));
                }
                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println(ex);
            }
        }

        return oSesionResult;
    }

    public List<ProductoSesion> listar(String iIdSesion) {
        String sProcedure = "{call nm_sesion_listar('Producto_Sesion','" + iIdSesion + "')}";
        List<ProductoSesion> lProductoSesions = new ArrayList<ProductoSesion>();
        try {

            CallableStatement statement = Controller.getConnection().prepareCall(sProcedure);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ProductoSesion oProductoSesion = new ProductoSesion(new Sesion(rs.getInt(1)),
                        new Producto(rs.getString(2)));
                lProductoSesions.add(oProductoSesion);
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
        return lProductoSesions;
    }
}
