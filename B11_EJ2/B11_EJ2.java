/**
 * B11_EJ1
 */
public class B11_EJ2 {

    public static void main(String[] args) {
        ReproductorDeAudio oRa = new ReproductorDeAudio("Sony", "NM-WM1Z", (byte) 1, true, true, true, false);
        
        oRa.setbAutonomia((byte) 20);
        oRa.setBooReproduceVideo(true);
        //oRa.setbTipoDeAlmacenamiento((byte) 3);
        oRa.setbPantalla((byte) 3);
        oRa.setbTipoDeBateria((byte) 2);
        oRa.setiCapacidadDeAlmacenamiento(20000);

        oRa.setbooRadio(true);
        oRa.setbooGrabacionDeVoz(true);

        System.out.println(oRa);
    }
}