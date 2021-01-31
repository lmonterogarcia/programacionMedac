import java.util.*;


public class Tienda {

	private int iIdTienda; // PK
	private List<Articulo> lArticulos; // N
	private List<Integer> lCantidades; // N
	private List<Cliente> lClientes; // N
	private int iNumArticulos; // N
	private int iNumClientes; // N

	/*
	 * ##################### ### Constructores ### #####################
	 */
	public Tienda(int iIdTienda) {
		setiIdTienda(iIdTienda);
		lArticulos = new ArrayList<Articulo>();
		lCantidades = new ArrayList<Integer>();
		lClientes = new ArrayList<Cliente>();
	}

	public Tienda(int iIdTienda, List<Articulo> lArticulos, List<Integer> lCantidades, List<Cliente> lClientes) {
		setiIdTienda(iIdTienda);
		lArticulos = new ArrayList<Articulo>();
		lCantidades = new ArrayList<Integer>();
		lClientes = new ArrayList<Cliente>();
		setiNumArticulos();
		setiNumClientes();
	}

	/*
	 * ################### ### Get and Set ### ###################
	 */
	public int getiIdTienda() {
		return iIdTienda;
	}

	public void setiIdTienda(int iIdTienda) {
		this.iIdTienda = iIdTienda;
	}

	public List<Articulo> getlArticulos() {
		return lArticulos;
	}

	public void setlArticulos(List<Articulo> lArticulos) {
		this.lArticulos = lArticulos;
	}

	public List<Integer> getlCantidades() {
		return lCantidades;
	}

	public void setlCantidades(List<Integer> lCantidades) {
		this.lCantidades = lCantidades;
	}

	public List<Cliente> getlClientes() {
		return lClientes;
	}

	public void setlClientes(List<Cliente> lClientes) {
		this.lClientes = lClientes;
	}

	public int getiNumArticulos() {
		return iNumArticulos;
	}

	public void setiNumArticulos() {
		this.iNumArticulos = lArticulos.size();
	}

	public int getiNumClientes() {
		return iNumClientes;
	}

	public void setiNumClientes() {
		this.iNumClientes = lClientes.size();
	}

	/*
	 * ############### ### METODOS ### ###############
	 */

	public void llenarAlmacen() {

//		Articulo oArticulo = new Articulo();
//		do {
//			oArticulo.setiIdArticulo((int) (Libreria.leer("\nId del articulo: ", 0, 5000000, -1, -1, (byte) 3)));
//			oArticulo.setsNombre((String) (Libreria.leer("Nombre del articulo ", -1, 255, -1, -1, (byte) 10)));
//			oArticulo.setdPrecio((double) (Libreria.leer("Precio del articulo: ", -1, -1, 0, 5000000, (byte) 6)));
//			lArticulos.add(oArticulo);
//			lCantidades.add((int) (Libreria.leer("Cantidad del articulo: ", 0, 50000000, -1, -1, (byte) 3)));
//			setiNumArticulos();
//		} while ((byte) Libreria.leer("\nQuiere seguir introduciendo articulos?\n1. Si\n0. Terminar", 0, 1, -1, -1, (byte) 1) == 1);

		// Para no estar todo el rato introduciendo datos se ha llenado el Almacen con
		// lo siguiente.

		Articulo oArticulo0 = new Articulo(0, "Cero", 10);
		lArticulos.add(oArticulo0);
		Articulo oArticulo1 = new Articulo(1, "Uno", 20);
		lArticulos.add(oArticulo1);
		Articulo oArticulo2 = new Articulo(2, "Dos", 15);
		lArticulos.add(oArticulo2);
		Articulo oArticulo3 = new Articulo(3, "Tres", 180);
		lArticulos.add(oArticulo3);
		Articulo oArticulo4 = new Articulo(4, "Cuatro", 105);
		lArticulos.add(oArticulo4);
		Articulo oArticulo5 = new Articulo(5, "Cinco", 99);
		lArticulos.add(oArticulo5);
		lCantidades = Arrays.asList(12, 9, 10, 15, 4, 1);
		setiNumArticulos();
	}

	public String mostrarInventario() {
		String sInventario = "\n";
		int iPosicion = 0;
		if (getiNumArticulos() > 0) {
			sInventario += "Mostrando inventario de la tienda:\n--------------------------------------------------\n";
			for (Articulo oArticulo : lArticulos) {
				sInventario += "[ " + iPosicion + "] Articulo: " + oArticulo.getsNombre() + " (ref. " + oArticulo.getiIdArticulo()
						+ "), " + oArticulo.getdPrecio() + " euros + iva\n";
				sInventario += "Cantidad en stock: " + lCantidades.get(iPosicion) + "\n";
				sInventario += "--------------------------------------------------\n";
				iPosicion++;
			}
		}
		return sInventario;
	}

	public Articulo[] obtenerArticulos() {
		Articulo[] aArticulo = new Articulo[this.lArticulos.size()];
		int iPosicion = 0;
		for (Articulo oArticulo : lArticulos) {
			aArticulo[iPosicion] = oArticulo;
			iPosicion++;
		}
		return aArticulo;
	}

	public void aniadirCliente(Cliente oCliente) {
		if (oCliente != null && !lClientes.contains(oCliente)) {
			lClientes.add(oCliente);
			oCliente.setoTienda(this);
			setiNumClientes();
		}
	}

	public boolean meterAlCarrito(Articulo oArticulo, Cliente oCliente) {
		boolean booExito = false;
		if (lArticulos.contains(oArticulo) && lCantidades.get(searchArticulo(oArticulo)) >= 1 && lClientes.contains(oCliente) ) {
			oCliente.meterAlCarrito(oArticulo);
			lCantidades.set(searchArticulo(oArticulo), (lCantidades.get(searchArticulo(oArticulo)) - 1));
			booExito = true;
		}
		return booExito;
	}

	public String venderCarrito(Cliente oCliente) {
		String sMensaje = "";
		double dTotal = 0;
		
		for (Articulo oArticulo : oCliente.getlCarrito()) {
			dTotal += oArticulo.getdPrecio();
		}
		if (lClientes.contains(oCliente) && dTotal <= oCliente.getdSaldo()) {
			for (Articulo oArticulo : oCliente.getlCarrito()) {
				sMensaje += "Articulo " + oArticulo.getsNombre() + " vendido al cliente " + oCliente.getsNombre() + ".\n";
				oCliente.aniadirAHistorial(oArticulo, Calendar.getInstance());
			}
			oCliente.limpiarElCarrito();
		}
		oCliente.setdSaldo(oCliente.getdSaldo() - dTotal);
		return sMensaje;
	}

	public boolean vender(Articulo oArticulo, Cliente oCliente) {
		boolean booExito = false;
		if (lArticulos.contains(oArticulo) && lCantidades.get(searchArticulo(oArticulo)) >= 1 && lClientes.contains(oCliente)) {
			lCantidades.set(searchArticulo(oArticulo), (lCantidades.get(searchArticulo(oArticulo)) - 1));
			oCliente.disminuirSaldo((lArticulos.get(searchArticulo(oArticulo)).getdPrecio()));
			oCliente.aniadirAHistorial(oArticulo, Calendar.getInstance());
			booExito = true;
		}
		return booExito;
	}
	
	public int searchArticulo(Articulo oArticulo) {
		int iPosicion = -1;
		int iContador = 0;
		while(iContador < this.getlArticulos().size() && iPosicion == -1) {
			if(this.getlArticulos().get(iContador).equals(oArticulo)) {
				iPosicion = iContador;
			}
			iContador++;
		}
		return iPosicion;
	}
}
