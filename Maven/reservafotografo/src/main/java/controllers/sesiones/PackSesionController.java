package controllers.sesiones;

import java.sql.*;
import java.util.*;

import controllers.Controller;
import models.productos.Pack;
import models.sesion.PackSesion;
import models.sesion.Sesion;

public class PackSesionController {

    public boolean add(List<PackSesion> lPackSesion) {
        boolean bExito = false;
        if (lPackSesion.size() > 0) {

            String json = "[";
            for (PackSesion oPackSesion : lPackSesion) {
                json += "{\"iIdSesion\":" + oPackSesion.getoSesion().getiIdSesion() + ",\"nombrePack\":\""
                        + oPackSesion.getoPack().getsNombrePack() + "\"},";
            }
            json = json.substring(0, (json.length() - 1)) + "]";
            bExito = Controller.executeProcedure(json, "{call Pack_sesion_create(?)}");

        }
        return bExito;
    }

    public boolean remove(PackSesion oPackSesion) {
        boolean bExito = false;
        if (oPackSesion != null && oPackSesion.getoSesion().getiIdSesion() > 0
                && oPackSesion.getoPack().getsNombrePack() != null) {

            String json = "[{\"iIdSesion\":" + oPackSesion.getoSesion().getiIdSesion() + ",\"nombrePack\":\""
                    + oPackSesion.getoPack().getsNombrePack() + "\"}]";

            bExito = Controller.executeProcedure(json, "{call Pack_sesion_remove(?)}");

        }
        return bExito;
    }

    public PackSesion searchByPk(PackSesion oPackSesion) {
        PackSesion oPackResult = null;
        if (oPackSesion != null && oPackSesion.getoSesion().getiIdSesion() > 0
                && oPackSesion.getoPack().getsNombrePack() != null) {

            String json = "[{\"iIdSesion\":" + oPackSesion.getoSesion().getiIdSesion() + ",\"nombrePack\":\""
                    + oPackSesion.getoPack().getsNombrePack() + "\"}]";

            try {

                CallableStatement statement = Controller.getConnection().prepareCall("{call Pack_sesion_search_by(?)}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    oPackResult = new PackSesion(new Pack(rs.getString(2)), new Sesion(rs.getInt(1)));
                }
                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println(ex);
            }
        }

        return oPackResult;
    }

    public Sesion searchBySesion(Sesion oSesion) {
        Sesion oSesionResult = null;
        if (oSesion != null && oSesion.getiIdSesion() > 0) {
            String json = "[{\"iIdSesion\":" + oSesion.getiIdSesion() + "}]";

            try {

                CallableStatement statement = Controller.getConnection()
                        .prepareCall("{call search_by(?,'iIdSesion','Pack_Sesion','idSesion')}");
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

    public List<PackSesion> listar(String iIdSesion) {
        String sProcedure = "{call nm_sesion_listar('Pack_Sesion','" + iIdSesion + "')}";
        List<PackSesion> lPackSesions = new ArrayList<PackSesion>();
        try {

            CallableStatement statement = Controller.getConnection().prepareCall(sProcedure);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                PackSesion oPackSesion = new PackSesion(new Pack(rs.getString(2)), new Sesion(rs.getInt(1)));
                lPackSesions.add(oPackSesion);
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
        return lPackSesions;
    }
}
