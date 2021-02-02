
public class Satelite implements ITelefono{

	private int iNumTel;
	private boolean boollamando;
	private boolean booAltavozActivo;
	private byte bCobertura;
	private byte bSatelites;
	
	
	public int getiNumTel() {
		return iNumTel;
	}
	public boolean setiNumTel(int iNumTel) {
		boolean booExito = false;
		if (iNumTel > 600000000 && iNumTel < 799999999) {
			this.iNumTel = iNumTel;
			booExito = true;
		}
		return booExito;
	}
	public boolean isBoollamando() {
		return boollamando;
	}
	public void setBoollamando(boolean boollamando) {
		this.boollamando = boollamando;
	}
	public boolean isBooAltavozActivo() {
		return booAltavozActivo;
	}
	public void setBooAltavozActivo(boolean booAltavozActivo) {
		this.booAltavozActivo = booAltavozActivo;
	}
	public byte getbCobertura() {
		return bCobertura;
	}
	public void setbCobertura(byte bCobertura) {
		this.bCobertura = bCobertura;
	}
	public byte getbSatelites() {
		return bSatelites;
	}
	public void setbSatelites(byte bSatelites) {
		this.bSatelites = bSatelites;
	}
	
	public int consultarNumero() {
		return getiNumTel();
	}

	public String marcar(int iNumTelefono) {
		setBoollamando(true);
		return "Llamando a " + iNumTelefono;
	}

	public void colgar() {
		setBoollamando(false);
		
	}

	public void activarAltavoz() {
		setBooAltavozActivo(true);
		
	}

	public void desactivarAltavoz() {
		setBooAltavozActivo(false);
		
	}

	public boolean sonarTimbre() {
		boolean booExito = false;
		if (!isBoollamando()) {
			booExito = true;
		}
		return booExito;
		
	}
	
	
	
	
	
}
