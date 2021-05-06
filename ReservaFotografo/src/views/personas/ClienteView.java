package views.personas;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang.WordUtils;

import controllers.Controller;
import models.personas.Cliente;
import models.personas.Usuario;
import views.Libreria;
import models.IPlantilla;
import models.lugar.Lugar;
import models.lugar.*;

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
		System.out.println("5. Listar clientes");
		System.out.println("6. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 6, -1, -1, (byte) 1);
	}

	public static void gestionClientes(Controller oCtrl) {
		byte bOpcion;
		do {
			bOpcion = subMenuClientes();
			switch (bOpcion) {
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
				case 5: // Listar Cliente
					List<Cliente> oListaCliente = listarCliente(oCtrl);
					if (oListaCliente != null && !oListaCliente.isEmpty()) {
						System.out.println("\n## Lista de clientes ##");
						for (Cliente oCliL : oListaCliente) {
							System.out.println("Id: " + oCliL.getiIdContacto() + " - DNI: " + oCliL.getsDniContacto()
									+ " - Nombre: " + oCliL.getsNombreContacto() + " " + oCliL.getsApellido1Contacto()
									+ " - Email: " + oCliL.getoUsuario().getsEmail() + " - Telefono: "
									+ oCliL.getsTelefonoContacto());
						}
						if (String.valueOf(Libreria.leer("¿Quiere mas informacion de algun Cliente? (s/n) ", -1, -1, -1,
								-1, (byte) 7)).equalsIgnoreCase("s")) {
							Cliente oCli = searchByEmail(oCtrl);
							if (oCli != null) {
								System.out.println(oCli);
							} else {
								System.out.println("El cliente no existe en la base de datos.");
							}
						}
					} else {
						System.out.println("No existen clientes en la base de datos.");
					}
					break;
			}
		} while (bOpcion != 6);

	}

	private static boolean create(Controller oCtrl) {
		String sDniContacto, sNombreContacto, sApellido1Contacto, sApellido2Contacto, sTelefonoContacto, sEmailUsuario,
				sPassword;
		String sCalleLugar, sNumeroLugar, sReferenciaCodigoPostal, sNombreLocalidad, sNombreProvincia, sNombrePais;
		int iDia, iMes, iAnio;
		LocalDate oFechaNacimientoContacto = null;
		Lugar oLugar = null;
		boolean booFecha = false;

		System.out.println("Introduce los datos basicos del cliente: ");
		System.out.println("Campos requeridos *");
		do {
			sDniContacto = String.valueOf(Libreria.leer("Introduce un dni", 0, BMAXDNI, -1, -1, (byte) 6));
		} while (!sDniContacto.isEmpty() && sDniContacto.length() != BMAXDNI);
		sNombreContacto = String.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRE, -1, -1, (byte) 6));
		do {
			sApellido1Contacto = String
					.valueOf(Libreria.leer("Introduce el primer apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
		} while (!sApellido1Contacto.isEmpty() && sApellido1Contacto.length() > BMAXAPELLIDOS);
		do {
			sApellido2Contacto = String
					.valueOf(Libreria.leer("Introduce el segundo apellido", 0, BMAXAPELLIDOS, -1, -1, (byte) 6));
		} while (!sApellido2Contacto.isEmpty() && sApellido2Contacto.length() > BMAXAPELLIDOS);
		do {
			sTelefonoContacto = String.valueOf(Libreria.leer("Introduce un telefono", 0, 9, -1, -1, (byte) 6));
		} while (!sTelefonoContacto.isEmpty() && sTelefonoContacto.length() != 9);
		if (String.valueOf(Libreria.leer("¿Quiere introducir la fecha de nacimiento? (s/n) ", -1, -1, -1, -1, (byte) 7))
				.equalsIgnoreCase("s")) {
			do {
				try {
					iDia = (int) Libreria.leer("Introduce el dia *", 1, 31, -1, -1, (byte) 3);
					iMes = (int) Libreria.leer("Introduce el mes *", 1, 12, -1, -1, (byte) 3);
					iAnio = (int) Libreria.leer("Introduce el annio *", (LocalDate.now().getYear() - 100),
							LocalDate.now().getYear(), -1, -1, (byte) 3);
					oFechaNacimientoContacto = LocalDate.of(iAnio, iMes, iDia);
					booFecha = true;
				} catch (Exception e) {
					System.out.println("\nHa introducido mal la fecha, vuelva a introducirla");
				}
			} while (!booFecha);
		}
		// Direccion
		if (String.valueOf(Libreria.leer("¿Quiere introducir la direccion? (s/n) ", -1, -1, -1, -1, (byte) 7))
				.equalsIgnoreCase("s")) {
			sCalleLugar = String.valueOf(Libreria.leer("Introduce una calle *", 1, BMAXNOMBRELUGAR, -1, -1, (byte) 6));
			sCalleLugar = WordUtils.capitalizeFully(sCalleLugar);
			sNumeroLugar = String
					.valueOf(Libreria.leer("Introduce el numero de la calle *", 1, BMAXNUMEROLUGAR, -1, -1, (byte) 6));
			sReferenciaCodigoPostal = String
					.valueOf(Libreria.leer("Introduce un codigo postal *", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
			sNombreLocalidad = String
					.valueOf(Libreria.leer("Introduce una localidad *", 1, BMAXNOMBRELUGAR, -1, -1, (byte) 6));
			sNombreLocalidad = WordUtils.capitalizeFully(sNombreLocalidad);
			sNombreProvincia = String
					.valueOf(Libreria.leer("Introduce una provincia *", 1, BMAXNOMBRELUGAR, -1, -1, (byte) 6));
			sNombreProvincia = WordUtils.capitalizeFully(sNombreProvincia);
			sNombrePais = String.valueOf(Libreria.leer("Introduce un pais *", 1, BMAXNOMBRELUGAR, -1, -1, (byte) 6));
			sNombrePais = WordUtils.capitalizeFully(sNombrePais);

			oLugar = new Lugar(null, null, sCalleLugar, sNumeroLugar, 0f, 0f,
					new CodigoPostalLocalidadPaisProvincia(new Localidad(sNombreLocalidad),
							new CodigoPostal(sReferenciaCodigoPostal),
							(new PaisProvincia(new Provincia(sNombreProvincia), new Pais(sNombrePais)))));
		}
		System.out.println("\nIntroduce ahora los datos del usuario asociado: ");
		sEmailUsuario = String.valueOf(Libreria.leer("Introduce un email *", 1, BMAXEMAIL, -1, -1, (byte) 6));
		sPassword = String.valueOf(Libreria.leer("Introduce una contrasena *", BMINPASSW, BMAXPASSW, -1, -1, (byte) 6));

		return oCtrl.addCliente(new Cliente(sDniContacto, sNombreContacto, sApellido1Contacto, sApellido2Contacto,
				sTelefonoContacto, oFechaNacimientoContacto, new Usuario(sEmailUsuario, sPassword), oLugar));
	}

	private static boolean update(Controller oCtrl) {
		String sDniContacto, sNombreContacto, sApellido1Contacto, sApellido2Contacto, sTelefonoContacto, sPassword,
				sFechaNacimiento, sMensaje;
		;
		String sCalleLugar, sNumeroLugar, sReferenciaCodigoPostal, sNombreLocalidad, sNombreProvincia, sNombrePais;
		int iDia, iMes, iAnio;
		boolean booFecha = false, booExito = false;

		Cliente oCliente = searchByEmail(oCtrl);
		if (oCliente != null) {
			oCliente.setoUsuario(oCtrl.getoPersonasCtrl().searchUsuario(oCliente));
			if (oCliente.getoUsuario() != null && oCliente.checkCliente()) {

				System.out.println("Modifica los datos basicos del cliente: ");

				do {
					sDniContacto = String.valueOf(Libreria.leer("Introduce un dni (" + oCliente.getsDniContacto() + ")",
							0, BMAXDNI, -1, -1, (byte) 6));
				} while (!sDniContacto.isEmpty() && sDniContacto.length() != BMAXDNI);
				oCliente.setsDniContacto(sDniContacto);

				do {
					sNombreContacto = String
							.valueOf(Libreria.leer("Introduce un nombre (" + oCliente.getsNombreContacto() + ")", 0,
									BMAXNOMBRE, -1, -1, (byte) 6));
				} while (!sNombreContacto.isEmpty() && sNombreContacto.length() > BMAXNOMBRE);
				oCliente.setsNombreContacto(sNombreContacto);

				do {
					sApellido1Contacto = String.valueOf(
							Libreria.leer("Introduce el primer apellido (" + oCliente.getsApellido1Contacto() + ")", 0,
									BMAXAPELLIDOS, -1, -1, (byte) 6));
				} while (!sApellido1Contacto.isEmpty() && sApellido1Contacto.length() > BMAXAPELLIDOS);
				oCliente.setsApellido1Contacto(sApellido1Contacto);

				do {
					sApellido2Contacto = String.valueOf(
							Libreria.leer("Introduce el segundo apellido (" + oCliente.getsApellido2Contacto() + ")", 0,
									BMAXAPELLIDOS, -1, -1, (byte) 6));
				} while (!sApellido2Contacto.isEmpty() && sApellido2Contacto.length() > BMAXAPELLIDOS);
				oCliente.setsApellido2Contacto(sApellido2Contacto);

				do {
					sTelefonoContacto = String.valueOf(Libreria.leer(
							"Introduce un telefono (" + oCliente.getsTelefonoContacto() + ")", 0, 9, -1, -1, (byte) 6));
				} while (!sTelefonoContacto.isEmpty() && sTelefonoContacto.length() != 9);
				oCliente.setsTelefonoContacto(sTelefonoContacto);

				if (oCliente.getoFechaNacimientoContacto() != null) {
					sFechaNacimiento = oCliente.getoFechaNacimientoContacto().getDayOfMonth() + "/"
							+ oCliente.getoFechaNacimientoContacto().getMonth() + "/"
							+ oCliente.getoFechaNacimientoContacto().getYear() + ")";
				} else {
					sFechaNacimiento = "Vacio";
				}

				if ((String.valueOf(
						Libreria.leer("¿Quiere modificar la fecha de nacimiento? (s/n) (" + sFechaNacimiento + ")", -1,
								-1, -1, -1, (byte) 7))).equalsIgnoreCase("s")) {
					do {
						try {
							iDia = (int) Libreria.leer("Introduce el dia ", 1, 31, -1, -1, (byte) 3);
							iMes = (int) Libreria.leer("Introduce el mes ", 1, 12, -1, -1, (byte) 3);
							iAnio = (int) Libreria.leer("Introduce el annio ", (LocalDate.now().getYear() - 100),
									LocalDate.now().getYear(), -1, -1, (byte) 3);
							booFecha = true;
							oCliente.setoFechaNacimientoContacto(LocalDate.of(iAnio, iMes, iDia));
						} catch (Exception e) {
							System.out.println("\nHa introducido una fecha incorrecta, vuelva a introducirla");
						}
					} while (!booFecha);

				}
				// Direccion
				if (String.valueOf(Libreria.leer("¿Quiere introducir la direccion? (s/n) ", -1, -1, -1, -1, (byte) 7))
						.equalsIgnoreCase("s")) {
					sCalleLugar = String.valueOf(
							Libreria.leer("Introduce una calle * (" + oCliente.getoLugar().getsCalleLugar() + ")", 1,
									BMAXNOMBRELUGAR, -1, -1, (byte) 6));
					sNumeroLugar = String.valueOf(Libreria.leer(
							"Introduce el numero de la calle * (" + oCliente.getoLugar().getsNumeroLugar() + ")", 1,
							BMAXNUMEROLUGAR, -1, -1, (byte) 6));
					try {
						sMensaje = oCliente.getoLugar().getoCodigoPostalLocalidadPaisProvincia().getoCodigoPostal()
								.getsReferenciaCodigoPostal();
					} catch (Exception e) {
						sMensaje = "Null";
					}
					sReferenciaCodigoPostal = String.valueOf(Libreria.leer(
							"Introduce un codigo postal * (" + sMensaje + ")", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));

					try {
						sMensaje = oCliente.getoLugar().getoCodigoPostalLocalidadPaisProvincia().getoLocalidad()
								.getsNombreLocalidad();
					} catch (Exception e) {
						sMensaje = "Null";
					}
					sNombreLocalidad = String.valueOf(Libreria.leer("Introduce una localidad * (" + sMensaje + ")", 1,
							BMAXNOMBRELUGAR, -1, -1, (byte) 6));

					try {
						sMensaje = oCliente.getoLugar().getoCodigoPostalLocalidadPaisProvincia().getoPaisProvincia()
								.getoProvincia().getsNombreProvincia();
					} catch (Exception e) {
						sMensaje = "Null";
					}
					sNombreProvincia = String.valueOf(Libreria.leer("Introduce una provincia *(" + sMensaje + ")", 1,
							BMAXNOMBRELUGAR, -1, -1, (byte) 6));

					try {
						sMensaje = oCliente.getoLugar().getoCodigoPostalLocalidadPaisProvincia().getoPaisProvincia()
								.getoPais().getsNombrePais();
					} catch (Exception e) {
						sMensaje = "Null";
					}
					sNombrePais = String.valueOf(Libreria.leer("Introduce un pais *(" + sMensaje + ")", 1,
							BMAXNOMBRELUGAR, -1, -1, (byte) 6));

					sCalleLugar = WordUtils.capitalizeFully(sCalleLugar);
					sNombreLocalidad = WordUtils.capitalizeFully(sNombreLocalidad);
					sNombreProvincia = WordUtils.capitalizeFully(sNombreProvincia);
					sNombrePais = WordUtils.capitalizeFully(sNombrePais);

					try {
						oCliente.getoLugar().setsCalleLugar(sCalleLugar);
					oCliente.getoLugar().setsNumeroLugar(sNumeroLugar);
					oCliente.getoLugar().getoCodigoPostalLocalidadPaisProvincia().getoCodigoPostal()
							.setsReferenciaCodigoPostal(sReferenciaCodigoPostal);
					oCliente.getoLugar().getoCodigoPostalLocalidadPaisProvincia().getoLocalidad()
							.setsNombreLocalidad(sNombreLocalidad);
					oCliente.getoLugar().getoCodigoPostalLocalidadPaisProvincia().getoPaisProvincia().getoProvincia()
							.setsNombreProvincia(sNombreProvincia);
					oCliente.getoLugar().getoCodigoPostalLocalidadPaisProvincia().getoPaisProvincia().getoPais()
							.setsNombrePais(sNombrePais);
					} catch (Exception e) {
						Lugar oLugar = new Lugar(null, null, sCalleLugar, sNumeroLugar, 0f, 0f,
					new CodigoPostalLocalidadPaisProvincia(new Localidad(sNombreLocalidad),
							new CodigoPostal(sReferenciaCodigoPostal),
							(new PaisProvincia(new Provincia(sNombreProvincia), new Pais(sNombrePais)))));
							oCliente.setoLugar(oLugar);
					}
					
				}

				if (String.valueOf(Libreria.leer("¿Quiere modificar la contraseña? (s/n) ", -1, -1, -1, -1, (byte) 7))
						.equalsIgnoreCase("s")) {
					byte bContador = 0;
					boolean booExitoPass = false;
					do {
						if ((Libreria.leer("Introduce la contraseña Actual ", BMINPASSW, BMAXPASSW, -1, -1, (byte) 6))
								.equals(oCliente.getoUsuario().getsPassword())) {
							sPassword = String.valueOf(Libreria.leer("Introduce la nueva contrasena", BMINPASSW,
									BMAXPASSW, -1, -1, (byte) 6));
							booExitoPass = true;
							oCliente.getoUsuario().setsPassword(sPassword);
						} else {
							bContador++;
							System.out.println("## Contraseña actual incorrecta ##");
						}
						if (bContador == 3) {
							System.out.println("Demasiados errores. La contraseña no se va a cambiar.");
						}
					} while (!booExitoPass && bContador < 3);
				}
				booExito = oCtrl.updateCliente(oCliente);
			}
		}

		return booExito;
	}

	private static Cliente searchByEmail(Controller oCtrl) {
		String sEmailCliente = String.valueOf(Libreria.leer("Introduce un email", 1, 100, -1, -1, (byte) 6));
		return oCtrl.searchCliente((new Cliente(null, new Usuario(sEmailCliente))));
	}

	private static boolean remove(Controller oCtrl) {
		boolean bExito = false;
		Cliente oCliente = searchByEmail(oCtrl);

		if (oCliente != null) {
			bExito = oCtrl.getoPersonasCtrl().removeCliente(oCliente);
		}
		return bExito;
	}

	public static List<Cliente> listarCliente(Controller oCtrl) {
		return oCtrl.getoPersonasCtrl().getoClientCtrl().listar();
	}
}
