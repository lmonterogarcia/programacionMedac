package models.lugar;

public interface ILugar {
    
    public int getiIdLugar();
    public void setiIdLugar(int iIdLugar);
    public String getsNombreLugar();
    public void setsNombreLugar(String sNombreLugar);
    public String getsGoogleMapLink();
    public void setsGoogleMapLink(String sGoogleMapLink);
    public String getsCalleLugar();
    public void setsCalleLugar(String sCalleLugar);
    public String getsNumeroLugar();
    public void setsNumeroLugar(String sNumeroLugar);
    public float getfLatitud();
    public void setfLatitud(float fLatitud);
    public float getfLongitud();
    public void setfLongitud(float fLongitud);
    public CodigoPostalLocalidadPaisProvincia getoCodigoPostalLocalidadPaisProvincia();
    public void setoCodigoPostalLocalidadPaisProvincia(CodigoPostalLocalidadPaisProvincia oCodigoPostalLocalidadPaisProvincia);

    public boolean checkLugar();
    public int hashCode();
    public boolean equals(Object obj);
    public String toString();
}
