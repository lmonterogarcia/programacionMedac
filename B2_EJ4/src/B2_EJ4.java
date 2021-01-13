import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_EJ4 {

	public static void main(String[] args) {
//		Declaracion variables
		short shNumero, shNumeroMenor = 2000, shNumeroMayor = -1000;
		byte bContador = 1;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Recolectar los 4 numeros y validar
		for (bContador = 1; bContador <= 4; bContador++) {
			do {
				System.out.print("Introduce el numero " + bContador + " (-1000...2000): ");
				try {
					shNumero = Short.parseShort(teclado.readLine());
				} catch (Exception e) {
					shNumero = -1001;
				}
				if (shNumero < -1000 || shNumero > 2000) {
					System.out.print("Numero fuera de rango o caracter invalido. ");
				}
			} while (shNumero < -1000 || shNumero > 2000);

//			Guardar los numero mayores o menores en variables de salida si son mayores o menores de los que ya hay 
			if (shNumero < shNumeroMenor) {
				shNumeroMenor = shNumero;
			} 
			if (shNumero > shNumeroMayor) {
				shNumeroMayor = shNumero;
			}
		}

//		Mostrar por consola el resultado
		System.out.println("\n"+"El numero mayor es " + shNumeroMayor + " y el numero menor es " + shNumeroMenor + ".");
	}
}
