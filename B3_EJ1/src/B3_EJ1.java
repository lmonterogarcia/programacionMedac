import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B3_EJ1 {

	public static void main(String[] args) {
//		Declaracion de variables
		short shNumeroEntrante, shNumeroControl = -30001;
		boolean booEsMayor = true;
		byte bContadorNumeros;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Recogida de numeros, validacion y logica para ver si estan en orden creciente
		for (bContadorNumeros = 1; bContadorNumeros <= 3; bContadorNumeros++) {
			do {
				System.out.print("Introduce el numero " + bContadorNumeros + " (-30000...30000): ");
				try {
					shNumeroEntrante = Short.parseShort(teclado.readLine());
				} catch (Exception e) {
					shNumeroEntrante = -30002;
				}
				if (shNumeroEntrante < -30000 || shNumeroEntrante > 30000) {
					System.err.print("Numero fuera de rango o caracter invalido. ");
				}
			} while (shNumeroEntrante < -30000 || shNumeroEntrante > 30000);
			
//			Ver si estan en orden creciente
			if (shNumeroEntrante > shNumeroControl && booEsMayor) {
				shNumeroControl = shNumeroEntrante;
			} else {
				booEsMayor = false;
			}
		}
		
//		Mostrar por consola el resultado
		if (booEsMayor) {
			System.out.println("\n" + "Los numeros introducidos estan en orden creciente");
		} else {
			System.out.println("\n" + "Los numeros introducidos NO estan en orden creciente");
		}
	}
}
/*
 * IMPORTANTE:Hay otra version de este programa. Que nada mas que meta un numero
 * que no sea creciente termine.Se haria con un do-while en vez de un for. Pero
 * en el enunciado del ejercicio pone que tiene que introducir los tres numeros.
 */