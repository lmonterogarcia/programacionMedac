
public class Tarjeta {

	private String sId;
	private String sDniTitular;
	private int iPin;
	private float fSaldo;
	
	public Tarjeta(String sId, String sDniTitular, int iPin, float fSaldo) {
		setsId(sId);
		setsDniTitular(sDniTitular);
		setiPin(iPin);
		setfSaldo(fSaldo);
	}

	public String getsId() {
		return sId;
	}

	public boolean setsId(String sId) {
		boolean booExito = false;
		if (sId != null) {
			this.sId = sId;
			booExito = true;
		}
		return booExito;
	}

	public String getsDniTitular() {
		return sDniTitular;
	}

	public boolean setsDniTitular(String sDniTitular) {
		boolean booExito = false;
		if (sDniTitular != null) {
			this.sDniTitular = sDniTitular;
			booExito = true;
		}
		return booExito;
	}

	public int getiPin() {
		return iPin;
	}

	public void setiPin(int iPin) {
		this.iPin = iPin;
	}

	public float getfSaldo() {
		return fSaldo;
	}

	public boolean setfSaldo(float fSaldo) {
		boolean booExito = false;
		if (fSaldo >= 0) {
			this.fSaldo = fSaldo;
			booExito = true;
		}
		return booExito;
	}
	
	public void comprar(float fImporte, String sDni) {
		//RELLENAR
	}
	
	public void retirarCajero(float fImporte, int iPin) {
		//RELLENAR
	}
	
	private boolean cargo(float fImporte) {
		boolean booExito = false;
		if (booExito) {
			booExito = true;
		}
		return booExito;
	}
}
