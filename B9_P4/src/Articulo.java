
public class Articulo {

	private int iIdArticulo; //PK
	private String sNombre; // NN
	private double dPrecio; // NN
	
	public Articulo(int iIdArticulo) {
		getiIdArticulo();
	}
	
	public Articulo(int iIdArticulo, String sNombre, double dPrecio) {
		getiIdArticulo();
		getsNombre();
		getdPrecio();
	}
	
	public int getiIdArticulo() {
		return iIdArticulo;
	}
	public boolean setiIdArticulo(int iIdArticulo) {
		boolean booExito = false;
		if (iIdArticulo > 0 && iIdArticulo < Integer.MAX_VALUE) {
			this.iIdArticulo = iIdArticulo;
			booExito = true;
		}
		return booExito;
	}
	public String getsNombre() {
		return sNombre;
	}
	public boolean setsNombre(String sNombre) {
		boolean booExito = false;
		if (sNombre != null && sNombre.length() > 5) {
			this.sNombre = sNombre;
			booExito = true;
		}
		return booExito;
	}
	public double getdPrecio() {
		
		return dPrecio;
	}
	public boolean setdPrecio(double dPrecio) {
		boolean booExito = false;
		if (dPrecio > 0 && dPrecio < Double.MAX_VALUE) {
			this.dPrecio = dPrecio;
			booExito = true;
		}
		return booExito;
		
	}
	
}
