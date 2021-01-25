
public class Semaforo {
	private byte bColor; // PK
	private boolean booParpadeando; // NN
	private boolean booInicializado; // N

	public Semaforo() {
		setbColor((byte)1);
		setBooInicializado(true);

	}

	public Semaforo(byte bColor) {
		setbColor(bColor);
		setBooInicializado(true);
	}

	public byte getbColor() {
		return bColor;
	}

	public boolean setbColor(byte bColor) {
		boolean bExito = true;
		if (isBooInicializado()) {
			switch (bColor) {
			case 0:
				if (getbColor() == 1 && !isBooParpadeando()) {
					this.bColor = bColor;
				} else {
					bExito = false;
				}
				break;
			case 1:
				if (getbColor() == 2 && !isBooParpadeando()) {
					this.bColor = bColor;
					setBooParpadeando(true);
				} else {
					bExito = false;
				}
				break;
			default:
				if (getbColor() == 0 && !isBooParpadeando()) {
					this.bColor = bColor;
				} else {
					bExito = false;
				}
			}
		} else {
			this.bColor = bColor;
			if (bColor == 1) {
				this.booParpadeando = true;
				bExito = true;

			}
		}

		return bExito;
	}

	public boolean isBooParpadeando() {
		return booParpadeando;
	}

	public boolean setBooParpadeando(boolean booParpadeando) {
		boolean booExito = true;
		if (this.bColor == 1 && booParpadeando == true && this.booParpadeando == true) {
			booExito = false;
		} else if (this.bColor == 1 && booParpadeando == true) {
			this.booParpadeando = booParpadeando;
		} else if (this.bColor == 1 && booParpadeando == false) {
			this.booParpadeando = booParpadeando;
		} else {
			booExito = false;
		}
		return booExito;
	}

	public boolean isBooInicializado() {
		return booInicializado;
	}

	public void setBooInicializado(boolean booInicializado) {
		this.booInicializado = true;
	}

	public String colorSemaforo() {
		String sColorSemaforo;

		switch (this.bColor) {
		case -1:
			sColorSemaforo = "\nError en el semaforo. Llame a un tecnico e informe a la policia.";
			break;
		case 0:
			sColorSemaforo = "ROJO";
			break;
		case 1:
			if (isBooParpadeando()) {
				sColorSemaforo = "AMBAR PARPADEANDO";
			} else {
				sColorSemaforo = "AMBAR";
			}
			break;
		default:
			sColorSemaforo = "VERDE";
		}
		return sColorSemaforo;
	}

	public String toString() {
		return "\nSemaforo en " + colorSemaforo();
	}

	public void cambia() {
		switch (this.bColor) {
		case 0:
			this.bColor = 2;
			break;
		case 1:
			if (isBooParpadeando()) {
				this.booParpadeando = false;
				;
			} else {
				this.bColor = 0;
				;
			}
			break;
		default:
			this.bColor = 1;
			this.booParpadeando = true;
		}
	}

	public void copiaSemaforo(Semaforo oSemaforo) {
		this.bColor = oSemaforo.getbColor();
		this.booParpadeando = oSemaforo.isBooParpadeando();
	}
}
