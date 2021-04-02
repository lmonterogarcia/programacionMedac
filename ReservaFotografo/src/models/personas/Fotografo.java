package models.personas;

import java.util.regex.Pattern;

import models.IPlantilla;

public class Fotografo implements IFotografo, IPlantilla{
    
    //PK
    private String sDniFotografo;
    //NN
    private String sNombreFotografo;
    
    // ###Contructores###

    public Fotografo(String sDniFotografo) {
        setsDniFotografo(sDniFotografo);
    }

    public Fotografo(String sDniFotografo, String sNombreFotografo) {
        setsDniFotografo(sDniFotografo);
        setsNombreFotografo(sNombreFotografo);
    }

    // ###GET and SET###

    public String getsDniFotografo() {
        return sDniFotografo;
    }

    public void setsDniFotografo(String sDniFotografo) {
        if (sDniFotografo != null && !sDniFotografo.isEmpty() && sDniFotografo.length() <= BMAXDNI && Pattern.matches(SPATRONDNI, sDniFotografo)) {
            this.sDniFotografo = sDniFotografo;
        }
    }

    public String getsNombreFotografo() {
        return sNombreFotografo;
    }

    public void setsNombreFotografo(String sNombreFotografo) {
        if (sNombreFotografo != null && !sNombreFotografo.isEmpty() && sNombreFotografo.length() <= BMAXNOMBRELARGO) {
            this.sNombreFotografo = sNombreFotografo;
        }
    }

    // ###Metodos de esta clase###
    
    public boolean checkFotografo(){
        boolean booExito = false;
        if (sDniFotografo != null && !sDniFotografo.isEmpty()) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sDniFotografo == null) ? 0 : sDniFotografo.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        Fotografo oFotografo = (Fotografo) obj;
        if (oFotografo.getsDniFotografo() != null && this.getsDniFotografo() != null && this.getsDniFotografo().equals(oFotografo.getsDniFotografo())){
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (this.checkFotografo()) {
            sMensaje += "##Fotografo##";
            sMensaje += "\n DNI: " + this.getsDniFotografo();
            sMensaje += "\n Nombre: " + this.getsNombreFotografo();
        }
        return sMensaje;
    }
}
