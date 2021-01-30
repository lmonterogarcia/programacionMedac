
public class B9_P4 {

	public static void main(String[] args) {
		// Creamos tienda, llenamos el almacen y mostramos el inventario:
		Tienda oTienda = new Tienda();
		oTienda.llenarAlmacen();
		oTienda.mostrarInventario();

		// Creamos cliente, lo registramos en la tienda y mostramos su saldo:
		Cliente oCliente = new Cliente("Pedro", 1000);
		oTienda.aniadirCliente(oCliente);
		c.mostrarSaldo();

		// Obtenemos array de articulos en la tienda:
		Articulo[] articulos = oTienda.obtenerArticulos();

		// Ejemplo de venta directa:
		oTienda.vender(articulos[0], oCliente);

		// Mostramos el estado del inventario, el saldo y el historial del
		// cliente despues de la compra:
		oTienda.mostrarInventario();
		oCliente.mostrarSaldo();
		oCliente.mostrarHistorial();

		// Ejemplo de venta mediante el carrito:
		oTienda.meterAlCarrito(articulos[1], oCliente);
		oTienda.meterAlCarrito(articulos[3], oCliente);
		oCliente.mostrarCarrito();
		oTienda.venderCarrito(oCliente);

		// Mostramos el estado del inventario,el saldo y el historial del
		// cliente despues de la compra:
		oTienda.mostrarInventario();
		oCliente.mostrarSaldo();
		oCliente.mostrarHistorial();

		// ----------------------------------------------------------------------
		// Algunas opciones que no deberían hacerse:
		// ----------------------------------------------------------------------

		// 1. Intentamos meter al carrito un articulo que no esta en el inventario:
		oTienda.meterAlCarrito(new Articulo(99, "ArticuloTrampa", 0), oCliente);

		// 2. Intentamos comprar un articulo que no esta en el inventario:
		oTienda.vender(new Articulo(99, "ArticuloTrampa", 0), oCliente);

		// 3. Un cliente no registrado intenta comprar en la
		// tienda:t.vender(articulos[0],new Cliente("ClienteNoRegistrado"));

	}

}
