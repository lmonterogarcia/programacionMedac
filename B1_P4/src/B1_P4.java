import java.io.BufferedReader;
import java.io.InputStreamReader;


public class B1_P4 {

	public static void main(String[] args) {
//		Declaracion de variables de entrada. Y las variables para el intercambio.
		short shVariable_1, shVariable_2, shVariableIntercambio;
		
//		Declaracion de variables para enrada por teclado
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String cadenaLeida;
		
//		Escribir mensaje y leer variable 1
		System.out.print("Introduce la variable 1 (0...128): ");
		try {
			cadenaLeida=lector.readLine();
		} catch (Exception e) {
			cadenaLeida="";
		}
		shVariable_1=Short.parseShort(cadenaLeida);
		
//		Escribir mensaje y leer variable 2
		System.out.print("Introduzca la variable 2 (0...128): ");
		try {
			cadenaLeida=lector.readLine();
		} catch (Exception e) {
			cadenaLeida="";
		}
		shVariable_2=Short.parseShort(cadenaLeida);
		
//		Escribir mensaje para enseñar las variables
		System.out.println('\r'+"Ante del intercambio. Variable 1 = "+shVariable_1+" y la variable 2 = "+shVariable_2);

//		Intercambio de variables
		shVariableIntercambio=shVariable_1;
		shVariable_1=shVariable_2;
		shVariable_2=shVariableIntercambio;
		
//		Escrirbir por consola las variables intercambiadas
		System.out.println("INTERCAMBIANDO"+'\r'+"Despues del intercambio. Variable 1 = "+shVariable_1+" y la variable 2 = "+shVariable_2);	
	}

}
