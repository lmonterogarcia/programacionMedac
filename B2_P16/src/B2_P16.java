
public class B2_P16 {

	public static void main(String[] args) {
//		Declaracion variables
		byte bContador;
		short shNumeroImpar = -1;
		short shSuma = 0;
		
//		Calculo de la suma de los impares
		for (bContador = 1; bContador <= 100; bContador++) {
			shNumeroImpar += 2;
			shSuma += shNumeroImpar;
		}
		System.out.println("La suma de los primeros 100 numeros impares es " + shSuma);
	}
}
