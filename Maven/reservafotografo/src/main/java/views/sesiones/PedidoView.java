package views.sesiones;

import java.util.List;

import controllers.Controller;
import models.IPlantilla;
import models.personas.Empresa;
import models.sesion.Pedido;
import views.Libreria;

public class PedidoView implements IPlantilla {

    public static byte subMenuPedido(Controller oCtrl) {
        byte bOpcion = 0;
        if (oCtrl.getConfiguracionCtrl().getoEmpresaCtrl().listar() != null) {
            System.out.println("");
            System.out.println("------------------");
            System.out.println("Gestion de pedidos");
            System.out.println("------------------");
            System.out.println("1. Alta");
            System.out.println("2. Modificar");
            System.out.println("3. Buscar pedido por id");
            System.out.println("4. Borrar");
            System.out.println("5. Listar pedidos");
            System.out.println("6. Volver atras");
            bOpcion = (byte) Libreria.leer("Introduce una opcion", 1, 6, -1, -1, (byte) 1);
        } else {
            System.out.println("\n¡¡Para poder gestionar pedidos tiene que tener creado al menos una Empresa!!\n");
        }
        return bOpcion;
    }

    public static void gestionPedido(Controller oCtrl) {
        byte bOpcion;
        do {
            bOpcion = subMenuPedido(oCtrl);
            switch (bOpcion) {
                case 1: // Alta de pedido
                    int iIdPedido = create(oCtrl);
                    if (iIdPedido > 0) {
                        System.out.println("El pedido ha sido creado con exito.");
                        System.out.println("El numero de pedido creado es " + iIdPedido);
                    } else {
                        System.out.println("El pedido no se ha podido crear.");
                    }
                    break;
                case 2: // Modificar
                    if (update(oCtrl)) {
                        System.out.println("El pedido ha sido modificado con exito.");
                    } else {
                        System.out.println("El pedido no se ha podido modificar.");
                    }
                    break;
                case 3: // Buscar
                    Pedido oPedido = searchById(oCtrl);
                    if (oPedido != null) {
                        System.out.println("El pedido buscado existe en la base de datos.");
                        System.out.println(oPedido);
                    } else {
                        System.out.println("El pedido no existe en la base de datos.");
                    }
                    break;
                case 4: // Borrar
                    if (remove(oCtrl)) {
                        System.out.println("El pedido ha sido eliminado con exito.");
                    } else {
                        System.out.println("El pedido no se ha podido eliminar.");
                    }
                    break;
                case 5: // Listar
                    List<Pedido> lPedidos = listarPedido(oCtrl);
                    if (lPedidos != null && !lPedidos.isEmpty()) {
                        System.out.println("\n### Lista de tipo de pedidos ###");
                        for (Pedido oPedL : lPedidos) {
                            System.out.println(" Id de pedido: " + oPedL.getiIdPedido() + " - Empresa: "
                                    + oPedL.getoEmpresa().getsNombreEmpresa() + " - Pagado: "
                                    + (oPedL.isBooPagado() ? "Pagado" : "NO PAGADO"));
                        }
                    } else {
                        System.out.println("No hay ninguna pedidos");
                    }
                    break;
            }
        } while (bOpcion != 6 || bOpcion != 0);

    }

    private static int create(Controller oCtrl) {
        String sCifNif;

        System.out.println("\nIntroduce los datos del pedido: ");
        System.out.println("Campos requeridos *");

        sCifNif = String.valueOf(Libreria.leer("Introduce el cif de la empresa *", 1, BMAXDNI, -1, -1, (byte) 6));

        return oCtrl.getSesionesCtrl().getoPedidoCtrl().add(new Pedido(false, new Empresa(sCifNif)));
    }

    private static boolean update(Controller oCtrl) {
        int iIdPedido;
        boolean booExito = false, booPagado;

        iIdPedido = (int) (Libreria.leer("\nIntroduce un id", 1, IMAXIDS, -1, -1, (byte) 3));
        Pedido oPedido = oCtrl.getSesionesCtrl().getoPedidoCtrl().searchByPk(new Pedido(iIdPedido));
        booPagado = oPedido.isBooPagado();
        if (oPedido != null) {
            if (oPedido != null && oPedido.checkPedido()) {

                System.out.println("Modifica si ha sido pagado o no: ");
                if (String.valueOf(Libreria.leer(
                        "¿Ha sido pagado? (S/N) ("
                                + (oPedido.isBooPagado() == true ? "pagado" : "no pagado") + "):",
                        -1, -1, -1, -1, (byte) 7)).equalsIgnoreCase("s")) {
                    booPagado = true;
                } else {
                    booPagado = false;
                }
                // do {
                // sLetra = String
                // .valueOf(Libreria.leer("¿Ha sido pagado?(s/n) (" + (oPedido.isBooPagado() ==
                // true ? "pagado" : "no pagado") + ")",
                // 1, 1, -1, -1, (byte) 6));
                // if (sLetra == "s" || sLetra == "S") {
                // booPagado = true;
                // } else if (sLetra == "n" || sLetra == "N") {
                // booPagado = false;
                // }
                // } while (sLetra != "s" && sLetra != "S" && sLetra != "n" && sLetra != "N");
                oPedido.setBooPagado(booPagado);
                booExito = oCtrl.getSesionesCtrl().getoPedidoCtrl().update(oPedido);
            }
        }

        return booExito;
    }

    private static Pedido searchById(Controller oCtrl) {
        int iIdPedido = (int) (Libreria.leer("\nIntroduce un id", 1, IMAXIDS, -1, -1, (byte) 3));
        return oCtrl.searchPedido(new Pedido(iIdPedido));
    }

    private static boolean remove(Controller oCtrl) {
        boolean bExito = false;
        Pedido oPedido = searchById(oCtrl);

        if (oPedido != null) {
            bExito = oCtrl.getSesionesCtrl().getoPedidoCtrl().remove(oPedido);
        }
        return bExito;
    }

    public static List<Pedido> listarPedido(Controller oCtrl) {
        return oCtrl.listarPedidos();
    }
}
