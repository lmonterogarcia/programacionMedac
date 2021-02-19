import java.util.*;

public class BonoDiezViajesConTrasbordo extends BonoDiezViajes {
   
    private GregorianCalendar oUltimoViaje;

    public BonoDiezViajesConTrasbordo(int idBonoBus) {
        super(idBonoBus);
    }

    public GregorianCalendar getoUltimoViaje() {
        return oUltimoViaje;
    }

    public void setoUltimoViaje(GregorianCalendar oUltimoViaje) {
        this.oUltimoViaje = oUltimoViaje;
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
                oUltimoViaje = new GregorianCalendar(shAnio, bMes, bDia, bHora, bMinuto);
                oUltimoViaje.add(Calendar.HOUR_OF_DAY , 1);
                booExito = true;
            }
        }
        return booExito;
    }

    private boolean transbordo(short shLineaBus, byte bDia, byte bMes, short shAnio, byte bHora, byte bMinuto) {
        boolean booExito = false;
        GregorianCalendar oFechaViaje = new GregorianCalendar(shAnio, bMes, bDia, bHora, bMinuto);

        if (super.getbViajesRealizados() > 0 && super.getbViajesRealizados() <= 10 && shLineaBus != super.getShLineaBus()) {
            if (oFechaViaje.before(getoUltimoViaje())) {
                booExito = true;
            }
        }
        return booExito;
    }

    
}
