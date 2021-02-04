
public class Satelite implements ITelefono{

	private int iNumTel;
	private boolean boollamando;
	private boolean booAltavozActivo;
	private byte bCobertura;
	private byte bSatelites;
	private final String STIPODETEL = "satelite";
	
	public Satelite(int iNumTel) {
		setiNumTel(iNumTel);
	}
	
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
	public boolean setBoollamando(boolean boollamando) {
		boolean booExito = false;
		if (boollamando != this.boollamando) {
			this.boollamando = boollamando;
			booExito = true;
		}
	
		return booExito;
	}
	public boolean isBooAltavozActivo() {
		return booAltavozActivo;
	}
	public boolean setBooAltavozActivo(boolean booAltavozActivo) {
		boolean booExito = false;
		if (booAltavozActivo != this.booAltavozActivo) {
			this.booAltavozActivo = booAltavozActivo;
			booExito = true;
		}
	
		return booExito;	
	}
	public byte getbCobertura() {
		return bCobertura;
	}
	public boolean setbCobertura(byte bCobertura) {
		boolean booExito = false;
		if (bCobertura >= 0 && bCobertura <= 5) {
			this.bCobertura = bCobertura;
			booExito = true;
		}
		return booExito;
	}
	public byte getbSatelites() {
		return bSatelites;
	}
	public boolean setbSatelites(byte bSatelites) {
		boolean booExito = false;
		if (bSatelites >= 0 && bSatelites <= 120) {
			booExito = true;
			this.bSatelites = bSatelites;
		}
		return booExito;
	}
	
	public int consultarNumero() {
		return getiNumTel();
	}

	public String marcar(int iNumTelefono) {
		setBoollamando(true);
		return "Llamando a " + iNumTelefono + "desde el telefono " + STIPODETEL;
	}

	public String colgar() {
		String sMensaje = "No se ha podido colgar, ya que no está descalgado";
		if (setBoollamando(false)) {
			sMensaje = "Se acaba de colgar  el telefono " + STIPODETEL;
		}
		return sMensaje;
	}

	public String activarAltavoz() {
		String sMensaje = "No se ha podido activar porque ya esta activado";
		if (setBooAltavozActivo(true)) {
			sMensaje = "Se acaba activar el altavoz";
		}
		return sMensaje;
	}

	public String desactivarAltavoz() {
		String sMensaje = "No se ha podido activar porque ya esta activo";
		if (setBooAltavozActivo(false)) {
			sMensaje = "Se acaba de desactivar el altavoz";
		}
		return sMensaje;
	}

	public boolean sonarTimbre() {
		boolean booExito = false;
		if (!isBoollamando()) {
			booExito = true;
		}
		return booExito;
	}

}
