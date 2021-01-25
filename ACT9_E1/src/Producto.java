
public class Producto {
	private final float PRECIO_MAXIMO = 1000000;
	private String sNombre;
	private float fPrecio;
	private int iUnidades;

	public Producto(String sNombre) {
		setsNombre(sNombre);
	}

	public Producto(String sNombre, float fPrecio, int iUnidades) {
		setsNombre(sNombre);
		setfPrecio(fPrecio);
		setiUnidades(iUnidades);
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public float getfPrecio() {
		return fPrecio;
	}

	public void setfPrecio(float fPrecio) {
		if (fPrecio > 0 && fPrecio < PRECIO_MAXIMO) {
			this.fPrecio = fPrecio;
		} else {
			this.fPrecio = 0;
		}

	}

	public int getiUnidades() {
		return iUnidades;
	}

	public void setiUnidades(int iUnidades) {
		if(iUnidades >= 0) {
			this.iUnidades = iUnidades;	
		}else {
			this.iUnidades = 0;
		}
		
	}

	public float valorEnStock() {
		return iUnidades * fPrecio;
	}

	public void incrementarStock(int incremento) {
		setiUnidades(this.getiUnidades() + incremento);
		// this.iUnidades = this.iUnidades + incremento;
	}

	public void disminuirStock(int decremento) {
		iUnidades = iUnidades - decremento;
	}
}
