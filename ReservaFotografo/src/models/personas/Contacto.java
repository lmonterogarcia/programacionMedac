package models.personas;

import java.time.*;
import java.util.regex.Pattern;
import models.IPlantilla;

abstract class Contacto implements IContacto, IPlantilla {

    // PK
    private int iIdContacto;
    // NN
    private LocalDateTime oFechaCreacion;
    private String sNombreContacto;
    // N
    private String sDniContacto, sApellido1Contacto, sApellido2Contacto, sTelefonoContacto;
    private LocalDate oFechaNacimientoContacto;

    // ###Contructores###

    public Contacto(int iIdContacto) {
        setiIdContacto(iIdContacto);
    }

    public Contacto(String sNombreContacto) {
        this.iIdContacto = 1;
        setoFechaCreacion();
        setsNombreContacto(sNombreContacto);
    }

    public Contacto(String sDniContacto, String sNombreContacto, String sApellido1Contacto,
            String setsApellido2Contacto, String sTelefonoContacto, LocalDate oFechaNacimientoContacto) {
        this.iIdContacto = 1;
        setoFechaCreacion();
        setsNombreContacto(sNombreContacto);
        setsDniContacto(sDniContacto);
        setsApellido1Contacto(sApellido1Contacto);
        setsetsApellido2Contacto(setsApellido2Contacto);
        setsTelefonoContacto(sTelefonoContacto);
        setoFechaNacimientoContacto(oFechaNacimientoContacto);
    }

    // ###GET and SET###

    public int getiIdContacto() {
        return iIdContacto;
    }

    // Es private por que solo se va a utilizar para la busqueda
    private void setiIdContacto(int iIdContacto) {
        if (this.iIdContacto >= 0 && this.iIdContacto <= IMAXIDS) {
            this.iIdContacto = iIdContacto;
        }
    }

    public LocalDateTime getoFechaCreacion() {
        return oFechaCreacion;
    }

    // Es private por que solo se va a utilizar en la creacion del dato,
    // despues no se puede cambiar.
    private void setoFechaCreacion() {
        this.oFechaCreacion = LocalDateTime.now();
    }

    public String getsNombreContacto() {
        return sNombreContacto;
    }

    public void setsNombreContacto(String sNombreContacto) {
        if (sNombreContacto != null && !sNombreContacto.isEmpty() && sNombreContacto.length() < BMAXNOMBRE) {
            this.sNombreContacto = sNombreContacto;
        }

    }

    public String getsDniContacto() {
        return sDniContacto;
    }

    public void setsDniContacto(String sDniContacto) {
        if (sDniContacto != null && !sDniContacto.isEmpty() && sDniContacto.length() <= BMAXDNI
                && Pattern.matches(SPATRONDNI, sDniContacto)) {
            this.sDniContacto = sDniContacto;
        }

    }

    public String getsApellido1Contacto() {
        return sApellido1Contacto;
    }

    public void setsApellido1Contacto(String sApellido1Contacto) {
        if (sApellido1Contacto != null && !sApellido1Contacto.isEmpty()
                && sApellido1Contacto.length() < BMAXAPELLIDOS) {
            this.sApellido1Contacto = sApellido1Contacto;
        }

    }

    public String getsetsApellido2Contacto() {
        return sApellido2Contacto;
    }

    public void setsetsApellido2Contacto(String sApellido2Contacto) {
        if (sApellido1Contacto != null && !sApellido1Contacto.isEmpty()
                && sApellido1Contacto.length() < BMAXAPELLIDOS) {
            this.sApellido2Contacto = sApellido2Contacto;
        }
    }

    public String getsTelefonoContacto() {
        return sTelefonoContacto;
    }

    public void setsTelefonoContacto(String sTelefonoContacto) {
        if (sTelefonoContacto != null && !sTelefonoContacto.isEmpty() && sTelefonoContacto.length() <= BMAXTELEFONO
                && Pattern.matches(SPATRONTELEFONO, sTelefonoContacto)) {
            this.sTelefonoContacto = sTelefonoContacto;
        }
    }

    public LocalDate getoFechaNacimientoContacto() {
        return oFechaNacimientoContacto;
    }

    public void setoFechaNacimientoContacto(LocalDate oFechaNacimientoContacto) {
        if (oFechaNacimientoContacto != null) {
            this.oFechaNacimientoContacto = oFechaNacimientoContacto;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkContacto() {
        boolean booExito = false;
        if (getiIdContacto() < 0 && getiIdContacto() > IMAXIDS && getoFechaCreacion() != null
                && getsNombreContacto() != null && !this.getsNombreContacto().isEmpty()) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + iIdContacto;
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        Contacto oContacto = (Contacto) obj;
        if (oContacto != null && this.iIdContacto > 0 && this.iIdContacto <= IMAXIDS
                && this.iIdContacto == oContacto.getiIdContacto()) {
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (this.iIdContacto >= 0 && this.iIdContacto <= IMAXIDS) {
            sMensaje += "\n Fecha de creacion: " + this.oFechaCreacion.getDayOfMonth() + "/"
                    + this.oFechaCreacion.getMonth() + "/" + this.oFechaCreacion.getYear() + " a las "
                    + oFechaCreacion.getHour() + ":" + oFechaCreacion.getMinute() + ":" + oFechaCreacion.getSecond();
            sMensaje += "\n Nombre: " + getsNombreContacto();
            if (this.sApellido1Contacto != null) {
                sMensaje += "\n Primer apellido: " + getsApellido1Contacto();
            }
            if (this.sApellido2Contacto != null) {
                sMensaje += "\n Segundo apellido: " + getsetsApellido2Contacto();
            }
            if (this.sDniContacto != null) {
                sMensaje += "\n DNI: " + getsDniContacto();
            }
            if (this.sTelefonoContacto != null) {
                sMensaje += "\n Telefono: " + getsTelefonoContacto();
            }
            if (this.oFechaNacimientoContacto != null) {
                sMensaje += "\n Fecha de nacimiento: " + this.oFechaNacimientoContacto.getDayOfMonth() + "/"
                        + this.oFechaNacimientoContacto.getMonth() + "/" + this.oFechaNacimientoContacto.getYear();
            }
        } else {
            sMensaje = "El contacto esta vacio o tiene algún error";
        }
        return sMensaje;
    }
}
