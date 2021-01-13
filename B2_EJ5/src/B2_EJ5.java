import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_EJ5 {

	public static void main(String[] args) {
//		Declaracion de variables
		byte bNumero, bContador = 1;
		short shResultado;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Lectura y validacion de variable
		do {
			System.out.print("Escribe el numero entero para crear la tabla de multiplicar (-100...100): ");
			try {
				bNumero = Byte.parseByte(teclado.readLine());
			} catch (Exception e) {
				bNumero = -101;
			}
			if (bNumero < -100 || bNumero > 100) {
				System.out.print("Numero fuera de rango o caracter invalido. ");
			}
		} while (bNumero < -100 || bNumero > 100);

//		Crear la tabla de multiplicar y escribirla en consoloa
		System.out.print("\n");
		for (bContador = 1; bContador <= 10; bContador++) {
			shResultado = (short) (bNumero * bContador);
			System.out.println(bNumero + " x " + bContador + " = " + shResultado);
		}
	}
}