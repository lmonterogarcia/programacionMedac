import java.io.BufferedReader;
import java.io.InputStreamReader;


public class B2_P6 {

	public static void main(String[] args) {
//		Declaracion de variables
		short shNumero=-1, shContador=0;
		final short SHCONTADORMAX = 32767;
		int iSuma = 0;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
//		Pedir los numeros para la suma y validar
		while (shNumero !=0 && shContador != SHCONTADORMAX) {
			do {
				System.out.print("Introduce un numero (-10000...10000), 0 para terminar: ");
				try {
					shNumero = Short.parseShort(teclado.readLine());
				} catch (Exception e) {
					shNumero = -10001;
				}
				if (shNumero < -10000 || shNumero > 10000) {
					System.out.print("Numero erroneo. ");
				}
			} while (shNumero < -10000 || shNumero > 10000);
			
			//Calculo de suma y sumados
			if (shNumero != 0) {
				iSuma += shNumero;
				shContador++;
				if (shContador == SHCONTADORMAX) {
					System.out.println("Has llegado al limite de sumados. Introduce 0 para terminar.");
					shNumero = 0;
				}
			}
		}
		System.out.println("La suma de "+shContador+" numeros es "+iSuma);
	}
}
