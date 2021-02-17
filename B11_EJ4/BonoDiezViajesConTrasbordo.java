import java.util.Calendar;

public class BonoDiezViajesConTrasbordo extends BonoDiezViajes {
   
    private Calendar oUltimoViaje;
    private final int IUNAHORA = 3600000;

    public BonoDiezViajesConTrasbordo(int idBonoBus) {
        super(idBonoBus);
    }

    public boolean picarViaje(short shLineaBus, byte bDia, byte bMes, short shAnio, byte bHora, byte bMinuto) {
        boolean booExito = false;
        
        if (transbordo(shLineaBus, bDia, bMes, shAnio, bHora, bMinuto)){
            if (super.setShLineaBus(shLineaBus) && super.setbDia(bDia) && super.setbMes(bMes) && super.setShAnio(shAnio) && super.setbHoras(bHora) && super.setbMinutos(bMinuto)) {
                booExito = true;
                //oUltimoViaje.set(shAnio, bMes, bDia, bHora, bMinuto); // Si se quiere que cada vez que haga trasbordo empice de nuevo el tiempo, descomentar esta linea. 
            }
        } else if (super.booValido) {
            if (super.setShLineaBus(shLineaBus) && super.setbDia(bDia) && super.setbMes(bMes) && super.setShAnio(shAnio) && super.setbHoras(bHora) && super.setbMinutos(bMinuto)) {
                setbViajesRealizados((byte) (this.bViajesRealizados + 1));
                setBooValido(bonoBusAcabado());
                oUltimoViaje.set(shAnio, bMes, bDia, bHora, bMinuto);
                booExito = true;
            }
        }
        return booExito;
    }

    private boolean transbordo(short shLineaBus, byte bDia, byte bMes, short shAnio, byte bHora, byte bMinuto) {
        boolean booExito = false;
        Calendar oFechaViaje = Calendar.getInstance();
        oFechaViaje.set(shAnio, bMes, bDia, bHora, bMinuto);

        if (super.getbViajesRealizados() > 0 && super.getbViajesRealizados() >= 10 && shLineaBus != super.getShLineaBus()) {
            if (oUltimoViaje.compareTo(oFechaViaje) >= 0 && oUltimoViaje.compareTo(oFechaViaje) <= IUNAHORA) {
                booExito = true;
            }
        }
        return booExito;
    }

}
