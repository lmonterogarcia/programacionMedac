
public interface IAireAcondicionado {

	public final byte FTEMPERATURAMAX = 30;
	public final byte FTEMPERATURAMIN = 15;
	public final byte FTEMPERATURAMINIMAREAL = -90;
	public final byte FTEMPERATURAMAXIMAREAL = 60;
	
	public String activar();
	public String desactivar();
	public String enfriar();
	public String calentar();
}
