
public class B2_EJ3 {

	public static void main(String[] args) {
//		Declarar varialbes
		byte bContadorNumero, bContadorFila;
		String sSerieTriangulo = "";
		for (bContadorFila = 1; bContadorFila * 2 <= 10; bContadorFila++) {
			for (bContadorNumero = bContadorFila; bContadorNumero < 10; bContadorNumero += bContadorFila) {
				sSerieTriangulo += bContadorNumero;
			}
			sSerieTriangulo += "\n";
		}
		System.out.println(sSerieTriangulo);
	}
}