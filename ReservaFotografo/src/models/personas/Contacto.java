package models.personas;

import java.time.*;

abstract class Contacto implements IContacto {

    // PK
    private String sIdContacto;
    // NN
    private LocalDateTime oFechaCreacion;
    private String sNombreContacto;
    // N
    private String sDniContacto, sApellido1Contacto, setsApellido2Contacto, sTelefonoContacto;
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
            String sDniContacto, String sApellido1Contacto, String setsApellido2Contacto, String sTelefonoContacto,
            LocalDate oFechaNacimientoContacto, byte bEdad) {
        setsIdContacto(sIdContacto);
        setoFechaCreacion(oFechaCreacion);
        setsNombreContacto(sNombreContacto);
        setsDniContacto(sDniContacto);
        setsApellido1Contacto(sApellido1Contacto);
        setsetsApellido2Contacto(setsApellido2Contacto);
        setsTelefonoContacto(sTelefonoContacto);
        setoFechaNacimientoContacto(oFechaNacimientoContacto);
        setbEdad(bEdad);
    }

    // GET and SET
    public String getsIdContacto() {
        return sIdContacto;
    }

    /* #### Se auto genera en la base de datos
    public void setsIdContacto(String sIdContacto) {
        this.sIdContacto = sIdContacto;
    }
    */

    public LocalDateTime getoFechaCreacion() {
        return oFechaCreacion;
    }

    // #### Es private por que solo se va a utilizar en la creacion del dato, depsue sno se puede cambiar.
    private void setoFechaCreacion(LocalDateTime oFechaCreacion) {
        if (oFechaCreacion != null) {
        this.oFechaCreacion = oFechaCreacion;  
        }
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

    public String getsetsApellido2Contacto() {
        return setsApellido2Contacto;
    }

    public void setsetsApellido2Contacto(String setsApellido2Contacto) {
        this.setsApellido2Contacto = setsApellido2Contacto;
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

    public boolean checkContacto(Contacto oContacto){
        boolean booExito = false;
        return booExito;
    }
    
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sIdContacto == null) ? 0 : sIdContacto.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        Contacto oContacto = (Contacto) obj;
        if (oContacto != null && this.sIdContacto != null && this.sIdContacto.equals(oContacto.getsIdContacto())) {
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (this.sIdContacto != null) {
            sMensaje +="\n Id: " + getsIdContacto();
            sMensaje +="\n Fecha de creacion: " + this.oFechaCreacion.getDayOfMonth() + "/" + this.oFechaCreacion.getMonth() + "/" + this.oFechaCreacion.getYear() + " a las " + oFechaCreacion.getHour() + ":" + oFechaCreacion.getMinute() + ":" + oFechaCreacion.getSecond() ;
            sMensaje +="\n Nombre: " + getsNombreContacto();
            if (this.sApellido1Contacto != null) {
                sMensaje +="\n Primer apellido: " + getsApellido1Contacto();
            }
            if (this.setsApellido2Contacto != null) {
                sMensaje +="\n Segundo apellido: " + getsetsApellido2Contacto();
            }
            if (this.sDniContacto != null) {
                sMensaje +="\n DNI: " + getsDniContacto();
            }
            if (this.sTelefonoContacto != null) {
                sMensaje +="\n Telefono: " + getsTelefonoContacto();
            }
            if (this.oFechaNacimientoContacto != null) {
                sMensaje +="\n Fecha de nacimiento: " + this.oFechaNacimientoContacto.getDayOfMonth() + "/" + this.oFechaNacimientoContacto.getMonth() + "/" + this.oFechaNacimientoContacto.getYear();
            }
        } else {
            sMensaje = "El contacto esta vacio o tiene algún error";
        }
        return sMensaje;
    }

}
