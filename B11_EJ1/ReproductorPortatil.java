public class ReproductorPortatil implements IReproductorPortatil {

    private String sMarca, sModelo;
    private boolean booReproduceSonido, booReproduceVideo;
    private byte bTipoDeAlmacenamiento, bPantalla, bTipoDeBateria, bAutonomia;
    private int iCapacidadDeAlmacenamiento;
    private float fPeso, fAncho, fAlto, fGrosor;

    public ReproductorPortatil(String sMarca, String sModelo, byte bTipoDeAlmacenamiento) {
        setsMarca(sMarca);
        setsModelo(sModelo);
        setbTipoDeAlmacenamiento(bTipoDeAlmacenamiento);
        setBooReproduceSonido(true);
    }

    public String getsMarca() {
        return sMarca;
    }

    public boolean setsMarca(String sMarca) {
        boolean booExito = false;
        if (sMarca != null) {
            this.sMarca = sMarca;
            booExito = true;
        }
        return booExito;
    }

    public String getsModelo() {
        return sModelo;
    }

    public boolean setsModelo(String sModelo) {
        boolean booExito = false;
        if (sModelo != null) {
            this.sModelo = sModelo;
            booExito = true;
        }
        return booExito;
    }

    public boolean isBooReproduceSonido() {
        return booReproduceSonido;
    }

    public boolean setBooReproduceSonido(boolean booReproduceSonido) {
        boolean booExito = false;
        if (booReproduceSonido != this.booReproduceSonido) {
            this.booReproduceSonido = booReproduceSonido;
            booExito = true;
        }
        return booExito;
    }

    public boolean isBooReproduceVideo() {
        return booReproduceVideo;
    }

    public boolean setBooReproduceVideo(boolean booReproduceVideo) {
        boolean booExito = false;
        if (booReproduceVideo != this.booReproduceVideo) {
            this.booReproduceVideo = booReproduceVideo;
            booExito = true;
        }
        return booExito;
    }

    public byte getbTipoDeAlmacenamiento() {
        return bTipoDeAlmacenamiento;
    }

    public boolean setbTipoDeAlmacenamiento(byte bTipoDeAlmacenamiento) {
        boolean booExito = false;
        if (bTipoDeAlmacenamiento >= 1 && bTipoDeAlmacenamiento <= 4) {
            this.bTipoDeAlmacenamiento = bTipoDeAlmacenamiento;
            booExito = true;
        }
        return booExito;
    }

    public byte getbPantalla() {
        return bPantalla;
    }

    public boolean setbPantalla(byte bPantalla) {
        boolean booExito = false;
        if (booReproduceVideo && bPantalla >= 1 && bPantalla <= 4) {
            this.bPantalla = bPantalla;
            booExito = true;
        }
        return booExito;
    }

    public byte getbTipoDeBateria() {
        return bTipoDeBateria;
    }

    public boolean setbTipoDeBateria(byte bTipoDeBateria) {
        boolean booExito = false;
        if (bTipoDeBateria >= 1 && bTipoDeBateria <= 2) {
            this.bTipoDeBateria = bTipoDeBateria;
            booExito = true;
        }
        return booExito;
    }

    public byte getbAutonomia() {
        return bAutonomia;
    }

    public boolean setbAutonomia(byte bAutonomia) {
        boolean booExito = false;
        if (bAutonomia >= 1 && bAutonomia <= 100) {
            this.bAutonomia = bAutonomia;
            booExito = true;
        }
        return booExito;
    }

    public int getiCapacidadDeAlmacenamiento() {
        return iCapacidadDeAlmacenamiento;
    }

    public boolean setiCapacidadDeAlmacenamiento(short iCapacidadDeAlmacenamiento) {
        boolean booExito = false;
        if (iCapacidadDeAlmacenamiento >= 1 && iCapacidadDeAlmacenamiento <= 100000) {
            this.iCapacidadDeAlmacenamiento = iCapacidadDeAlmacenamiento;
            booExito = true;
        }
        return booExito;
    }

    public float getfPeso() {
        return fPeso;
    }

    public boolean setfPeso(float fPeso) {
        boolean booExito = false;
        if (fPeso >= 1 && fPeso <= 1000) {
            this.fPeso = fPeso;
            booExito = true;
        }
        return booExito;
    }

    public float getfAncho() {
        return fAncho;
    }

    public boolean setfAncho(float fAncho) {
        boolean booExito = false;
        if (fAncho >= 1 && fAncho <= 1000) {
            this.fAncho = fAncho;
            booExito = true;
        }
        return booExito;
    }

    public float getfAlto() {
        return fAlto;
    }

    public boolean setfAlto(float fAlto) {
        boolean booExito = false;
        if (fAlto >= 1 && fAlto <= 1000) {
            this.fAlto = fAlto;
            booExito = true;
        }
        return booExito;
    }

    public float getfGrosor() {
        return fGrosor;
    }

    public boolean setfGrosor(float fGrosor) {
        boolean booExito = false;
        if (fGrosor >= 1 && fGrosor <= 1000) {
            this.fGrosor = fGrosor;
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "\nReproductor Portatil\n\n";
        sMensaje += "Marca: " + getsMarca();
        sMensaje += "\nModelo: " + getsModelo();
        sMensaje += "\nTipo de almacenamiento: ";
        switch (getbTipoDeAlmacenamiento()) {
            case BCD:
                sMensaje += "CD";
                break;
            case BDVD:
                sMensaje += "DVD";
                break;
            case BMEMORIAFLASH:
                sMensaje += "Memoria Flash";
                break;
            default:
                sMensaje += "Minidisk";
                break;
        }
        sMensaje += "\nReproduce sonio: ";
        if (booReproduceSonido) {
            sMensaje += "Si";
        } else {
            sMensaje += "No";
        }
        sMensaje += "\nReproduce video: ";
        if (isBooReproduceVideo()) {
            sMensaje += "Si";
        } else {
            sMensaje += "No";
        }
        sMensaje += "\nTipo de pantalla: ";
        if (booReproduceVideo) {
            switch (getbPantalla()) {
                case BTEXTO:
                    sMensaje += "Texto";
                    break;
                case BMONOCROMO:
                    sMensaje += "Monocromo";
                    break;
                default:
                    sMensaje += "Color";
                    break;
            }
        } else {
            sMensaje += "Ninguna";
        }
        if (bAutonomia >= 1 && bAutonomia <= 100) {
            sMensaje += "\nAutonomia: " + getbAutonomia();
        }
        if (iCapacidadDeAlmacenamiento >= 1 && iCapacidadDeAlmacenamiento <= 100000) {
            sMensaje += "\nCapacidad de almacenamiento: " + getiCapacidadDeAlmacenamiento();
        }
        if (fPeso >= 1 && fPeso <= 1000) {
            sMensaje += "\nPeso: " + getfPeso();
        }
        if ((fAncho >= 1 && fAncho <= 1000) || (fAlto >= 1 && fAlto <= 1000) ||(fGrosor >= 1 && fGrosor <= 1000)) {
            sMensaje += "\nMedidas";
        }
        if (fAncho >= 1 && fAncho <= 1000) {
            sMensaje += "\nAncho: " + getfAncho();
        }
        if (fAlto >= 1 && fAlto <= 1000) {
            sMensaje += "\nAlto: " + getfAlto();
        }
        if (fGrosor >= 1 && fGrosor <= 1000) {
            sMensaje += "\nGrosor: " + getfGrosor();
        }
        return sMensaje;
    }

}
