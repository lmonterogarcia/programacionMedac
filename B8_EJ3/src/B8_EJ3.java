
public class B8_EJ3 {

	public static void main(String[] args) {
		// 1
		Semaforo oSemaforo1 = new Semaforo();
		// 2
		oSemaforo1.setbColor((byte) 1);
		// 3
		oSemaforo1.setbColor((byte) 2);
		// 4
		oSemaforo1.setBooParpadeando(true);
		// 5
		oSemaforo1.setbColor((byte) 1);
		// 6
		oSemaforo1.setBooParpadeando(true);
		// 7
		for (byte bContador = 0; bContador < 5; bContador++) {
			oSemaforo1.cambia();
		}
		// 8
		Semaforo oSemaforo2 = new Semaforo();
		oSemaforo2.copiaSemaforo(oSemaforo1);
		System.out.println("\nSemaforo 2\n------------");
		oSemaforo2.imprimir();
	}

}
