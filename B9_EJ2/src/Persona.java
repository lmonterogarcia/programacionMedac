
public class Persona {
	private String sNombre; // PK
	private String sApellido1; // PK
	private String sApellido2; // PK
	private short shEdad; // N
	private float fEstatura; // N
	private float fPeso; // N
	private byte bEstado; // N

	public Persona(String sNombre, String sApellido1, String sApellido2) {
		setsNombre(sNombre);
		setsApellido1(sApellido1);
		setsApellido2(sApellido2);
	}
	public Persona(String sNombre, String sApellido1, String sApellido2, short shEdad, float eEstatura, float fPeso, byte bEstado) {
		setsNombre(sNombre);
		setsApellido1(sApellido1);
		setsApellido2(sApellido2);
		setShEdad(shEdad);
		setfEstatura(eEstatura);
		setfPeso(fPeso);
		setbEstado(bEstado);
	}

	public String getsNombre() {
		return sNombre;
	}

	private boolean setsNombre(String sNombre) {
		boolean booExito = false;
		if (sNombre != null && sNombre.length() < 10) {
			this.sNombre = sNombre;
			booExito = true;
		}
		return booExito;
	}

	public String getsApellido1() {
		return sApellido1;
	}

	private boolean setsApellido1(String sApellido1) {
		boolean booExito = false;
		if (sNombre != null && sNombre.length() < 20) {
			this.sApellido1 = sApellido1;
			booExito = true;
		}
		return booExito;

	}

	public String getsApellido2() {
		return sApellido2;
	}

	private boolean setsApellido2(String sApellido2) {
		boolean booExito = false;
		if (sNombre != null && sNombre.length() < 20) {
			this.sApellido2 = sApellido2;
			booExito = true;
		}
		return booExito;

	}

	public short getShEdad() {
		return shEdad;
	}

	public boolean setShEdad(short shEdad) {
		boolean booExito = false;
		if ((shEdad >= 0 && shEdad <= 150) && shEdad > this.shEdad) {
			this.shEdad = shEdad;
			booExito = true;
		}
		return booExito;
	}

	public float getfEstatura() {
		return fEstatura;
	}

	public boolean setfEstatura(float fEstatura) {
		boolean booExito = false;
		if (fEstatura >= 0 && fEstatura <= 3) {
			this.fEstatura = fEstatura;
			booExito = true;
		}
		return booExito;
	}

	public float getfPeso() {
		return fPeso;
	}

	public boolean setfPeso(float fPeso) {
		boolean booExito = false;
		if (fPeso >= 0 && fPeso <= 300) {
			this.fPeso = fPeso;
			booExito = true;
		}
		return booExito;
	}

	public byte getbEstado() {
		return bEstado;
	}

	public boolean setbEstado(byte bEstado) {
		boolean booExito = false;
		if (bEstado > 0 && bEstado <= 5) {
			switch (bEstado) {
			case 1:
				if (this.getbEstado() < 1) {
					this.bEstado = bEstado;
					booExito = true;
				}
				break;
			case 2:
				if (this.getbEstado() == 1 || this.getbEstado() == 4 || this.getbEstado() == 5) {
					this.bEstado = bEstado;
					booExito = true;
				}
				break;
			case 3:
				if (this.getbEstado() == 2) {
					this.bEstado = bEstado;
					booExito = true;
				}
				break;
			case 4:
				if (this.getbEstado() == 3) {
					this.bEstado = bEstado;
					booExito = true;
				}
				break;
			default:
				if (this.getbEstado() == 2 || this.getbEstado() == 3) {
					this.bEstado = bEstado;
					booExito = true;
				}
				break;
			}
		}
		return booExito;
	}

	
	public String nombreEstado() {
		String sMensaje;
		switch (this.bEstado) {
		case 1:
			sMensaje = "soltero.";
			break;
		case 2:
			sMensaje = "casado.";
			break;
		case 3:
			sMensaje = "separado.";
			break;
		case 4:
			sMensaje = "divorciado.";
			break;
		default:
			sMensaje = "viudo.";
		}
		return sMensaje;
	}
}
