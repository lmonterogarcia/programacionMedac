
public class ACT11_E4 {
	public static void main(String[] args) {
		ViajeroOcasional v1 = new ViajeroOcasional(9650, "Pablo de Olavide", "Gran Plaza");
		ViajeroAbonado v2 = new ViajeroAbonado(9700, "Montequinto", "San Bernardo");
		System.out.println(v1.viajar());
		System.out.println(v2.viajar());
	}
}
