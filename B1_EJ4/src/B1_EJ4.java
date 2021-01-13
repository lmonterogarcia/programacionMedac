import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_EJ4 {

	public static void main(String[] args) {
//		Declaracion variables para lectura por teclado.
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String cadenaLeida;
		
//		Declaracion de variables de entrada e internas. Horas, Minutos y Segundos. Conversor.
		short shHoras;
		byte bMinutos, bSegundos;
		final byte BCONVERSOR = 60;
		
//		Declaracion de variable de salida.
		int iTotalSegundos;
		
//		Escribir "Escribir las horas: "
		System.out.print("Introduce las horas a convertir (0...500): ");

//		Leer horas y casting de String a Short
		try {
			cadenaLeida = lector.readLine();
			}catch(Exception e) {
				cadenaLeida = "";
			}
		shHoras =Short.parseShort(cadenaLeida);
				
//		Escribir "Escribir las minutos: "
		System.out.print("Introduce los minutos a convertir (0...59): ");

//		Leer minutos y casting de String a Byte
		try {
			cadenaLeida = lector.readLine();
			}catch(Exception e) {
				cadenaLeida = "";
			}
		bMinutos =Byte.parseByte(cadenaLeida);
				
//		Escribir "Escribir los segundos: "
		System.out.print("Introduce los segundos a convertir (0...59): ");

//		Leer segundos y casting de String a Byte
		try {
			cadenaLeida = lector.readLine();
			}catch(Exception e) {
				cadenaLeida = "";
			}
		bSegundos =Byte.parseByte(cadenaLeida);
		
//		Inicializacion de iTotalSegundos con algoritmo de convertir todo a segundos.
		iTotalSegundos=shHoras*BCONVERSOR*BCONVERSOR+bMinutos*BCONVERSOR+bSegundos;
		
//		 Escribir mensaje para mostar en consola el resultado.
		System.out.println(shHoras+" horas, "+bMinutos+" minutos y "+bSegundos+" segundos equivalen a "+iTotalSegundos+" segundos.");
	}

}
