import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_P11 {

	public static void main(String[] args) {
//		Declaracion variables
		byte bHora = 0, bMinuto = 0, bSegundo = 0;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Leer la hora y si algun numero es negativo terminar el programa
		do {
			do {
				try {
					System.out.print("Intruduce la hora (hasta 100): ");
					bHora = Byte.parseByte(teclado.readLine());
				} catch (Exception e) {
					bHora = -101;
				}
				if (bHora < -100 || bHora > 100) {
					System.out.print("Hora fuera de rango. ");
				}
			} while (bHora < -100 || bHora > 100);
			if (bHora >= 0) {
				do {
					try {
						System.out.print("Intruduce los minutos (hasta 100): ");
						bMinuto = Byte.parseByte(teclado.readLine());
					} catch (Exception e) {
						bMinuto = -101;
					}
					if (bMinuto < -100 || bMinuto > 100) {
						System.out.print("Hora fuera de rango");
					}
				} while (bMinuto < -100 || bMinuto > 100);
				if (bMinuto >= 0) {
					do {
						try {
							System.out.print("Intruduce los segundos (hasta 100): ");
							bSegundo = Byte.parseByte(teclado.readLine());
						} catch (Exception e) {
							bSegundo = -101;
						}
						if (bSegundo < -100 || bSegundo > 100) {
							System.out.print("Hora fuera de rango");
						}
					} while (bSegundo < -100 || bSegundo > 100);
					if (bSegundo >= 0) {
	//					Escribir por pantalla si es correcto o no
						if (bHora > 23 || bMinuto > 59 || bSegundo > 59) {
							System.out.println("La hora " + bHora + ":" + bMinuto + ":" + bSegundo + " es ERRONEA");
						} else {
							System.out.println("La hora " + bHora + ":" + bMinuto + ":" + bSegundo + " es CORRECTA");
						}
					}
				}
			}
		} while (bHora >= 0 && bMinuto >= 0 && bSegundo >= 0);
		System.out.println("Has introducido un numero negativo. Ha finalizado el programa.");
	}
}
