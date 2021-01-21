
public class Semaforo {

	private byte bColor; //PK
	private boolean booParpadeando; // NN
	
	public byte getbColor() {
		return bColor;
	}
	public void setbColor(byte bColor) {

			switch (bColor) {
			case 0:
				if (getbColor() == 1 && !isBooParpadeando()) {
					this.bColor = bColor;
					imprimir();
				} else {
					System.out.println("\nAsigancion de color incorrecto.\nEl semaforo se queda en " + colorSemaforo());
				}
				break;
			case 1:
				if (getbColor() == 2 && !isBooParpadeando()) {
					this.bColor = bColor;
					setBooParpadeando(true);
				} else {
					System.out.println("\nAsigancion de color incorrecto.\nEl semaforo se queda en " + colorSemaforo());
				}
				break;
			default:
				if (getbColor() == 0 && !isBooParpadeando()) {
					this.bColor = bColor;
					imprimir();
				} else {
					System.out.println("\nAsigancion de color incorrecto.\nEl semaforo se queda en " + colorSemaforo());
				}
			}
	}
	public boolean isBooParpadeando() {
		return booParpadeando;
	}
	
	public void setBooParpadeando(boolean booParpadeando) {
		if (this.bColor == 1 && booParpadeando == true && this.booParpadeando == true) {
			System.out.println("\nEl semaforo ya esta en AMBAR PARPADEANDO");
		} else if (this.bColor == 1 && booParpadeando == true) {
			this.booParpadeando = booParpadeando;
			imprimir();
		} else if (this.bColor == 1 && booParpadeando == false) {
			this.booParpadeando = booParpadeando;
			imprimir();
		} else {
			System.out.println("\nAsigancion de parpadeo incorrecto.\nEl semaforo se queda en " + colorSemaforo());
		}
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
	
	public void imprimir() {
		System.out.println("\nSemaforo en " + colorSemaforo());
	}
	
	
	public void cambia() {
		switch (this.bColor) {
		case 0:
			this.bColor = 2;
			imprimir();
			break;
		case 1:
			if (isBooParpadeando()) {
				this.booParpadeando = false;
				imprimir();
			} else {
				this.bColor = 0;
				imprimir();
			}
			break;
		default:
			this.bColor = 1;
			this.booParpadeando = true;
			imprimir();
		}
	}
	
	public void copiaSemaforo(Semaforo oSemaforo) {
		this.bColor = oSemaforo.getbColor();
		this.booParpadeando = oSemaforo.isBooParpadeando();
	}
}
