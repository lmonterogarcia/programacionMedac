import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_EJ2 {

	public static void main(String[] args) {
//		Declaracion de variables
		byte bHorasH1, bMinutosH1, bHorasH2, bMinutosH2, bHorasDiferencia, bMinutosDiferencia;
		final byte bConversorHoras = 60;
		short shMinutosTotalH1, shMinutosTotalH2;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir las horas al usuario y validad
		// H1
		do {
			System.out.print("Introduce las horas de H1 (numero entrero entre 0...23): ");
			try {
				bHorasH1 = Byte.parseByte(teclado.readLine());
			} catch (Exception e) {
				bHorasH1 = -1;
			}
		} while (bHorasH1 < 0 || bHorasH1 > 23);
		do {
			System.out.print("Introduce los minutos de H1 (numero entrero entre 0...59): ");
			try {
				bMinutosH1 = Byte.parseByte(teclado.readLine());
			} catch (Exception e) {
				bMinutosH1 = -1;
			}
		} while (bMinutosH1 < 0 || bMinutosH1 > 59);
		// H2
		do {
			System.out.print("\n"+"Introduce las horas de H2 (numero entrero entre 0...23): ");
			try {
				bHorasH2 = Byte.parseByte(teclado.readLine());
			} catch (Exception e) {
				bHorasH2 = -1;
			}
		} while (bHorasH2 < 0 || bHorasH2 > 23);
		do {
			System.out.print("Introduce los minutos de H2 (numero entrero entre 0...59): ");
			try {
				bMinutosH2 = Byte.parseByte(teclado.readLine());
			} catch (Exception e) {
				bMinutosH2 = -1;
			}
		} while (bMinutosH2 < 0 || bMinutosH2 > 59);

//		Calculo de la diferencia entre las horas
		shMinutosTotalH1 = (short) (bHorasH1 * bConversorHoras + bMinutosH1);
		shMinutosTotalH2 = (short) (bHorasH2 * bConversorHoras + bMinutosH2);
		if (shMinutosTotalH1 > shMinutosTotalH2) {
			bHorasDiferencia = (byte) ((shMinutosTotalH1 - shMinutosTotalH2) / bConversorHoras);
			bMinutosDiferencia = (byte) ((shMinutosTotalH1 - shMinutosTotalH2) % bConversorHoras);
		} else {
			bHorasDiferencia = (byte) ((shMinutosTotalH2 - shMinutosTotalH1) / bConversorHoras);
			bMinutosDiferencia = (byte) ((shMinutosTotalH2 - shMinutosTotalH1) % bConversorHoras);
		}

//		Enseniar por consola el resultaldo
		if (shMinutosTotalH1 > shMinutosTotalH2) {
			System.out.println(
					"\n"+"La hora H1 es posterior a la hora H2 en " + bHorasDiferencia + " horas y " + bMinutosDiferencia+" minutos.");
		} else if (shMinutosTotalH1 < shMinutosTotalH2) {
			System.out
					.println("\n"+"La hora H1 es anterior a la hora H2 en " + bHorasDiferencia + " horas y " + bMinutosDiferencia+" minutos.");
		} else {
			System.out.println("\n"+"La hora H1 es igual a la hora H2");
		}
	}
}
