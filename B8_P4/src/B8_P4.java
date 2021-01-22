
public class B8_P4 {

	public static void main(String[] args) {
		MaquinaExpendedora oMaquina1 = new MaquinaExpendedora((short) 11245);

		oMaquina1.insertarMoneda(2f);
		oMaquina1.insertarMoneda(1f);
		oMaquina1.insertarMoneda(2f);
		oMaquina1.insertarMoneda(0.5f);
		oMaquina1.insertarMoneda(2f);
		
		System.out.println(oMaquina1);
		
		oMaquina1.pedirProducto(1.2f);
		
		System.out.println("\n" + oMaquina1);
		
		System.out.println(oMaquina1.pedirDevolucion());
		
		System.out.println("\n" + oMaquina1);
		
		oMaquina1.insertarMoneda(2f);
		oMaquina1.insertarMoneda(2f);
		oMaquina1.insertarMoneda(2f);
		oMaquina1.insertarMoneda(2f);
		oMaquina1.insertarMoneda(2f);
		
		System.out.println("\n" + oMaquina1);
		
		System.out.println(oMaquina1.pedirDevolucion());
		
		System.out.println("\n" + oMaquina1);
		
		
	}

}
