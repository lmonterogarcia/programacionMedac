public class ReproductorDeVideo extends ReproductorPortatil implements IReproductorVideo {

    private boolean booReproduceWMV;
    private boolean booReproduceDIVX;
    private boolean booReporduceMPG;
    private boolean booReproduceDVD;
    private boolean booReproduceJPG;
    private byte bTamnioDeLaPantalla;
    private boolean booTelevision;


    public ReproductorDeVideo(String sModelo){
        super(sModelo);
    }
    //¡¡¡¡¡¡¡¡ Para poder crear el constructor hay que llamar a un constructor
    // de la clase super. Por lo que tb hay que incluir bTipoDeAlmacenamiento en
    // en los atributos necesarios para crear un ReproductorDeVideo!!!!!!!!!!!!
    public ReproductorDeVideo(String sMarca, String sModelo,byte bTipoDeAlmacenamiento,  byte bTamnioDeLaPantalla){
        super(sMarca, sModelo, bTipoDeAlmacenamiento);
        setbTamnioDeLaPantalla(bTamnioDeLaPantalla);
        super.setBooReproduceVideo(true);

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
        String sMensaje = "\n### Reproductor de Video ###" + super.toString();
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
