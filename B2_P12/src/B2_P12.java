import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_P12 {

	public static void main(String[] args) {
//		Declarar variables
		byte bNumeroTotalTerminos, bContadorTerminos;
		long lNumeroTermino1, lNumeroTermino2 = -1, lNumeroTermino3 = 1;
		String sSerieFibonacci = "";
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir el numero de terminos
		do {
			System.out.print("Introduce el numero de terminos que quiere de la serie de Fibonacci (1...50): ");
			try {
				bNumeroTotalTerminos = Byte.parseByte(teclado.readLine());
			} catch (Exception e) {
				bNumeroTotalTerminos = -1;
			}
			if (bNumeroTotalTerminos < 1 || bNumeroTotalTerminos > 50) {
				System.out.print("Numero introducido fuera de rango o caracter no valido. ");
			}
		} while (bNumeroTotalTerminos < 1 || bNumeroTotalTerminos > 50);

//		Calcular la serie de fibonacci
		for (bContadorTerminos = 1; bContadorTerminos <= (bNumeroTotalTerminos); bContadorTerminos++) {
			lNumeroTermino1 = lNumeroTermino2;
			lNumeroTermino2 = lNumeroTermino3;
			lNumeroTermino3 = lNumeroTermino1 + lNumeroTermino2;
			sSerieFibonacci += lNumeroTermino3 + ", ";
		}

//		Escribir por consola el resultado de la serie de fibonacci
		System.out.println(sSerieFibonacci.substring(0, sSerieFibonacci.length() - 2) + ".");

	}
}
