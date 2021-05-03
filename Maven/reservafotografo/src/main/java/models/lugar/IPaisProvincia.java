package models.lugar;

public interface IPaisProvincia {

    public Provincia getoProvincia();
    public void setoProvincia(Provincia oProvincia);
    public Pais getoPais();
    public void setoPais(Pais oPais);

    public boolean checkPaisProvincia();
    public int hashCode();
    public boolean equals(Object obj);
    public String toString();
}
