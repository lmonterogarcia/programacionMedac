
public class B9_P3 {

	public static void main(String[] args) {
		boolean booCasa = false;
		Aparato oAparato1 = new Aparato();

		oAparato1.cambiarInterruptor();
		System.out.println(estaEncendido(booCasa, oAparato1));
		booCasa = cambiarInterruptorCasa(booCasa);
		System.out.println(estaEncendido(booCasa, oAparato1));
	
	}

	private static boolean cambiarInterruptorCasa(boolean booCasa) {
		if (booCasa) {
			booCasa = false;
		} else {
			booCasa = true;
		}
		return booCasa;
	}
	
	private static String estaEncendido(boolean booCasa, Aparato oAparato) {
		String sMensaje = "\n";
		if (oAparato.estaEncendido(booCasa)) {
			sMensaje += "El aparato esta encendido";
		} else {
			sMensaje += "El aparato no esta encendido";
		}
		return sMensaje;
	}
}
