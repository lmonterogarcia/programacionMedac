package models.personas;

import java.time.LocalDate;
import java.time.LocalDateTime;

abstract class Contacto implements IContacto {

    // PK
    private String sIdContacto;
    // NN
    private LocalDateTime oFechaCreacion;
    private String sNombreContacto;
    // N
    private String sDniContacto, sApellido1Contacto, sApellido2contacto, sTelefonoContacto;
    private LocalDate oFechaNacimientoContacto;
    private byte bEdad;

    // Contructores
    public Contacto(String sIdContacto) {
        setsIdContacto(sIdContacto);
    }

    public Contacto(String sIdContacto, LocalDateTime oFechaCreacion, String sNombreContacto) {
        setsIdContacto(sIdContacto);
        setoFechaCreacion(oFechaCreacion);
        setsNombreContacto(sNombreContacto);
    }

    public Contacto(String sIdContacto, LocalDateTime oFechaCreacion, String sNombreContacto,
            String sDniContacto, String sApellido1Contacto, String sApellido2contacto, String sTelefonoContacto,
            LocalDate oFechaNacimientoContacto, byte bEdad) {
        setsIdContacto(sIdContacto);
        setoFechaCreacion(oFechaCreacion);
        setsNombreContacto(sNombreContacto);
        setsDniContacto(sDniContacto);
        setsApellido1Contacto(sApellido1Contacto);
        setsApellido2contacto(sApellido2contacto);
        setsTelefonoContacto(sTelefonoContacto);
        setoFechaNacimientoContacto(oFechaNacimientoContacto);
        setbEdad(bEdad);
    }

    // GET and SET
    public String getsIdContacto() {
        return sIdContacto;
    }

    public void setsIdContacto(String sIdContacto) {
        this.sIdContacto = sIdContacto;
    }

    public LocalDateTime getoFechaCreacion() {
        return oFechaCreacion;
    }

    public void setoFechaCreacion(LocalDateTime oFechaCreacion) {
        this.oFechaCreacion = oFechaCreacion;
    }

    public String getsNombreContacto() {
        return sNombreContacto;
    }

    public void setsNombreContacto(String sNombreContacto) {
        this.sNombreContacto = sNombreContacto;
    }

    public String getsDniContacto() {
        return sDniContacto;
    }

    public void setsDniContacto(String sDniContacto) {
        this.sDniContacto = sDniContacto;
    }

    public String getsApellido1Contacto() {
        return sApellido1Contacto;
    }

    public void setsApellido1Contacto(String sApellido1Contacto) {
        this.sApellido1Contacto = sApellido1Contacto;
    }

    public String getsApellido2contacto() {
        return sApellido2contacto;
    }

    public void setsApellido2contacto(String sApellido2contacto) {
        this.sApellido2contacto = sApellido2contacto;
    }

    public String getsTelefonoContacto() {
        return sTelefonoContacto;
    }

    public void setsTelefonoContacto(String sTelefonoContacto) {
        this.sTelefonoContacto = sTelefonoContacto;
    }

    public LocalDate getoFechaNacimientoContacto() {
        return oFechaNacimientoContacto;
    }

    public void setoFechaNacimientoContacto(LocalDate oFechaNacimientoContacto) {
        this.oFechaNacimientoContacto = oFechaNacimientoContacto;
    }

    public byte getbEdad() {
        return bEdad;
    }

    public void setbEdad(byte bEdad) {
        this.bEdad = bEdad;
    }
    // Metodos de esta clase

}
