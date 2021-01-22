
public class MaquinaExpendedora {

	private short shNumeroSerie; // PK
	private float fCreditoAcumuladoUsuario; // N
	private float fCreditoConsumidoUsuario; // N
	private float fCantidadDinero; // N
	private short[] aMonedasParaCambio; // NN
	private short[] aMonedasUsuario; // N
	
	private final short SHCREDITOMAX = 100;
	private final byte BVALORPARACADAMONEDACAMBIO = 50;
	private final float[] AVALORESMONEDAS = {2f,1f,0.5f,0.2f,0.10f,0.05f,0.02f,0.01f};

	public MaquinaExpendedora(short shNumeroSerie) {
		setShNumeroSerie(shNumeroSerie);
		crearOrResetCambioMaquina();
		this.aMonedasUsuario = new short[AVALORESMONEDAS.length];
		
	}

	public MaquinaExpendedora(short shNumeroSerie, float fCreditoAcumuladoUsuario, float fCreditoConsumidoUsuario,
			float fCantidadDinero) {
		setShNumeroSerie(shNumeroSerie);
		setfCreditoAcumuladoUsuario(fCreditoAcumuladoUsuario);
		setfCreditoConsumidoUsuario(fCreditoConsumidoUsuario);
		setfCantidadDinero(fCantidadDinero);
		crearOrResetCambioMaquina();
		this.aMonedasUsuario = new short[AVALORESMONEDAS.length];
	}

	public short getShNumeroSerie() {
		return shNumeroSerie;
	}

	public void setShNumeroSerie(short shNumeroSerie) {

		if (shNumeroSerie > 10000 && shNumeroSerie < 31000) {
			this.shNumeroSerie = shNumeroSerie;
		} else {
			this.shNumeroSerie = -1;
		}

	}

	public float getfCreditoAcumuladoUsuario() {
		return fCreditoAcumuladoUsuario;
	}

	public void setfCreditoAcumuladoUsuario(float fCreditoAcumuladoUsuario) {
		if (fCreditoAcumuladoUsuario > 0 && fCreditoAcumuladoUsuario < SHCREDITOMAX) {
			this.fCreditoAcumuladoUsuario = fCreditoAcumuladoUsuario;
		} else {
			this.fCreditoAcumuladoUsuario = 0;
		}

	}

	public float getfCreditoConsumidoUsuario() {
		return fCreditoConsumidoUsuario;
	}

	public void setfCreditoConsumidoUsuario(float fCreditoConsumidoUsuario) {
		if (fCreditoConsumidoUsuario > 0 && fCreditoConsumidoUsuario < SHCREDITOMAX) {
			this.fCreditoConsumidoUsuario = fCreditoConsumidoUsuario;
		} else {
			this.fCreditoConsumidoUsuario = 0;
		}
	}

	public float getfCantidadDinero() {
		return fCantidadDinero;
	}

	public void setfCantidadDinero(float fCantidadDinero) {
		this.fCantidadDinero = fCantidadDinero;
	}

	public short[] getaMonedasParaCambio() {
		return aMonedasParaCambio;
	}

	public void setaMonedasParaCambio(short[] aMonedasParaCambio) {
		this.aMonedasParaCambio = aMonedasParaCambio;
	}

	public short[] getaMonedasUsuario() {
		return aMonedasUsuario;
	}

	public void setaMonedasUsuario(short[] aMonedasUsuario) {
		this.aMonedasUsuario = aMonedasUsuario;
	}

	public void crearOrResetCambioMaquina() {
		this.aMonedasParaCambio = new short[AVALORESMONEDAS.length];
		for (int bContador = 0; bContador < this.aMonedasParaCambio.length; bContador++) {
			this.aMonedasParaCambio[bContador] = (short) (BVALORPARACADAMONEDACAMBIO / this.AVALORESMONEDAS[bContador]);
		}
	}
	
	public boolean insertarMoneda(float fMoneda) {
		boolean bExito = false;
		byte bContador = 0;
		while (!bExito && bContador < this.aMonedasUsuario.length) {
			if (fMoneda == this.AVALORESMONEDAS[bContador]) {
				bExito = true;
			} else {
				bContador++;
			}
		}
		
		if (bExito) {
			this.fCreditoAcumuladoUsuario += fMoneda;
			aMonedasUsuario[bContador]++;
		}
		
		return bExito;
	}

	public float valorArrayMonedas(short[] aMonedas) {
		float fValor = 0;
		for (byte bContador = 0; bContador < aMonedas.length; bContador++) {
			if (aMonedas[bContador] != 0) {
				fValor += aMonedas[bContador] * this.AVALORESMONEDAS[bContador];
			}
		}
		return fValor;
	}
	
	public boolean pedirProducto(float fPrecio) {
		boolean booExito = true;
		if ((fPrecio <= valorArrayMonedas(aMonedasUsuario)) && (valorArrayMonedas(aMonedasParaCambio) >= (this.fCreditoAcumuladoUsuario - fPrecio))) {
			this.fCreditoConsumidoUsuario += fPrecio;
			this.fCantidadDinero += fPrecio;
			this.fCreditoAcumuladoUsuario -= fPrecio;
			ponerToCeroaMonedasUsuario(); //Pasa a la caja de recaudaccion.
			
		} else {
			booExito = false;
		}
		
		
		return booExito;
	}
	
	public void ponerToCeroaMonedasUsuario() {
		for (byte bContador = 0; bContador < this.aMonedasUsuario.length; bContador++) {
			if (this.aMonedasUsuario[bContador] != 0) {
				this.aMonedasUsuario[bContador] = 0;
			}
		}
	}
	

	public String pedirDevolucion() {
		String sMensaje = "\nCredito devuelto (" + this.fCreditoAcumuladoUsuario + "): " + calculoDevolucionMoneda();

		this.fCreditoAcumuladoUsuario = 0;
		this.fCreditoConsumidoUsuario = 0;

		return sMensaje;
	}

	public String creditoDisponible() {
		String sMensaje;

		sMensaje = "El credito disponible es " + getfCreditoAcumuladoUsuario();

		return sMensaje;
	}

	public String toString() {
		String sMensaje = "";

		sMensaje += "Maquina con numero de serie: " + getShNumeroSerie();
		sMensaje += "\nCredito acumulado: " + getfCreditoAcumuladoUsuario();
		sMensaje += "\nCredito Consumido: " + getfCreditoConsumidoUsuario();
		sMensaje += "\nDinero recaudado: " + getfCantidadDinero();

		return sMensaje;
	}

	public String calculoDevolucionMoneda() {
		float fCredito = this.fCreditoAcumuladoUsuario;
		String sMensaje = "";
		boolean booQuedadinero = true;
		byte bContador = 0;
		short shNumeroMonedas;
			if (haGastado()) {
				while (booQuedadinero && bContador < AVALORESMONEDAS.length) {
				if (fCredito > 0) {
					shNumeroMonedas = (short) (fCredito / AVALORESMONEDAS[bContador]);
					if (shNumeroMonedas > 0) {
						if (shNumeroMonedas > aMonedasParaCambio[bContador]) {
							sMensaje +="\n" + aMonedasParaCambio[bContador] + " monedas de " + AVALORESMONEDAS[bContador] + " euros.";
							aMonedasParaCambio[bContador] -= aMonedasParaCambio[bContador];
							fCredito = fCredito % AVALORESMONEDAS[bContador];
						} else {
							sMensaje +="\n" + shNumeroMonedas + " monedas de " + AVALORESMONEDAS[bContador] + " euros.";
							aMonedasParaCambio[bContador] -= shNumeroMonedas;
							fCredito = fCredito % AVALORESMONEDAS[bContador];
						}
						
					}
					bContador++;
				} else {
					booQuedadinero = false;
				}
			}
			} else {
				for (byte bcontador = 0; bcontador < aMonedasUsuario.length; bcontador++) {
					if (aMonedasUsuario[bContador] != 0) {
						sMensaje +="\n" + aMonedasUsuario[bContador] + " monedas de " + AVALORESMONEDAS[bContador] + " euros.";
						aMonedasUsuario[bContador] = 0;
					}
				}
			}
			

		return sMensaje;
	}
	
	public boolean hayCambio() {
		boolean booHayCambio = true;
		byte bContador = 0;
		
		while (booHayCambio && bContador < aMonedasParaCambio.length) {
			if (aMonedasParaCambio[bContador] == 0) {
				booHayCambio = false;
			}
		}
		
		return booHayCambio;
	}
	
	public boolean haGastado() {
		boolean booHaGastado = true;
		byte bContador = 0;
		
		while (booHaGastado && bContador < aMonedasUsuario.length) {
			if (aMonedasUsuario[bContador] != 0) {
				booHaGastado = false;
			} else {
				bContador++;
			}
		}
		return booHaGastado;
	}
	
}
