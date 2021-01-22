
public class ProgramadorBombillas {

	private byte bNumeroBombillas; //PK
	private Bombilla[] aBombillas; //NN
	
	public ProgramadorBombillas(byte bNumeroBombillas) {
		aBombillas =  new Bombilla[bNumeroBombillas];
		for (byte bContador = 0; bContador < aBombillas.length; bContador++) {
			aBombillas[bContador] = new Bombilla();
		}
	}
	
	public Bombilla[] getoBombillas() {
		return aBombillas;
	}
	public void setoBombillas(Bombilla[] oBombillas) {
		this.aBombillas = oBombillas;
	}
	public byte getbNumeroBombillas() {
		return bNumeroBombillas;
	}
	public void setbNumeroBombillas(byte bNumeroBombillas) {
		this.bNumeroBombillas = bNumeroBombillas;
	}
	
	/*
	 * ######## # CRUD # ########
	 */
	
	public String programa1() {
		String sMensaje = "";
		if (!checkBombillaApagada()) {
			apagarTodo();
		}
		sMensaje += "Programa 1\n-----------";
		for (byte bContador = 0; bContador < this.aBombillas.length; bContador++) {
			if (bContador % 2 == 0) {
				aBombillas[bContador].encender();
			} else {
				aBombillas[bContador].apagar();
			}
		}
		sMensaje += "\n" + toString();
		for (byte bContador = 0; bContador < this.aBombillas.length; bContador++) {
			aBombillas[bContador].cambiar();
		}
		sMensaje += "\n" +toString();
		sMensaje += "\n-----------";
		apagarTodo();
		
		return sMensaje;
	}
	
	public String programa2() {
		String sMensaje = "";
		
		if (!checkBombillaApagada()) {
			apagarTodo();
		}
		sMensaje += "Programa 2\n-----------";
		for (byte bContador = 0; bContador < this.aBombillas.length; bContador++) {
			if (bContador  != 0) {
				aBombillas[bContador - 1].apagar();
			} 
			aBombillas[bContador].encender();
			sMensaje += "\n" + toString();
		}
		sMensaje += "\n-----------";
		apagarTodo();
		
		return sMensaje;
	}
	
	public String programa3() {
	String sMensaje = "";
		if (!checkBombillaApagada()) {
			apagarTodo();
		}
		sMensaje += "Programa 3\n-----------";
		for (byte bVeces = 0; bVeces < 2; bVeces++) {
			for (byte bContador = 0; bContador < this.aBombillas.length; bContador++) {
				aBombillas[bContador].cambiar();
				sMensaje += "\n" + toString();
			}
		}
		for (byte bVeces = 0; bVeces < 2; bVeces++) {
			for (byte bContador = (byte) (this.aBombillas.length - 1); bContador >=  0 ; bContador--) {
				aBombillas[bContador].cambiar();
				sMensaje += "\n" +toString();
			}
		}
		sMensaje += "\n-----------";
		return sMensaje;
	}
	
	public String toString() {
		String sMostrar = "";
		
		for (int bContador = 0; bContador < this.aBombillas.length; bContador++) {
			sMostrar += this.aBombillas[bContador].mostrar() + " ";
		}
		
		return sMostrar;
	}	
	
	public boolean checkBombillaApagada() {
		boolean booBombillaApagada = true;
		byte bContador = (byte) (this.aBombillas.length - 1);
		while (booBombillaApagada && bContador >= 0) {
			if (aBombillas[bContador].isBooEncendida() == true) {
				booBombillaApagada = false;
			}
			bContador--;
		}
		return booBombillaApagada;
	}
	
	private void apagarTodo() {
		for (byte bContador = 0; bContador < this.aBombillas.length; bContador++) {
			if (aBombillas[bContador].isBooEncendida()) {
				aBombillas[bContador].cambiar();
			}
		}
	}	 
	 
}
