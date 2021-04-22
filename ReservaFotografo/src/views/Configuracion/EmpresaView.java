package views.Configuracion;

import java.util.regex.Pattern;

import controllers.Controller;
import models.IPlantilla;
import models.lugar.Lugar;
import models.personas.Empresa;
import views.Libreria;

public class EmpresaView implements IPlantilla{
    
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
		String sCifNif, sNombreEmpresa, sEmailEmpresa, sTelefonoEmpresa;
		Lugar oLugar;

		System.out.println("\nIntroduce los datos del empresa: ");
		System.out.println("Campos requeridos *");
		do {
			sCifNif = String.valueOf(Libreria.leer("Introduce un cif o nif *", 1, BMAXDNI, -1, -1, (byte) 6));
		} while (!sCifNif.isEmpty() && sCifNif.length() != BMAXDNI && Pattern.matches(SPATRONDNI, sCifNif));
		do {
			sNombreEmpresa = String.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombreEmpresa.isEmpty() && sNombreEmpresa.length() > BMAXNOMBRELARGO);
		do {
			sEmailEmpresa = String.valueOf(Libreria.leer("Introduce un email", 0, BMAXEMAIL, -1, -1, (byte) 6));
		} while (!sEmailEmpresa.isEmpty() && sEmailEmpresa.length() > BMAXEMAIL);
		do {
			sTelefonoEmpresa = String.valueOf(Libreria.leer("Introduce un telefono", 0, BMAXTELEFONO, -1, -1, (byte) 6));
		} while (!sTelefonoEmpresa.isEmpty() && sTelefonoEmpresa.length() > BMAXTELEFONO);
		//NO SE IMPLEMENTA OLUGAR HASTA QUE NO SE CREEN LAS VISTAS Y CONTROLADORES DE LUGAR
		oLugar = new Lugar(1,"pruebas","pruebas"); //#@#@#@#@@#@@#@#@#@#@#@#@#@#@#@#@
		

		return oCtrl.addEmpresa(new Empresa(sCifNif, sNombreEmpresa, sEmailEmpresa, sTelefonoEmpresa, oLugar));
	}

	private static boolean update(Controller oCtrl) {
		String sCifNif, sNombreEmpresa, sEmailEmpresa, sTelefonoEmrpesa;
		// Lugar oLugar;
		boolean booExito = false;
		Empresa oEmpresa = searchByCifDni(oCtrl);

		sCifNif = oEmpresa.getsCifNif();
		if (oEmpresa != null) {
			if (oEmpresa != null && oEmpresa.checkEmpresa()) {
				System.out.println("Modifica los datos de la empresa: ");

				do {
					sCifNif = String.valueOf(Libreria.leer("Introduce un cif o nif (" + oEmpresa.getsCifNif() + ")", 0, BMAXDNI, -1, -1, (byte) 6));
				} while (!sCifNif.isEmpty() && sCifNif.length() != BMAXDNI);
				oEmpresa.setsCifNif(sCifNif);
				
				do {
					sNombreEmpresa = String.valueOf(Libreria.leer("Introduce un nombre (" + oEmpresa.getsNombreEmpresa() + ")", 0, BMAXNOMBRELARGO, -1, -1, (byte) 6));
				} while (!sNombreEmpresa.isEmpty() && sNombreEmpresa.length() > BMAXNOMBRELARGO);
				oEmpresa.setsNombreEmpresa(sNombreEmpresa);
				
				do {
					sEmailEmpresa = String.valueOf(Libreria.leer("Introduce un nombre (" + oEmpresa.getsEmailEmpresa() + ")", 0, BMAXEMAIL, -1, -1, (byte) 6));
				} while (!sEmailEmpresa.isEmpty() && sEmailEmpresa.length() > BMAXEMAIL);
				oEmpresa.setsEmailEmpresa(sEmailEmpresa);
				
				do {
					sTelefonoEmrpesa = String.valueOf(Libreria.leer("Introduce un nombre (" + oEmpresa.getsTelefonoEmrpesa() + ")", 0, BMAXTELEFONO, -1, -1, (byte) 6));
				} while (!sTelefonoEmrpesa.isEmpty() && sTelefonoEmrpesa.length() > BMAXTELEFONO);
				oEmpresa.setsTelefonoEmrpesa(sTelefonoEmrpesa);

				//NO SE IMPLEMENTA OLUGAR HASTA QUE NO SE CREEN LAS VISTAS Y CONTROLADORES DE LUGAR
				//oLugar = new Lugar(1,"pruebas","pruebas"); //#@#@#@#@@#@@#@#@#@#@#@#@#@#@#@#@

				booExito = oCtrl.updateEmpresa(oEmpresa);
			}
		}
		

		return booExito;
	}

	private static Empresa searchByCifDni(Controller oCtrl) {
		String sCifNif;
		do {
			sCifNif = String.valueOf(Libreria.leer("Introduce un cif o nif *", 1, BMAXDNI, -1, -1, (byte) 6));
		} while (!sCifNif.isEmpty() && sCifNif.length() != BMAXDNI && Pattern.matches(SPATRONDNI, sCifNif));
		return oCtrl.searchEmpresa(new Empresa(sCifNif,"nombre", null, null, new Lugar(1,null, null)));
	}

	private static boolean remove(Controller oCtrl) {
		boolean bExito = false;
		String sCifNif;
		do {
			sCifNif = String.valueOf(Libreria.leer("Introduce un cif o nif ", 1, BMAXDNI, -1, -1, (byte) 6));
		} while (!sCifNif.isEmpty() && sCifNif.length() != BMAXDNI && Pattern.matches(SPATRONDNI, sCifNif));
		
		bExito = oCtrl.removeEmpresa(new Empresa(sCifNif,"nombre", null, null, new Lugar(1,null, null)));
	
		return bExito;
	}

}
