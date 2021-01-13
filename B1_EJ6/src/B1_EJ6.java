import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_EJ6 {

	public static void main(String[] args) {
		// Declaracion de variables 
		int iDorsalDeportista;
		float fAlturaDeportista, fPesoDeportista;

		// Declaracion de variables para lectura por teclado
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String cadenaLeida;

		// Escribir en pantalla "Introduce el dorsal"
		System.out.println("Introduce el dorsal del deportista (0...1000000): ");

		// Leer el dorsal
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		// Casting
		iDorsalDeportista = Integer.parseInt(cadenaLeida);

		// Escribir en pantalla "Introduce el altura"
		System.out.println("Introduce la altura del deportista (1.0...2.6): ");

		// Leer el mes
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		// Casting
		fAlturaDeportista = Float.parseFloat(cadenaLeida);

		// Escribir en pantalla "Introduce el peso"
		System.out.println("Introduce el peso del deportista (40.0...150.0): ");

		// Leer el peso
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		// Casting
		fPesoDeportista = Float.parseFloat(cadenaLeida);

		// Imprimir por pantalla la frase "resultado"
		System.out.println("El dorsal número "+iDorsalDeportista+" mide "+fAlturaDeportista+"cm y pesa "+fPesoDeportista+"kg");
	}

}
