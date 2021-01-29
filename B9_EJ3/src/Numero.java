
public class Numero {
	private double dNumero;
	private double prueba;

	public Numero(double dNumero) {
		setdNumero(dNumero);
	}
	public Numero(float fNumero) {
		setdNumero(fNumero);
	}
	
	public Numero(long lNumero) {
		setdNumero(lNumero);
	}
	
	public Numero(int iNumero) {
		setdNumero(iNumero);
	}
	
	public double getdNumero() {
		return dNumero;
	}

	public void setdNumero(double dNumero) {
		this.dNumero = dNumero;
	}
	public void setdNumero(float fNumero) {
		this.dNumero = fNumero;
		this.dNumero = (float)dNumero;
	}
	public void setdNumero(long lNumero) {
		this.dNumero = lNumero;
		this.dNumero = (long)dNumero;
	}
	public void setdNumero(int iNumero) {
		this.dNumero = iNumero;
		this.dNumero = (int)dNumero;
	}

	//instance of 
	
}

