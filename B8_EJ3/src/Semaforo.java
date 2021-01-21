
public class Semaforo {

	private byte bColor; //PK
	private boolean booParpadeando; // NN
	
	public byte getbColor() {
		return bColor;
	}
	public void setbColor(byte bColor) {
		if (bColor > 0 && bColor <= 2) {
			this.bColor = bColor;
		} else {
			this.bColor = -1;
		}
	}
	public boolean isBooParpadeando() {
		return booParpadeando;
	}
	
	public void setBooParpadeando(boolean booParpadeando) {
		if (this.bColor == 1 && booParpadeando == true) {
			this.booParpadeando = booParpadeando;
		} else {
			this.booParpadeando = false;
		}
	}
	
	public String colorSemaforo() {
		String sColorSemaforo;
		
		switch (this.bColor) {
		case -1:
			sColorSemaforo = "Error en el semaforo. Llame a un tecnico e informe a la policia.";
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
	
	public void imprimir() {
		System.out.println("Semaforo en " + colorSemaforo());
	}
	
	public void cambia() {
		switch (this.bColor) {
		case 0:
			setbColor((byte)2);
			break;
		case 1:
			if (isBooParpadeando()) {
				setBooParpadeando(false);
			} else {
				setbColor((byte)0);
			}
			break;
		default:
			setbColor((byte)1);
			setBooParpadeando(false);
		}
	}
}
