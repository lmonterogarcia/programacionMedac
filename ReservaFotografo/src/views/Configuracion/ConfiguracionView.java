package views.Configuracion;

import controllers.Controller;
import views.Libreria;

public class ConfiguracionView {

    public static void gestionConfiguracion(Controller oCtrl) {
        byte bOpcion;

        do {

            bOpcion = subMenuConfiguracion();

            switch (bOpcion) {
            case 1: // Gestion de empresa
                EmpresaView.gestionEmpresa(oCtrl);
                break;
            case 2: // Gestion de participantes
                //TipoAndEstadoView.gestionTipoAndEstado(oCtrl);
                break;
            case 3: // Gestion de participantes
                //LugarView.gestionLugar(oCtrl);
                break;
            case 4: // Gestion de participantes
                //ProductoView.gestionProducto(oCtrl);
                break;
            default:
            }

        } while (bOpcion != 5);
    }

    public static byte subMenuConfiguracion() {
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Gestion de configuracion");
		System.out.println("-----------------------");
		System.out.println("1. Gestion de empresa");
        System.out.println("2. Gestion de tipo y estados de sesion");
		System.out.println("3. Gestion de direccion y lugares");
        System.out.println("4. Gestion de productos y packs");
        System.out.println("5. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
	}
}
