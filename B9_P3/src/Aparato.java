
public class Aparato {

	private boolean booInterruptor;

	public Aparato() {
		setBooInterruptor(false);
	}
	
	public boolean isBooInterruptor() {
		return booInterruptor;
	}

	public void setBooInterruptor(boolean booInterruptor) {
		this.booInterruptor = booInterruptor;
	}
	
	public void cambiarInterruptor() {
		if (booInterruptor) {
			setBooInterruptor(false);
		} else {
			setBooInterruptor(true);
		}
	}
	
	public boolean estaEncendido(boolean booCasa) {
		boolean booEncendio = false;
		if (booCasa && isBooInterruptor()) {
			booEncendio = true;
		}
		return booEncendio;
	}
}
