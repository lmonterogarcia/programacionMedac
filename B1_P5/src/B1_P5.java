import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_P5 {

	public static void main(String[] args) {
//		Declaracion de variables para enrada por teclado
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String cadenaLeida;

//		Declaracion de variables de entradas y salida. 3 coeficientes y dos resultados
		float fCoeficienteA, fCoeficienteB, fCoeficientec, fResultado_1, fResultado_2;

//		Pedir al usuario los coeficientes y grabarlos en sus variables

		// coeficiente a
		System.out.print("Introduce el coeficiente a (-126.0...128.0): ");
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		fCoeficienteA = Float.parseFloat(cadenaLeida);

		// coeficiente b
		System.out.print("Introduce el coeficiente b (-126.0...128.0): ");
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		fCoeficienteB = Float.parseFloat(cadenaLeida);

		// coeficiente c
		System.out.print("Introduce el coeficiente c (-126.0...128.0): ");
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		fCoeficientec = Float.parseFloat(cadenaLeida);
		
//		Calcular los resultados de la ecuacion de segundo grado
		//Resultado 1
		fResultado_1=(float)((-1*fCoeficienteB+(Math.pow(((fCoeficienteB*fCoeficienteB)-(4*fCoeficienteA*fCoeficientec)), 0.5)))/(2*fCoeficienteA));
		//Resultado 2
		fResultado_2=(float)((-1*fCoeficienteB-(Math.pow(((fCoeficienteB*fCoeficienteB)-(4*fCoeficienteA*fCoeficientec)), 0.5)))/(2*fCoeficienteA));
		
//		Escribir por consola el resultado
		System.out.println('\r'+"Tenga en cuenta que si b^2-4*a*c < 0, la ecuacion de segundo grado no tiene resultado. Y aparecera NaN."+'\r'+'\r');
		System.out.println("Los resultados para la ecuación de segundo grado con los coeficientes a = "+fCoeficienteA+", b = "+fCoeficienteB+", y c = "+fCoeficientec+" son "+fResultado_1+" y "+fResultado_2+".");
	}

}
