package models.lugar;

public class CodigoPostalLocalidadPaisProvincia implements ICodigoPostalLocalidadPaisProvincia {

    // PK
    private Localidad oLocalidad;
    private CodigoPostal oCodigoPostal;
    private PaisProvincia oPaisProvincia;

    // ###Contructores###

    public CodigoPostalLocalidadPaisProvincia(Localidad oLocalidad, CodigoPostal oCodigoPostal,
            PaisProvincia oPaisProvincia) {
        setoLocalidad(oLocalidad);
        setoCodigoPostal(oCodigoPostal);
        setoPaisProvincia(oPaisProvincia);
    }

    // ###GET and SET###

    public Localidad getoLocalidad() {
        return oLocalidad;
    }

    public void setoLocalidad(Localidad oLocalidad) {
        if (oLocalidad != null) {
            this.oLocalidad = oLocalidad;
        }
    }

    public CodigoPostal getoCodigoPostal() {
        return oCodigoPostal;
    }

    public void setoCodigoPostal(CodigoPostal oCodigoPostal) {
        if (oCodigoPostal != null) {
            this.oCodigoPostal = oCodigoPostal;
        }
    }

    public PaisProvincia getoPaisProvincia() {
        return oPaisProvincia;
    }

    public void setoPaisProvincia(PaisProvincia oPaisProvincia) {
        if (oPaisProvincia != null) {
            this.oPaisProvincia = oPaisProvincia;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkCodigoPostalLocalidadPaisProvincia() {
        boolean booExito = false;
        if (this.getoLocalidad().checkLocalidad() && this.getoCodigoPostal().checkCodigoPostal()
                && this.getoPaisProvincia().checkPaisProvincia()) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((oCodigoPostal == null) ? 0 : oCodigoPostal.hashCode());
        result = prime * result + ((oLocalidad == null) ? 0 : oLocalidad.hashCode());
        result = prime * result + ((oPaisProvincia == null) ? 0 : oPaisProvincia.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        CodigoPostalLocalidadPaisProvincia oCodigoPostalLocalidadPaisProvincia = (CodigoPostalLocalidadPaisProvincia) obj;
        if (oCodigoPostalLocalidadPaisProvincia != null && this != null
                && this.getoLocalidad().getsNombreLocalidad()
                        .equals(oCodigoPostalLocalidadPaisProvincia.getoLocalidad().getsNombreLocalidad())
                && this.getoCodigoPostal().getsReferenciaCodigoPostal()
                        .equals(oCodigoPostalLocalidadPaisProvincia.getoCodigoPostal().getsReferenciaCodigoPostal())
                && this.getoPaisProvincia().getoProvincia().getsNombreProvincia().equals(
                        oCodigoPostalLocalidadPaisProvincia.getoPaisProvincia().getoProvincia().getsNombreProvincia())
                && this.getoPaisProvincia().getoPais().getsNombrePais()
                        .equals(oCodigoPostalLocalidadPaisProvincia.getoPaisProvincia().getoPais().getsNombrePais())) {
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (this.checkCodigoPostalLocalidadPaisProvincia()) {
            sMensaje += oCodigoPostal.toString() + oLocalidad.toString() + oPaisProvincia.toString();
        }
        return sMensaje;
    }
}
