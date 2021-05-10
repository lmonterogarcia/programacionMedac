package views.sesiones;

import java.time.*;
import java.util.*;

import org.apache.commons.lang3.text.WordUtils;

import controllers.Controller;
import models.IPlantilla;
import models.lugar.Lugar;
import models.personas.*;
import models.productos.Pack;
import models.productos.Producto;
import models.sesion.*;
import views.Libreria;

public class SesionView implements IPlantilla {

    public static byte subMenuSesion(Controller oCtrl) {
        byte bOpcion = 0;
        if (oCtrl.getoPersonasCtrl().getoClientCtrl().listar() != null
                && oCtrl.getConfiguracionCtrl().getoLugarCtrl().listar() != null
                && oCtrl.getSesionesCtrl().getoPedidoCtrl().listar() != null) {
            System.out.println("");
            System.out.println("------------------");
            System.out.println("Gestion de sesions");
            System.out.println("------------------");
            System.out.println("1. Alta");
            System.out.println("2. Modificar");
            System.out.println("3. Buscar sesion por id");
            System.out.println("4. Buscar sesion por Cliente");
            System.out.println("5. Borrar");
            System.out.println("6. Listar sesiones");
            System.out.println("7. Asignar fotografo");
            System.out.println("8. Borrar fotografo");
            System.out.println("9. Asignar participante");
            System.out.println("10. Borrar participante");
            System.out.println("11. Asignar producto");
            System.out.println("12. Borrar producto");
            System.out.println("13. Asignar pack");
            System.out.println("14. Borrar pack");
            System.out.println("15. Volver atras");
            bOpcion = (byte) Libreria.leer("Introduce una opcion", 1, 15, -1, -1, (byte) 1);
        } else {
            System.out.println(
                    "\n¡¡Para poder gestionar sesiones tiene que tener creado al menos un cliente, un sitio, un pedido, un tipo de sesion con estados asignados!!\n");
        }
        return bOpcion;
    }

    public static void gestionSesion(Controller oCtrl) {
        byte bOpcion;
        do {
            bOpcion = subMenuSesion(oCtrl);
            switch (bOpcion) {
                case 1: // Alta de sesion
                    if (create(oCtrl)) {
                        System.out.println("La sesion ha sido creado con exito.");
                    } else {
                        System.out.println("La sesion no se ha podido crear.");
                    }
                    break;

                case 2: // Modificar
                    if (update(oCtrl)) {
                        System.out.println("La sesion ha sido modificado con exito.");
                    } else {
                        System.out.println("La sesion no se ha podido modificar.");
                    }
                    break;
                case 3:
                    // Buscar
                    Sesion oSesion = searchById(oCtrl);
                    if (oSesion != null) {
                        System.out.println("La sesion buscado existe en la base de datos.");
                        System.out.println(oSesion);
                        listarFotografoDeSesion(oCtrl, oSesion);
                        listarParticipanteDeSesion(oCtrl, oSesion);
                        listarProductoDeSesion(oCtrl, oSesion);
                        listarPackDeSesion(oCtrl, oSesion);
                    } else {
                        System.out.println("La sesion no existe en la base de datos.");
                    }
                    break;
                case 4: // Buscar
                    List<Sesion> lSesiones = searchByCliente(oCtrl);
                    if (lSesiones != null) {
                        System.out.println("Hay sesiones de ese cliente");
                        for (Sesion oSesCliL : lSesiones) {
                            System.out.println(" Id de sesion: " + oSesCliL.getiIdSesion() + " Pedido: "
                                    + oSesCliL.getoPedido().getiIdPedido() + " - Tipo de Sesion: "
                                    + oSesCliL.getoEstadoTipoSesion().getoTipoSesion().getsNombreTipoSesion()
                                    + " - Estado: " + oSesCliL.getoEstadoTipoSesion().getoEstado().getsNombreEstado());
                        }
                    } else {
                        System.out.println("No hay sesiones de ese cliente.");
                    }
                    break;
                case 5: // Borrar
                    if (remove(oCtrl)) {
                        System.out.println("La sesion ha sido eliminado con exito.");
                    } else {
                        System.out.println("La sesion no se ha podido eliminar.");
                    }
                    break;
                case 6: // Listar
                    List<Sesion> lSesions = listarSesion(oCtrl);
                    if (lSesions != null && !lSesions.isEmpty()) {
                        System.out.println("\n### Lista de sesiones ###");
                        for (Sesion oSesL : lSesions) {
                            System.out.println(" Id de sesion: " + oSesL.getiIdSesion() + " - Cliente: "
                                    + oSesL.getoCliente().getsNombreContacto() + " - Tipo Sesion: "
                                    + oSesL.getoEstadoTipoSesion().getoTipoSesion().getsNombreTipoSesion() + " - "
                                    + oSesL.getoEstadoTipoSesion().getoEstado().getsNombreEstado());
                        }
                    } else {
                        System.out.println("No hay ninguna sesion");
                    }
                    break;
                case 7: // Asignar Fotografo
                    if (asignarFotografo(oCtrl)) {
                        System.out.println("El fotografo ha sido asignado de la sesion.");
                    } else {
                        System.out.println("El fotografo NO ha sido asignado de la sesion.");
                    }
                    break;
                case 8: // Eliminar Fotografo
                    if (eliminarFotografo(oCtrl)) {
                        System.out.println("El fotografo ha sido eliminado de la sesion.");
                    } else {
                        System.out.println("El fotografo ha sido eliminado de la sesion.");
                    }
                    break;
                case 9: // Asignar Paticipante
                    if (asignarParticipante(oCtrl)) {
                        System.out.println("El participante ha sido asignado de la sesion.");
                    } else {
                        System.out.println("El participante NO ha sido asignado de la sesion.");
                    }
                    break;
                case 10: // Eliminar Participante
                    if (eliminarParticipante(oCtrl)) {
                        System.out.println("El participante ha sido eliminado de la sesion.");
                    } else {
                        System.out.println("El participante NO ha sido eliminado de la sesion.");
                    }
                    break;
                case 11: // Asignar Prodcuto
                    if (asignarProducto(oCtrl)) {
                        System.out.println("El producto ha sido asignado de la sesion.");
                    } else {
                        System.out.println("El producto NO ha sido asignado de la sesion.");
                    }
                    break;
                case 12: // Eliminar Producto
                    if (eliminarProducto(oCtrl)) {
                        System.out.println("El producto ha sido eliminado de la sesion.");
                    } else {
                        System.out.println("El producto NO ha sido eliminado de la sesion.");
                    }
                    break;
                case 13: // Asignar Pack
                    if (asignarPack(oCtrl)) {
                        System.out.println("El pack ha sido asignado de la sesion.");
                    } else {
                        System.out.println("El pack ha sido NO asignado de la sesion.");
                    }
                    break;
                case 14: // Elinimar Pack
                    if (eliminarPack(oCtrl)) {
                        System.out.println("El pack ha sido eliminado de la sesion.");
                    } else {
                        System.out.println("El pack ha sido NO eliminado de la sesion.");
                    }
                    break;
                default:
                    break;
            }
        } while (bOpcion != 15 || bOpcion != 0);

    }

    private static boolean create(Controller oCtrl) {
        Cliente oCliente = null;
        Pedido oPedido = new Pedido(0);
        LocalDate oFechaSesion = null;
        LocalTime oHoraSesion = null;
        Lugar oLugar = null;
        EstadoTipoSesion oEstadoTipoSesion = null;
        TipoSesion oTipoSesion;
        Estado oEstado;
        String sEmailUsuario, sNombreLugar;
        int iDia, iMes, iAnio, iMinutos, iHoras;
        boolean booFecha = false, booEstadoTipoSesion = false, booHora = false;

        System.out.println("\nIntroduce los datos del sesion: ");
        System.out.println("Campos requeridos *");
        // Pedido
        do {
            oPedido.setiIdPedido((int) (Libreria.leer("\nIntroduce un id de pedido", 1, IMAXIDS, -1, -1, (byte) 3)));
            if (oCtrl.getSesionesCtrl().getoPedidoCtrl().searchByPk(oPedido) == null) {
                System.out.println("No hay ningun pedido con ese numero");
            }
        } while (oCtrl.getSesionesCtrl().getoPedidoCtrl().searchByPk(oPedido) == null);
        // Cliente
        do {
            sEmailUsuario = String
                    .valueOf(Libreria.leer("Introduce un email de cliente *", 1, BMAXEMAIL, -1, -1, (byte) 6));
            oCliente = oCtrl.getoPersonasCtrl().getoClientCtrl()
                    .searchByPk(new Cliente("nombre", new Usuario(sEmailUsuario)));
            if (oCliente == null) {
                System.out.println("No hay ningun cliente con ese email");
            }
        } while (oCliente == null);
        // EstadoTipoSesion
        do {
            oTipoSesion = new TipoSesion(WordUtils.capitalizeFully(String.valueOf(
                    Libreria.leer("Introduce un nombre de tipo de sesion", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6))));
            if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoTipoSesionCtrl()
                    .searchByPk(oTipoSesion) != null) {
                oEstado = new Estado(WordUtils.capitalizeFully(String.valueOf(
                        Libreria.leer("Introduce un estado de sesion", 0, BMAXNOMBRELARGO, -1, -1, (byte) 6))));

                if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl().searchByPk(oEstado) != null) {
                    oEstadoTipoSesion = new EstadoTipoSesion(oEstado, oTipoSesion);

                    if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl()
                            .searchByPk(oEstadoTipoSesion) != null) {
                        booEstadoTipoSesion = true;
                    }
                }
            }
            if (!booEstadoTipoSesion) {
                System.out.println("Ese estado no esta asignado a este tipo de sesion");
            }
        } while (!booEstadoTipoSesion);

        // Lugar
        do {
            do {
                sNombreLugar = String
                        .valueOf(Libreria.leer("Introduce un nombre *", 0, BMAXNOMBRELUGAR, -1, -1, (byte) 6));
                sNombreLugar = WordUtils.capitalizeFully(sNombreLugar);
            } while (!sNombreLugar.isEmpty() && sNombreLugar.length() > BMAXNOMBRELUGAR);
            oLugar = oCtrl.getConfiguracionCtrl().getoLugarCtrl().searchByNombreLugar(new Lugar(1, sNombreLugar, null));
        } while (oLugar == null);

        // Fecha
        if (String.valueOf(Libreria.leer("¿Quiere introducir la fecha de la sesion? (s/n) ", -1, -1, -1, -1, (byte) 7))
                .equalsIgnoreCase("s")) {
            do {
                try {
                    iDia = (int) Libreria.leer("Introduce el dia *", 1, 31, -1, -1, (byte) 3);
                    iMes = (int) Libreria.leer("Introduce el mes *", 1, 12, -1, -1, (byte) 3);
                    iAnio = (int) Libreria.leer("Introduce el annio *", LocalDate.now().getYear(),
                            (LocalDate.now().getYear() + 5), -1, -1, (byte) 3);
                    oFechaSesion = LocalDate.of(iAnio, iMes, iDia);
                    booFecha = true;
                } catch (Exception e) {
                    System.out.println("\nHa introducido mal la fecha, vuelva a introducirla");
                }
            } while (!booFecha);
        }

        // Hora
        if (String.valueOf(Libreria.leer("¿Quiere introducir la hora de la sesion? (s/n) ", -1, -1, -1, -1, (byte) 7))
                .equalsIgnoreCase("s")) {
            do {
                try {
                    iHoras = (int) Libreria.leer("Introduce la hora *", 0, 23, -1, -1, (byte) 3);
                    iMinutos = (int) Libreria.leer("Introduce los minutos *", 0, 59, -1, -1, (byte) 3);

                    oHoraSesion = LocalTime.of(iHoras, iMinutos);
                    booHora = true;
                } catch (Exception e) {
                    System.out.println("\nHa introducido mal la hora, vuelva a introducirla");
                }
            } while (!booHora);
        }
        return oCtrl.getSesionesCtrl().getoSesionCtrl()
                .add(new Sesion(oCliente, oPedido, oFechaSesion, oHoraSesion, oLugar, oEstadoTipoSesion));
    }

    private static boolean update(Controller oCtrl) {

        LocalDate oFechaSesion = null;
        LocalTime oHoraSesion = null;
        Lugar oLugar = null;
        EstadoTipoSesion oEstadoTipoSesion = null;
        Estado oEstado;
        String sNombreLugar;
        int iDia, iMes, iAnio, iMinutos, iHoras;
        boolean booFecha = false, booHora = false;
        Sesion oSesion = searchById(oCtrl);

        if (oSesion != null) {
            System.out.println("\nIntroduce los datos Que se tiene que modificar: ");
            System.out.println("Campos requeridos *");

            // Estado
            do {

                oEstado = new Estado(WordUtils.capitalizeFully(String.valueOf(Libreria.leer(
                        "Modifica un estado de sesion ("
                                + oSesion.getoEstadoTipoSesion().getoEstado().getsNombreEstado() + ")",
                        0, BMAXNOMBRELARGO, -1, -1, (byte) 6))));
                if (oEstado.getsNombreEstado() != null) {
                    if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl()
                            .searchByPk(oEstado) != null) {
                        oEstadoTipoSesion = new EstadoTipoSesion(oEstado,
                                oSesion.getoEstadoTipoSesion().getoTipoSesion());

                        if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl()
                                .searchByPk(oEstadoTipoSesion) != null) {
                            oSesion.getoEstadoTipoSesion().setoEstado(oEstado);
                        }
                    }
                }
            } while ((oEstado.getsNombreEstado().length() > BMAXNOMBRELARGO && !oEstado.getsNombreEstado().isEmpty()));

            // Lugar
            if (String
                    .valueOf(Libreria.leer("¿Quiere modificar el lugar de la sesion? (s/n) ("
                            + oSesion.getoLugar().getsNombreLugar() + "): ", -1, -1, -1, -1, (byte) 7))
                    .equalsIgnoreCase("s")) {
                do {
                    do {
                        sNombreLugar = String
                                .valueOf(Libreria.leer("Introduce un nombre *", 0, BMAXNOMBRELUGAR, -1, -1, (byte) 6));
                        sNombreLugar = WordUtils.capitalizeFully(sNombreLugar);
                    } while (!sNombreLugar.isEmpty() && sNombreLugar.length() > BMAXNOMBRELUGAR);
                    oLugar = oCtrl.getConfiguracionCtrl().getoLugarCtrl()
                            .searchByNombreLugar(new Lugar(1, sNombreLugar, null));
                } while (oLugar == null);
                oSesion.setoLugar(oLugar);
            }

            // Fecha
            if (String.valueOf(Libreria.leer(
                    "¿Quiere introducir la fecha de la sesion? (s/n) (" + oSesion.getoFechaSesion() + "): ", -1, -1, -1,
                    -1, (byte) 7)).equalsIgnoreCase("s")) {
                do {
                    try {
                        iDia = (int) Libreria.leer("Introduce el dia *", 1, 31, -1, -1, (byte) 3);
                        iMes = (int) Libreria.leer("Introduce el mes *", 1, 12, -1, -1, (byte) 3);
                        iAnio = (int) Libreria.leer("Introduce el annio *", LocalDate.now().getYear(),
                                (LocalDate.now().getYear() + 5), -1, -1, (byte) 3);
                        oFechaSesion = LocalDate.of(iAnio, iMes, iDia);
                        booFecha = true;
                    } catch (Exception e) {
                        System.out.println("\nHa introducido mal la fecha, vuelva a introducirla");
                    }
                } while (!booFecha);
                oSesion.setoFechaSesion(oFechaSesion);
            }

            // Hora
            if (String.valueOf(
                    Libreria.leer("¿Quiere introducir la hora de la sesion? (s/n) (" + oSesion.getoHoraSesion() + "): ",
                            -1, -1, -1, -1, (byte) 7))
                    .equalsIgnoreCase("s")) {
                do {
                    try {
                        iHoras = (int) Libreria.leer("Introduce la hora *", 0, 23, -1, -1, (byte) 3);
                        iMinutos = (int) Libreria.leer("Introduce los minutos *", 0, 59, -1, -1, (byte) 3);

                        oHoraSesion = LocalTime.of(iHoras, iMinutos);
                        booHora = true;
                    } catch (Exception e) {
                        System.out.println("\nHa introducido mal la hora, vuelva a introducirla");
                    }
                } while (!booHora);
                oSesion.setoHoraSesion(oHoraSesion);
            }
        }
        return oCtrl.getSesionesCtrl().getoSesionCtrl().update(oSesion);
    }

    private static Sesion searchById(Controller oCtrl) {
        int iIdSesion = (int) (Libreria.leer("\nIntroduce un id", 1, IMAXIDS, -1, -1, (byte) 3));
        return oCtrl.searchSesion(new Sesion(iIdSesion));
    }

    public static List<Sesion> searchByCliente(Controller oCtrl) {
        Cliente oCliente;
        String sEmailCliente;
        do {
            sEmailCliente = String.valueOf(Libreria.leer("Introduce un email", 1, 100, -1, -1, (byte) 6));
            oCliente = oCtrl.searchCliente((new Cliente(null, new Usuario(sEmailCliente))));
        } while (oCliente == null);
        return oCtrl.getSesionesCtrl().getoSesionCtrl().searchByCliente(oCliente.getiIdContacto());
    }

    private static boolean remove(Controller oCtrl) {
        boolean bExito = false;
        Sesion oSesion = searchById(oCtrl);

        if (oSesion != null) {
            bExito = oCtrl.getSesionesCtrl().getoSesionCtrl().remove(oSesion);
        }
        return bExito;
    }

    public static List<Sesion> listarSesion(Controller oCtrl) {
        return oCtrl.listarSesion();
    }

    // ###### FOTOGRAFO ######

    private static void listarFotografoDeSesion(Controller oCtrl, Sesion oSesion) {
        if (oCtrl.getSesionesCtrl().getoFotografoSesionCtrl().searchBySesion(oSesion) != null) {
            System.out.println("# Fotografos de la sesion #");
            List<FotografoSesion> lFotografos = oCtrl.listarFotografoSesion(oSesion);
            for (FotografoSesion oFotografoSesion : lFotografos) {
                System.out.println(oFotografoSesion.getoFotografo().getsNombreFotografo());
            }

        } else {
            System.out.println("¡Esta sesion no tiene ningun fotografo asignado!");
        }
    }

    private static boolean asignarFotografo(Controller oCtrl) {
        List<FotografoSesion> lFotografos = new ArrayList<FotografoSesion>();
        FotografoSesion oFotografoSesion = null;
        Fotografo oFotografo = null;
        String sDniFotografo = null;

        if (oCtrl.getSesionesCtrl().getoSesionCtrl().listar() != null && oCtrl.getoFotografoCtrl().listar() != null) {

            Sesion oSesion = new Sesion(
                    (int) (Libreria.leer("Introduce un id de sesion", 1, IMAXIDS, -1, -1, (byte) 3)));

            if (oCtrl.getSesionesCtrl().getoSesionCtrl().searchByPk(oSesion) != null) {

                System.out.println("¡Cuando quiera dejar de instroducir fotografos, dejelo en blanco y pulse ENTER!");
                do {
                    sDniFotografo = (String.valueOf(
                            Libreria.leer("Introduce el dni del fotografo", 0, BMAXDNI, -1, -1, (byte) 6)));

                    if (oCtrl.getoFotografoCtrl().searchByPk(new Fotografo(sDniFotografo)) != null) {

                        oFotografo = new Fotografo(sDniFotografo);
                        oFotografoSesion = new FotografoSesion(oFotografo, oSesion);

                        if (oCtrl.getSesionesCtrl().getoFotografoSesionCtrl().searchByPk(oFotografoSesion) == null) {
                            lFotografos.add(oFotografoSesion);
                            System.out.println("Fotografo preparado");
                        } else {
                            System.out.println("Ese Fotografo ya esta asignado a la sesion");
                        }

                    } else {
                        if (!sDniFotografo.isEmpty()) {
                            System.out.println("¡Este fotografo no esta creado!");
                        }
                    }
                } while (!sDniFotografo.isEmpty());
            } else {
                System.out.println("No existe una sesion con esa id.");
            }

        } else {
            System.out.println("Tiene que haber creado sesiones y fotografo para utilizar esta herramienta");
        }

        return oCtrl.getSesionesCtrl().getoFotografoSesionCtrl().add(lFotografos);
    }

    private static boolean eliminarFotografo(Controller oCtrl) {
        String sDniFotografo;
        int iIdSesion;

        do {
            iIdSesion = (int)(Libreria.leer("Introduce un id de sesion", 1, IMAXIDS, -1, -1, (byte) 3));
            if (oCtrl.getSesionesCtrl().getoFotografoSesionCtrl().searchBySesion(new Sesion(iIdSesion)) == null) {
                System.out.println("Ese Sesion no tiene fotografos asignados");
            }
        } while (oCtrl.getSesionesCtrl().getoFotografoSesionCtrl().searchBySesion(new Sesion(iIdSesion)) == null);

        do {
            sDniFotografo = String
                    .valueOf(Libreria.leer("Introduce el dni del fotogrado", BMINDNI, BMAXDNI, -1, -1, (byte) 6));
            if (oCtrl.getSesionesCtrl().getoFotografoSesionCtrl().searchByPk(new FotografoSesion(new Fotografo(sDniFotografo), new Sesion(iIdSesion))) == null) {
                System.out.println("Ese Fotografo no esta asignado a esa sesion");
            }
        } while (oCtrl.getSesionesCtrl().getoFotografoSesionCtrl().searchByPk(
            new FotografoSesion(new Fotografo(sDniFotografo), new Sesion(iIdSesion))) == null);

        return oCtrl.getSesionesCtrl().getoFotografoSesionCtrl().remove(new FotografoSesion(new Fotografo(sDniFotografo), new Sesion(iIdSesion)));

    }

    // ###### Participante ######

    private static void listarParticipanteDeSesion(Controller oCtrl, Sesion oSesion) {
        if (oCtrl.getSesionesCtrl().getoParticipanteSesionCtrl().searchBySesion(oSesion) != null) {
            System.out.println("# Participantes de la sesion #");
            List<ParticipanteSesion> lParticipantes = oCtrl.listarParticipanteSesion(oSesion);
            for (ParticipanteSesion oParticipanteSesion : lParticipantes) {
                System.out.println(oParticipanteSesion.getoParticipante().getsNombreContacto() + " " + oParticipanteSesion.getoParticipante().getsApellido1Contacto());
            }

        } else {
            System.out.println("¡Esta sesion no tiene ningun participante asignado!");
        }
    }

    private static boolean asignarParticipante(Controller oCtrl) {
        List<ParticipanteSesion> lParticipantes = new ArrayList<ParticipanteSesion>();
        ParticipanteSesion oParticipanteSesion = null;
        Participante oParticipante = null;
        String sDniParticipante = null;

        if (oCtrl.getSesionesCtrl().getoSesionCtrl().listar() != null && oCtrl.getoParticipanteCtrl().listar() != null) {

            Sesion oSesion = new Sesion(
                    (int) (Libreria.leer("Introduce un id de sesion", 1, IMAXIDS, -1, -1, (byte) 3)));

            if (oCtrl.getSesionesCtrl().getoSesionCtrl().searchByPk(oSesion) != null) {

                System.out.println("¡Cuando quiera dejar de instroducir participantes, dejelo en blanco y pulse ENTER!");
                do {
                    sDniParticipante = (String.valueOf(
                            Libreria.leer("Introduce el dni del participante", 0, BMAXDNI, -1, -1, (byte) 6)));

                    if (oCtrl.getoParticipanteCtrl().searchByPk(new Participante(1, sDniParticipante)) != null) {

                        oParticipante = oCtrl.getoParticipanteCtrl().searchByPk(new Participante(1, sDniParticipante));
                        oParticipanteSesion = new ParticipanteSesion(oParticipante, oSesion);

                        if (oCtrl.getSesionesCtrl().getoParticipanteSesionCtrl().searchByPk(oParticipanteSesion) == null) {
                            lParticipantes.add(oParticipanteSesion);
                            System.out.println("Participante preparado");
                        } else {
                            System.out.println("Ese Participante ya esta asignado a la sesion");
                        }

                    } else {
                        if (!sDniParticipante.isEmpty()) {
                            System.out.println("¡Este participante no esta creado!");
                        }
                    }
                } while (!sDniParticipante.isEmpty());
            } else {
                System.out.println("No existe una sesion con esa id.");
            }

        } else {
            System.out.println("Tiene que haber creado sesiones y participante para utilizar esta herramienta");
        }

        return oCtrl.getSesionesCtrl().getoParticipanteSesionCtrl().add(lParticipantes);
    }

    private static boolean eliminarParticipante(Controller oCtrl) {
        String sDniParticipante;
        int iIdSesion;
        Participante oParticipante;

        do {
            iIdSesion = (int)(Libreria.leer("Introduce un id de sesion", 1, IMAXIDS, -1, -1, (byte) 3));
            if (oCtrl.getSesionesCtrl().getoParticipanteSesionCtrl().searchBySesion(new Sesion(iIdSesion)) == null) {
                System.out.println("Ese Sesion no tiene participantes asignados");
            }
        } while (oCtrl.getSesionesCtrl().getoParticipanteSesionCtrl().searchBySesion(new Sesion(iIdSesion)) == null);

        do {
            sDniParticipante = String
                    .valueOf(Libreria.leer("Introduce el dni del participante", BMINDNI, BMAXDNI, -1, -1, (byte) 6));
                    oParticipante = oCtrl.getoParticipanteCtrl().searchByPk(new Participante(1, sDniParticipante));
            if (oCtrl.getSesionesCtrl().getoParticipanteSesionCtrl().searchByPk(new ParticipanteSesion(oParticipante, new Sesion(iIdSesion))) == null) {
                System.out.println("Ese Participante no esta asignado a esa sesion");
            }

        } while (oCtrl.getSesionesCtrl().getoParticipanteSesionCtrl().searchByPk(
            new ParticipanteSesion(oParticipante, new Sesion(iIdSesion))) == null);

        return oCtrl.getSesionesCtrl().getoParticipanteSesionCtrl().remove(new ParticipanteSesion(oParticipante, new Sesion(iIdSesion)));

    }


    // ###### Producto ######

    private static void listarProductoDeSesion(Controller oCtrl, Sesion oSesion) {
        if (oCtrl.getSesionesCtrl().getoProductoSesionCtrl().searchBySesion(oSesion) != null) {
            System.out.println("# Productos de la sesion #");
            List<ProductoSesion> lProductos = oCtrl.getSesionesCtrl().getoProductoSesionCtrl().listar(oSesion.getiIdSesion());
            for (ProductoSesion oProductoSesion : lProductos) {
                System.out.println(oProductoSesion.getoProducto().getsNombreProducto());
            }

        } else {
            System.out.println("¡Este pack no tiene ningun producto asignado!");
        }
    }

    private static boolean asignarProducto(Controller oCtrl) {
        List<ProductoSesion> lProductos = new ArrayList<ProductoSesion>();
        ProductoSesion oProductoSesion = null;
        Producto oProducto = null;
        String sDniProducto = null;

        if (oCtrl.getSesionesCtrl().getoSesionCtrl().listar() != null && oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoProductoCtrl().listar() != null) {

            Sesion oSesion = new Sesion(
                    (int) (Libreria.leer("Introduce un id de sesion", 1, IMAXIDS, -1, -1, (byte) 3)));

            if (oCtrl.getSesionesCtrl().getoSesionCtrl().searchByPk(oSesion) != null) {

                System.out.println("¡Cuando quiera dejar de instroducir productos, dejelo en blanco y pulse ENTER!");
                do {
                    sDniProducto = (String.valueOf(
                            Libreria.leer("Introduce el nombre del producto", 0, BMAXDNI, -1, -1, (byte) 6)));

                    if (oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoProductoCtrl().searchByPk(new Producto(sDniProducto)) != null) {

                        oProducto = new Producto(sDniProducto);
                        oProductoSesion = new ProductoSesion(oSesion, oProducto);

                        if (oCtrl.getSesionesCtrl().getoProductoSesionCtrl().searchByPk(oProductoSesion) == null) {
                            lProductos.add(oProductoSesion);
                            System.out.println("Producto preparado");
                        } else {
                            System.out.println("Ese Producto ya esta asignado a la sesion");
                        }

                    } else {
                        if (!sDniProducto.isEmpty()) {
                            System.out.println("¡Este producto no esta creado!");
                        }
                    }
                } while (!sDniProducto.isEmpty());
            } else {
                System.out.println("No existe una sesion con esa id.");
            }

        } else {
            System.out.println("Tiene que haber creado sesiones y producto para utilizar esta herramienta");
        }

        return oCtrl.getSesionesCtrl().getoProductoSesionCtrl().add(lProductos);
    }

    private static boolean eliminarProducto(Controller oCtrl) {
        String sDniProducto;
        int iIdSesion;

        do {
            iIdSesion = (int)(Libreria.leer("Introduce un id de sesion", 1, IMAXIDS, -1, -1, (byte) 3));
            if (oCtrl.getSesionesCtrl().getoProductoSesionCtrl().searchBySesion(new Sesion(iIdSesion)) == null) {
                System.out.println("Ese Sesion no tiene productos asignados");
            }
        } while (oCtrl.getSesionesCtrl().getoProductoSesionCtrl().searchBySesion(new Sesion(iIdSesion)) == null);

        do {
            sDniProducto = String
                    .valueOf(Libreria.leer("Introduce el nombre del producto", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
            if (oCtrl.getSesionesCtrl().getoProductoSesionCtrl().searchByPk(new ProductoSesion(new Sesion(iIdSesion), new Producto(sDniProducto))) == null) {
                System.out.println("Ese Producto no esta asignado a esa sesion");
            }
        } while (oCtrl.getSesionesCtrl().getoProductoSesionCtrl().searchByPk(
            new ProductoSesion(new Sesion(iIdSesion), new Producto(sDniProducto))) == null);

        return oCtrl.getSesionesCtrl().getoProductoSesionCtrl().remove(new ProductoSesion(new Sesion(iIdSesion), new Producto(sDniProducto)));

    }

    // ###### Pack ######

    private static void listarPackDeSesion(Controller oCtrl, Sesion oSesion) {
        if (oCtrl.getSesionesCtrl().getoPackSesionCtrl().searchBySesion(oSesion) != null) {
            System.out.println("# Packs de la sesion #");
            List<PackSesion> lPacks = oCtrl.getSesionesCtrl().getoPackSesionCtrl().listar(oSesion.getiIdSesion());
            for (PackSesion oPackSesion : lPacks) {
                System.out.println(oPackSesion.getoPack().getsNombrePack());
            }

        } else {
            System.out.println("¡Este pack no tiene ningun pack asignado!");
        }
    }

    private static boolean asignarPack(Controller oCtrl) {
        List<PackSesion> lPacks = new ArrayList<PackSesion>();
        PackSesion oPackSesion = null;
        Pack oPack = null;
        String sDniPack = null;

        if (oCtrl.getSesionesCtrl().getoSesionCtrl().listar() != null && oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoPackCtrl().listar() != null) {

            Sesion oSesion = new Sesion(
                    (int) (Libreria.leer("Introduce un id de sesion", 1, IMAXIDS, -1, -1, (byte) 3)));

            if (oCtrl.getSesionesCtrl().getoSesionCtrl().searchByPk(oSesion) != null) {

                System.out.println("¡Cuando quiera dejar de instroducir packs, dejelo en blanco y pulse ENTER!");
                do {
                    sDniPack = (String.valueOf(
                            Libreria.leer("Introduce el nombre del pack", 0, BMAXDNI, -1, -1, (byte) 6)));

                    if (oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoPackCtrl().searchByPk(new Pack(sDniPack)) != null) {

                        oPack = new Pack(sDniPack);
                        oPackSesion = new PackSesion(oPack, oSesion);

                        if (oCtrl.getSesionesCtrl().getoPackSesionCtrl().searchByPk(oPackSesion) == null) {
                            lPacks.add(oPackSesion);
                            System.out.println("Pack preparado");
                        } else {
                            System.out.println("Ese Pack ya esta asignado a la sesion");
                        }

                    } else {
                        if (!sDniPack.isEmpty()) {
                            System.out.println("¡Este pack no esta creado!");
                        }
                    }
                } while (!sDniPack.isEmpty());
            } else {
                System.out.println("No existe una sesion con esa id.");
            }

        } else {
            System.out.println("Tiene que haber creado sesiones y pack para utilizar esta herramienta");
        }

        return oCtrl.getSesionesCtrl().getoPackSesionCtrl().add(lPacks);
    }

    private static boolean eliminarPack(Controller oCtrl) {
        String sNombrePack;
        int iIdSesion;

        do {
            iIdSesion = (int)(Libreria.leer("Introduce un id de sesion", 1, IMAXIDS, -1, -1, (byte) 3));
            if (oCtrl.getSesionesCtrl().getoPackSesionCtrl().searchBySesion(new Sesion(iIdSesion)) == null) {
                System.out.println("Esta Sesion no tiene packs asignados");
            }
        } while (oCtrl.getSesionesCtrl().getoPackSesionCtrl().searchBySesion(new Sesion(iIdSesion)) == null);

        do {
            sNombrePack = String
                    .valueOf(Libreria.leer("Introduce el nombre del pack", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
            if (oCtrl.getSesionesCtrl().getoPackSesionCtrl().searchByPk(new PackSesion(new Pack(sNombrePack), new Sesion(iIdSesion))) == null) {
                System.out.println("Este Pack no esta asignado a esa sesion");
            }
        } while (oCtrl.getSesionesCtrl().getoPackSesionCtrl().searchByPk(
            new PackSesion(new Pack(sNombrePack), new Sesion(iIdSesion))) == null);

        return oCtrl.getSesionesCtrl().getoPackSesionCtrl().remove(new PackSesion(new Pack(sNombrePack), new Sesion(iIdSesion)));

    }

}
