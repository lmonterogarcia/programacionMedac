import java.util.Calendar;

public class Revista implements IPublicacion,IConsultable{
	private int iCodigo;
	private String sAutor;
	private String sTitulo;
	private short shAnnoPublicacion;
	private boolean booConsulta;
	private final String STIPO = "revista";
	
	public Revista(int iCodigo) {
		setiCodigo(iCodigo);
	}
	public Revista(int iCodigo,String sAutor, String sTitulo, short shAnnoPublicacion) {
		setiCodigo(iCodigo);
		setsAutor(sAutor);
		setsTitulo(sTitulo);
		setShAnnoPublicacion(shAnnoPublicacion);
		setBooConsulta(false);
	}
	
	public int getiCodigo() {
		return iCodigo;
	}
	public boolean setiCodigo(int iCodigo) {
		boolean booExito = false;
		if (iCodigo >= 200000 && iCodigo <= 299999) {
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
		if (sAutor != null && sAutor.length() <= 255) {
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
		if (sTitulo != null && sAutor.length()> 1 && sTitulo.length() <= 255) {
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
	private boolean isBooConsulta() {
		return booConsulta;
	}
	private void setBooConsulta(boolean booConsulta) {
		this.booConsulta = booConsulta;
	}
	public String getSTIPO() {
		return STIPO;
	}
	
	public void retirar() {
		if (!estaConsultando()) {
			setBooConsulta(true);
		}
	}
	public void devolverConsulta() {
		if (estaConsultando()) {
			setBooConsulta(false);
		}
	}
	public boolean estaConsultando() {
		return isBooConsulta();
	}
	
	public String toString() {
		String sMensaje = "Datos de la " + STIPO.toUpperCase();
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
		if (estaConsultando()) {
			sMensaje +="Consultando: SI" + "\n\n";
		} else {
			sMensaje +="Consultando: NO" + "\n\n";
		}
		return sMensaje;
	}
}
