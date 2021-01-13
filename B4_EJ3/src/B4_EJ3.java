import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B4_EJ3 {

	public static void main(String[] args) {
//		Se puede hacer declarando variables
		
		/*byte bDia = (byte)leer("Introduce el dia ",-100,100,-1,-1,(byte)1 ), bMes = (byte)leer("Introduce el mes ",-100,100,-1,-1,(byte)1 );
		short shAnio =(short)leer("Introduce el anio ",-3000,3000,-1,-1,(byte)2 );
		
		System.out.println(mostrarResultadoFecha( bDia, bMes, shAnio));*/
		
//		O sin declarar y meter la funcion leer() dentro de la funcion mostrarResultadoFecha()
		
		System.out.println(mostrarResultadoFecha( (byte)leer("Introduce el dia ",-100,100,-1,-1,(byte)1 ), (byte)leer("Introduce el mes ",-100,100,-1,-1,(byte)1 ), (short)leer("Introduce el anio ",-3000,3000,-1,-1,(byte)2 )));
	}

//	Funcion que calcula el dia maximo segun anio y mes
	private static byte diasDelMes(byte bMes, short shAnio) {
		byte bDiaMax;
		if (bMes==2) {
			if ((shAnio%4==0 && shAnio%100!=0) || shAnio%400==0) {
				bDiaMax = 29;
			} else {
				bDiaMax = 28;
			}
		} else if (bMes==4 || bMes==6 || bMes==9 || bMes==11) {
			bDiaMax = 30;
		} else {
			bDiaMax = 31;
		}
		return bDiaMax;
	}
	
//	Funcion para calcular si la fecha instroducida es correcta o no
	private static boolean fechaCorrecta(byte bDia, byte bMes, short shAnio) {
		boolean booCorrecto = false;
		if (shAnio >= 1 && (bMes >= 1 && bMes <= 12) && (bDia >=1 && (bDia <= diasDelMes(bMes,shAnio)))) {
			booCorrecto = true;
		}
		return booCorrecto;
	}
	
//	Funcion para mostar el resultado en forma de String
	private static String mostrarResultadoFecha(byte bDia, byte bMes, short shAnio) {
		String sResultado;
		if (fechaCorrecta(bDia,bMes,shAnio) == true) {
			sResultado = "\nLa fecha "+bDia+"/"+bMes+"/"+shAnio+" es CORRECTA.";
		} else {
			sResultado = "\nLa fecha "+bDia+"/"+bMes+"/"+shAnio+" es INCORRECTA";
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
