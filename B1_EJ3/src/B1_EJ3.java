import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_EJ3 {

	public static void main(String[] args) {
		// Declaracion de variables
		byte bDia;
		String sMes;
		short shAnio;

		// Declaracion de variables para lectura por teclado
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String cadenaLeida;

		// Escribir en pantalla "Introduce el dia"
		System.out.print("Introduce el dia de tu nacimiento (1...31): ");

		// Leer el dia
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		// Casting
		bDia = Byte.parseByte(cadenaLeida);

		// Escribir en pantalla "Introduce el mes"
		System.out.print("Introduce el mes de tu nacimiento (Enero...Diciembre): ");

		// Leer el mes
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		// Casting
		sMes = cadenaLeida;

		// Escribir en pantalla "Introduce el Anio"
		System.out.print("Introduce el anio de tu nacimiento (1...2020): ");

		// Leer el dia
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		// Casting
		shAnio = Short.parseShort(cadenaLeida);
		
		//Imprimir por pantalla el resultado
		System.out.println("Esta persona nacio el dia "+bDia+" del mes de "+sMes+" de "+shAnio);
	}

}
