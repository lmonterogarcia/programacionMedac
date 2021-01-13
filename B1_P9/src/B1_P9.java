import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_P9 {

	public static void main(String[] args) {
//		Declaracion de variables para enrada por teclado
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String scadenaLeida;

//		Declacion de variables de entrada, internas y salida
		int iNumero;
		byte bPosicion, bNumeroEnPosicion;

//		Pedir al usurario que escriba el numero y la posicion. Asignacion a las variables.
		
		// Numero
		System.out.print("Introduce el numero (-90000000...90000000): ");
		try {
			scadenaLeida = lector.readLine();
		} catch (Exception e) {
			scadenaLeida = "";
		}
		iNumero=Integer.parseInt(scadenaLeida); //Casting

		// Posicion
		System.out.print("Introduce la posicion del numero (1...9): ");
		try {
			scadenaLeida=lector.readLine ();
		} catch (Exception e) {
			scadenaLeida = "";
		}
		bPosicion=Byte.parseByte(scadenaLeida);
		
//		Calculo del algoritomo para sacar la posicion del digito dentro del numero
		bNumeroEnPosicion=(byte)(Math.pow((Math.pow((((int)((iNumero)/(Math.pow(10, ((Math.ceil(Math.log10((Math.pow((Math.pow(iNumero, 2)), 0.5))+1)))-bPosicion)))))%10), 2)), 0.5));
		
//		Enseniar por consola el resultado.
		System.out.print("\nLa posicion "+bPosicion+" del numero "+iNumero+" es "+bNumeroEnPosicion);
	}
}