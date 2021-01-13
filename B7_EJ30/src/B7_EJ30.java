import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B7_EJ30 {

	public static void main(String[] args) {
		byte bRegion = (byte) leer("Introduce la region ", 1, 4, -1, -1, (byte) 1), bProvincias = provinciasDeRegion(bRegion);
		String sNombreProvincia, sGanaVotosA = "", sMasVotosA ="", sGanaVotosB ="", sMasVotosB ="", sEmpate ="";
		int iVotosA, iVotosAMax = 0, iVotosB, iVotosBMax = 0,  iAbstenciones, iTotalVotos =  0, iTotalAbstenciones = 0, iTotal;
		final int IALTAABSTENCION = 100000;
		float fVotos, fAbstenciones;
		boolean booAbstencionesAlto = false;

		for (int bContador = 1; bContador <= bProvincias; bContador++) {
			System.out.println("\nProvincia " + bContador);
			sNombreProvincia = (leer("Introduce el nombre: ", -1, -1, -1, -1, (byte) 9)).toString();
			iVotosA = (int) leer("Introduce los votos del partido A ", 0, 40000000, -1, -1, (byte) 3);
			iVotosB = (int) leer("Introduce los votos del partido B ", 0, 40000000, -1, -1, (byte) 3);
			iAbstenciones = (int) leer("Introduce las abstenciones en esta provincia ", 0, 40000000, -1, -1, (byte) 3);
			iTotalAbstenciones += iAbstenciones;

			iTotalVotos += iVotosA + iVotosB;
			iTotalAbstenciones += iAbstenciones;
			
			if (iVotosA > iVotosAMax) {
				iVotosAMax = iVotosA;
				sMasVotosA = sNombreProvincia;
			}
			
			if (iVotosB > iVotosBMax) {
				iVotosBMax = iVotosB;
				sMasVotosB = sNombreProvincia;
			}
			
			if (iVotosA > iVotosB) {
				sGanaVotosA += sNombreProvincia+", ";
			} else if (iVotosA < iVotosB) {
				sGanaVotosB += sNombreProvincia+", ";
			} else {
				sEmpate += sNombreProvincia+", ";
			}

			if (iAbstenciones > IALTAABSTENCION) {
				booAbstencionesAlto = true;
			}

		}
		
		iTotal = iTotalVotos + iTotalAbstenciones;
		fVotos = (float)iTotalVotos / iTotal;
		fAbstenciones = (float)iTotalAbstenciones / iTotal;
		 
		System.out.println(mensajeFinal(bRegion, fVotos, fAbstenciones, sGanaVotosA, sMasVotosA, sGanaVotosB, sMasVotosB, sEmpate, booAbstencionesAlto));
		
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
	
	private static byte provinciasDeRegion(byte bRegion) {
		byte bProvincias;

		switch (bRegion) {
		case 1:
			bProvincias = 10;
			break;
		case 2:
			bProvincias = 4;
			break;
		case 3:
			bProvincias = 6;
			break;
		default:
			bProvincias = 1;
		}
		
		return bProvincias;
	}
	
	private static String mensajeFinal(byte bRegion, float fVotos, float fAbstenciones, String sGanaVotosA, String sMasVotosA, String sGanaVotosB, String sMasVotosB, String sEmpate, boolean booAbstencionesAlto) {
		String sMensaje;
		
		sMensaje = "\nINFORME DE LA REGION "+bRegion+"\nPorcentaje votos totales: "+fVotos * 100+"%\nPorcentaje de abstenciones: "+fAbstenciones * 100+"%";
		
		if (sMasVotosA != "") {
			sMensaje += "\nProvincia donde el partido A ha obtenido mas votos: "+sMasVotosA;
		}
		
		if (sMasVotosB != "") {
			sMensaje += "\nProvincia donde el partido B ha obtenido mas votos: "+sMasVotosB;
		}
		
		if (sGanaVotosA != "") {
			sMensaje += esPlural("El Partido A ha conseguido mas votos", sGanaVotosA);
		}
		
		if (sGanaVotosB != "") {
			sMensaje += esPlural("El Partido B ha conseguido mas votos", sGanaVotosB);
		}
		
		if (sEmpate != "") {
			sMensaje += esPlural("Los partidos A y B han empatado", sEmpate);
		}
		
		if (booAbstencionesAlto) {
			sMensaje += "\nAlta Abstencion";
		}
		
		return sMensaje;
	}

	private static String esPlural(String sFrase, String sVotos) {
		String sMensaje = "";

		if (masDeUnaProvincia(sVotos)) {
			sMensaje += "\n" + sFrase + " en las provincias de "+ penultimaComaPorY(sVotos.substring(0, sVotos.length() - 2));
		} else {
			sMensaje += "\n" + sFrase + " en la provincia de " + sVotos.substring(0, sVotos.length() - 2);
		}

		return sMensaje;
	}
	
	private static boolean masDeUnaProvincia(String sMasVotos) {
		boolean booMasDeUnaProvincia= false;
		byte bContadorLetras = (byte) (sMasVotos.length() - 3);
		
		do {
			if (sMasVotos.charAt(bContadorLetras) == ' ') {
				booMasDeUnaProvincia = true;
			}
			bContadorLetras--;
		} while (!booMasDeUnaProvincia && bContadorLetras >= 0);
		
		return booMasDeUnaProvincia;
	}
	
	private static String penultimaComaPorY(String sMensaje) {
		String sMensajeConY = sMensaje;
		byte bContadorLetras = (byte) (sMensaje.length() - 3);
		boolean booComa = false;
		
		do {
			if (sMensajeConY.charAt(bContadorLetras) == ',') {
				booComa = true;
			}
			bContadorLetras--;
		} while (!booComa && bContadorLetras >= 0);
		
		sMensajeConY = sMensajeConY.substring(0, bContadorLetras + 1)+" y"+sMensajeConY.substring(bContadorLetras + 2);
		return sMensajeConY;
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
