package controllers.sesiones;

import java.sql.*;
import java.util.*;

import com.google.gson.Gson;

import controllers.Controller;
import models.lugar.Lugar;
import models.personas.Cliente;
import models.sesion.Estado;
import models.sesion.EstadoTipoSesion;
import models.sesion.Pedido;
import models.sesion.Sesion;
import models.sesion.TipoSesion;

public class SesionController {

    public boolean add(Sesion oSesion) {
        boolean bExito = false;
        if (oSesion != null && oSesion.checkSesion()) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oSesion) + "]";

            bExito = Controller.executeProcedure(json, "{call sesion_create(?)}");

        }
        return bExito;
    }

    public boolean remove(Sesion oSesion) {
        boolean bExito = false;
        if (oSesion != null && oSesion.getiIdSesion() > 0) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oSesion) + "]";

            bExito = Controller.executeProcedure(json, "{call remove(?,'iIdSesion','Sesion','idSesion')}");

        }
        return bExito;
    }

    public boolean update(Sesion oSesion) {
        boolean bExito = false;
        if (oSesion != null && oSesion.checkSesion()) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oSesion) + "]";

            bExito = Controller.executeProcedure(json, "{call sesion_update(?)}");

        }
        return bExito;
    }

    public Sesion searchByPk(Sesion oSesion) {
        Sesion oSesionResult = null;
        if (oSesion != null && oSesion.getiIdSesion() > 0) {
            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oSesion) + "]";

            try {

                CallableStatement statement = Controller.getConnection()
                        .prepareCall("{call search_by(?,'iIdSesion','Sesion','idSesion')}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    oSesionResult = new Sesion(oSesion.getiIdSesion());
                    oSesionResult.setoFechaSesion(rs.getDate(2) != null ? rs.getDate(2).toLocalDate() : null);
                    oSesionResult.setoHoraSesion(rs.getTime(3) != null ? rs.getTime(3).toLocalTime() : null);
                    oSesionResult.setoCliente(new Cliente(rs.getInt(4)));
                    oSesionResult.setoLugar(new Lugar(rs.getInt(5)));
                    oSesionResult.setoPedido(new Pedido(rs.getInt(6)));
                    oSesionResult.setoEstadoTipoSesion(
                            new EstadoTipoSesion(new Estado(rs.getString(7)), new TipoSesion(rs.getString(8))));
                }
                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println(ex);
            }
        }

        return oSesionResult;
    }

    public List<Sesion> listar() {
        List<Sesion> lSesions = new ArrayList<Sesion>();
        try {

            CallableStatement statement = Controller.getConnection().prepareCall("{call listar('Sesion')}");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Sesion oSesion = new Sesion(rs.getInt(1));
                oSesion.setoFechaSesion(rs.getDate(2) != null ? rs.getDate(2).toLocalDate() : null);
                oSesion.setoHoraSesion(rs.getTime(3) != null ? rs.getTime(3).toLocalTime() : null);
                oSesion.setoCliente(new Cliente(rs.getInt(4)));
                oSesion.setoLugar(new Lugar(rs.getInt(5)));
                oSesion.setoPedido(new Pedido(rs.getInt(6)));
                oSesion.setoEstadoTipoSesion(
                        new EstadoTipoSesion(new Estado(rs.getString(7)), new TipoSesion(rs.getString(8))));
                lSesions.add(oSesion);
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
        return lSesions;
    }
}
