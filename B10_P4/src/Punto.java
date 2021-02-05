
public class Punto implements IPunto{
	private double dX;
	private double dY;

	public Punto() {
		this.dX = 0f;
		this.dY = 0f;
	}

	public Punto(double dX, double dY) {
		setdX(dX);
		setdY(dY);
	}

	/**
	 * @return the dX
	 */
	public double getdX() {
		return dX;
	}

	/**
	 * @param dX the dX to set
	 */
	public void setdX(double dX) {
		this.dX = dX;
	}

	/**
	 * @return the dY
	 */
	public double getdY() {
		return dY;
	}

	/**
	 * @param dY the dY to set
	 */
	public void setdY(double dY) {
		this.dY = dY;
	}

	public void borrar() {
		this.dX = 0f;
		this.dY = 0f;
	}

	public void mover(double dX, double dY) {
		setdX(dX);
		setdY(dY);
	}

	public void mover(Punto oPunto) {
		setdX(oPunto.getdX());
		setdY(oPunto.getdY());
	}

	public double distanciaEuclidiana(Punto oPunto) {
		double dDistancia;

		dDistancia = Math.sqrt(Math.pow((oPunto.getdX() - this.dX), 2) + Math.pow((oPunto.getdY() - this.dY), 2));

		return dDistancia;
	}

	public String toString() {
		String sMensaje;
		sMensaje = "(" + getdX() + " , " + getdY() + ")";
		return sMensaje;
	}
}
