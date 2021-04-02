package models.lugar;

public interface IPais {

    public String getsNombrePais();
    public void setsNombrePais(String sNombrePais);
    public short getShCodigoInternacional();
    public void setShCodigoInternacional(short shCodigoInternacional);
    public String getsSiglasPais();
    public void setsSiglasPais(String sSiglasPais);

    public boolean checkPais();
    public int hashCode();
    public boolean equals(Object obj);
    public String toString();
}
