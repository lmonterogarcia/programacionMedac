import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_P3 {

	public static void main(String[] args) {
//		Declaracion Variables
		float fNumero1, fNumero2, fResultado = 0;
		boolean booMensajeError = false;
		byte bEleccionOperador;
		String sOperador = "";
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir los valores y validar
		// Numero 1
		do {
			System.out.print("Introduce el primer numero (-30000...30000): ");
			try {
				fNumero1 = Float.parseFloat(teclado.readLine());
			} catch (Exception e) {
				fNumero1 = -30001;
			}
			if (fNumero1 < -30000 || fNumero1 > 30000) {
				System.out.print("Numero fuera de rango. ");
			}
		} while (fNumero1 < -30000 || fNumero1 > 30000);
		// Numero 2
		do {
			System.out.print("Introduce el segundo numero (-30000...30000): ");
			try {
				fNumero2 = Float.parseFloat(teclado.readLine());
			} catch (Exception e) {
				fNumero2 = -30001;
			}
			if (fNumero2 < -30000 || fNumero2 > 30000) {
				System.out.print("Numero fuera de rango. ");
			}
		} while (fNumero2 < -30000 || fNumero2 > 30000);
		
//		Mostrar el menu, pedir la eleccion y validarla
		do {
			System.out.print("\n"+"1. Suma"+"\n"+"2. Resta"+"\n"+"3. Multiplicacion"+"\n"+"4. Division"+"\n"+"5. Resto"+"\n"+"\n"+"Elija opcion: ");
			try {
				bEleccionOperador = Byte.parseByte(teclado.readLine());
			} catch (Exception e) {
				bEleccionOperador = -1;
			}
			if (bEleccionOperador < 1 || bEleccionOperador > 5) {
				System.out.print("Eleccion fuera de rango. ");
			}
		} while (bEleccionOperador < 1 || bEleccionOperador > 5);

//		Hacer los calculos
		switch (bEleccionOperador) {
		case 1:
			fResultado = fNumero1 + fNumero2;
			sOperador = " + ";
			break;
		case 2:
			fResultado = fNumero1 - fNumero2;
			sOperador = " - ";
			break;
		case 3:
			fResultado = fNumero1 * fNumero2;
			sOperador = " * ";
			break;
		case 4:
			if (fNumero2 == 0 ) {
				booMensajeError = true;
			}else {
				fResultado = fNumero1 / fNumero2;
				sOperador = " / ";
			}
			break;
		default:
			if (fNumero2 == 0 ) {
				booMensajeError = true;
			}else {
				fResultado = fNumero1 % fNumero2;
				sOperador = " % ";
			}
		}
		
//		Mostrar el resutlado por consola
		if (booMensajeError) {
			System.out.println("\n"+"ERROR. Operacion con resultado indefinido");
		}else {
			System.out.println("\n"+fNumero1+sOperador+fNumero2+" = "+fResultado);
		}
	}
}
