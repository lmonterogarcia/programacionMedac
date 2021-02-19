public class Simulacro_EJ2 {
    public static void main(String[] args) {
        Cliente oCliente = new Cliente("28818261C");
        CuentaBancaria oCuenta = new CuentaBancaria("1458745896325874");

        actualizarDatosCliente(oCliente, "Luis", "Montero", 658745897, (byte) 0);
        actualizarDatosCuenta(oCuenta, "ING Direct", "25020.25", oCliente);
        
        System.out.println(oCliente);
        System.out.println(oCuenta);

    

    }

    private static String actualizarDatosCliente( Cliente oCliente, String sNombre, String sApellido, int iTelefono, byte bTipo){
        String sMensaje = "";
        if (oCliente.setsNombre(sNombre) && oCliente.setsApellidos(sApellido) && oCliente.setiTelefono(iTelefono) && oCliente.setbTipo(bTipo)) {
            sMensaje = "Se han actualizado todos los datos del cliente";
        } else {
            sMensaje = "No se han actualizado todos los datos del cliente";
        }
       ;
        return sMensaje;
    }
    private static String actualizarDatosCuenta(CuentaBancaria oCuenta, String sBanco, String sSaldo, Cliente oCliente){
        String sMensaje = "";
        if (oCuenta.setsBanco(sBanco) && oCuenta.setfSaldo(sSaldo) && oCuenta.setoCliente(oCliente)){
            sMensaje = "Se han actualizado todos los datos de la cuenta";
        } else {
            sMensaje = "No se han actualizado todos los datos de la cuenta";
        }
        return sMensaje;
    }
}
