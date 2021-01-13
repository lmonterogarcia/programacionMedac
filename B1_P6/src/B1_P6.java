import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_P6 {

	public static void main(String[] args) {
//		Declaracion de variables para enrada por teclado
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String cadenaLeida;

//		Declaracion de variables de entradas, interna y salida. Radio, area, longitus y pi.
		float fRadioCircunferencia, fAreaCircunferencia, fLongitudCircunferencia;
		final float FPI=3.14159265f;
		
//		Pedir al usuario que introduzca el radio de la circunferencia
		System.out.print("Introduce el radio de la circunferencia (0.01...128.0): ");
		
//		Leer variable del radio de la circunferencia
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida= "";
		}
		fRadioCircunferencia=Float.parseFloat(cadenaLeida);
		
//		Calculo del area y de la longitud de la circunferencia
		fAreaCircunferencia=FPI*fRadioCircunferencia*fRadioCircunferencia;
		fLongitudCircunferencia=2*FPI*fRadioCircunferencia;
		
//		Enseñar por consola el resultado
		System.out.println("Para una circunferencia con radio "+fRadioCircunferencia+", tiene un area de "+fAreaCircunferencia+" y una longitud de "+fLongitudCircunferencia);
	}

}
