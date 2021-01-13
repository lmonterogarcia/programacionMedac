import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_P7 {

	public static void main(String[] args) {
//		Declaracion de variables para enrada por teclado
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String cadenaLeida;
		
//		Declaracion de variables de entrada y salida. segundos y resultado en segundos y minutos
		float fSegundos, fResultadoSegundos ;
		int iResultadoMinutos;
		
//		Pedir al usuario que introduzca os segundos a convertir. Escribir.
		System.out.print("Introduce los segundos a convertir (0.0...3000000.0): ");
		
//		Leer la variable iSegundos
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		fSegundos=Float.parseFloat(cadenaLeida);
		
//		Calcular minutos y segundos
		iResultadoMinutos=(int)(Math.floor(fSegundos/60));
		fResultadoSegundos=(fSegundos%60);
		
//		Escribir por consola el resultado.
		System.out.println(fSegundos+" segundos es igual a "+iResultadoMinutos+" minutos y "+fResultadoSegundos+" segundos.");
	}

}
