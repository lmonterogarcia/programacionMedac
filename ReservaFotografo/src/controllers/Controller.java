package controllers;

import java.sql.*;
import java.util.*;
import java.io.*;

import controllers.personas.PersonasController;
import models.personas.Cliente;

public class Controller implements IController{
    private Connection oConnection;
	private PersonasController oPersonasCtrl;
	
	public Controller() {
		oPersonasCtrl = new PersonasController();
	}

	public PersonasController getoPersonasCtrl() {
		return oPersonasCtrl;
	}

	public Connection getConnection() {
		return oConnection;
	}

    /*
	 * # DB METHODS
	 */
	public boolean init() throws Exception {
		boolean bExito = false;
		oConnection = connectDb();
		if (oConnection != null) {
			bExito = true;
		}
		return bExito;
	}

	public void closeDb() {
		if (oConnection != null) {
			try {
				oConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Map<String, String> getPropertiesDb() throws Exception {

		Map<String, String> mapProperties = new HashMap<String, String>();

		// Database credentials
		File file = new File(CONFIG_URL);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String linea;
		while ((linea = br.readLine()) != null) {
			linea = linea.replaceAll(" ", "");
			String sParam = linea.substring(0, linea.indexOf(":"));
			String sValue = linea.substring(linea.indexOf(":") + 1, linea.length());
			mapProperties.put(sParam, sValue);
		}
		br.close();
		return mapProperties;
	}

	public Connection connectDb() throws Exception {

		Map<String, String> mapProperties = getPropertiesDb();

		Connection conn = null;
		String sURL = "jdbc:mysql://" + mapProperties.get("SERVER") + ":" + mapProperties.get("PORT") + "/"
				+ mapProperties.get("DB");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(sURL, mapProperties.get("USER"), mapProperties.get("PASSWORD"));
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	public boolean addCliente(Cliente oCliente) {
		return oPersonasCtrl.addCliente(oCliente, oConnection);
	}

	public boolean removeCliente(Cliente oCliente) {
		return oPersonasCtrl.removeCliente(oCliente, oConnection);
	}

	public boolean updateCliente(Cliente oCliente) {
		return oPersonasCtrl.getoClientCtrl().update(oCliente, oConnection);
	}

	public Cliente searchCliente(Cliente oCliente) {
		return oPersonasCtrl.searchCliente(oCliente, oConnection);
	}

}
