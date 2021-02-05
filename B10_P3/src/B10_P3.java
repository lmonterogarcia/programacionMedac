import java.util.Calendar;

public class B10_P3 {

	public static void main(String[] args) {
		IPublicacion oPublicacion;
		Libro oLibro = new Libro(100478, "Perez Reverte", "Las mil guerras", (short)2000);
		Revista oRevista = new Revista(200498, "Planeta", "Lonely Planet Traveller", (short)2011);
		Disco oDisco = new Disco(300498, "Red Hot Chilly Peppers", "Californication", (short)1995);
		
		oPublicacion = oLibro;
		System.out.println(oPublicacion);
		oPublicacion.setShAnnoPublicacion((short)3254); //No debe cambiar
		oPublicacion.setsTitulo("La reina del sur");
		oPublicacion.setBooPrestado(true);
		System.out.println(oPublicacion);
		
		oPublicacion = oRevista;
		System.out.println(oPublicacion);
		oPublicacion.setShAnnoPublicacion((short)2012); 
		oPublicacion.setiCodigo(354789);//No debe cambiar
		oPublicacion.setBooPrestado(true);
		System.out.println(oPublicacion);
		
		oPublicacion = oDisco;
		System.out.println(oPublicacion);
		oPublicacion.setsAutor(""); //No debe cambiar
		oPublicacion.setsTitulo("Blood Sugar Sex Magik");
		oPublicacion.setBooPrestado(true);
		System.out.println(oPublicacion);

	
	
	}

}
