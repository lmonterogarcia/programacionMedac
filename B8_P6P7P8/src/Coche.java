import java.util.Calendar;

public class Coche {

	private String sModelo; // PK
	private String sColor; // NN
	private boolean booMetalizado; // N
	private String sMatricula; // N
	private byte bTipoCoche; // N
	private short shAnioFabricacion; // N
	private boolean booSeguro; // true = todo riesgo, false = a terceros // N

	public Coche(String sModelo) {
		setsModelo(sModelo);
	}

	public Coche(String sModelo, String sColor) {
		setsModelo(sModelo);
		setsColor(sColor);
	}

	public Coche(String sModelo, String sColor, boolean booMetalizado, String sMatricula, byte bTipoCoche,
			short shAnioFabricacion, boolean booSegudo) {
		setsModelo(sModelo);
		setsColor(sColor);
		setBooMetalizado(booMetalizado);
		setsMatricula(sMatricula);
		setbTipoCoche(bTipoCoche);
		setShAnioFabricacion(shAnioFabricacion);
		setBooSeguro(booSegudo);
	}

	/**
	 * @return the sModelo
	 */
	public String getsModelo() {
		return sModelo;
	}

	/**
	 * @param sModelo the sModelo to set
	 */
	public void setsModelo(String sModelo) {
		if (sModelo != null) {
			this.sModelo = sModelo;
		}
	}

	/**
	 * @return the sColor
	 */
	public String getsColor() {
		return sColor;
	}

	/**
	 * @param sColor the sColor to set
	 */
	public void setsColor(String sColor) {
		if (sColor != null) {
			this.sColor = sColor;
		}
	}

	/**
	 * @return the booMetalizado
	 */
	public boolean isBooMetalizado() {
		return booMetalizado;
	}

	/**
	 * @param booMetalizado the booMetalizado to set
	 */
	public void setBooMetalizado(boolean booMetalizado) {
		this.booMetalizado = booMetalizado;
	}

	/**
	 * @return the sMatricula
	 */
	public String getsMatricula() {
		return sMatricula;
	}

	/**
	 * @param sMatricula the sMatricula to set
	 */
	public void setsMatricula(String sMatricula) {
		if (sMatricula != null && sMatricula.toUpperCase().matches("^[0-9]{4}[A-Z]{3}$")) {
			this.sMatricula = sMatricula;
		}
	}

	/**
	 * @return the bTipoCoche
	 */
	public byte getbTipoCoche() {
		return bTipoCoche;
	}

	/**
	 * @param bTipoCoche the bTipoCoche to set
	 */
	public void setbTipoCoche(byte bTipoCoche) {
		if (bTipoCoche <= 1 && bTipoCoche <= 4) {
			this.bTipoCoche = bTipoCoche;
		}
	}

	/**
	 * @return the shAnioFabricacion
	 */
	public short getShAnioFabricacion() {
		return shAnioFabricacion;
	}

	/**
	 * @param shAnioFabricacion the shAnioFabricacion to set
	 */
	public void setShAnioFabricacion(short shAnioFabricacion) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		if (shAnioFabricacion > 1 && shAnioFabricacion <= year) {
			this.shAnioFabricacion = shAnioFabricacion;
		}
	}

	/**
	 * @return the booSeguro
	 */
	public boolean isBooSeguro() {
		return booSeguro;
	}

	/**
	 * @param booSeguro the booSeguro to set
	 */
	public void setBooSeguro(boolean booSeguro) {
		this.booSeguro = booSeguro;
	}

	public String imprimeCoche() {
		String sMensaje = "";

		sMensaje += "El modelo del coche es " + this.sModelo + ".";
		sMensaje += "\nY el color del coche es " + getsColor();
		if (booMetalizado) {
			sMensaje += " metalizado.";
		} else {
			sMensaje += ".";
		}

		return sMensaje;
	}

	public String toString() {
		String sMensaje = "";

		sMensaje += "El modelo del coche es " + this.sModelo;
		sMensaje += " de color " + getsColor();
		if (booMetalizado) {
			sMensaje += " metalizado";
		}
		sMensaje += ".\nLa matricula es " + this.sMatricula;
		sMensaje += ", el tipo de coche es ";
		switch (this.bTipoCoche) {
		case 1:
			sMensaje += "Mini";
			break;
		case 2:
			sMensaje += "Utilitario";
			break;
		case 3:
			sMensaje += "Familiar";
			break;

		default:
			sMensaje += "Deportivo";
		}
		sMensaje += ", fabricado en el anio " + getShAnioFabricacion();
		sMensaje += ".\nTipo de seguro: ";
		if (booSeguro) {
			sMensaje += "a todo riesgo.";
		} else {
			sMensaje += "a terceros.";
		}

		return sMensaje;
	}
}
