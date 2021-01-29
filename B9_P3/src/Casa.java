import java.util.*;

public class Casa {

	private boolean booEncendia;
	private List<Aparato> lAparatos;

	public Casa() {
		setBooEncendia(false);
		lAparatos = new ArrayList<Aparato>();
	}
	
	public boolean isBooEncendia() {
		return booEncendia;
	}

	public void setBooEncendia(boolean booEncendia) {
		this.booEncendia = booEncendia;
	}

	public List<Aparato> getlAparato() {
		return lAparatos;
	}

	public void setlAparato(List<Aparato> lAparato) {
		this.lAparatos = lAparato;
	}
	
	// EMPECE ESTA CLASE PERO AL CONOCER QUE NO HACIA FALTA LA DEJE SIN TERMINAR. Solo con un booleando en el main ya vale.
	
}
