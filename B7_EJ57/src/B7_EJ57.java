import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class B7_EJ57 {

	//Se ha realizado para que funcione con codigos ASCII.
	public static void main(String[] args) {
		char[][] aMatriz = crearMatrizRandomCharAscii(5, 10);	
		byte[] aVector = new byte[aMatriz[0].length];

		aVector = hayVocalEnColumnaEnCadaColumna(aVector, aMatriz);
		
		System.out.println(imprimeMatrizChar(aMatriz));
		System.out.println(imprimeVectorByte(aVector));
		
		}

		/*
		 * ########################################
		 * ##### # Funciones especificas para este programa  # #####
		 * ########################################
		 *
		 *
		 *Siempre el codigo es creado para ser reutilizado. Por lo que la mayoria de las veces el tipado es int,
		 *a no ser que sea muy especifica del Ejercicio/Problema.
		 */
		
		private static byte[] hayVocalEnColumnaEnCadaColumna(byte[] aVector, char[][] aMatriz) {
			
			for (int iContadorColumna = 0; iContadorColumna < aMatriz[0].length; iContadorColumna++) {
				
				if (hayVocalEnColumna(iContadorColumna, aMatriz)) {
					aVector[iContadorColumna] = 1;
				} else {
					aVector[iContadorColumna] = 0;
				}
				
			}
				
			return aVector;
		}
		
		private static boolean hayVocalEnColumna(int iColumna, char[][] aMatriz) {
			int iFila = 0;
			boolean booSeRepite = false;
			
			
			do {
				if (aMatriz[iFila][iColumna] == 'a' || aMatriz[iFila][iColumna] == 'e' || aMatriz[iFila][iColumna] == 'i' || aMatriz[iFila][iColumna] == 'o' || aMatriz[iFila][iColumna] == 'u' ) {
					booSeRepite = true;
				}
				iFila++;
				
			} while (!booSeRepite && iFila < aMatriz.length - 1);
			
			return booSeRepite;
		}
		
		/*
		 * #######################################
		 * ############ # LIBRERIA CASTING # ###########
		 * #######################################
		 */
		
		// Casting VECTOR#################################################################
		
		private static String charVectorToStringSimple(char[] aVector) {
			String sMensaje = "";

			for (int iContador = 0; iContador < aVector.length; iContador++) {
				sMensaje += (aVector[iContador]);
			}

			return sMensaje;
		}
		private static char[] stringSimpleToCharVector(String sMensaje) {
			char[] aMensaje = new char[sMensaje.length()];

			for (int iContador = 0; iContador < aMensaje.length; iContador++) {
				aMensaje[iContador] = sMensaje.charAt(iContador);
			}

			return aMensaje;
		}
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
		private static byte[] objectToByteVector(Object[] aVector) {
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
		private static short[] objectToShortVector(Object[] aVector) {
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
		private static int[] objectToIntVector(Object[] aVector) {
			int[] aVectorCasteado = new int[aVector.length];
			try {
				for (int iContador = 0; iContador < aVector.length; iContador++) {
					aVectorCasteado[iContador] = (int) aVector[iContador];
				}
			} catch (Exception e) {
				System.err.println("Error al hacer el casting");
				for (int iContador = 0; iContador < aVector.length; iContador++) {
					aVectorCasteado[iContador] = -1;
				}
			}
			return aVectorCasteado;
		}
		private static float[] objectToFloatVector(Object[] aVector) {
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
		private static double[] objectToDoubleVector(Object[] aVector) {
			double[] aVectorCasteado = new double[aVector.length];
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
		private static char[] objectToCharVector(Object[] aVector) {
			char[] aVectorCasteado = new char[aVector.length];
			try {
				for (int iContador = 0; iContador < aVector.length; iContador++) {
					aVectorCasteado[iContador] = (char) aVector[iContador];
				}
			} catch (Exception e) {
				System.err.println("Error al hacer el casting");
				for (int iContador = 0; iContador < aVector.length; iContador++) {
					aVectorCasteado[iContador] = '@';
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
		private static byte[][] objectToByteMatriz(Object[][] aMatriz) {
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
		private static short[][] objectToShortMatriz(Object[][] aMatriz) {
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
		private static int[][] objectToIntMatriz(Object[][] aMatriz) {
			int[][] aMatrizCasteado = new int[aMatriz.length][aMatriz[0].length];
			try {
				for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
					for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
						aMatrizCasteado[iContadorFila][iContadorColumna] = (int) aMatriz[iContadorFila][iContadorColumna];
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
		private static float[][] objectToFloatMatriz(Object[][] aMatriz) {
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
		private static double[][] objectToDoubleMatriz(Object[][] aMatriz) {
			double[][] aMatrizCasteado = new double[aMatriz.length][aMatriz[0].length];
			try {
				for (int iContadorFila = 0; iContadorFila < aMatriz.length; iContadorFila++) {
					for (int iContadorColumna = 0; iContadorColumna < aMatriz[iContadorFila].length; iContadorColumna++) {
						aMatrizCasteado[iContadorFila][iContadorColumna] = (double) aMatriz[iContadorFila][iContadorColumna];
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
					sResultado += " , ";
				}
			}
			return sResultado;
		}
		public static String imprimeVectorShort(short[] aVector) {
			String sResultado = "";
			for(int iContador = 0; iContador < aVector.length; iContador++) {
				sResultado += aVector[iContador];
				if(iContador < aVector.length - 1) {
					sResultado += " , ";
				}
			}
			return sResultado;
		}
		public static String imprimeVectorInt(int[] aVector) {
			String sResultado = "";
			for(int iContador = 0; iContador < aVector.length; iContador++) {
				sResultado += aVector[iContador];
				if(iContador < aVector.length - 1) {
					sResultado += " , ";
				}
			}
			return sResultado;
		}
		public static String imprimeVectorLong(long[] aVector) {
			String sResultado = "";
			for(int iContador = 0; iContador < aVector.length; iContador++) {
				sResultado += aVector[iContador];
				if(iContador < aVector.length - 1) {
					sResultado += " , ";
				}
			}
			return sResultado;
		}
		public static String imprimeVectorFloat(float[] aVector) {
			String sResultado = "";
			for(int iContador = 0; iContador < aVector.length; iContador++) {
				sResultado += aVector[iContador];
				if(iContador < aVector.length - 1) {
					sResultado += " , ";
				}
			}
			return sResultado;
		}
		public static String imprimeVectorDouble(double[] aVector) {
			String sResultado = "";
			for(int iContador = 0; iContador < aVector.length; iContador++) {
				sResultado += aVector[iContador];
				if(iContador < aVector.length - 1) {
					sResultado += " , ";
				}
			}
			return sResultado;
		}
		public static String imprimeVectorString(String[] aVector) {
			String sResultado = "";
			for(int iContador = 0; iContador < aVector.length; iContador++) {
				sResultado += aVector[iContador];
				if(iContador < aVector.length - 1) {
					sResultado += " , ";
				}
			}
			return sResultado;
		}
		public static String imprimeVectorChar(char[] aVector) {
			String sResultado = "";
			for(int iContador = 0; iContador < aVector.length; iContador++) {
				sResultado += aVector[iContador];
				if(iContador < aVector.length - 1) {
					sResultado += " , ";
				}
			}
			return sResultado;
		}
		public static String imprimeVectorBoolean(boolean[] aVector) {
			String sResultado = "";
			for(int iContador = 0; iContador < aVector.length; iContador++) {
				if (aVector[iContador] == true) {
					sResultado += "1";
				} else if (aVector[iContador] == false) {
					sResultado += "0";
				} else {
					sResultado += -1;
				}
				if(iContador < aVector.length - 1) {
					sResultado += " , ";
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
			case 8:
				oNumero = pideChar(sMensaje);
				break;
			case 9:
				oNumero = pideString(sMensaje);
				break;
			case 10:
				oNumero = pideStringMax(sMensaje, lMaximo);
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

//		Nueva funcion para Libreria Leer. Lee un double dentro de un rango sin llegar a los limites
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
		
		private static char pideChar(String sMensaje) {
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			String sCadenaLeida;
			char cCaracter;
			boolean booCorrecto;

			do {
				System.out.print(sMensaje);
				try {
					sCadenaLeida = teclado.readLine();
					cCaracter = sCadenaLeida.charAt(0);
					booCorrecto = true;
				} catch (Exception e) {
					sCadenaLeida = "-1";
					cCaracter = 'e';
					booCorrecto = false;
				}
			} while (!booCorrecto || sCadenaLeida.length() != 1);

			return cCaracter;
		}
		
		private static String pideString(String sMensaje) {
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			String sCadenaLeida;
			System.out.print(sMensaje);
			boolean booCorrecto;
			
			do {
				try {
					sCadenaLeida = teclado.readLine();
					booCorrecto = true;
				} catch (Exception e) {
					sCadenaLeida = "-1";
					booCorrecto = false;
				}
			} while (!booCorrecto);

			return sCadenaLeida;
		}
		
		private static String pideStringMax(String sMensaje, long lMax) {
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			String sCadenaLeida;
			boolean booCorrecto;
			
			do {
				System.out.print(sMensaje+" (maximo "+lMax+" caracteres): ");
				try {
					sCadenaLeida = teclado.readLine();
					booCorrecto = true;
				} catch (Exception e) {
					sCadenaLeida = "-1";
					booCorrecto = false;
				}
				
				if (sCadenaLeida.length() > lMax) {
					System.out.println("Ha sperado el maximo de caracteres, pruebe de nuevo.");
				}
			} while (!booCorrecto && sCadenaLeida.length() > lMax);

			return sCadenaLeida;
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
			case 7:
				aoNumero = pideVectorChar(sMensaje, iTamanio);
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
		
		public static Object[] pideVectorChar(String sMensaje, int iTamanio) {

			int iNumeroElementos = iTamanio;
			Object[] aVector = new Object[iNumeroElementos];

			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVector[iContador] = (char) leer(
						sMensaje + (iContador + 1) + "/" + aVector.length + ": ", -1, -1,
						-1, -1, (byte) 8);
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
					aVector[iContadorFila][iContadorColumna] = (short) leer(sMensaje +"["+iContadorFila+"]"+"["+iContadorColumna+"]" + ": ", (long) lMin, (long) lMax, -1, -1,
							(byte) 2);
				}	
			}

			return aVector;
		}
		
		public static Object[][] pideMatrizInt(String sMensaje, int iFilas, int iColumnas, long lMin, long lMax) {

			Object[][] aVector = new Object[iFilas][iColumnas];

			for (int iContadorFila = 0; iContadorFila < aVector.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aVector[0].length; iContadorColumna++) {
					aVector[iContadorFila][iContadorColumna] = (int) leer(sMensaje +"["+iContadorFila+"]"+"["+iContadorColumna+"]" + ": ", (long) lMin, (long) lMax, -1, -1,
							(byte) 3);
				}	
			}

			return aVector;
		}
		
		public static Object[][] pideMatrizLong(String sMensaje, int iFilas, int iColumnas, long lMin, long lMax) {

			Object[][] aVector = new Object[iFilas][iColumnas];

			for (int iContadorFila = 0; iContadorFila < aVector.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aVector[0].length; iContadorColumna++) {
					aVector[iContadorFila][iContadorColumna] = (long) leer(sMensaje +"["+iContadorFila+"]"+"["+iContadorColumna+"]" + ": ", (long) lMin, (long) lMax, -1, -1,
							(byte) 4);
				}	
			}

			return aVector;
		}
		
		public static Object[][] pideMatrizFloat(String sMensaje, int iFilas, int iColumnas, double dMin, double dMax) {

			Object[][] aVector = new Object[iFilas][iColumnas];

			for (int iContadorFila = 0; iContadorFila < aVector.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aVector[0].length; iContadorColumna++) {
					aVector[iContadorFila][iContadorColumna] = (float) leer(sMensaje +"["+iContadorFila+"]"+"["+iContadorColumna+"]" + ": ", -1, -1, dMin, dMax,
							(byte) 5);
				}	
			}

			return aVector;
		}
		
		public static Object[][] pideMatrizDouble(String sMensaje, int iFilas, int iColumnas, double dMin, double dMax) {

			Object[][] aVector = new Object[iFilas][iColumnas];

			for (int iContadorFila = 0; iContadorFila < aVector.length; iContadorFila++) {
				for (int iContadorColumna = 0; iContadorColumna < aVector[0].length; iContadorColumna++) {
					aVector[iContadorFila][iContadorColumna] = (double) leer(sMensaje +"["+iContadorFila+"]"+"["+iContadorColumna+"]" + ": ", -1, -1, dMin, dMax,
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
				aVector[iContador] = (byte) ((bMin) + Math.floor(Math.random() * ((bMax - bMin) + 1)));
			}
			return aVector;
		}
		private static short[] crearVectorRandomShort(int iTamanio, short shMin, short shMax) {

			short[] aVector = new short[iTamanio];
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVector[iContador] = (short) ((shMin) + Math.floor(Math.random() * ((shMax - shMin) + 1)));
			}
			return aVector;
		}
		private static int[] crearVectorRandomInt(int iTamanio, int iMin, int iMax) {

			int[] aVector = new int[iTamanio];
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVector[iContador] = (int) ((iMin) + Math.floor(Math.random() * ((iMax - iMin) + 1)));
			}
			return aVector;
		}
		private static long[] crearVectorRandomLong(int iTamanio, long lMin, long lMax) {

			long[] aVector = new long[iTamanio];
			for (int iContador = 0; iContador < aVector.length; iContador++) {
				aVector[iContador] = (long) ((lMin) + Math.floor(Math.random() * ((lMax - lMin) + 1)));
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
					aMatriz[iContadorFilas][iContadorColumnas] = (byte) ((bMin) + Math.floor(Math.random() * ((bMax - bMin) + 1)));
				}
			}
			return aMatriz;
		}
		private static short[][] crearMatrizRandomShort(int iFilas, int iColumnas, short shMin, short shMax) {

			short[][] aMatriz = new short[iFilas][iColumnas];
			for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
				for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {
					aMatriz[iContadorFilas][iContadorColumnas] = (short) ((shMin) + Math.floor(Math.random() * ((shMax - shMin) + 1)));
				}
			}
			return aMatriz;
		}
		private static int[][] crearMatrizRandomInt(int iFilas, int iColumnas, int iMin, int iMax) {

			int[][] aMatriz = new int[iFilas][iColumnas];
			for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
				for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {
					aMatriz[iContadorFilas][iContadorColumnas] = (int) ((iMin) + Math.floor(Math.random() * ((iMax - iMin) + 1)));
				}
			}
			return aMatriz;
		}
		private static long[][] crearMatrizRandomLong(int iFilas, int iColumnas, long lMin, long lMax) {

			long[][] aMatriz = new long[iFilas][iColumnas];
			for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
				for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {
					aMatriz[iContadorFilas][iContadorColumnas] = (long) ((lMin) + Math.floor(Math.random() * ((lMax - lMin) + 1)));
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
		private static char[][] crearMatrizRandomCharAscii(int iFilas, int iColumnas) {

			char[][] aMatriz = new char[iFilas][iColumnas];
			for (int iContadorFilas = 0; iContadorFilas < aMatriz.length; iContadorFilas++) {
				for (int iContadorColumnas = 0; iContadorColumnas < aMatriz[iContadorFilas].length; iContadorColumnas++) {
					aMatriz[iContadorFilas][iContadorColumnas] = (char) ((97) + Math.floor(Math.random() * ((122 - 97) + 1)));
				}
			}
			return aMatriz;
		}

}
