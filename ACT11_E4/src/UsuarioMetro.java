public abstract class UsuarioMetro implements IUsuarioMetro {
	private int codigoViajero;
	private String paradaInicial;
	private String paradaFinal;

	public UsuarioMetro(int codigoViajero, String paradaInicial, String paradaFinal) {
		this.codigoViajero = codigoViajero;
		this.paradaInicial = paradaInicial;
		this.paradaFinal = paradaFinal;
	}

	public int getCodigoViajero() {
		return codigoViajero;
	}

	public void setCodigoViajero(int codigoViajero) {
		this.codigoViajero = codigoViajero;
	}

	public String getParadaFinal() {
		return paradaFinal;
	}

	public void setParadaFinal(String paradaFinal) {
		this.paradaFinal = paradaFinal;
	}

	public String getParadaInicial() {
		return paradaInicial;
	}

	public void setParadaInicial(String paradaInicial) {
		this.paradaInicial = paradaInicial;
	}
}