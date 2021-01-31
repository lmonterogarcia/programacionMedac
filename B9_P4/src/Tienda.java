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
	}

	public Tienda(int iIdTienda, List<Articulo> lArticulos, List<Integer> lCantidades, List<Cliente> lClientes,
			int iNumArticulos, int iNumClientes) {
		setiIdTienda(iIdTienda);
		lArticulos = new ArrayList<Articulo>();
		lCantidades = new ArrayList<Integer>();
		lClientes = new ArrayList<Cliente>();
		setiNumArticulos(iNumArticulos);
		setiNumClientes(iNumClientes);
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

	public void setiNumArticulos(int iNumArticulos) {
		this.iNumArticulos = iNumArticulos;
	}

	public int getiNumClientes() {
		return iNumClientes;
	}

	public void setiNumClientes(int iNumClientes) {
		this.iNumClientes = iNumClientes;
	}

	/*
	 * ############### ### METODOS ### ###############
	 */

	public void llenarAlmacen() {

	}

	public void mostrarInventario() {

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
