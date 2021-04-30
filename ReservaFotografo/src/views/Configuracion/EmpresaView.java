package views.Configuracion;

import java.util.List;
import java.util.regex.Pattern;

import controllers.Controller;
import models.IPlantilla;
import models.lugar.Lugar;
import models.personas.Empresa;
import views.Libreria;

public class EmpresaView implements IPlantilla {

	public static byte subMenuEmpresa() {
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Gestion de empresa");
		System.out.println("-----------------------");
		System.out.println("1. Alta");
		System.out.println("2. Modificar");
		System.out.println("3. Buscar empresa por cif/dni");
		System.out.println("4. Borrar");
		System.out.println("5. Listar empresas");
		System.out.println("6. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 6, -1, -1, (byte) 1);
	}

	public static void gestionEmpresa(Controller oCtrl) {
		switch (subMenuEmpresa()) {
		case 1: // Alta de empresa
			if (create(oCtrl)) {
				System.out.println("La empresa ha sido creado con exito.");
			} else {
				System.out.println("La empresa no se ha podido crear.");
			}
			break;
		case 2: // Modificar
			if (update(oCtrl)) {
				System.out.println("La empresa ha sido modificado con exito.");
			} else {
				System.out.println("La empresa no se ha podido modificar.");
			}
			break;
		case 3: // Buscar
			Empresa oEmpresa = searchByCifDni(oCtrl);
			if (oEmpresa != null) {
				System.out.println("La empresa buscado existe en la base de datos.");
				System.out.println(oEmpresa);
			} else {
				System.out.println("La empresa no existe en la base de datos.");
			}
			break;
		case 4: // Borrar
			if (remove(oCtrl)) {
				System.out.println("La empresa ha sido eliminado con exito.");
			} else {
				System.out.println("La empresa no se ha podido eliminar.");
			}
			break;
		case 5: // Borrar
			List<Empresa> lEmpresas = listarEmpresa(oCtrl);
			if (lEmpresas != null && !lEmpresas.isEmpty()) {
				System.out.println("### Lista de empresas ###");
				for (Empresa oEmpL : lEmpresas) {
					System.out.println(
							" Nombre de empresa: " + oEmpL.getsNombreEmpresa() + " - Cif o Nif: " + oEmpL.getsCifNif());
				}
				if (String.valueOf(
						Libreria.leer("¿Quiere mas informacion de alguna empresa? (s/n) ", -1, -1, -1, -1, (byte) 7))
						.equalsIgnoreCase("s")) {
					Empresa oEmp = searchByCifDni(oCtrl);
					if (oEmp != null) {
						System.out.println(oEmp);
					} else {
						System.out.println("La empresa no existe en la base de datos.");
					}
				}
			} else {
				System.out.println("No hay ninguna empresa");
			}
			break;
		}
	}

	private static boolean create(Controller oCtrl) {
		String sCifNif, sNombreEmpresa, sEmailEmpresa, sTelefonoEmpresa;
		Lugar oLugar;

		System.out.println("\nIntroduce los datos del empresa: ");
		System.out.println("Campos requeridos *");
		do {
			sCifNif = String.valueOf(Libreria.leer("Introduce un cif o nif *", 1, BMAXDNI, -1, -1, (byte) 6));
		} while (!sCifNif.isEmpty() && sCifNif.length() != BMAXDNI && Pattern.matches(SPATRONDNI, sCifNif));
		do {
			sNombreEmpresa = String
					.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombreEmpresa.isEmpty() && sNombreEmpresa.length() > BMAXNOMBRELARGO);
		do {
			sEmailEmpresa = String.valueOf(Libreria.leer("Introduce un email", 0, BMAXEMAIL, -1, -1, (byte) 6));
		} while (!sEmailEmpresa.isEmpty() && sEmailEmpresa.length() > BMAXEMAIL);
		do {
			sTelefonoEmpresa = String
					.valueOf(Libreria.leer("Introduce un telefono", 0, BMAXTELEFONO, -1, -1, (byte) 6));
		} while (!sTelefonoEmpresa.isEmpty() && sTelefonoEmpresa.length() > BMAXTELEFONO);
		// NO SE IMPLEMENTA OLUGAR HASTA QUE NO SE CREEN LAS VISTAS Y CONTROLADORES DE
		// LUGAR
		oLugar = new Lugar(1, "pruebas", "pruebas"); // #@#@#@#@@#@@#@#@#@#@#@#@#@#@#@#@

		return oCtrl.getConfiguracionCtrl().getoEmpresaCtrl()
				.add(new Empresa(sCifNif, sNombreEmpresa, sEmailEmpresa, sTelefonoEmpresa, oLugar));
	}

	private static boolean update(Controller oCtrl) {
		String sNombreEmpresa, sEmailEmpresa, sTelefonoEmrpesa;
		// Lugar oLugar;
		boolean booExito = false;
		Empresa oEmpresa = searchByCifDni(oCtrl);

		if (oEmpresa != null) {
			if (oEmpresa != null && oEmpresa.checkEmpresa()) {
				System.out.println("Modifica los datos de la empresa: ");

				do {
					sNombreEmpresa = String
							.valueOf(Libreria.leer("Introduce un nombre (" + oEmpresa.getsNombreEmpresa() + ")", 0,
									BMAXNOMBRELARGO, -1, -1, (byte) 6));
				} while (!sNombreEmpresa.isEmpty() && sNombreEmpresa.length() > BMAXNOMBRELARGO);
				oEmpresa.setsNombreEmpresa(sNombreEmpresa);

				do {
					sEmailEmpresa = String
							.valueOf(Libreria.leer("Introduce un email (" + oEmpresa.getsEmailEmpresa() + ")", 0,
									BMAXEMAIL, -1, -1, (byte) 6));
				} while (!sEmailEmpresa.isEmpty() && sEmailEmpresa.length() > BMAXEMAIL);
				oEmpresa.setsEmailEmpresa(sEmailEmpresa);

				do {
					sTelefonoEmrpesa = String
							.valueOf(Libreria.leer("Introduce un telefono (" + oEmpresa.getsTelefonoEmrpesa() + ")", 0,
									BMAXTELEFONO, -1, -1, (byte) 6));
				} while (!sTelefonoEmrpesa.isEmpty() && sTelefonoEmrpesa.length() > BMAXTELEFONO);
				oEmpresa.setsTelefonoEmrpesa(sTelefonoEmrpesa);

				// NO SE IMPLEMENTA OLUGAR HASTA QUE NO SE CREEN LAS VISTAS Y CONTROLADORES DE
				// LUGAR
				// oLugar = new Lugar(1,"pruebas","pruebas"); //#@#@#@#@@#@@#@#@#@#@#@#@#@#@#@#@

				booExito = oCtrl.getConfiguracionCtrl().getoEmpresaCtrl().update(oEmpresa);
			}
		}

		return booExito;
	}

	private static Empresa searchByCifDni(Controller oCtrl) {
		String sCifNif;
		do {
			sCifNif = String.valueOf(Libreria.leer("Introduce un cif o nif *", 1, BMAXDNI, -1, -1, (byte) 6));
		} while (!sCifNif.isEmpty() && sCifNif.length() != BMAXDNI && Pattern.matches(SPATRONDNI, sCifNif));
		return oCtrl.getConfiguracionCtrl().searchEmpresa(new Empresa(sCifNif));
	}

	private static boolean remove(Controller oCtrl) {
		boolean bExito = false;
		String sCifNif;
		do {
			sCifNif = String.valueOf(Libreria.leer("Introduce un cif o nif ", 1, BMAXDNI, -1, -1, (byte) 6));
		} while (!sCifNif.isEmpty() && sCifNif.length() != BMAXDNI && Pattern.matches(SPATRONDNI, sCifNif));

		bExito = oCtrl.getConfiguracionCtrl().getoEmpresaCtrl().remove(new Empresa(sCifNif));

		return bExito;
	}

	public static List<Empresa> listarEmpresa(Controller oCtrl) {
		return oCtrl.getConfiguracionCtrl().getoEmpresaCtrl().listar();

	}

}
