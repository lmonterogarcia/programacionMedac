package models.personas;

public interface IParticipante {
    
    public String getsEmailParticipante();
    public void setsEmailParticipante(String sEmailParticipante);

    public boolean checkCliente();
	public boolean equals(Object obj);
    public String toString();
}
