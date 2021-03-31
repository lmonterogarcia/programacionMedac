package models.personas;

import java.time.*;

public interface IContacto {
    public final String SLETRACLIENTE = "C";

    public int getiIdContacto();
    public LocalDateTime getoFechaCreacion();
    public String getsNombreContacto();
    public void setsNombreContacto(String sNombreContacto);
    public String getsDniContacto();
    public void setsDniContacto(String sDniContacto);
    public String getsApellido1Contacto();
    public void setsApellido1Contacto(String sApellido1Contacto);
    public String getsetsApellido2Contacto();
    public void setsetsApellido2Contacto(String setsApellido2Contacto);
    public String getsTelefonoContacto();
    public void setsTelefonoContacto(String sTelefonoContacto);
    public LocalDate getoFechaNacimientoContacto();
    public void setoFechaNacimientoContacto(LocalDate oFechaNacimientoContacto);

    public boolean checkContacto();
    public int hashCode();
    public boolean equals(Object obj);
    public String toString();
}
