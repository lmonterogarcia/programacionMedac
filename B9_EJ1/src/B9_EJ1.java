
public class B9_EJ1 {

	public static void main(String[] args) {
		Semaforo oSemaforo1 = new Semaforo(), oSemaforo2 = new Semaforo((byte) 0), oSemaforo3 = new Semaforo((byte) 1);

		System.out.println(oSemaforo1);
		System.out.println(oSemaforo2);
		System.out.println(oSemaforo3);
		
		System.out.println(cambioColor(oSemaforo1, (byte) 5));
		System.out.println(cambioColor(oSemaforo2, (byte) 2));
		System.out.println(cambioColor(oSemaforo3, (byte) 1));


	}

	private static String cambioColor(Semaforo oSemaforo, byte bColor) {
		String sMensaje = "";
		if(oSemaforo.setbColor(bColor)) {
			sMensaje = oSemaforo.toString();
		}else {
			sMensaje = "\nEl seteo de  color es incorrecto." + oSemaforo.toString();
		}
		return sMensaje;
	}
	
}
