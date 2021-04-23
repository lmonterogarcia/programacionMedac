package controllers;

import java.sql.*;
import java.util.*;
import java.io.*;

import controllers.configuracion.ConfiguracionCtrl;
import controllers.personas.PersonasController;
import models.personas.*;

public class Controller implements IController{
    private Connection oConnection;
	private PersonasController oPersonasCtrl;
	private ConfiguracionCtrl oConfiguracionCtrl;
	
	public Controller() {
		oPersonasCtrl = new PersonasController();
		oConfiguracionCtrl = new ConfiguracionCtrl();
	}

	public Connection getConnection() {
		return oConnection;
	}

	public PersonasController getoPersonasCtrl() {
		return oPersonasCtrl;
	}

	public ConfiguracionCtrl getConfiguracionCtrl(){
		return oConfiguracionCtrl;
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



	// ###### Cliente y Usuario ######
	public boolean addCliente(Cliente oCliente) {
		return oPersonasCtrl.addCliente(oCliente, oConnection);
	}

	public boolean removeCliente(Cliente oCliente) {
		return oPersonasCtrl.removeCliente(oCliente, oConnection);
	}

	public boolean updateCliente(Cliente oCliente) {
		boolean booExito = false;
		if (oPersonasCtrl.getoClientCtrl().update(oCliente, oConnection)) {
			if (oPersonasCtrl.getoUserCtrl().update(oCliente.getoUsuario(), oConnection)) {
				booExito = true;
			}
		}
		return booExito;
	}

	public Cliente searchCliente(Cliente oCliente) {
		return oPersonasCtrl.searchCliente(oCliente, oConnection);
	}
	public Usuario searchUsuario(Cliente oCliente) {
		return oPersonasCtrl.searchUsuario(oCliente, oConnection);
	}



	// ###### Fotografo ######
	public boolean addFotografo(Fotografo oFotografo) {
		return oPersonasCtrl.addFotografo(oFotografo, oConnection);
	}

	public boolean removeFotografo(Fotografo oFotografo) {
		return oPersonasCtrl.removeFotografo(oFotografo, oConnection);
	}

	public boolean updateFotografo(Fotografo oFotografo) {
		return oPersonasCtrl.getoFotografoCtrl().update(oFotografo, oConnection);
	}

	public Fotografo searchFotografo(Fotografo oFotografo) {
		return oPersonasCtrl.searchFotografo(oFotografo, oConnection);
	}



	// ###### Participante ######
	public boolean addParticipante(Participante oParticipante) {
		return oPersonasCtrl.addParticipante(oParticipante, oConnection);
	}

	public boolean removeParticipante(Participante oParticipante) {
		return oPersonasCtrl.removeParticipante(oParticipante, oConnection);
	}

	public boolean updateParticipante(Participante oParticipante) {
		return oPersonasCtrl.getoParticipanteCtrl().update(oParticipante, oConnection);
	}

	public Participante searchParticipante(Participante oParticipante) {
		return oPersonasCtrl.searchParticipante(oParticipante, oConnection);
	}



	// ###### Empresa ######
	public boolean addEmpresa(Empresa oEmpresa) {
		return oConfiguracionCtrl.getoEmpresaCtrl().add(oEmpresa, oConnection);
	}

	public boolean removeEmpresa(Empresa oEmpresa) {
		return oConfiguracionCtrl.getoEmpresaCtrl().remove(oEmpresa, oConnection);
	}

	public boolean updateEmpresa(Empresa oEmpresa) {
		return oConfiguracionCtrl.getoEmpresaCtrl().update(oEmpresa, oConnection);
	}

	public Empresa searchEmpresa(Empresa oEmpresa) {
		return oConfiguracionCtrl.searchEmpresa(oEmpresa, oConnection);
		//Cuando se implemente LUGAR HAY QUE CAMCBIAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}

 

}
