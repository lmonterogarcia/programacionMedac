
public class MaquinaExpendedora {

	private short shNumeroSerie; // PK
	private float fCreditoAcumuladoUsuario; // N
	private float fCreditoConsumidoUsuario; //N
	private float fCreditoDisponible; // N
	private float fCantidadDinero; // N
	private final float FCREDITOMAX = 2500;
	
	public MaquinaExpendedora(short shNumeroSerie) {
		setShNumeroSerie(shNumeroSerie);
	}
	
	public MaquinaExpendedora(short shNumeroSerie, float fCreditoAcumuladoUsuario, float fCreditoConsumidoUsuario, float fCreditoDisponible, float fCantidadDinero) {
		setShNumeroSerie(shNumeroSerie);
		setfCreditoAcumuladoUsuario(fCreditoAcumuladoUsuario);
		setfCreditoConsumidoUsuario(fCreditoConsumidoUsuario);
		setfCreditoDisponible(fCreditoDisponible);
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
	public float getfCreditoDisponible() {
		return fCreditoDisponible;
	}
	public void setfCreditoDisponible(float fCreditoDisponible) {
		this.fCreditoDisponible = fCreditoDisponible;
	}
	public float getfCantidadDinero() {
		return fCantidadDinero;
	}
	public void setfCantidadDinero(float fCantidadDinero) {
		this.fCantidadDinero = fCantidadDinero;
	}
	
}
