import java.io.BufferedReader;
import java.io.InputStreamReader;


public class B2_P8 {

	public static void main(String[] args) {
//		Declarar las variables
		float fLadoTrianguloA, fLadoTrianguloB, fLadoTrianguloC;
		byte bTipoTriangulo;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
//		Pedir al usuario la longitud de los lados del triangulo
		//Lado A
		do {
			System.out.print("Introduce la longitud del lado A (0...500): ");
			try {
				fLadoTrianguloA = Float.parseFloat(teclado.readLine());
			} catch (Exception e) {
				fLadoTrianguloA = -1;
			}
			if (fLadoTrianguloA < 0 || fLadoTrianguloA > 500) {
				System.out.print("Longitud fuera de rango o caracter invalido. ");
			}
		} while (fLadoTrianguloA < 0 || fLadoTrianguloA > 500);
		//Lado B
		do {
			System.out.print("Introduce la longitud del lado B (0...500): ");
			try {
				fLadoTrianguloB = Float.parseFloat(teclado.readLine());
			} catch (Exception e) {
				fLadoTrianguloB = -1;
			}
			if (fLadoTrianguloB < 0 || fLadoTrianguloB > 500) {
				System.out.print("Longitud fuera de rango o caracter invalido. ");
			}
		} while (fLadoTrianguloB < 0 || fLadoTrianguloB > 500);
		//Lado C
		do {
			System.out.print("Introduce la longitud del lado C (0...500): ");
			try {
				fLadoTrianguloC = Float.parseFloat(teclado.readLine());
			} catch (Exception e) {
				fLadoTrianguloC = -1;
			}
			if (fLadoTrianguloC < 0 || fLadoTrianguloC > 500) {
				System.out.print("Longitud fuera de rango o caracter invalido. ");
			}
		} while (fLadoTrianguloC < 0 || fLadoTrianguloC > 500);
		
//		Calcular que tipo de triangulo es
		if (fLadoTrianguloA == (fLadoTrianguloB+fLadoTrianguloC)) {
			bTipoTriangulo = 1;
		} else if (fLadoTrianguloA < (fLadoTrianguloB+fLadoTrianguloC)) {
			bTipoTriangulo = 2;
		} else {
			bTipoTriangulo = 3;
		}
		
//		Escribir por consola el resutlado
		if (bTipoTriangulo == 1) {
			System.out.println("\n"+"Segun la longitud de los lados introducidos es un triangulo rectangulo");
		} else if (bTipoTriangulo == 2) {
			System.out.println("\n"+"Segun la longitud de los lados introducidos es un triangulo acutangulo");
		} else {
			System.out.println("\n"+"Segun la longitud de los lados introducidos es un triangulo obtusangulo");
		}
	}
}
