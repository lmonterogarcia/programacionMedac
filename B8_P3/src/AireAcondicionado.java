
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
		if (this.fTemperaturaDeseada >= FTEMPERATURAMIN && this.fTemperaturaDeseada <= FTEMPERATURAMAX) {
			this.booEncendido = booEncendido;
		}

		if (this.booEncendido) {
			System.out.println("Aire acondicionado encendido\n");
		} else {
			System.out.println("Aire acondicionado apagado\n");
		}

	}

	public float getfTemperaturaActual() {
		return fTemperaturaActual;
	}

	public void setfTemperaturaActual(float fTemperaturaActual) {
		boolean booEstadoAire = this.booEncendido;
		this.booEncendido = false;
		this.fTemperaturaActual = fTemperaturaActual;
		System.out.println("Temperatura de la habitacion " + this.fTemperaturaActual + "\n");
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
		System.out.println("Temperatura seteada a " + this.fTemperaturaDeseada + "\n");
		this.booEncendido = booEstadoAire;
	}

	public void activar() {
		System.out.println("\nControl automatico de la maquina programado.");
		if (getfTemperaturaDeseada() > getfTemperaturaActual()) {
			setBooEncendido(true);
			while (isBooEncendido()) {
				if (getfTemperaturaDeseada() <= getfTemperaturaActual()) {
					desactivar();
				} else {
					calentar();
				}

			}
		} else if (getfTemperaturaDeseada() < getfTemperaturaActual()) {
			setBooEncendido(true);
			while (isBooEncendido()) {
				if (getfTemperaturaDeseada() >= getfTemperaturaActual()) {
					desactivar();
				} else {
					enfriar();
				}

			}
		} else {
			System.out.println("La temperatura de la habitacion es la misma que la deseada. No se va a encender el Aire Acondicionado.");
		}
	}

	public void desactivar() {
		setBooEncendido(false);
		System.out.println("Se ha llegado a la temperatura seteada.");
	}

	private void enfriar() {
		this.fTemperaturaActual -= 0.5;
		System.out.println("Temperatura de la habitacion " + this.fTemperaturaActual + "\n");
	}

	private void calentar() {
		this.fTemperaturaActual += 0.5;
		System.out.println("Temperatura de la habitacion " + this.fTemperaturaActual + "\n");
	}

}
