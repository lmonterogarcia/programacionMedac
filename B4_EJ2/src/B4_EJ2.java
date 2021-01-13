import java.io.BufferedReader;
import java.io.InputStreamReader;


public class B4_EJ2 {

	public static void main(String[] args) {
		byte bEleccion = 0;
		do {
			bEleccion = (byte) leer("CALCULADORA\n##############\n1. Suma\n2. Resta\n3. Multiplicacion\n4. Division\n5. Resto\n6. Salir\nElija opcion", (byte) 1,(byte) 6, -1, -1, (byte) 1);
			if (bEleccion != 6) {
			System.out.println(mostrarResutlado(calculadora(bEleccion,
					(float) leer("\nIntroduzca el primer numero ", -1, -1, -30000.0, 30000.0, (byte) 5),
					(float) leer("Introduzca el segundo numero ", -1, -1, -30000.0, 30000.0, (byte) 5))));
			pulsarEnterParaContinuar("\nPulsa Entrer para continuar");
			
			}
		} while (bEleccion != 6);	
		System.out.println("\nHasta Luego.");
		
	}
//	Funcion Menu para la calculadora
	private static Float calculadora(byte bEleccionOperador, float fNumero1, float fNumero2) {
		float fResultado = 0;
		switch (bEleccionOperador) {
		case 1:
			fResultado = fNumero1 + fNumero2;
			break;
		case 2:
			fResultado = fNumero1 - fNumero2;
			break;
		case 3:
			fResultado = fNumero1 * fNumero2;
			break;
		case 4:
			if (fNumero2 == 0) {
				fResultado = fNumero1 / fNumero2;
			} else {
				fResultado = fNumero1 / fNumero2;
			}
			break;
		default:
			if (fNumero2 == 0) {
				fResultado = fNumero1 % fNumero2;
			} else {
				fResultado = fNumero1 % fNumero2;
			}
		}
		return fResultado;
	}

//	Funcion para pausar el programa hasta pulsar enter
	private static void pulsarEnterParaContinuar(String sMensaje) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(sMensaje);
		try {
			teclado.readLine();
		} catch (Exception e) {

		}
	}
	
//	Funcion para mostar el resultado en un String de la calculadora
	private static String mostrarResutlado(float fResultado) {
		String sResultado;
		if (Float.isNaN(fResultado)) {
			sResultado = "\nERROR. Operacion con resultado indefinido. ";
		} else if (Float.isInfinite(fResultado)) {
			sResultado = "\nERROR. Operacion con resultado infinito. ";
		} else {
			sResultado = "\nEl resultado es: "+fResultado;
		}
	return sResultado;
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
