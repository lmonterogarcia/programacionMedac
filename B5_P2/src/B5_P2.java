import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class B5_P2 {

	public static void main(String[] args) {
		byte[][] aSudoku = {{1,2,3,4,5,6,7,8,9},{4,5,6,7,8,9,1,2,3},{7,8,9,1,2,3,4,5,6},{2,1,4,3,6,5,8,9,7},{3,6,5,8,9,7,2,1,4},{8,9,7,2,1,4,3,6,5},{5,3,1,6,4,2,9,7,8},{6,7,2,9,3,8,5,4,1},{9,4,8,5,7,1,6,3,2}};
//		byte[][] aSudoku = {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}};
//		byte[][] aSudoku = {{1,5,4,6,9,3,2,8,7},{6,3,2,5,7,8,9,4,1},{8,9,7,1,2,4,6,5,3},{5,1,9,8,4,7,3,2,6},{2,4,3,9,6,5,7,1,8},{7,6,8,3,1,2,4,9,5},{4,8,6,7,5,9,1,3,2},{9,7,5,2,3,1,8,6,4},{3,2,1,4,8,6,5,7,9}};
		
		System.out.println(imprimeSudoku(aSudoku));
		
		if (verificarSudoku(aSudoku)) {
			System.out.println("El sudoku es CORRECTO.");
		} else {
			System.out.println("El sudoku es INCORRECTO.");
		}
		copy();
	}

	private static boolean verificarSudoku(byte[][] aMatriz) {
		boolean booSudokuCorrecto = true;
		byte bContador = 0, bContadorSub = 0;
		
		while (booSudokuCorrecto && bContador < aMatriz.length) {
			
			if (!verificarFilaMatriz(byteToIntMatriz(aMatriz), bContador)) {
				booSudokuCorrecto = false;
//				System.out.println("Fila");
			}
			
			if (booSudokuCorrecto && !VerificarColumnaMatriz(byteToIntMatriz(aMatriz), bContador)) {
				booSudokuCorrecto = false;
//				System.out.println("Colum");
			}
			
			if (booSudokuCorrecto && !verificarSubMatrizSudoku(aMatriz, (byte)(Math.floor(bContador / 3)), bContadorSub)) {
				booSudokuCorrecto = false;
//				System.out.println("Sub");
			}
			
			
			bContador++;
			bContadorSub++;
			if (bContadorSub == 3) {
				bContadorSub = 0;
			} 
		}
		
		
		return booSudokuCorrecto;
	}
	
	
	private static boolean verificarFilaMatriz(int[][] aMatriz, int iFila) {
		int[] aFilaMatriz = new int[aMatriz[iFila].length];
		boolean booEsCorrecto = true;
		byte bContador = 0, bContadorControl;
		
		

		while (booEsCorrecto && bContador < aFilaMatriz.length ) {
			aFilaMatriz[bContador] = aMatriz[iFila][bContador];
			bContadorControl = (byte) (bContador - 1);
			while (booEsCorrecto && bContadorControl >= 0) {
				if (aFilaMatriz[bContador] == aFilaMatriz[bContadorControl] ) {
					booEsCorrecto = false;
				}
				bContadorControl--;
			}
			bContador++;
		}
		
		return booEsCorrecto;
	}


	private static boolean VerificarColumnaMatriz(int[][] aMatriz, int iColumna) {
		int[] aColumnaMatriz = new int[aMatriz[iColumna].length];
		boolean booEsCorrecto = true;
		byte bContador = 0, bContadorControl;
		
		

		while (booEsCorrecto && bContador < aColumnaMatriz.length ) {
			aColumnaMatriz[bContador] = aMatriz[bContador][iColumna];
			bContadorControl = (byte) (bContador - 1);
			while (booEsCorrecto && bContadorControl >= 0) {
				if (aColumnaMatriz[bContador] == aColumnaMatriz[bContadorControl] ) {
					booEsCorrecto = false;
				}
				bContadorControl--;
			}
			bContador++;
		}
		
		return booEsCorrecto;
	}


	private static boolean verificarSubMatrizSudoku(byte[][] aMatriz, byte bCoordenadaFila, byte bCoordenadaColumna) {
		byte[] aSubMatriz = new byte[aMatriz.length];
		boolean booEsCorrecto = true;
		byte bContador = 0, bContadorControl, bContadorFila = (byte) ((3 * bCoordenadaFila)),
				bContadorColumna = (byte) ((3 * bCoordenadaColumna));

		while (booEsCorrecto && bContador < (aSubMatriz.length)) {
			aSubMatriz[bContador] = aMatriz[bContadorFila][bContadorColumna];
			bContadorControl = (byte) (bContador - 1);

			while (booEsCorrecto && bContadorControl >= 0) {
				if (aSubMatriz[bContador] == aSubMatriz[bContadorControl]) {
					booEsCorrecto = false;
				}
				bContadorControl--;
			}
			bContadorColumna++;
			if (bContadorColumna == ((3 * bCoordenadaColumna) + 3)) {
				bContadorFila++;
				bContadorColumna = (byte) ((3 * bCoordenadaColumna));
			}
			bContador++;

		}

		return booEsCorrecto;
	}
	
	
	public static String imprimeSudoku(byte[][] aMatriz) {
		String sResultado = "";
		for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
			if (iContadorFila == 3 || iContadorFila == 6) {
				sResultado +="---------------------------\n";
			}
			for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
				sResultado += aMatriz[iContadorFila][iContadorColumna];
				if (iContadorColumna == 2 || iContadorColumna == 5) {
					sResultado +=" | ";
				} else if (iContadorColumna < aMatriz[iContadorFila].length - 1) {
					sResultado += "  ";
				}
				
			}
			sResultado += "\n";
		}
		return sResultado;
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

	
	// CREAR VECTOR ##########################################################
	private static byte[] crearVectorRandomByte(int iTamanio, byte bMin, byte bMax) {

		byte[] aVector = new byte[iTamanio];
		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = (byte) ((bMin - 1) + Math.floor(Math.random() * (bMax + 1) + 1));
		}
		return aVector;
	}
	private static short[] crearVectorRandomShort(int iTamanio, short shMin, short shMax) {

		short[] aVector = new short[iTamanio];
		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = (short) ((shMin - 1) + Math.floor(Math.random() * (shMax + 1) + 1));
		}
		return aVector;
	}
	private static int[] crearVectorRandomInt(int iTamanio, int iMin, int iMax) {

		int[] aVector = new int[iTamanio];
		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = (byte) ((iMin - 1) + Math.floor(Math.random() * (iMax + 1) + 1));
		}
		return aVector;
	}
	private static long[] crearVectorRandomLong(int iTamanio, long lMin, long lMax) {

		long[] aVector = new long[iTamanio];
		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = (long) ((lMin - 1) + Math.floor(Math.random() * (lMax + 1) + 1));
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
	
	// CREAR MATRIZ ##########################################################
	private static byte[][] crearMatrizRandomByte(int iFilas, int iColumnas, byte bMin, byte bMax) {

		byte[][] aMatriz = new byte[iFilas][iColumnas];
		for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
			for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {
				aMatriz[iContadorFilas][iContadorColumnas] = (byte) ((bMin - 1) + Math.floor(Math.random() * (bMax + 1) + 1));
			}
		}
		return aMatriz;
	}
	private static short[][] crearMatrizRandomShort(int iFilas, int iColumnas, short shMin, short shMax) {

		short[][] aMatriz = new short[iFilas][iColumnas];
		for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
			for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {
				aMatriz[iContadorFilas][iContadorColumnas] = (short) ((shMin - 1) + Math.floor(Math.random() * (shMax + 1) + 1));
			}
		}
		return aMatriz;
	}
	private static int[][] crearMatrizRandomInt(int iFilas, int iColumnas, int iMin, int iMax) {

		int[][] aMatriz = new int[iFilas][iColumnas];
		for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
			for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {
				aMatriz[iContadorFilas][iContadorColumnas] = (int) ((iMin - 1) + Math.floor(Math.random() * (iMax + 1) + 1));
			}
		}
		return aMatriz;
	}
	private static long[][] crearMatrizRandomLong(int iFilas, int iColumnas, long lMin, long lMax) {

		long[][] aMatriz = new long[iFilas][iColumnas];
		for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
			for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {
				aMatriz[iContadorFilas][iContadorColumnas] = (long) ((lMin - 1) + Math.floor(Math.random() * (lMax + 1) + 1));
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
