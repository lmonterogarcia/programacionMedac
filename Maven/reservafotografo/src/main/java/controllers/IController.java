package controllers;

//import controllers.personas.*;
import java.sql.*;
import java.util.*;

import controllers.personas.PersonasController;

public interface IController {
    // public final String PATH = "/Users/luis/Documents/git-repositorio/programacionMedac/ReservaFotografo"; // ### MACBOOK ###
    // public final String PATH = "/Users/luis/Documents/git-repositories/programacionMedac/ReservaFotografo"; // ### IMAC ###
    // public final String PATH = "C:/Users/Usuario/git-repositorios/programacionMedac/ReservaFotografo"; // ### Windows ###
    // public final String CONFIG_URL = PATH + "/src/config/config.txt";
    public final String CONFIG_URL = "src/main/java/config/config.txt";

    public PersonasController getoPersonasCtrl();

    public boolean init() throws Exception;

    public void closeDb();

    public Map<String, String> getPropertiesDb() throws Exception;

    public Connection connectDb() throws Exception;
}
