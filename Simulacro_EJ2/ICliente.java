public interface ICliente {
    
    public final byte BCLIENTEBASICO = 0;
    public final byte BINVERSOR = 1;
    public final byte BAUTONOMO = 2;

    public String getsDni();
    public boolean setsDni(String sDni);

    public String getsNombre();
    public boolean setsNombre(String sNombre);

    public String getsApellidos();
    public boolean setsApellidos(String sApellidos);

    public int getiTelefono();
    public boolean setiTelefono(int iTelefono);

    public byte getbTipo();
    public boolean setbTipo(byte bTipo);

    public String toString();
    public int hashCode();
    public boolean equals(Object obj);
}
