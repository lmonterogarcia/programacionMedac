import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_E6 {

	public static void main(String[] args) {
		byte bNumero;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		do {
			try{
				System.out.println("Introduce un numero entero: ");
				bNumero = Byte.parseByte(teclado.readLine());				
			}catch(Exception e) {
				bNumero = 5;
			}	
		}while(bNumero < 1 || bNumero > 10);

	}

}
