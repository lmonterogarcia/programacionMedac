package controllers;

import java.sql.*;
import java.util.*;
import java.io.*;

import controllers.configuracion.ConfiguracionController;
import controllers.personas.*;
import controllers.sesiones.SesionesController;
import models.personas.*;
import models.sesion.*;
import models.lugar.Lugar;

public class Controller implements IController {
	private static Connection oConnection;
	private PersonasController oPersonasCtrl;
	private FotografoController oFotografoCtrl;
	private ParticipanteController oParticipanteCtrl;
	private ConfiguracionController oConfiguracionCtrl;
	private SesionesController oSesionesCtrl;

	public Controller() {
		oPersonasCtrl = new PersonasController();
		oConfiguracionCtrl = new ConfiguracionController();
		oFotografoCtrl = new FotografoController();
		oParticipanteCtrl = new ParticipanteController();
		oSesionesCtrl = new SesionesController();
	}

	public static Connection getConnection() {
		return oConnection;
	}

	public PersonasController getoPersonasCtrl() {
		return oPersonasCtrl;
	}

	public FotografoController getoFotografoCtrl() {
		return oFotografoCtrl;
	}

	public ParticipanteController getoParticipanteCtrl() {
		return oParticipanteCtrl;
	}

	public ConfiguracionController getConfiguracionCtrl() {
		return oConfiguracionCtrl;
	}

	public SesionesController getSesionesCtrl() {
		return oSesionesCtrl;
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

	public static boolean executeProcedure(String json, String sFunction) {

		boolean bExito = false;

		try {

			CallableStatement statement = oConnection.prepareCall(sFunction);
			statement.setString(1, json);

			statement.execute();
			statement.close();

			bExito = true;

		} catch (SQLException ex) {
			System.out.println(ex);
			bExito = false;
		}

		return bExito;

	}

	// ###### Cliente y Usuario ######

	public boolean addCliente(Cliente oCliente) {
		boolean booExito = false;
		int iIdLugar;
		Lugar oLugar;

		if (oCliente.getoLugar() != null) {
			oLugar = oConfiguracionCtrl.getoLugarCtrl().searchByDireccion(oCliente.getoLugar());
			if (oLugar != null) {
				iIdLugar = oLugar.getiIdLugar();
			} else {
				iIdLugar = oConfiguracionCtrl.getoLugarCtrl().add(oCliente.getoLugar());
			}

			oCliente.getoLugar().setiIdLugar(iIdLugar);
		}

		if (getoPersonasCtrl().addCliente(oCliente)) {
			booExito = true;
		}

		return booExito;
	}

	public boolean updateCliente(Cliente oCliente) {
		boolean booExito = false;
		Lugar oLugar = oConfiguracionCtrl.getoLugarCtrl().searchByDireccion(oCliente.getoLugar());

		if (oLugar == null) {
			if (oCliente.getoLugar().getiIdLugar() == 0) {
				oCliente.getoLugar().setiIdLugar(oConfiguracionCtrl.getoLugarCtrl().add(oCliente.getoLugar()));
			} else {
				oConfiguracionCtrl.getoLugarCtrl().update(oCliente.getoLugar());
			}

		}
		if (getoPersonasCtrl().updateCliente(oCliente)) {
			booExito = true;
		}
		return booExito;
	}

	public Cliente searchCliente(Cliente oCliente) {
		Cliente oClienteaResult = getoPersonasCtrl().searchCliente(oCliente);
		if (oClienteaResult != null) {
			oClienteaResult.setoLugar(oConfiguracionCtrl.getoLugarCtrl().searchByPk(oClienteaResult.getoLugar()));
		}
		return oClienteaResult;
	}

	// ###### PEDIDOS #######

	public Pedido searchPedido(Pedido oPedido) {
		Pedido oPedidoResult = getSesionesCtrl().getoPedidoCtrl().searchByPk(oPedido);
		if (oPedidoResult != null) {
			oPedidoResult.setoEmpresa(getConfiguracionCtrl().getoEmpresaCtrl().searchByPk(oPedidoResult.getoEmpresa()));
			oPedidoResult.getoEmpresa()
					.setoLugar(oConfiguracionCtrl.getoLugarCtrl().searchByPk(oPedidoResult.getoEmpresa().getoLugar()));
		}
		return oPedidoResult;
	}

	public List<Pedido> listarPedidos() {
		List<Pedido> lPedidos = getSesionesCtrl().getoPedidoCtrl().listar();
		if (lPedidos.size() > 0) {
			for (Pedido oPedido : lPedidos) {
				oPedido.setoEmpresa(getConfiguracionCtrl().getoEmpresaCtrl().searchByPk(oPedido.getoEmpresa()));
			}
		}
		return lPedidos;
	}

	// ###### SESION ######

    public Sesion searchSesion(Sesion oSesion){
        Sesion oSesionResult = getSesionesCtrl().searchSesion(oSesion);
        if (oSesionResult != null) {
            oSesionResult.setoCliente(getoPersonasCtrl().getoClientCtrl().searchById(oSesionResult.getoCliente()));
			oSesionResult.setoLugar(getConfiguracionCtrl().getoLugarCtrl().searchByPk(oSesionResult.getoLugar()));
        }
        return oSesionResult;
    }

	public List <Sesion> listarSesion(){
        List <Sesion> lSesiones = getSesionesCtrl().getoSesionCtrl().listar();
        if (lSesiones.size() > 0) {
			for (Sesion oSesion : lSesiones) {
				oSesion.setoCliente(getoPersonasCtrl().getoClientCtrl().searchById(oSesion.getoCliente()));
			}
        }
        return lSesiones;
    }

	public List <FotografoSesion> listarFotografoSesion(Sesion oSesion){
		List <FotografoSesion> lFotografoSesion = getSesionesCtrl().getoFotografoSesionCtrl().listar(oSesion.getiIdSesion());
		if (lFotografoSesion.size() > 0) {
			for (FotografoSesion oFotografoSesion : lFotografoSesion) {
				oFotografoSesion.setoFotografo(getoFotografoCtrl().searchByPk(oFotografoSesion.getoFotografo()));
			}
		}
		return lFotografoSesion;
	}

	public List <ParticipanteSesion> listarParticipanteSesion(Sesion oSesion){
		List <ParticipanteSesion> lParticipanteSesion = getSesionesCtrl().getoParticipanteSesionCtrl().listar(oSesion.getiIdSesion());
		if (lParticipanteSesion.size() > 0) {
			for (ParticipanteSesion oFotografoSesion : lParticipanteSesion) {
				oFotografoSesion.setoParticipante(getoParticipanteCtrl().searchById(oFotografoSesion.getoParticipante()));
			}
		}
		return lParticipanteSesion;
	}
}
