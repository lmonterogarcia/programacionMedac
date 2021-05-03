package models.lugar;

public interface ICodigoPostalLocalidadPaisProvincia {

    public Localidad getoLocalidad();
    public void setoLocalidad(Localidad oLocalidad);
    public CodigoPostal getoCodigoPostal();
    public void setoCodigoPostal(CodigoPostal oCodigoPostal);
    public PaisProvincia getoPaisProvincia();
    public void setoPaisProvincia(PaisProvincia oPaisProvincia);

    public boolean checkCodigoPostalLocalidadPaisProvincia();
    public int hashCode();
    public boolean equals(Object obj);
    public String toString();
}
