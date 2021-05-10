package views.sesiones;

import controllers.Controller;
import views.Libreria;

public class SesionesView {
    
    public static void gestionSesiones(Controller oCtrl) {
        byte bOpcion;

        do {

            bOpcion = subMenuConfiguracion();

            switch (bOpcion) {
            case 1: // Gestion de empresa
                PedidoView.gestionPedido(oCtrl);
                break;
            case 2: // Gestion de tipo y estado de Sesion
                SesionView.gestionSesion(oCtrl);
                break;
            default:
            }

        } while (bOpcion != 3);
    }

    public static byte subMenuConfiguracion() {
		System.out.println("");
		System.out.println("-----------------------------");
		System.out.println("Gestion de pedidos y sesiones");
		System.out.println("-----------------------------");
		System.out.println("1. Gestion de pedidos");
        System.out.println("2. Gestion de sesiones");
        System.out.println("3. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 3, -1, -1, (byte) 1);
	}
}
