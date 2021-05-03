package views.Configuracion;

import controllers.Controller;
import views.Libreria;

public class LugarView {
/*
    public static byte subMenuLugar() {
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Gestion de lugar");
        System.out.println("-----------------------");
        System.out.println("1. Gestion de direccion");
        System.out.println("2. Gestion de sitios");
        System.out.println("3. Listar lugares");
        System.out.println("4. Volver atras");
        return (byte) Libreria.leer("Introduce una opcion", 1, 4, -1, -1, (byte) 1);
    }

    public static byte subMenuDireccion() {
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Gestion de Direccion");
        System.out.println("-----------------------");
        System.out.println("1. Alta");
        System.out.println("2. Modificar");
        System.out.println("3. Buscar Direccion por id");
        System.out.println("4. Buscar Direccion por calle y numero");
        System.out.println("5. Borrar");
        System.out.println("6. Volver atras");
        return (byte) Libreria.leer("Introduce una opcion", 1, 6, -1, -1, (byte) 1);
    }

    public static byte subMenuSitio() {
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Gestion de Sitio");
        System.out.println("-----------------------");
        System.out.println("1. Alta");
        System.out.println("2. Modificar");
        System.out.println("3. Buscar sitio por nombre");
        System.out.println("4. Borrar");
        System.out.println("5. Volver atras");
        return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
    }

    public static void gestionLugar(Controller oCtrl) {
        byte bOpcion;
        do {
            bOpcion = subMenuLugar();

            switch (bOpcion) {
                case 1: // Direccion
                    do {
                        bOpcion = subMenuDireccion();

                        switch (bOpcion) {
                            case 1: // Alta de lugar
                                if (create(oCtrl)) {
                                    System.out.println("La lugar ha sido creado con exito.");
                                } else {
                                    System.out.println("La lugar no se ha podido crear.");
                                }
                                break;
                            case 2: // Modificar
                                if (update(oCtrl)) {
                                    System.out.println("La lugar ha sido modificado con exito.");
                                } else {
                                    System.out.println("La lugar no se ha podido modificar.");
                                }
                                break;

                            case 3: // Buscar
                                Lugar oLugar = searchByCifDni(oCtrl);
                                if (oLugar != null) {
                                    System.out.println("La lugar buscado existe en la base de datos.");
                                    System.out.println(oLugar);
                                } else {
                                    System.out.println("La lugar no existe en la base de datos.");
                                }
                                break;
                            case 4: // Borrar
                                if (remove(oCtrl)) {
                                    System.out.println("La lugar ha sido eliminado con exito.");
                                } else {
                                    System.out.println("La lugar no se ha podido eliminar.");
                                }
                                break;
                            case 5: // Listar
                                List<Lugar> lLugars = listarLugar(oCtrl);
                                if (lLugars != null && !lLugars.isEmpty()) {
                                    System.out.println("\n### Lista de lugars ###");
                                    for (Lugar oEmpL : lLugars) {
                                        System.out.println(" Nombre de lugar: " + oEmpL.getsNombreLugar()
                                                + " - Cif o Nif: " + oEmpL.getsCifNif());
                                    }
                                    if (String.valueOf(Libreria.leer("¿Quiere mas informacion de alguna lugar? (s/n) ",
                                            -1, -1, -1, -1, (byte) 7)).equalsIgnoreCase("s")) {
                                        Lugar oEmp = searchByCifDni(oCtrl);
                                        if (oEmp != null) {
                                            System.out.println(oEmp);
                                        } else {
                                            System.out.println("La lugar no existe en la base de datos.");
                                        }
                                    }
                                } else {
                                    System.out.println("No hay ninguna lugar");
                                }
                                break;
                        }
                    } while (bOpcion != 6);
                    break;
                case 2: // Sitio
                    do {
                        bOpcion = subMenuSitio();

                        switch (bOpcion) {
                            case 1: // Alta de lugar
                                if (create(oCtrl)) {
                                    System.out.println("La lugar ha sido creado con exito.");
                                } else {
                                    System.out.println("La lugar no se ha podido crear.");
                                }
                                break;
                            case 2: // Modificar
                                if (update(oCtrl)) {
                                    System.out.println("La lugar ha sido modificado con exito.");
                                } else {
                                    System.out.println("La lugar no se ha podido modificar.");
                                }
                                break;

                            case 3: // Buscar
                                Lugar oLugar = searchByCifDni(oCtrl);
                                if (oLugar != null) {
                                    System.out.println("La lugar buscado existe en la base de datos.");
                                    System.out.println(oLugar);
                                } else {
                                    System.out.println("La lugar no existe en la base de datos.");
                                }
                                break;
                            case 4: // Borrar
                                if (remove(oCtrl)) {
                                    System.out.println("La lugar ha sido eliminado con exito.");
                                } else {
                                    System.out.println("La lugar no se ha podido eliminar.");
                                }
                                break;
                            case 5: // Listar
                                List<Lugar> lLugars = listarLugar(oCtrl);
                                if (lLugars != null && !lLugars.isEmpty()) {
                                    System.out.println("\n### Lista de lugars ###");
                                    for (Lugar oEmpL : lLugars) {
                                        System.out.println(" Nombre de lugar: " + oEmpL.getsNombreLugar()
                                                + " - Cif o Nif: " + oEmpL.getsCifNif());
                                    }
                                    if (String.valueOf(Libreria.leer("¿Quiere mas informacion de alguna lugar? (s/n) ",
                                            -1, -1, -1, -1, (byte) 7)).equalsIgnoreCase("s")) {
                                        Lugar oEmp = searchByCifDni(oCtrl);
                                        if (oEmp != null) {
                                            System.out.println(oEmp);
                                        } else {
                                            System.out.println("La lugar no existe en la base de datos.");
                                        }
                                    }
                                } else {
                                    System.out.println("No hay ninguna lugar");
                                }
                                break;
                        }
                    } while (bOpcion != 5);
                    break;
                case 3: // Listar
                    List<Lugar> lLugars = listarLugar(oCtrl);
                    if (lLugars != null && !lLugars.isEmpty()) {
                        System.out.println("\n### Lista de lugars ###");
                        for (Lugar oEmpL : lLugars) {
                            System.out.println(" Nombre de lugar: " + oEmpL.getsNombreLugar() + " - Cif o Nif: "
                                    + oEmpL.getsCifNif());
                        }
                        if (String.valueOf(Libreria.leer("¿Quiere mas informacion de alguna lugar? (s/n) ", -1, -1, -1,
                                -1, (byte) 7)).equalsIgnoreCase("s")) {
                            Lugar oEmp = searchByCifDni(oCtrl);
                            if (oEmp != null) {
                                System.out.println(oEmp);
                            } else {
                                System.out.println("La lugar no existe en la base de datos.");
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
        String sCifNif, sNombreLugar, sEmailLugar, sTelefonoLugar;
        Lugar oLugar;

        System.out.println("\nIntroduce los datos del lugar: ");
        System.out.println("Campos requeridos *");
        do {
            sCifNif = String.valueOf(Libreria.leer("Introduce un cif o nif *", 1, BMAXDNI, -1, -1, (byte) 6));
        } while (!sCifNif.isEmpty() && sCifNif.length() != BMAXDNI && Pattern.matches(SPATRONDNI, sCifNif));
        do {
            sNombreLugar = String.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
        } while (!sNombreLugar.isEmpty() && sNombreLugar.length() > BMAXNOMBRELARGO);
        do {
            sEmailLugar = String.valueOf(Libreria.leer("Introduce un email", 0, BMAXEMAIL, -1, -1, (byte) 6));
        } while (!sEmailLugar.isEmpty() && sEmailLugar.length() > BMAXEMAIL);
        do {
            sTelefonoLugar = String.valueOf(Libreria.leer("Introduce un telefono", 0, BMAXTELEFONO, -1, -1, (byte) 6));
        } while (!sTelefonoLugar.isEmpty() && sTelefonoLugar.length() > BMAXTELEFONO);
        // NO SE IMPLEMENTA OLUGAR HASTA QUE NO SE CREEN LAS VISTAS Y CONTROLADORES DE
        // LUGAR
        oLugar = new Lugar(1, "pruebas", "pruebas"); // #@#@#@#@@#@@#@#@#@#@#@#@#@#@#@#@

        return oCtrl.getConfiguracionCtrl().getoLugarCtrl()
                .add(new Lugar(sCifNif, sNombreLugar, sEmailLugar, sTelefonoLugar, oLugar));
    }

    private static boolean update(Controller oCtrl) {
        String sNombreLugar, sEmailLugar, sTelefonoEmrpesa;
        // Lugar oLugar;
        boolean booExito = false;
        Lugar oLugar = searchByCifDni(oCtrl);

        if (oLugar != null) {
            if (oLugar != null && oLugar.checkLugar()) {
                System.out.println("Modifica los datos de la lugar: ");

                do {
                    sNombreLugar = String
                            .valueOf(Libreria.leer("Introduce un nombre (" + oLugar.getsNombreLugar() + ")", 0,
                                    BMAXNOMBRELARGO, -1, -1, (byte) 6));
                } while (!sNombreLugar.isEmpty() && sNombreLugar.length() > BMAXNOMBRELARGO);
                oLugar.setsNombreLugar(sNombreLugar);

                do {
                    sEmailLugar = String.valueOf(Libreria.leer("Introduce un email (" + oLugar.getsEmailLugar() + ")",
                            0, BMAXEMAIL, -1, -1, (byte) 6));
                } while (!sEmailLugar.isEmpty() && sEmailLugar.length() > BMAXEMAIL);
                oLugar.setsEmailLugar(sEmailLugar);

                do {
                    sTelefonoEmrpesa = String
                            .valueOf(Libreria.leer("Introduce un telefono (" + oLugar.getsTelefonoEmrpesa() + ")", 0,
                                    BMAXTELEFONO, -1, -1, (byte) 6));
                } while (!sTelefonoEmrpesa.isEmpty() && sTelefonoEmrpesa.length() > BMAXTELEFONO);
                oLugar.setsTelefonoEmrpesa(sTelefonoEmrpesa);

                // NO SE IMPLEMENTA OLUGAR HASTA QUE NO SE CREEN LAS VISTAS Y CONTROLADORES DE
                // LUGAR
                // oLugar = new Lugar(1,"pruebas","pruebas"); //#@#@#@#@@#@@#@#@#@#@#@#@#@#@#@#@

                booExito = oCtrl.getConfiguracionCtrl().getoLugarCtrl().update(oLugar);
            }
        }

        return booExito;
    }

    private static Lugar searchByCifDni(Controller oCtrl) {
        String sCifNif;
        do {
            sCifNif = String.valueOf(Libreria.leer("Introduce un cif o nif *", 1, BMAXDNI, -1, -1, (byte) 6));
        } while (!sCifNif.isEmpty() && sCifNif.length() != BMAXDNI && Pattern.matches(SPATRONDNI, sCifNif));
        return oCtrl.getConfiguracionCtrl().searchLugar(new Lugar(sCifNif));
    }

    private static boolean remove(Controller oCtrl) {
        boolean bExito = false;
        String sCifNif;
        do {
            sCifNif = String.valueOf(Libreria.leer("Introduce un cif o nif ", 1, BMAXDNI, -1, -1, (byte) 6));
        } while (!sCifNif.isEmpty() && sCifNif.length() != BMAXDNI && Pattern.matches(SPATRONDNI, sCifNif));

        bExito = oCtrl.getConfiguracionCtrl().getoLugarCtrl().remove(new Lugar(sCifNif));

        return bExito;
    }

    public static List<Lugar> listarLugar(Controller oCtrl) {
        return oCtrl.getConfiguracionCtrl().getoLugarCtrl().listar();
    }
    */
}
