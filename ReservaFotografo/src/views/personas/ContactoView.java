package views.personas;

import controllers.Controller;
import views.Libreria;

public class ContactoView {
    
    public static void gestionContato(Controller oCtrl) {

        byte bOpcion;

        do {
            
            bOpcion = subMenuContacto();

            switch (bOpcion) {
            case 1: // Gestion de clientes
                ClienteView.gestionClientes(oCtrl);
                break;
            case 2: // Gestion de participantes
                ParticipanteView.gestionParticipante(oCtrl);
                break;
            case 3: // Gestion de participantes
                FotografoView.gestionFotografo(oCtrl);
                break;
            default:
            }

        } while (bOpcion != 4);
    }

    public static byte subMenuContacto() {
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Gestion de contactos");
		System.out.println("-----------------------");
		System.out.println("1. Gestion de clientes");
        System.out.println("2. Gestion de participantes");
		System.out.println("3. Gestion de fotografos");
        System.out.println("4. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 4, -1, -1, (byte) 1);
	}
}
