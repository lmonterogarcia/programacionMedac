import java.util.regex.Pattern;

public class CuentaBancaria {
    
    private String sNumCuenta, sBanco;
    private float fSaldo;
    private Cliente oCliente;

    public CuentaBancaria(String sNumCuenta) {
        setsNumCuenta(sNumCuenta);
    }

    public CuentaBancaria(String sNumCuenta, String sBanco, String sSaldo) {
        setsNumCuenta(sNumCuenta);
        setsBanco(sBanco);
        setfSaldo(sSaldo);
    }

    public String getsNumCuenta() {
        return sNumCuenta;
    }

    public boolean setsNumCuenta(String sNumCuenta) {
        
        boolean booExito = false;
        if (sNumCuenta != null && Pattern.matches("\\d{16}", sNumCuenta)) {
            this.sNumCuenta = sNumCuenta;
        }
        return booExito;
    }

    public String getsBanco() {
        return sBanco;
    }

    public boolean setsBanco(String sBanco) {
        boolean booExito = false;
        if (sBanco != null && (sBanco.length() > 0 && sBanco.length() <= 150)) {
            this.sBanco = sBanco;
        }
        return booExito;
    }

    public float getfSaldo() {
        return fSaldo;
    }

    public boolean setfSaldo(String sSaldo) {
        boolean booExito = false;
        if (sSaldo!= null && Pattern.matches("\\d{9}[.]d{2}", sNumCuenta) ) {
            this.fSaldo = Float.parseFloat(sSaldo); 
        }
        return booExito;
    }

    public Cliente getoCliente() {
        return oCliente;
    }

    public boolean setoCliente(Cliente oCliente) {
        boolean booExito = false;
        if (oCliente != null) {
             this.oCliente = oCliente;
             booExito = true;
        }
        return booExito;
       
    }

    
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(fSaldo);
        result = prime * result + ((sBanco == null) ? 0 : sBanco.hashCode());
        result = prime * result + ((sNumCuenta == null) ? 0 : sNumCuenta.hashCode());
        return result;
    }

    
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CuentaBancaria other = (CuentaBancaria) obj;
        if (Float.floatToIntBits(fSaldo) != Float.floatToIntBits(other.fSaldo))
            return false;
        if (sBanco == null) {
            if (other.sBanco != null)
                return false;
        } else if (!sBanco.equals(other.sBanco))
            return false;
        if (sNumCuenta == null) {
            if (other.sNumCuenta != null)
                return false;
        } else if (!sNumCuenta.equals(other.sNumCuenta))
            return false;
        return true;
    }

    public void reducirSaldo(float fCuantia){

    }

    public void ingresarSaldo(float fCuantia) {

    }

    
    public String toString() {
        return "CuentaBancaria [fSaldo=" + fSaldo + ", sBanco=" + sBanco + ", sNumCuenta=" + sNumCuenta + "]";
    }
}
