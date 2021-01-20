
public class MaquinaExpendedora {

	private short shNumeroSerie; // PK
	private float fCreditoAcumuladoUsuario; // N
	private float fCreditoConsumidoUsuario; //N
	private float fCantidadDinero; // N
	private final float FCREDITOMAX = 2500;
	
	public MaquinaExpendedora(short shNumeroSerie) {
		setShNumeroSerie(shNumeroSerie);
	}
	
	public MaquinaExpendedora(short shNumeroSerie, float fCreditoAcumuladoUsuario, float fCreditoConsumidoUsuario, float fCantidadDinero) {
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
		if (fCreditoAcumuladoUsuario > 0 && fCreditoAcumuladoUsuario < FCREDITOMAX) {
			this.fCreditoAcumuladoUsuario = fCreditoAcumuladoUsuario;
		} else {
			this.fCreditoAcumuladoUsuario = 0;
		}
		
	}
	public float getfCreditoConsumidoUsuario() {
		return fCreditoConsumidoUsuario;
	}
	public void setfCreditoConsumidoUsuario(float fCreditoConsumidoUsuario) {
		if (fCreditoConsumidoUsuario > 0 && fCreditoConsumidoUsuario < FCREDITOMAX) {
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
	
	public void insertarMoneda(float fMoneda) {
		this.fCreditoAcumuladoUsuario += fMoneda;
		this.fCantidadDinero += fMoneda;
	}
	
	public void pedirProducto(float fPrecio) {
		this.fCreditoConsumidoUsuario += fPrecio;
		this.fCreditoAcumuladoUsuario -= fPrecio;
	}
	
	public String pedirDevolucion() {
		String sMensaje = "\nCredito devuelto: " + fCreditoAcumuladoUsuario;
	
		this.fCreditoAcumuladoUsuario = 0;
		setfCreditoAcumuladoUsuario(0f);
		
		
		this.fCreditoConsumidoUsuario = 0;
		
		return sMensaje;
	}
	
	public String creditoDisponible() {
		String sMensaje;
		
		sMensaje = "El credito disponible es "+getfCreditoAcumuladoUsuario();
		
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
		float fCredito = this.fCreditoAcumuladoUsuario, fcreditoRestante;
		String sMensaje = "";
		final byte BMONEDA2E = 2;
		final byte BMONEDA1E = 1;
		final float FMONEDA50C = 0.5f;
		final float FMONEDA20C = 0.2f;
		final float FMONEDA10C = 0.1f;
		final float FMONEDA5C = 0.05f;
		final float FMONEDA2C = 0.02f;
		final float FMONEDA1C = 0.01f;
		
		if ((short)(fCredito / BMONEDA2E) > 0 ) {
			
		}
		
		return sMensaje;
	}
}
