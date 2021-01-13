import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B7_EJ27 {

	public static void main(String[] args) {
		char cLetraGrupo = pideGrupo("Introduce el grupo ", "Ese grupo no existe, intentelo de nuevo\n", 'A', 'D');
		byte bAlumnos = cuantosAlumnos(cLetraGrupo), bContadorSuspenso = 0;
		float fNotaMedia, fNotaMediaAlumnoMax = 0;
		String sNombreAlumno, sMejorAlumno = "";
		boolean booSobresaliente = false, booMasDeUnMejorAlumno = false;
		
		for (byte bContador = 0; bContador < bAlumnos; bContador++) {
			System.out.println("\nAlumno "+(bContador + 1));
			sNombreAlumno = (leer("Introduce el nombre: ", -1, -1, -1, -1, (byte) 9)).toString();
			fNotaMedia = notaMedia((byte) 3);
			
			if (fNotaMedia > fNotaMediaAlumnoMax) {
				sMejorAlumno = sNombreAlumno;
				fNotaMediaAlumnoMax = fNotaMedia;
				booMasDeUnMejorAlumno = false;
				
			} else if (fNotaMedia == fNotaMediaAlumnoMax) {
				sMejorAlumno += ", "+sNombreAlumno;
				booMasDeUnMejorAlumno = true;
			}
			
			if (fNotaMedia < 5) {
				bContadorSuspenso++;
			}
			
			if (fNotaMedia >= 9) {
				booSobresaliente = true;
			}
			
		}
		
		System.out.println("\n"+mensajeFinal(sMejorAlumno, booMasDeUnMejorAlumno, bContadorSuspenso, booSobresaliente));
		
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
	
	private static char pideGrupo(String sMensaje, String sMensajeError, char cMin, char cMax) {
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
	
	private static byte cuantosAlumnos(char cGrupo) {
		byte bNumerosAlumnos;
		
		switch (cGrupo) {
		case 'A':
			bNumerosAlumnos = 25;
			break;
		case 'B':
			bNumerosAlumnos = 28;
			break;
		case 'C':
			bNumerosAlumnos = 31;
			break;
		default:
			bNumerosAlumnos = 29;
		}
		
		return bNumerosAlumnos;
	}
	
	private static float notaMedia(byte bNumeroDeNotas ) {
		float fNotaAlumnoTotal = 0;
		
		for (byte bContador = 0; bContador < bNumeroDeNotas; bContador++) {
			fNotaAlumnoTotal += (float) leer("Introduce la nota del trimestre "+(bContador + 1)+": ", -1, -1, 0, 10, (byte) 5);
		}
		 return 		fNotaAlumnoTotal / bNumeroDeNotas;
	}
	
	private static String mensajeFinal(String sMejorAlumno, boolean booMasDeUnMejorAlumno, byte bSuspensos, boolean booSobresaliente) {
		String sMensaje;
		
		if (booMasDeUnMejorAlumno) {
			sMensaje = "Los alumnos con mejor nota son "+sMejorAlumno+".\n";
		} else {
			sMensaje = "El alumno con mejor nota es "+sMejorAlumno+".\n";
		}
		
		if (bSuspensos > 0) {
			sMensaje += bSuspensos+" alumnos han suspendido.\n";
		} else {
			sMensaje +="No hay suspensos.\n";
		}
		
		if (booSobresaliente) {
			sMensaje += "Existen Sobresalientes";
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
