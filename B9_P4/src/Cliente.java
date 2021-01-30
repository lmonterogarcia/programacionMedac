import java.util.*;

public class Cliente {

	private int iIdCliente; //PK
	private String sNombre; //NN
	private double dSaldo;  //NN
	private List<Articulo> lHistorialArticulos; //N
	private List<Calendar> lHistorialFechas; //N
	private List<Articulo> lCarrito; //N
	private Tienda oTienda; //N
	private int iTamanioCarrito; //N
	private int iTamanioHistorial; //N
	
	
	public int getiIdCliente() {
		return iIdCliente;
	}
	public void setiIdCliente(int iIdCliente) {
		this.iIdCliente = iIdCliente;
	}
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public double getdSaldo() {
		return dSaldo;
	}
	public void setdSaldo(double dSaldo) {
		this.dSaldo = dSaldo;
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
	public void setiTamanioCarrito(int iTamanioCarrito) {
		this.iTamanioCarrito = iTamanioCarrito;
	}
	public int getiTamanioHistorial() {
		return iTamanioHistorial;
	}
	public void setiTamanioHistorial(int iTamanioHistorial) {
		this.iTamanioHistorial = iTamanioHistorial;
	}
	
	
	
}
