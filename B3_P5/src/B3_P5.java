import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B3_P5 {

	public static void main(String[] args) {
//		Declarar variables
		float fNumeroBase;
		byte bNumeroExponente, bContadorOperacion;
		double dResultado = 1;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
//		Pedir por teclado la base y el exponente
		do {
			System.out.print("Introduce un numero base (0...127): ");
			try {
				fNumeroBase = Float.parseFloat(teclado.readLine());
			} catch (Exception e) {
				fNumeroBase = -1;
			}
			if (fNumeroBase < 0 || fNumeroBase > 127) {
				System.err.print("Numero fuera de rango o caracter invalido. ");
			}
		} while (fNumeroBase < 0 || fNumeroBase > 127);
		do {
			System.out.print("Introduce un numero entero para base (0...100): ");
			try {
				bNumeroExponente = Byte.parseByte(teclado.readLine());
			} catch (Exception e) {
				bNumeroExponente = -1;
			}
			if (bNumeroExponente < 0|| bNumeroExponente > 100) {
				System.err.print("Numero fuera de rango o caracter invalido. ");
			}
		} while (bNumeroExponente < 0 || bNumeroExponente > 100);
		
//		Calculo del exponencial
		for (bContadorOperacion = 1; bContadorOperacion <= bNumeroExponente ; bContadorOperacion++) {
			dResultado *= fNumeroBase;
		}
		
//		Mostrar por consola el resultado
		System.out.println("El resltuado de "+fNumeroBase+" elevado a "+bNumeroExponente+" es "+dResultado);
	}
}
