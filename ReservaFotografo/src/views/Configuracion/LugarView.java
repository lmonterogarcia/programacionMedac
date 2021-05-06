package views.Configuracion;

import java.util.*;

import org.apache.commons.lang.WordUtils;

import controllers.Controller;
import models.IPlantilla;
import models.lugar.Lugar;
import views.Libreria;

public class LugarView implements IPlantilla{

    public static byte subMenuLugar() {
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Gestion de Sitio");
        System.out.println("-----------------------");
        System.out.println("1. Alta");
        System.out.println("2. Modificar");
        System.out.println("3. Buscar sitio por nombre");
        System.out.println("4. Borrar");
        System.out.println("5. Listar");
        System.out.println("6. Volver atras");
        return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
    }

    public static void gestionLugar(Controller oCtrl) {
        byte bOpcion;
        do {
            bOpcion = subMenuLugar();

            switch (bOpcion) {
                case 1: // Alta de sitio
                    if (create(oCtrl)) {
                        System.out.println("El sitio ha sido creado con exito.");
                    } else {
                        System.out.println("El sitio no se ha podido crear.");
                    }
                    break;
                case 2: // Modificar sitio
                    if (update(oCtrl)) {
                        System.out.println("El sitio ha sido modificado con exito.");
                    } else {
                        System.out.println("El sitio no se ha podido modificar.");
                    }
                    break;

                case 3: // Buscar sitio
                    Lugar oLugar = searchByNombre(oCtrl);
                    if (oLugar != null) {
                        System.out.println("El sitio buscado existe en la base de datos.");
                        System.out.println(oLugar);
                    } else {
                        System.out.println("El sitio no existe en la base de datos.");
                    }
                    break;
                case 4: // Borrar sitio
                    if (remove(oCtrl)) {
                        System.out.println("El sitio ha sido eliminado con exito.");
                    } else {
                        System.out.println("El sitio no se ha podido eliminar.");
                    }
                    break;
                case 5: // Listar sitio
                    List<Lugar> lLugares = listarSitio(oCtrl);
                    if (lLugares != null && !lLugares.isEmpty()) {
                        System.out.println("\n### Lista de sitios ###");
                        for (Lugar oLugL : lLugares) {
                            System.out.println(" Nombre de sitio: " + oLugL.getsNombreLugar());
                        }
                        if (String.valueOf(Libreria.leer("¿Quiere mas informacion de alguna lugar? (s/n) ",
                                -1, -1, -1, -1, (byte) 7)).equalsIgnoreCase("s")) {
                            Lugar oLug = searchByNombre(oCtrl);
                            if (oLug != null) {
                                System.out.println(oLug);
                            } else {
                                System.out.println("El sitio no existe en la base de datos.");
                            }
                        }
                    } else {
                        System.out.println("No hay ninguna lugar");
                    }
                    break;
            }
        } while (bOpcion != 4);

    }

    private static boolean create(Controller oCtrl) {
        String sNombreLugar, sGoogleMapLink;
        float fLatitud, fLongitud;

        System.out.println("\nIntroduce los datos del sitio: ");
        System.out.println("Campos requeridos *");

        sNombreLugar = String.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRELUGAR, -1, -1, (byte) 6));
        sNombreLugar = WordUtils.capitalizeFully(sNombreLugar);
        do {
            sGoogleMapLink = String.valueOf(Libreria.leer("Introduce un link de googlemaps", 0, BMAX255, -1, -1, (byte) 6));
        } while (!sGoogleMapLink.isEmpty() && sGoogleMapLink.length() > BMAX255);
        fLatitud = (float)(Libreria.leer("Introduce una latitud gps, si no quiere poner nada introduzca 0", -1, -1, IMINLATITUD, IMAXLATITUD, (byte) 5));
        fLongitud = (float)(Libreria.leer("Introduce una longitud gps, si no quiere poner nada introduzca 0", -1, -1, IMINLONGITUD, IMAXLONGITUD, (byte) 5));
        
        

        return oCtrl.getConfiguracionCtrl().addSitio(new Lugar(sNombreLugar, sGoogleMapLink, null, null, fLatitud, fLongitud, null));
    }

    private static boolean update(Controller oCtrl) {
        String sGoogleMapLink;
        float fLatitud, fLongitud;
        boolean booExito = false;
        Lugar oLugar = searchByNombre(oCtrl);

        if (oLugar != null) {
            if (oLugar != null && oLugar.checkLugar()) {
                System.out.println("Modifica los datos de la lugar: ");
        do {
            sGoogleMapLink = String.valueOf(Libreria.leer("Introduce un link de googlemaps (" + oLugar.getsGoogleMapLink() + ")", 0, BMAX255, -1, -1, (byte) 6));
        } while (!sGoogleMapLink.isEmpty() && sGoogleMapLink.length() != BMAX255);
        oLugar.setsGoogleMapLink(sGoogleMapLink);

        fLatitud = (float)(Libreria.leer("Introduce una latitud gps, si no quiere cambiarlo, introduxca la misma (" + oLugar.getfLatitud() + ")", -1, -1, IMINLATITUD, IMAXLATITUD, (byte) 5));
        oLugar.setfLatitud(fLatitud);

        fLongitud = (float)(Libreria.leer("Introduce una longitud gps, si no quiere cambiarlo, introduxca la misma (" + oLugar.getfLongitud() + ")", -1, -1, IMINLONGITUD, IMAXLONGITUD, (byte) 5));
        oLugar.setfLongitud(fLongitud);
                
        booExito = oCtrl.getConfiguracionCtrl().getoLugarCtrl().update(oLugar);
            }
        }

        return booExito;
    }

    private static Lugar searchByNombre(Controller oCtrl) {
        String sNombreLugar;
        sNombreLugar = String.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRELUGAR, -1, -1, (byte) 6));
        return oCtrl.getConfiguracionCtrl().getoLugarCtrl().searchByNombreLugar(new Lugar(1, sNombreLugar, null));
    }

    private static boolean remove(Controller oCtrl) {
        boolean bExito = false;
        Lugar oLugar = searchByNombre(oCtrl);
        bExito = oCtrl.getConfiguracionCtrl().getoLugarCtrl().remove(oLugar);

        return bExito;
    }

    public static List<Lugar> listarSitio(Controller oCtrl) {
        return oCtrl.getConfiguracionCtrl().getoLugarCtrl().listar();
    }
    
}
