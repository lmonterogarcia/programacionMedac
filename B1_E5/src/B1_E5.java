import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_E5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declaracion de las 5 variables para las notas
		float fNotaExamen1, fNotaExamen2, fNotaExamen3, fNotaExamen4, fNotaExamen5 = 0f;

		// Declaracion de la variable para la nota media
		float fNotaMedia;
		
		//Declaracion para lectura por teclado
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String cadenaLeida;

		// Escribir "1ª nota"
		System.out.println("Introduce la nota del primer examen: ");

		// Leer Nota_1
		try {
			cadenaLeida = lector.readLine();	
		} catch (Exception e) {
			cadenaLeida = "";
		}
		fNotaExamen1 = Float.parseFloat(cadenaLeida);
		
		// Escribir "2ª nota"
		System.out.println("Introduce la nota del segundo examen: ");

		// Leer Nota_2
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		fNotaExamen2 = Float.parseFloat(cadenaLeida);
		
		// Escribir "3ª nota"
		System.out.println("Introduce la nota del tercer examen: ");

		// Leer Nota_3
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		fNotaExamen3 = Float.parseFloat(cadenaLeida);
		
		// Escribir "4ª nota"
		System.out.println("Introduce la nota del cuarto examen: ");

		// Leer Nota_4
		try {
			cadenaLeida = lector.readLine();

		} catch (Exception e) {
			cadenaLeida = "";
		}
		fNotaExamen4 = Float.parseFloat(cadenaLeida);
		
		// Escribir "5ª nota"
		System.out.println("Introduce la nota del quinto examen: ");

		// Leer Nota_5
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		fNotaExamen5 = Float.parseFloat(cadenaLeida);

		// Calculo de nota media
		fNotaMedia = (fNotaExamen1 + fNotaExamen2 + fNotaExamen3 + fNotaExamen4 + fNotaExamen5) / 5;

		// Escricir por pantala la nota media
		System.out.println("La nota media del alumno es " + fNotaMedia);
	}

}
