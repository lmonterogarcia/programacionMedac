
public class Sim_EJ1 {
    public static void main(String[] args) {
    byte[][] aMatriz1 ={{1,2,3},{0,-1,-4},{0,0,2}};
    byte[][] aMatriz2 ={{1,0,0},{4,-1,0},{5,6,2}};
    byte[][] aMatriz3 ={{1,0,0},{0,3,0},{0,0,4}};


    }
    
    private byte matrizTriangular (byte[][] aMatriz) {
        byte bResultado = -1;
        boolean booTenemosResultado = false;
        if (esDiagonal(aMatriz)) {
            bResultado = 3;
            booTenemosResultado = true;
        }
        if (!booTenemosResultado && esTriInf(aMatriz)) {
            bResultado = 2;
            booTenemosResultado = true;
        }
        if (!booTenemosResultado && esTriSup(aMatriz)) {
            bResultado = 1;
            booTenemosResultado = true;
        }
        return bResultado;
    }

    private boolean esDiagonal (byte[][] aMatriz) {
        boolean booExito = true;
        int iFila = 0;
        int iColumna = 1;
        while (booExito && iFila < aMatriz.length) {
            while (booExito && iColumna < aMatriz.length) {
                
            }
        }
        return booExito;
    }
    private boolean esTriSup (byte[][] aMatriz) {
        boolean booExito = true;

        return booExito;
    }
    private boolean esTriInf (byte[][] aMatriz) {
        boolean booExito = true;

        return booExito;
    }
}