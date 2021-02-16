public class B11_EJ3 {
    public static void main(String[] args) {
        ReproductorDeAudio oRa = new ReproductorDeAudio("Apple", "HomePod", (byte) 3, false, true, true, false);
        ReproductorDeVideo oRv = new ReproductorDeVideo("Philips", "Hy45-Hyu", (byte) 4, (byte) 5);
        ReproductorMultimedia oRm = new ReproductorMultimedia("Sony", "NM-WM1Z", (byte) 1, true, true, false, false, (byte) 21);
        
        oRa.setbAutonomia((byte) 0);
        oRa.setBooReproduceVideo(false);
        oRa.setbPantalla((byte) 1);
        oRa.setbTipoDeBateria((byte) 2);
        oRa.setiCapacidadDeAlmacenamiento(60000);
        oRa.setbooRadio(false);
        oRa.setbooGrabacionDeVoz(true);

        oRv.setbAutonomia((byte) 20);
        oRv.setbTipoDeAlmacenamiento((byte) 3);
        oRv.setBooReproduceVideo(true);
        oRv.setbPantalla((byte) 3);
        oRv.setbTipoDeBateria((byte) 2);
        oRv.setiCapacidadDeAlmacenamiento(80000);
        oRv.setbooReproduceDIVX(true);
        oRv.setbooTelevision(true);

        oRm.setbAutonomia((byte) 90);
        oRm.setBooReproduceVideo(true);
        oRm.setbPantalla((byte) 2);
        oRm.setbTipoDeBateria((byte) 1);
        oRm.setiCapacidadDeAlmacenamiento(20000);
        oRm.setbooRadio(true);
        oRm.setbooGrabacionDeVoz(false);
        oRm.setbooReproduceDIVX(true);
        oRm.setbooTelevision(true);

        System.out.println(oRa);
        System.out.println(oRv);
        System.out.println(oRm);
    }
}
