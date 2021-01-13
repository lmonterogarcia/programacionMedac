import java.io.*;

public class B2_E1 {

	public static void main(String[] args) {

		float fEjeX, fEjeY;
		byte bNumeroCuadrante;

		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;

		// Pido por teclado el eje X
		do {
			System.out.print("Escribe una coordenada X (-10...10 sin usar el 0): ");
			try {
				sCadenaLeida = teclado.readLine();
			} catch (Exception e) {
				sCadenaLeida = "";
			}
			fEjeX = Float.parseFloat(sCadenaLeida); // Casting
		} while (fEjeX < -10 || fEjeX > 10 || fEjeX == 0);

		// Pido por teclado el eje Y
		do {
			System.out.print("Escribe una coordenada Y (-10...10 sin usar el 0): ");
			try {
				sCadenaLeida = teclado.readLine();
			} catch (Exception e) {
				sCadenaLeida = "";
			}
			fEjeY = Float.parseFloat(sCadenaLeida); // Casting
		} while (fEjeY < -10 || fEjeY > 10 || fEjeY == 0);

		fEjeY = Float.parseFloat(sCadenaLeida); // Casting
		
		// Logica de la aplicacion (Algoritmo)
		if (fEjeX > 0 && fEjeY > 0) {
			bNumeroCuadrante = 1;
		} else if (fEjeX > 0 && fEjeY < 0) {
			bNumeroCuadrante = 4;
		} else if (fEjeX < 0 && fEjeY > 0) {
			bNumeroCuadrante = 2;
		} else {
			bNumeroCuadrante = 3;
		}

		System.out.println("El cuadrante de tu coordenada es: " + bNumeroCuadrante);

	}

}
