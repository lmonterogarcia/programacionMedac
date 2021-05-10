package views.sesiones;

import java.time.*;
import java.util.*;

import org.apache.commons.lang3.text.WordUtils;

import controllers.Controller;
import models.IPlantilla;
import models.lugar.Lugar;
import models.personas.*;
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

                default:
                    break;
            }
        } while (bOpcion != 6 || bOpcion != 0);

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

                oEstado = new Estado(WordUtils.capitalizeFully(String.valueOf(
                        Libreria.leer("Modifica un estado de sesion (" + oSesion.getoEstadoTipoSesion().getoEstado().getsNombreEstado() + ")", 0, BMAXNOMBRELARGO, -1, -1, (byte) 6))));
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
                    .valueOf(Libreria.leer("¿Quiere modificar el lugar de la sesion? (s/n) (" + oSesion.getoLugar().getsNombreLugar() + "): ", -1, -1, -1, -1, (byte) 7))
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
            if (String
                    .valueOf(
                            Libreria.leer("¿Quiere introducir la fecha de la sesion? (s/n) (" + oSesion.getoFechaSesion() + "): ", -1, -1, -1, -1, (byte) 7))
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
                oSesion.setoFechaSesion(oFechaSesion);
            }

            // Hora
            if (String
                    .valueOf(Libreria.leer("¿Quiere introducir la hora de la sesion? (s/n) (" + oSesion.getoHoraSesion() + "): ", -1, -1, -1, -1, (byte) 7))
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

}
