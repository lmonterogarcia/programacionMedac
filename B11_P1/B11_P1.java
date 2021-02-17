/**
 * B11_EJ1
 */
public class B11_P1 {

    public static void main(String[] args) {
        ReproductorDeVideo oRv = new ReproductorDeVideo("Sony", "NM-WM1Z", (byte) 21);
        
        oRv.setbAutonomia((byte) 20);
        oRv.setbTipoDeAlmacenamiento((byte) 3);
        oRv.setBooReproduceVideo(true);
        oRv.setbPantalla((byte) 3);
        oRv.setbTipoDeBateria((byte) 2);
        oRv.setiCapacidadDeAlmacenamiento(20000);

        oRv.setbooReproduceDIVX(true);
        oRv.setbooTelevision(true);

        System.out.println(oRv);
    }
}