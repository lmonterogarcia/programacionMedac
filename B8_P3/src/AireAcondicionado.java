
public class AireAcondicionado {
	private short shNumeroSerie; // PK
	private boolean booEncendido; // NN
	private float fTemperaturaActual; // NN
	private float fTemperaturaDeseada; // NN
	private final float FTEMPERATURAMAX = 30f;
	private final float FTEMPERATURAMIN = 15f;
	private final float FTEMPERATURAMINIMAREAL = -90f;
	private final float FTEMPERATURAMAXIMAREAL = 60f;

	public AireAcondicionado(short shNumeroSerie) {
		setShNumeroSerie(shNumeroSerie);
	}

	public AireAcondicionado(short shNumeroSerie, float fTemperaturaDeseada, float fTemperaturaActual,
			boolean booEncendido) {
		setShNumeroSerie(shNumeroSerie);
		setfTemperaturaDeseada(fTemperaturaDeseada);
		setfTemperaturaActual(fTemperaturaActual);
		setBooEncendido(booEncendido);
	}

	public short getShNumeroSerie() {
		return shNumeroSerie;
	}

	public void setShNumeroSerie(short shNumeroSerie) {
		if (shNumeroSerie > 10000 && shNumeroSerie < 30000) {
			this.shNumeroSerie = shNumeroSerie;
		}
	}

	public boolean isBooEncendido() {
		return booEncendido;
	}

	public void setBooEncendido(boolean booEncendido) {
		if ((this.fTemperaturaDeseada >= FTEMPERATURAMIN && this.fTemperaturaDeseada <= FTEMPERATURAMAX)
				&& (this.fTemperaturaActual <= FTEMPERATURAMAXIMAREAL
						&& this.fTemperaturaActual >= FTEMPERATURAMINIMAREAL)) {
			this.booEncendido = booEncendido;
		}

		if (this.booEncendido) {
			activar();
		}

	}

	public float getfTemperaturaActual() {
		return fTemperaturaActual;
	}

	public void setfTemperaturaActual(float fTemperaturaActual) {
		boolean booEstadoAire = this.booEncendido;
		this.booEncendido = false;
		if (fTemperaturaActual > FTEMPERATURAMAXIMAREAL) {
			System.out.println(
					"No estas tan cerca del SOL, temperatura seteada al maximo registrado en el planeta TIERRA.");
			this.fTemperaturaActual = FTEMPERATURAMAXIMAREAL;
		} else if (fTemperaturaActual < FTEMPERATURAMINIMAREAL) {
			System.out.println(
					"¿Te crees que estas en Pluton?, temperatura seteada al minimo registrado en el planeta TIERRA.");
			this.fTemperaturaActual = FTEMPERATURAMINIMAREAL;
		} else {
			this.fTemperaturaActual = fTemperaturaActual;
		}

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
			System.out.println("La temperatura se ha seteado a minimo permitido.");
			this.fTemperaturaDeseada = FTEMPERATURAMIN;
		} else if (fTemperaturaDeseada > FTEMPERATURAMAX) {
			System.out.println("La temperatura se ha seteado a maximo permitido.");
			this.fTemperaturaDeseada = FTEMPERATURAMAX;
		} else {
			this.fTemperaturaDeseada = fTemperaturaDeseada;
		}
		System.out.println("Temperatura seteada a " + this.fTemperaturaDeseada + "\n");
		this.booEncendido = booEstadoAire;
	}

	public void activar() {
		System.out.println("Control automatico de la maquina programado.");
		if (getfTemperaturaDeseada() > getfTemperaturaActual()) {
			System.out.println("Maquina activada.\n");
			if (!isBooEncendido()) {
				this.booEncendido = true;
			}
			while (isBooEncendido()) {
				if (getfTemperaturaDeseada() <= getfTemperaturaActual()) {
					desactivar();
				} else {
					calentar();
				}

			}
		} else if (getfTemperaturaDeseada() < getfTemperaturaActual()) {
			System.out.println("Maquina activada.\n");
			if (!isBooEncendido()) {
				this.booEncendido = true;
			}
			while (isBooEncendido()) {
				if (getfTemperaturaDeseada() >= getfTemperaturaActual()) {
					desactivar();
				} else {
					enfriar();
				}

			}
		} else {
			System.out.println(
					"La temperatura de la habitacion es la misma que la deseada. No se va a encender el Aire Acondicionado.");
		}
	}

	public void desactivar() {
		setBooEncendido(false);
		System.out.println("Se ha llegado a la temperatura seteada.\n");
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
