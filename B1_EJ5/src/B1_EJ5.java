import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_EJ5 {

	public static void main(String[] args) {
//		Declaracion de variables de entrada y salida. Base, altura y area.
		float fBaseRectangulo, fAlturaRectangulo, fAreaRectangulo;
		
//		Declaracion variables para lectura por teclado.
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String cadenaLeida;
		
//		Escribir "Escribir la base del rectangulo: "
		System.out.print("Introduce la base del rectangulo (0...500): ");

//		Leer base del rectangulo y casting
		try {
			cadenaLeida = lector.readLine();
			}catch(Exception e) {
				cadenaLeida = "";
			}
		fBaseRectangulo =Float.parseFloat(cadenaLeida);
				
//		Escribir "Escribir la altura: "
		System.out.print("Introduce la altura del rectangulo (0...500): ");

//		Leer altura del rectangulo y casting 
		try {
			cadenaLeida = lector.readLine();
			}catch(Exception e) {
				cadenaLeida = "";
			}
		fAlturaRectangulo =Float.parseFloat(cadenaLeida);
				
//		Inicializacion de fAreaRectangulo con algoritmo de calcular de area.
		fAreaRectangulo=fBaseRectangulo*fAlturaRectangulo;
		
//		 Escribir mensaje para mostar en consola el resultado.
		System.out.println("El área de un rectángulo de base "+fBaseRectangulo+" y altura "+fAlturaRectangulo+" es "+fAreaRectangulo+".");

	}

}
