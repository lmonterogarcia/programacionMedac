
public interface ITarjetaMonedero {

	public String getsId();
	public String getsDniTitular();
	public void setiPin(int iPin);
	public float getfSaldo();
	public void comprar(float fImporte, String sDni);
}
