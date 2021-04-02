package views;

import java.time.LocalDate;
import models.lugar.Lugar;
import models.personas.*;
import controllers.*;

public class App {
    public static void main(String[] args) throws Exception {
        Controller oCtrl = new Controller();
        Empresa oEmpresa = new Empresa("28845798R", "Medac, S.A.", "info@medac.es", "945511763", null);

        System.out.println(oEmpresa);

        if (oCtrl.init()) {
            System.out.println("Se ha conectado");
        } else {
            System.out.println("Nabo");
        }
    }
}
