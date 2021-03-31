package controllers;

//import controllers.personas.*;
import java.sql.*;
import java.util.*;

public interface IController {
    // public final String PATH = "/home/dam/vscode-workspace/TIENDA_DAMDB";
    public final String PATH = "/Users/luis/Documents/git-repositorio/programacionMedac/ReservaFotografo"; // ### MAC ###
    // public final String PATH = "C:/Users/Usuario/git-repositorios/programacionMedac/ReservaFotografo"; // ### Windows ###
    public final String CONFIG_URL = PATH + "/src/config/config.txt";

    // public PersonasController getoPersonasCtrl();

    public Connection getConnection();

    public boolean init() throws Exception;

    public void closeDb();

    public Map<String, String> getPropertiesDb() throws Exception;

    public Connection connectDb() throws Exception;
}
