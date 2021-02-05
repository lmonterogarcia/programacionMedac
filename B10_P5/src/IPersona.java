
public interface IPersona {

	public final byte BSOLTERO = 1;
	public final byte BCASADO = 2;
	public final byte BSEPARADO = 3;
	public final byte BDIVORCIADO = 4;
	public final byte BVIUDO = 5;

	public String getsNombre();
	public boolean setsNombre(String sNombre);
	public String getsApellido1();
	public boolean setsApellido1(String sApellido1);
	public String getsApellido2();
	public boolean setsApellido2(String sApellido2);
	public short getShEdad();
	public boolean setShEdad(short shEdad);
	public float getfEstatura();
	public boolean setfEstatura(float fEstatura);
	public float getfPeso();
	public boolean setfPeso(float fPeso);
	public byte getbEstado();
	public boolean setbEstado(byte bEstado);
	public String nombreEstado();
}
