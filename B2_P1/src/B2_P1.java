import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_P1 {

	public static void main(String[] args) {
//		Declaracion de variables
		byte bEleccion, bContadorNumero, bContadorFila, bContadorPrimo;
		boolean booEsPrimo;
		String sSerie = "\n";
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir al usuario que introduzca el numero para el menu
		do {
			System.out.print("1. Mostras triangulo original" + "\n"
					+ "2. Mostrar el triangulo eliminando los numeros primos y sustituyendolos por asteriscos" + "\n"
					+ "3. Mostrar el triangulo eliminando los no numeros primos y sustituyendolos por asteriscos" + "\n"
					+ "\n" + "Seleccione una opcion del menu de arriba (1...3): ");
			try {
				bEleccion = Byte.parseByte(teclado.readLine());
			} catch (Exception e) {
				bEleccion = -1;
			}
			if (bEleccion < 1 || bEleccion > 3) {
				System.out.println("\n" + "ELECCION INCORRECTA." + "\n");
			}
		} while (bEleccion < 1 || bEleccion > 3);

//		Construir la piramide dependiendo de la eleccion del usuario
		switch (bEleccion) {
		case 1:
			for (bContadorFila = 1; bContadorFila * 2 <= 10; bContadorFila++) {
				for (bContadorNumero = bContadorFila; bContadorNumero < 10; bContadorNumero += bContadorFila) {
					sSerie += bContadorNumero;
				}
				sSerie += "\n";
			}
			break;
		// EL NUMERO 1 NO ES PRIMO POR DEFINICION
		case 2:
			for (bContadorFila = 1; bContadorFila * 2 <= 10; bContadorFila++) {
				for (bContadorNumero = bContadorFila; bContadorNumero < 10; bContadorNumero += bContadorFila) {
					if (bContadorNumero > 1) {
						bContadorPrimo = 2;
						booEsPrimo = true;
						while (bContadorPrimo < bContadorNumero && booEsPrimo) {
							if (bContadorNumero % bContadorPrimo == 0) {
								booEsPrimo = false;
							}
							bContadorPrimo++;
						}
						if (booEsPrimo) {
							sSerie += "*";
						} else {
							sSerie += bContadorNumero;
						}
					} else {
						sSerie += bContadorNumero;
					}
				}
				sSerie += "\n";
			}
			break;
		// EL NUMERO 1 NO ES PRIMO POR DEFINICION
		default:
			for (bContadorFila = 1; bContadorFila * 2 <= 10; bContadorFila++) {
				for (bContadorNumero = bContadorFila; bContadorNumero < 10; bContadorNumero += bContadorFila) {
					if (bContadorNumero > 1) {
						bContadorPrimo = 2;
						booEsPrimo = true;
						while (bContadorPrimo < bContadorNumero && booEsPrimo) {
							if (bContadorNumero % bContadorPrimo == 0) {
								booEsPrimo = false;
							}
							bContadorPrimo++;
						}
						if (booEsPrimo) {
							sSerie += bContadorNumero;
						} else {
							sSerie += "*";
						}
					} else {
						sSerie += "*";
					}
				}
				sSerie += "\n";
			}
			break;
		}

//		Imprimir por pantalla el resultado
		System.out.println(sSerie);
	}
}
