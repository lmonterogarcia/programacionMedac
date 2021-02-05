
public interface IPunto {

	public void borrar();
	public void mover(double dX, double dY);
	public void mover(Punto oPunto);
	public double distanciaEuclidiana(Punto oPunto);
}
