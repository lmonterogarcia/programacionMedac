public class Airbus340 implements IAeronave,IAvion{

    private String id;
    private int altura=0;
    private boolean trenAbierto = true;
    private int pasajeros;
	private byte bEstado;
    
    public Airbus340(String identificacion,int pasajeros) {
        this.id=identificacion;
        this.pasajeros = pasajeros;
        mensaje("Preparado para recibir plan de vuelo");        
    }

    
    public void aumentarAlturaDeVuelo(int aumento){
        mensaje("Incrementando altura de vuelo en " + aumento + " pies");
        variarAlturaDeVuelo(obtenerAlturaDeVuelo()+aumento);
    }

    
    public void disminuirAlturaDeVuelo(int descenso){
        mensaje("Disminuyendo la altura de vuelo en " + descenso + " pies");
        variarAlturaDeVuelo(obtenerAlturaDeVuelo()-descenso);
    }

    
    public int obtenerAlturaDeVuelo(){
        return altura;
    }

    
    public void variarAlturaDeVuelo(int altura){
        this.altura = altura;
        mensaje("Altura de vuelo establecida en " + obtenerAlturaDeVuelo() +
                " pies");
    }
    
       
    
    public void despegar(){
        mensaje("Procediendo a realizar la maniobra de despegue");
        aumentarAlturaDeVuelo(150);
        cerrarTrenDeAterrizaje();
        aumentarAlturaDeVuelo(1000);
        mensaje("Maniobra de despegue concluida");
        this.bEstado = 1;
        consultarEstado();
    }
    
    
    public void aterrizar(){
        mensaje("Procediendo a realizar la maniobra de aterrizaje");
        variarAlturaDeVuelo(200);
        abrirTrenDeAterrizaje();
        disminuirAlturaDeVuelo(200);
        mensaje("Maniobra de aterrizaje concluida");   
        this.bEstado = 2;
        consultarEstado();
    }

    
    public String obtenerIdentificacion(){
        return id;
    }

    
    public void establecerIdentificacion(String identificacion){
        mensaje("Cambio de número de vuelo a" + identificacion);
        id = identificacion;
    }


    private void mensaje(String informacion){
        System.out.println( "Airbus340 - Vuelo " +
                obtenerIdentificacion() + ":" + informacion);
    }

    
    public void abrirTrenDeAterrizaje(){
        trenAbierto = true;
        mensaje("Tren de aterrizaje abierto");
    }

    
    public void cerrarTrenDeAterrizaje(){
        trenAbierto = false;
        mensaje("Tren de aterrizaje cerrado");
    }

    
    public int capacidad(){
        return 295;
    }
    public int obtenerPlazasOcupadas(){
        return pasajeros;
    }

	public String consultarEstado() {
		String sEstado;
		if (this.bEstado == 1 ) {
			mensaje("Estamos en el aire!");
			sEstado = IAeronave.SVOLANDO;
		} else {
			mensaje("Estamos en tierra!");
			sEstado = IAeronave.SENTIERRA;
		}
		return sEstado;
	}
    
    
    
    
    
}
