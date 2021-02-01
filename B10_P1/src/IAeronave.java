public interface IAeronave {

	public final String SVOLANDO = "Volando";
	public final String SENTIERRA = "En tierra";
	
    public void aumentarAlturaDeVuelo(int aumento);
    public void disminuirAlturaDeVuelo(int descenso);
    public int obtenerAlturaDeVuelo();
    public void variarAlturaDeVuelo(int altura);
    public void despegar();
    public void aterrizar();
    public String obtenerIdentificacion();
    public void establecerIdentificacion(String identificacion);
    
    public String consultarEstado(); //Solo se puede crear un metodo con un mismo nombre y sin
    
}
