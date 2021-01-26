
public class B9_EJ2 {

	public static void main(String[] args) {
		// Los atributos de la clase Persona son privados, por lo que no se pueden
		// acceder
		// por lo que las reglas no pueden ser violadas.

		Persona oPersona1 = new Persona("Luis", "Montero", "Garcia-Manjarón");
		System.out.println(cambioEdad((short) 36, oPersona1));
		System.out.println(cambioEdad((short) 36, oPersona1));
		System.out.println(cambioEdad((short) 250, oPersona1));
		System.out.println(cambioPeso(88.5f, oPersona1));
		System.out.println(cambioPeso(250.5f, oPersona1));
		System.out.println(cambioEstatura(1.69f, oPersona1));
		System.out.println(cambioEstatura(7.69f, oPersona1));
		System.out.println(cambioEstado((byte) 1, oPersona1));
		System.out.println(cambioEstado((byte) 5, oPersona1));
		System.out.println(cambioEstado((byte) 2, oPersona1));
		System.out.println(cambioEstado((byte) 6, oPersona1));
		
		

	}

	private static String cambioEdad(short shEdad, Persona oPersona) {
		String sMensaje = "";

		if (oPersona.setShEdad(shEdad)) {
			sMensaje += "La edad de la persona se ha cambiado a " + shEdad + ".";
		} else {
			sMensaje += "La edad de la persona no ha sido cambiada";
		}

		return sMensaje;
	}

	private static String cambioPeso(float fPeso, Persona oPersona) {
		String sMensaje = "";

		if (oPersona.setfPeso(fPeso)) {
			sMensaje += "El peso de la persona se ha cambiado a " + fPeso + ".";
		} else {
			sMensaje += "El peso de la persona no ha sido cambiado";
		}

		return sMensaje;
	}

	private static String cambioEstatura(float fEstatura, Persona oPersona) {
		String sMensaje = "";

		if (oPersona.setfEstatura(fEstatura)) {
			sMensaje += "La estatura de la persona se ha cambiado a " + fEstatura + ".";
		} else {
			sMensaje += "La estatura de la persona no ha sido cambiada";
		}

		return sMensaje;
	}

	private static String cambioEstado(byte bEstado, Persona oPersona) {
		String sMensaje = "";

		if (oPersona.setbEstado(bEstado)) {
			sMensaje += "El estado ha sido cambiado a ";
			switch (bEstado) {
			case 1:
				sMensaje += "soltero.";
				break;
			case 2:
				sMensaje += "casado.";
				break;
			case 3:
				sMensaje += "separado.";
				break;
			case 4:
				sMensaje += "divorciado.";
				break;
			default:
				sMensaje += "viudo.";
			}
		} else {
			sMensaje += "El estado de la persona no ha sido cambiado";
		}

		return sMensaje;
	}
}
