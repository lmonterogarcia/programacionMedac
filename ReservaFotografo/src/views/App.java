package views;

import java.sql.Connection;
import java.time.LocalDate;

import models.personas.*;
import controllers.*;

public class App {
    public static void main(String[] args) throws Exception {
        Controller oCtrl = new Controller();

        if (oCtrl.init()) {
            System.out.println("Se ha conectado");
        } else {
            System.out.println("Nabo");
        }
    }
}
