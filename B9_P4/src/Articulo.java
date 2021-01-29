
public class Articulo {

	private int iId; //PK
	private String sNombre; // NN
	private double dPrecio; // NN
	
	public Articulo(int iId) {
		getiId();
	}
	
	public Articulo(int iId, String sNombre, double dPrecio) {
		getiId();
		getsNombre();
		getdPrecio();
	}
	
	public int getiId() {
		return iId;
	}
	public boolean setiId(int iId) {
		boolean booExito = false;
		if (iId > 0 && iId < Integer.MAX_VALUE) {
			this.iId = iId;
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
