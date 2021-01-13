import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B3_P1 {

	public static void main(String[] args) {
//		Declaracion de variables
		float fTiempoLlegada = 3, fTiempoControl = 3, fTiempoControlEntrada = 3;
		byte bContadorTiempos;
		String sSerieTiempos = "";
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir los 5 tiempos y validar
		do {
			for (bContadorTiempos = 1; bContadorTiempos <= 5; bContadorTiempos++) {
				do {
					System.out.print("Introduce el tiempo " + bContadorTiempos + " ("+fTiempoControlEntrada+"...50): ");
					try {
						fTiempoLlegada = Float.parseFloat(teclado.readLine());
					} catch (Exception e) {
						fTiempoLlegada = -1;
					}
					if ((fTiempoLlegada < 3 || fTiempoLlegada > 50) || (fTiempoLlegada < fTiempoControlEntrada)) {
						System.err.println("El tiempo introducido tiene que ser mayor que el anterior, esta fuera de rango o caracter invalido. ");
					}
				} while ((fTiempoLlegada < 3 || fTiempoLlegada > 50) || (fTiempoLlegada < fTiempoControlEntrada));
				
//				Comprobacion si se ha lleqado al maximo del tiempo y no han llegado todos los objetos. Si no se umple Calcula la diferencia.
				if (fTiempoLlegada == 50 && bContadorTiempos < 5) {
					bContadorTiempos = 6;
				} else {
					if (bContadorTiempos == 1) {
						fTiempoControl = fTiempoLlegada;
					}
					sSerieTiempos += (fTiempoLlegada - fTiempoControl) + ", ";
					fTiempoControlEntrada = fTiempoLlegada;
				}
			}
		} while (fTiempoLlegada < 50 && bContadorTiempos < 5);
		

//		Mostrar por consola el resultado
		if (fTiempoLlegada == 50 && bContadorTiempos == 7) {
			System.err.println("\n" + "HA LLEGADO AL LIMITE del tiempo antes de que llegue el ultimo objeto. El programa ha terminado.");
		} else  {
			System.out.println("\n" + "La diferencia con respecto al primero en llegar es : "
					+ sSerieTiempos.substring(0, sSerieTiempos.length() - 2) + ".");
		}
	}
}
