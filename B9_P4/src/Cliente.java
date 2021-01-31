import java.util.*;

public class Cliente {

	private int iIdCliente; // PK
	private String sNombre; // NN
	private double dSaldo; // NN
	private List<Articulo> lHistorialArticulos; // N
	private List<Calendar> lHistorialFechas; // N
	private List<Articulo> lCarrito; // N
	private Tienda oTienda; // N
	private int iTamanioCarrito; // N
	private int iTamanioHistorial; // N

	/*
	 * ##################### ### Constructores ### #####################
	 */
	public Cliente(int iIdCliente) {
		setiIdCliente(iIdCliente);
	}

	public Cliente(int iIdCliente, String sNombre, double dSaldo) {
		setiIdCliente(iIdCliente);
		setsNombre(sNombre);
		setdSaldo(dSaldo);
		lHistorialArticulos = new ArrayList<Articulo>();
		lHistorialFechas = new ArrayList<Calendar>();
		lCarrito = new ArrayList<Articulo>();
	}

	public Cliente(int iIdCliente, String sNombre, double dSaldo, List<Articulo> lHistorialArticulos,
			List<Calendar> lHistorialFechas, List<Articulo> lCarrito, Tienda oTienda) {
		setiIdCliente(iIdCliente);
		setsNombre(sNombre);
		setdSaldo(dSaldo);
		lHistorialArticulos = new ArrayList<Articulo>();
		lHistorialFechas = new ArrayList<Calendar>();
		lCarrito = new ArrayList<Articulo>();
		setoTienda(oTienda);
		setiTamanioCarrito();
		setiTamanioHistorial();
	}

	/*
	 * ################### ### Get and Set ### ###################
	 */
	public int getiIdCliente() {
		return iIdCliente;
	}

	public boolean setiIdCliente(int iIdCliente) {
		boolean booExito = false;
		if (iIdCliente >= 0 && iIdCliente < Integer.MAX_VALUE) {
			this.iIdCliente = iIdCliente;
			booExito = true;
		}
		return booExito;
	}

	public String getsNombre() {
		return sNombre;
	}

	public boolean setsNombre(String sNombre) {
		boolean booExito = false;
		if (sNombre != null && sNombre.length() > 2) {
			this.sNombre = sNombre;
			booExito = true;
		}
		return booExito;

	}

	public double getdSaldo() {
		return dSaldo;
	}

	public boolean setdSaldo(double dSaldo) {
		boolean booExito = false;
		if (dSaldo >= 0 && dSaldo < Double.MAX_VALUE) {
			this.dSaldo = dSaldo;
			booExito = true;
		}
		return booExito;

	}

	public List<Articulo> getlHistorialArticulos() {
		return lHistorialArticulos;
	}

	public void setlHistorialArticulos(List<Articulo> lHistorialArticulos) {
		this.lHistorialArticulos = lHistorialArticulos;
	}

	public List<Calendar> getlHistorialFechas() {
		return lHistorialFechas;
	}

	public void setlHistorialFechas(List<Calendar> lHistorialFechas) {
		this.lHistorialFechas = lHistorialFechas;
	}

	public List<Articulo> getlCarrito() {
		return lCarrito;
	}

	public void setlCarrito(List<Articulo> lCarrito) {
		this.lCarrito = lCarrito;
	}

	public Tienda getoTienda() {
		return oTienda;
	}

	public void setoTienda(Tienda oTienda) {
		this.oTienda = oTienda;
	}

	public int getiTamanioCarrito() {
		return iTamanioCarrito;
	}

	public void setiTamanioCarrito() {
		this.iTamanioCarrito = lCarrito.size();
	}

	public int getiTamanioHistorial() {
		return iTamanioHistorial;
	}

	public void setiTamanioHistorial() {
		this.iTamanioHistorial = lHistorialArticulos.size();
	}

	/*
	 * ############### ### METODOS ### ###############
	 */
	public void aumentarSaldo(double dSaldo) {
		this.dSaldo += dSaldo;
	}

	public void disminuirSaldo(double dSaldo) {
		this.dSaldo -= dSaldo;
	}

	public void meterAlCarrito(Articulo oArticulo) {

	}

	public void aniadirAHistorial(Articulo oArticulo, Calendar oFecha) {

	}

	public String mostrarCarrito() {
		String sMensaje = "";
		return sMensaje;
	}

	public String mostrarHistorial() {
		String sMensaje = "";
		return sMensaje;
	}

	public String mostrarSaldo() {
		String sMensaje = "Saldo actual de de " + getsNombre() + ": " + getdSaldo();
		return sMensaje;
	}
}
