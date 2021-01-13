import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_P17 {

	public static void main(String[] args) {
//		Declaracion variables
		short shNumero = -1001, shNumeroMenor = 2000, shNumeroMayor = -1000;
		byte bContador = 1, bNumerosAIntroducir;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Saber cuantos numeros hay que comparar
		do {
			System.out.print("¿Cuantos numeros vas a introducir? (1...127): ");
			try {
				bNumerosAIntroducir = Byte.parseByte(teclado.readLine());
			} catch (Exception e) {
				bNumerosAIntroducir = -1;
			}
			if (bNumerosAIntroducir < 1 || bNumerosAIntroducir > 127) {
				System.out.print("Numero fuera de rango. ");
			}
		} while (bNumerosAIntroducir < 1 || bNumerosAIntroducir > 127);
		
//		Recoloectar los numeros y validar
		for (bContador = 1; bContador <= bNumerosAIntroducir; bContador++) {
			do {
				System.out.print("Introduce el numero " + bContador + " (-1000...2000): ");
				try {
					shNumero = Short.parseShort(teclado.readLine());
				} catch (Exception e) {
					shNumero = -1002;
				}
				if (shNumero < -1000 || shNumero > 2000) {
					System.out.print("Numero fuera de rango. ");
				}
			} while (shNumero < -1000 || shNumero > 2000);

			// Guardar los numero mayores o menores en variables de salida si son mayores o
			// menores de los que ya hay
			if (bNumerosAIntroducir != 1) {
				if (shNumero < shNumeroMenor) {
					shNumeroMenor = shNumero;
				} 
				
				if (shNumero > shNumeroMayor) {
					shNumeroMayor = shNumero;
				}
			}
		}
		
//		Mostrar por consola el resultado
		if (bNumerosAIntroducir == 1) {
			System.out.println("Solo ha introducido un numero, por lo que "+shNumero+" es el numero mayor y menor");
		}else {
			System.out.println("El numero mayor es " + shNumeroMayor + " y el numero menor es " + shNumeroMenor + ".");
		}	
	}
}
