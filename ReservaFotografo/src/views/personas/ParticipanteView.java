package views.personas;

import java.time.*;
import java.util.regex.Pattern;

import controllers.Controller;
import models.IPlantilla;
import models.personas.Participante;
import views.Libreria;

public class ParticipanteView implements IPlantilla {
    public static byte subMenuParticipante() {
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Gestion de Participante");
        System.out.println("-----------------------");
        System.out.println("1. Alta");
        System.out.println("2. Modificar");
        System.out.println("3. Buscar usuario por dni");
        System.out.println("4. Borrar");
        System.out.println("5. Volver atras");
        return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
    }

    public static void gestionParticipante(Controller oCtrl) {
        switch (ParticipanteView.subMenuParticipante()) {
        case 1: // Alta de particpante
            if (create(oCtrl)) {
                System.out.println("El participante ha sido creado con exito.");
            } else {
                System.out.println("El participante no se ha podido crear.");
            }
            break;
        case 2: // Modificar
            if (update(oCtrl)) {
                System.out.println("El participante ha sido modificado con exito.");
            } else {
                System.out.println("El participante no se ha podido modificar.");
            }
            break;
        case 3: // Buscar
            Participante oParticipante = searchByDni(oCtrl);
            if (oParticipante != null) {
                System.out.println("El participante buscado existe en la base de datos.");
                System.out.println(oParticipante);
            } else {
                System.out.println("El participante no existe en la base de datos.");
            }
            break;
        case 4: // Borrar
            if (remove(oCtrl)) {
                System.out.println("El participante ha sido eliminado con exito.");
            } else {
                System.out.println("El participante no se ha podido eliminar.");
            }
            break;
        }
    }

    private static boolean create(Controller oCtrl) {
        String sDniContacto, sNombreContacto, sApellido1Contacto, sApellido2Contacto, sTelefonoContacto,
                sEmailParticipante;
        char cFechaNacimiento;
        int iDia, iMes, iAnio;
        LocalDate oFechaNacimientoContacto = null;
        boolean booFecha = false;

        System.out.println("Introduce los datos basicos del participante: ");
        System.out.println("Campos requeridos *");
        do {
            sDniContacto = String.valueOf(Libreria.leer("Introduce un dni *", BMINDNI, BMAXDNI, -1, -1, (byte) 6));
        } while (!Pattern.matches(SPATRONDNI, sDniContacto));
        sNombreContacto = String.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRE, -1, -1, (byte) 6));
        do {
            sApellido1Contacto = String
                    .valueOf(Libreria.leer("Introduce el primer apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
        } while (!sApellido1Contacto.isEmpty() && sApellido1Contacto.length() > BMAXAPELLIDOS);
        do {
            sApellido2Contacto = String
                    .valueOf(Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
        } while (!sApellido2Contacto.isEmpty() && sApellido2Contacto.length() > BMAXAPELLIDOS);
        do {
            sTelefonoContacto = String.valueOf(Libreria.leer("Introduce un telefono", 0, 9, -1, -1, (byte) 6));
        } while (!sTelefonoContacto.isEmpty() && sTelefonoContacto.length() != 9);

        do {
            sEmailParticipante = String.valueOf(Libreria.leer("Introduce un email", 0, BMAXEMAIL, -1, -1, (byte) 6));
        } while (!sEmailParticipante.isEmpty() && sEmailParticipante.length() > BMAXEMAIL);

        if (String.valueOf(Libreria.leer("¿Quiere introducir la fecha de nacimiento? (s/n) ", -1, -1, -1, -1, (byte) 7))
                .equalsIgnoreCase("s")) {
            do {
                try {
                    iDia = (int) Libreria.leer("Introduce el dia *", 1, 31, -1, -1, (byte) 3);
                    iMes = (int) Libreria.leer("Introduce el mes *", 1, 12, -1, -1, (byte) 3);
                    iAnio = (int) Libreria.leer("Introduce el annio *", (LocalDate.now().getYear() - 100),
                            LocalDate.now().getYear(), -1, -1, (byte) 3);
                    oFechaNacimientoContacto = LocalDate.of(iAnio, iMes, iDia);
                    booFecha = true;
                } catch (Exception e) {
                    System.out.println("\nHa introducido mal la fecha, vuelva a introducirla");
                }
            } while (!booFecha);
        }

        return oCtrl.addParticipante(new Participante(sDniContacto, sNombreContacto, sApellido1Contacto,
                sApellido2Contacto, sTelefonoContacto, oFechaNacimientoContacto, sEmailParticipante));
    }

    private static boolean update(Controller oCtrl) {
        String sDniContacto, sNombreContacto, sApellido1Contacto, sApellido2Contacto, sTelefonoContacto,
                sEmailParticipante;
        char cFechaNacimiento;
        int iDia, iMes, iAnio;
        LocalDate oFechaNacimientoContacto = null;
        boolean booFecha = false;

        do {
            sDniContacto = String.valueOf(Libreria.leer("Introduce un dni *", BMINDNI, BMAXDNI, -1, -1, (byte) 6));
        } while (!Pattern.matches(SPATRONDNI, sDniContacto));
        Participante oParticipante = oCtrl.searchParticipante(new Participante(null, sDniContacto));

        if (oParticipante != null && oParticipante.checkParticipante()) {

            System.out.println("Modifica los datos basicos del participante: ");

            do {
                sDniContacto = String.valueOf(Libreria.leer(
                        "Introduce un dni (" + oParticipante.getsDniContacto() + ")", 0, BMAXDNI, -1, -1, (byte) 6));
            } while (!sDniContacto.isEmpty() && sDniContacto.length() != BMAXDNI);
            oParticipante.setsDniContacto(sDniContacto);

            do {
                sNombreContacto = String
                        .valueOf(Libreria.leer("Introduce un nombre (" + oParticipante.getsNombreContacto() + ")", 0,
                                BMAXNOMBRE, -1, -1, (byte) 6));
            } while (!sNombreContacto.isEmpty() && sNombreContacto.length() > BMAXNOMBRE);
            oParticipante.setsNombreContacto(sNombreContacto);

            do {
                sApellido1Contacto = String.valueOf(
                        Libreria.leer("Introduce el primer apellido (" + oParticipante.getsApellido1Contacto() + ")", 0,
                                BMAXAPELLIDOS, -1, -1, (byte) 6));
            } while (!sApellido1Contacto.isEmpty() && sApellido1Contacto.length() > BMAXAPELLIDOS);
            oParticipante.setsApellido1Contacto(sApellido1Contacto);

            do {
                sApellido2Contacto = String.valueOf(
                        Libreria.leer("Introduce el segundo apellido (" + oParticipante.getsApellido2Contacto() + ")",
                                0, BMAXAPELLIDOS, -1, -1, (byte) 6));
            } while (!sApellido2Contacto.isEmpty() && sApellido2Contacto.length() > BMAXAPELLIDOS);
            oParticipante.setsApellido2Contacto(sApellido2Contacto);

            do {
                sTelefonoContacto = String
                        .valueOf(Libreria.leer("Introduce un telefono (" + oParticipante.getsTelefonoContacto() + ")",
                                0, 9, -1, -1, (byte) 6));
            } while (!sTelefonoContacto.isEmpty() && sTelefonoContacto.length() != 9);
            oParticipante.setsTelefonoContacto(sTelefonoContacto);

            if (oParticipante.getoFechaNacimientoContacto() != null) {
                sFechaNacimiento = oParticipante.getoFechaNacimientoContacto().getDayOfMonth() + "/"
                        + oParticipante.getoFechaNacimientoContacto().getMonth() + "/"
                        + oParticipante.getoFechaNacimientoContacto().getYear() + ")";
            } else {
                sFechaNacimiento = "Vacio";
            }

            if ((String
                    .valueOf(Libreria.leer("¿Quiere modificar la fecha de nacimiento? (s/n) (" + sFechaNacimiento + ")",
                            -1, -1, -1, -1, (byte) 7))).equalsIgnoreCase("s")) {
                do {
                    try {
                        iDia = (int) Libreria.leer("Introduce el dia ", 1, 31, -1, -1, (byte) 3);
                        iMes = (int) Libreria.leer("Introduce el mes ", 1, 12, -1, -1, (byte) 3);
                        iAnio = (int) Libreria.leer("Introduce el annio ", (LocalDate.now().getYear() - 100),
                                LocalDate.now().getYear(), -1, -1, (byte) 3);
                        oFechaNacimientoContacto = LocalDate.of(iAnio, iMes, iDia);
                        booFecha = true;
                        oParticipante.setoFechaNacimientoContacto(LocalDate.of(iAnio, iMes, iDia));
                    } catch (Exception e) {
                        System.out.println("\nHa introducido una fecha incorrecta, vuelva a introducirla");
                    }
                } while (!booFecha);

            }
            // ######## NO IMPLEMENTADO HASTA QUE NO SE CREE EL CONTROLADOR DE LUGAR
            // ############
            if (String.valueOf(
                    Libreria.leer("¿Quiere modificar la direccion o localizacion? (s/n) ", -1, -1, -1, -1, (byte) 7))
                    .equalsIgnoreCase("s")) {
                do {
                    try {
                        sNombreLugar = String.valueOf(
                                Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
                        sGoogleLink = String.valueOf(
                                Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
                        fLatitud = (float) (Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1,
                                (byte) 5));
                        fLongitud = (float) (Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1,
                                (byte) 5));
                        sCalle = String.valueOf(
                                Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
                        sNumeroCalle = String.valueOf(
                                Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
                        sCodigoPostal = String.valueOf(
                                Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
                        sLocalidda = String.valueOf(
                                Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
                        sProvincia = String.valueOf(
                                Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
                        sPais = String.valueOf(
                                Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
                        booFecha = true;
                    } catch (Exception e) {
                        System.out.println("\nHa introducido mal la fecha, vuelva a introducirla");
                    }
                } while (booFecha);
                oParticipante.setoLugar(null); // Cambiar cuando se cree el controlador de Lugar
            }

            if (String.valueOf(Libreria.leer("¿Quiere modificar la contraseña? (s/n) ", -1, -1, -1, -1, (byte) 7))
                    .equalsIgnoreCase("s")) {
                byte bContador = 0;
                boolean booExitoPass = false;
                do {
                    if ((Libreria.leer("Introduce la contraseña Actual ", BMINPASSW, BMAXPASSW, -1, -1, (byte) 6))
                            .equals(oParticipante.getoUsuario().getsPassword())) {
                        sPassword = String.valueOf(
                                Libreria.leer("Introduce la nueva contrasena", BMINPASSW, BMAXPASSW, -1, -1, (byte) 6));
                        booExitoPass = true;
                        oParticipante.getoUsuario().setsPassword(sPassword);
                    } else {
                        bContador++;
                        System.out.println("## Contraseña actual incorrecta ##");
                    }
                    if (bContador == 3) {
                        System.out.println("Demasiados errores. La contraseña no se va a cambiar.");
                    }
                } while (!booExitoPass && bContador < 3);
            }
            booExito = oCtrl.updateParticipante(oParticipante);
        }

        return booExito;
    }

    private static Participante searchByDni(Controller oCtrl) {
        String sDniContacto;
        System.out.println("\nCampos requeridos *");
        do {
            sDniContacto = String.valueOf(Libreria.leer("Introduce un dni *", BMINDNI, BMAXDNI, -1, -1, (byte) 6));
        } while (!Pattern.matches(SPATRONDNI, sDniContacto));

        return oCtrl.searchParticipante(new Participante(null, sDniContacto));
    }

    private static boolean remove(Controller oCtrl) {
        boolean bExito = false;
        Participante oParticipante = searchByDni(oCtrl);

        if (oParticipante != null) {
            bExito = oCtrl.removeParticipante(oParticipante);
        }
        return bExito;
    }
}
