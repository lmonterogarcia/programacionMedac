public class B11_P2 {
    public static void main(String[] args) {
        ReproductorMultimedia oRm = new ReproductorMultimedia("Sony", "NM-WM1Z", (byte) 1, true, true, false, false, (byte) 21);
        
        oRm.setbAutonomia((byte) 20);
        oRm.setBooReproduceVideo(true);
        //oRm.setbTipoDeAlmacenamiento((byte) 3);
        oRm.setbPantalla((byte) 3);
        oRm.setbTipoDeBateria((byte) 2);
        oRm.setiCapacidadDeAlmacenamiento(20000);

        oRm.setbooRadio(true);
        oRm.setbooGrabacionDeVoz(true);

        oRm.setbooReproduceDIVX(true);
        oRm.setbooTelevision(true);

        System.out.println(oRm);
    }
}
