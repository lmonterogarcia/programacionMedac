
public class AireAcondicionado {
	
	private short shNumeroSerie; // PK
	private boolean booEncendido; // NN
	private float fTemperaturaActual; // NN
	private float fTemperaturaDeseada; // NN
	
	private final byte FTEMPERATURAMAX = 30;
	private final byte FTEMPERATURAMIN = 15;
	private final byte FTEMPERATURAMINIMAREAL = -90;
	private final byte FTEMPERATURAMAXIMAREAL = 60;

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
	
	public AireAcondicionado(short shNumeroSerie, float fTemperaturaDeseada, float fTemperaturaActual) {
		setShNumeroSerie(shNumeroSerie);
		setfTemperaturaDeseada(fTemperaturaDeseada);
		setfTemperaturaActual(fTemperaturaActual);
		setBooEncendido(false);
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

	public boolean setfTemperaturaActual(float fTemperaturaActual) {
		boolean booEstadoAire = this.booEncendido, booExito = true;
		this.booEncendido = false;
		if (fTemperaturaActual > FTEMPERATURAMAXIMAREAL) {
			booExito = false;
			this.fTemperaturaActual = FTEMPERATURAMAXIMAREAL;
		} else if (fTemperaturaActual < FTEMPERATURAMINIMAREAL) {
			booExito = false;
			this.fTemperaturaActual = FTEMPERATURAMINIMAREAL;
		} else {
			this.fTemperaturaActual = fTemperaturaActual;
		}
		
		this.booEncendido = booEstadoAire;
		return booExito;
	}

	public float getfTemperaturaDeseada() {
		return fTemperaturaDeseada;
	}

	public boolean setfTemperaturaDeseada(float fTemperaturaDeseada) {
		boolean booEstadoAire = this.booEncendido, booExito = true;
		this.booEncendido = false;
		if (fTemperaturaDeseada < FTEMPERATURAMIN) {
			booExito = false;
			this.fTemperaturaDeseada = FTEMPERATURAMIN;
		} else if (fTemperaturaDeseada > FTEMPERATURAMAX) {
			booExito = false;
			this.fTemperaturaDeseada = FTEMPERATURAMAX;
		} else {
			this.fTemperaturaDeseada = fTemperaturaDeseada;
		}

		this.booEncendido = booEstadoAire;
		return booExito;
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
