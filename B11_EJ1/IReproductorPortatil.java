public interface IReproductorPortatil {
    
    public final byte BCD = 1;
    public final byte BDVD = 2;
    public final byte BMEMORIAFLASH = 3;
    public final byte BMINIDISK = 4;
    public final byte BNINGUNA = 1;
    public final byte BTEXTO = 2;
    public final byte BMONOCROMO = 3;
    public final byte BCOLOR = 4;
    public final byte BPILAS = 1;
    public final byte BLIION = 2;

    public String getsMarca();
    public boolean setsMarca(String sMarca);
    public String getsModelo();
    public boolean setsModelo(String sModelo);
    public boolean isBooReproduceSonido();
    public boolean setBooReproduceSonido(boolean booReproduceSonido);
    public boolean isBooReproduceVideo();
    public boolean setBooReproduceVideo(boolean booReproduceVideo);
    public byte getbTipoDeAlmacenamiento();
    public boolean setbTipoDeAlmacenamiento(byte bTipoDeAlmacenamiento);
    public byte getbPantalla();
    public boolean setbPantalla(byte bPantalla);
    public byte getbTipoDeBateria();
    public boolean setbTipoDeBateria(byte bTipoDeBateria);
    public byte getbAutonomia();
    public boolean setbAutonomia(byte bAutonomia);
    public short getShCapacidadDeAlmacenamiento();
    public boolean setShCapacidadDeAlmacenamiento(short shCapacidadDeAlmacenamiento);
    public float getfPeso();
    public boolean setfPeso(float fPeso);
    public float getfAncho();
    public boolean setfAncho(float fAncho);
    public float getfAlto();
    public boolean setfAlto(float fAlto);
    public float getfGrosor();
    public boolean setfGrosor(float fGrosor);
    public String toString();
}
