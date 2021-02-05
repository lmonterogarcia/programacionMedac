
public interface IProdcuto {

	public final float PRECIO_MAXIMO = 1000000;
	
	public String getsNombre();
	public void setsNombre(String sNombre);
	public float getfPrecio();
	public void setfPrecio(float fPrecio);
	public int getiUnidades();
	public void setiUnidades(int iUnidades);
	public float valorEnStock();
	public void incrementarStock(int incremento);
	public void disminuirStock(int decremento);
}
