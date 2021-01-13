
public class B7_EJ16 {

	public static void main(String[] args) {
		double dResultado = 1;
		byte bNumerosImpares = 10;
		
		for (byte bContador = 1; bContador < (2 * (bNumerosImpares + 1)); bContador += 2) {
			dResultado *= bContador;
		}

		System.out.println("El producto de los "+bNumerosImpares+" primeros numeros impares es "+dResultado);
	}

}
