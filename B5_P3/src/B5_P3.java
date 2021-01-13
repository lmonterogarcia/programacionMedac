
public class B5_P3 {

	public static void main(String[] args) {
		float[][] aNumerosReales = {{1.6f,1.5f,0.2f,1.3f,1.8f},{1.8f,1.2f,1.5f,1.4f,1.9f},{1.9f,0.6f,0.8f,1.5f,1.6f},{1.6f,1.5f,1.5f,1.5f,1.5f}};

		System.out.println(imprimeMatrizFloat(aNumerosReales));
		System.out.println("\n"+imprimeMatrizChar(realesToColor(aNumerosReales)));
		System.out.println("\nColor/es mayoritario/s "+modaMatrizChar(ordenarMatrizBurbujaChar(realesToColor(aNumerosReales))));
		System.out.println("\n"+informeSiempreSeExpresan(realesToColor(aNumerosReales)));
	}

	private static char[][] realesToColor(float[][] aMatriz) {
		char[][] aColores = new char[aMatriz.length][aMatriz[0].length];
		final float FUMBRAL = 1.5F;
		for (int iContadorFilas = 0; iContadorFilas < aColores.length; iContadorFilas++) {
			for (int iContadorColumnas = 0; iContadorColumnas < aColores[iContadorFilas].length; iContadorColumnas++) {
				if (aMatriz[iContadorFilas][iContadorColumnas] < FUMBRAL) {
					aColores[iContadorFilas][iContadorColumnas] = 'R';
				} else if (aMatriz[iContadorFilas][iContadorColumnas] > FUMBRAL) {
					aColores[iContadorFilas][iContadorColumnas] = 'V';
				} else {
					aColores[iContadorFilas][iContadorColumnas] = 'A';
				}
			}
		}

		return aColores;
	}
	
	private static String informeSiempreSeExpresan(char[][] aMatriz) {
		String sInforme = "";
		
		for (int iContador = 0; iContador < aMatriz[0].length; iContador++) {
			if (siempreSeExpresa(aMatriz, iContador)) {
				sInforme += "El gen "+iContador+" siempre se expresa.\n";
			}
		}
		 if (sInforme == "") {
			sInforme += "No hay ningun gen que siempre se exprese";
		}
		return sInforme;
	}
	
	private static boolean siempreSeExpresa(char[][] aMatriz, int Columna ) {
		int iFilas = 0;
		boolean booSeExpresa = true;
		
		while (booSeExpresa && iFilas < aMatriz.length) {
		if (aMatriz[iFilas][Columna] != 'V') {
			booSeExpresa = false;
		}
			iFilas++;
		}
		
		return booSeExpresa;
	}
	
	public static String imprimeMatrizFloat(float[][] aMatriz) {
		String sResultado = "";
		for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
			for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
				sResultado += aMatriz[iContadorFila][iContadorColumna];
				if (iContadorColumna < aMatriz[iContadorFila].length - 1) {
					sResultado += " , ";
				}
			}
			sResultado += "\n";
		}
		return sResultado;
	}
	
	public static String imprimeMatrizChar(char[][] aMatriz) {
		String sResultado = "";
		for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
			for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
				sResultado += aMatriz[iContadorFila][iContadorColumna];
				if (iContadorColumna < aMatriz[iContadorFila].length - 1) {
					sResultado += " , ";
				}
			}
			sResultado += "\n";
		}
		return sResultado;
	}
	
	
	private static String modaMatrizChar(char[][] aMatriz) {
		String sModa = "";
		int iRepeticiones = 1, iControlRepeticiones = 1;
	

		for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
			for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {

				if ((iContadorColumnas == aMatriz[iContadorFilas].length - 1) && (iContadorFilas != aMatriz.length - 1)) {
					if (aMatriz[iContadorFilas][iContadorColumnas] == aMatriz[iContadorFilas + 1][0]) {
						iRepeticiones++;
					} else {

						if (iRepeticiones > iControlRepeticiones) {
							sModa = "("+iRepeticiones+" repeticiones): "+ String.valueOf(aMatriz[iContadorFilas][iContadorColumnas]);
							iControlRepeticiones = iRepeticiones;
							iRepeticiones = 1;

						} else if (iRepeticiones == iControlRepeticiones) {
							sModa += ", " + aMatriz[iContadorFilas][iContadorColumnas];
							iControlRepeticiones = iRepeticiones;
							iRepeticiones = 1;

						} else {
							iRepeticiones = 1;
						}
					}
				} else if (iContadorColumnas != aMatriz[iContadorFilas].length - 1) {
					if (aMatriz[iContadorFilas][iContadorColumnas] == aMatriz[iContadorFilas][iContadorColumnas + 1]) {
						iRepeticiones++;
					} else {

						if ((iContadorFilas == 0 && iContadorColumnas == 0) || iRepeticiones > iControlRepeticiones) {
							sModa =  "("+iRepeticiones+" repeticiones): "+ String.valueOf(aMatriz[iContadorFilas][iContadorColumnas]);
							iControlRepeticiones = iRepeticiones;
							iRepeticiones = 1;

						} else if (iRepeticiones == iControlRepeticiones) {
							sModa += ", " + aMatriz[iContadorFilas][iContadorColumnas];
							iControlRepeticiones = iRepeticiones;
							iRepeticiones = 1;

						} else {
							iRepeticiones = 1;
						}
					}
				} else {
					
					if (iRepeticiones > iControlRepeticiones) {
						sModa =  "("+iRepeticiones+" repeticiones): "+ String.valueOf(aMatriz[iContadorFilas][iContadorColumnas]);
						iControlRepeticiones = iRepeticiones;
						iRepeticiones = 1;

					} else if (iRepeticiones == iControlRepeticiones) {
						sModa += ", " + aMatriz[iContadorFilas][iContadorColumnas];
						iControlRepeticiones = iRepeticiones;
						iRepeticiones = 1;

					} 
				}
			}
		}
		return sModa;
	}
	
	private static char[][] ordenarMatrizBurbujaChar(char[][] aMatriz) {
		char iTemp;

		for (int iContadorFila1 = 0; iContadorFila1 < aMatriz.length; iContadorFila1++) {
			for (int iContadorColumna1 = 0; iContadorColumna1 < aMatriz[iContadorFila1].length; iContadorColumna1++) {
				for (int iContadorFila2 = 0; iContadorFila2 < aMatriz.length; iContadorFila2++) {
					for (int iContadorColumna2 = 0; iContadorColumna2 < aMatriz[iContadorFila2].length; iContadorColumna2++) {
						if (aMatriz[iContadorFila1][iContadorColumna1] < aMatriz[iContadorFila2][iContadorColumna2]) {
							iTemp = aMatriz[iContadorFila1][iContadorColumna1];
							aMatriz[iContadorFila1][iContadorColumna1] = aMatriz[iContadorFila2][iContadorColumna2];
							aMatriz[iContadorFila2][iContadorColumna2] = iTemp;
						}
					}
				}
			}
		}
		return aMatriz;
	}
}
	
	
