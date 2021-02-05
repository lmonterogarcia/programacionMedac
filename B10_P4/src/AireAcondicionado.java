
public class AireAcondicionado implements IAireAcondicionado{
	private short shNumeroSerie; // PK
	private boolean booEncendido; // NN
	private float fTemperaturaActual; // NN
	private float fTemperaturaDeseada; // NN

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
		boolean booExito = true;
		if (!booEncendido) {
			if (fTemperaturaActual > FTEMPERATURAMAXIMAREAL) {
			booExito = false;
			this.fTemperaturaActual = FTEMPERATURAMAXIMAREAL;
		} else if (fTemperaturaActual < FTEMPERATURAMINIMAREAL) {
			booExito = false;
			this.fTemperaturaActual = FTEMPERATURAMINIMAREAL;
		} else {
			this.fTemperaturaActual = fTemperaturaActual;
		}
		} else {
			booExito = false;
		}
		
		
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

	public String activar() {
		String sAcciones = "";
		
		sAcciones += "\nControl automatico de la maquina programado.\n";
		if (getfTemperaturaDeseada() > getfTemperaturaActual()) {
			sAcciones += "Maquina activada.\n";
			if (!isBooEncendido()) {
				this.booEncendido = true;
			}
			while (isBooEncendido()) {
				if (getfTemperaturaDeseada() <= getfTemperaturaActual()) {
					sAcciones += desactivar();
				} else {
					sAcciones += calentar();
				}

			}
		} else if (getfTemperaturaDeseada() < getfTemperaturaActual()) {
			sAcciones += "Maquina activada.\n";
			if (!isBooEncendido()) {
				this.booEncendido = true;
			}
			while (isBooEncendido()) {
				if (getfTemperaturaDeseada() >= getfTemperaturaActual()) {
					sAcciones += desactivar();
				} else {
					sAcciones += enfriar();
				}

			}
		} else {
			sAcciones += 
					"La temperatura de la habitacion es la misma que la deseada. No se va a encender el Aire Acondicionado.";
		}
		
		return sAcciones;
	}

	public String desactivar() {
		String sAviso;
		setBooEncendido(false);
		sAviso = "\nSe ha llegado a la temperatura seteada.\n";
		return sAviso;
	}

	public String enfriar() {
		String sAviso;
		this.fTemperaturaActual -= 0.5;
		sAviso = "Temperatura de la habitacion " + this.fTemperaturaActual + "\n";
		return sAviso;
	}

	public String calentar() {
		String sAviso;
		this.fTemperaturaActual += 0.5;
		sAviso = "Temperatura de la habitacion " + this.fTemperaturaActual + "\n";
		return sAviso;
	}
}
