import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_EJ2 {

	public static void main(String[] args) {
//		Declaracion de constantes y variable
		final float FPI = 3.14159235f;
		float fRadioCirculo, fAreaCirculo;
		
//		Declaracion para lectura por teclado
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String cadenaLeida;
		
//		Escribir en panatalla "Introduzca el radio del circulo"
		System.out.println("Introduzca el radio del circulo: ");
		
//		Leer datos del teclado. Leer radio.
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		fRadioCirculo = Float.parseFloat(cadenaLeida);
		
//		Calculo del area
		fAreaCirculo = FPI*fRadioCirculo*fRadioCirculo;
		
//		Escribir por pantalla el resultado
		System.out.println("El area del circulo es " + fAreaCirculo);
	}

}
