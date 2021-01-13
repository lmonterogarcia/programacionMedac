import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_E7 {
	public static void main(String[] args) {

		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		int iNumero;
		boolean bEsPrimo = true;
		int iContador;

		try {
			System.out.println("Introduce un numero entero: ");
			iNumero = Integer.parseInt(teclado.readLine());
		} catch (Exception e) {
			iNumero = -1;
		}

		if (iNumero > 1) {
			iContador = 2;
			while (iContador < iNumero && bEsPrimo) {
				if (iNumero % iContador == 0) {
					bEsPrimo = false;
				}
				iContador++;
			}
			
			if(bEsPrimo) {
				System.out.println("El numero "+iNumero+" es primo.");
			}else {
				System.out.println("El numero "+iNumero+" no es primo."+'\n'+"Es divisible por "+(iContador-1));
			}
		}else {
			System.out.println("No es primo.");
		}
		
		

	}
}
