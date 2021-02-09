package views;

import controllers.Controller;
import models.Cliente;
import models.Usuario;

public class ClienteView {
	public static byte subMenuClientes() {
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Gestion de clientes");
		System.out.println("-----------------------");
		System.out.println("1. Alta");
		System.out.println("2. Modificar");
		System.out.println("3. Buscar usuario por dni");
		System.out.println("4. Borrar");
		System.out.println("5. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
	}
	
	public static void gestionClientes(Controller oCtrl) {
		switch (ClienteView.subMenuClientes()) {
		case 1: // Alta de cliente
			if(create(oCtrl)) {
				System.out.println("El cliente ha sido creado con exito.");
			}else {
				System.out.println("El cliente no se ha podido crear.");
			}
			break;
		case 2: // Modificar
			if(update(oCtrl)) {
				System.out.println("El cliente ha sido modificado con exito.");
			}else {
				System.out.println("El cliente no se ha podido modificar.");
			}
			break;
		case 3: // Buscar
			int iPosicion = searchByDni(oCtrl);
			if(iPosicion != -1) {
				System.out.println("El cliente buscado existe en la base de datos.");
				System.out.println(oCtrl.getoClientCtrl().getLista().get(iPosicion));
			}else {
				System.out.println("El cliente no existe en la base de datos.");
			}
			break;
		case 4: // Borrar
			if(remove(oCtrl)) {
				System.out.println("El cliente ha sido eliminado con exito.");
			}else {
				System.out.println("El cliente no se ha podido eliminar.");
			}
			break;
		}
	}
	
	private static boolean create(Controller oCtrl) {
		String sDni, sNombre, sApellidos, sDireccion, sNumeroDireccion, sTelefono, sTarjeta, sEmail, sPass;
		
		System.out.println("Introduce los datos basicos del cliente: ");
		sDni = String.valueOf(Libreria.leer("Introduce un dni", 9, 9, -1, -1, (byte)6));
		sNombre = String.valueOf(Libreria.leer("Introduce un nombre", 1, 250, -1, -1, (byte)6));
		sApellidos = String.valueOf(Libreria.leer("Introduce unos apellidos", 1, 250, -1, -1, (byte)6));
		sDireccion = String.valueOf(Libreria.leer("Introduce una direccion", 1, 250, -1, -1, (byte)6));
		sNumeroDireccion = String.valueOf(Libreria.leer("Introduce un numero de direccion", 1, 250, -1, -1, (byte)6));
		sTelefono = String.valueOf(Libreria.leer("Introduce un telefono", 9, 9, -1, -1, (byte)6));
		sTarjeta = String.valueOf(Libreria.leer("Introduce una tarjeta", 16, 16, -1, -1, (byte)6));
		
		System.out.println("\nIntroduce ahora los datos del usuario asociado: ");		
		sEmail = String.valueOf(Libreria.leer("Introduce un email", 1, 250, -1, -1, (byte)6));
		sPass = String.valueOf(Libreria.leer("Introduce una contrasena", 1, 250, -1, -1, (byte)6));
		
		return oCtrl.addCliente(new Cliente(sDni, sNombre, sApellidos, sDireccion, sNumeroDireccion,
				sTelefono, new Usuario(sEmail, sPass), sTarjeta));
	}
	
	private static boolean update(Controller oCtrl) {
		String sDni,sNombre, sApellidos, sDireccion, sNumeroDireccion, sTelefono, sTarjeta;
		int iPosicion = -1;
		boolean bExito = false;
		sDni = String.valueOf(Libreria.leer("Introduce un DNI", 9, 9, -1, -1, (byte)6));
		iPosicion = oCtrl.getoClientCtrl().searchPosition(new Cliente(sDni));
		if(iPosicion != -1) {
			Cliente oCliente = oCtrl.getoClientCtrl().getLista().get(iPosicion);
			
			sNombre = String.valueOf(Libreria.leer("Introduce un nombre", 1, 250, -1, -1, (byte)6));
			oCliente.setsNombre(sNombre);
			
			sApellidos = String.valueOf(Libreria.leer("Introduce unos apellidos", 1, 250, -1, -1, (byte)6));
			oCliente.setsApellidos(sApellidos);
			
			sDireccion = String.valueOf(Libreria.leer("Introduce una direccion", 1, 250, -1, -1, (byte)6));
			oCliente.setsDireccion(sDireccion);
			
			sNumeroDireccion = String.valueOf(Libreria.leer("Introduce un numero de direccion", 1, 250, -1, -1, (byte)6));
			oCliente.setsNumeroDireccion(sNumeroDireccion);
			
			sTelefono = String.valueOf(Libreria.leer("Introduce un telefono", 9, 9, -1, -1, (byte)6));
			oCliente.setsTelefono(sTelefono);
			
			sTarjeta = String.valueOf(Libreria.leer("Introduce una tarjeta", 16, 16, -1, -1, (byte)6));
			oCliente.setsTarjeta(sTarjeta);					
			
			bExito = oCtrl.getoClientCtrl().update(oCliente);
		}
		return bExito;
	}
	
	private static int searchByDni(Controller oCtrl) {
		String sDni = String.valueOf(Libreria.leer("Introduce un dni", 9, 9, -1, -1, (byte)6));
		return oCtrl.getoClientCtrl().searchPosition(new Cliente(sDni));
	}
	
	private static boolean remove(Controller oCtrl) {
		String sDni;
		int iPosicion = -1;
		boolean bExito = false;
		sDni = String.valueOf(Libreria.leer("Introduce un dni", 9, 9, -1, -1, (byte)6));
		iPosicion = oCtrl.getoClientCtrl().searchPosition(new Cliente(sDni));
		
		if(iPosicion != -1) {
			Cliente oCliente = oCtrl.getoClientCtrl().getLista().get(iPosicion);
			bExito = oCtrl.removeCliente(oCliente);
		}
		return bExito;
	}
}
