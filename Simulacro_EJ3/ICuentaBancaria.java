public interface ICuentaBancaria {
    
    public String getsNumCuenta();
    public void setsNumCuenta(String sNumCuenta);

    public String getsBanco();
    public void setsBanco(String sBanco);

    public float getfSaldo();
    public void setfSaldo(float fSaldo);

    public Cliente getoCliente();
    public void setoCliente(Cliente oCliente);

    public int hashCode();
    public boolean equals(Object obj);
    public void reducirSaldo(float fCuantia);
    public void ingresarSaldo(float fCuantia);
    public String toString();
}
