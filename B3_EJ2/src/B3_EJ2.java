import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B3_EJ2 {

	public static void main(String[] args) {
//		Declarar las variables
		float fLadoTrianguloA, fLadoTrianguloB, fLadoTrianguloC;
		String sTipoTriangulo;
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
				System.err.print("Longitud fuera de rango o caracter invalido. ");
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
				System.err.print("Longitud fuera de rango o caracter invalido. ");
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
				System.err.print("Longitud fuera de rango o caracter invalido. ");
			}
		} while (fLadoTrianguloC < 0 || fLadoTrianguloC > 500);
		
//		Calcular que tipo de triangulo es
		if (fLadoTrianguloA == fLadoTrianguloB && fLadoTrianguloB == fLadoTrianguloC) {
			sTipoTriangulo = "equilatero";
		} else if ((fLadoTrianguloA != fLadoTrianguloB) && (fLadoTrianguloB != fLadoTrianguloC) && (fLadoTrianguloA != fLadoTrianguloC)) {
			sTipoTriangulo = "escaleno";
		} else {
			sTipoTriangulo = "isoceles";
		}
		
//		Escribir por consola el resutlado
		
			System.out.println("\n"+"Segun la longitud de los lados introducidos es un triangulo "+sTipoTriangulo+".");
	}
}
