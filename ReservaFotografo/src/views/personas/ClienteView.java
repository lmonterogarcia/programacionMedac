package views.personas;

import controllers.Controller;
import models.personas.Cliente;
import models.personas.Usuario;
import views.Libreria;
import models.IPlantilla;

public class ClienteView implements IPlantilla {
    public static byte subMenuClientes() {
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Gestion de clientes");
		System.out.println("-----------------------");
		System.out.println("1. Alta");
		System.out.println("2. Modificar");
		System.out.println("3. Buscar usuario por email");
		System.out.println("4. Borrar");
		System.out.println("5. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
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
		}
	}

	private static boolean create(Controller oCtrl) {
		String sDni, sNombre, sApellido1, sApellido2, sDireccion, sNumeroDireccion, sTelefono, sTarjeta, sEmail, sPass;

		System.out.println("Introduce los datos basicos del cliente: ");
		sDni = String.valueOf(Libreria.leer("Introduce un dni", BMAXDNI, BMAXDNI, -1, -1, (byte) 6));
		sNombre = String.valueOf(Libreria.leer("Introduce un nombre", 1, BMAXNOMBRE, -1, -1, (byte) 6));
		sApellido1 = String.valueOf(Libreria.leer("Introduce el primer apellido", 1, BMAXAPELLIDOS, -1, -1, (byte) 6));
        sApellido2 = String.valueOf(Libreria.leer("Introduce el segundo apellido", 1, BMAXAPELLIDOS, -1, -1, (byte) 6));
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

	private static boolean update(Controller oCtrl) { //############POR AQUIIIIIIII###########
		String sDni, sNombre, sApellidos, sDireccion, sNumeroDireccion, sTelefono, sTarjeta;
		boolean bExito = false;
		String sEmailCliente = String.valueOf(Libreria.leer("Introduce un email", 1, 100, -1, -1, (byte) 6));
		Cliente oCliente = oCtrl.searchCliente(new Cliente (null,new Usuario(sEmailCliente)));
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

	private static Cliente searchByEmail(Controller oCtrl) {
		String sEmailCliente = String.valueOf(Libreria.leer("Introduce un email", 1, 100, -1, -1, (byte) 6));
		return oCtrl.searchCliente(new Cliente(null,new Usuario(sEmailCliente)));
	}

	private static boolean remove(Controller oCtrl) {
		boolean bExito = false;
		Cliente oCliente = searchByEmail(oCtrl);

		if (oCliente != null) {
			bExito = oCtrl.removeCliente(oCliente);
		}
		return bExito;
	}
}
