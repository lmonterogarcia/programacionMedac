package models.productos;

public interface IPack {

    public int getiIdPack();
    public void setiIdPack(int iIdPack);
    public String getsNombrePack();
    public void setsNombrePack(String sNombrePack);
    public float getfPrecioPack();
    public void setfPrecioPack(float fPrecioPack);
    public String getsDescripcionPack();
    public void setsDescripcionPack(String sDescripcionPack);

    public boolean checkPack();
    public int hashCode();
    public boolean equals(Object obj);
    public String toString();
}
