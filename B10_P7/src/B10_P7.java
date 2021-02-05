
public class B10_P7 {
	
	public static void simularCompra(ITarjetaMonedero oTarjMon) {
		oTarjMon.comprar((float)Libreria.leer("Importe de la compra ", -1, -1, 0, 3500, (byte) 5), (String)Libreria.leer("Introduzca el DNI ", -1, 9, -1, -1, (byte) 10));
	}
	
	public static void simularRetiradaCajero(ITarjetaDebito oTarjDeb) {
		oTarjDeb.retirarCajero((float)Libreria.leer("Importe de la compra ", -1, -1, 0, 3500, (byte) 5), (int)Libreria.leer("Introduzca el Pin ", 0, 999999, -1, -1, (byte) 3));
	}
	
	public static void main(String[] args) {
		ITarjetaMonedero oTarjMon = new Tarjeta("8737459715487874", "54789625I", 123456, (float) 45789.77);
		ITarjetaDebito oTarjDeb = new Tarjeta("6537845715487874", "75148965W", 123456, (float) 250);
		Tarjeta oTarj = new Tarjeta("1237845715487874", "25478695R", 123456, (float) 28475.47);

		simularCompra(oTarjMon); //Para que funcione hay que inicializar con una clase Tarjeta.
//		simularCompra(oTarjDeb); // Da error ya que este metodo solo esta hecho para la interfaz ITarjetaMonedero y clases donde se halla implementado.
		simularCompra(((ITarjetaMonedero)oTarjDeb)); // Para que funcione hay que inicializar con una clase Tarjeta y convertirla en ITarjetaMonedero.
		simularCompra(oTarj);
		
//		simularRetiradaCajero(oTarjMon); // Da error ya que este metodo solo esta hecho para la interfaz ITarjetaDebito y clases donde se halla implementado.
		simularRetiradaCajero(((ITarjetaDebito)oTarjMon)); // Para que funcione hay que inicializar con una clase Tarjeta y convertirla en ITarjetaDebito.
		simularRetiradaCajero(oTarjDeb);
		simularRetiradaCajero(oTarj);

		
	}


}
