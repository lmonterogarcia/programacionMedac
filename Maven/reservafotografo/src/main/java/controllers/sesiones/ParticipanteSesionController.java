package controllers.sesiones;

import java.sql.*;
import java.util.*;

import controllers.Controller;
import models.personas.Participante;
import models.sesion.ParticipanteSesion;
import models.sesion.Sesion;

public class ParticipanteSesionController {

    public boolean add(List<ParticipanteSesion> lParticipanteSesion) {
        boolean bExito = false;
        if (lParticipanteSesion.size() > 0) {

            String json = "[";
            for (ParticipanteSesion oParticipanteSesion : lParticipanteSesion) {
                json += "{\"iIdSesion\":" + oParticipanteSesion.getoSesion().getiIdSesion() + ",\"idParticipante\":\""
                        + oParticipanteSesion.getoParticipante().getiIdContacto() + "\"},";
            }
            json = json.substring(0, (json.length() - 1)) + "]";
            bExito = Controller.executeProcedure(json, "{call participante_sesion_create(?)}");

        }
        return bExito;
    }

    public boolean remove(ParticipanteSesion oParticipanteSesion) {
        boolean bExito = false;
        if (oParticipanteSesion != null && oParticipanteSesion.getoSesion().getiIdSesion() > 0
                && oParticipanteSesion.getoParticipante().getsNombreContacto() != null) {

            String json = "[{\"iIdSesion\":" + oParticipanteSesion.getoSesion().getiIdSesion()
                    + ",\"idParticipante\":\"" + oParticipanteSesion.getoParticipante().getiIdContacto() + "\"}]";

            bExito = Controller.executeProcedure(json, "{call participante_sesion_remove(?)}");

        }
        return bExito;
    }

    public ParticipanteSesion searchByPk(ParticipanteSesion oParticipanteSesion) {
        ParticipanteSesion oParticipanteResult = null;
        if (oParticipanteSesion != null && oParticipanteSesion.getoSesion().getiIdSesion() > 0
                && oParticipanteSesion.getoParticipante().getsNombreContacto() != null) {

            String json = "[{\"iIdSesion\":" + oParticipanteSesion.getoSesion().getiIdSesion()
                    + ",\"idParticipante\":\"" + oParticipanteSesion.getoParticipante().getiIdContacto() + "\"}]";

            try {

                CallableStatement statement = Controller.getConnection()
                        .prepareCall("{call participante_sesion_search_by(?)}");
                statement.setString(1, json);

                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    oParticipanteResult = new ParticipanteSesion(new Participante(rs.getInt(2)),
                            new Sesion(rs.getInt(1)));
                }
                statement.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println(ex);
            }
        }

        return oParticipanteResult;
    }

    public Sesion searchBySesion(Sesion oSesion) {
        Sesion oSesionResult = null;
        if (oSesion != null && oSesion.getiIdSesion() > 0) {

            String json = "[{\"iIdSesion\":" + oSesion.getiIdSesion() + "}]";

            try {

                CallableStatement statement = Controller.getConnection()
                        .prepareCall("{call search_by(?,'iIdSesion','Participante_Sesion','idSesion')}");
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

    public List<ParticipanteSesion> listar(int iIdSesion) {
        String sProcedure = "{call nm_sesion_listar('Participante_Sesion','" + iIdSesion + "')}";
        List<ParticipanteSesion> lParticipanteSesions = new ArrayList<ParticipanteSesion>();
        try {

            CallableStatement statement = Controller.getConnection().prepareCall(sProcedure);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ParticipanteSesion oParticipanteSesion = new ParticipanteSesion(new Participante(rs.getInt(1)),
                        new Sesion(rs.getInt(2)));
                lParticipanteSesions.add(oParticipanteSesion);
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
        return lParticipanteSesions;
    }
}
