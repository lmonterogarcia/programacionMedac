
public class AparatoElectrico {

	private boolean booEncendido;
	private short shConsumo;
	
	public AparatoElectrico (short shConsumo) {
		setBooEncendido(false);
		setShConsumo(shConsumo);
	}
	
	public boolean isBooEncendido() {
		return booEncendido;
	}
	public void setBooEncendido(boolean booEncendido) {
		this.booEncendido = booEncendido;
	}
	public short getShConsumo() {
		return shConsumo;
	}
	public boolean setShConsumo(short shConsumo) {
		boolean booExito = false;
		if (shConsumo > 0) {
			this.shConsumo = shConsumo;
			booExito = true;
		} 
		return booExito;	
	}
	
}
