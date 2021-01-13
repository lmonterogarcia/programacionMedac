import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B7_EJ48 {

	public static void main(String[] args) {
		byte bCoeficienteA = (byte) leer("Introduce el ceoficiente A ", -120, 120, -1, -1, (byte) 1), bCoeficienteB = (byte) leer("Introduce el ceoficiente B ", -120, 120, -1, -1, (byte) 1), bCoeficienteC = (byte) leer("Introduce el ceoficiente C ", -120, 120, -1, -1, (byte) 1);

		System.out.println(resolverEcuaconSegundoGrado(bCoeficienteA, bCoeficienteB, bCoeficienteC));
	}

	private static String resolverEcuaconSegundoGrado(byte bCoeficienteA, byte bCoeficienteB, byte bCoeficienteC) {
		String sResultado;
		float fResultado1, fResultado2;
		
		if (bCoeficienteA == 0) {
			sResultado ="Al ser \"a\" igual a cero, se resuelve como una ecuacion de primer grado.\nEl resultado es "+((float) (-1 * bCoeficienteC) / bCoeficienteB);
		} else if (Math.pow(bCoeficienteB, 2) - (4*bCoeficienteA*bCoeficienteC) < 0) {
			sResultado = "No hay resultados reales, ya que "+bCoeficienteB+"^2 - (4 x "+bCoeficienteA+" x "+bCoeficienteC+") es negativo "+(Math.pow(bCoeficienteB, 2) - (4*bCoeficienteA*bCoeficienteC)); 
		} else {
			fResultado1 = (float) (((-1 * bCoeficienteB) + (Math.pow((Math.pow(bCoeficienteB, 2) - (4*bCoeficienteA*bCoeficienteC)), 0.5))) / (2*bCoeficienteA));
			fResultado2 = (float) (((-1 * bCoeficienteB) - (Math.pow((Math.pow(bCoeficienteB, 2) - (4*bCoeficienteA*bCoeficienteC)), 0.5))) / (2*bCoeficienteA));
			
			sResultado = "Los resultados de esta ecuaion de segundo grado son:\nX1 = "+fResultado1+"\nX2 = "+fResultado2;
		}
		
		return sResultado;
	}
	
	/*
	 * #####################################
	 * ############ # LIBRERIA LEER # ############
	 * #####################################
	 */

	
	// Leer VARIABLE SIMPLE###########################################################
	private static Object leer(String sMensaje, long lMinimo, long lMaximo, double dMinimo, double dMaximo,
			byte bEstado) {
		Object oNumero;
		switch (bEstado) {
		case 1:
			oNumero = pideNumeroByte(sMensaje, lMinimo, lMaximo);
			break;
		case 2:
			oNumero = pideNumeroShort(sMensaje, lMinimo, lMaximo);
			break;
		case 3:
			oNumero = pideNumeroInt(sMensaje, lMinimo, lMaximo);
			break;
		case 4:
			oNumero = pideNumeroLong(sMensaje, lMinimo, lMaximo);
			break;
		case 5:
			oNumero = pideNumeroFloat(sMensaje, dMinimo, dMaximo);
			break;
		case 6:
			oNumero = pideNumeroDouble(sMensaje, dMinimo, dMaximo);
			break;
		case 7:
			oNumero = pideNumeroDoubleNoInclusivo(sMensaje, dMinimo, dMaximo);
			break;
		case 8:
			oNumero = pideChar(sMensaje);
			break;
		case 9:
			oNumero = pideString(sMensaje);
			break;
		case 10:
			oNumero = pideStringMax(sMensaje, lMaximo);
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
			System.out.print(sMensaje + "(" + lMinimo + " a " + lMaximo + "): ");
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
			System.out.print(sMensaje + "(" + lMinimo + " a " + lMaximo + "): ");
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
			System.out.print(sMensaje + "(" + lMinimo + " a " + lMaximo + "): ");
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
			System.out.print(sMensaje + "(" + lMinimo + " a " + lMaximo + "): ");
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
			System.out.print(sMensaje + "(" + dMinimo + " a " + dMaximo + "): ");
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
			System.out.print(sMensaje + "(" + dMinimo + " a " + dMaximo + "): ");
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

//	Nueva funcion para Libreria Leer. Lee un double dentro de un rango sin llegar a los limites
	private static double pideNumeroDoubleNoInclusivo(String sMensaje, double dMinimo, double dMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		double dNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "(no inclusivo entre " + dMinimo + " y " + dMaximo + "): ");
			try {
				dNumero = Double.parseDouble(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
			if (bFallo || (dNumero <= dMinimo || dNumero >= dMaximo)) {
				System.err.println("Numero fuera de rango o caracter invalido");
			}
		} while (bFallo || (dNumero <= dMinimo || dNumero >= dMaximo));

		return dNumero;
	}
	
	private static char pideChar(String sMensaje) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;
		char cCaracter;
		boolean booCorrecto;

		do {
			System.out.print(sMensaje);
			try {
				sCadenaLeida = teclado.readLine();
				cCaracter = sCadenaLeida.charAt(0);
				booCorrecto = true;
			} catch (Exception e) {
				sCadenaLeida = "-1";
				cCaracter = 'e';
				booCorrecto = false;
			}
		} while (!booCorrecto || sCadenaLeida.length() != 1);

		return cCaracter;
	}
	
	private static String pideString(String sMensaje) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;
		System.out.print(sMensaje);
		boolean booCorrecto;
		
		do {
			try {
				sCadenaLeida = teclado.readLine();
				booCorrecto = true;
			} catch (Exception e) {
				sCadenaLeida = "-1";
				booCorrecto = false;
			}
		} while (!booCorrecto);

		return sCadenaLeida;
	}
	
	private static String pideStringMax(String sMensaje, long lMax) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;
		boolean booCorrecto;
		
		do {
			System.out.print(sMensaje+" (maximo "+lMax+" caracteres): ");
			try {
				sCadenaLeida = teclado.readLine();
				booCorrecto = true;
			} catch (Exception e) {
				sCadenaLeida = "-1";
				booCorrecto = false;
			}
			
			if (sCadenaLeida.length() > lMax) {
				System.out.println("Ha sperado el maximo de caracteres, pruebe de nuevo.");
			}
		} while (!booCorrecto && sCadenaLeida.length() > lMax);

		return sCadenaLeida;
	}
	
}
