package views;

import java.time.LocalDate;

import models.personas.*;

public class App {
    public static void main(String[] args) throws Exception {
        Contacto oContacto = new Contacto("Javier");
        LocalDate oFecha = LocalDate.of(2010, 04, 16);
        Contacto oContacto2 = new Contacto("Jesus", "28818263G", "Montero",
        "Lopez", "647583947", oFecha);
        System.out.println(oContacto);
        System.out.println(oContacto2);
    }
}
