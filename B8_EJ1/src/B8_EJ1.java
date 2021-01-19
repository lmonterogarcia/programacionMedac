
public class B8_EJ1 {

	public static void main(String[] args) {
		Producto oP = new Producto("Cola-Cao",-10.5F, 3);
		Producto oA = new Producto("Nocilla",5.5F, 10);
		Producto oB = new Producto("Jamon",0F, 0);
		Producto oC = new Producto("Pavo",2.3F, -5);
		
		if (oP.checkProducto()) {
			System.out.println("\nEl precio del producto " + oP.getsNombre() + " es de " + oP.getfPrecio() + " Euros");
			System.out.println("Hay " + oP.getiUnidades() + " en stock, valoradas es " + oP.valorEnStock() + " Euros");
		} else {
			System.out.println("\nError al crear el producto.");
		}
		
		if (oA.checkProducto()) {
			System.out.println("\nEl precio del producto " + oA.getsNombre() + " es de " + oA.getfPrecio() + " Euros");
			System.out.println("Hay " + oA.getiUnidades() + " en stock, valoradas es " + oA.valorEnStock() + " Euros");
		} else {
			System.out.println("\nError al crear el producto.");
		}
		
		if (oB.checkProducto()) {
			System.out.println("\nEl precio del producto " + oB.getsNombre() + " es de " + oB.getfPrecio() + " Euros");
			System.out.println("Hay " + oB.getiUnidades() + " en stock, valoradas es " + oB.valorEnStock() + " Euros");
		} else {
			System.out.println("\nError al crear el producto.");
		}
		
		if (oC.checkProducto()) {
			System.out.println("\nEl precio del producto " + oC.getsNombre() + " es de " + oC.getfPrecio() + " Euros");
			System.out.println("Hay " + oC.getiUnidades() + " en stock, valoradas es " + oC.valorEnStock() + " Euros");
		} else {
			System.out.println("\nError al crear el producto.");
		}
	}

}
