
public class B2_P2 {

	public static void main(String[] args) {
//		Declarar variables
		short shContador;
		int iSuma = 0;
		
//		Calculo de la suma
		for (shContador = 2; shContador <= 1000; shContador += 2) {
			iSuma += shContador;
		}
		
//		Imprimir por consola el resultado
		System.out.println("La suma de los pares entre 2 y 1000 es " + iSuma);
	}
}
