package models.personas;

public interface IFotografo {
    
    public String getsDniFotografo();
    public void setsDniFotografo(String sDniFotografo);
    public String getsNombreFotografo();
    public void setsNombreFotografo(String sNombreFotografo);

    public boolean checkFotografo();
    public int hashCode();
    public boolean equals(Object obj);
    public String toString();
}
