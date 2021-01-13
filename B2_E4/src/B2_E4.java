
public class B2_E4 {

	public static void main(String[] args) {		
		/*byte bNumero;		
		for(bNumero = 3; bNumero <= 99; bNumero += 3) {
			System.out.println(bNumero);
		}*/
		
		/*byte bNumero = 3;
		byte bResultado = -1;
		boolean boolEncontrado = false;
		while(bNumero <= 99 && !boolEncontrado) {
			if(bNumero > 10) {
				boolEncontrado = true;
				bResultado = bNumero;
			}
			bNumero += 3;
		}
		
		if(bResultado == -1) {
			System.out.println("No has encontrado lo que ibas buscando.");
		} else {
			System.out.println("Has encontrado el primer numero mayor que 10: "+bResultado);
		}*/
		
		
		
		
		
		
		byte bNumero = 3;
		byte bPosicion = 1;
		byte bResultado = -1;
		boolean boolEncontrado = false;
		
		while(bNumero <= 99 && !boolEncontrado) {
			if(bPosicion == 7) {
				bResultado = bNumero;
				boolEncontrado = true;
			}
			bNumero += 3;
			bPosicion++;
		}
		
		if(bResultado == -1) {
			System.out.println("No has encontrado lo que ibas buscando.");
		} else {
			System.out.println("El numero de la posicion 7 es: "+bResultado);
		}
		
		
		
	}

}
