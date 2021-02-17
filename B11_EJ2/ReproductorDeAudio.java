public class ReproductorDeAudio extends ReproductorPortatil implements IReproductorAudio {

    private boolean booReproduceAudioCDs;
    private boolean booReproduceMP3;
    private boolean booReporduceWMA;
    private boolean booReproduceVorbis;
    private boolean booAcesoPorCarpetas;
    private boolean booRadio;
    private boolean booGrabacionDeVoz;


    public ReproductorDeAudio(String sModelo){
        super(sModelo);
    }

    public ReproductorDeAudio(String sMarca, String sModelo, byte bTipoDeAlmacenamiento, boolean booReproduceAudioCDs, boolean booReproduceMP3, boolean booReporduceWMA, boolean booReproduceVorbis){
        super(sModelo);
        super.setsMarca(sMarca);
        setbTipoDeAlmacenamiento(bTipoDeAlmacenamiento);
        setbooReproduceAudioCDs(booReproduceAudioCDs);
        setbooReproduceMP3(booReproduceMP3);
        setbooReporduceWMA(booReporduceWMA);
        setbooReproduceVorbis(booReproduceVorbis);
    }
    
    public boolean setbTipoDeAlmacenamiento(byte bTipoDeAlmacenamiento){
        boolean booExito = super.setbTipoDeAlmacenamiento(bTipoDeAlmacenamiento);
        if (super.getbTipoDeAlmacenamiento() != BCD) {
            this.booReproduceAudioCDs = false;
        }
        return booExito;
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
    
    public String toString(){
        String sMensaje ="\n### Reproductor de Audio ###" + super.toString();
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
        
        return sMensaje;
    }
}
