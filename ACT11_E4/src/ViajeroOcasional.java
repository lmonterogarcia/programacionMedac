
public class ViajeroOcasional extends UsuarioMetro implements IViajeroOcasional {
	
	public ViajeroOcasional(int codigoViajero, String paradaInicial, String paradaFinal) {
		super(codigoViajero,paradaInicial,paradaFinal);
	}
	
	public String viajar() {
		return "Viajero "+this.getCodigoViajero()+": "+this.getParadaInicial()+" - "+this.getParadaFinal()+". Ha validado su billete univiaje.";
	}	
}
