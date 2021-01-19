
public class B8_P1 {

	public static void main(String[] args) {
		Fecha oA = new Fecha((byte)16, (byte)4, (short)1984);
		Fecha oB = new Fecha((byte)29, (byte)2, (short)2019);
		Fecha oC = new Fecha((byte)16, (byte)15, (short)1984);
		
		System.out.println(mensajePantalla(oA));
		System.out.println(mensajePantalla(oB));
		System.out.println(mensajePantalla(oC));
		
	}

	
	public static String mensajePantalla(Fecha oFecha) {
		String sMensaje;
		if (oFecha.checkFecha()) {
			sMensaje = oFecha.toString()+" es correcta.";
		} else {
			sMensaje = "La fecha introducida no es correcta";
		}
		return sMensaje;
	}
}
