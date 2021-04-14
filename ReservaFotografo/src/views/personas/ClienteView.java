package views.personas;

import java.time.LocalDate;

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
			Cliente oCliente = searchByEmail(oCtrl);
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
		// LAS VARIABLES DE LA CLASE LUGAR AUN NO SE VAN A
		// PEDIR!!!!!!!!#######################################################################
		String sDniContacto, sNombreContacto, sApellido1Contacto, setsApellido2Contacto, sTelefonoContacto, sEmailUsuario, sPassword, sNombreLugar, sGoogleLink, sCalle,
				sNumeroCalle, sCodigoPostal, sLocalidda, sProvincia, sPais;
		char cFechaNacimiento;
		int iDia, iMes, iAnio;
		LocalDate oFechaNacimientoContacto = null;
		float fLatitud, fLongitud;
		boolean booFecha = false, booLugar = false;

		System.out.println("Introduce los datos basicos del cliente: ");
		do {
			sDniContacto = String.valueOf(Libreria.leer("Introduce un dni", 0, BMAXDNI, -1, -1, (byte) 6));
		} while (!sDniContacto.isEmpty() && sDniContacto.length() != BMAXDNI);
		sNombreContacto = String.valueOf(Libreria.leer("Introduce un nombre", 1, BMAXNOMBRE, -1, -1, (byte) 6));
		do {
			sApellido1Contacto = String
					.valueOf(Libreria.leer("Introduce el primer apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
		} while (!sApellido1Contacto.isEmpty() && sApellido1Contacto.length() > BMAXAPELLIDOS);
		do {
			setsApellido2Contacto = String
					.valueOf(Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
		} while (!setsApellido2Contacto.isEmpty() && setsApellido2Contacto.length() > BMAXAPELLIDOS);
		do {
			sTelefonoContacto = String.valueOf(Libreria.leer("Introduce un telefono", 0, 9, -1, -1, (byte) 6));
		} while (!sTelefonoContacto.isEmpty() && sTelefonoContacto.length() != 9);
		if ((char) (Libreria.leer("¿Quiere introducir la fecha de nacimiento? (s/n) ", -1, -1, -1, -1,
				(byte) 7)) == 's') {
			do {
				try {
					iDia = (int)Libreria.leer("Introduce el dia (1-31)", 1, 31, -1, -1, (byte) 3);
					iMes = (int) Libreria.leer("Introduce el mes (1-12)", 1, 12, -1, -1, (byte) 3);
					iAnio = (int) Libreria.leer(
							"Introduce el annio (" + (LocalDate.now().getYear() - 150) + "-" + LocalDate.now().getYear()
									+ ") ",
							LocalDate.now().getYear() - 150, LocalDate.now().getYear(), -1, -1, (byte) 3);
							oFechaNacimientoContacto = LocalDate.of(iAnio, iMes, iDia);
					booFecha = true;
				} catch (Exception e) {
					System.out.println("\nHa introducido mal la fecha, vuelva a introducirla");
				}
			} while (booFecha);
		}
			// ######## NO IMPLEMENTADO HASTA QUE NO SE CREE EL CONTROLADOR DE LUGAR ############
		if ((char) (Libreria.leer("¿Quiere introducir una direccion? (s/n) ", -1, -1, -1, -1, (byte) 7)) == 's') {
			do {
				try {
					sNombreLugar = String.valueOf(
							Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
					sGoogleLink = String.valueOf(
							Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
					fLatitud = (float) (Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1,
							(byte) 5));
					fLongitud = (float) (Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1,
							(byte) 5));
					sCalle = String.valueOf(
							Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
					sNumeroCalle = String.valueOf(
							Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
					sCodigoPostal = String.valueOf(
							Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
					sLocalidda = String.valueOf(
							Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
					sProvincia = String.valueOf(
							Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
					sPais = String.valueOf(
							Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
					booFecha = true;
				} catch (Exception e) {
					System.out.println("\nHa introducido mal la fecha, vuelva a introducirla");
				}
			} while (booFecha);
		}

		System.out.println("\nIntroduce ahora los datos del usuario asociado: ");
		sEmailUsuario = String.valueOf(Libreria.leer("Introduce un email", 1, BMAXEMAIL, -1, -1, (byte) 6));
		sPassword = String.valueOf(Libreria.leer("Introduce una contrasena", BMINPASSW, BMAXPASSW, -1, -1, (byte) 6));

		return oCtrl.addCliente(new Cliente(sDniContacto, sNombreContacto,sApellido1Contacto, setsApellido2Contacto, sTelefonoContacto, oFechaNacimientoContacto,new Usuario(sEmailUsuario,sPassword) , null));
	}

	private static boolean update(Controller oCtrl) {
		String sDni, sNombre, sApellidos, sDireccion, sNumeroDireccion, sTelefono, sTarjeta;
		boolean bExito = false;
		/*
		String sEmailCliente = String.valueOf(Libreria.leer("Introduce un email", 1, 100, -1, -1, (byte) 6));
		Cliente oCliente = oCtrl.searchCliente(new Cliente(null, new Usuario(sEmailCliente)));
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
		}*/
		return bExito;
	}

	private static Cliente searchByEmail(Controller oCtrl) {
		String sEmailCliente = String.valueOf(Libreria.leer("Introduce un email", 1, 100, -1, -1, (byte) 6));
		return oCtrl.searchCliente(new Cliente(null, new Usuario(sEmailCliente)));
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
