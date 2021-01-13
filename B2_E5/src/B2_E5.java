import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_E5 {

	public static void main(String[] args) {
		byte bNumero, bContador;
		float fMedia;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
		fMedia = 0;
		bContador = 0;
		
		do {
			System.out.println("Introduce un numero entero: ");
			try{
				bNumero = Byte.parseByte(teclado.readLine());
				if(bNumero >= 0) {
					fMedia += bNumero; // fMedia = fMedia + bNumero;
					bContador++;
				}				
			}catch(Exception e) {
				bNumero = 0;
			}			
		}while(bNumero >= 0);
		
		if(bContador > 0) {
			fMedia /= bContador; // fMedia = fMedia / bContador;
		}
		
		System.out.println("La media es: "+fMedia);

	}

}
