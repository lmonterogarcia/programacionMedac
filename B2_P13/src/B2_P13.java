import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_P13 {

	public static void main(String[] args) {
//		Declaracion de variables
		String sNumero = "", sNumeroInvertido = "";
		int iNumero;
		byte bLongitudNumero;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir el numero
		do {
			System.out.print("Introduce el numero a invertir (0...999999): ");
			try {
				sNumero = teclado.readLine();
				iNumero = Integer.parseInt(sNumero);
			} catch (Exception e) {
				iNumero = -1;
			}
			if (iNumero < 0 || iNumero > 999999) {
				System.out.print("Numero fuera de rango o caracter invalido. ");
			}
		} while (iNumero < 0 || iNumero > 999999);

//		Invertir el numero
//		for (bLongitudNumero = ((byte) (sNumero.length() - 1)); bLongitudNumero >= 0; bLongitudNumero--) {
//			sNumeroInvertido += sNumero.charAt(bLongitudNumero);
//		}
		
		
		for (bLongitudNumero = ((byte) (sNumero.length() - 1)); bLongitudNumero >= 0; bLongitudNumero--) {
			sNumeroInvertido += sNumero.charAt(bLongitudNumero);
		}
//		(byte) Math.ceil(Math.log10(iNumeroBinario + 1))

//		Escribir por consola el resultado
		System.out.println("\n" + "El numero invertido es " + sNumeroInvertido);

	}

}
