package views.Configuracion;

import java.util.List;

import controllers.Controller;
import models.IPlantilla;
import models.sesion.Estado;
import models.sesion.TipoSesion;
import views.Libreria;

public class TipoAndEstadoView implements IPlantilla {

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
		System.out.println("5. Listar tipo de sesiones");
		System.out.println("---------Estado--------");
		System.out.println("6. Alta");
		System.out.println("7. Modificar");
		System.out.println("8. Buscar Estado por nombre");
		System.out.println("9. Borrar");
		System.out.println("10. Listar estados");
		System.out.println("11. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 11, -1, -1, (byte) 1);
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
		case 5: // Listar
			List<TipoSesion> lTipoSesions = listarTipoSesion(oCtrl);
			if (lTipoSesions != null && !lTipoSesions.isEmpty()) {
				System.out.println("\n### Lista de tipo de sesiones ###");
				for (TipoSesion oTiSeL : lTipoSesions) {
					System.out.println(" Nombre de la sesion: " + oTiSeL.getsNombreTipoSesion()
							+ " - Duracion de la sesion: " + oTiSeL.getShDuracionTipoSesion() + " min");
				}
			} else {
				System.out.println("No hay ninguna empresa");
			}
			break;
		case 6: // Alta de Estado
			if (createEstado(oCtrl)) {
				System.out.println("El estado de sesion ha sido creado con exito.");
			} else {
				System.out.println("El estado de sesion no se ha podido crear.");
			}
			break;
		case 7: // Modificar Estado
			if (updateEstado(oCtrl)) {
				System.out.println("El estado de sesion ha sido modificado con exito.");
			} else {
				System.out.println("El estado de sesion no se ha podido modificar.");
			}
			break;
		case 8: // Buscar Estado
			Estado oEstado = searchByNombreEstado(oCtrl);
			if (oEstado != null) {
				System.out.println("El estado de sesion buscado existe en la base de datos.");
				System.out.println(oEstado);
			} else {
				System.out.println("El estado de sesion no existe en la base de datos.");
			}
			break;
		case 9: // Borrar Estado
			if (removeEstado(oCtrl)) {
				System.out.println("El estado de sesion ha sido eliminado con exito.");
			} else {
				System.out.println("El estado de sesion no se ha podido eliminar.");
			}
			break;
		case 10: // Listar
			List<Estado> lEstados = listarEstado(oCtrl);
			if (lEstados != null && !lEstados.isEmpty()) {
				System.out.println("\n### Lista de estados ###");
				for (Estado oEst : lEstados) {
					System.out.println(" Nombre del estado de sesion: " + oEst.getsNombreEstado());
				}
			} else {
				System.out.println("No hay ninguna empresa");
			}
			break;
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

		sNombreTipoSesion = String
				.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		sNombreTipoSesion = Libreria.primeraMayus(sNombreTipoSesion);

		try {
			shDuracionTipoSesion = (short) (Libreria.leer("Introduce una duracion *", 0, SHMAXDURACION, -1, -1,
					(byte) 2));
		} catch (Exception e) {
			shDuracionTipoSesion = -1;
		}

		return oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoTipoSesionCtrl()
				.add(new TipoSesion(sNombreTipoSesion, shDuracionTipoSesion));
	}

	private static boolean updateTipoSesion(Controller oCtrl) {
		short shDuracionTipoSesion;
		boolean booExito = false;
		TipoSesion oTipoSesion = searchByNombreTipoSesion(oCtrl);

		if (oTipoSesion != null) {
			if (oTipoSesion != null && oTipoSesion.checkTipoSesion()) {
				System.out.println("Modifica los datos del tipo de sesion: ");

				try {
					shDuracionTipoSesion = (short) (Libreria.leer("Introduce una duracion ", 0, SHMAXDURACION, -1, -1,
							(byte) 2));
				} catch (Exception e) {
					shDuracionTipoSesion = -1;
				}
				oTipoSesion.setShDuracionTipoSesion(shDuracionTipoSesion);

				booExito = oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoTipoSesionCtrl()
						.update(oTipoSesion);
			}
		}
		return booExito;
	}

	private static TipoSesion searchByNombreTipoSesion(Controller oCtrl) {
		String sNombreTipoSesion;
		do {
			sNombreTipoSesion = String
					.valueOf(Libreria.leer("Introduce un nombre ", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombreTipoSesion.isEmpty() && sNombreTipoSesion.length() > BMAXDNI);
		sNombreTipoSesion = Libreria.primeraMayus(sNombreTipoSesion);

		return oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoTipoSesionCtrl()
				.searchByPk(new TipoSesion(sNombreTipoSesion));
	}

	private static boolean removeTipoSesion(Controller oCtrl) {
		boolean bExito = false;
		String sNombreTipoSesion;
		do {
			sNombreTipoSesion = String
					.valueOf(Libreria.leer("Introduce un nombre ", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombreTipoSesion.isEmpty() && sNombreTipoSesion.length() > BMAXDNI);
		sNombreTipoSesion = Libreria.primeraMayus(sNombreTipoSesion);

		bExito = oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoTipoSesionCtrl()
				.remove(new TipoSesion(sNombreTipoSesion));

		return bExito;
	}

	public static List<TipoSesion> listarTipoSesion(Controller oCtrl) {
		return oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoTipoSesionCtrl().listar();
	}

	// ########### Estado ##############

	private static boolean createEstado(Controller oCtrl) {
		String sNombreEstado;

		System.out.println("\nIntroduce los datos del estado de sesion: ");
		System.out.println("Campos requeridos *");

		sNombreEstado = String.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		sNombreEstado = Libreria.primeraMayus(sNombreEstado);
		return oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl().add(new Estado(sNombreEstado));
	}

	private static boolean updateEstado(Controller oCtrl) {
		String sNombreEstado;
		boolean booExito = false;
		Estado oEstadoAntiguo = searchByNombreEstado(oCtrl);
		Estado oEstado = new Estado(oEstadoAntiguo.getsNombreEstado());

		if (oEstado != null && oEstado.checkEstado()) {
			System.out.println("Modifica los datos del estado: ");

			do {
				sNombreEstado = String
						.valueOf(Libreria.leer("Introduce un nuevo nombre ", 0, BMAXNOMBRELARGO, -1, -1, (byte) 6));
			} while (!sNombreEstado.isEmpty() && sNombreEstado.length() > BMAXNOMBRELARGO);
			sNombreEstado = Libreria.primeraMayus(sNombreEstado);
			oEstado.setsNombreEstado(sNombreEstado);

			booExito = oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl().update(oEstado,
					oEstadoAntiguo);
		}

		return booExito;
	}

	private static Estado searchByNombreEstado(Controller oCtrl) {
		String sNombreEstado;
		do {
			sNombreEstado = String.valueOf(Libreria.leer("Introduce un nombre ", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombreEstado.isEmpty() && sNombreEstado.length() > BMAXNOMBRELARGO);
		sNombreEstado = Libreria.primeraMayus(sNombreEstado);

		return oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl()
				.searchByPk(new Estado(sNombreEstado));
	}

	private static boolean removeEstado(Controller oCtrl) {
		boolean bExito = false;
		String sNombreEstado;
		do {
			sNombreEstado = String.valueOf(Libreria.leer("Introduce un nombre ", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombreEstado.isEmpty() && sNombreEstado.length() > BMAXNOMBRELARGO);
		sNombreEstado = Libreria.primeraMayus(sNombreEstado);

		bExito = oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl()
				.remove(new Estado(sNombreEstado));

		return bExito;
	}

	public static List<Estado> listarEstado(Controller oCtrl) {
		return oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl().listar();
	}

}
