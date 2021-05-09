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

    public Pedido searchPedido(Pedido oPedido){
        Pedido oPedidoResult = getSesionesCtrl().getoPedidoCtrl().searchByPk(oPedido);
		if (oPedidoResult != null) {
			oPedidoResult.setoEmpresa(getConfiguracionCtrl().getoEmpresaCtrl().searchByPk(oPedidoResult.getoEmpresa()));
		}
		return oPedidoResult;
    }

	public List<Pedido> listarPedidos (){
		List <Pedido> lPedidos = getSesionesCtrl().getoPedidoCtrl().listar();
		if (lPedidos.size() > 0) {
			for (Pedido oPedido : lPedidos) {
				oPedido.setoEmpresa(getConfiguracionCtrl().getoEmpresaCtrl().searchByPk(oPedido.getoEmpresa()));
			}
		}
		return lPedidos;
	}
	
	/*
	 * public boolean removeCliente(Cliente oCliente) { return
	 * getoPersonasCtrl().removeCliente(oCliente, oConnection); } public Cliente
	 * searchCliente(Cliente oCliente) { return
	 * getoPersonasCtrl().searchCliente(oCliente, oConnection); } public Usuario
	 * searchUsuario(Cliente oCliente) { return
	 * getoPersonasCtrl().searchUsuario(oCliente, oConnection); }
	 * 
	 * 
	 * 
	 * // ###### Fotografo ###### public boolean addFotografo(Fotografo oFotografo)
	 * { return getoPersonasCtrl().getoFotografoCtrl().add(oFotografo, oConnection);
	 * }
	 * 
	 * public boolean removeFotografo(Fotografo oFotografo) { return
	 * getoPersonasCtrl().removeFotografo(oFotografo, oConnection); }
	 * 
	 * public boolean updateFotografo(Fotografo oFotografo) { return
	 * getoPersonasCtrl().getoFotografoCtrl().update(oFotografo, oConnection); }
	 * 
	 * public Fotografo searchFotografo(Fotografo oFotografo) { return
	 * getoPersonasCtrl().searchFotografo(oFotografo, oConnection); }
	 * 
	 * 
	 * 
	 * // ###### Participante ###### public boolean addParticipante(Participante
	 * oParticipante) { return getoPersonasCtrl().addParticipante(oParticipante,
	 * oConnection); }
	 * 
	 * public boolean removeParticipante(Participante oParticipante) { return
	 * getoPersonasCtrl().removeParticipante(oParticipante, oConnection); }
	 * 
	 * public boolean updateParticipante(Participante oParticipante) { return
	 * getoPersonasCtrl().getoParticipanteCtrl().update(oParticipante, oConnection);
	 * }
	 * 
	 * public Participante searchParticipante(Participante oParticipante) { return
	 * getoPersonasCtrl().searchParticipante(oParticipante, oConnection); }
	 * 
	 * 
	 * 
	 * // ###### Empresa ###### public boolean addEmpresa(Empresa oEmpresa) { return
	 * getoConfiguracionCtrl().getoEmpresaCtrl().add(oEmpresa, oConnection); }
	 * 
	 * public boolean removeEmpresa(Empresa oEmpresa) { return
	 * getoConfiguracionCtrl().getoEmpresaCtrl().remove(oEmpresa, oConnection); }
	 * 
	 * public boolean updateEmpresa(Empresa oEmpresa) { return
	 * getoConfiguracionCtrl().getoEmpresaCtrl().update(oEmpresa, oConnection); }
	 * 
	 * public Empresa searchEmpresa(Empresa oEmpresa) { return
	 * getoConfiguracionCtrl().searchEmpresa(oEmpresa, oConnection); //Cuando se
	 * implemente LUGAR HAY QUE CAMCBIAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! }
	 * 
	 * 
	 * 
	 * // ###### Estado ###### public boolean addEstado(Estado oEstado) { return
	 * getoConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl().add(oEstado,
	 * oConnection); }
	 * 
	 * public boolean removeEstado(Estado oEstado) { return
	 * getoConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl().remove(
	 * oEstado, oConnection); }
	 * 
	 * public boolean updateEstado(Estado oNuevoEstado, Estado oEstadoAntiguo) {
	 * return
	 * getoConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl().update(
	 * oNuevoEstado, oEstadoAntiguo, oConnection); }
	 * 
	 * public Estado searchEstado(Estado oEstado) { return
	 * getoConfiguracionCtrl().getoTipoAndEstadoCtrl().getoEstadoCtrl().searchByPk(
	 * oEstado, oConnection); }
	 * 
	 * 
	 * 
	 * 
	 * // ###### TipoSesion ###### public boolean addTipoSesion(TipoSesion
	 * oTipoSesion) { return
	 * getoConfiguracionCtrl().getoTipoAndEstadoCtrl().getoTipoSesionCtrl().add(
	 * oTipoSesion, oConnection); }
	 * 
	 * public boolean removeTipoSesion(TipoSesion oTipoSesion) { return
	 * getoConfiguracionCtrl().getoTipoAndEstadoCtrl().getoTipoSesionCtrl().remove(
	 * oTipoSesion, oConnection); }
	 * 
	 * public boolean updateTipoSesion(TipoSesion oTipoSesion) { return
	 * getoConfiguracionCtrl().getoTipoAndEstadoCtrl().getoTipoSesionCtrl().update(
	 * oTipoSesion, oConnection); }
	 * 
	 * public TipoSesion searchTipoSesion(TipoSesion oTipoSesion) { return
	 * getoConfiguracionCtrl().getoTipoAndEstadoCtrl().getoTipoSesionCtrl().
	 * searchByPk(oTipoSesion, oConnection); }
	 */
}
