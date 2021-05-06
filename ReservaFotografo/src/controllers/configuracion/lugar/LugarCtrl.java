package controllers.configuracion.lugar;

import java.sql.*;
import java.util.*;

import com.google.gson.Gson;

import controllers.Controller;
import models.lugar.CodigoPostalLocalidadPaisProvincia;
import models.lugar.Lugar;
import models.lugar.*;

public class LugarCtrl {

    // ###### CRUD ######

    public int add(Lugar oLugar) {
        int iIdLugar = -1;
        if (oLugar != null && oLugar.checkLugar()) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oLugar) + "]";

            try {

                CallableStatement statement = Controller.getConnection()
                        .prepareCall("{call lugar_create(?)}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    iIdLugar = rs.getInt(1);
                }
                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println(ex);
            }

        }
        return iIdLugar;
    }

    public boolean remove(Lugar oLugar) {
        boolean bExito = false;
        if (oLugar != null && oLugar.getiIdLugar() > 1) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oLugar) + "]";

            bExito = Controller.executeProcedure(json, "{call remove(?,'iIdLugar','Lugar','IdLugar')}");

        }
        return bExito;
    }

    public boolean update(Lugar oLugar) {
        boolean bExito = false;
        if (oLugar != null && oLugar.checkLugar()) {

            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oLugar) + "]";

            bExito = Controller.executeProcedure(json, "{call lugar_update(?)}");

        }
        return bExito;
    }

    public Lugar searchByPk(Lugar oLugar) {
        Lugar oLugarResult = null;
        if (oLugar != null && oLugar.getiIdLugar() > 1) {
            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oLugar) + "]";

            try {

                CallableStatement statement = Controller.getConnection()
                        .prepareCall("{call search_by(?,'iIdLugar','Lugar','IdLugar')}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    oLugarResult = new Lugar(oLugar.getiIdLugar());
                    oLugarResult.setsNombreLugar(rs.getString(2));
                    oLugarResult.setsGoogleMapLink(rs.getString(3));
                    oLugarResult.setfLatitud(rs.getFloat(4));
                    oLugarResult.setfLongitud(rs.getFloat(5));
                    oLugarResult.setsCalleLugar(rs.getString(6));
                    oLugarResult.setsNumeroLugar(rs.getString(7));
                    oLugarResult.setoCodigoPostalLocalidadPaisProvincia(new CodigoPostalLocalidadPaisProvincia(
                            new Localidad(rs.getString(9)), new CodigoPostal(rs.getString(8)),
                            (new PaisProvincia(new Provincia(rs.getString(10)), new Pais(rs.getString(11))))));
                }
                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println(ex);
            }
        }

        return oLugarResult;
    }

    public Lugar searchByNombreLugar(Lugar oLugar) {
        Lugar oLugarResult = null;
        if (oLugar != null && oLugar.getsNombreLugar() != null) {
            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oLugar) + "]";

            try {

                CallableStatement statement = Controller.getConnection()
                        .prepareCall("{call search_by(?,'sNombreLugar','Lugar','nombreLugar')}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    oLugarResult = new Lugar(rs.getInt(1));
                    oLugarResult.setsNombreLugar(oLugar.getsNombreLugar());
                    oLugarResult.setsGoogleMapLink(rs.getString(3));
                    oLugarResult.setfLatitud(rs.getFloat(4));
                    oLugarResult.setfLongitud(rs.getFloat(5));
                    oLugarResult.setsCalleLugar(rs.getString(6));
                    oLugarResult.setsNumeroLugar(rs.getString(7));
                    oLugarResult.setoCodigoPostalLocalidadPaisProvincia(new CodigoPostalLocalidadPaisProvincia(
                            new Localidad(rs.getString(9)), new CodigoPostal(rs.getString(8)),
                            (new PaisProvincia(new Provincia(rs.getString(10)), new Pais(rs.getString(11))))));
                }
                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println(ex);
            }
        }

        return oLugarResult;
    }

    public Lugar searchByGoogleLink(Lugar oLugar) {
        Lugar oLugarResult = null;
        if (oLugar != null && oLugar.getsGoogleMapLink() != null) {
            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oLugar) + "]";

            try {

                CallableStatement statement = Controller.getConnection()
                        .prepareCall("{call search_by(?,'sGoogleMapLink','Lugar','googleMapLink')}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    oLugarResult = new Lugar(rs.getInt(1));
                    oLugarResult.setsNombreLugar(rs.getString(2));
                    oLugarResult.setsGoogleMapLink(oLugar.getsGoogleMapLink());
                    oLugarResult.setfLatitud(rs.getFloat(4));
                    oLugarResult.setfLongitud(rs.getFloat(5));
                    oLugarResult.setsCalleLugar(rs.getString(6));
                    oLugarResult.setsNumeroLugar(rs.getString(7));
                    oLugarResult.setoCodigoPostalLocalidadPaisProvincia(new CodigoPostalLocalidadPaisProvincia(
                            new Localidad(rs.getString(9)), new CodigoPostal(rs.getString(8)),
                            (new PaisProvincia(new Provincia(rs.getString(10)), new Pais(rs.getString(11))))));
                }
                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println(ex);
            }
        }

        return oLugarResult;
    }

    // SE HA CREADO A LA ESPERA SI HAY QUE UTILIZARLO
    public Lugar searchByDireccion(Lugar oLugar) {
        Lugar oLugarResult = null;
        if (oLugar != null && oLugar.getsCalleLugar() != null) {
            Gson oGson = new Gson();
            String json = "[" + oGson.toJson(oLugar) + "]";

            try {

                CallableStatement statement = Controller.getConnection()
                        .prepareCall("{call lugar_search_by_direccion(?)}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    oLugarResult = new Lugar(rs.getInt(1));
                    oLugarResult.setsNombreLugar(rs.getString(2));
                    oLugarResult.setsGoogleMapLink(rs.getString(3));
                    oLugarResult.setfLatitud(rs.getFloat(4));
                    oLugarResult.setfLongitud(rs.getFloat(5));
                    oLugarResult.setsCalleLugar(rs.getString(6));
                    oLugarResult.setsNumeroLugar(rs.getString(7));
                    oLugarResult.setoCodigoPostalLocalidadPaisProvincia(new CodigoPostalLocalidadPaisProvincia(
                            new Localidad(rs.getString(9)), new CodigoPostal(rs.getString(8)),
                            (new PaisProvincia(new Provincia(rs.getString(10)), new Pais(rs.getString(11))))));
                }
                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println(ex);
            }
        }

        return oLugarResult;
    }

    // SOLO SE LISTAN LOS SITIOS
    public List<Lugar> listar() {
        List<Lugar> lLugars = new ArrayList<Lugar>();
        try {

            CallableStatement statement = Controller.getConnection().prepareCall("{call listar('Lugar')}");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Lugar oLugar = new Lugar(rs.getInt(1));
                oLugar.setsNombreLugar(rs.getString(2));
                oLugar.setsGoogleMapLink(rs.getString(3));
                oLugar.setfLatitud(rs.getFloat(4));
                oLugar.setfLongitud(rs.getFloat(5));
                oLugar.setsCalleLugar(rs.getString(6));
                if (oLugar.getsNombreLugar() != null) {
                    lLugars.add(oLugar);
                }
            }
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
        return lLugars;
    }
    
}
