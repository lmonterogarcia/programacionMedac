
public class Sim_EJ1 {
    public static void main(String[] args) {
        byte[][] aMatriz1 = { { 1, 2, 3 }, { 0, -1, -4 }, { 0, 0, 2 } };
        byte[][] aMatriz2 = { { 1, 0, 0 }, { 4, -1, 0 }, { 5, 6, 2 } };
        byte[][] aMatriz3 = { { 1, 0, 0 }, { 0, 3, 0 }, { 0, 0, 4 } };
        byte[][] aMatriz4 = { { 4, 0, 0, 0 }, { 0, 6, 0, 0 }, { 0, 0, 7, 0 }, { 0, 0, 0, 9 } };
        System.out.println(resutladoTriangular(aMatriz1));
        System.out.println(resutladoTriangular(aMatriz2));
        System.out.println(resutladoTriangular(aMatriz3));
        System.out.println(resutladoTriangular(aMatriz4));
    }

    private static String resutladoTriangular(byte[][] aMatriz) {
        String sResultado;
        switch (esTriangular(aMatriz)) {
            case 1:
                sResultado = "Superior";
                break;
            case 2:
                sResultado = "Inferior";
                break;
            case 3:
                sResultado = "Diagonal";
                break;
            default:
                sResultado = "No es";
        }
        return sResultado;
    }

    private static byte esTriangular(byte[][] aMatriz) {
        byte bResultado = -1;
        boolean booTriSuperior = true;
        boolean booTriInferior = true;
        int iFila = 0;
        int iColumna = 1;
        if (aMatriz.length == aMatriz[0].length) {
            while ((booTriInferior || booTriSuperior) && iFila < aMatriz.length - 1) {
                while ((booTriInferior || booTriSuperior) && iColumna < aMatriz.length) {
                    if (booTriInferior && aMatriz[iFila][iColumna] != 0) {
                        booTriInferior = false;
                    }
                    if (booTriSuperior && aMatriz[iColumna][iFila] != 0) {
                        booTriSuperior = false;
                    }
                    iColumna++;
                }
                iFila++;
                iColumna = iFila + 1;
            }
            if (booTriInferior && booTriSuperior) {
                bResultado = 3;
            } else if (booTriInferior && !booTriSuperior) {
                bResultado = 2;
            } else if (!booTriInferior && booTriSuperior) {
                bResultado = 1;
            } else {
                bResultado = -1;
            }
        }
        return bResultado;
    }
}