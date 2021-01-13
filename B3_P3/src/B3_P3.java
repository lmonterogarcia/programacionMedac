import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B3_P3 {

	public static void main(String[] args) {
//		Declarar variables
		char cNumero;
		boolean booEsCorrecto = false;
		byte bContador = 1;
		String sCandenaLeida = null;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir al usuario que teclee el caracter
			do {
				System.out.print("Oportunidad " + bContador + " de 3. Pulsa una tecla del 0 al 9: ");
				try {
					sCandenaLeida = teclado.readLine();
					cNumero = sCandenaLeida.charAt(0);
				} catch (Exception e) {
					cNumero = 'e';
				}
				
//				Comprobar que solo ha pulsado una tecla y esta comprendida del 0 al 9. Enseni a mensaje de error si no se cumple.
				if (((sCandenaLeida.length()) == 1) && (cNumero >= '0' && cNumero <= '9')) {
					booEsCorrecto = true;
				} else {
					System.err.println("Solo puede pulsar una unica tecla comprendida entre 0 y 9. "+"\n");
					bContador++;
				}
			} while (((cNumero < '0' || cNumero > '9') || (bContador < 4 && !booEsCorrecto)) && bContador < 4);


//		Enseniar por consola el resultado
		if (!booEsCorrecto) {
			System.out.println("\n"
					+ "Despues de tres oportunidades no ha tecleado un numero del 0 al 9. El programa ha terminado.");
		} else {
			System.out.println("\n" + "El numero es " + cNumero + ".");
		}
	}
}
