
public class B9_EJ2 {

	public static void main(String[] args) {
		// Los atributos de la clase Persona son privados, por lo que no se pueden
		// acceder
		// por lo que las reglas no pueden ser violadas.

		Persona oPersona1 = new Persona("Luis", "Montero", "Garcia-Manjarón");
		demostrarClase(oPersona1);
		
	}

	private static void demostrarClase(Persona oPersona1) {
		System.out.println(cambioEdad((short) 36, oPersona1));
		System.out.println(cambioEdad((short) 36, oPersona1));
		System.out.println(cambioEdad((short) 250, oPersona1));
		System.out.println(cambioPeso(88.5f, oPersona1));
		System.out.println(cambioPeso(350.5f, oPersona1));
		System.out.println(cambioEstatura(1.69f, oPersona1));
		System.out.println(cambioEstatura(7.69f, oPersona1));
		System.out.println(cambioEstado((byte) 1, oPersona1));
		System.out.println(cambioEstado((byte) 5, oPersona1));
		System.out.println(cambioEstado((byte) 2, oPersona1));
		System.out.println(cambioEstado((byte) 6, oPersona1));
	}
	
	private static String cambioEdad(short shEdad, Persona oPersona) {
		String sMensaje = "\n";

		if (oPersona.setShEdad(shEdad)) {
			sMensaje += "La edad de la persona se ha cambiado a " + shEdad + ".";
		} else {
			sMensaje += "La edad de la persona no ha sido cambiada";
		}

		return sMensaje;
	}

	private static String cambioPeso(float fPeso, Persona oPersona) {
		String sMensaje = "\n";

		if (oPersona.setfPeso(fPeso)) {
			sMensaje += "El peso de la persona se ha cambiado a " + fPeso + ".";
		} else {
			sMensaje += "El peso de la persona no ha sido cambiado";
		}

		return sMensaje;
	}

	private static String cambioEstatura(float fEstatura, Persona oPersona) {
		String sMensaje = "\n";

		if (oPersona.setfEstatura(fEstatura)) {
			sMensaje += "La estatura de la persona se ha cambiado a " + fEstatura + ".";
		} else {
			sMensaje += "La estatura de la persona no ha sido cambiada";
		}

		return sMensaje;
	}

	private static String cambioEstado(byte bEstado, Persona oPersona) {
		String sMensaje = "\n";

		if (oPersona.setbEstado(bEstado)) {
			sMensaje += "El estado ha sido cambiado a " + oPersona.nombreEstado();
		} else {
			sMensaje += "El estado de la persona no ha sido cambiado";
		}

		return sMensaje;
	}
}
