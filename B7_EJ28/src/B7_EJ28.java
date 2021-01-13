import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B7_EJ28 {

	public static void main(String[] args) {
		
		final byte BGRANALTURA =30;
		short shNumeroArboles = (short) leer("Introduce el numero de arboles ", 1, 1000, -1, -1, (byte) 2), shEdad, shContadorTipoB = 0;
		int iEdadTotal= 0;
		float fdiametroMt, fDiametroMaxMt = 0.05f, fDiametroMinMt = 15 , fAlturaMt, fMediaAlturaMt, fAlturaMaxMt = 1.20f, fAlturaMinMt =120, fAlturaTotal = 0, fEdadMedia;
		char cTipoArbol;
		boolean booArbolMas30Metros = false;
		
		for (short shContador = 1; shContador <= shNumeroArboles; shContador++) {
			System.out.println("\nArbol "+shContador+":");
			cTipoArbol = pideArbol("Tipo de Arbol ", "Tipo de arbol incorrecto, intentelo de nuevo\n", 'A', 'B');
			fdiametroMt = (float) leer("Introduce el diametro (metros)", -1, -1, 0.05, 15, (byte) 5);
			fAlturaMt = (float) leer("Introduce la altura (metros)", -1, -1, 1.20, 120, (byte) 5);
			fAlturaTotal += fAlturaMt;
			if (cTipoArbol == 'B') {
				shEdad = (short) leer("Introduce la edad ", 0, 4000, -1, -1, (byte) 2);
				iEdadTotal += shEdad;
				shContadorTipoB++;
			}
			
			if (fdiametroMt < fDiametroMinMt) {
				fDiametroMinMt = fdiametroMt;
			}
			
			if (fdiametroMt > fDiametroMaxMt) {
				fDiametroMaxMt = fdiametroMt;
			}
			
			if (fAlturaMt < fAlturaMinMt) {
				fAlturaMinMt = fAlturaMt;
			}
			
			if (fAlturaMt > fAlturaMaxMt) {
				fAlturaMaxMt = fAlturaMt;
			}
			
			if (fAlturaMt >= BGRANALTURA) {
				booArbolMas30Metros = true;
			}
			
		}
		
		fMediaAlturaMt = fAlturaTotal / shNumeroArboles;
		fEdadMedia = iEdadTotal / shNumeroArboles;
		
		System.out.println("\n"+mensajeFinal(fDiametroMinMt, fDiametroMaxMt, fAlturaMinMt, fAlturaMaxMt, fMediaAlturaMt, fEdadMedia, shContadorTipoB, booArbolMas30Metros, BGRANALTURA));
		
	}
	

	/*
	 * ########################################
	 * ##### # Funciones especificas para este programa  # #####
	 * ########################################
	 *
	 *
	 *Siempre el codigo es creado para ser reutilizado. Por lo que la mayoria de las veces el tipado es int,
	 *a no ser que sea muy especifica del Ejercicio/Problema.
	 */
		
	private static char pideArbol(String sMensaje, String sMensajeError, char cMin, char cMax) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sCadenaLeida;
		char cCaracter;
		boolean booCorrecto;

		do {
			System.out.print(sMensaje+"("+cMin+"-"+cMax+"): ");
			try {
				sCadenaLeida = teclado.readLine();
				cCaracter = (sCadenaLeida.toUpperCase()).charAt(0);
				booCorrecto = true;
			} catch (Exception e) {
				sCadenaLeida = "-1";
				cCaracter = 'e';
				booCorrecto = false;
			}
			
			if (cCaracter < cMin || cCaracter > cMax) {
				System.out.println(sMensajeError);
			}
			
		} while ((!booCorrecto || (cCaracter < cMin || cCaracter > cMax)));

		return cCaracter;
	}

	private static String mensajeFinal(float fDiametroMinMt, float fDiametroMaxMt, float fAlturaMinMt, float fAlturaMaxMt, float fMediaAlturaMt, float fEdadMedia, short shContadorTipoB, boolean booArbolMas30Metros, byte BGRANALTURA) {
		String sMensaje;
		
		sMensaje = "\nAltura media: "+fMediaAlturaMt+"\nAltura maxima: "+fAlturaMaxMt+"\nAltura minima: "+fAlturaMinMt+"\nDiametro maximo: "+fDiametroMaxMt+"\nDiametro minimo: "+fDiametroMinMt;
		
		if (shContadorTipoB > 0) {
			sMensaje += "\nEdadMeida de los arboles tipo B: "+fEdadMedia;
		}
		
		if (booArbolMas30Metros) {
			sMensaje += "\nExisten arboles de mas de "+BGRANALTURA;
		}
		
		return sMensaje;
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
		
		boolean booCorrecto;
		
		do {
			System.out.print(sMensaje);
			try {
				sCadenaLeida = teclado.readLine();
				booCorrecto = true;
			} catch (Exception e) {
				sCadenaLeida = "-1";
				booCorrecto = false;
			}
		} while (!booCorrecto || sCadenaLeida.length() < 1);

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
