// He hecho esta clase pq no me quedo claro el enunciado. Esta es por si acaso.....

public class AparatosConectados {
	private boolean booBombilla;
	private boolean booRadiador;
	private boolean booPancha;
	private final short SHBOMBILLA = 100;
	private final short SHRADIADOR = 2000;
	private final short SHPLANCHA = 1200;

	public AparatosConectados() {
		setBooBombilla(false);
		setBooRadiador(false);
		setBooPancha(false);
	}

	public boolean isBooBombilla() {
		return booBombilla;
	}

	public void setBooBombilla(boolean booBombilla) {
		this.booBombilla = booBombilla;
	}

	public boolean isBooRadiador() {
		return booRadiador;
	}

	public void setBooRadiador(boolean booRadiador) {
		this.booRadiador = booRadiador;
	}

	public boolean isBooPancha() {
		return booPancha;
	}

	public void setBooPancha(boolean booPancha) {
		this.booPancha = booPancha;
	}

	public String toString() {
		String sMensaje = "";
		short shConsumo = 0;

		if (booBombilla) {
			shConsumo += SHBOMBILLA;
		}
		if (booRadiador) {
			shConsumo += SHRADIADOR;
		}
		if (booPancha) {
			shConsumo += SHPLANCHA;
		}

		if (shConsumo > 0) {
			sMensaje += "El consumo de los aparatos es de " + shConsumo + "watios.";
			if (booBombilla || booRadiador || booPancha) {
				sMensaje += "\nAparatos encendidos:";
				if (booBombilla) {
					sMensaje += "\nBombilla";
				}
				if (booRadiador) {
					sMensaje += "\nRadiador";
				}
				if (booPancha) {
					sMensaje += "\nPlancha";
				}
			}
		} else {
			sMensaje = "No hay ningun consumo";
		}
		return sMensaje;
	}

}
