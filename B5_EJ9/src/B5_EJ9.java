import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class B5_EJ9 {

	public static void main(String[] args) {
		byte[][] aMatriz = crearMatrizRandomByte((int) leer("Introduce el numero de FILAS ", 1, 30, -1, -1, (byte) 3),
				(int) leer("Introduce el numero COLUMNAS ", 1, 30, -1, -1, (byte) 3), (byte) 1, (byte) 10);

		System.out.println("\n" + imprimeMatrizByte(aMatriz));
		System.out.println("\n" + imprimeMatrizInt(ordenarMatrizBurbuja(byteToIntMatriz(aMatriz))));
		System.out.println("La moda de la matriz es " + modaMatriz(ordenarMatrizBurbuja(byteToIntMatriz(aMatriz))));
	}
	
	/*
	 * ########################################
	 * ##### # Funciones especificas para este programa  # #####
	 * ########################################
	 *
	 *
	 *Siempre el codigo es creado para ser reutilizado. Por lo que la mayoria de las veces el tipado es int, a no ser que sea muy es
	 *a no ser que sea muy especifica del Ejercicio/Problema.
	 */
	
	private static String modaMatriz(int[][] aMatriz) {
		String sModa = "";
		int iRepeticiones = 1, iControlRepeticiones = 1;
	

		for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
			for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {

				if ((iContadorColumnas == aMatriz[iContadorFilas].length - 1) && (iContadorFilas != aMatriz.length - 1)) {
					if (aMatriz[iContadorFilas][iContadorColumnas] == aMatriz[iContadorFilas + 1][0]) {
						iRepeticiones++;
					} else {

						if (iRepeticiones > iControlRepeticiones) {
							sModa = "("+iRepeticiones+" repeticiones) "+String.valueOf(aMatriz[iContadorFilas][iContadorColumnas]);
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
							sModa =  "("+iRepeticiones+" repeticiones) "+String.valueOf(aMatriz[iContadorFilas][iContadorColumnas]);
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
						sModa =  "("+iRepeticiones+" repeticiones) "+String.valueOf(aMatriz[iContadorFilas][iContadorColumnas]);
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
	
	private static int[][] ordenarMatrizBurbuja(int[][] aMatriz) {
		int iTemp;

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
//			double dTemporal;
//			int iContadorI, iContadorFila, iContadorColumna, iElementos = aMatriz.length * aMatriz[0].length;
//
//			for (iContadorI = 1; iContadorI < iElementos; iContadorI++) {
//
////				for (iContadorFila = (aMatriz.length - 1); iContadorFila >= iContadorI; iContadorFila--) {
//				for (iContadorFila = (aMatriz.length - 1); iContadorFila >= 0; iContadorFila--) {
//					
//					for (iContadorColumna = aMatriz[iContadorFila].length - 1; iContadorColumna >= 0; iContadorColumna--) {
//						
//						if (iContadorColumna  == 0 && iContadorFila != 0) {
//
//							if (aMatriz[iContadorFila][iContadorColumna] < aMatriz[iContadorFila - 1][aMatriz[iContadorFila].length - 1]) {
//								dTemporal = aMatriz[iContadorFila][iContadorColumna];
//								aMatriz[iContadorFila][iContadorColumna] = aMatriz[iContadorFila - 1][aMatriz[iContadorFila].length - 1];
//								aMatriz[iContadorFila - 1][aMatriz[iContadorFila].length - 1] = (int) dTemporal;
//							}
//							
//						} else if (iContadorColumna  != 0 && iContadorFila >= 0)  {
//							
//							if (aMatriz[iContadorFila][iContadorColumna] < aMatriz[iContadorFila][iContadorColumna - 1]) {
//								dTemporal = aMatriz[iContadorFila][iContadorColumna];
//								aMatriz[iContadorFila][iContadorColumna] = aMatriz[iContadorFila][iContadorColumna - 1];
//								aMatriz[iContadorFila][iContadorColumna - 1] = (int) dTemporal;
//							}
//						}
//						
////						System.out.println(imprimeMatriz(aMatriz));
//					}
//				}
//			}
//	                  NO HE TENIDO COJONES QUE FUNCIONE BIEN CON 3 FOR :(.	LOS ORDENA, PERO SIEMPRE PASA POR TODOS LOS ELEMENTOS.

	
	}
		
	/*
	 * #######################################
	 * ############ # LIBRERIA CASTING # ###########
	 * #######################################
	 */
	
	// Casting VECTOR#################################################################
	private static int[] byteToIntVector(byte[] aVector) {
		int[] aVectorCasteado = new int[aVector.length];
		try {
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVectorCasteado[iContador] = aVector[iContador];
			}
		} catch (Exception e) {
			System.err.println("Error al hacer el casting");
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVectorCasteado[iContador] = -1;
			}
		}
		return aVectorCasteado;
	}
	private static boolean[] byteToBooleanVector(byte[] aVector) {
		boolean[] aVectorCasteado = new boolean[aVector.length];
		try {
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				if (aVector[iContador] == 1) {
					aVectorCasteado[iContador] = true;
				} else {
					aVectorCasteado[iContador] = false;
				}
			}
		} catch (Exception e) {
			System.err.println("Error al hacer el casting");
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVectorCasteado[iContador] = false;
			}
		}
		return aVectorCasteado;
	}
	private static int[] shortToIntVector(short[] aVector) {
		int[] aVectorCasteado = new int[aVector.length];
		try {
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVectorCasteado[iContador] = aVector[iContador];
			}
		} catch (Exception e) {
			System.err.println("Error al hacer el casting");
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVectorCasteado[iContador] = -1;
			}
		}
		return aVectorCasteado;
	}
	private static byte[] intToByteVector(int[] aVector) {
		byte[] aVectorCasteado = new byte[aVector.length];
		try {
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVectorCasteado[iContador] = (byte) aVector[iContador];
			}
		} catch (Exception e) {
			System.err.println("Error al hacer el casting");
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVectorCasteado[iContador] = -1;
			}
		}
		return aVectorCasteado;
	}
	private static short[] intToShortVector(int[] aVector) {
		short[] aVectorCasteado = new short[aVector.length];
		try {
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVectorCasteado[iContador] = (short) aVector[iContador];
			}
		} catch (Exception e) {
			System.err.println("Error al hacer el casting");
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVectorCasteado[iContador] = -1;
			}
		}
		return aVectorCasteado;
	}
	private static double[] floatToDoubleVector(float[] aVector) {
		double[] aVectorCasteado = new double[aVector.length];
		try {
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVectorCasteado[iContador] = aVector[iContador];
			}
		} catch (Exception e) {
			System.err.println("Error al hacer el casting");
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVectorCasteado[iContador] = -1;
			}
		}
		return aVectorCasteado;
	}
	private static float[] doubleToFloatVector(double[] aVector) {
		float[] aVectorCasteado = new float[aVector.length];
		try {
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVectorCasteado[iContador] = (float) aVector[iContador];
			}
		} catch (Exception e) {
			System.err.println("Error al hacer el casting");
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVectorCasteado[iContador] = -1;
			}
		}
		return aVectorCasteado;
	}
	// Casting MATRIZ#################################################################
	private static int[][] byteToIntMatriz(byte[][] aMatriz) {
		int[][] aMatrizCasteado = new int[aMatriz.length][aMatriz[0].length];
		try {
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					aMatrizCasteado[iContadorFila][iContadorColumna] = aMatriz[iContadorFila][iContadorColumna];
				}
			}
		} catch (Exception e) {
			System.err.println("Error al hacer el casting");
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					aMatrizCasteado[iContadorFila][iContadorColumna] = -1;
				}
			}
		}
		return aMatrizCasteado;
	}
	private static boolean[][] byteToBooleanMatriz(byte[][] aMatriz) {
		boolean[][] aMatrizCasteado = new boolean[aMatriz.length][aMatriz[0].length];
		try {
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					if (aMatriz[iContadorFila][iContadorColumna] == 1) {
						aMatrizCasteado[iContadorFila][iContadorColumna] = true;
					} else {
						aMatrizCasteado[iContadorFila][iContadorColumna] = false;
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Error al hacer el casting");
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					aMatrizCasteado[iContadorFila][iContadorColumna] = false;
				}
			}
		}
		return aMatrizCasteado;
	}
	private static int[][] shortToIntMatriz(short[][] aMatriz) {
		int[][] aMatrizCasteado = new int[aMatriz.length][aMatriz[0].length];
		try {
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					aMatrizCasteado[iContadorFila][iContadorColumna] = aMatriz[iContadorFila][iContadorColumna];
				}
			}
		} catch (Exception e) {
			System.err.println("Error al hacer el casting");
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					aMatrizCasteado[iContadorFila][iContadorColumna] = -1;
				}
			}
		}
		return aMatrizCasteado;
	}
	private static byte[][] intToByteMatriz(int[][] aMatriz) {
		byte[][] aMatrizCasteado = new byte[aMatriz.length][aMatriz[0].length];
		try {
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					aMatrizCasteado[iContadorFila][iContadorColumna] = (byte) aMatriz[iContadorFila][iContadorColumna];
				}
			}
		} catch (Exception e) {
			System.err.println("Error al hacer el casting");
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					aMatrizCasteado[iContadorFila][iContadorColumna] = -1;
				}
			}
		}
		return aMatrizCasteado;
	}
	private static short[][] intToShortMatriz(int[][] aMatriz) {
		short[][] aMatrizCasteado = new short[aMatriz.length][aMatriz[0].length];
		try {
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					aMatrizCasteado[iContadorFila][iContadorColumna] = (short) aMatriz[iContadorFila][iContadorColumna];
				}
			}
		} catch (Exception e) {
			System.err.println("Error al hacer el casting");
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					aMatrizCasteado[iContadorFila][iContadorColumna] = -1;
				}
			}
		}
		return aMatrizCasteado;
	}
	private static double[][] floatToDoubleMatriz(float[][] aMatriz) {
		double[][] aMatrizCasteado = new double[aMatriz.length][aMatriz[0].length];
		try {
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					aMatrizCasteado[iContadorFila][iContadorColumna] = aMatriz[iContadorFila][iContadorColumna];
				}
			}
		} catch (Exception e) {
			System.err.println("Error al hacer el casting");
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					aMatrizCasteado[iContadorFila][iContadorColumna] = -1;
				}
			}
		}
		return aMatrizCasteado;
	}
	private static float[][] doubleToFloatMatriz(double[][] aMatriz) {
		float[][] aMatrizCasteado = new float[aMatriz.length][aMatriz[0].length];
		try {
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					aMatrizCasteado[iContadorFila][iContadorColumna] = (float) aMatriz[iContadorFila][iContadorColumna];
				}
			}
		} catch (Exception e) {
			System.err.println("Error al hacer el casting");
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					aMatrizCasteado[iContadorFila][iContadorColumna] = -1;
				}
			}
		}
		return aMatrizCasteado;
	}
	private static int[][] booleanTointMatriz(boolean[][] aMatriz) {
		int[][] aMatrizCasteado = new int[aMatriz.length][aMatriz[0].length];
		try {
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					if (aMatriz[iContadorFila][iContadorColumna] == true) {
						aMatrizCasteado[iContadorFila][iContadorColumna] = 1;
					} else {
						aMatrizCasteado[iContadorFila][iContadorColumna] = 0;
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Error al hacer el casting");
			for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
					aMatrizCasteado[iContadorFila][iContadorColumna] = -1;
				}
			}
		}
		return aMatrizCasteado;
	}
	
	/*
	 * ######################################
	 * ########### # LIBRERIA IMPRIMIR # ###########
	 * ######################################
	 */
	
	// Imprimir VECTOR#################################################################
	public static String imprimeVectorByte(byte[] aVector) {
		String sResultado = "";
		for(int iContador = 0; iContador < aVector.length; iContador++) {
			sResultado += aVector[iContador];
			if(iContador < aVector.length - 1) {
				sResultado += ",";
			}
		}
		return sResultado;
	}
	public static String imprimeVectorShort(short[] aVector) {
		String sResultado = "";
		for(int iContador = 0; iContador < aVector.length; iContador++) {
			sResultado += aVector[iContador];
			if(iContador < aVector.length - 1) {
				sResultado += ",";
			}
		}
		return sResultado;
	}
	public static String imprimeVectorInt(int[] aVector) {
		String sResultado = "";
		for(int iContador = 0; iContador < aVector.length; iContador++) {
			sResultado += aVector[iContador];
			if(iContador < aVector.length - 1) {
				sResultado += ",";
			}
		}
		return sResultado;
	}
	public static String imprimeVectorLong(long[] aVector) {
		String sResultado = "";
		for(int iContador = 0; iContador < aVector.length; iContador++) {
			sResultado += aVector[iContador];
			if(iContador < aVector.length - 1) {
				sResultado += ",";
			}
		}
		return sResultado;
	}
	public static String imprimeVectorFloat(float[] aVector) {
		String sResultado = "";
		for(int iContador = 0; iContador < aVector.length; iContador++) {
			sResultado += aVector[iContador];
			if(iContador < aVector.length - 1) {
				sResultado += ",";
			}
		}
		return sResultado;
	}
	public static String imprimeVectorDouble(double[] aVector) {
		String sResultado = "";
		for(int iContador = 0; iContador < aVector.length; iContador++) {
			sResultado += aVector[iContador];
			if(iContador < aVector.length - 1) {
				sResultado += ",";
			}
		}
		return sResultado;
	}
	public static String imprimeVectorString(String[] aVector) {
		String sResultado = "";
		for(int iContador = 0; iContador < aVector.length; iContador++) {
			sResultado += aVector[iContador];
			if(iContador < aVector.length - 1) {
				sResultado += ",";
			}
		}
		return sResultado;
	}
	public static String imprimeVectorChar(char[] aVector) {
		String sResultado = "";
		for(int iContador = 0; iContador < aVector.length; iContador++) {
			sResultado += aVector[iContador];
			if(iContador < aVector.length - 1) {
				sResultado += ",";
			}
		}
		return sResultado;
	}
	public static String imprimeVectorBoolean(boolean[] aVector) {
		String sResultado = "";
		for(int iContador = 0; iContador < aVector.length; iContador++) {
			if (aVector[iContador] == true) {
				sResultado += "1";
			} else {
				sResultado += "0";
			}
			if(iContador < aVector.length - 1) {
				sResultado += ",";
			}
		}
		return sResultado;
	}
	
	// Imprimir MATRIZ#################################################################
	public static String imprimeMatrizByte(byte[][] aMatriz) {
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
	
	public static String imprimeMatrizShort(short[][] aMatriz) {
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
	
	public static String imprimeMatrizInt(int[][] aMatriz) {
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
	
	public static String imprimeMatrizLong(long[][] aMatriz) {
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
	
	public static String imprimeMatrizDouble(double[][] aMatriz) {
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
	
	public static String imprimeMatrizString(String[][] aMatriz) {
		String sResultado = "";
		for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
			for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
				sResultado += aMatriz[iContadorFila][iContadorColumna];
				if (iContadorColumna < aMatriz[iContadorFila].length - 1) {
					sResultado += " || ";
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
	public static String imprimeMatrizBoolean(boolean[][] aMatriz) {
		String sResultado = "";
		for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
			for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
				if (aMatriz[iContadorFila][iContadorColumna] == true) {
					sResultado += "1";
				} else {
					sResultado += "0";
				}
				if (iContadorColumna < aMatriz[iContadorFila].length - 1) {
					sResultado += " , ";
				}
			}
			sResultado += "\n";
		}
		return sResultado;
	}


	/*
	 * #####################################
	 * ############ # LIBRERIA LEER # ############
	 * #####################################
	 */

	
	// Leer VARIABLE SIMPLE###########################################################
	private static Object leer(String sMensaje, long lMinimo, long lMaximo, double dMinimo, double dMaximo,
			byte bEstado) {
		Object oNumero;
		switch (bEstado) {
		case 1:
			oNumero = pideNumeroByte(sMensaje, lMinimo, lMaximo);
			break;
		case 2:
			oNumero = pideNumeroShort(sMensaje, lMinimo, lMaximo);
			break;
		case 3:
			oNumero = pideNumeroInt(sMensaje, lMinimo, lMaximo);
			break;
		case 4:
			oNumero = pideNumeroLong(sMensaje, lMinimo, lMaximo);
			break;
		case 5:
			oNumero = pideNumeroFloat(sMensaje, dMinimo, dMaximo);
			break;
		case 6:
			oNumero = pideNumeroDouble(sMensaje, dMinimo, dMaximo);
			break;
		case 7:
			oNumero = pideNumeroDoubleNoInclusivo(sMensaje, dMinimo, dMaximo);
			break;
		default:
			oNumero = -1;
		}
		return oNumero;
	}

	private static byte pideNumeroByte(String sMensaje, long lMinimo, long lMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		byte bNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "(" + lMinimo + " a " + lMaximo + "): ");
			try {
				bNumero = Byte.parseByte(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
			if (bFallo || (bNumero < lMinimo || bNumero > lMaximo)) {
				System.err.println("Numero fuera de rango o caracter invalido");
			}
		} while (bFallo || (bNumero < lMinimo || bNumero > lMaximo));

		return bNumero;
	}

	private static short pideNumeroShort(String sMensaje, long lMinimo, long lMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		short shNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "(" + lMinimo + " a " + lMaximo + "): ");
			try {
				shNumero = Short.parseShort(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
			if (bFallo || (shNumero < lMinimo || shNumero > lMaximo)) {
				System.err.println("Numero fuera de rango o caracter invalido");
			}
		} while (bFallo || (shNumero < lMinimo || shNumero > lMaximo));

		return shNumero;
	}

	private static int pideNumeroInt(String sMensaje, long lMinimo, long lMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		int iNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "(" + lMinimo + " a " + lMaximo + "): ");
			try {
				iNumero = Integer.parseInt(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
			if (bFallo || (iNumero < lMinimo || iNumero > lMaximo)) {
				System.err.println("Numero fuera de rango o caracter invalido");
			}
		} while (bFallo || (iNumero < lMinimo || iNumero > lMaximo));

		return iNumero;
	}

	private static long pideNumeroLong(String sMensaje, long lMinimo, long lMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		long lNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "(" + lMinimo + " a " + lMaximo + "): ");
			try {
				lNumero = Long.parseLong(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
			if (bFallo || (lNumero < lMinimo || lNumero > lMaximo)) {
				System.err.println("Numero fuera de rango o caracter invalido");
			}
		} while (bFallo || (lNumero < lMinimo || lNumero > lMaximo));

		return lNumero;
	}

	private static float pideNumeroFloat(String sMensaje, double dMinimo, double dMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		float fNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "(" + dMinimo + " a " + dMaximo + "): ");
			try {
				fNumero = Float.parseFloat(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
			if (bFallo || (fNumero < dMinimo || fNumero > dMaximo)) {
				System.err.println("Numero fuera de rango o caracter invalido");
			}
		} while (bFallo || (fNumero < dMinimo || fNumero > dMaximo));

		return fNumero;
	}

	private static double pideNumeroDouble(String sMensaje, double dMinimo, double dMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		double dNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "(" + dMinimo + " a " + dMaximo + "): ");
			try {
				dNumero = Double.parseDouble(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
			if (bFallo || (dNumero < dMinimo || dNumero > dMaximo)) {
				System.err.println("Numero fuera de rango o caracter invalido");
			}
		} while (bFallo || (dNumero < dMinimo || dNumero > dMaximo));

		return dNumero;
	}

//	Nueva funcion para Libreria Leer. Lee un double dentro de un rango sin llegar a los limites
	private static double pideNumeroDoubleNoInclusivo(String sMensaje, double dMinimo, double dMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		double dNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "(no inclusivo entre " + dMinimo + " y " + dMaximo + "): ");
			try {
				dNumero = Double.parseDouble(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
			if (bFallo || (dNumero <= dMinimo || dNumero >= dMaximo)) {
				System.err.println("Numero fuera de rango o caracter invalido");
			}
		} while (bFallo || (dNumero <= dMinimo || dNumero >= dMaximo));

		return dNumero;
	}

	// Leer VECTOR##########################################################################
	private static Object[] leerVector(String sMensaje, int iTamanio, long lMinimo, long lMaximo, double dMinimo, double dMaximo,
			byte bEstado) {
		Object[] aoNumero = new Object[iTamanio];
		switch (bEstado) {
		case 1:
			aoNumero = pideVectorByte(sMensaje,iTamanio, lMinimo, lMaximo);
			break;
		case 2:
			aoNumero = pideVectorShort(sMensaje,iTamanio, lMinimo, lMaximo);
			break;
		case 3:
			aoNumero = pideVectorInt(sMensaje,iTamanio, lMinimo, lMaximo);
			break;
		case 4:
			aoNumero = pideVectorLong(sMensaje,iTamanio, lMinimo, lMaximo);
			break;
		case 5:
			aoNumero = pideVectorFloat(sMensaje,iTamanio, dMinimo, dMaximo);
			break;
		case 6:
			aoNumero = pideVectorDouble(sMensaje,iTamanio, dMinimo, dMaximo);
			break;
		default:
			aoNumero = new Object[iTamanio];
		}
		return aoNumero;
	}
	public static Object[] pideVectorByte(String sMensaje, int iTamanio, long lMin, long lMax) {

		Object[] aVector = new Object[iTamanio];

		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = (byte) leer(sMensaje + (iContador + 1) + ": ", (long) lMin, (long) lMax, -1, -1,
					(byte) 1);
		}

		return aVector;
	}
	
	public static Object[] pideVectorShort(String sMensaje, int iTamanio, long lMin, long lMax) {

		Object[] aVector = new Object[iTamanio];

		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = (short) leer(sMensaje + (iContador + 1) + ": ", (long) lMin, (long) lMax, -1, -1,
					(byte) 2);
		}

		return aVector;
	}
	
	public static Object[] pideVectorInt(String sMensaje, int iTamanio, long lMin, long lMax) {

		Object[] aVector = new Object[iTamanio];

		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = (int) leer(sMensaje + (iContador + 1) + ": ", (long) lMin, (long) lMax, -1, -1,
					(byte) 3);
		}

		return aVector;
	}
	
	public static Object[] pideVectorLong(String sMensaje, int iTamanio, long lMin, long lMax) {

		Object[] aVector = new Object[iTamanio];

		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = (long) leer(sMensaje + (iContador + 1) + ": ", (long) lMin, (long) lMax, -1, -1,
					(byte) 4);
		}

		return aVector;
	}
	
	public static Object[] pideVectorFloat(String sMensaje, int iTamanio, double dMin, double dMax) {

		Object[] aVector = new Object[iTamanio];

		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = (float) leer(sMensaje + (iContador + 1) + ": ", -1, -1, dMin, dMax,
					(byte) 5);
		}

		return aVector;
	}
	
	public static Object[] pideVectorDouble(String sMensaje, int iTamanio, double dMin, double dMax) {

		Object[] aVector = new Object[iTamanio];

		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = (double) leer(sMensaje + (iContador + 1) + ": ", -1, -1, dMin, dMax,
					(byte) 6);
		}

		return aVector;
	}
	
	// Leer MATRIZ##########################################################################
	private static Object[][] leerMatriz(String sMensaje, int iFilas, int iColumnas, long lMinimo, long lMaximo, double dMinimo, double dMaximo,
			byte bEstado) {
		Object[][] aoNumero = new Object[iFilas][iColumnas];
		switch (bEstado) {
		case 1:
			aoNumero = pideMatrizByte(sMensaje, iFilas, iColumnas, lMinimo, lMaximo);
			break;
		case 2:
			aoNumero = pideMatrizShort(sMensaje, iFilas, iColumnas, lMinimo, lMaximo);
			break;
		case 3:
			aoNumero = pideMatrizInt(sMensaje, iFilas, iColumnas, lMinimo, lMaximo);
			break;
		case 4:
			aoNumero = pideMatrizLong(sMensaje, iFilas, iColumnas, lMinimo, lMaximo);
			break;
		case 5:
			aoNumero = pideMatrizFloat(sMensaje, iFilas, iColumnas, dMinimo, dMaximo);
			break;
		case 6:
			aoNumero = pideMatrizDouble(sMensaje, iFilas, iColumnas, dMinimo, dMaximo);
			break;
		default:
			aoNumero = new Object[iFilas][iColumnas];
		}
		return aoNumero;
	}
	public static Object[][] pideMatrizByte(String sMensaje, int iFilas, int iColumnas, long lMin, long lMax) {

		Object[][] aVector = new Object[iFilas][iColumnas];

		for (int iContadorFila = 0; iContadorFila < aVector.length; iContadorFila++) {
			for (int iContadorColumna = 0; iContadorColumna < aVector[0].length; iContadorColumna++) {
				aVector[iContadorFila][iContadorColumna] = (byte) leer(sMensaje +"["+iContadorFila+"]"+"["+iContadorColumna+"]" + ": ", (long) lMin, (long) lMax, -1, -1,
						(byte) 1);
			}	
		}

		return aVector;
	}
	
	public static Object[][] pideMatrizShort(String sMensaje, int iFilas, int iColumnas, long lMin, long lMax) {

		Object[][] aVector = new Object[iFilas][iColumnas];

		for (int iContadorFila = 0; iContadorFila < aVector.length; iContadorFila++) {
			for (int iContadorColumna = 0; iContadorColumna < aVector[0].length; iContadorColumna++) {
				aVector[iContadorFila][iContadorColumna] = (byte) leer(sMensaje +"["+iContadorFila+"]"+"["+iContadorColumna+"]" + ": ", (long) lMin, (long) lMax, -1, -1,
						(byte) 2);
			}	
		}

		return aVector;
	}
	
	public static Object[][] pideMatrizInt(String sMensaje, int iFilas, int iColumnas, long lMin, long lMax) {

		Object[][] aVector = new Object[iFilas][iColumnas];

		for (int iContadorFila = 0; iContadorFila < aVector.length; iContadorFila++) {
			for (int iContadorColumna = 0; iContadorColumna < aVector[0].length; iContadorColumna++) {
				aVector[iContadorFila][iContadorColumna] = (byte) leer(sMensaje +"["+iContadorFila+"]"+"["+iContadorColumna+"]" + ": ", (long) lMin, (long) lMax, -1, -1,
						(byte) 3);
			}	
		}

		return aVector;
	}
	
	public static Object[][] pideMatrizLong(String sMensaje, int iFilas, int iColumnas, long lMin, long lMax) {

		Object[][] aVector = new Object[iFilas][iColumnas];

		for (int iContadorFila = 0; iContadorFila < aVector.length; iContadorFila++) {
			for (int iContadorColumna = 0; iContadorColumna < aVector[0].length; iContadorColumna++) {
				aVector[iContadorFila][iContadorColumna] = (byte) leer(sMensaje +"["+iContadorFila+"]"+"["+iContadorColumna+"]" + ": ", (long) lMin, (long) lMax, -1, -1,
						(byte) 4);
			}	
		}

		return aVector;
	}
	
	public static Object[][] pideMatrizFloat(String sMensaje, int iFilas, int iColumnas, double dMin, double dMax) {

		Object[][] aVector = new Object[iFilas][iColumnas];

		for (int iContadorFila = 0; iContadorFila < aVector.length; iContadorFila++) {
			for (int iContadorColumna = 0; iContadorColumna < aVector[0].length; iContadorColumna++) {
				aVector[iContadorFila][iContadorColumna] = (byte) leer(sMensaje +"["+iContadorFila+"]"+"["+iContadorColumna+"]" + ": ", -1, -1, dMin, dMax,
						(byte) 5);
			}	
		}

		return aVector;
	}
	
	public static Object[][] pideMatrizDouble(String sMensaje, int iFilas, int iColumnas, double dMin, double dMax) {

		Object[][] aVector = new Object[iFilas][iColumnas];

		for (int iContadorFila = 0; iContadorFila < aVector.length; iContadorFila++) {
			for (int iContadorColumna = 0; iContadorColumna < aVector[0].length; iContadorColumna++) {
				aVector[iContadorFila][iContadorColumna] = (byte) leer(sMensaje +"["+iContadorFila+"]"+"["+iContadorColumna+"]" + ": ", -1, -1, dMin, dMax,
						(byte) 6);
			}	
		}

		return aVector;
	}
	
	
	/*
	 * ######################################
	 * ########## # LIBRERIA CREAR RANDOM # ########
	 * ######################################
	 */

	
	// Crear VECTOR ##########################################################
	private static byte[] crearVectorRandomByte(int iTamanio, byte bMin, byte bMax) {

		byte[] aVector = new byte[iTamanio];
		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = (byte) ((bMin - 1) + Math.floor(Math.random() * (bMax) + 1));
		}
		return aVector;
	}
	private static short[] crearVectorRandomShort(int iTamanio, short shMin, short shMax) {

		short[] aVector = new short[iTamanio];
		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = (short) ((shMin - 1) + Math.floor(Math.random() * (shMax) + 1));
		}
		return aVector;
	}
	private static int[] crearVectorRandomInt(int iTamanio, int iMin, int iMax) {

		int[] aVector = new int[iTamanio];
		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = (byte) ((iMin - 1) + Math.floor(Math.random() * (iMax) + 1));
		}
		return aVector;
	}
	private static long[] crearVectorRandomLong(int iTamanio, long lMin, long lMax) {

		long[] aVector = new long[iTamanio];
		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = (long) ((lMin - 1) + Math.floor(Math.random() * (lMax) + 1));
		}
		return aVector;
	}
	private static float[] crearVectorRandomFloat(int iTamanio, float fMin, float fMax) {

		float[] aVector = new float[iTamanio];
		Random rand = new Random();
		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] =  fMin  + (rand.nextFloat() * (fMax - fMin));
		}
		return aVector;
	}
	private static double[] crearVectorRandomDouble(int iTamanio, double dMin, double dMax) {

		double[] aVector = new double[iTamanio];
		Random rand = new Random();
		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] =  dMin  + (rand.nextDouble() * (dMax - dMin));
		}
		return aVector;
	}
	private static boolean[] crearVectorRandomBoolean(int iTamanio) {

		boolean[] aVector = new boolean[iTamanio];
		Random rand = new Random();
		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = rand.nextBoolean();
		}
		return aVector;
	}
	
	// Crear MATRIZ ##########################################################
	private static byte[][] crearMatrizRandomByte(int iFilas, int iColumnas, byte bMin, byte bMax) {

		byte[][] aMatriz = new byte[iFilas][iColumnas];
		for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
			for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {
				aMatriz[iContadorFilas][iContadorColumnas] = (byte) ((bMin - 1) + Math.floor(Math.random() * (bMax) + 1));
			}
		}
		return aMatriz;
	}
	private static short[][] crearMatrizRandomShort(int iFilas, int iColumnas, short shMin, short shMax) {

		short[][] aMatriz = new short[iFilas][iColumnas];
		for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
			for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {
				aMatriz[iContadorFilas][iContadorColumnas] = (short) ((shMin - 1) + Math.floor(Math.random() * (shMax) + 1));
			}
		}
		return aMatriz;
	}
	private static int[][] crearMatrizRandomInt(int iFilas, int iColumnas, int iMin, int iMax) {

		int[][] aMatriz = new int[iFilas][iColumnas];
		for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
			for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {
				aMatriz[iContadorFilas][iContadorColumnas] = (int) ((iMin - 1) + Math.floor(Math.random() * (iMax) + 1));
			}
		}
		return aMatriz;
	}
	private static long[][] crearMatrizRandomLong(int iFilas, int iColumnas, long lMin, long lMax) {

		long[][] aMatriz = new long[iFilas][iColumnas];
		for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
			for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {
				aMatriz[iContadorFilas][iContadorColumnas] = (long) ((lMin - 1) + Math.floor(Math.random() * (lMax) + 1));
			}
		}
		return aMatriz;
	}
	private static float[][] crearMatrizRandomFloat(int iFilas, int iColumnas, float fMin, float fMax) {

		float[][] aMatriz = new float[iFilas][iColumnas];
		Random rand = new Random();
		for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
			for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {
				aMatriz[iContadorFilas][iContadorColumnas] =  fMin  + (rand.nextFloat() * (fMax - fMin));
			}
		}
		return aMatriz;
	}
	private static double[][] crearMatrizRandomDouble(int iFilas, int iColumnas, double dMin, double dMax) {

		double[][] aMatriz = new double[iFilas][iColumnas];
		Random rand = new Random();
		for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
			for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {
				aMatriz[iContadorFilas][iContadorColumnas] =  dMin  + (rand.nextDouble() * (dMax - dMin));
			}
		}
		return aMatriz;
	}
	private static boolean[][] crearMatrizRandomBoolean(int iFilas, int iColumnas) {

		boolean[][] aMatriz = new boolean[iFilas][iColumnas];
		Random rand = new Random();
		for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
			for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {
				aMatriz[iContadorFilas][iContadorColumnas] = rand.nextBoolean();
			}
		}
		return aMatriz;
	}
	
	
	private static void copy(){
		 System.err.print("\n\n©LuisMontero");
		}
	
}
