
public class B9_P2 {

	public static void main(String[] args) {
		AparatoElectrico oBombilla = new AparatoElectrico((short) 100);
		AparatoElectrico oRadiador = new AparatoElectrico((short) 2000);
		AparatoElectrico oPlancha = new AparatoElectrico((short) 1200);
		
		System.out.println(mostrarConsumo(oBombilla, oRadiador, oPlancha));
		
		oBombilla.setBooEncendido(true);
		oPlancha.setBooEncendido(true);
		
		System.out.println(mostrarConsumo(oBombilla, oRadiador, oPlancha));
		
		oPlancha.setBooEncendido(false);
		oRadiador.setBooEncendido(true);
		
		System.out.println(mostrarConsumo(oBombilla, oRadiador, oPlancha));
		

	}

	private static String mostrarConsumo(AparatoElectrico oBombilla, AparatoElectrico oRadiador, AparatoElectrico oPlancha) {
		String sMensaje = "\n";
		short shConsumo = 0;

		if (oBombilla.isBooEncendido()) {
			shConsumo += oBombilla.getShConsumo();
		}
		if (oRadiador.isBooEncendido()) {
			shConsumo += oRadiador.getShConsumo();
		}
		if (oPlancha.isBooEncendido()) {
			shConsumo += oPlancha.getShConsumo();
		}

		if (shConsumo > 0) {
			sMensaje += "El consumo de los aparatos es de " + shConsumo + " watios.";
			if (oBombilla.isBooEncendido() || oRadiador.isBooEncendido() || oPlancha.isBooEncendido()) {
				sMensaje += "\nAparatos encendidos:";
				if (oBombilla.isBooEncendido()) {
					sMensaje += "\nBombilla";
				}
				if (oRadiador.isBooEncendido()) {
					sMensaje += "\nRadiador";
				}
				if (oPlancha.isBooEncendido()) {
					sMensaje += "\nPlancha";
				}
			}
		} else {
			sMensaje = "No hay ningun consumo.";
		}
		return sMensaje;
	}
	
}
