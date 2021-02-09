package views;

import controllers.*;

public class TIENDA_DAM {

	public static void main(String[] args) {
		byte bOpcion;
		Controller oCtrl = new Controller();

		do {
			bOpcion = menu();

			switch (bOpcion) {
			case 1: // Gestion de clientes
				ClienteView.gestionClientes(oCtrl);
				break;
			default:
				System.out.println("Hasta luego.");
			}

		} while (bOpcion != 3);
	}

	public static byte menu() {
		System.out.println("##################################");
		System.out.println("Bienvenido a la APP Aurelinex");
		System.out.println("##################################");		
		System.out.println("1. Gestion de clientes");
		System.out.println("2. Salir");
		return (byte) Libreria.leer("Introduce una opcion", 1, 2, -1, -1, (byte) 1);
	}	
}
