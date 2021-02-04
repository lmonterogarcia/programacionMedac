
public class P10_P2 {

	public static void main(String[] args) {
		ITelefono oTel;
		Satelite oSat = new Satelite(658847562);
		Movil oMov = new Movil(632598741);
		Fijo oFij = new Fijo(684597542);
		
		oTel = oFij;
		System.out.println(oTel.consultarNumero());
		System.out.println(oTel.activarAltavoz());
		System.out.println(oFij.activarAltavoz());
		System.out.println(oTel.desactivarAltavoz());
		System.out.println(oTel.marcar(658747589));
		System.out.println(sonarTel(oTel));
		System.out.println(oTel.colgar());
		System.out.println(sonarTel(oTel));
		
		oTel = oMov;
		System.out.println(oTel.consultarNumero());
		System.out.println(oTel.activarAltavoz());
		System.out.println(oTel.activarAltavoz());
		System.out.println(oMov.desactivarAltavoz());
		System.out.println(oTel.marcar(658747589));
		System.out.println(sonarTel(oTel));
		System.out.println(oTel.colgar());
		System.out.println(sonarTel(oTel));
		
		oTel = oSat;
		System.out.println(oTel.consultarNumero());
		System.out.println(oTel.activarAltavoz());
		System.out.println(oTel.activarAltavoz());
		System.out.println(oTel.desactivarAltavoz());
		System.out.println(oSat.marcar(658747589));
		System.out.println(sonarTel(oTel));
		System.out.println(oTel.colgar());
		System.out.println(sonarTel(oTel));
	}

	private static String sonarTel(ITelefono oTel) {
		String sMensaje = "";
		if (!oTel.isBoollamando()) {
			sMensaje = "Telefono " + oTel.getSTIPODETEL() + " RING RING RING";
		} else {
			sMensaje =  "Telefono " + oTel.getSTIPODETEL() + "  NO SONIDO";
		}
		return sMensaje;
	}
}
