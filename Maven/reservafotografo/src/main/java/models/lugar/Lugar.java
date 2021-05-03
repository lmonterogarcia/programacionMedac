package models.lugar;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Pattern;

import models.IPlantilla;

public class Lugar implements ILugar, IPlantilla {

    // PK
    private int iIdLugar;
    // N
    private String sNombreLugar, sGoogleMapLink, sCalleLugar, sNumeroLugar;
    private float fLatitud, fLongitud;
    private CodigoPostalLocalidadPaisProvincia oCodigoPostalLocalidadPaisProvincia;

    // ###Contructores###

    public Lugar(int iIdLugar) {
        setiIdLugar(iIdLugar);
    }

    public Lugar(int iIdLugar, String sNombreLugar, String sCalleLugar) {
        setiIdLugar(iIdLugar);
        setsNombreLugar(sNombreLugar);
        setsCalleLugar(sCalleLugar);
    }

    public Lugar(String sNombreLugar, String sGoogleMapLink, String sCalleLugar, String sNumeroLugar, float fLatitud,
            float fLongitud, CodigoPostalLocalidadPaisProvincia oCodigoPostalLocalidadPaisProvincia) {
        this.iIdLugar = 1;
        setsNombreLugar(sNombreLugar);
        setsGoogleMapLink(sGoogleMapLink);
        setsCalleLugar(sCalleLugar);
        setsNombreLugar(sNombreLugar);
        setfLatitud(fLatitud);
        setfLongitud(fLongitud);
        setoCodigoPostalLocalidadPaisProvincia(oCodigoPostalLocalidadPaisProvincia);
    }

    // ###GET and SET###

    public int getiIdLugar() {
        return iIdLugar;
    }

    public void setiIdLugar(int iIdLugar) {
        if (this.iIdLugar >= 0 && this.iIdLugar <= IMAXIDS) {
            this.iIdLugar = iIdLugar;
        }
    }

    public String getsNombreLugar() {
        return sNombreLugar;
    }

    public void setsNombreLugar(String sNombreLugar) {
        if (sNombreLugar != null && !sNombreLugar.isEmpty() && sNombreLugar.length() < BMAXNOMBRELUGAR) {
            this.sNombreLugar = sNombreLugar;
        }
    }

    public String getsGoogleMapLink() {
        return sGoogleMapLink;
    }

    public void setsGoogleMapLink(String sGoogleMapLink) {
        if (sGoogleMapLink != null && !sGoogleMapLink.isEmpty() && sGoogleMapLink.length() < BMAX255 && Pattern.matches(SPATRONGOOGLEMAPWEB, sGoogleMapLink)) {
            this.sGoogleMapLink = sGoogleMapLink;
        }
    }

    public String getsCalleLugar() {
        return sCalleLugar;
    }

    public void setsCalleLugar(String sCalleLugar) {
        if (sCalleLugar != null && !sCalleLugar.isEmpty() && sCalleLugar.length() < BMAXNOMBRELUGAR) {
            this.sCalleLugar = sCalleLugar;
        }
    }

    public String getsNumeroLugar() {
        return sNumeroLugar;
    }

    public void setsNumeroLugar(String sNumeroLugar) {
        if (sNumeroLugar != null && !sNumeroLugar.isEmpty() && sNumeroLugar.length() < BMAXNUMEROLUGAR) {
            this.sNumeroLugar = sNumeroLugar;
        }
    }

    public float getfLatitud() {
        return fLatitud;
    }

    public void setfLatitud(float fLatitud) {
        if (fLatitud < IMAXLATITUD && fLatitud > IMINLATITUD) {
            BigDecimal bigVariable = new BigDecimal(fLatitud).setScale(BMAXDECIMALLAT, RoundingMode.UP);
            this.fLatitud = bigVariable.floatValue();
        }
    }

    public float getfLongitud() {
        return fLongitud;
    }

    public void setfLongitud(float fLongitud) {
        if (fLongitud < IMAXLONGITUD && fLongitud > IMINLONGITUD) {
            BigDecimal bigVariable = new BigDecimal(fLongitud).setScale(BMAXDECIMALLONG, RoundingMode.UP);
            this.fLongitud = bigVariable.floatValue();
        }
    }

    public CodigoPostalLocalidadPaisProvincia getoCodigoPostalLocalidadPaisProvincia() {
        return oCodigoPostalLocalidadPaisProvincia;
    }

    public void setoCodigoPostalLocalidadPaisProvincia(
            CodigoPostalLocalidadPaisProvincia oCodigoPostalLocalidadPaisProvincia) {
        if (oCodigoPostalLocalidadPaisProvincia != null) {
            this.oCodigoPostalLocalidadPaisProvincia = oCodigoPostalLocalidadPaisProvincia;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkLugar() {
        boolean booExito = false;
        if (this != null && this.getiIdLugar() > 0 && this.getiIdLugar() <= IMAXIDS) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + iIdLugar;
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        Lugar oLugar = (Lugar) obj;
        if ((oLugar != null && ((oLugar.getsNombreLugar() != null && this.getsNombreLugar() != null
                && this.getsNombreLugar().equals(oLugar.getsNombreLugar()))
                || (oLugar.getsCalleLugar() != null && this.getsCalleLugar() != null
                        && this.getsCalleLugar().equals(oLugar.getsCalleLugar()))))) {
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (checkLugar()) {
            sMensaje += "\n##Lugar o Direccion##";
            sMensaje += "\n Id: " + this.getiIdLugar();
            if (this.getsNombreLugar() != null) {
                sMensaje += "\n Nombre: " + this.getsNombreLugar();
            }
            if (this.getsGoogleMapLink() != null) {
                sMensaje += "\n Google Maps Link: " + this.getsGoogleMapLink();
            }
            if (this.getfLatitud() < IMAXLATITUD && this.getfLatitud() > IMINLATITUD) {
                sMensaje += "\n Latitud: " + this.getfLatitud();
            }
            if (this.getfLongitud() < IMAXLONGITUD && this.getfLongitud() > IMINLONGITUD) {
                sMensaje += "\n Longitud: " + this.getfLongitud();
            }
            if (this.getsCalleLugar() != null) {
                sMensaje += "\n Calle: " + this.getsCalleLugar();
            }
            if (this.getsNumeroLugar() != null) {
                sMensaje += "\n Numero: " + this.getsNumeroLugar();
            }
            if (oCodigoPostalLocalidadPaisProvincia != null) {
                sMensaje += oCodigoPostalLocalidadPaisProvincia.toString();
            }
        }
        return sMensaje;
    }
}
