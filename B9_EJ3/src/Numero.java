

public class Numero {
	private double dNumero;
  
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
	public double getfNumero() {
		float fNumero = (float) dNumero;
		return fNumero;
	}
	public double getlNumero() {
		long lNumero = (long) dNumero;
		return lNumero;
	}
	public double getiNumero() {
		int iNumero = (int) dNumero;
		return iNumero;
	}

	public void setdNumero(double dNumero) {
		this.dNumero = dNumero;
	}
	public void setdNumero(float fNumero) {
		this.dNumero = fNumero;
	}
	public void setdNumero(long lNumero) {
		this.dNumero = lNumero;
	}
	public void setdNumero(int iNumero) {
		this.dNumero = iNumero;
	}

	public void sumar(double dNumero) {
		this.dNumero = this.dNumero + dNumero;
	}
	public void sumar(float fNumero) {
		this.dNumero = this.dNumero + fNumero;
	}
	public void sumar(long lNumero) {
		this.dNumero = this.dNumero + lNumero;
	}
	public void sumar(int iNumero) {
		this.dNumero = this.dNumero + iNumero;
	}
	
	public void restar(double dNumero) {
		this.dNumero = this.dNumero - dNumero;
	}
	public void restar(float fNumero) {
		this.dNumero = this.dNumero - fNumero;
	}
	public void restar(long lNumero) {
		this.dNumero = this.dNumero - lNumero;
	}
	public void restar(int iNumero) {
		this.dNumero = this.dNumero - iNumero;
	}
	
	public void multiplicar(double dNumero) {
		this.dNumero = this.dNumero * dNumero;
	}
	public void multiplicar(float fNumero) {
		this.dNumero = this.dNumero * fNumero;
	}
	public void multiplicar(long lNumero) {
		this.dNumero = this.dNumero * lNumero;
	}
	public void multiplicar(int iNumero) {
		this.dNumero = this.dNumero * iNumero;
	}
	
	public void dividir(double dNumero) {
		this.dNumero = this.dNumero / dNumero;
	}
	public void dividir(float fNumero) {
		this.dNumero = this.dNumero / fNumero;
	}
	public void dividir(long lNumero) {
		this.dNumero = this.dNumero / lNumero;
	}
	public void dividir(int iNumero) {
		this.dNumero = this.dNumero / iNumero;
	}

	public String toString() {
		String sResultado = "";
		if (this.dNumero % 1 == 0) {
			if (this.dNumero < Integer.MAX_VALUE && this.dNumero > Integer.MIN_VALUE) {
				sResultado += (int) getiNumero();
			} else {
				sResultado += (long) getlNumero();
			}
		} else {
			if (this.dNumero <Float.MAX_VALUE && this.dNumero > Float.MIN_VALUE) {
				sResultado += (float) getfNumero();
			} else {
				sResultado += getdNumero();
			}
		}
		return sResultado;
	}
	
	
	//instance of 
	
}

