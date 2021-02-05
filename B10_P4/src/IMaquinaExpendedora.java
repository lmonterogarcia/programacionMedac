
public interface IMaquinaExpendedora {

	public final short SHCREDITOMAX = 100;
	public final byte BVALORPARACADAMONEDACAMBIO = 50;
	public final float[] AVALORESMONEDAS = {2f,1f,0.5f,0.2f,0.10f,0.05f,0.02f,0.01f};
	
	public void crearOrResetCambioMaquina();
	public boolean insertarMoneda(float fMoneda);
	public float valorArrayMonedas(short[] aMonedas);
	public boolean pedirProducto(float fPrecio);
	public void ponerToCeroaMonedasUsuario();
	public String pedirDevolucion();
	public String creditoDisponible();
	public String toString();
	public String calculoDevolucionMoneda();
	public boolean hayCambio();
	public boolean haGastado();
}
