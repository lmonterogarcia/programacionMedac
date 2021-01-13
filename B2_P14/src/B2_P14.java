import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_P14 {

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

//		Invertir el numero y ver si es capicua.
		for (bLongitudNumero = ((byte) (sNumero.length() - 1)); bLongitudNumero >= 0; bLongitudNumero--) {
			sNumeroInvertido += sNumero.charAt(bLongitudNumero);
		}

//		Escribir por consola el resultado
		if (sNumero.equals(sNumeroInvertido)) {
			System.out.println("\n" + "El numero " + sNumero + " es capicua");
		} else {
			System.out.println("\n" + "El numero " + sNumero + " NO es capicua");
		}
	}
}
