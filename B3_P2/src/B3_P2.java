import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B3_P2 {

	public static void main(String[] args) {
//		Declarar variables
		short shNumero;
		String sSerieEsMultiplo = "", sSerieNoMultiplo = "";
		boolean booControlSalidaConsola = false;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir el numero al usuario
		do {
			System.out.print("Introduce un numero (0...30000): ");
			try {
				shNumero = Short.parseShort(teclado.readLine());
			} catch (Exception e) {
				shNumero = -1;
			}
			if (shNumero < 0 || shNumero > 30000) {
				System.err.print("Numero fuera de rango o caracter invalido. ");
			}
		} while (shNumero < 0 || shNumero > 30000);

//		Logica para ver si es mutliplo o no
		if (shNumero % 2 == 0) {
			sSerieEsMultiplo += "2, ";
		} else {
			sSerieNoMultiplo += "2, ";
		}
		if (shNumero % 3 == 0) {
			sSerieEsMultiplo += "3, ";
		} else {
			sSerieNoMultiplo += "3, ";
		}
		if (shNumero % 5 == 0) {
			sSerieEsMultiplo += "5, ";
		} else {
			sSerieNoMultiplo += "5, ";
		}
		if (shNumero % 7 == 0) {
			sSerieEsMultiplo += "7, ";
		} else {
			sSerieNoMultiplo += "7, ";
		}
		if (shNumero % 10 == 0) {
			sSerieEsMultiplo += "10, ";
		} else {
			sSerieNoMultiplo += "10, ";
			booControlSalidaConsola = true;
		}

//		Enseniar por consola el resultado.
		if ((shNumero % 2 != 0) && (shNumero % 3 != 0) && (shNumero % 5 != 0) && (shNumero % 7 != 0)
				&& (shNumero % 10 != 0)) {
			System.out.println("\n" + "El " + shNumero + " no es divisible por "
					+ sSerieNoMultiplo.substring(0, sSerieNoMultiplo.length() - 6) + " y "
					+ sSerieNoMultiplo.substring(12, sSerieNoMultiplo.length() - 2) + ".");
		} else if ((shNumero % 2 == 0) && (shNumero % 3 == 0) && (shNumero % 5 == 0) && (shNumero % 7 == 0)
				&& (shNumero % 10 == 0)) {
			System.out.println("\n" + "El " + shNumero + " es divisible por "
					+ sSerieEsMultiplo.substring(0, sSerieEsMultiplo.length() - 6) + " y "
					+ sSerieEsMultiplo.substring(12, sSerieEsMultiplo.length() - 2) + ".");	
		} else if (booControlSalidaConsola) {
			System.out.println("\n" + "El " + shNumero + " es divisible por "
					+ sSerieEsMultiplo.substring(0, sSerieEsMultiplo.length() - 2) + " y no es divisible por "
					+ sSerieNoMultiplo.substring(0, sSerieNoMultiplo.length() - 6) + " y "
					+ sSerieNoMultiplo.substring(sSerieNoMultiplo.length() - 4, sSerieNoMultiplo.length() - 2) + ".");
		} else if (sSerieNoMultiplo.length() == 3) {
			System.out.println("\n" + "El " + shNumero + " es divisible por "
					+ sSerieEsMultiplo.substring(0, sSerieEsMultiplo.length() - 2) + " y no es divisible por "
					+ sSerieNoMultiplo.substring(sSerieNoMultiplo.length() - 3, sSerieNoMultiplo.length() - 2) + ".");
		} else {
			System.out.println("\n" + "El " + shNumero + " es divisible por "
					+ sSerieEsMultiplo.substring(0, sSerieEsMultiplo.length() - 2) + " y no es divisible por "
					+ sSerieNoMultiplo.substring(0, sSerieNoMultiplo.length() - 5) + " y "
					+ sSerieNoMultiplo.substring(sSerieNoMultiplo.length() - 3, sSerieNoMultiplo.length() - 2) + ".");
		}
	}
}
