import java.util.regex.Pattern;

abstract class Cliente implements ICliente{
    private String sDni, sNombre, sApellidos;
    private int iTelefono;
    private byte bTipo;

    protected Cliente(String sDni) {
        setsDni(sDni);
    }

    protected Cliente(String sDni, String sNombre, String sApellidos, int iTelefono, byte bTipo) {
        setsDni(sDni);
        setsNombre(sNombre);
        setsApellidos(sApellidos);
        setiTelefono(iTelefono);
        setbTipo(bTipo);
    }

    public String getsDni() {
        return sDni;
    }

    protected boolean setsDni(String sDni) {
        boolean booExito = false;
        if (sDni != null && Pattern.matches("\\d{8}[A-Za-z]", sDni)) {
            this.sDni = sDni;
        }
        return booExito;
    }

    public String getsNombre() {
        return sNombre;
    }

    protected boolean setsNombre(String sNombre) {
        boolean booExito = false;
        if (sNombre != null && (sNombre.length() > 0 && sNombre.length() <= 150)) {
            this.sNombre = sNombre;
        }
        return booExito;
    }

    public String getsApellidos() {
        return sApellidos;
    }

    protected boolean setsApellidos(String sApellidos) {
        boolean booExito = false;
        if (sApellidos != null && (sApellidos.length() > 0 && sApellidos.length() <= 150)) {
            this.sApellidos = sApellidos;
        }
        return booExito;
    }

    public int getiTelefono() {
        return iTelefono;
    }

    protected boolean setiTelefono(int iTelefono) {
        boolean booExito = false;
        if (iTelefono >= 600000000 && iTelefono <= 899999999) {
            this.iTelefono = iTelefono;
        }
        return booExito;
    }

    public byte getbTipo() {
        return bTipo;
    }

    protected boolean setbTipo(byte bTipo) {
        boolean booExito = false;
        if (bTipo >= 0 && bTipo <= 2) {
            this.bTipo = bTipo;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "\n### CLIENTE ###\n\n";
        sMensaje += "DNI: " + sDni + "\n";
        if (getsNombre() != null) {
            sMensaje += "Nombre: " + getsNombre() + "\n";
        }
        if (getsApellidos() != null) {
           sMensaje += "Apellido: " + getsApellidos() + "\n"; 
        }
        if (iTelefono >= 600000000 && iTelefono <= 899999999) {
            sMensaje += "Telefono: " + getiTelefono() + "\n";
        }
        if (bTipo >= 0 && bTipo <= 2) {
            sMensaje += "Tipo de cliente: ";
            switch (bTipo) {
                case BCLIENTEBASICO:
                sMensaje += "Cliente particular";
                    break;
                case BINVERSOR:
                sMensaje += "Inversor";
                    break;
                default:
                sMensaje += "Autonomo";
                    break;
            }
        }
        return sMensaje;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bTipo;
        result = prime * result + iTelefono;
        result = prime * result + ((sApellidos == null) ? 0 : sApellidos.hashCode());
        result = prime * result + ((sDni == null) ? 0 : sDni.hashCode());
        result = prime * result + ((sNombre == null) ? 0 : sNombre.hashCode());
        return result;
    }

    public boolean equals(Cliente oCliente) {
        boolean booEsIgual = false;
        if (oCliente.getsDni() != null && oCliente.getsDni() == this.sDni) {
            booEsIgual = true;
        }
        return booEsIgual;
    }
}
