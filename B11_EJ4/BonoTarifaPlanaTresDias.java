import java.util.*;

public class BonoTarifaPlanaTresDias extends BonoTarifaPlana{
    
    private final int ICADUCIDAD = 3;
    private final int ITIPOFECHA = Calendar.DAY_OF_MONTH;
    private boolean booPrimerViaje;

    public BonoTarifaPlanaTresDias(int idBonoBus) {
        super(idBonoBus);
        booPrimerViaje = true;
    }

    public boolean picarViaje(short shLineaBus, byte bDia, byte bMes, short shAnio, byte bHora, byte bMinuto) {
        boolean booExito = false;
        GregorianCalendar oFechaViaje = new GregorianCalendar(shAnio, bMes, bDia, bHora, bMinuto);
        if (booPrimerViaje) {
            super.setoCaducidad(new GregorianCalendar(shAnio, bMes, bDia, bHora, bMinuto));
            super.oCaducidad.add(ITIPOFECHA, ICADUCIDAD);
            booPrimerViaje = false;
        }
        if (oFechaViaje.before(super.getoCaducidad())) {
            if (super.setShLineaBus(shLineaBus) && super.setbDia(bDia) && super.setbMes(bMes) && super.setShAnio(shAnio) && super.setbHoras(bHora) && super.setbMinutos(bMinuto)) {
                booExito = true;
            }
        }
        return booExito;
    }
}
