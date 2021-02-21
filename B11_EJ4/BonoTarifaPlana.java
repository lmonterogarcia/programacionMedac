
import java.time.*;

abstract class BonoTarifaPlana extends BonoBus implements IBonoBus {

    private LocalDateTime oCaducidad; // en vez de crear 5 atributos, he creado un objeto de la clase Calendar. Se simplifica todo muchisimo.


    protected BonoTarifaPlana(int idBonoBus) {
        super(idBonoBus);
    }

    protected BonoTarifaPlana(int idBonoBus, LocalDateTime oCaducidad) {
        super(idBonoBus);
        setoCaducidad(oCaducidad);    
    }

    public LocalDateTime getoCaducidad() {
        return oCaducidad;
    }

    public boolean setoCaducidad(LocalDateTime oCaducidad) {
        boolean booExito;
        try {
            this.oCaducidad = oCaducidad;
            booExito = true;
        } catch (Exception e) {
            booExito = false;
        }
        return booExito;
    }

    public boolean picarViaje(short shLineaBus, byte bDia, byte bMes, short shAnio, byte bHora, byte bMinuto) {
        boolean booExito = false;
        LocalDateTime oFechaViaje;
        if (checkFechaValida(bDia, bMes, shAnio, bHora, bMinuto)) {
            oFechaViaje = LocalDateTime.of(shAnio, bMes, bDia, bHora, bMinuto);
            if (oFechaViaje.isBefore(oCaducidad)) {
                if (super.setShLineaBus(shLineaBus) && super.setShAnio(shAnio) && super.setbMes(bMes) && super.setbDia(bDia) && super.setbHoras(bHora) && super.setbMinutos(bMinuto)) {
                    booExito = true;
                }
            }
        }
        
        return booExito;
    }

    protected boolean checkFechaValida(byte bDia, byte bMes, short shAnio, byte bHora, byte bMinuto) {
        boolean booExito;
        LocalDateTime oFecha;
        try {
            oFecha = LocalDateTime.of(shAnio, bMes, bDia, bHora, bMinuto);
            booExito = true;
        } catch (Exception e) {
            oFecha = null;
            booExito = false;
        }
        return booExito;
    }

    public String toString(){
        String sMensaje = super.toString();
        sMensaje += "\nValido hasta " + oCaducidad.getDayOfMonth() + "/" + oCaducidad.getMonthValue() + "/" + oCaducidad.getYear() + " " + oCaducidad.getHour() + ":" + oCaducidad.getMinute() + "\n";
        return sMensaje;
    }

    
}
