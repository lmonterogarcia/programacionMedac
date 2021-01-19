
public class Fecha {

	private byte bDia; //PK
	private byte bMes; //PK
	private short shAnio; //PK
	private final byte BDIAMAX;
	
	public Fecha(byte bDia, byte Mes, short shAnio) {
		setbDia(bDia);
		setbMes(bMes);
		setShAnio(shAnio);
	}
	
	public byte getbDia() {
		return bDia;
	}
	public void setbDia(byte bDia) {
		this.bDia = bDia;
	}
	public byte getbMes() {
		return bMes;
	}
	public void setbMes(byte bMes) {
		this.bMes = bMes;
	}
	public short getShAnio() {
		return shAnio;
	}
	public void setShAnio(short shAnio) {
		if (shAnio > 1 && shAnio < 9999) {
			this.shAnio = shAnio;
		}
	}
	
	private byte diaMax(short shAnio, byte bMes) {
		byte bDiaMax = 0;
		
		return bDiaMax;
	}
}
