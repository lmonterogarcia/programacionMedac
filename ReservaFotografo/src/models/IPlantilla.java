package models;

public interface IPlantilla {

    // ### MAXIMOS ###
    public final int IMAXIDS = 999999;
    public final byte BMAXID = 6;
    public final byte BMAXDNI = 9;
    public final byte BMAXNOMBRE = 20;
    public final byte BMAXNOMBRELARGO = 50;
    public final byte BMAXAPELLIDOS = 30;
    public final byte BMAXTELEFONO = 9;
    public final byte BMAXEMAIL = 100;
    public final byte BMINPASSW = 5;
    public final byte BMAXPASSW = 15;
    public final byte BMAXCODIGOPOSTAL = 20;
    public final byte BMAXCODIGOINT = 3;
    public final byte BMAXNOMBRELUGAR = 100;
    public final byte BMAXNUMEROLUGAR = 10;
    public final byte BMAXSIGLASPAIS = 2;
    public final int IMAXLATITUD = 100;
    public final int IMINLATITUD = -100;
    public final byte BMAXDECIMALLAT = 7;
    public final int IMAXLONGITUD = 100;
    public final int IMINLONGITUD = -100;
    public final byte BMAXDECIMALLONG = 7;
    public final short SHMAXDURACION = 999;
    public final int IMAXPRECIO = 100000;
    public final byte BMAXPRECIODECIMAL = 2;
    public final byte BMAXORDEN = 30;
    public final short BMAX255 = 255;

    // ### PATRONES ###
    public final String SPATRONDNI = "\\d{8}[A-za-z]";
    public final String SPATRONTELEFONO = "(6|7|8|9){1}\\d{8}";
    public final String SPATRONEMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";
    public final String SPATRONIDTOSTRING = "%06d";
    public final String SPATRONWEB = "(http:|https:)?\\/\\/(www\\.)?(maps.)?google\\.[a-z.]+\\/maps/?([\\?]|place/*[^@]*)?/*@?(ll=)?(q=)?(([\\?=]?[a-zA-Z]*[+]?)*/?@{0,1})?([0-9]{1,3}\\.[0-9]+(,|&[a-zA-Z]+=)-?[0-9]{1,3}\\.[0-9]+(,?[0-9]+(z|m))?)?(\\/?data=[\\!:\\.\\-0123456789abcdefmsx]+)?";

    // ### LETRAS PARA LOS IDS ###
    public final String SLETRACLIENTE = "C";
    public final String SLETRAPARTICIPANTE = "P";
    public final String SLETRASESION = "S";
    public final String SLETRALUGAR = "L";
    public final String SLETRAPEDIDO = "O";
    public final String SLETRAPRODUCTO = "P";
    public final String SLETRAPACK = "X";

    //PK

    //NN

    //N
    
    // ###Contructores###

    // ###GET and SET###

    // ###Metodos de esta clase###

}
