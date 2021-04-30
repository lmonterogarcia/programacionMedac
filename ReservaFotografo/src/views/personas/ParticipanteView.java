package views.personas;

import java.time.*;
import java.util.List;
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
        System.out.println("5. Listar participantes");
        System.out.println("6. Volver atras");
        return (byte) Libreria.leer("Introduce una opcion", 1, 6, -1, -1, (byte) 1);
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
        case 5: // Listar Participante
            List<Participante> oListaParticipante = listarParticipante(oCtrl);
            if (oListaParticipante != null && !oListaParticipante.isEmpty()) {
                System.out.println("\n## Lista de participantes ##");
                for (Participante oParL : oListaParticipante) {
                    System.out.println(
                            "Id: " + oParL.getiIdContacto() + " - DNI: " + oParL.getsDniContacto() + " - Nombre: "
                                    + oParL.getsNombreContacto() + " " + oParL.getsApellido1Contacto() + " - Email: "
                                    + oParL.getsEmailParticipante() + " - Telefono: " + oParL.getsTelefonoContacto());
                }
                if (String.valueOf(
                        Libreria.leer("¿Quiere mas informacion de algun Participante? (s/n) ", -1, -1, -1, -1, (byte) 7))
                        .equalsIgnoreCase("s")) {
                    Participante oPar = searchByDni(oCtrl);
                    if (oPar != null) {
                        System.out.println(oPar);
                    } else {
                        System.out.println("El participante no existe en la base de datos.");
                    }
                }
            } else {
                System.out.println("No existen participantes en la base de datos.");
            }
            break;
        }
    }

    private static boolean create(Controller oCtrl) {
        String sDniContacto, sNombreContacto, sApellido1Contacto, sApellido2Contacto, sTelefonoContacto,
                sEmailParticipante;
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

        return oCtrl.getoParticipanteCtrl().add(new Participante(sDniContacto, sNombreContacto, sApellido1Contacto,
                sApellido2Contacto, sTelefonoContacto, oFechaNacimientoContacto, sEmailParticipante));
    }

    private static boolean update(Controller oCtrl) {
        String sDniContacto, sNombreContacto, sApellido1Contacto, sApellido2Contacto, sTelefonoContacto,
                sEmailParticipante, sFechaNacimiento;
        int iDia, iMes, iAnio;
        boolean booExito = false, booFecha = false, booDni;

        do {
            sDniContacto = String.valueOf(Libreria.leer("Introduce un dni ", BMINDNI, BMAXDNI, -1, -1, (byte) 6));
        } while (!Pattern.matches(SPATRONDNI, sDniContacto));
        Participante oParticipante = oCtrl.getoParticipanteCtrl().searchByPk(new Participante(1, sDniContacto));

        if (oParticipante != null && oParticipante.checkParticipante()) {

            System.out.println("Modifica los datos del participante: ");

            do {
                sDniContacto = String.valueOf(Libreria.leer(
                        "Introduce un dni (" + oParticipante.getsDniContacto() + ")", 0, BMAXDNI, -1, -1, (byte) 6));
                if (oCtrl.getoParticipanteCtrl().searchByPk(new Participante(1, sDniContacto)) != null) {
                    System.out.println("\nEste dni ya esta siendo utilizado en la base de datos");
                    booDni = false;
                } else {
                    booDni = true;
                }
            } while (!sDniContacto.isEmpty() && sDniContacto.length() != BMAXDNI && !booDni);
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

            do {
                sEmailParticipante = String.valueOf(Libreria.leer(
                        "Introduce un email (" + oParticipante.getsEmailParticipante() + ")", 0, 9, -1, -1, (byte) 6));
            } while (!sEmailParticipante.isEmpty() && sEmailParticipante.length() != 9);
            oParticipante.setsEmailParticipante(sEmailParticipante);

            if (oParticipante.getoFechaNacimientoContacto() != null) {
                sFechaNacimiento = oParticipante.getoFechaNacimientoContacto().getDayOfMonth() + "/"
                        + oParticipante.getoFechaNacimientoContacto().getMonth() + "/"
                        + oParticipante.getoFechaNacimientoContacto().getYear() + ")";
            } else {
                sFechaNacimiento = "Vacio";
            }

            if ((String
                    .valueOf(Libreria.leer("¿Quiere modificar la fecha de nacimiento? (s/n) (" + sFechaNacimiento + " ",
                            -1, -1, -1, -1, (byte) 7))).equalsIgnoreCase("s")) {
                do {
                    try {
                        iDia = (int) Libreria.leer("Introduce el dia ", 1, 31, -1, -1, (byte) 3);
                        iMes = (int) Libreria.leer("Introduce el mes ", 1, 12, -1, -1, (byte) 3);
                        iAnio = (int) Libreria.leer("Introduce el annio ", (LocalDate.now().getYear() - 100),
                                LocalDate.now().getYear(), -1, -1, (byte) 3);
                        booFecha = true;
                        oParticipante.setoFechaNacimientoContacto(LocalDate.of(iAnio, iMes, iDia));
                    } catch (Exception e) {
                        System.out.println("\nHa introducido una fecha incorrecta, vuelva a introducirla");
                    }
                } while (!booFecha);

            }

            booExito = oCtrl.getoParticipanteCtrl().update(oParticipante);
        }

        return booExito;
    }

    private static Participante searchByDni(Controller oCtrl) {
        String sDniContacto;
        System.out.println("\nCampos requeridos *");
        do {
            sDniContacto = String.valueOf(Libreria.leer("Introduce un dni *", BMINDNI, BMAXDNI, -1, -1, (byte) 6));
        } while (!Pattern.matches(SPATRONDNI, sDniContacto));

        return oCtrl.getoParticipanteCtrl().searchByPk(new Participante(1, sDniContacto));
    }

    private static boolean remove(Controller oCtrl) {
        boolean bExito = false;
        Participante oParticipante = searchByDni(oCtrl);

        if (oParticipante != null) {
            bExito = oCtrl.getoParticipanteCtrl().remove(oParticipante);
        }
        return bExito;
    }

    public static List<Participante> listarParticipante(Controller oCtrl) {
        return oCtrl.getoParticipanteCtrl().listar();
    }
}
