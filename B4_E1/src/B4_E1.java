import java.io.*;

public class B4_E1 {

	public static void main(String[] args) {
		byte bNumero1 = (byte) leer("Introduce un numero entero positivo ", (long) 1, (long) 50,-1,-1, (byte) 1);
		byte bNumero2 = (byte) leer("Dame un numero o plomo: ", (long) 1, (long) 10,-1,-1, (byte) 1);
		short shNumero3 = (short) leer("Dame ahora un short: ", (long) 1, (long) 50,-1,-1, (byte) 2);

		System.out.println("El valor mayor es:" + esMayor(bNumero1, bNumero2));
		System.out.println("El valor menor es:" + esMenor(bNumero1, bNumero2));
		System.out.println("El valor del short es: " + shNumero3);
	}

	private static int esMayor(byte bNumero1, byte bNumero2) {
		int bEsMayor;
		if (bNumero1 > bNumero2) {
			bEsMayor = bNumero1;
		} else {
			bEsMayor = bNumero2;
		}
		return bEsMayor;
	}

	private static int esMenor(byte bNumero1, byte bNumero2) {
		int bEsMenor;
		if (bNumero1 < bNumero2) {
			bEsMenor = bNumero1;
		} else {
			bEsMenor = bNumero2;
		}
		return bEsMenor;
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
			if (bNumero < lMinimo || bNumero > lMaximo) {
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
			if (shNumero < lMinimo || shNumero > lMaximo) {
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
			if (iNumero < lMinimo || iNumero > lMaximo) {
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
			if (lNumero < lMinimo || lNumero > lMaximo) {
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
			if (fNumero < dMinimo || fNumero > dMaximo) {
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
			if (dNumero < dMinimo || dNumero > dMaximo) {
				System.err.println("Numero fuera de rango o caracter invalido");
			}
		} while (bFallo || (dNumero < dMinimo || dNumero > dMaximo));

		return dNumero;
	}

}
