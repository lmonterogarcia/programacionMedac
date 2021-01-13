import java.io.*;

public class B2_E2 {

	public static void main(String[] args) {
		// Declaracion de variables y constantes
		float fTemperatura;
		byte bEstado;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;

		// Validacion y peticion de datos
		do {
			System.out.print("Escribe una temperatura (-200....200): ");
			try {
				sCadenaLeida = teclado.readLine();
			} catch (Exception e) {
				sCadenaLeida = "";
			}
			fTemperatura = Float.parseFloat(sCadenaLeida); // Casting
		} while (fTemperatura < -200 || fTemperatura > 200);

		// Logica de la aplicacion (Algoritmo)
		if (fTemperatura < 0) {
			bEstado = 1;
		} else if (fTemperatura >= 0 && fTemperatura <= 100) {
			bEstado = 2;
		} else {
			bEstado = 3;
		}

		// Impresion por pantalla
		/*if (bEstado == 1) {
			System.out.println("Hielo");
		} else if (bEstado == 2) {
			System.out.println("Agua");
		} else {
			System.out.println("Vapor");
		}*/

		switch (bEstado) {
		case 1:
			System.out.println("Hielo");
			break;
		case 2:
			System.out.println("Agua");
			break;
		default:
			System.out.println("Vapor");
		}
	}
}
