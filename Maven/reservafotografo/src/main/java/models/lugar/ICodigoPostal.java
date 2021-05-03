package models.lugar;

public interface ICodigoPostal {

    public String getsReferenciaCodigoPostal();
    public void setsReferenciaCodigoPostal(String sReferenciaCodigoPostal);

    public boolean checkCodigoPostal();
    public int hashCode();
    public boolean equals(Object obj);
    public String toString();
}
