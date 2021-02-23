import java.time.*;

public class BonoTarifaPlanaUnMes extends BonoTarifaPlana {
    private final int IPERIODOCADUCIDAD = 1;
    private boolean booPrimerViaje;

    public BonoTarifaPlanaUnMes(int idBonoBus) {
        super(idBonoBus);
        booPrimerViaje = true;
    }
    
    public boolean picarViaje(short shLineaBus, byte bDia, byte bMes, short shAnio, byte bHora, byte bMinuto) {
        boolean booExito = false;
        LocalDateTime oFechaViaje;
        if (super.checkFechaValida(bDia, bMes, shAnio, bHora, bMinuto)) {
            oFechaViaje = LocalDateTime.of(shAnio, bMes, bDia, bHora, bMinuto);
            if (booPrimerViaje && super.setoCaducidad((LocalDateTime.of(shAnio, bMes, bDia, bHora, bMinuto)).plusMonths(IPERIODOCADUCIDAD))) {
                booPrimerViaje = false;
            }
            if (oFechaViaje.isBefore(super.getoCaducidad()) && (oFechaViaje.isAfter(super.getoCaducidad().minusMonths(IPERIODOCADUCIDAD)) || oFechaViaje.isEqual(super.getoCaducidad().minusMonths(IPERIODOCADUCIDAD)))) {
                if (super.setShLineaBus(shLineaBus) && super.setShAnio(shAnio) && super.setbMes(bMes) && super.setbDia(bDia) && super.setbHoras(bHora) && super.setbMinutos(bMinuto)) {
                    booExito = true;
                }
            }
        }
        return booExito;
    }
}
