package views;

import java.util.List;

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
		System.out.println("5. Buscar clientes por direccion");
		System.out.println("6. Mostrar contraseña por DNI");
		System.out.println("7. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 7, -1, -1, (byte) 1);
	}

	public static void gestionClientes(Controller oCtrl) {
		switch (ClienteView.subMenuClientes()) {
		case 1: // Alta de cliente
			if (create(oCtrl)) {
				System.out.println("El cliente ha sido creado con exito.");
			} else {
				System.out.println("El cliente no se ha podido crear.");
			}
			break;
		case 2: // Modificar
			if (update(oCtrl)) {
				System.out.println("El cliente ha sido modificado con exito.");
			} else {
				System.out.println("El cliente no se ha podido modificar.");
			}
			break;
		case 3: // Buscar
			Cliente oCliente = searchByDni(oCtrl);
			if (oCliente != null) {
				System.out.println("El cliente buscado existe en la base de datos.");
				System.out.println(oCliente);
			} else {
				System.out.println("El cliente no existe en la base de datos.");
			}
			break;
		case 4: // Borrar
			if (remove(oCtrl)) {
				System.out.println("El cliente ha sido eliminado con exito.");
			} else {
				System.out.println("El cliente no se ha podido eliminar.");
			}
			break;
		case 5: // Mostrar clientes por direccion
			List<Cliente> oListaClientes = searchByDireccion(oCtrl);
			if (oListaClientes != null && !oListaClientes.isEmpty()) {
				for (Cliente oCli : oListaClientes) {
					System.out.println("Nombre: " + oCli.getsNombre() + " " + oCli.getsApellidos());
				}
			} else {
				System.out.println("No existen clientes con esa direccion.");
			}
			break;
		case 6: // Mostrar contraseña por DNI
			Usuario oUser = searchUserByDni(oCtrl);
			if (oUser != null) {
				System.out.println("Contraseña: " + oUser.getsPassword());
			} else {
				System.out.println("No existen clientes con ese DNI.");
			}
			break;
		}
	}

	private static boolean create(Controller oCtrl) {
		String sDni, sNombre, sApellidos, sDireccion, sNumeroDireccion, sTelefono, sTarjeta, sEmail, sPass;

		System.out.println("Introduce los datos basicos del cliente: ");
		sDni = String.valueOf(Libreria.leer("Introduce un dni", 9, 9, -1, -1, (byte) 6));
		sNombre = String.valueOf(Libreria.leer("Introduce un nombre", 1, 250, -1, -1, (byte) 6));
		sApellidos = String.valueOf(Libreria.leer("Introduce unos apellidos", 1, 250, -1, -1, (byte) 6));
		sDireccion = String.valueOf(Libreria.leer("Introduce una direccion", 0, 250, -1, -1, (byte) 6));
		sNumeroDireccion = String.valueOf(Libreria.leer("Introduce un numero de direccion", 0, 250, -1, -1, (byte) 6));
		do {
			sTelefono = String.valueOf(Libreria.leer("Introduce un telefono", 0, 9, -1, -1, (byte) 6));
		} while (!sTelefono.isEmpty() && sTelefono.length() != 9);
		do {
			sTarjeta = String.valueOf(Libreria.leer("Introduce una tarjeta", 0, 16, -1, -1, (byte) 6));
		} while (!sTarjeta.isEmpty() && sTarjeta.length() != 16);
		System.out.println("\nIntroduce ahora los datos del usuario asociado: ");
		sEmail = String.valueOf(Libreria.leer("Introduce un email", 1, 250, -1, -1, (byte) 6));
		sPass = String.valueOf(Libreria.leer("Introduce una contrasena", 5, 12, -1, -1, (byte) 6));

		return oCtrl.addCliente(new Cliente(sDni, sNombre, sApellidos, sDireccion, sNumeroDireccion, sTelefono,
				new Usuario(sEmail, sPass), sTarjeta));
	}

	private static boolean update(Controller oCtrl) {

		String sDni, sNombre, sApellidos, sDireccion, sNumeroDireccion, sTelefono, sTarjeta;
		boolean bExito = false;
		sDni = String.valueOf(Libreria.leer("Introduce un DNI", 9, 9, -1, -1, (byte) 6));
		Cliente oCliente = oCtrl.searchCliente(new Cliente(sDni));
		if (oCliente != null) {
			sNombre = String.valueOf(
					Libreria.leer("Introduce un nombre (" + oCliente.getsNombre() + ")", 0, 250, -1, -1, (byte) 6));

			oCliente.setsNombre(sNombre);

			sApellidos = String.valueOf(Libreria.leer("Introduce unos apellidos (" + oCliente.getsApellidos() + ")", 0,
					250, -1, -1, (byte) 6));
			oCliente.setsApellidos(sApellidos);

			sDireccion = String.valueOf(Libreria.leer("Introduce una direccion (" + oCliente.getsDireccion() + ")", 0,
					250, -1, -1, (byte) 6));
			oCliente.setsDireccion(sDireccion);

			sNumeroDireccion = String
					.valueOf(Libreria.leer("Introduce un numero de direccion (" + oCliente.getsNumeroDireccion() + ")",
							0, 250, -1, -1, (byte) 6));
			oCliente.setsNumeroDireccion(sNumeroDireccion);

			sTelefono = String.valueOf(
					Libreria.leer("Introduce un telefono (" + oCliente.getsTelefono() + ")", 0, 9, -1, -1, (byte) 6));
			oCliente.setsTelefono(sTelefono);

			sTarjeta = String.valueOf(
					Libreria.leer("Introduce una tarjeta (" + oCliente.getsTarjeta() + ")", 0, 16, -1, -1, (byte) 6));
			oCliente.setsTarjeta(sTarjeta);

			bExito = oCtrl.updateCliente(oCliente);
		}
		return bExito;
	}

	private static Cliente searchByDni(Controller oCtrl) {
		String sDni = String.valueOf(Libreria.leer("Introduce un dni", 9, 9, -1, -1, (byte) 6));
		return oCtrl.searchCliente(new Cliente(sDni));
	}

	private static boolean remove(Controller oCtrl) {
		String sEmail = String.valueOf(Libreria.leer("Introduce un email", 1, 250, -1, -1, (byte) 6));
		return oCtrl.removeUsuario(new Usuario(sEmail, ""));
	}

	private static List<Cliente> searchByDireccion(Controller oCtrl) {
		String sDireccion = String.valueOf(Libreria.leer("Introduce una direccion", 1, 250, -1, -1, (byte) 6));
		return oCtrl.searchByDireccion(sDireccion);
	}

	private static Usuario searchUserByDni(Controller oCtrl) {
		String sDni = String.valueOf(Libreria.leer("Introduce un dni", 9, 9, -1, -1, (byte) 6));
		return oCtrl.searchUserByDni(new Cliente(sDni));
	}

}
