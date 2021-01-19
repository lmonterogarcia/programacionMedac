
public class B8_EJ2 {

	public static void main(String[] args) {
		Asignatura aA = new Asignatura((byte)1, "Programacion", "1ºDAM");
		Asignatura aB = new Asignatura((byte)2, "En", "1ºDAM");
		Asignatura aC = new Asignatura((byte)0, "Programacion", "1");
		Asignatura aD = new Asignatura((byte)-6, "Base de Datos", "1ºDAM");
		
		System.out.println(aA.toString());
		System.out.println(aB.toString());
		System.out.println(aC.toString());
		System.out.println(aD.toString());	
		
	}

}
