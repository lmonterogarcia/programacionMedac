
public class B8_EJ1 {

	public static void main(String[] args) {
		Producto pP = new Producto("Cola-Cao",-10.5F, 3);
		Producto pA = new Producto("Nocilla",5.5F, 10);
		Producto pB = new Producto("Jamon",0F, 0);
		Producto pC = new Producto("Pavo",2.3F, -5);
		
		if (pP.checkProducto()) {
			System.out.println("\nEl precio del producto " + pP.getsNombre() + " es de " + pP.getfPrecio() + " Euros");
			System.out.println("Hay " + pP.getiUnidades() + " en stock, valoradas es " + pP.valorEnStock() + " Euros");
		} else {
			System.out.println("\nError al crear el producto.");
		}
		
		if (pA.checkProducto()) {
			System.out.println("\nEl precio del producto " + pA.getsNombre() + " es de " + pA.getfPrecio() + " Euros");
			System.out.println("Hay " + pA.getiUnidades() + " en stock, valoradas es " + pA.valorEnStock() + " Euros");
		} else {
			System.out.println("\nError al crear el producto.");
		}
		
		if (pB.checkProducto()) {
			System.out.println("\nEl precio del producto " + pB.getsNombre() + " es de " + pB.getfPrecio() + " Euros");
			System.out.println("Hay " + pB.getiUnidades() + " en stock, valoradas es " + pB.valorEnStock() + " Euros");
		} else {
			System.out.println("\nError al crear el producto.");
		}
		
		if (pC.checkProducto()) {
			System.out.println("\nEl precio del producto " + pC.getsNombre() + " es de " + pC.getfPrecio() + " Euros");
			System.out.println("Hay " + pC.getiUnidades() + " en stock, valoradas es " + pC.valorEnStock() + " Euros");
		} else {
			System.out.println("\nError al crear el producto.");
		}
	}

}
