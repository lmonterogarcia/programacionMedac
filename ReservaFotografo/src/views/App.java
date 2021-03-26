package views;

import java.sql.Connection;
import java.time.LocalDate;

import models.personas.*;
import controllers.*;

public class App {
    public static void main(String[] args) throws Exception {
        Controller oCtrl = new Controller();
        LocalDate oFecha = LocalDate.of(1984, 04, 16);
        Contacto oContacto = new Contacto("288457985","Luis","Montero","Garcia-Manjaron","166655444",oFecha);

        System.out.println(oContacto);

        if (oCtrl.init()) {
            System.out.println("Se ha conectado");
        } else {
            System.out.println("Nabo");
        }
    }
}
