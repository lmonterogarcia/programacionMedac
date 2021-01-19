
public class Asignatura {

	private byte bCodigo; //PK
	private String sCurso; //NN
	private String sNombre; //NN
	
	public Asignatura(byte bCodigo){
		
		setbCodigo(bCodigo);
		
	}
	
	public Asignatura(byte bCodigo, String sNombre, String sCurso) {
		
		setbCodigo(bCodigo);
		setsCurso(sCurso);
		setsNombre(sNombre);
		
	}

	public byte getbCodigo() {
		return bCodigo;
	}

	public void setbCodigo(byte bCodigo) {
		if (bCodigo > 0) {
			this.bCodigo = bCodigo;
		} else {
			this.bCodigo = -1;
		}
		
	}

	public String getsCurso() {
		return sCurso;
	}

	public void setsCurso(String sCurso) {
		if ( sCurso!= null && sCurso.length() > 3) {
			this.sCurso = sCurso;
		}
		
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		if ( sNombre != null && sNombre.length() > 3) {
			this.sNombre = sNombre;
		}
	}
	
	public String toString() {
		String sMensaje = "";
		if (checkAsignatura()) {

			sMensaje += "Codigo de la asignatura: " + bCodigo + "\n";
			sMensaje += "Nombre de la asignatura: " + sNombre + "\n";
			sMensaje += "Curso: " + sCurso + "\n";
			
		} else {
			sMensaje += "Error en la asignatura, verificar los datos.";
		}

		return sMensaje;
	}
	
	public boolean checkAsignatura() {
		boolean booExito = false;
		if (this.getbCodigo() > 0 && this.getsCurso() != null && this.getsNombre() != null) {
			booExito = true;
		}
		return booExito;
	}
	
}
