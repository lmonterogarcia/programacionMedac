
public class B10_EJ3 {

	public static void main(String[] args) {
		//a
		IAeronave oAn;
		// Instancia del objeto, con la clase de implementación
		Airbus340 oAv = new Airbus340("XW432", 200);
		Globo oGl = new Globo("CH221");
		// Funcionan como aeronaves
		oAn = oAv; // el avión
		oAn.despegar();
		oAn = oGl; // el globo
		oAn.despegar();
		// Como avión tiene sus propias métodos
		((IAvion) oAv).cerrarTrenDeAterrizaje();// el avión
		// Sólo como globo tiene sus métodos
		oGl.calentarAire(10);
		oGl.expulsarAire(12);
		System.out.println("Actualemente el vuelo " + oAv.obtenerIdentificacion() + " vuela a "
				+ oAv.obtenerAlturaDeVuelo() + " pies de altura.");
		//b
		// ((IAvion) oGl).cerrarTrenDeAterrizaje(); La clase Globo no es un IAvion es un IAeronave. Ademas dentro de la Interfas de IAeronave no existe el metodo cerrarTrenDeAterrizaje().
		
		//c
		oAn = oAv; // el avión
		((IAvion) oAn).abrirTrenDeAterrizaje(); //Para que funcione hay que especificar que la Interfas es la de IAvion y no la de IAeronave.
		
		//d
		System.out.println("\nApartado d\n");
		Globo oGl2 = new Globo("HHH100");
		oGl2.despegar();
		oGl2.aumentarAlturaDeVuelo(100);
		System.out.println("Actualemente el vuelo " + oGl2.obtenerIdentificacion() + " vuela a "
				+ oGl2.obtenerAlturaDeVuelo() + " pies de altura.");
		oGl2.aterrizar();
		oGl2.expulsarAire(1000);

	}

}
