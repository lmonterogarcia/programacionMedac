import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_E3 {

	public static void main(String[] args) {
		// Declaracion de variables
		byte bHoras, bEstado;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
		// Introducir por teclado las horas
		do {
			System.out.print("Introduce las horas (0...23): ");
			try{
				bHoras = Byte.parseByte(teclado.readLine());
			}catch(Exception e) {
				bHoras = -1;
				System.out.println("ERROR: "+e.getMessage());
			}
		}while(bHoras < 0 || bHoras > 23);
		
		// Logica
		if(bHoras >= 0 && bHoras < 12) {
			bEstado = 1;
		}else if(bHoras >= 12 && bHoras < 18) {
			bEstado = 2;
		}else {
			bEstado = 3;
		}
		
		// Salida
		if (bEstado == 1) {
			System.out.println("Buenos dias");
		} else if(bEstado == 2) {
			System.out.println("Buenas tardes");
		} else {
			System.out.println("Buenas noches");
		}
		

	}

}
