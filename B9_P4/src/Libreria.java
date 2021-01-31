import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Libreria {

	/*
	 * ############ ### LIBRERIA LEER ### ############
	 */

	// Leer VARIABLE SIMPLE
	public static Object leer(String sMensaje, long lMinimo, long lMaximo, double dMinimo, double dMaximo,
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
			System.out.print(sMensaje + " (maximo " + lMax + " caracteres): ");
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

	public static String deNumeroToLetrasHasta9999(short shNumero) {
		String sNumero = "";
		byte bUnidad, bDecena, bCentena, bMillar;

		if (shNumero < 1000) {
			sNumero = deNumeroToLetrasHasta999(shNumero);
		} else {
			bUnidad = (byte) (shNumero % 10);
			bDecena = (byte) (((short) (shNumero / 10)) % 10);
			bCentena = (byte) (((byte) (shNumero / 100)) % 10);
			bMillar = (byte) (shNumero / 1000);

			switch (bMillar) {
			case 1:
				sNumero = "mil";
				if (bUnidad != 0 || bDecena != 0 || bCentena != 0) {
					sNumero += " " + deNumeroToLetrasHasta999((short) ((bCentena * 100) + (bDecena * 10) + bUnidad));
				}
				break;
			default:
				sNumero = deNumeroToLetrasHasta15(bMillar) + "mil";
				if (bUnidad != 0 || bDecena != 0 || bCentena != 0) {
					sNumero += " " + deNumeroToLetrasHasta999((short) ((bCentena * 100) + (bDecena * 10) + bUnidad));
				}
			}
		}

		return sNumero;
	}

	private static String deNumeroToLetrasHasta999(short shNumero) {
		String sNumero = "";
		byte bUnidad, bDecena, bCentena;

		if (shNumero < 100) {
			sNumero = deNumeroToLetrasHasta99((byte) shNumero);
		} else {
			bUnidad = (byte) (shNumero % 10);
			bDecena = (byte) (((byte) (shNumero / 10)) % 10);
			bCentena = (byte) (shNumero / 100);

			switch (bCentena) {
			case 1:
				if (bUnidad != 0 && bDecena != 0) {
					sNumero = "cien";
				} else {
					sNumero = "ciento " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			case 2:
				sNumero = "doscientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			case 3:
				sNumero = "trescientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			case 4:
				sNumero = "cuatrocientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			case 5:
				sNumero = "quinientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			case 6:
				sNumero = "seiscientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			case 7:
				sNumero = "setecientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			case 8:
				sNumero = "ochocientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			default:
				sNumero = "novecientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
			}
		}

		return sNumero;
	}

	private static String deNumeroToLetrasHasta99(byte bNumero) {
		String sNumero = "";
		byte bUnidad, bDecena;

		if (bNumero < 16) {
			sNumero = deNumeroToLetrasHasta15(bNumero);
		} else {
			bUnidad = (byte) (bNumero % 10);
			bDecena = (byte) (bNumero / 10);

			switch (bDecena) {
			case 1:
				sNumero = "dieci" + deNumeroToLetrasHasta15(bUnidad);
				break;
			case 2:
				if (bUnidad != 0) {
					sNumero = "veinti" + deNumeroToLetrasHasta15(bUnidad);
				} else {
					sNumero = "veinte";
				}
				break;
			case 3:
				sNumero = "treinta";
				if (bUnidad != 0) {
					sNumero += " y " + deNumeroToLetrasHasta15(bUnidad);
				}
				break;
			case 4:
				sNumero = "cuarenta";
				if (bUnidad != 0) {
					sNumero += " y " + deNumeroToLetrasHasta15(bUnidad);
				}
				break;
			case 5:
				sNumero = "cincuenta";
				if (bUnidad != 0) {
					sNumero += " y " + deNumeroToLetrasHasta15(bUnidad);
				}
				break;
			case 6:
				sNumero = "sesenta";
				if (bUnidad != 0) {
					sNumero += " y " + deNumeroToLetrasHasta15(bUnidad);
				}
				break;
			case 7:
				sNumero = "setenta";
				if (bUnidad != 0) {
					sNumero += " y " + deNumeroToLetrasHasta15(bUnidad);
				}
				break;
			case 8:
				sNumero = "ochenta";
				if (bUnidad != 0) {
					sNumero += " y " + deNumeroToLetrasHasta15(bUnidad);
				}
				break;
			default:
				sNumero = "noventa";
				if (bUnidad != 0) {
					sNumero += " y " + deNumeroToLetrasHasta15(bUnidad);
				}
			}
		}

		return sNumero;
	}

	private static String deNumeroToLetrasHasta15(byte bNumero) {
		String sNumero;

		switch (bNumero) {
		case 0:
			sNumero = "cero";
			break;
		case 1:
			sNumero = "uno";
			break;
		case 2:
			sNumero = "dos";
			break;
		case 3:
			sNumero = "tres";
			break;
		case 4:
			sNumero = "cuatro";
			break;
		case 5:
			sNumero = "cinco";
			break;
		case 6:
			sNumero = "seis";
			break;
		case 7:
			sNumero = "siete";
			break;
		case 8:
			sNumero = "ocho";
			break;
		case 9:
			sNumero = "nueve";
			break;
		case 10:
			sNumero = "diez";
			break;
		case 11:
			sNumero = "once";
			break;
		case 12:
			sNumero = "doce";
			break;
		case 13:
			sNumero = "trece";
			break;
		case 14:
			sNumero = "catorce";
			break;
		default:
			sNumero = "quince";
		}

		return sNumero;
	}

	private static String primeraLetraMayus(String sCadena) {
		String sMensaje, cLetra = Character.toString(sCadena.charAt(0));

		sMensaje = cLetra.toUpperCase() + sCadena.substring(1, sCadena.length());

		return sMensaje;
	}
}
