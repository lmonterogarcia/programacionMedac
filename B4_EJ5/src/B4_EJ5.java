import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B4_EJ5 {

	public static void main(String[] args) {
		int iNumero = (int)leer("Introduce un numero entero ",0,170,-1,-1,(byte)3);
		System.out.println("\nEl resultado de "+iNumero+" factorial es "+factorial(iNumero));

	}

//	Funcion para calcular el factorial de n
	private static double factorial(int iNumero) {
		double dResutladoFactorial = 1;
		for (int iContador = 1; iContador <= iNumero; iContador++) {
			dResutladoFactorial *= iContador;
		}
		return dResutladoFactorial;
	}
	
/*
 * 
 *    ############
 *    #LIBRERIA  LEER#
 *    ############
 * 
 */
	
	private static Object leer(String sMensaje, long lMinimo, long lMaximo, double dMinimo, double dMaximo, byte bEstado) {
		Object oNumero;
		switch(bEstado) {
		case 1:
			oNumero = pideNumeroByte(sMensaje,lMinimo,lMaximo);
			break;
		case 2:
			oNumero = pideNumeroShort(sMensaje,lMinimo,lMaximo);
			break;
		case 3:
			oNumero = pideNumeroInt(sMensaje,lMinimo,lMaximo);
			break;
		case 4:
			oNumero = pideNumeroLong(sMensaje,lMinimo,lMaximo);
			break;
		case 5:
			oNumero = pideNumeroFloat(sMensaje,dMinimo,dMaximo);
			break;
		case 6:
			oNumero = pideNumeroDouble(sMensaje,dMinimo,dMaximo);
			break;
		default:
			oNumero = -1;
		}
		return oNumero;
	}

	private static byte pideNumeroByte(String sMensaje, long lMinimo, long lMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		byte bNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "("+lMinimo+" - " +lMaximo+"): ");
			try {
				bNumero = Byte.parseByte(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
			if (bFallo || (bNumero < lMinimo || bNumero > lMaximo)) {
				System.err.println("Numero fuera de rango o caracter invalido");
			}
		} while (bFallo || (bNumero < lMinimo || bNumero > lMaximo));

		return bNumero;
	}
	
	private static short pideNumeroShort(String sMensaje, long lMinimo, long lMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		short shNumero = 0;
		boolean bFallo;
		
		do {
			System.out.print(sMensaje + "("+lMinimo+" - " +lMaximo+"): ");
			try {
				shNumero = Short.parseShort(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
			if (bFallo || (shNumero < lMinimo || shNumero > lMaximo)) {
				System.err.println("Numero fuera de rango o caracter invalido");
			}
		} while (bFallo || (shNumero < lMinimo || shNumero > lMaximo));

		return shNumero;
	}
	
	private static int pideNumeroInt(String sMensaje, long lMinimo, long lMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		int iNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "("+lMinimo+" - " +lMaximo+"): ");
			try {
				iNumero = Integer.parseInt(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
			if (bFallo || (iNumero < lMinimo || iNumero > lMaximo)) {
				System.err.println("Numero fuera de rango o caracter invalido");
			}
		} while (bFallo || (iNumero < lMinimo || iNumero > lMaximo));

		return iNumero;
	}
	
	private static long pideNumeroLong(String sMensaje, long lMinimo, long lMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		long lNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "("+lMinimo+" - " +lMaximo+"): ");
			try {
				lNumero = Long.parseLong(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
			if (bFallo || (lNumero < lMinimo || lNumero > lMaximo)) {
				System.err.println("Numero fuera de rango o caracter invalido");
			}
		} while (bFallo || (lNumero < lMinimo || lNumero > lMaximo));

		return lNumero;
	}
	
	private static float pideNumeroFloat(String sMensaje, double dMinimo, double dMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		float fNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "("+dMinimo+" - " +dMaximo+"): ");
			try {
				fNumero = Float.parseFloat(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
			if (bFallo || (fNumero < dMinimo || fNumero > dMaximo)) {
				System.err.println("Numero fuera de rango o caracter invalido");
			}
		} while (bFallo || (fNumero < dMinimo || fNumero > dMaximo));

		return fNumero;
	}
	
	private static double pideNumeroDouble(String sMensaje, double dMinimo, double dMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		double dNumero = 0;
		boolean bFallo;
		
		do {
			System.out.print(sMensaje + "(" + dMinimo + " - " + dMaximo + "): ");
			try {
				dNumero = Double.parseDouble(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
			if (bFallo || (dNumero < dMinimo || dNumero > dMaximo)) {
				System.err.println("Numero fuera de rango o caracter invalido");
			}
		} while (bFallo || (dNumero < dMinimo || dNumero > dMaximo));

		return dNumero;
	}

	
}
