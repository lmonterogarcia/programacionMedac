package views.Configuracion;

import controllers.Controller;
import models.IPlantilla;
import models.productos.Pack;
import models.productos.Producto;
import views.Libreria;

public class ProductoAndPackView implements IPlantilla {

	public static byte subMenuProductoAndPack() {
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Gestion de prodcutos y packs");
		System.out.println("-----------------------");
		System.out.println("-----Prodcutos----");
		System.out.println("1. Alta");
		System.out.println("2. Modificar");
		System.out.println("3. Buscar producto por nombre");
		System.out.println("4. Borrar");
		System.out.println("---------Pack--------");
		System.out.println("5. Alta");
		System.out.println("6. Modificar");
		System.out.println("7. Buscar Pack por nombre");
		System.out.println("8. Borrar");
		System.out.println("9. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 9, -1, -1, (byte) 1);
	}

	public static void gestionProductoAndPack(Controller oCtrl) {
		switch (subMenuProductoAndPack()) {
		case 1: // Alta del Producto
			if (createProducto(oCtrl)) {
				System.out.println("El producto ha sido creada con exito.");
			} else {
				System.out.println("El producto no se ha podido crear.");
			}
			break;
		case 2: // Modificar Producto
			if (updateProducto(oCtrl)) {
				System.out.println("El producto ha sido modificado con exito.");
			} else {
				System.out.println("El producto no se ha podido modificar.");
			}
			break;
		case 3: // Buscar Producto
			Producto oProducto = searchByNombreProducto(oCtrl);
			if (oProducto != null) {
				System.out.println("El producto buscado existe en la base de datos.");
				System.out.println(oProducto);
			} else {
				System.out.println("El producto no existe en la base de datos.");
			}
			break;
		case 4: // Borrar Producto
			if (removeProducto(oCtrl)) {
				System.out.println("El producto ha sido eliminado con exito.");
			} else {
				System.out.println("El producto no se ha podido eliminar.");
			}
			break;
		case 5: // Alta de Pack
			if (createPack(oCtrl)) {
				System.out.println("El pack ha sido creado con exito.");
			} else {
				System.out.println("El pack no se ha podido crear.");
			}
			break;
		case 6: // Modificar Pack
			if (updatePack(oCtrl)) {
				System.out.println("El pack ha sido modificado con exito.");
			} else {
				System.out.println("El pack no se ha podido modificar.");
			}
			break;
		case 7: // Buscar Pack
			Pack oPack = searchByNombrePack(oCtrl);
			if (oPack != null) {
				System.out.println("El pack buscado existe en la base de datos.");
				System.out.println(oPack);
			} else {
				System.out.println("El pack no existe en la base de datos.");
			}
			break;
		case 8: // Borrar Pack
			if (removePack(oCtrl)) {
				System.out.println("El pack ha sido eliminado con exito.");
			} else {
				System.out.println("El pack no se ha podido eliminar.");
			}
			break;
		default:
			break;
		}
	}

	// ########### Tipo Sesion ##############

	private static boolean createProducto(Controller oCtrl) {
		String sNombreProducto, sProveedroProducto, sDescripcionProducto;
		float fPrecioProducto, fCosteProducto;

		System.out.println("\nIntroduce los datos del producto: ");
		System.out.println("Campos requeridos *");

		sNombreProducto = String.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		sNombreProducto = Libreria.todasPrimeraMayus(sNombreProducto);

		do {
			try {
				fPrecioProducto = (float) (Libreria.leer("Introduce un precio *", -1, -1, 0, 1000000, (byte) 4));
			} catch (Exception e) {
				fPrecioProducto = -1;
			}
		} while (fPrecioProducto == -1);

		try {
			fCosteProducto = (float) (Libreria.leer("Introduce el coste *", -1, -1, 0, 1000000, (byte) 4));
		} catch (Exception e) {
			fCosteProducto = -1;
		}

		do {
			sProveedroProducto = String
					.valueOf(Libreria.leer("Introduce el proovedor", 0, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sProveedroProducto.isEmpty() && sProveedroProducto.length() > BMAXNOMBRELARGO);
		sProveedroProducto = Libreria.todasPrimeraMayus(sProveedroProducto);

		do {
			sDescripcionProducto = String.valueOf(Libreria.leer("Introduce el primer apellido", 0, BMAX255, -1, -1, (byte) 6));
		} while (!sDescripcionProducto.isEmpty() && sDescripcionProducto.length() > BMAX255);

		return oCtrl.getConfiguracionCtrl().getoProductoPackCtrl().getoProductoCtrl()
				.add(new Producto(sNombreProducto, fPrecioProducto, fCosteProducto, sProveedroProducto, sDescripcionProducto));
	}

	private static boolean updateProducto(Controller oCtrl) {
		String sProveedroProducto, sDescripcionProducto;
		float fPrecioProducto, fCosteProducto;
		boolean booExito = false;
		Producto oProducto = searchByNombreProducto(oCtrl);

		if (oProducto != null) {
			if (oProducto != null && oProducto.checkProducto()) {
				System.out.println("Modifica los datos del tipo de sesion: ");

				try {
					fPrecioProducto = (float) (Libreria.leer("Introduce un precio *", -1, -1, 0, 1000000, (byte) 4));
				} catch (Exception e) {
					fPrecioProducto = -1;
				}
				oProducto.setfPrecioProducto(fPrecioProducto);

				try {
					fCosteProducto = (float) (Libreria.leer("Introduce el coste *", -1, -1, 0, 1000000, (byte) 4));
				} catch (Exception e) {
					fCosteProducto = -1;
				}
				oProducto.setfCosteProducto(fCosteProducto);

				do {
					sProveedroProducto = String
							.valueOf(Libreria.leer("Introduce el proovedor", 0, BMAXNOMBRELARGO, -1, -1, (byte) 6));
				} while (!sProveedroProducto.isEmpty() && sProveedroProducto.length() > BMAXNOMBRELARGO);
				oProducto.setsProveedroProducto(sProveedroProducto);

				do {
					sDescripcionProducto = String
							.valueOf(Libreria.leer("Introduce el primer apellido", 0, BMAX255, -1, -1, (byte) 6));
				} while (!sDescripcionProducto.isEmpty() && sDescripcionProducto.length() > BMAX255);
				oProducto.setsDescripcionProducto(sDescripcionProducto);


				booExito = oCtrl.getConfiguracionCtrl().getoProductoPackCtrl().getoProductoCtrl().update(oProducto);
			}
		}
		return booExito;
	}

	private static Producto searchByNombreProducto(Controller oCtrl) {
		String sNombreProducto;
		do {
			sNombreProducto = String
					.valueOf(Libreria.leer("Introduce un nombre ", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombreProducto.isEmpty() && sNombreProducto.length() > BMAXNOMBRELARGO);
		sNombreProducto = Libreria.primeraMayus(sNombreProducto);

		return oCtrl.getConfiguracionCtrl().getoProductoPackCtrl().getoProductoCtrl()
				.searchByPk(new Producto(sNombreProducto));
	}

	private static boolean removeProducto(Controller oCtrl) {
		boolean bExito = false;
		String sNombreProducto;
		do {
			sNombreProducto = String
					.valueOf(Libreria.leer("Introduce un nombre ", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombreProducto.isEmpty() && sNombreProducto.length() > BMAXNOMBRELARGO);
		sNombreProducto = Libreria.primeraMayus(sNombreProducto);

		bExito = oCtrl.getConfiguracionCtrl().getoProductoPackCtrl().getoProductoCtrl()
				.remove(new Producto(sNombreProducto));

		return bExito;
	}

	// ########### Pack ##############

	private static boolean createPack(Controller oCtrl) {
		String sNombrePack, sDescripcionPack;
		float fPrecioPack;

		System.out.println("\nIntroduce los datos del pack: ");
		System.out.println("Campos requeridos *");

		sNombrePack = String.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		sNombrePack = Libreria.primeraMayus(sNombrePack);

		do {
			try {
				fPrecioPack = (float) (Libreria.leer("Introduce un precio *", -1, -1, 0, 1000000, (byte) 4));
			} catch (Exception e) {
				fPrecioPack = -1;
			}
		} while (fPrecioPack == -1);

		do {
			sDescripcionPack = String
					.valueOf(Libreria.leer("Introduce el primer apellido", 0, BMAX255, -1, -1, (byte) 6));
		} while (!sDescripcionPack.isEmpty() && sDescripcionPack.length() > BMAX255);

		return oCtrl.getConfiguracionCtrl().getoProductoPackCtrl().getoPackCtrl().add(new Pack(sNombrePack, fPrecioPack, sDescripcionPack));
	}

	private static boolean updatePack(Controller oCtrl) {
		String sDescripcionPack;
		float fPrecioPack;
		boolean booExito = false;
		Pack oPack = searchByNombrePack(oCtrl);

		if (oPack != null && oPack.checkPack()) {
			System.out.println("Modifica los datos del pack: ");

			try {
				fPrecioPack = (float) (Libreria.leer("Introduce un precio *", -1, -1, 0, 1000000, (byte) 4));
			} catch (Exception e) {
				fPrecioPack = -1;
			}
			oPack.setfPrecioPack(fPrecioPack);

			do {
				sDescripcionPack = String
						.valueOf(Libreria.leer("Introduce el primer apellido", 0, BMAX255, -1, -1, (byte) 6));
			} while (!sDescripcionPack.isEmpty() && sDescripcionPack.length() > BMAX255);
			oPack.setsDescripcionPack(sDescripcionPack);

			booExito = oCtrl.getConfiguracionCtrl().getoProductoPackCtrl().getoPackCtrl().update(oPack);
		}

		return booExito;
	}

	private static Pack searchByNombrePack(Controller oCtrl) {
		String sNombrePack;
		do {
			sNombrePack = String.valueOf(Libreria.leer("Introduce un nombre ", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombrePack.isEmpty() && sNombrePack.length() > BMAXNOMBRELARGO);
		sNombrePack = Libreria.primeraMayus(sNombrePack);

		return oCtrl.getConfiguracionCtrl().getoProductoPackCtrl().getoPackCtrl().searchByPk(new Pack(sNombrePack));
	}

	private static boolean removePack(Controller oCtrl) {
		boolean bExito = false;
		String sNombrePack;
		do {
			sNombrePack = String.valueOf(Libreria.leer("Introduce un nombre ", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombrePack.isEmpty() && sNombrePack.length() > BMAXNOMBRELARGO);
		sNombrePack = Libreria.primeraMayus(sNombrePack);

		bExito = oCtrl.getConfiguracionCtrl().getoProductoPackCtrl().getoPackCtrl().remove(new Pack(sNombrePack));

		return bExito;
	}
}
