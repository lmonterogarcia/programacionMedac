
public class ClienteNormal extends Cliente {

    boolean booSeguroVivienda;
    boolean booSeguroVida;

    public ClienteNormal(String sDni) {
        super(sDni);
    }

    public ClienteNormal(String sDni, String sNombre, String sApellidos, int iTelefono, byte bTipo, boolean booSeguroVivienda, boolean booSeguroVida) {
        super(sDni, sNombre, sApellidos, iTelefono, bTipo);
        setBooSeguroVida(booSeguroVida);
        setBooSeguroVivienda(booSeguroVivienda);
    }

    public boolean isBooSeguroVivienda() {
        return booSeguroVivienda;
    }

    public void setBooSeguroVivienda(boolean booSeguroVivienda) {
        this.booSeguroVivienda = booSeguroVivienda;
    }

    public boolean isBooSeguroVida() {
        return booSeguroVida;
    }

    public void setBooSeguroVida(boolean booSeguroVida) {
        this.booSeguroVida = booSeguroVida;
    }

    public String toString() {
       String sMensaje = super.toString();
       if (booSeguroVida && booSeguroVivienda) {
           sMensaje += "\nSeguros contratados:";
           if (booSeguroVida) {
                sMensaje += "   - Seguro de vida";
           }
           if (booSeguroVivienda) {
                sMensaje += "   - Seguro de vivienda";
        }
       }
       return sMensaje;
    }
    
}