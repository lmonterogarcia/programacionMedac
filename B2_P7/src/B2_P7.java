import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_P7 {

	public static void main(String[] args) {
//		Declaracion de variables
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		short shAnio;

//		Pedir el anio 

		do {
			System.out.print("Escribe el anio (1...3000): ");
			try {
				shAnio = Short.parseShort(teclado.readLine());
			} catch (Exception e) {
				shAnio = -1;
			}
		} while (shAnio < 1 || shAnio > 3000);

//		Calcular si es bisiesto e imprimirlo por pantalla
		if ((shAnio % 4 == 0 && shAnio % 100 != 0) || shAnio % 400 == 0) {
			System.out.println("El anio " + shAnio + " es bisiesto");
		} else {
			System.out.println("El anio " + shAnio + " no es bisiesto");
		}
	}
}