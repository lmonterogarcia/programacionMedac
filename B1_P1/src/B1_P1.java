import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_P1 {

	public static void main(String[] args) {
//		Declacion de variables de entrada, internas y salida.
		byte bDiaNacimiento, bMesNacimiento, bdiaActual, bMesActual;
		short shAnioNacimiento, shAnioActual;
		final short SHDIASANIO = 365;
		final byte BDIASMES = 30;
		int iDiasViviendo;

//		Declacion de variables para leer por teclado
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String cadenaLeida;
		
//		Escribir y leer fecha de Nacimiento. 3 variables.
		// Dia
		System.out.print("Introduce el dia del nacimiento (1...31): ");
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		bDiaNacimiento=Byte.parseByte(cadenaLeida);
		// Mes
		System.out.print("Introduce el mes del nacimiento (1...12): ");
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		bMesNacimiento=Byte.parseByte(cadenaLeida);
		// Anio
		System.out.print("Introduce el anio del nacimiento (1...2020): ");
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		shAnioNacimiento=Short.parseShort(cadenaLeida);
		
//		Escribir y leer fecha Actual. 3 variables.
		// Dia
		System.out.print("Introduce el dia actual (1...31): ");
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		bdiaActual=Byte.parseByte(cadenaLeida);
		// Mes
		System.out.print("Introduce el mes actual (1...12): ");
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		bMesActual=Byte.parseByte(cadenaLeida);
		// Anio
		System.out.print("Introduce el anio actual (2020): ");
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		shAnioActual=Short.parseShort(cadenaLeida);
		
//		Calcular numero de dias vividos y asignarlo a la variable. Los a�os son 365 y los meses son 30 dias.
		iDiasViviendo=(shAnioActual-shAnioNacimiento)*SHDIASANIO+(bMesActual-bMesNacimiento)*BDIASMES+(bdiaActual-bDiaNacimiento);
		
//		Escribir por consola el resutlado de los dias viviendo de la persona
		System.out.println("Esta persona ha vivido "+iDiasViviendo+" Dias.");
	}

}
