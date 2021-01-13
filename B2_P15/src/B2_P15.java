import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_P15 {

	public static void main(String[] args) {
//		Declaracion de variables
		int iRango1, iRango2, iIntercambio, iContador;
		String sNumero, sNumeroInvertido, sNumerosCapicua = "";
		byte bLongitudNumero;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir el numero
		//Primer numero del rango
		do {
			System.out.print("Introduce el primer numero (0...999999): ");
			try {
				iRango1 = Integer.parseInt(teclado.readLine());
			} catch (Exception e) {
				iRango1 = -1;
			}
			if (iRango1 < 0 || iRango1 > 999999) {
				System.out.print("Numero fuera de rango o caracter invalido. ");
			}
		} while (iRango1 < 0 || iRango1 > 999999);
		//Segundo numero del rango
		do {
			System.out.print("Introduce el primer numero (0...999999): ");
			try {
				iRango2 = Integer.parseInt(teclado.readLine());
			} catch (Exception e) {
				iRango2 = -1;
			}
			if (iRango2 < 0 || iRango2 > 999999) {
				System.out.print("Numero fuera de rango o caracter invalido. ");
			}
		} while (iRango2 < 0 || iRango2 > 999999);

//		Verificar si rango 1 es menor que rango 2, sino intercabiar variables
		if (iRango2 < iRango1) {
			iIntercambio = iRango2;
			iRango2 = iRango1;
			iRango1 = iIntercambio;
		}
		
//		Hacer un recorrido desde el numero mas pequenio al mas grande y encontrar los capicua para insertarlos en la cadena.
		for (iContador = iRango1 ; iContador <= iRango2; iContador++) {
			sNumero = Integer.toString(iContador);
			sNumeroInvertido = "";
			for (bLongitudNumero = ((byte) (sNumero.length() - 1)); bLongitudNumero >= 0; bLongitudNumero--) {
				sNumeroInvertido += sNumero.charAt(bLongitudNumero);
			}
			if (sNumero.equals(sNumeroInvertido)) {
				sNumerosCapicua += sNumero+", ";
			}
		}

//		Escribir por consola el resultado
		if (sNumerosCapicua.equals("")) {
			System.out.println("No hay ningun numero capicua");
		} else {
			System.out.println(sNumerosCapicua.substring(0, sNumerosCapicua.length()-2)+".");
		}	
	}
}
