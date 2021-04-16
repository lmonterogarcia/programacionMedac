package views.personas;

import controllers.Controller;
import models.IPlantilla;
import models.personas.Fotografo;
import views.Libreria;

public class FotografoView implements IPlantilla{
    public static byte subMenuFotografo() {
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Gestion de fotografo");
		System.out.println("-----------------------");
		System.out.println("1. Alta");
		System.out.println("2. Modificar");
		System.out.println("3. Buscar fotografo por dni");
		System.out.println("4. Borrar");
		System.out.println("5. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
	}

	public static void gestionFotografo(Controller oCtrl) {
		switch (FotografoView.subMenuFotografo()) {
		case 1: // Alta de fotografo
			if (create(oCtrl)) {
				System.out.println("El fotografo ha sido creado con exito.");
			} else {
				System.out.println("El fotografo no se ha podido crear.");
			}
			break;
		case 2: // Modificar
			if (update(oCtrl)) {
				System.out.println("El fotografo ha sido modificado con exito.");
			} else {
				System.out.println("El fotografo no se ha podido modificar.");
			}
			break;
		case 3: // Buscar
			Fotografo oFotografo = searchByDni(oCtrl);
			if (oFotografo != null) {
				System.out.println("El fotografo buscado existe en la base de datos.");
				System.out.println(oFotografo);
			} else {
				System.out.println("El fotografo no existe en la base de datos.");
			}
			break;
		case 4: // Borrar
			if (remove(oCtrl)) {
				System.out.println("El fotografo ha sido eliminado con exito.");
			} else {
				System.out.println("El fotografo no se ha podido eliminar.");
			}
			break;
		}
	}

	private static boolean create(Controller oCtrl) {
		String sDniFotgrafo, sNombreFotografo;

		System.out.println("\nIntroduce los datos del fotografo: ");
		do {
			sDniFotgrafo = String.valueOf(Libreria.leer("Introduce un dni", 1, BMAXDNI, -1, -1, (byte) 6));
		} while (!sDniFotgrafo.isEmpty() && sDniFotgrafo.length() != BMAXDNI);
		do {
			sNombreFotografo = String.valueOf(Libreria.leer("Introduce un nombre", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombreFotografo.isEmpty() && sNombreFotografo.length() > BMAXNOMBRELARGO);
		

		return oCtrl.addFotografo(new Fotografo(sDniFotgrafo, sNombreFotografo));
	}

	private static boolean update(Controller oCtrl) {
		String sDniFotgrafo, sNombreFotografo;
		boolean booExito = false;

		sDniFotgrafo = String.valueOf(Libreria.leer("\nIntroduce un dni", BMINDNI, BMAXDNI, -1, -1, (byte) 6));
		Fotografo oFotografo = oCtrl.searchFotografo(new Fotografo(sDniFotgrafo));
		if (oFotografo != null) {
			if (oFotografo != null && oFotografo.checkFotografo()) {

				System.out.println("Modifica el nombre del fotografo: ");

				do {
					sNombreFotografo = String
							.valueOf(Libreria.leer("Introduce un nombre (" + oFotografo.getsNombreFotografo() + ")", 0,
									BMAXNOMBRE, -1, -1, (byte) 6));
				} while (!sNombreFotografo.isEmpty() && sNombreFotografo.length() > BMAXNOMBRE);
				oFotografo.setsNombreFotografo(sNombreFotografo);

				booExito = oCtrl.updateFotografo(oFotografo);
			}
		}
		

		return booExito;
	}

	private static Fotografo searchByDni(Controller oCtrl) {
		String sDniFotgrafo = String.valueOf(Libreria.leer("\nIntroduce un dni", BMINDNI, BMAXDNI, -1, -1, (byte) 6));
		return oCtrl.searchFotografo(new Fotografo(sDniFotgrafo));
	}

	private static boolean remove(Controller oCtrl) {
		boolean bExito = false;
		Fotografo oFotografo = searchByDni(oCtrl);

		if (oFotografo != null) {
			bExito = oCtrl.removeFotografo(oFotografo);
		}
		return bExito;
	}
}
