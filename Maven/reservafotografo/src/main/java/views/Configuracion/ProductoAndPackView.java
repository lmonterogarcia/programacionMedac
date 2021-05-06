package views.Configuracion;

import java.util.*;

import org.apache.commons.lang3.text.WordUtils;

import controllers.Controller;
import models.IPlantilla;
import models.productos.Pack;
import models.productos.PackProducto;
import models.productos.Producto;
import views.Libreria;

public class ProductoAndPackView implements IPlantilla {

	public static byte subMenuProductoAndPack() {
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Gestion de productos y packs");
		System.out.println("-----------------------");
		System.out.println("------Productos------");
		System.out.println("1. Alta");
		System.out.println("2. Modificar");
		System.out.println("3. Buscar producto por nombre");
		System.out.println("4. Borrar");
		System.out.println("5. Listar todos los productos");
		System.out.println("---------Pack--------");
		System.out.println("6. Alta");
		System.out.println("7. Modificar");
		System.out.println("8. Buscar Pack por nombre");
		System.out.println("9. Borrar");
		System.out.println("10. Listar todos los pack");
		System.out.println("11. Aniadir productos a un pack");
		System.out.println("12. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 12, -1, -1, (byte) 1);
	}

	public static void gestionProductoAndPack(Controller oCtrl) {
		byte bOpcion;
		do {
			bOpcion = subMenuProductoAndPack();
			switch (bOpcion) {
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
				case 5: // Listar Producto
					List<Producto> oListaProducto = listarProducto(oCtrl);
					if (oListaProducto != null && !oListaProducto.isEmpty()) {
						System.out.println("\n## Lista de productos ##");
						for (Producto oPro : oListaProducto) {
							System.out.println(
									"Nombre: " + oPro.getsNombreProducto() + " - Precio: " + oPro.getfPrecioProducto());
						}
						if (String.valueOf(Libreria.leer("¿Quiere mas informacion de algun producto? (s/n) ", -1, -1,
								-1, -1, (byte) 7)).equalsIgnoreCase("s")) {
							Producto oProL = searchByNombreProducto(oCtrl);
							if (oProL != null) {
								System.out.println(oProL);
							} else {
								System.out.println("El prodcuto no existe en la base de datos.");
							}
						}
					} else {
						System.out.println("No existen productos en la base de datos.");
					}
					break;
				case 6: // Alta de Pack
					if (createPack(oCtrl)) {
						System.out.println("El pack ha sido creado con exito.");
					} else {
						System.out.println("El pack no se ha podido crear.");
					}
					break;
				case 7: // Modificar Pack
					if (updatePack(oCtrl)) {
						System.out.println("El pack ha sido modificado con exito.");
					} else {
						System.out.println("El pack no se ha podido modificar.");
					}
					break;
				case 8: // Buscar Pack
					Pack oPack = searchByNombrePack(oCtrl);
					if (oPack != null) {
						System.out.println("El pack buscado existe en la base de datos.");
						System.out.println(oPack);
						listarProductoDePack(oCtrl, oPack);
					} else {
						System.out.println("El pack no existe en la base de datos.");
					}
					break;
				case 9: // Borrar Pack
					if (removePack(oCtrl)) {
						System.out.println("El pack ha sido eliminado con exito.");
					} else {
						System.out.println("El pack no se ha podido eliminar.");
					}
					break;
				case 10: // Listar Pack
					List<Pack> oListaPack = listarPack(oCtrl);
					if (oListaPack != null && !oListaPack.isEmpty()) {
						System.out.println("\n## Lista de pack ##");
						for (Pack oPac : oListaPack) {
							System.out.println(
									"Nombre: " + oPac.getsNombrePack() + " - Precio: " + oPac.getfPrecioPack());
						}
						if (String.valueOf(Libreria.leer("¿Quiere mas informacion de algun pack? (s/n) ", -1, -1, -1,
								-1, (byte) 7)).equalsIgnoreCase("s")) {
							Pack oPackL = searchByNombrePack(oCtrl);
							if (oPackL != null) {
								System.out.println(oPackL);
								listarProductoDePack(oCtrl, oPackL);
							} else {
								System.out.println("El pack no existe en la base de datos.");
							}
						}
					} else {
						System.out.println("No existen packs en la base de datos.");
					}
					break;
				case 11: // Modificar Pack
					if (asignarProductoToPack(oCtrl)) {
						System.out.println("El/los prodcutos se han aniadido al pack");
					} else {
						System.out.println("No se han aniadido al pack");
					}
					break;
				default:
					break;
			}
		} while (bOpcion != 11);

	}

	// ########### Producto ##############

	private static boolean createProducto(Controller oCtrl) {
		String sNombreProducto, sProveedorProducto, sDescripcionProducto;
		float fPrecioProducto, fCosteProducto;

		System.out.println("\nIntroduce los datos del producto: ");
		System.out.println("Campos requeridos *");

		sNombreProducto = String.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		sNombreProducto = WordUtils.capitalizeFully(sNombreProducto);

		do {
			try {
				fPrecioProducto = (float) (Libreria.leer("Introduce un precio *", -1, -1, 0, 1000000, (byte) 5));
			} catch (Exception e) {
				fPrecioProducto = -1;
			}
		} while (fPrecioProducto == -1);

		try {
			fCosteProducto = (float) (Libreria.leer("Introduce el coste *", -1, -1, 0, 1000000, (byte) 5));
		} catch (Exception e) {
			fCosteProducto = -1;
		}

		do {
			sProveedorProducto = String
					.valueOf(Libreria.leer("Introduce el proovedor", 0, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sProveedorProducto.isEmpty() && sProveedorProducto.length() > BMAXNOMBRELARGO);
		sProveedorProducto = WordUtils.capitalizeFully(sProveedorProducto);

		do {
			sDescripcionProducto = String
					.valueOf(Libreria.leer("Introduce la descripcion", 0, BMAX255, -1, -1, (byte) 6));
		} while (!sDescripcionProducto.isEmpty() && sDescripcionProducto.length() > BMAX255);

		return oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoProductoCtrl().add(new Producto(sNombreProducto,
				fPrecioProducto, fCosteProducto, sProveedorProducto, sDescripcionProducto));
	}

	private static boolean updateProducto(Controller oCtrl) {
		String sProveedorProducto, sDescripcionProducto;
		float fPrecioProducto, fCosteProducto;
		boolean booExito = false;
		Producto oProducto = searchByNombreProducto(oCtrl);

		if (oProducto != null) {
			if (oProducto != null && oProducto.checkProducto()) {
				System.out.println("Modifica los datos del tipo de sesion: ");

				try {
					fPrecioProducto = (float) (Libreria.leer(
							"Introduce un precio (" + oProducto.getfPrecioProducto() + ")", -1, -1, 0, 1000000,
							(byte) 5));
				} catch (Exception e) {
					fPrecioProducto = -1;
				}
				oProducto.setfPrecioProducto(fPrecioProducto);

				try {
					fCosteProducto = (float) (Libreria.leer(
							"Introduce el coste (" + oProducto.getfCosteProducto() + ")", -1, -1, 0, 1000000,
							(byte) 5));
				} catch (Exception e) {
					fCosteProducto = -1;
				}
				oProducto.setfCosteProducto(fCosteProducto);

				do {
					sProveedorProducto = String
							.valueOf(Libreria.leer("Introduce el proovedor (" + oProducto.getsProveedorProducto() + ")",
									0, BMAXNOMBRELARGO, -1, -1, (byte) 6));
				} while (!sProveedorProducto.isEmpty() && sProveedorProducto.length() > BMAXNOMBRELARGO);
				oProducto.setsProveedorProducto(sProveedorProducto);

				do {
					sDescripcionProducto = String.valueOf(
							Libreria.leer("Introduce la descripcion (" + oProducto.getsDescripcionProducto() + ")", 0,
									BMAX255, -1, -1, (byte) 6));
				} while (!sDescripcionProducto.isEmpty() && sDescripcionProducto.length() > BMAX255);
				oProducto.setsDescripcionProducto(sDescripcionProducto);

				booExito = oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoProductoCtrl().update(oProducto);
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
		sNombreProducto = WordUtils.capitalizeFully(sNombreProducto);

		return oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoProductoCtrl()
				.searchByPk(new Producto(sNombreProducto));
	}

	private static boolean removeProducto(Controller oCtrl) {
		boolean bExito = false;
		String sNombreProducto;
		do {
			sNombreProducto = String
					.valueOf(Libreria.leer("Introduce un nombre ", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombreProducto.isEmpty() && sNombreProducto.length() > BMAXNOMBRELARGO);
		sNombreProducto = WordUtils.capitalizeFully(sNombreProducto);

		bExito = oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoProductoCtrl()
				.remove(new Producto(sNombreProducto));

		return bExito;
	}

	public static List<Producto> listarProducto(Controller oCtrl) {
		return oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoProductoCtrl().listar();

	}

	// ########### Pack ##############

	private static boolean createPack(Controller oCtrl) {
		String sNombrePack, sDescripcionPack;
		float fPrecioPack;

		System.out.println("\nIntroduce los datos del pack: ");
		System.out.println("Campos requeridos *");

		sNombrePack = String.valueOf(Libreria.leer("Introduce un nombre *", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		sNombrePack = WordUtils.capitalizeFully(sNombrePack);

		do {
			try {
				fPrecioPack = (float) (Libreria.leer("Introduce un precio *", -1, -1, 0, 1000000, (byte) 5));
			} catch (Exception e) {
				fPrecioPack = -1;
			}
		} while (fPrecioPack == -1);

		do {
			sDescripcionPack = String.valueOf(Libreria.leer("Introduce la descripcion", 0, BMAX255, -1, -1, (byte) 6));
		} while (!sDescripcionPack.isEmpty() && sDescripcionPack.length() > BMAX255);

		return oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoPackCtrl()
				.add(new Pack(sNombrePack, fPrecioPack, sDescripcionPack));
	}

	private static boolean updatePack(Controller oCtrl) {
		String sDescripcionPack;
		float fPrecioPack;
		boolean booExito = false;
		Pack oPack = searchByNombrePack(oCtrl);

		if (oPack != null && oPack.checkPack()) {
			System.out.println("Modifica los datos del pack: ");

			try {
				fPrecioPack = (float) (Libreria.leer("Introduce un precio (" + oPack.getfPrecioPack() + ")", -1, -1, 0,
						1000000, (byte) 5));
			} catch (Exception e) {
				fPrecioPack = -1;
			}
			oPack.setfPrecioPack(fPrecioPack);

			do {
				sDescripcionPack = String
						.valueOf(Libreria.leer("Introduce la descripcion (" + oPack.getsDescripcionPack() + ")", 0,
								BMAX255, -1, -1, (byte) 6));
			} while (!sDescripcionPack.isEmpty() && sDescripcionPack.length() > BMAX255);
			oPack.setsDescripcionPack(sDescripcionPack);

			booExito = oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoPackCtrl().update(oPack);
		}

		return booExito;
	}

	private static Pack searchByNombrePack(Controller oCtrl) {
		String sNombrePack;
		do {
			sNombrePack = String.valueOf(Libreria.leer("Introduce un nombre ", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombrePack.isEmpty() && sNombrePack.length() > BMAXNOMBRELARGO);
		sNombrePack = WordUtils.capitalizeFully(sNombrePack);

		return oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoPackCtrl().searchByPk(new Pack(sNombrePack));
	}

	private static boolean removePack(Controller oCtrl) {
		boolean bExito = false;
		String sNombrePack;
		do {
			sNombrePack = String.valueOf(Libreria.leer("Introduce un nombre ", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		} while (!sNombrePack.isEmpty() && sNombrePack.length() > BMAXNOMBRELARGO);
		sNombrePack = WordUtils.capitalizeFully(sNombrePack);

		bExito = oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoPackCtrl().remove(new Pack(sNombrePack));

		return bExito;
	}

	public static List<Pack> listarPack(Controller oCtrl) {
		return oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoPackCtrl().listar();

	}

	private static void listarProductoDePack(Controller oCtrl, Pack oPack) {
		if (oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoPackProductoCtrl().searchByPack(oPack) != null) {
			System.out.println("# Productos en el pack #");
			List<PackProducto> lProductos = oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoPackProductoCtrl()
					.listar(oPack.getsNombrePack());
			for (PackProducto oPackProducto : lProductos) {
				System.out.println(oPackProducto.getoProducto().getsNombreProducto());
			}

		} else {
			System.out.println("¡Este pack no tiene ningun producto asignado!");
		}
	}

	private static boolean asignarProductoToPack(Controller oCtrl) {
		List<PackProducto> lProductos = new ArrayList<PackProducto>();
		PackProducto oPackProducto = null;
		Producto oProducto = null;
		String sNombreProducto = null;

		if (oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoPackCtrl().listar() != null
				&& oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoProductoCtrl().listar() != null) {

			Pack oPack = new Pack(String
					.valueOf(Libreria.leer("Introduce un nombre de pack", 1, BMAXNOMBRELARGO, -1, -1, (byte) 6)));
			System.out.println("¡Cuando quiera dejar de instroducir productos, dejelo en blanco y pulse ENTER!");
			do {
				sNombreProducto = String.valueOf(
						Libreria.leer("Introduce un nombre de producto", 0, BMAXNOMBRELARGO, -1, -1, (byte) 6));
		
				if (oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoProductoCtrl()
				.searchByPk(new Producto(sNombreProducto)) != null) {
						oProducto = new Producto(sNombreProducto);
						oPackProducto = new PackProducto(oPack, oProducto);
						lProductos.add(oPackProducto);
				} else {
					if (!sNombreProducto.isEmpty()) {
						System.out.println("¡Este producto no esta creado!");
					}			
				}
			} while (!sNombreProducto.isEmpty());

		} else {
			System.out.println("Tiene que haber creado productos y pack para utilizar esta herramienta");
		}

		return oCtrl.getConfiguracionCtrl().getoProductosCtrl().getoPackProductoCtrl().add(lProductos);
	}
}
