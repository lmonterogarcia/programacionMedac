import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B3_EJ4 {

	public static void main(String[] args) {
//		Declaracion de variables
		int iNumero, iContador = 2;
		boolean booEsPrimo = true;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir el numero y validar
		do {
			System.out.print("Introduce un numero entero (1...999999999): ");
			try {
				iNumero = Integer.parseInt(teclado.readLine());
			} catch (Exception e) {
				iNumero = -1;
			}
			if (iNumero < 1 || iNumero > 999999999) {
				System.err.print("Numero fuera de rango o caracter invalido. ");
			}
		} while (iNumero < 1 || iNumero > 999999999);

//		Calculo para ver si es primo
			while (iContador < iNumero && booEsPrimo) {
				if (iNumero % iContador == 0) {
					booEsPrimo = false;
				}
				iContador++;
			}

//		Mostrar por consola si es primo o no
		if (booEsPrimo && iNumero != 1) {
			System.out.println("\n" + "El numero " + iNumero + " es primo.");
		} else if (iNumero == 1) {
			System.out.println("\n" + "El numero 1 no es primo por definicion.");
		} else {
			System.out.println("\n" + "El numero " + iNumero + " no es primo." + "\n" + "Es divisible por "
					+ (iContador - 1) + ".");
		}
	}
}
