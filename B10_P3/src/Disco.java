import java.util.Calendar;

public class Disco implements IPublicacion{
	private int iCodigo;
	private String sAutor;
	private String sTitulo;
	private short shAnnoPublicacion;
	private boolean booPrestado;
	
	
	public int getIcodigo() {
		return iCodigo;
	}
	public boolean setIcodigo(int iCodigo) {
		boolean booExito = false;
		if (iCodigo >= 100000 && iCodigo <= 999999) {
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
	public String getsTirulo() {
		return sTitulo;
	}
	public boolean setsTirulo(String sTitulo) {
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
		if (shAnnoPublicacion >= 1440 && shAnnoPublicacion <= (short) Calendar.getInstance().YEAR) {
			this.shAnnoPublicacion = shAnnoPublicacion;
			booExito = true;
		}
		return booExito;
	}
	public boolean isBooPrestado() {
		return booPrestado;
	}
	public void setBooPrestado(boolean booPrestado) {
		this.booPrestado = booPrestado;
	}
}
