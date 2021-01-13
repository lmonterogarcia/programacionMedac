
public class B7_EJ14 {

	public static void main(String[] args) {
		String sMensaje = "";
		
		for (short shContador = 500; shContador >= 0; shContador -= 2) {
			sMensaje += shContador+", ";
		}
		
		System.out.println(sMensaje.substring(0, (sMensaje.length() - 2))+".");
		
		// Yo creo que lo que pides es el de arriba, pero por si acaso aqui tienes otra version.
//		for (short shContador = 500; shContador >= 0; shContador--) {
//			for (byte bContador = 0; bContador < 2; bContador++) {
//				sMensaje += shContador+", ";
//				shContador--;
//			}
//			sMensaje += "\n";
//		}
//	
//		System.out.println(sMensaje.substring(0, (sMensaje.length() - 3))+".");
	}

}
