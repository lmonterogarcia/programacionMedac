import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_P3 {

	public static void main(String[] args) {
//		Declarar variables para lectura de teclado
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		String cadenaLeida;
		
//		Declaracion Variables de entrada, internas y salida.
		byte bHorasTrabajadas, bHorasExtras;
		final byte BEUROSHORASTRABAJADAS=10;
		final byte BEUROSHORASEXTRAS=20;
		short shSalarioSemanal;
		
//		Pedir las horas trabajadas y extras que ha trabajado
		
		//Trabajadas
		System.out.print("Introduce las horas trabajadas (0...40): ");
		//Leer
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		bHorasTrabajadas=Byte.parseByte(cadenaLeida);
				
		//Extras
		System.out.print("Introduce las horas trabajadas (0...80): ");
		//Leer
		try {
			cadenaLeida = lector.readLine();
		} catch (Exception e) {
			cadenaLeida = "";
		}
		bHorasExtras=Byte.parseByte(cadenaLeida);
		
//		Calcular Salario e inicializar la variable de Salario
		shSalarioSemanal=(short)(bHorasTrabajadas*BEUROSHORASTRABAJADAS + bHorasExtras*BEUROSHORASEXTRAS);
		
//		Enseniar por consola el resultado
		System.out.println(bHorasTrabajadas+" horas  trabajadas  y "+bHorasExtras+"  horas  extras  corresponden  a  un  salario  semanal  de  "+shSalarioSemanal+" euros.");
	}

}
