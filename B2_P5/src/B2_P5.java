import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_P5 {

	public static void main(String[] args) {
//		Declarar variables
		int iNumeroBinario, iControlBinario;
		short shNumeroDecimal = 0;
		byte bContador = 1, bContadorMax;
		boolean booEsPrimo;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir numero binario y validarlo
		do {
			System.out.print("Introduce el numero binario (0...1111111111): ");
			try {
				iNumeroBinario = Integer.parseInt(teclado.readLine());
			} catch (Exception e) {
				iNumeroBinario = -1;
			}
			// Saber cuantos digitos tiene el numero
			bContadorMax = (byte) Math.ceil(Math.log10(iNumeroBinario + 1));
			// Validar si es primo
			iControlBinario = iNumeroBinario;
			booEsPrimo = true;
			while (booEsPrimo && bContador <= bContadorMax) {
				if (iControlBinario % 10 != 1 && iControlBinario % 10 != 0) {
					booEsPrimo = false;
				}
				iControlBinario = (int) (iControlBinario / 10);
				bContador++;
			}
			if (!booEsPrimo || iNumeroBinario == -1) {
				System.out.print("El numero introducido no es binario, esta fuera de rango o es un caracter invalido. ");
			}
		} while (!booEsPrimo || iNumeroBinario == -1);

//		Calcular el numero en base 10
		iControlBinario = iNumeroBinario;
		for (bContador = 1; bContador <= bContadorMax; bContador++) {
			shNumeroDecimal += ((iControlBinario % 10) * (Math.pow(2, bContador - 1)));
			iControlBinario = iControlBinario / 10;

		}

//		Imprimir por consola el resultado
		System.out.println("El numero binario " + iNumeroBinario + " en base 10 es " + shNumeroDecimal);
	}
}