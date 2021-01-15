package views;
import models.*;
import controllers.*;
public class TIENDA_DAM {

	public static void main(String[] args) {
		UsuarioController oUserCtrl = new UsuarioController();
		
		if(oUserCtrl.addUsuario(new Usuario("kkkkk@mmm.com","12"))) {
			System.out.println("El usuario ha sido insertado en la base de datos.");
		}else {
			System.out.println("El usuario no se ha podido insertar.");
		}
		
		if(oUserCtrl.addUsuario(new Usuario("qweqweqwe","123123213"))) {
			System.out.println("El usuario ha sido insertado en la base de datos.");
		}else {
			System.out.println("El usuario no se ha podido insertar.");
		}
		
		if(oUserCtrl.addUsuario(new Usuario("aurelio.lopez@medac.es","123456"))) {
			System.out.println("El usuario ha sido insertado en la base de datos.");
		}else {
			System.out.println("El usuario no se ha podido insertar.");
		}
		
		System.out.println(oUserCtrl.getlUsuarios().size());
		
		//cargaDatos();
		
		
	}
	
	/*public static void cargaDatos() {
	
		Cliente oCliente1 = new Cliente("123123A");
		Cliente oCliente2 = new Cliente("12345678K","Aurelio","Lopez","Calle Falsa","Bloque Falso, 123", "666333111",oUsuario3);
		Cliente oCliente3 = new Cliente("12312221L","Pepe","kkkk","calle falsa","123","kkkk",oUsuario1);		
	}*/
}
