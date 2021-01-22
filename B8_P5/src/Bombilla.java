
public class Bombilla {

	private boolean booEncendida;

	public Bombilla(){
		this.booEncendida = false;
	}
	
	public Bombilla(boolean booEncendida) {
		setBooEncendida(booEncendida);
	}
	
	public boolean isBooEncendida() {
		return booEncendida;
	}

	public void setBooEncendida(boolean booEncendida) {
		this.booEncendida = booEncendida;
	}
	
	public void encender() {
		setBooEncendida(true);
	}
	
	public void apagar() {
		setBooEncendida(false);
	}
	
	public void cambiar() {
		if (isBooEncendida()) {
			setBooEncendida(false);
		} else {
			setBooEncendida(true);
		}
	}
	
	public String mostrar() {
		String sBombilla = "·";
		if (this.booEncendida) {
			sBombilla = "*"; 
		}
		return sBombilla;
	}
}
