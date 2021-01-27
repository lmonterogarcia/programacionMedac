
public class Reloj {

	private byte bHora;
	private byte bMinuto;
	private byte bSegundo;
	private boolean booPostMeridian;

	public Reloj() {
		setbHora((byte) 0);
		setbMinuto((byte) 0);
		setbSegundo((byte) 0);
	}

	public Reloj(byte bHora, byte bMinuto, byte bSegundo) {
		setbHora(bHora);
		setbMinuto(bMinuto);
		setbSegundo(bSegundo);
	}

	/**
	 * @return the bHora
	 */
	public byte getbHora() {
		return bHora;
	}

	/**
	 * @param bHora the bHora to set
	 */
	public boolean setbHora(byte bHora) {
		boolean booExito = false;
		if (bHora >= 0 && bHora <= 23) {
			this.bHora = bHora;
			booExito = true;
		}
		return booExito;
	}

	/**
	 * @return the bMinuto
	 */
	public byte getbMinuto() {
		return bMinuto;
	}

	/**
	 * @param bMinuto the bMinuto to set
	 */
	public boolean setbMinuto(byte bMinuto) {
		boolean booExito = false;
		if (bMinuto >= 0 && bMinuto <= 59) {
			this.bMinuto = bMinuto;
			booExito = true;
		}
		return booExito;
	}

	/**
	 * @return the bSegundo
	 */
	public byte getbSegundo() {
		return bSegundo;
	}

	/**
	 * @param bSegundo the bSegundo to set
	 */
	public boolean setbSegundo(byte bSegundo) {
		boolean booExito = false;
		if (bSegundo >= 0 && bSegundo <= 59) {
			this.bSegundo = bSegundo;
			booExito = true;
		}
		return booExito;
	}

	/**
	 * @return the booPstoMeridian
	 */
	public boolean isBooPstoMeridian() {
		return booPostMeridian;
	}

	/**
	 * @param booPstoMeridian the booPstoMeridian to set
	 */
	public void setBooPstoMeridian(boolean booPstoMeridian) {
		this.booPostMeridian = booPstoMeridian;
	}

	public String toString() {
		String sMensaje = "";
		sMensaje += getbHora() + ":";
		sMensaje += getbMinuto() + ":";
		sMensaje += getbSegundo();
		return sMensaje;
	}

	public String imrpimirRelojVersion12() {
		String sMensaje = "";
		byte bHora12;
		boolean booPostMeridian = false;

		if (getbHora() == 0) {
			bHora12 = (byte) (getbHora() + 12);
			booPostMeridian = false;
		} else if (getbHora() == 12) {
			bHora12 = (byte) (getbHora());
			booPostMeridian = true;
		} else if (getbHora() > 12) {
			bHora12 = (byte) (getbHora() - 12);
			booPostMeridian = true;
		} else {
			bHora12 = getbHora();
		}

		sMensaje += bHora12 + ":";
		sMensaje += getbMinuto() + ":";
		sMensaje += getbSegundo();
		if (booPostMeridian) {
			sMensaje += " pm";
		} else {
			sMensaje += " am";
		}
		return sMensaje;
	}

	public boolean ponerEnHora(byte bHora, byte bMinuto) {
		boolean booExito = false;
		if (setbHora(bHora) && setbMinuto(bMinuto)) {
			booExito = true;
		}
		setbSegundo((byte) 0);
		return booExito;
	}
	
	public boolean ponerEnHora(byte bHora, byte bMinuto, byte bSegundo) {
		boolean booExito = false;
		if (setbHora(bHora) && setbMinuto(bMinuto) && setbSegundo(bSegundo)) {
			booExito = true;
		}
		return booExito;
	}
	
	public boolean ponerEnHora(byte bHora, byte bMinuto, byte bSegundo, boolean booPostMeridian) {
		boolean booExito = false;
		byte bHora12;
		if (booPostMeridian && bHora < 12) {
			bHora12 = (byte) (bHora + 12);
		} else if (!booPostMeridian && bHora == 12) {
			bHora12 = 0;
		} else {
			bHora12 = bHora;
		}
		if (setbHora(bHora12) && setbMinuto(bMinuto) && setbSegundo(bSegundo)) {
			booExito = true;
		}
		return booExito;
	}
}
