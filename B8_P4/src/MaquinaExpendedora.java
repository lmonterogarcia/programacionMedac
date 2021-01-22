
public class MaquinaExpendedora {

	private short shNumeroSerie; // PK
	private float fCreditoAcumuladoUsuario; // N
	private float fCreditoConsumidoUsuario; // N
	private float fCantidadDinero; // N
	private float[] aMonedasParaCambio; // N
	private float[] aMonedasUsuario; // N
	
	private final short SHCREDITOMAX = 2500;
	private final byte BMONEDA2E = 2;
	private final byte BMONEDA1E = 1;
	private final float FMONEDA50C = 0.5f;
	private final float FMONEDA20C = 0.2f;
	private final float FMONEDA10C = 0.1f;
	private final float FMONEDA5C = 0.05f;
	private final float FMONEDA2C = 0.02f;
	private final float FMONEDA1C = 0.01f;

	public MaquinaExpendedora(short shNumeroSerie) {
		setShNumeroSerie(shNumeroSerie);
	}

	public MaquinaExpendedora(short shNumeroSerie, float fCreditoAcumuladoUsuario, float fCreditoConsumidoUsuario,
			float fCantidadDinero) {
		setShNumeroSerie(shNumeroSerie);
		setfCreditoAcumuladoUsuario(fCreditoAcumuladoUsuario);
		setfCreditoConsumidoUsuario(fCreditoConsumidoUsuario);
		setfCantidadDinero(fCantidadDinero);
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

	public float[] getaMonedasParaCambio() {
		return aMonedasParaCambio;
	}

	public void setaMonedasParaCambio(float[] aMonedasParaCambio) {
		this.aMonedasParaCambio = aMonedasParaCambio;
	}

	public float[] getaMonedasUsuario() {
		return aMonedasUsuario;
	}

	public void setaMonedasUsuario(float[] aMonedasUsuario) {
		this.aMonedasUsuario = aMonedasUsuario;
	}

	public void insertarMoneda(float fMoneda) {
		this.fCreditoAcumuladoUsuario += fMoneda;
		this.fCantidadDinero += fMoneda;
	}

	public void pedirProducto(float fPrecio) {
		this.fCreditoConsumidoUsuario += fPrecio;
		this.fCreditoAcumuladoUsuario -= fPrecio;
	}
	
	

	public String pedirDevolucion() {
		String sMensaje = "\nCredito devuelto (" + this.fCreditoAcumuladoUsuario + "): " + calculoDevolucionMoneda();

		this.fCantidadDinero -= this.fCreditoAcumuladoUsuario;
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
		
//		final byte BMONEDA2E = 2;
//		final byte BMONEDA1E = 1;
//		final float FMONEDA50C = 0.5f;
//		final float FMONEDA20C = 0.2f;
//		final float FMONEDA10C = 0.1f;
//		final float FMONEDA5C = 0.05f;
//		final float FMONEDA2C = 0.02f;
//		final float FMONEDA1C = 0.01f;

		if ((short) (fCredito / BMONEDA2E) > 0) {
			sMensaje += "\n" + (short) (fCredito / BMONEDA2E) + " moneda de 2 euros";
			fCredito = fCredito % BMONEDA2E;
		}
		if ((byte) (fCredito / BMONEDA1E) > 0) {
			sMensaje += "\n" + (byte) (fCredito / BMONEDA1E) + " moneda de 1 euros";
			fCredito = fCredito % BMONEDA1E;
		}
		if ((byte) (fCredito / FMONEDA50C) > 0) {
			sMensaje += "\n" + (byte) (fCredito / FMONEDA50C) + " moneda de 50 centimos";
			fCredito = fCredito % FMONEDA50C;
		}
		if ((byte) (fCredito / FMONEDA20C) > 0) {
			sMensaje += "\n" + (byte) (fCredito / FMONEDA20C) + " moneda de 20 centimos";
			fCredito = fCredito % FMONEDA20C;
		}
		if ((byte) (fCredito / FMONEDA10C) > 0) {
			sMensaje += "\n" + (byte) (fCredito / FMONEDA10C) + " moneda de 10 centimos";
			fCredito = fCredito % FMONEDA10C;
		}
		if ((byte) (fCredito / FMONEDA5C) > 0) {
			sMensaje += "\n" + (byte) (fCredito / FMONEDA5C) + " moneda de 5 centimos";
			fCredito = fCredito % FMONEDA5C;
		}
		if ((byte) (fCredito / FMONEDA2C) > 0) {
			sMensaje += "\n" + (byte) (fCredito / FMONEDA2C) + " moneda de 2 centimos";
			fCredito = fCredito % FMONEDA2C;
		}
		if ((byte) (fCredito / FMONEDA1C) > 0) {
			sMensaje += "\n" + (byte) (fCredito / FMONEDA1C) + " moneda de 1 centimos";
			fCredito = fCredito % FMONEDA1C;
		}

		return sMensaje;
	}
}
