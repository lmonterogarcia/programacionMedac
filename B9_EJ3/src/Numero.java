
public class Numero {
	private double dNumero;

	//instance of 
	public Numero(double dNumero) {
		setdNumero(dNumero);
	}
	public Numero(int iNumero) {
		double dNumero = iNumero;
		setdNumero(dNumero);
	}
	public Numero(long lNumero) {
		double dNumero = lNumero;
		setdNumero(dNumero);
	}
	public Numero(float fNumero) {
		double dNumero = fNumero;
		setdNumero(dNumero);
	}
	
	
	public double getdNumero() {
		return dNumero;
	}
	public void setdNumero(double dNumero) {
		this.dNumero = dNumero;
	}
	public int getiNumero() {
		return iNumero;
	}
	public void setiNumero(int iNumero) {
		this.iNumero = iNumero;
	}
	public long getlNumero() {
		return lNumero;
	}
	public void setlNumero(long lNumero) {
		this.lNumero = lNumero;
	}
	public float getfNumero() {
		return fNumero;
	}
	public void setfNumero(float fNumero) {
		this.fNumero = fNumero;
	}
	
	
}

