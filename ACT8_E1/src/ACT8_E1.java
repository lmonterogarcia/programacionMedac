
public class ACT8_E1 {

	public static void main(String[] args) {
		Producto p = new Producto("Cola-Cao",-10.5F, 3);
		System.out.println("El precio del producto " + p.getsNombre() + " es de " + p.getfPrecio() + " Euros");
		System.out.println("Hay " + p.getiUnidades() + " en stock, valoradas es " + p.valorEnStock() + " Euros");
	}

}
