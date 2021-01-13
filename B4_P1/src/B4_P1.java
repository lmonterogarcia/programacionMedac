import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B4_P1 {

	public static void main(String[] args) {
		String sResultado = "";
		do {
			sResultado = menuFormulas((byte) leer(
					"Menu para B4_P1\n############\n1. Funcion de Legendre\n2. Suma en coma flotante\n3. Serie de Fibonacci\n4. Multiplicacion en coma flotante\n5. Salir\nElija una opcion ",
					1, 5, -1, -1, (byte) 1));
			if (sResultado != "salir") {
				System.out.println(sResultado);
				pulsarEnterParaContinuar("\nPulsa Enter para mostrar el Menu");
			}
		} while (sResultado != "salir");
		System.out.println("\nHasta Luego.");
	}

//	FuncionMenu
	private static String menuFormulas(byte bFormula) {
		String sResultado;
		switch (bFormula) {
		case 1:
			sResultado = seriePolinomiosLegendre();
			break;
		case 2:
			sResultado = "La suma es " + sumaComaFlotante(
					(long) leer("Introduzca el numero de sumandos ", 2, 1999999999, -1, -1, (byte) 4));
			break;
		case 3:
			sResultado = serieFibonacci();
			break;
		case 4:
			sResultado = "La multiplicacion es " + multiplicacionComaFlotante(
					(long) leer("Introduzca el numero de sumandos ", 2, 1999999999, -1, -1, (byte) 4));
			break;
		default:
			sResultado = "salir";
		}
		return sResultado;

	}

//	Funcion para calcular un solo polinomio segun n y x
	private static double funcionLegendre(double dNumeroN, double dNumeroX) {
		if (dNumeroN == 0) {
			return 1;
		} else if (dNumeroN == 1) {
			return dNumeroX;
		} else {
			return (((((2 * dNumeroN - 1) / dNumeroN) * dNumeroX) * funcionLegendre((dNumeroN - 1), dNumeroX))
					- (((dNumeroN - 1) / dNumeroN) * funcionLegendre((dNumeroN - 2), dNumeroX)));
		}
	}

//	Funcion para crear una serie de polinomios de Legendre
	private static String seriePolinomiosLegendre() {
		String sSerieLegendre = "";
		double dNumeroX = (double) leer("\nIntroduce el valor de X ", -1, -1, -1, 1, (byte) 7);
		byte bNumeroN = (byte) leer("Introduce el valor de n ", 0, 45, -1, -1, (byte) 1);
		System.out.println("");
		for (byte bContador = 0; bContador <= bNumeroN; bContador++) {
			sSerieLegendre += "Polinomio de Legendre de x=" + dNumeroX + " y para n=" + bContador + " es "
					+ funcionLegendre((double) bContador, dNumeroX) + "\n";
		}
		return sSerieLegendre;
	}

//	Funcion para suma de n numeros en coma flotante
	private static double sumaComaFlotante(long lNumerosSumandos) {
		double dSumando, dResultado = 0;
		for (long lContador = 1; lContador <= lNumerosSumandos; lContador++) {
			dSumando = (double) leer("Introduce el sumando " + lContador, -1, -1, -999999999.0, 999999999.0, (byte) 6);
			dResultado += dSumando;
		}
		return dResultado;
	}

//	Funcion para clacular un solo numero de Fibonacci segun n.
	private static double numeroFibonacci(short shNumerosTermino) {
		double dNumeroTermino1, dNumeroTermino2 = -1, dFibonacci = 1;
		for (short shContadorTerminos = 0; shContadorTerminos <= shNumerosTermino; shContadorTerminos++) {
			dNumeroTermino1 = dNumeroTermino2;
			dNumeroTermino2 = dFibonacci;
			dFibonacci = dNumeroTermino1 + dNumeroTermino2;
		}
		return dFibonacci;
	}

//	Funcion para la creacion de la serie Fibonacci
	private static String serieFibonacci() {
		short shNumeroDeTerminos = (short) leer("\nIntroduce el numero de terminos de la serie Fibonacci ", 1, 1000, -1,
				-1, (byte) 2);
		String sSerieFibonacci = "";
		for (short shContadorTerminos = 0; shContadorTerminos <= (shNumeroDeTerminos); shContadorTerminos++) {
			sSerieFibonacci += numeroFibonacci(shContadorTerminos) + ", ";
		}

		return (sSerieFibonacci.substring(0, sSerieFibonacci.length() - 2) + ".");
	}

//	Funcion para multiplicar n numeros
	private static double multiplicacionComaFlotante(long lNumeros) {
		double dNumero, dResultado = 1;
		for (long lContador = 1; lContador <= lNumeros; lContador++) {
			dNumero = (double) leer("Introduce el numero " + lContador, -1, -1, -999999999.0, 999999999.0, (byte) 6);
			dResultado *= dNumero;
		}
		return dResultado;
	}

//	Funicon para pausar el programa hasta pulsar enter
	private static void pulsarEnterParaContinuar(String sMensaje) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(sMensaje);
		try {
			teclado.readLine();
		} catch (Exception e) {

		}
	}

	/*
	 * 
	 * ############ # LIBRERIA LEER # ############
	 * 
	 */

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

}
