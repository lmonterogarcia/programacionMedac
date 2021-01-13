import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dados {

	public static void main(String[] args) {
		byte bTiradaDados, bPrimeraPuntacion = 0;
		boolean booTirada1;
		String sMensaje;
		
		do {
			
			booTirada1 = true;
			pulsarEnterParaContinuar("\nPor favor lanza los dados . . .");
			
			do {
				bTiradaDados = tirarDados((byte) 2, (byte) 6);
				if (booTirada1) {
					bPrimeraPuntacion = bTiradaDados;
				}
				sMensaje = mensajeDelJuego(analisisJugada(bTiradaDados, booTirada1, bPrimeraPuntacion));
				booTirada1 = false;
			} while (!finDelJuego(sMensaje, bTiradaDados));
			
		} while (seguirJugando());
		System.out.println("\nHasta luego.");
	}

	
	private static boolean seguirJugando() {
		if (leerCharv2("\nDesea jugar de nuevo? ", 's', 'n') == 's') {
			return true;
		} else {
			return false;
		}
	}

	private static boolean finDelJuego(String sMensaje, byte bTiradaDados) {
		if (sMensaje == "  -  Felicidades! GANASTE en la primera tirada"
				|| sMensaje == "  -  Lo siento! PERDISTE en la primera tirada"
				|| sMensaje == "  -  PIERDES por no igualar tu primera puntuacion"
				|| sMensaje == "  -  GANAS por igualar tu primera puntuacion"){
			System.out.println(bTiradaDados+ sMensaje);
			return true;
		} else {
			pulsarEnterParaContinuar(bTiradaDados+ sMensaje);
			return false;
		}
	}

	private static String mensajeDelJuego(byte bTipoResultado) {
		switch (bTipoResultado) {
		case 1:
			return "  -  Felicidades! GANASTE en la primera tirada";

		case 2:
			return "  -  Lo siento! PERDISTE en la primera tirada";

		case 3:
			return "  -  PIERDES por no igualar tu primera puntuacion";

		case 4:
			return "  -  GANAS por igualar tu primera puntuacion";

		default:
			return "  -  Lanza los dados de nuevo . . .";
		}
	}

	private static byte analisisJugada(byte bPuntacionDados, boolean booTirada1, byte bPrimeraPuntacion) {
		if (booTirada1 && (bPuntacionDados == 7 || bPuntacionDados == 11)) {
			return 1;
		} else if (booTirada1 && (bPuntacionDados == 2 || bPuntacionDados == 3 || bPuntacionDados == 12)) {
			return 2;
		} else if (!booTirada1 && bPuntacionDados == 7) {
			return 3;
		} else if (!booTirada1 && bPuntacionDados == bPrimeraPuntacion) {
			return 4;
		} else {
			return 5;
		}

	}

	private static int numeroAleatorioEntero(int iNumeroMax) {
		return (int) Math.floor(Math.random() * iNumeroMax + 1);
	}

	private static byte tirarDados(byte bDados, byte bLadosDado) {
		byte bResustadoTirada = 0;
		for (byte bContador = 1; bContador <= bDados; bContador++) {
			bResustadoTirada += numeroAleatorioEntero(bLadosDado);
		}
		return bResustadoTirada;
	}

	private static void pulsarEnterParaContinuar(String sMensaje) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(sMensaje);
		try {
			teclado.readLine();
		} catch (Exception e) {

		}
	}

	private static char leerCharv2(String sMensaje, char cMinimo, char cMaximo) {
//		Declarar variables
		char cChar;
		String sCandenaLeida = null;
		boolean booEsCorrecto = false;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir al usuario que teclee el caracter
		do {
			System.out.print(sMensaje + "(" + cMinimo + " - " + cMaximo + "): ");
			try {
				sCandenaLeida = teclado.readLine();
				cChar = sCandenaLeida.charAt(0);
			} catch (Exception e) {
				cChar = 'e';
			}

//				Comprobar que solo ha pulsado una tecla y es una o otra. Ensenia mensaje de error si no se cumple.
			if (((sCandenaLeida.length()) == 1) && (cChar == cMinimo || cChar == cMaximo)) {
				booEsCorrecto = true;
			} else {
				System.err.println("No ha pulsado una tecla correcta\n");
			}
		} while (!booEsCorrecto);

		return cChar;
	}

}
