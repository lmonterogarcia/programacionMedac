package controllers;

import models.Cliente;
import controllers.personas.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public interface IController {
    // public final String PATH = "/home/dam/vscode-workspace/TIENDA_DAMDB";
    // public final String CONFIG_URL = PATH + "src/config/config.txt";
    public final String CONFIG_URL = "src/config/config.txt";

    public PersonasController getoPersonasCtrl();

    public Connection getConnection();

    public boolean init() throws Exception;

    public void closeDb();

    public Map<String, String> getPropertiesDb() throws Exception;

    public Connection connectDb() throws Exception;

}
