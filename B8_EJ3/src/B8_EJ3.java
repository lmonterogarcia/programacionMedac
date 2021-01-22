
public class B8_EJ3 {

	public static void main(String[] args) {
		// 1
		Semaforo oSemaforo1 = new Semaforo();
		System.out.println(oSemaforo1);
		// 2
		if(oSemaforo1.setbColor((byte) 1)) {
			System.out.println(oSemaforo1);
		}else {
			System.out.println("\nEl seteo de  color es incorrecto.");
		}
		
		// 3
		oSemaforo1.setbColor((byte) 2);
		System.out.println(oSemaforo1);
		// 4
		
		if(oSemaforo1.setBooParpadeando(true)) {
			System.out.println(oSemaforo1);
		}else {
			System.out.println("\nEl seteo de parpadeo es incorrecto.");
		}
		// 5
		oSemaforo1.setbColor((byte) 1);
		System.out.println(oSemaforo1);
		// 6
		if(oSemaforo1.setBooParpadeando(true)) {
			System.out.println(oSemaforo1);
		}else {
			System.out.println("\nEl seteo de parpadeo es incorrecto.");
		}
		// 7
		for (byte bContador = 0; bContador < 5; bContador++) {
			oSemaforo1.cambia();
			System.out.println(oSemaforo1);
		}
		// 8
		Semaforo oSemaforo2 = new Semaforo();
		oSemaforo2.copiaSemaforo(oSemaforo1);
		System.out.println("\nSemaforo 2\n------------");
		System.out.println(oSemaforo1);
	}

}
