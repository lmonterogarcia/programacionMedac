package models.sesion;

public interface IEstado {

    public String getsNombreEstado();
    public void setsNombreEstado(String sNombreEstado);

    public boolean checkEstado();
    public int hashCode();
    public boolean equals(Object obj);
    public String toString();
}
