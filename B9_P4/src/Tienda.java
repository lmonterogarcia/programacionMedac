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
		// Para no estar todo el rato introduciendo datos se ha llenado el Almacen con arrays.
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
		Articulo oArticulo5 = new Articulo(5, "Cintoc", 99);
		lArticulos.add(oArticulo5);
		
		lCantidades = Arrays.asList(12,9,10,15,4,1);
		setiNumArticulos();
	}

	public String mostrarInventario() {
		String sInventario = "";
		int iPosicion = 0;
		if (getiNumArticulos() > 0) {
			sInventario += "Mostrando inventario de la tienda:\n------------------------------------------------------------\n";
			for (Articulo oArticulo : lArticulos) {
				sInventario += "[ " + iPosicion + "] Articulo: " + oArticulo.getsNombre() + " (ref. " + iPosicion + "), " + oArticulo.getdPrecio() + " euros + iva\n";
				sInventario += "Cantidad en stock: " + lCantidades.get(iPosicion) + "\n";
				sInventario += "------------------------------------------------------------\n";
				iPosicion++;
			}
		}
		return sInventario;
	}

	public Articulo[] obtenerArticulos() {
		Articulo[] oArticulo = new Articulo[21];
		return oArticulo;
	}

	public void aniadirCliente(Cliente oCliente) {
		
	}

	public void meterAlCarrito(Articulo oArticulo, Cliente oCliente) {

	}

	public void venderCarrito(Cliente oCliente) {

	}

	public void vender(Articulo oArticulo, Cliente oCliente) {

	}
}
