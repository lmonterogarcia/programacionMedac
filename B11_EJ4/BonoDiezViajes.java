public class BonoDiezViajes extends BonoBus implements IBonoBus {
    
    protected boolean booValido;
    protected byte bViajesRealizados;

    public BonoDiezViajes(int idBonoBus){
        super(idBonoBus);
        setbViajesRealizados((byte) 0);
        setBooValido(true);
    }

    public boolean isBooValido() {
        return booValido;
    }

    public void setBooValido(boolean booValido) {
        this.booValido = booValido;
    }

    public byte getbViajesRealizados() {
        return bViajesRealizados;
    }

    public boolean setbViajesRealizados(byte bViajesRealizados) {
        boolean booExito = false;
        if (isBooValido() && bViajesRealizados > this.bViajesRealizados) {
            this.bViajesRealizados = bViajesRealizados;
            booExito = true;
        }
        return booExito;
    }

    public boolean bonoBusAcabado () {
        boolean booExito = false;
        if (this.bViajesRealizados < 10) {
           booExito = true;
        }
        return booExito;
    }
    
    public boolean picarViaje(short shLineaBus, byte bDia, byte bMes, short shAnio, byte bHora, byte bMinuto) {
        boolean booExito = false;
        if (booValido) {
            if (super.setShLineaBus(shLineaBus) && super.setbDia(bDia) && super.setbMes(bMes) && super.setShAnio(shAnio) && super.setbHoras(bHora) && super.setbMinutos(bMinuto)) {
                setbViajesRealizados((byte) (this.bViajesRealizados + 1));
                setBooValido(bonoBusAcabado());
                booExito = true;
            }
        }
        return booExito;
    }

    public String toString(){
        String sMensaje = super.toString();
        sMensaje += "\nQuedan " + (10 - bViajesRealizados) + " viajes en el bonobus.\n";
        return sMensaje;
    }
}
