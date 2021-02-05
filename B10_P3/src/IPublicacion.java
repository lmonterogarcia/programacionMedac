import java.util.Calendar;

public interface IPublicacion {

	public int getIcodigo();
	public boolean setIcodigo(int iCodigo);
	public String getsAutor();
	public boolean setsAutor(String sAutor);
	public String getsTirulo();
	public boolean setsTirulo(String sTitulo);
	public short getShAnnoPublicacion();
	public boolean setShAnnoPublicacion(short shAnnoPublicacion);
	public boolean isBooPrestado();
	public void setBooPrestado(boolean booPrestado);
	
}
