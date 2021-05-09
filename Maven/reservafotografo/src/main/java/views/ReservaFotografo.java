package views;

import controllers.Controller;
import views.Configuracion.*;
import views.personas.*;
import views.sesiones.SesionesView;

public class ReservaFotografo {
        public static void main(String[] args) throws Exception {
                
                byte bOpcion;
                Controller oCtrl = new Controller();

				if (oCtrl.init()) {
                        do {
				bOpcion = menu();

				switch (bOpcion) {
				case 1: // Gestion de clientes
					ContactoView.gestionContato(oCtrl);
					break;
                 case 2: // Gestion de configuracion (Lugar, productos, empresa y tipo y estado sesion)
					ConfiguracionView.gestionConfiguracion(oCtrl);
					break;
					case 3: // Gestion de Sesiones (Pedidos y Sesiones)
					SesionesView.gestionSesiones(oCtrl);
					break;
				default:
					System.out.println("Hasta luego.");
				}
			} while (bOpcion != 4);
			oCtrl.closeDb();
                } else {
                        System.out.println("Error al conectar con la base de datos.");
                }
        }

        public static byte menu() {
		System.out.println("\n###############################################");
		System.out.println("## Bienvenido a la APP de Reserva Fotografos ##");
		System.out.println("###############################################");
		System.out.println("1. Gestion de contactos");
        System.out.println("2. Gestion de configuracion");
		System.out.println("3. Gestion de pedidos y sesiones");
		System.out.println("4. Salir");
		return (byte) Libreria.leer("Introduce una opcion", 1, 4, -1, -1, (byte) 1);
	}
}
