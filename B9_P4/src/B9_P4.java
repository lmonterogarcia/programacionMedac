
public class B9_P4 {

	public static void main(String[] args) {
		// Creamos tienda, llenamos el almacen y mostramos el inventario:
		Tienda oTienda = new Tienda(1);
		oTienda.llenarAlmacen();
		System.out.println(oTienda.mostrarInventario());

		// Creamos cliente, lo registramos en la tienda y mostramos su saldo:
		Cliente oCliente = new Cliente(1, "Pedro", 1000);
		oTienda.aniadirCliente(oCliente);
		System.out.println(oCliente.mostrarSaldo());

		// Obtenemos array de articulos en la tienda:
		// Esta funcion no tiene mucho sentido si se trabaja con ArrayList...
//		Articulo[] aArticulos = oTienda.obtenerArticulos();

		// Ejemplo de venta directa:
		System.out.println(vender(oTienda, oTienda.getlArticulos().get(0), oCliente));

		// Mostramos el estado del inventario, el saldo y el historial del
		// cliente despues de la compra:
		System.out.println(oTienda.mostrarInventario());
		System.out.println(oCliente.mostrarSaldo());
		System.out.println(oCliente.mostrarHistorial());

		// Ejemplo de venta mediante el carrito:
//		oTienda.meterAlCarrito(oTienda.getlArticulos().get(1), oCliente);
		System.out.println(meterCarrito(oTienda, oTienda.getlArticulos().get(1), oCliente));
//		oTienda.meterAlCarrito(oTienda.getlArticulos().get(3), oCliente);
		System.out.println(meterCarrito(oTienda, oTienda.getlArticulos().get(3), oCliente));
		System.out.println(oCliente.mostrarCarrito());
		System.out.println(oTienda.venderCarrito(oCliente));

		// Mostramos el estado del inventario,el saldo y el historial del
		// cliente despues de la compra:
		System.out.println(oTienda.mostrarInventario());
		System.out.println(oCliente.mostrarSaldo());
		System.out.println(oCliente.mostrarHistorial());

		// ----------------------------------------------------------------------
		// Algunas opciones que no deberían hacerse:
		// ----------------------------------------------------------------------

		// 1. Intentamos meter al carrito un articulo que no esta en el inventario:
		System.out.println(meterCarrito(oTienda, new Articulo(99, "ArticuloTrampa", 0), oCliente));

		// 2. Intentamos comprar un articulo que no esta en el inventario:
		System.out.println(vender(oTienda, new Articulo(99, "ArticuloTrampa", 0), oCliente));

		// 3. Un cliente no registrado intenta comprar en la tienda:
		System.out.println(vender(oTienda, oTienda.getlArticulos().get(3), new Cliente(2, "NoRegistrado", 1000)));

	}

	private static String meterCarrito(Tienda oTienda, Articulo oArticulo, Cliente oCliente) {
		String sMensaje = "\n";
		if (oTienda.meterAlCarrito(oArticulo, oCliente)) {
			sMensaje += "Articulo " + oArticulo.getsNombre() + " añadido al carrtio del cliente " + oCliente.getsNombre() + ".";
		} else {
			if (!oTienda.getlArticulos().contains(oArticulo)) {
				sMensaje += "--Error: Articulo no existe en la tienda.";
			} else if(!oTienda.getlClientes().contains(oCliente)) {
				sMensaje += "--Error: Cliente no esta registrado en la tienda.";
			} else {
				sMensaje += "--Error: No hay suficiente cantidad del producto.";
			}
			
		}
		return sMensaje;
	}
	
	private static String vender(Tienda oTienda, Articulo oArticulo, Cliente oCliente) {
		String sMensaje = "\n";
		if (oTienda.vender(oArticulo, oCliente)) {
			sMensaje += "Articulo " + oArticulo.getsNombre() + " vendido al cliente " + oCliente.getsNombre() + ".";
		} else {
			if (!oTienda.getlArticulos().contains(oArticulo)) {
				sMensaje += "--Error: Articulo no existe en la tienda.";
			} else if(!oTienda.getlClientes().contains(oCliente)) {
				sMensaje += "--Error: Cliente no esta registrado en la tienda.";
			} else {
				sMensaje += "--Error: No hay suficiente cantidad del producto.";
			}
			
		}
		return sMensaje;
	}

}
