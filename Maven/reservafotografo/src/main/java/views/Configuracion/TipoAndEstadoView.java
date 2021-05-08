package views.Configuracion;

import java.util.*;

import org.apache.commons.lang3.text.WordUtils;

import controllers.Controller;
import models.IPlantilla;
import models.sesion.Estado;
import models.sesion.EstadoTipoSesion;
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
		System.out.println("6. Aniadir estado a un tipo de sesion");
		System.out.println("7. Eliminar estado a un tipo de sesion");
		System.out.println("8. Cambiar el orden de estados de un tipo de sesion");
		System.out.println("---------Estado--------");
		System.out.println("9. Alta");
		System.out.println("10. Modificar");
		System.out.println("11. Buscar Estado por nombre");
		System.out.println("12. Borrar");
		System.out.println("13. Listar estados");
		System.out.println("14. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 14, -1, -1, (byte) 1);
	}

	public static void gestionTipoAndEstado(Controller oCtrl) {
		byte bOpcion;
		do {
			bOpcion = subMenuTipoAndEstado();
			switch (bOpcion) {
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
						listarEstadosDeTipoSesion(oCtrl, oTipoSesion);
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
							listarEstadosDeTipoSesion(oCtrl, oTiSeL);
						}
					} else {
						System.out.println("No hay ninguna empresa");
					}
					break;
				case 6: // Aniadir Estados a Tipo de Sesion
					if (asignarEstadoToTipoSesion(oCtrl)) {
						System.out.println("El/los estados se han aniadido al tipo de sesion");
					} else {
						System.out.println("No se han aniadido estados al tipo de sesion");
					}
					break;
				case 7: // Eliminar Estados a Tipo de Sesion
					if (eliminarEstadoToTipoSesion(oCtrl)) {
						System.out.println("El estado se ha eliminado del tipo de sesion");
					} else {
						System.out.println("El estado NO se ha eliminado del tipo de sesion");
					}
					break;
				case 8: // Cambiar orden entre Estados de un Tipo de sesion
					if (cambiarOrdenEstados(oCtrl)) {
						System.out.println("Se ha intercambiado el orden");
					} else {
						System.out.println("No se ha intercambiado el orden");
					}
					break;
				case 9: // Alta de Estado
					if (createEstado(oCtrl)) {
						System.out.println("El estado de sesion ha sido creado con exito.");
					} else {
						System.out.println("El estado de sesion no se ha podido crear.");
					}
					break;
				case 10: // Modificar Estado
					if (updateEstado(oCtrl)) {
						System.out.println("El estado de sesion ha sido modificado con exito.");
					} else {
						System.out.println("El estado de sesion no se ha podido modificar.");
					}
					break;
				case 11: // Buscar Estado
					Estado oEstado = searchByNombreEstado(oCtrl);
					if (oEstado != null) {
						System.out.println("El estado de sesion buscado existe en la base de datos.");
						System.out.println(oEstado);
					} else {
						System.out.println("El estado de sesion no existe en la base de datos.");
					}
					break;
				case 12: // Borrar Estado
					if (removeEstado(oCtrl)) {
						System.out.println("El estado de sesion ha sido eliminado con exito.");
					} else {
						System.out.println("El estado de sesion no se ha podido eliminar.");
					}
					break;
				case 13: // Listar
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
		} while (bOpcion != 14);
	}

	// ########### Tipo Sesion ##############

	private static boolean createTipoSesion(Controller oCtrl) {
		String sNombreTipoSesion;
		short shDuracionTipoSesion;

		System.out.println("\nIntroduce los datos del tipo de sesion: ");
		System.out.println("Campos requeridos *");

		sNombreTipoSesion = String
				.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		sNombreTipoSesion = WordUtils.capitalizeFully(sNombreTipoSesion);

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
		sNombreTipoSesion = WordUtils.capitalizeFully(sNombreTipoSesion);

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
		sNombreTipoSesion = WordUtils.capitalizeFully(sNombreTipoSesion);

		bExito = oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoTipoSesionCtrl()
				.remove(new TipoSesion(sNombreTipoSesion));

		return bExito;
	}

	public static List<TipoSesion> listarTipoSesion(Controller oCtrl) {
		return oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoTipoSesionCtrl().listar();
	}

	private static void listarEstadosDeTipoSesion(Controller oCtrl, TipoSesion oTipoSesion) {
		if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl()
				.searchByTipoSesion(oTipoSesion) != null) {
			byte bOrden = 1;
			System.out.println("# Estados en el tipo de sesion #");
			List<EstadoTipoSesion> lEstados = oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl()
					.getoEstadoTipoSesionCtrl().listar(oTipoSesion.getsNombreTipoSesion());
			for (EstadoTipoSesion oEstadoTipoSesion : lEstados) {
				System.out.println(bOrden + " - " + oEstadoTipoSesion.getoEstado().getsNombreEstado());
				bOrden++;
			}

		} else {
			System.out.println("¡Este tipo de sesion no tiene ningun estado asignado!");
		}
	}

	private static boolean asignarEstadoToTipoSesion(Controller oCtrl) {
		List<EstadoTipoSesion> lEstados = new ArrayList<EstadoTipoSesion>();
		EstadoTipoSesion oEstadoTipoSesion = null;
		Estado oEstado = null;
		String sNombreEstado = null;

		if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoTipoSesionCtrl().listar() != null
				&& oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl().listar() != null) {

			TipoSesion oTipoSesion = new TipoSesion(String.valueOf(
					Libreria.leer("Introduce un nombre de tipo de sesion", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6)));

			if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoTipoSesionCtrl()
					.searchByPk(oTipoSesion) != null) {
				byte bOrden = oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl()
						.getProximoOrden(oTipoSesion);
				System.out.println("¡Cuando quiera dejar de instroducir estados, dejelo en blanco y pulse ENTER!");
				do {
					sNombreEstado = String.valueOf(
							Libreria.leer("Introduce un estado de sesion", 0, BMAXNOMBRELARGO, -1, -1, (byte) 6));

					if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl()
							.searchByPk(new Estado(sNombreEstado)) != null) {

						oEstado = new Estado(sNombreEstado);
						oEstadoTipoSesion = new EstadoTipoSesion(oEstado, oTipoSesion, bOrden);
						bOrden++;

						if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl()
								.searchByPk(oEstadoTipoSesion) == null) {
							lEstados.add(oEstadoTipoSesion);
						} else {
							System.out.println("Ese estado ya esta asignado al tipo de sesion");
						}

					} else {
						if (!sNombreEstado.isEmpty()) {
							System.out.println("¡Este estado no esta creado!");
						}
					}
				} while (!sNombreEstado.isEmpty());
			} else {
				System.out.println("Ese Tipo de Sesion no existe");
			}

		} else {
			System.out.println("Tiene que haber creado tipo de sesiones y estados para utilizar esta herramienta");
		}

		return oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl().add(lEstados);
	}

	private static boolean eliminarEstadoToTipoSesion(Controller oCtrl) {
		String sNombreTipoSesion, sNombreEstado;
		do {
			sNombreTipoSesion = String.valueOf(
					Libreria.leer("Introduce un nombre de tipo de sesion", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
			if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl()
					.searchByTipoSesion(new TipoSesion(sNombreTipoSesion)) == null) {
				System.out.println("Ese pack no tiene estados asignados");
			}
		} while (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl()
				.searchByTipoSesion(new TipoSesion(sNombreTipoSesion)) == null);

		do {
			sNombreEstado = String
					.valueOf(Libreria.leer("Introduce un nombre de estado", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
			if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl().searchByPk(
					new EstadoTipoSesion(new Estado(sNombreEstado), new TipoSesion(sNombreTipoSesion))) == null) {
				System.out.println("Ese estado no esta en el tipo de sesion");
			}
		} while (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl().searchByPk(
				new EstadoTipoSesion(new Estado(sNombreEstado), new TipoSesion(sNombreTipoSesion))) == null);

		return oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl()
				.remove(new EstadoTipoSesion(new Estado(sNombreEstado), new TipoSesion(sNombreTipoSesion)));

	}

	private static boolean cambiarOrdenEstados(Controller oCtrl) {
		String sNombreTipoSesion, sNombreEstado1, sNombreEstado2;
		EstadoTipoSesion oEstadoTipoSesion1 = null, oEstadoTipoSesion2 = null;
		do {
			sNombreTipoSesion = String.valueOf(
					Libreria.leer("Introduce un nombre de tipo de sesion", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
			if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl()
					.searchByTipoSesion(new TipoSesion(sNombreTipoSesion)) == null) {
				System.out.println("Ese tipo de sesion no tiene estados asignados");
			}
		} while (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl()
				.searchByTipoSesion(new TipoSesion(sNombreTipoSesion)) == null);

		if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl()
				.listar(sNombreTipoSesion) != null) {
			do {
				sNombreEstado1 = String.valueOf(
						Libreria.leer("Introduce el primer nombre de estado", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
				if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl().searchByPk(
						new EstadoTipoSesion(new Estado(sNombreEstado1), new TipoSesion(sNombreTipoSesion))) == null) {
					System.out.println("Ese estado no esta en el tipo de sesion");
				}
			} while (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl().searchByPk(
					new EstadoTipoSesion(new Estado(sNombreEstado1), new TipoSesion(sNombreTipoSesion))) == null);

			do {
				sNombreEstado2 = String.valueOf(
						Libreria.leer("Introduce el segundo nombre de estado", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
				if (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl().searchByPk(
						new EstadoTipoSesion(new Estado(sNombreEstado2), new TipoSesion(sNombreTipoSesion))) == null) {
					System.out.println("Ese estado no esta en el tipo de sesion");
				}
			} while (oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl().searchByPk(
					new EstadoTipoSesion(new Estado(sNombreEstado2), new TipoSesion(sNombreTipoSesion))) == null);

			oEstadoTipoSesion1 = new EstadoTipoSesion(new Estado(sNombreEstado1), new TipoSesion(sNombreTipoSesion));
			oEstadoTipoSesion2 = new EstadoTipoSesion(new Estado(sNombreEstado2), new TipoSesion(sNombreTipoSesion));
		} else {
			System.out.println("Ese Tipo de sesion no tiene estados asignados");
		}

		return oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoTipoSesionCtrl()
				.update(oEstadoTipoSesion1, oEstadoTipoSesion2);
	}

	// ########### Estado ##############

	private static boolean createEstado(Controller oCtrl) {
		String sNombreEstado;

		System.out.println("\nIntroduce los datos del estado de sesion: ");
		System.out.println("Campos requeridos *");

		sNombreEstado = String.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		sNombreEstado = WordUtils.capitalizeFully(sNombreEstado);
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
			sNombreEstado = WordUtils.capitalizeFully(sNombreEstado);
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
		sNombreEstado = WordUtils.capitalizeFully(sNombreEstado);

		return oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl()
				.searchByPk(new Estado(sNombreEstado));
	}

	private static boolean removeEstado(Controller oCtrl) {
		boolean bExito = false;
		String sNombreEstado;
		do {
			sNombreEstado = String.valueOf(Libreria.leer("Introduce un nombre ", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombreEstado.isEmpty() && sNombreEstado.length() > BMAXNOMBRELARGO);
		sNombreEstado = WordUtils.capitalizeFully(sNombreEstado);

		bExito = oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl()
				.remove(new Estado(sNombreEstado));

		return bExito;
	}

	public static List<Estado> listarEstado(Controller oCtrl) {
		return oCtrl.getConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl().listar();
	}

}
