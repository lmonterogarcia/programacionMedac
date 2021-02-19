public interface ICliente {
    
    public final byte BCLIENTEBASICO = 0;
    public final byte BINVERSOR = 1;
    public final byte BAUTONOMO = 2;

    public String getsDni();
    public String getsNombre();
    public String getsApellidos();
    public int getiTelefono();
    public byte getbTipo();

    public String toString();
    public int hashCode();
    public boolean equals(Object obj);
}
