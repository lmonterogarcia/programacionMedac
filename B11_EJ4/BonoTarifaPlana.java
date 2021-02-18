import java.util.GregorianCalendar;

public class BonoTarifaPlana extends BonoBus implements IBonoBus {

    GregorianCalendar oCaducidad;
    

    public BonoTarifaPlana(int idBonoBus){
        super(idBonoBus);
    }

    public BonoTarifaPlana(int idBonoBus) {
        super(idBonoBus);
        oCaducidad = (GregorianCalendar) GregorianCalendar.getInstance();
        oCaducidad.add((GregorianCalendar.MONTH), 1);
        
    }

    @Override
    public boolean picarViaje(short shLineaBus, byte bDia, byte bMes, short shAnio, byte bHora, byte bMinuto) {
        boolean booExito = false;
        GregorianCalendar oFechaViaje = new GregorianCalendar(shAnio, bMes, bDia, bHora, bMinuto);
        if (oFechaViaje.before(oCaducidad)) {
            if (super.setShLineaBus(shLineaBus) && super.setbDia(bDia) && super.setbMes(bMes) && super.setShAnio(shAnio) && super.setbHoras(bHora) && super.setbMinutos(bMinuto)) {
                booExito = true;
            }
        }
        return booExito;
    }
    
}
