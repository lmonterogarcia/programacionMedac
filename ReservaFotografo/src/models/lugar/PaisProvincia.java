package models.lugar;

public class PaisProvincia implements IPaisProvincia {

    // PK
    private Provincia oProvincia;
    private Pais oPais;

    // ###Contructores###
    public PaisProvincia(Provincia oProvincia, Pais oPais) {
        this.setoProvincia(oProvincia);
        this.setoPais(oPais);
    }
    // ###GET and SET###

    public Provincia getoProvincia() {
        return oProvincia;
    }

    public void setoProvincia(Provincia oProvincia) {
        if (oProvincia != null) {
            this.oProvincia = oProvincia;
        }
    }

    public Pais getoPais() {
        return oPais;
    }

    public void setoPais(Pais oPais) {
        if (oPais != null) {
            this.oPais = oPais;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkPaisProvincia(){
        boolean booExito = false;
        if (this.getoProvincia().checkProvincia() && this.getoPais().checkPais()) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((oPais == null) ? 0 : oPais.hashCode());
        result = prime * result + ((oProvincia == null) ? 0 : oProvincia.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        PaisProvincia oPaisProvincia = (PaisProvincia) obj;
        if (oPaisProvincia.getoProvincia() != null && oPaisProvincia.getoPais() != null
                && this.getoProvincia().getsNombreProvincia()
                        .equals(oPaisProvincia.getoProvincia().getsNombreProvincia())
                && this.getoPais().getsNombrePais().equals(oPaisProvincia.getoPais().getsNombrePais())) {
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (this.checkPaisProvincia()) {
            sMensaje += oProvincia.toString() + oPais.toString();
        }
        return sMensaje;
    }
}
