package models.productos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import models.IPlantilla;

public class Pack implements IPack, IPlantilla{
    
    //PK
    private int iIdPack;
    //NN
    private String sNombrePack;
    private float fPrecioPack;
    //N
    private String sDescripcionPack;

    // ###Contructores###

    public Pack(int iIdPack) {
        setiIdPack(iIdPack);
    }

    public Pack(String sNombrePack, float fPrecioPack) {
        this.iIdPack = 1;
        setsNombrePack(sNombrePack);
        setfPrecioPack(fPrecioPack);
    }

    public Pack(String sNombrePack, float fPrecioPack, String sDescripcionPack) {
        this.iIdPack = 1;
        setsNombrePack(sNombrePack);
        setfPrecioPack(fPrecioPack);
        setsDescripcionPack(sDescripcionPack);
    }

    // ###GET and SET###

    public int getiIdPack() {
        return iIdPack;
    }

    public void setiIdPack(int iIdPack) {
        if (this.iIdPack >= 0 && this.iIdPack <= IMAXIDS) {
            this.iIdPack = iIdPack;
        }
    }

    public String getsNombrePack() {
        return sNombrePack;
    }

    public void setsNombrePack(String sNombrePack) {
        if (sNombrePack != null && !sNombrePack.isEmpty() && sNombrePack.length() < BMAXNOMBRELARGO){
            this.sNombrePack = sNombrePack;
        }
    }

    public float getfPrecioPack() {
        return fPrecioPack;
    }

    public void setfPrecioPack(float fPrecioPack) {
        if (fPrecioPack < IMAXPRECIO && fPrecioPack > 0) {
            BigDecimal bigVariable = new BigDecimal(fPrecioPack).setScale(BMAXPRECIODECIMAL, RoundingMode.UP);
        this.fPrecioPack = bigVariable.floatValue();
        }
        this.fPrecioPack = fPrecioPack;
    }

    public String getsDescripcionPack() {
        return sDescripcionPack;
    }

    public void setsDescripcionPack(String sDescripcionPack) {
        if (sDescripcionPack != null && !sDescripcionPack.isEmpty() && sDescripcionPack.length() < BMAX255){
            this.sDescripcionPack = sDescripcionPack;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkPack() {
        boolean booExito = false;
        if (this.getiIdPack() > 0 && this.getiIdPack() < IMAXIDS && this.getsNombrePack() != null && fPrecioPack < IMAXPRECIO && fPrecioPack > 0) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(fPrecioPack);
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        Pack oPack = (Pack) obj;
        if (oPack.checkPack() && this.checkPack() && this.getsNombrePack().equals(oPack.getsNombrePack())){
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (checkPack()) {
            sMensaje += "\n## Pack ##";
            sMensaje += "\n Id: " + SLETRAPACK + String.format(SPATRONIDTOSTRING , this.getiIdPack());
            sMensaje += "\n Nombre: " + this.getsNombrePack();
            sMensaje += "\n Precio: " + this.getfPrecioPack() + "€";
            if (this.getsDescripcionPack() != null && this.getsDescripcionPack().isEmpty()) {
                sMensaje += "\n Descripcion: " + this.getsDescripcionPack();
            }
        }
        return sMensaje;
    }
}
