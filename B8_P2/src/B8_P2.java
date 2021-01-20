
public class B8_P2 {

	public static void main(String[] args) {
		Punto oPunto1 = new Punto();
		Punto oPunto2 = new Punto(0.5 , 2.4);

		oPunto2.borrar();
		System.out.println(oPunto2.toString());
		oPunto1.mover(0.8, 2.9);
		oPunto2.mover(oPunto1);
		System.out.println("Punto 2 despues del cambio "+oPunto2);

		oPunto1.mover(0.8, 0.4);
		System.out.println("La distancia euclidia entre el punto 1 y el punto 2 es "+oPunto1.distanciaEuclidiana(oPunto2));
		
		
		
	}

}
