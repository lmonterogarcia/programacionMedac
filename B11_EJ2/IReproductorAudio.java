public interface IReproductorAudio extends IReproductorPortatil {
    
    public boolean isbooReproduceAudioCDs();
    public boolean setbooReproduceAudioCDs(boolean booReproduceAudioCDs);

    public boolean isbooReproduceMP3();
    public boolean setbooReproduceMP3(boolean booReproduceMP3);

    public boolean isbooReporduceWMA();
    public boolean setbooReporduceWMA(boolean booReporduceWMA);

    public boolean isbooReproduceVorbis();
    public boolean setbooReproduceVorbis(boolean booReproduceVorbis);

    public boolean isbooAcesoPorCarpetas();
    public boolean setbooAcesoPorCarpetas(boolean booAcesoPorCarpetas);

    public boolean isbooRadio();
    public boolean setbooRadio(boolean booRadio);

    public boolean isbooGrabacionDeVoz();
    public boolean setbooGrabacionDeVoz(boolean booGrabacionDeVoz);
}
