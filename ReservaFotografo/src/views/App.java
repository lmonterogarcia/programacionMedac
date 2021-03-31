package views;

import java.time.LocalDate;
import models.lugar.Lugar;
import models.personas.*;
import controllers.*;

public class App {
    public static void main(String[] args) throws Exception {
        Controller oCtrl = new Controller();
        Cliente oContacto = new Cliente("28845798R", "Luis", "Montero", "Garcia-Manjaron", "666655444",
                LocalDate.of(1984, 04, 16), new Usuario("lmongarman@gmial.com", "qweqwe"), null);

        System.out.println(oContacto);

        if (oCtrl.init()) {
            System.out.println("Se ha conectado");
        } else {
            System.out.println("Nabo");
        }
    }
}
