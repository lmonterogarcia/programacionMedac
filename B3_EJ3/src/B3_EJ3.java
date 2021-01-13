
public class B3_EJ3 {

	public static void main(String[] args) {
//		Declarar variables
		short shContadorMultiplos5;
		String sSerieMultiplos = "";
		
//		Calculo de los multiplos
		for (shContadorMultiplos5 = 5; shContadorMultiplos5 <= 1000; shContadorMultiplos5 += 5) {
			sSerieMultiplos += shContadorMultiplos5+", ";
		}
		
//		Mostrar por consola el resultado
		System.out.println(sSerieMultiplos.substring(0, sSerieMultiplos.length()-2)+".");
	}
}
