public class ReproductorMultimedia extends ReproductorPortatil implements IReproductorAudio, IReproductorVideo {
    private boolean booReproduceAudioCDs;
    private boolean booReproduceMP3;
    private boolean booReporduceWMA;
    private boolean booReproduceVorbis;
    private boolean booAcesoPorCarpetas;
    private boolean booRadio;
    private boolean booGrabacionDeVoz;
    
    private boolean booReproduceWMV;
    private boolean booReproduceDIVX;
    private boolean booReporduceMPG;
    private boolean booReproduceDVD;
    private boolean booReproduceJPG;
    private byte bTamnioDeLaPantalla;
    private boolean booTelevision;

    public ReproductorMultimedia(String sModelo){
        super(sModelo);
    }
    
    public ReproductorMultimedia(String sMarca, String sModelo,byte bTipoDeAlmacenamiento, boolean booReproduceAudioCDs, boolean booReproduceMP3, boolean booReporduceWMA, boolean booReproduceVorbis, byte bTamnioDeLaPantalla){
        super(sMarca, sModelo, bTipoDeAlmacenamiento);
        setbooReproduceAudioCDs(booReproduceAudioCDs);
        setbooReproduceMP3(booReproduceMP3);
        setbooReporduceWMA(booReporduceWMA);
        setbooReproduceVorbis(booReproduceVorbis);
        setbTamnioDeLaPantalla(bTamnioDeLaPantalla);
        super.setBooReproduceVideo(true);

    }

    public boolean isbooAcesoPorCarpetas() {
        return this.booAcesoPorCarpetas;
    }

    
    public boolean isbooGrabacionDeVoz() {
        return this.booGrabacionDeVoz;
    }

    
    public boolean isbooRadio() {        
        return this.booRadio;
    }

    
    public boolean isbooReporduceWMA() {        
        return this.booReporduceWMA;
    }

    
    public boolean isbooReproduceAudioCDs() {        
        return this.booReproduceAudioCDs;
    }

    
    public boolean isbooReproduceMP3() {        
        return this.booReproduceMP3;
    }

    
    public boolean isbooReproduceVorbis() {        
        return this.booReproduceVorbis;
    }

    
    public boolean setbooAcesoPorCarpetas(boolean booAcesoPorCarpetas) {
        boolean booExito = false;
        if (booAcesoPorCarpetas != this.booAcesoPorCarpetas) {
            this.booAcesoPorCarpetas = booAcesoPorCarpetas;
            booExito = true;
        }
        return booExito;
    }

    
    public boolean setbooGrabacionDeVoz(boolean booGrabacionDeVoz) {
        boolean booExito = false;
        if (booGrabacionDeVoz != this.booGrabacionDeVoz) {
            this.booGrabacionDeVoz = booGrabacionDeVoz;
            booExito = true;
        }
        return booExito;
    }

    
    public boolean setbooRadio(boolean booRadio) {
        boolean booExito = false;
        if (booRadio != this.booRadio) {
            this.booRadio = booRadio;
            booExito = true;
        }
        return booExito;
    }

    
    public boolean setbooReporduceWMA(boolean booReporduceWMA) {
        boolean booExito = false;
        if (booReporduceWMA != this.booReporduceWMA) {
            this.booReporduceWMA = booReporduceWMA;
            booExito = true;
        }
        return booExito;
    }

    
    public boolean setbooReproduceAudioCDs(boolean booReproduceAudioCDs) {
        boolean booExito = false;
        if ( super.getbTipoDeAlmacenamiento() == BCD && booReproduceAudioCDs != this.booReproduceAudioCDs) {
            this.booReproduceAudioCDs = booReproduceAudioCDs;
            booExito = true;
        }
        return booExito;
    }

    
    public boolean setbooReproduceMP3(boolean booReproduceMP3) {
        boolean booExito = false;
        if (booReproduceMP3 != this.booReproduceMP3) {
            this.booReproduceMP3 = booReproduceMP3;
            booExito = true;
        }
        return booExito;
    }

    
    public boolean setbooReproduceVorbis(boolean booReproduceVorbis) {
        boolean booExito = false;
        if (booReproduceVorbis != this.booReproduceVorbis) {
            this.booReproduceVorbis = booReproduceVorbis;
            booExito = true;
        }
        return booExito;
    }
    
    public boolean isbooReproduceJPG() {
        return this.booReproduceJPG;
    }

    
    public boolean isbooTelevision() {
        return this.booTelevision;
    }

    
    public byte getbTamnioDeLaPantalla() {        
        return this.bTamnioDeLaPantalla;
    }

    
    public boolean isbooReporduceMPG() {        
        return this.booReporduceMPG;
    }

    
    public boolean isbooReproduceWMV() {        
        return this.booReproduceWMV;
    }

    
    public boolean isbooReproduceDIVX() {        
        return this.booReproduceDIVX;
    }

    
    public boolean isbooReproduceDVD() {        
        return this.booReproduceDVD;
    }

    
    public boolean setbooReproduceJPG(boolean booReproduceJPG) {
        boolean booExito = false;
        if (isBooReproduceVideo() && booReproduceJPG != this.booReproduceJPG) {
            this.booReproduceJPG = booReproduceJPG;
            booExito = true;
        }
        return booExito;
    }

    
    public boolean setbooTelevision(boolean booTelevision) {
        boolean booExito = false;
        if (isBooReproduceVideo() && booTelevision != this.booTelevision) {
            this.booTelevision = booTelevision;
            booExito = true;
        }
        return booExito;
    }

    
    public boolean setbTamnioDeLaPantalla(byte bTamnioDeLaPantalla) {
        boolean booExito = false;
        if (isBooReproduceVideo() && bTamnioDeLaPantalla > 0 && bTamnioDeLaPantalla < 120) {
            this.bTamnioDeLaPantalla = bTamnioDeLaPantalla;
            booExito = true;
        }
        return booExito;
    }

    
    public boolean setbooReporduceMPG(boolean booReporduceMPG) {
        boolean booExito = false;
        if (isBooReproduceVideo() && booReporduceMPG != this.booReporduceMPG) {
            this.booReporduceMPG = booReporduceMPG;
            booExito = true;
        }
        return booExito;
    }

    
    public boolean setbooReproduceWMV(boolean booReproduceWMV) {
        boolean booExito = false;
        if (isBooReproduceVideo() && booReproduceWMV != this.booReproduceWMV) {
            this.booReproduceWMV = booReproduceWMV;
            booExito = true;
        }
        return booExito;
    }

    
    public boolean setbooReproduceDIVX(boolean booReproduceDIVX) {
        boolean booExito = false;
        if (isBooReproduceVideo() && booReproduceDIVX != this.booReproduceDIVX) {
            this.booReproduceDIVX = booReproduceDIVX;
            booExito = true;
        }
        return booExito;
    }

    
    public boolean setbooReproduceDVD(boolean booReproduceDVD) {
        boolean booExito = false;
        if (isBooReproduceVideo() && booReproduceDVD != this.booReproduceDVD) {
            this.booReproduceDVD = booReproduceDVD;
            booExito = true;
        }
        return booExito;
    }

    public String toString(){
        String sMensaje = super.toString();
        if (isbooReproduceAudioCDs() || isbooReproduceMP3() || isbooReporduceWMA() || isbooReproduceVorbis() || isbooAcesoPorCarpetas() || isbooRadio() || isbooGrabacionDeVoz()) {
            sMensaje += "\n\nCARACTERISTICAS de audio";
            if (isbooReproduceAudioCDs()) {
                sMensaje += "\nReproduce CDs";
            }
            if (isbooReproduceMP3()) {
                sMensaje += "\nReproduce MP3";
            }
            if (isbooReporduceWMA()) {
                sMensaje += "\nReproduce WMA";
            }
            if (isbooReproduceVorbis()) {
                sMensaje += "\nReproduce Vorbis";
            }
            if (isbooAcesoPorCarpetas()) {
                sMensaje += "\nAccede por carpetas";
            }
            if (isbooRadio()) {
                sMensaje += "\nTiene radio";
            }
            if (isbooGrabacionDeVoz()) {
                sMensaje += "\nGraba voz";
            }
        }
        if (isbooReproduceWMV() || isbooReproduceDIVX() || isbooReporduceMPG() || isbooReproduceDVD() || isbooReproduceJPG() || getbTamnioDeLaPantalla() > 0 || isbooTelevision()) {
            sMensaje += "\n\nCARACTERISTICAS de video";
            if (isbooReproduceWMV()) {
                sMensaje += "\nReproduce WMV";
            }
            if (isbooReproduceDIVX()) {
                sMensaje += "\nReproduce DIVX";
            }
            if (isbooReporduceMPG()) {
                sMensaje += "\nReproduce MPG";
            }
            if (isbooReproduceDVD()) {
                sMensaje += "\nReproduce DVD";
            }
            if (isbooReproduceJPG()) {
                sMensaje += "\nReproduce JPG";
            }
            if (getbTamnioDeLaPantalla() > 0) {
                sMensaje += "\nTamaño de la pantalla: " + bTamnioDeLaPantalla  + " pulgadas";
            }
            if (isbooTelevision()) {
                sMensaje += "\nSintoniza emisoras de TV";
            }
        }
        
        return sMensaje;
    }
}
