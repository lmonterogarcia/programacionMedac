package views.Configuracion;

import java.util.regex.Pattern;

import controllers.Controller;
import models.IPlantilla;
import models.sesion.Estado;
import models.sesion.TipoSesion;
import views.Libreria;

public class TipoAndEstadoView implements IPlantilla{
    
    public static byte subMenuTipoAndEstado() {
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Gestion de tipo y estado de sesion");
		System.out.println("-----------------------");
        System.out.println("-----Tipo de Sesion----");
		System.out.println("1. Alta");
		System.out.println("2. Modificar");
		System.out.println("3. Buscar Tipo de sesion por nombre");
		System.out.println("4. Borrar");
        System.out.println("---------Estado--------");
        System.out.println("5. Alta");
		System.out.println("6. Modificar");
		System.out.println("7. Buscar Estado por nombre");
		System.out.println("8. Borrar");
		System.out.println("9. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 9, -1, -1, (byte) 1);
	}

	public static void gestionTipoAndEstado(Controller oCtrl) {
		switch (subMenuTipoAndEstado()) {
		case 1: // Alta de Tipo de Sesion
			if (createTipoSesion(oCtrl)) {
				System.out.println("El tipo sesion ha sido creada con exito.");
			} else {
				System.out.println("El tipo sesion no se ha podido crear.");
			}
			break;
		case 2: // Modificar Tipo de Sesion
			if (updateTipoSesion(oCtrl)) {
				System.out.println("El tipo sesion ha sido modificado con exito.");
			} else {
				System.out.println("El tipo sesion no se ha podido modificar.");
			}
			break;
		case 3: // Buscar Tipo de Sesion
            TipoSesion oTipoSesion = searchByNombreTipoSesion(oCtrl);
			if (oTipoSesion != null) {
				System.out.println("El tipo sesion buscado existe en la base de datos.");
				System.out.println(oTipoSesion);
			} else {
				System.out.println("El tipo sesion no existe en la base de datos.");
			}
			break;
		case 4: // Borrar Tipo de Sesion
			if (removeTipoSesion(oCtrl)) {
				System.out.println("El tipo sesion ha sido eliminado con exito.");
			} else {
				System.out.println("El tipo sesion no se ha podido eliminar.");
			}
			break;
       /* case 5: // Alta de Estado
			if (createEstado(oCtrl)) {
				System.out.println("La empresa ha sido creado con exito.");
			} else {
				System.out.println("La empresa no se ha podido crear.");
			}
			break;
		case 6: // Modificar Estado
			if (updateEstado(oCtrl)) {
				System.out.println("La empresa ha sido modificado con exito.");
			} else {
				System.out.println("La empresa no se ha podido modificar.");
			}
			break;
		case 7: // Buscar Estado
            Estado oEstado = searchByNombreEstado(oCtrl);
			if (oEstado != null) {
				System.out.println("La empresa buscado existe en la base de datos.");
				System.out.println(oEstado);
			} else {
				System.out.println("La empresa no existe en la base de datos.");
			}
			break;
		case 8: // Borrar Estado
			if (removeEstado(oCtrl)) {
				System.out.println("La empresa ha sido eliminado con exito.");
			} else {
				System.out.println("La empresa no se ha podido eliminar.");
			}
			break;*/
        default:
            break;
		}
	}

    // ########### Tipo Sesion ##############

	private static boolean createTipoSesion(Controller oCtrl) {
		String sNombreTipoSesion;
        short shDuracionTipoSesion;

		System.out.println("\nIntroduce los datos del tipo de sesion: ");
		System.out.println("Campos requeridos *");
		
		sNombreTipoSesion = String.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		
		try {
            shDuracionTipoSesion = (short)(Libreria.leer("Introduce un nombre *", 0, SHMAXDURACION, -1, -1, (byte) 2));
        } catch (Exception e) {
            shDuracionTipoSesion = -1;
        }

		return oCtrl.addTipoSesion(new TipoSesion(sNombreTipoSesion, shDuracionTipoSesion));
	}

	private static boolean updateTipoSesion(Controller oCtrl) {
        short shDuracionTipoSesion;
		boolean booExito = false;
		TipoSesion oTipoSesion = searchByNombreTipoSesion(oCtrl);
		
		if (oTipoSesion != null) {
			if (oTipoSesion != null && oTipoSesion.checkTipoSesion()) {
				System.out.println("Modifica los datos del tipo de sesion: ");
				
				try {
                    shDuracionTipoSesion = (short)(Libreria.leer("Introduce una duracion ", 0, SHMAXDURACION, -1, -1, (byte) 2));
                } catch (Exception e) {
                    shDuracionTipoSesion = -1;
                }
                oTipoSesion.setShDuracionTipoSesion(shDuracionTipoSesion);

				booExito = oCtrl.updateTipoSesion(oTipoSesion);
			}
		}
		

		return booExito;
	}

	private static TipoSesion searchByNombreTipoSesion(Controller oCtrl) {
		String sNombreTipoSesion;
		do {
			sNombreTipoSesion = String.valueOf(Libreria.leer("Introduce un nombre ", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombreTipoSesion.isEmpty() && sNombreTipoSesion.length() > BMAXDNI);
		return oCtrl.searchTipoSesion(new TipoSesion(sNombreTipoSesion));
	}

	private static boolean removeTipoSesion(Controller oCtrl) {
		boolean bExito = false;
		String sNombreTipoSesion;
		do {
			sNombreTipoSesion = String.valueOf(Libreria.leer("Introduce un nombre ", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombreTipoSesion.isEmpty() && sNombreTipoSesion.length() > BMAXDNI);
		
		bExito = oCtrl.removeTipoSesion(new TipoSesion(sNombreTipoSesion));
	
		return bExito;
	}

/*
    // ########### Estado ##############
    
	private static boolean createEstado(Controller oCtrl) {
		String sCifNif, sNombreEmpresa, sEmailEmpresa, sTelefonoEmpresa;
		

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

	private static boolean updateEstado(Controller oCtrl) {
		String sNombreEmpresa, sEmailEmpresa, sTelefonoEmrpesa;
		// Lugar oLugar;
		boolean booExito = false;
		TipoSesion oEmpresa = searchByCifDni(oCtrl);
		
		if (oEmpresa != null) {
			if (oEmpresa != null && oEmpresa.checkEmpresa()) {
				System.out.println("Modifica los datos de la empresa: ");
				
				do {
					sNombreEmpresa = String.valueOf(Libreria.leer("Introduce un nombre (" + oEmpresa.getsNombreEmpresa() + ")", 0, BMAXNOMBRELARGO, -1, -1, (byte) 6));
				} while (!sNombreEmpresa.isEmpty() && sNombreEmpresa.length() > BMAXNOMBRELARGO);
				oEmpresa.setsNombreEmpresa(sNombreEmpresa);
				
				do {
					sEmailEmpresa = String.valueOf(Libreria.leer("Introduce un email (" + oEmpresa.getsEmailEmpresa() + ")", 0, BMAXEMAIL, -1, -1, (byte) 6));
				} while (!sEmailEmpresa.isEmpty() && sEmailEmpresa.length() > BMAXEMAIL);
				oEmpresa.setsEmailEmpresa(sEmailEmpresa);
				
				do {
					sTelefonoEmrpesa = String.valueOf(Libreria.leer("Introduce un telefono (" + oEmpresa.getsTelefonoEmrpesa() + ")", 0, BMAXTELEFONO, -1, -1, (byte) 6));
				} while (!sTelefonoEmrpesa.isEmpty() && sTelefonoEmrpesa.length() > BMAXTELEFONO);
				oEmpresa.setsTelefonoEmrpesa(sTelefonoEmrpesa);

				//NO SE IMPLEMENTA OLUGAR HASTA QUE NO SE CREEN LAS VISTAS Y CONTROLADORES DE LUGAR
				//oLugar = new Lugar(1,"pruebas","pruebas"); //#@#@#@#@@#@@#@#@#@#@#@#@#@#@#@#@

				booExito = oCtrl.updateEmpresa(oEmpresa);
			}
		}
		

		return booExito;
	}

	private static Estado searchByNombreEstado(Controller oCtrl) {
		String sCifNif;
		do {
			sCifNif = String.valueOf(Libreria.leer("Introduce un cif o nif *", 1, BMAXDNI, -1, -1, (byte) 6));
		} while (!sCifNif.isEmpty() && sCifNif.length() != BMAXDNI && Pattern.matches(SPATRONDNI, sCifNif));
		return oCtrl.searchEmpresa(new Empresa(sCifNif));
	}

	private static boolean removeEstado(Controller oCtrl) {
		boolean bExito = false;
		String sCifNif;
		do {
			sCifNif = String.valueOf(Libreria.leer("Introduce un cif o nif ", 1, BMAXDNI, -1, -1, (byte) 6));
		} while (!sCifNif.isEmpty() && sCifNif.length() != BMAXDNI && Pattern.matches(SPATRONDNI, sCifNif));
		
		bExito = oCtrl.removeEmpresa(new Empresa(sCifNif));
	
		return bExito;
	}
    */
}
