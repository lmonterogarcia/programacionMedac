import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_P2 {

	public static void main(String[] args) {
//		Declaracion variables de entrada, interna y salida.
		short shAnioNacimiento, shEdad;
		final short SHANIOACTUAL=2020;
		
//		Declarar variables para lectura de teclado
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String cadenaLeida;
		
//		Escribir mensaje para recolectar el anio de nacimiento. Casting.
		System.out.print("Introduce el anio de nacimiento (1...2020): ");
		//Leer
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		shAnioNacimiento=Short.parseShort(cadenaLeida);
		
//		Calcular la edad y asignalar a la variable
		shEdad=(short)(SHANIOACTUAL-shAnioNacimiento);
		
//		Escribir por consola el resultado
		System.out.println("El usuario tiene "+shEdad+" anios.");
	
	}

}
