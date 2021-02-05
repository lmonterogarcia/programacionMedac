import java.util.Calendar;

public class Disco implements IPublicacion, IPrestable, IConsultable{
	private int iCodigo;
	private String sAutor;
	private String sTitulo;
	private short shAnnoPublicacion;
	private boolean booPrestado;
	private boolean booConsulta;
	private final String STIPO = "disco";
	
	public Disco(int iCodigo) {
		setiCodigo(iCodigo);
	}
	public Disco(int iCodigo,String sAutor, String sTitulo, short shAnnoPublicacion) {
		setiCodigo(iCodigo);
		setsAutor(sAutor);
		setsTitulo(sTitulo);
		setShAnnoPublicacion(shAnnoPublicacion);
		setBooPrestado(false);
		setBooConsulta(false);
	}
	
	public int getiCodigo() {
		return iCodigo;
	}
	public boolean setiCodigo(int iCodigo) {
		boolean booExito = false;
		if (iCodigo >= 300000 && iCodigo <= 399999) {
			this.iCodigo = iCodigo;
			booExito = true;
		}
		return booExito;
	}
	public String getsAutor() {
		return sAutor;
	}
	public boolean setsAutor(String sAutor) {
		boolean booExito = false;
		if (sAutor != null && sAutor.length()> 1 && sAutor.length() <= 255) {
			this.sAutor = sAutor;
			booExito = true;
		}
		return booExito;
	}
	public String getsTitulo() {
		return sTitulo;
	}
	public boolean setsTitulo(String sTitulo) {
		boolean booExito = false;
		if (sTitulo != null && sTitulo.length() <= 255) {
			this.sTitulo = sTitulo;
			booExito = true;
		}
		return booExito;
	}
	public short getShAnnoPublicacion() {
		return shAnnoPublicacion;
	}
	public boolean setShAnnoPublicacion(short shAnnoPublicacion) {
		boolean booExito = false;
		Calendar.getInstance();
		if (shAnnoPublicacion >= SHANNOMINPUBLIC && shAnnoPublicacion <= (short) (Calendar.getInstance()).get(Calendar.YEAR)) {
			this.shAnnoPublicacion = shAnnoPublicacion;
			booExito = true;
		}
		return booExito;
	}
	private boolean isBooPrestado() {
		return booPrestado;
	}
	private void setBooPrestado(boolean booPrestado) {
		this.booPrestado = booPrestado;
	}
	private boolean isBooConsulta() {
		return booConsulta;
	}
	private void setBooConsulta(boolean booConsulta) {
		this.booConsulta = booConsulta;
	}
	public String getSTIPO() {
		return STIPO;
	}
	
	public void prestar() {
		if (!estaPrestado() && !estaConsultando()) {
			setBooPrestado(true);
		}
	}
	public void devolverPrestamo() {
		if (estaPrestado() && !estaConsultando()) {
			setBooPrestado(false);
		}
	}
	public boolean estaPrestado() {
		return isBooPrestado();
	}
	
	public void retirar() {
		if (!estaPrestado() && !estaConsultando()) {
			setBooConsulta(true);
		}
	}
	public void devolverConsulta() {
		if (!estaPrestado() && estaConsultando()) {
			setBooConsulta(false);
		}
	}
	public boolean estaConsultando() {
		return isBooConsulta();
	}
	
	public String toString() {
		String sMensaje = "Datos del " + STIPO.toUpperCase();
		if (getiCodigo() >= 100000 && getiCodigo() <= 999999) {
			sMensaje +="\nCodigo: " + getiCodigo() + "\n";
		}
		if (getsAutor() != null) {
			sMensaje +="Autor: " + getsAutor() + "\n";
		}
		if (getsTitulo() != null) {
			sMensaje +="Titulo: " + getsTitulo() + "\n";
		}
		if (getShAnnoPublicacion() >= SHANNOMINPUBLIC) {
			sMensaje +="Anno de publicacion: " + getShAnnoPublicacion() + "\n";
		}
		if (estaPrestado()) {
			sMensaje +="Prestado: SI" + "\n";
		} else {
			sMensaje +="Prestado: NO" + "\n";
		}
		if (estaConsultando()) {
			sMensaje +="Consultado: SI" + "\n\n";
		} else {
			sMensaje +="Consultado: NO" + "\n\n";
		}
		return sMensaje;
	}
}
