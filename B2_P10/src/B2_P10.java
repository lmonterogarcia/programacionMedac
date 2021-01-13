import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_P10 {

	public static void main(String[] args) {
//		Declarar variables
		byte bNumero, bNumeroPar;
		String sSerieNumerosPares = "";
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir numero
		do {
			System.out.print("Introduce un numero (1...100): ");
			try {
				bNumero = Byte.parseByte(teclado.readLine());
			} catch (Exception e) {
				bNumero = -1;
			}
			if (bNumero < 1 || bNumero > 100) {
				System.out.print("Numero fuera de rango o caracter invalido. ");
			}
		} while (bNumero < 1 || bNumero > 100);

//		Calcular la serie de numero pares
		for (bNumeroPar = 2; bNumeroPar <= bNumero; bNumeroPar += 2) {
			sSerieNumerosPares += bNumeroPar + ", ";
		}

//		Imprimir por pantalla el resutlado
		if (sSerieNumerosPares == "") {
			System.out.println("No hay ningun numero par entre 1 y " + bNumero + ".");
		} else {
			System.out.println(sSerieNumerosPares.substring(0, sSerieNumerosPares.length() - 2) + ".");
		}
	}
}
