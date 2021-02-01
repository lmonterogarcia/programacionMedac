public interface IAeronave {

	public final int IVOLANDO = 1;
	public final int IENTIERRA = 2;
    public void aumentarAlturaDeVuelo(int aumento);
    public void disminuirAlturaDeVuelo(int descenso);
    public int obtenerAlturaDeVuelo();
    public void variarAlturaDeVuelo(int altura);
    public void despegar();
    public void aterrizar();
    public String obtenerIdentificacion();
    public void establecerIdentificacion(String identificacion);
}
