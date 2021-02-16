public interface IReproductorVideo extends IReproductorPortatil {
    
    public boolean isbooReproduceWMV();
    public boolean setbooReproduceWMV(boolean booReproduceWMV);

    public boolean isbooReproduceDIVX();
    public boolean setbooReproduceDIVX(boolean booReproduceDIVX);

    public boolean isbooReporduceMPG();
    public boolean setbooReporduceMPG(boolean booReporduceMPG);

    public boolean isbooReproduceDVD();
    public boolean setbooReproduceDVD(boolean booReproduceDVD);

    public boolean isbooReproduceJPG();
    public boolean setbooReproduceJPG(boolean booReproduceJPG);

    public byte getbTamnioDeLaPantalla();
    public boolean setbTamnioDeLaPantalla(byte bTamnioDeLaPantalla);

    public boolean isbooTelevision();
    public boolean setbooTelevision(boolean booTelevision);
}
