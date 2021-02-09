
public class ViajeroAbonado extends UsuarioMetro implements IViajeroAbonado {
	
	public ViajeroAbonado(int codigoViajero, String paradaInicial, String paradaFinal) {
		super(codigoViajero,paradaInicial,paradaFinal);
	}
	
	public String viajar() {
		return "Viajero "+this.getCodigoViajero()+": "+this.getParadaInicial()+" - "+this.getParadaFinal()+". Ha validado su abono de transportes.";
	}	
}
