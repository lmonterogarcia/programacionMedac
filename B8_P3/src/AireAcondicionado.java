
public class AireAcondicionado {

	private boolean booEncendido; // NN
	private float fTemperaturaActual; // NN
	private float fTemperaturaDeseada; // PK
	private final float FTEMPERATURAMAX = 30f;
	private final float FTEMPERATURAMIN = 15f;

	public AireAcondicionado(float fTemperaturaDeseada) {
		setfTemperaturaDeseada(fTemperaturaDeseada);
	}

	public AireAcondicionado(float fTemperaturaDeseada, float fTemperaturaActual, boolean booEncendido) {
		setfTemperaturaDeseada(fTemperaturaDeseada);
		setfTemperaturaActual(fTemperaturaActual);
		setBooEncendido(booEncendido);
	}

	public boolean isBooEncendido() {
		return booEncendido;
	}

	public void setBooEncendido(boolean booEncendido) {
		if ((this.fTemperaturaDeseada > FTEMPERATURAMIN && this.fTemperaturaDeseada < FTEMPERATURAMAX)
				&& (this.fTemperaturaActual > FTEMPERATURAMIN && this.fTemperaturaActual < FTEMPERATURAMAX)) {
			this.booEncendido = booEncendido;
		}

	}

	public float getfTemperaturaActual() {
		return fTemperaturaActual;
	}

	public void setfTemperaturaActual(float fTemperaturaActual) {
		boolean booEstadoAire = this.booEncendido;
		this.booEncendido = false;
		this.fTemperaturaActual = fTemperaturaActual;
		this.booEncendido = booEstadoAire;
	}

	public float getfTemperaturaDeseada() {
		return fTemperaturaDeseada;
	}

	public void setfTemperaturaDeseada(float fTemperaturaDeseada) {
		boolean booEstadoAire = this.booEncendido;
		this.booEncendido = false;
		if (fTemperaturaDeseada < FTEMPERATURAMIN) {
			this.fTemperaturaDeseada = FTEMPERATURAMIN;
		} else if (fTemperaturaDeseada > FTEMPERATURAMAX) {
			this.fTemperaturaDeseada = FTEMPERATURAMAX;
		} else {
			this.fTemperaturaDeseada = fTemperaturaDeseada;
		}
		
		this.booEncendido = booEstadoAire;
	}

	
	
}
