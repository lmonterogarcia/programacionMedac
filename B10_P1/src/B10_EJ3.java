
public class B10_EJ3 {

	public static void main(String[] args) {
		//a
		IAeronave oAn;
		// Instancia del objeto, con la clase de implementaci�n
		Airbus340 oAv = new Airbus340("XW432", 200);
		Globo oGl = new Globo("CH221");
		// Funcionan como aeronaves
		oAn = oAv; // el avi�n
		oAn.despegar();
		oAn = oGl; // el globo
		oAn.despegar();
		// Como avi�n tiene sus propias m�todos
		((IAvion) oAv).cerrarTrenDeAterrizaje();// el avi�n
		// S�lo como globo tiene sus m�todos
		oGl.calentarAire(10);
		oGl.expulsarAire(12);
		System.out.println("Actualemente el vuelo " + oAv.obtenerIdentificacion() + " vuela a "
				+ oAv.obtenerAlturaDeVuelo() + " pies de altura.");
		//b
		// ((IAvion) oGl).cerrarTrenDeAterrizaje(); La clase Globo no es un IAvion es un IAeronave. Ademas dentro de la Interfas de IAeronave no existe el metodo cerrarTrenDeAterrizaje().
		
		//c
		oAn = oAv; // el avi�n
		((IAvion) oAn).abrirTrenDeAterrizaje(); //Para que funcione hay que especificar que la Interfas es la de IAvion y no la de IAeronave.
		
		//d
		System.out.println("\nApartado d\n");
		Globo oGl2 = new Globo("HHH100");
		oAn = oGl2;
		oAn.despegar();
		oAn.aumentarAlturaDeVuelo(100);
		System.out.println("Actualemente el vuelo " + oAn.obtenerIdentificacion() + " vuela a "
				+ oGl2.obtenerAlturaDeVuelo() + " pies de altura.");
		oAn.aterrizar();
		oAn.consultarEstado();
		oGl2.expulsarAire(1000);

	}

}
