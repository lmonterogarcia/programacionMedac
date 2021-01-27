
public class B9_P1 {

	public static void main(String[] args) {
		Reloj oReloj1 = new Reloj();
		Reloj oReloj2 = new Reloj((byte) 13, (byte) 33, (byte) 25);
		
		System.out.println(oReloj1);
		System.out.println(oReloj1.imrpimirRelojVersion12());
		System.out.println(oReloj2);
		System.out.println(oReloj2.imrpimirRelojVersion12());
		
		if (oReloj1.ponerEnHora((byte) 85, (byte) 12)) {
			System.out.println("\n" + oReloj1);
			System.out.println(oReloj1.imrpimirRelojVersion12());
		} else {
			System.out.println("\nNo se ha podido cambiar la hora");
		}
		
		if (oReloj1.ponerEnHora((byte) 23, (byte) 12, (byte) 0)) {
			System.out.println("\n" + oReloj1);
			System.out.println(oReloj1.imrpimirRelojVersion12());
		} else {
			System.out.println("\nNo se ha podido cambiar la hora");
		}
		
		if (oReloj1.ponerEnHora((byte) 12, (byte) 12, (byte) 12, false)) {
			System.out.println("\n" + oReloj1);
			System.out.println(oReloj1.imrpimirRelojVersion12());
		} else {
			System.out.println("\nNo se ha podido cambiar la hora");
		}

		
		

	}

}
