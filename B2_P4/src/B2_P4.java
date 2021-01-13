import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2_P4 {

	public static void main(String[] args) {
//		Declaracion de variables
		float fRadio, fResultadoOperacion;
		final float FPI = 3.141592f;
		String sOperadorTipo;
		byte bEleccionMenu;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir al usuario el radio
		do {
			System.out.print("Introduce el radio (hasta 900): ");
			try {
				fRadio = Float.parseFloat(teclado.readLine());
			} catch (Exception e) {
				fRadio = -901;
			}
			if (fRadio < -900 || fRadio > 900) {
				System.out.print("Radio fuera de rango o caracter invalido. ");
			}
		} while (fRadio < -900 || fRadio > 900);

//		Si el radio es negativo se acaba el programa con un mensaje de error
		if (fRadio > 0) {

//			Mostar menu y pedir la eleccio
			do {
				System.out.print('\n'+"1. Longitud de la circunferencia"+'\n'+"2. Superficie de la circunferencia"+'\n'
								+"3. Volumen de la esfera"+'\n'+"4. Area de la esfera"+'\n'+'\n'+"Elija opcion (1...4): ");
				try {
					bEleccionMenu = Byte.parseByte(teclado.readLine());
				} catch (Exception e) {
					bEleccionMenu = -1;
				}
				if (bEleccionMenu < 1 || bEleccionMenu > 4) {
					System.out.print('\n'+"ERROR. OPCION NO CONTEMPLADA. VUELVA A ELEGIR."+'\n');
				}
			} while (bEleccionMenu < 1 || bEleccionMenu > 4);
			
//			Calculo de las diferentes operaciones. Menu.
			switch (bEleccionMenu) {
			case 1:
				fResultadoOperacion = 2*FPI*fRadio;
				sOperadorTipo = "La longitud de la circunferencia es ";
				break;
			case 2:
				fResultadoOperacion = (float) (FPI*Math.pow(fRadio, 2));
				sOperadorTipo = "La superficie de la circunferencia es ";
				break;
			case 3:
				fResultadoOperacion = (float) (0.75*FPI*Math.pow(fRadio, 3));
				sOperadorTipo = "El volumen de la esfera es ";
				break;
			default:
				fResultadoOperacion = (float) (4*FPI*Math.pow(fRadio, 2));
				sOperadorTipo = "El area de la esfera es ";
				break;
			}
			
//			Escribir por consola resultados
			System.out.println('\n'+sOperadorTipo+fResultadoOperacion);
		} else {
			System.out.println('\n'+"El radio no puede ser negativo");
		}
	}
}
