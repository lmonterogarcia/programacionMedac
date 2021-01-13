import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B3_P4 {

	public static void main(String[] args) {
//		Declarar variables
		short shNumero;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir al usuario el numero y validar
		do {
			do {
				System.out.print("Introduce un numero (0...30000): ");
				try {
					shNumero = Short.parseShort(teclado.readLine());
				} catch (Exception e) {
					shNumero = -1;
				}
				if (shNumero < 0 || shNumero > 30000) {
					System.err.print("Numero fuera de rango o caracter invalido. ");
				}
			} while (shNumero < 0 || shNumero > 30000);

//			Ver si es divisible entre 2 y 3
			if (shNumero % 2 != 0 || shNumero % 3 != 0) {
				System.err.println("\n"+ shNumero + " No es divisible por 3 y 2. "+"\n");
			}
		} while (shNumero % 2 != 0 || shNumero % 3 != 0);

//		Enseniar el resultado por consola
		System.out.println("\n"+"El resutlado es "+shNumero + "/2=" + shNumero / 2 + " y " + shNumero + "/3=" + shNumero / 3);
	}
}
