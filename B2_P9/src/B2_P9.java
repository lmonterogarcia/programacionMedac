import java.io.BufferedReader;
import java.io.InputStreamReader;
public class B2_P9 {
	public static void main(String[] args) {
//		Declaracion de variables
		byte bDia, bMes, bDiaMax;
		short shAnio;
		boolean booBisiesto;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

//		Pedir las variables al usuarios y validar y crear control para la siguiente fase
		//Anio
		do {
			System.out.print("Introduce el anio (1...3000): ");
			try {
				shAnio=Short.parseShort(teclado.readLine());
			} catch (Exception e) {
				shAnio=-1;
			}
		} while (shAnio<= 1 || shAnio>3000);
		if ((shAnio%4==0 && shAnio%100!=0) || shAnio%400==0) {
			booBisiesto = true;
		} else {
			booBisiesto = false;
		}
		//Mes
		do {
			System.out.print("Introduce el mes (1...12): ");
			try {
				bMes=Byte.parseByte(teclado.readLine());
			} catch (Exception e) {
				bMes=-1;
			}
		} while (bMes<= 1 || bMes>12);
		if (bMes==2) {
			if (booBisiesto) {
				bDiaMax = 29;
			} else {
				bDiaMax = 28;
			}
		} else if (bMes==4 || bMes==6 || bMes==9 || bMes==11) {
			bDiaMax = 30;
		} else {
			bDiaMax = 31;
		}
		//Dia
		do {
			System.out.print("Introduce el dia (1...31): ");
			try {
				bDia=Byte.parseByte(teclado.readLine());
			} catch (Exception e) {
				bDia=-1;
			}
		} while (bDia<= 1 || bDia>31);
		
//		Verificar si la fecha es correcta
		if (bDia<=bDiaMax) {
			System.out.println(bDia+"/"+bMes+"/"+shAnio+" es correcta.");
		} else {
			System.out.println(bDia+"/"+bMes+"/"+shAnio+" es incorrecta.");
		}
	}
}