package views.Configuracion;

import controllers.Controller;
import models.personas.Empresa;
import views.Libreria;

public class EmpresaView {
    
    public static byte subMenuEmpresa() {
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Gestion de empresa");
		System.out.println("-----------------------");
		System.out.println("1. Alta");
		System.out.println("2. Modificar");
		System.out.println("3. Buscar empresa por cif/dni");
		System.out.println("4. Borrar");
		System.out.println("5. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
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
		}
	}

	private static boolean create(Controller oCtrl) {
		String sDniFotgrafo, sNombreEmpresa;

		System.out.println("\nIntroduce los datos del empresa: ");
		System.out.println("Campos requeridos *");
		do {
			sDniFotgrafo = String.valueOf(Libreria.leer("Introduce un dni *", 1, BMAXDNI, -1, -1, (byte) 6));
		} while (!sDniFotgrafo.isEmpty() && sDniFotgrafo.length() != BMAXDNI);
		do {
			sNombreEmpresa = String.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombreEmpresa.isEmpty() && sNombreEmpresa.length() > BMAXNOMBRELARGO);
		

		return oCtrl.addEmpresa(new Empresa(sDniFotgrafo, sNombreEmpresa));
	}

	private static boolean update(Controller oCtrl) {
		String sDniFotgrafo, sNombreEmpresa;
		boolean booExito = false;

		sDniFotgrafo = String.valueOf(Libreria.leer("\nIntroduce un dni", BMINDNI, BMAXDNI, -1, -1, (byte) 6));
		Empresa oEmpresa = oCtrl.searchEmpresa(new Empresa(sDniFotgrafo));
		if (oEmpresa != null) {
			if (oEmpresa != null && oEmpresa.checkEmpresa()) {

				System.out.println("Modifica el nombre del empresa: ");
				System.out.println("Campos requeridos *");

				do {
					sNombreEmpresa = String
							.valueOf(Libreria.leer("Introduce un nombre (" + oEmpresa.getsNombreEmpresa() + ") *", 0,
									BMAXNOMBRE, -1, -1, (byte) 6));
				} while (!sNombreEmpresa.isEmpty() && sNombreEmpresa.length() > BMAXNOMBRE);
				oEmpresa.setsNombreEmpresa(sNombreEmpresa);

				booExito = oCtrl.updateEmpresa(oEmpresa);
			}
		}
		

		return booExito;
	}

	private static Empresa searchByCifDni(Controller oCtrl) {
		String sDniFotgrafo = String.valueOf(Libreria.leer("\nIntroduce un dni", BMINDNI, BMAXDNI, -1, -1, (byte) 6));
		return oCtrl.searchEmpresa(new Empresa(sDniFotgrafo));
	}

	private static boolean remove(Controller oCtrl) {
		boolean bExito = false;
		Empresa oEmpresa = searchByDni(oCtrl);

		if (oEmpresa != null) {
			bExito = oCtrl.removeEmpresa(oEmpresa);
		}
		return bExito;
	}
}
