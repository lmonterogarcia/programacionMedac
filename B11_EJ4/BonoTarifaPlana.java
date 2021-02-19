import java.util.*;

abstract class BonoTarifaPlana extends BonoBus implements IBonoBus {

    protected GregorianCalendar oCaducidad; // en vez de crear 5 atributos, he creado un objeto de la clase Calendar. Se simplifica todo muchisimo.
    private byte bDiaCaducidad;
    private byte bMesCaducidad;
    private short shAnioCaducidad;
    private byte bHorasCaducidad;
    private byte bMinutosCaducidad;

    public BonoTarifaPlana(int idBonoBus) {
        super(idBonoBus);
    }

    public BonoTarifaPlana(int idBonoBus, byte bDiaCaducidad, byte bMesCaducidad, short shAnioCaducidad, byte bHoraCaducidad, byte bMinutoCaducidad) {
        super(idBonoBus);
        setbDiaCaducidad(bDiaCaducidad);
        setbMesCaducidad(bMesCaducidad);
        this.shAnioCaducidad = shAnioCaducidad;
        this.bHorasCaducidad = bHoraCaducidad;
        this.bMinutosCaducidad = bMinutoCaducidad;
        this.oCaducidad = new GregorianCalendar(this.shAnioCaducidad, this.bMesCaducidad, this.bDiaCaducidad, this.bHorasCaducidad, this.bMinutosCaducidad);
    }

    public GregorianCalendar getoCaducidad() {
        return oCaducidad;
    }

    protected void setoCaducidad(GregorianCalendar oCaducidad) {
        this.oCaducidad = oCaducidad;
    }

    public byte getbDiaCaducidad() {
        return bDiaCaducidad;
    }

    protected void setbDiaCaducidad(byte bDiaCaducidad) {
        this.bDiaCaducidad = bDiaCaducidad;
    }

    public byte getbMesCaducidad() {
        return bMesCaducidad;
    }

    protected void setbMesCaducidad(byte bMesCaducidad) {
        this.bMesCaducidad = bMesCaducidad;
    }

    public short getShAnioCaducidad() {
        return shAnioCaducidad;
    }

    protected void setShAnioCaducidad(short shAnioCaducidad) {
        this.shAnioCaducidad = shAnioCaducidad;
    }

    public byte getbHorasCaducidad() {
        return bHorasCaducidad;
    }

    protected void setbHorasCaducidad(byte bHorasCaducidad) {
        this.bHorasCaducidad = bHorasCaducidad;
    }

    public byte getbMinutosCaducidad() {
        return bMinutosCaducidad;
    }

    protected void setbMinutosCaducidad(byte bMinutosCaducidad) {
        this.bMinutosCaducidad = bMinutosCaducidad;
    }

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
 
    public String toString(){
        String sMensaje = super.toString();
        sMensaje += "\nValido hasta " + oCaducidad.get(Calendar.DAY_OF_MONTH) + "/" + oCaducidad.get(Calendar.MONTH) + "/" + oCaducidad.get(Calendar.YEAR) + " " + oCaducidad.get(Calendar.HOUR_OF_DAY) + ":" + oCaducidad.get(Calendar.MINUTE) + "\n";
        return sMensaje;
    }
}
