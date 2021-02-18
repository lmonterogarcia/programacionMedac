import java.util.GregorianCalendar;

public class BonoTarifaPlanaUnDia extends BonoTarifaPlana {
    private GregorianCalendar oCaducidad;
    private final int ICADUCIDAD = 1;
    private final int ITIPOFECHA = GregorianCalendar.DAY_OF_MONTH;

    public BonoTarifaPlanaUnDia(int idBonoBus) {
        super(idBonoBus);
        oCaducidad = (GregorianCalendar) GregorianCalendar.getInstance();
        oCaducidad.add(ITIPOFECHA, ICADUCIDAD);
    }
}
