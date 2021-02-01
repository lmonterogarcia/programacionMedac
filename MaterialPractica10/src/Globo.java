/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FJGIL
 */
public class Globo implements IAeronave {

    private String id;
    private int altura=0;



    public Globo(String identificacion) {
        this.id=identificacion;
        mensaje("Preparado para dar un paseo en globo");
    }


    public void calentarAire(int segundos){
        mensaje("Calentando aire durante " + segundos + " segundos");
    }

    public void expulsarAire(int segundos){
        mensaje("Expulsando aire durante " + segundos + " segundos");
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
        if(obtenerAlturaDeVuelo() < altura)
            calentarAire(altura - obtenerAlturaDeVuelo());
        else if(obtenerAlturaDeVuelo() > altura)
            expulsarAire(obtenerAlturaDeVuelo() - altura);

        this.altura = altura;
        mensaje("Altura de vuelo establecida en " + obtenerAlturaDeVuelo() +
                " pies");
    }
   
    
    public void despegar(){
        mensaje("¡Preparaos para despegar!");
        aumentarAlturaDeVuelo(150);
        mensaje("¡Ya estamos en el aire!");
    }

    public void aterrizar(){
        mensaje("Vamos a aterrizar !Agarraos!");
        variarAlturaDeVuelo(0);
        mensaje("Ya estamos en tierra firme");
    }


        
    public String obtenerIdentificacion(){
        return id;
    }

    
    public void establecerIdentificacion(String identificacion){
        mensaje("Cambio de número de vuelo a" + identificacion);
        id = identificacion;
    }



    private void mensaje(String informacion){
        System.out.println( "Globo - Vuelo " +
                obtenerIdentificacion() + ":" + informacion);
    }

}
