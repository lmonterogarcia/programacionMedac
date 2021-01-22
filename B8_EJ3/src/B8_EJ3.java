
public class B8_EJ3 {

	public static void main(String[] args) {
		// 1
		Semaforo oSemaforo1 = new Semaforo();
		oSemaforo1.imprimir();
		// 2
		if(oSemaforo1.setbColor((byte) 1)) {
			System.out.println(oSemaforo1.imprimir());
		}else {
			System.out.println("El color es incorrecto.");
		}
		
		// 3
		oSemaforo1.setbColor((byte) 2);
		oSemaforo1.imprimir();
		// 4
		oSemaforo1.setBooParpadeando(true);
		oSemaforo1.imprimir();
		// 5
		oSemaforo1.setbColor((byte) 1);
		oSemaforo1.imprimir();
		// 6
		oSemaforo1.setBooParpadeando(true);
		oSemaforo1.imprimir();
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
