import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_EJ1 {

	public static void main(String[] args) {
//		Declaracion de variables
		byte bDia, bMes, bNextDia, bNextMes, bDiaMax;
		short shAnio, shNextAnio;
		boolean booBisiesto;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir las variables al usuarios y validar si la fecha es correcta
		// Anio
		do {
			System.out.print("Introduce el anio (1...3000): ");
			try {
				shAnio = Short.parseShort(teclado.readLine());
			} catch (Exception e) {
				shAnio = -1;
			}
			if (shAnio <= 1 || shAnio > 3000) {
				System.out.print("Anio fuera de rango o caracter invalido. ");
			}
		} while (shAnio <= 1 || shAnio > 3000);
		if ((shAnio % 4 == 0 && shAnio % 100 != 0) || shAnio % 400 == 0) {
			booBisiesto = true;
		} else {
			booBisiesto = false;
		}
		// Mes
		do {
			System.out.print("Introduce el mes (1...12): ");
			try {
				bMes = Byte.parseByte(teclado.readLine());
			} catch (Exception e) {
				bMes = -1;
			}
			if (bMes <= 1 || bMes > 12) {
				System.out.print("Mes fuera de rango o caracter invalido. ");
			}
		} while (bMes <= 1 || bMes > 12);
		if (bMes == 2) {
			if (booBisiesto) {
				bDiaMax = 29;
			} else {
				bDiaMax = 28;
			}
		} else if (bMes == 4 || bMes == 6 || bMes == 9 || bMes == 11) {
			bDiaMax = 30;
		} else {
			bDiaMax = 31;
		}
		// Dia
		do {
			System.out.print("Introduce el dia (1..." + bDiaMax + "): ");
			try {
				bDia = Byte.parseByte(teclado.readLine());
			} catch (Exception e) {
				bDia = -1;
			}
			if (bDia <= 1 || bDia > bDiaMax) {
				System.out.print("Dia fuera de rango o caracter invalido. ");
			}
		} while (bDia <= 1 || bDia > bDiaMax);

//		Calcular el dia siguiente
		if (bDia == bDiaMax && bMes == 12) {
			bNextDia = 1;
			bNextMes = 1;
			shNextAnio = (short) (shAnio + 1);
		} else if (bDia == bDiaMax) {
			bNextDia = 1;
			bNextMes = (byte) (bMes + 1);
			shNextAnio = shAnio;
		} else {
			bNextDia = (byte) (bDia + 1);
			bNextMes = bMes;
			shNextAnio = shAnio;
		}

//		Imprimir por consola el resultado
		System.out.println("El dia siguiente a " + bDia + "/" + bMes + "/" + shAnio + " es " + bNextDia + "/" + bNextMes
				+ "/" + shNextAnio);
	}
}
