package controllers.personas;

import java.sql.*;

import models.personas.Participante;

public class ParticipanteController {

    /*
     * ######## # CRUD # ########
     */
    public boolean add(Participante oParticipante, Connection oConnection) {
        boolean bExito = false;
        if (oParticipante != null && oParticipante.checkParticipante()) {

            try {
                Statement stmt = oConnection.createStatement();

                String sSQL = "INSERT INTO Participante VALUES (NULL,";

                if (oParticipante.getoFechaCreacion() != null) {
                    sSQL += "'" + Timestamp.valueOf(oParticipante.getoFechaCreacion()) + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                if (oParticipante.getsDniContacto() != null) {
                    sSQL += "'" + oParticipante.getsDniContacto() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                if (oParticipante.getsNombreContacto() != null) {
                    sSQL += "'" + oParticipante.getsNombreContacto() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                if (oParticipante.getsApellido1Contacto() != null) {
                    sSQL += "'" + oParticipante.getsApellido1Contacto() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                if (oParticipante.getsApellido2Contacto() != null) {
                    sSQL += "'" + oParticipante.getsApellido2Contacto() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                if (oParticipante.getsTelefonoContacto() != null) {
                    sSQL += "'" + oParticipante.getsTelefonoContacto() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                if (oParticipante.getoFechaNacimientoContacto() != null) {
                    sSQL += "'" + Date.valueOf(oParticipante.getoFechaNacimientoContacto()) + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                if (oParticipante.getsEmailParticipante() != null) {
                    sSQL += "'" + oParticipante.getsEmailParticipante() + "'";
                } else {
                    sSQL += "NULL";
                }

                sSQL += ")";

                if (stmt.executeUpdate(sSQL) > 0) {
                    bExito = true;
                }
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e);
                bExito = false;
            }
        }
        return bExito;
    }

    public boolean remove(Participante oParticipante, Connection oConnection) {
        boolean bExito = false;

        try {
            Statement stmt = oConnection.createStatement();

            String sSQL = "DELETE FROM Participante WHERE dniParticipante = ";
            if (oParticipante.getsDniContacto() != null) {
                sSQL += "'" + oParticipante.getsDniContacto() + "'";
            } else {
                sSQL += "NULL";
            }

            if (stmt.executeUpdate(sSQL) > 0) {
                bExito = true;
            }
            stmt.close();
        } catch (SQLException e) {
            bExito = false;
        }

        return bExito;

    }

    public boolean update(Participante oParticipante, Connection oConnection) {
        boolean bExito = false;
        String sOldDniParticipante = oParticipante.getsDniContacto();
        if (oParticipante != null && oParticipante.checkParticipante()) {

            try {
                Statement stmt = oConnection.createStatement();

                String sSQL = "UPDATE Participante SET ";

                sSQL += "dniParticipante = ";
                if (oParticipante.getsDniContacto() != null) {
                    sSQL += "'" + oParticipante.getsDniContacto() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                sSQL += "nombreParticipante = ";
                if (oParticipante.getsNombreContacto() != null) {
                    sSQL += "'" + oParticipante.getsNombreContacto() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                sSQL += "apellido1Participante = ";
                if (oParticipante.getsApellido1Contacto() != null) {
                    sSQL += "'" + oParticipante.getsApellido1Contacto() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                sSQL += "apellido2Participante = ";
                if (oParticipante.getsApellido2Contacto() != null) {
                    sSQL += "'" + oParticipante.getsApellido2Contacto() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                sSQL += "telefonoParticipante = ";
                if (oParticipante.getsTelefonoContacto() != null) {
                    sSQL += "'" + oParticipante.getsTelefonoContacto() + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                sSQL += "fechaNacimientoParticipante = ";
                if (oParticipante.getoFechaNacimientoContacto() != null) {
                    sSQL += "'" + Date.valueOf(oParticipante.getoFechaNacimientoContacto()) + "'";
                } else {
                    sSQL += "NULL";
                }
                sSQL += ",";

                sSQL += "emailParticipante = ";
                if (oParticipante.getsEmailParticipante() != null) {
                    sSQL += "'" + oParticipante.getsEmailParticipante() + "'";
                } else {
                    sSQL += "NULL";
                }

                sSQL += " WHERE dniParticipante = '" + sOldDniParticipante + "'";

                if (stmt.executeUpdate(sSQL) > 0) {
                    bExito = true;
                }
                stmt.close();
            } catch (SQLException e) {
                bExito = false;
                //System.out.println(e);
            }
        }
        return bExito;
    }

    public Participante searchByPk(Participante oParticipante, Connection oConnection) {
        Participante oParticipanteResult = null;
        String sSQL = "SELECT * FROM Participante WHERE dniParticipante = '" + oParticipante.getsDniContacto()
                + "'";

        try {
            Statement stmt = oConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sSQL);
            if (rs.next()) {
                oParticipanteResult = new Participante(rs.getInt(1));
                oParticipanteResult.setoFechaCreacion(rs.getTimestamp(2).toLocalDateTime());
                oParticipanteResult.setsDniContacto(oParticipante.getsDniContacto());
                oParticipanteResult.setsNombreContacto(rs.getString(4));
                oParticipanteResult.setsApellido1Contacto(rs.getString(5));
                oParticipanteResult.setsApellido2Contacto(rs.getString(6));
                oParticipanteResult.setsTelefonoContacto(rs.getString(7));
                oParticipanteResult
                        .setoFechaNacimientoContacto(rs.getDate(8) != null ? rs.getDate(8).toLocalDate() : null);
                oParticipanteResult.setsEmailParticipante(rs.getString(9));
            }
            stmt.close();
        } catch (SQLException e) {
            oParticipanteResult = null;
        }

        return oParticipanteResult;
    }
}
