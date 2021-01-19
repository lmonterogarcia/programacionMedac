
public class Asignatura {

	private byte bCodigo; //PK
	private String sCurso; //NN
	private String sNombre; //NN
	
	public Asignatura(byte bCodigo){
		
		setbCodigo(bCodigo);
		
	}
	
	public Asignatura(byte bCodigo, String sCurso, String sNombre) {
		
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
	
}
