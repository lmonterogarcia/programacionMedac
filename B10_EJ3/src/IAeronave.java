public interface IAeronave {

    public void aumentarAlturaDeVuelo(int aumento);
    public void disminuirAlturaDeVuelo(int descenso);
    public int obtenerAlturaDeVuelo();
    public void variarAlturaDeVuelo(int altura);
    public void despegar();
    public void aterrizar();
    public String obtenerIdentificacion();
    public void establecerIdentificacion(String identificacion);
}
