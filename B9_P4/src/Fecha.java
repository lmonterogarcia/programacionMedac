import java.util.*;

public class Fecha {
	
	private byte bDia; //PK
	private byte bMes; //PK
	private short shAnio; //PK
	private final short SHANIOMAX = 9999;
	
	public Fecha(byte bDia, byte bMes, short shAnio) {
		setbMes(bMes);
		setShAnio(shAnio);
		setbDia(bDia);
	}
	
	public byte getbDia() {
		return bDia;
	}
	public void setbDia(byte bDia) {
		if (bDia > 0 && bDia <= diaMaxFecha(getbMes(), esBisiesto(this.shAnio)) ) {
			this.bDia = bDia;
		} else {
			this.bDia = -1;
		}
	}
	public byte getbMes() {
		return bMes;
	}
	public void setbMes(byte bMes) {
		if (bMes > 0 && bMes <= 12 ) {
			this.bMes = bMes;
		} else {
			this.bMes = -1;
		}
		
	}
	public short getShAnio() {
		return shAnio;
	}
	public void setShAnio(short shAnio) {
		if (shAnio > 1 && shAnio < SHANIOMAX) {
			this.shAnio = shAnio;
		} else {
			this.shAnio = -1;
		}
	}
	
	private byte diaMaxFecha(byte bMes, boolean booBisiesto) {
		byte bDiaMax;
		
		if (bMes==2) {
			if (booBisiesto) {
				bDiaMax = 29;
			} else {
				bDiaMax = 28;
			}
		} else if (bMes==4 || bMes==6 || bMes==9 || bMes==11) {
			bDiaMax = 30;
		} else {
			bDiaMax = 31;
		}
		
		return bDiaMax;
	}
	
	private boolean esBisiesto(short shAnio) {
		boolean booEsBisiesto;

		if ((shAnio % 4 == 0 && shAnio % 100 != 0) || shAnio % 400 == 0) {
			booEsBisiesto = true;
		} else {
			booEsBisiesto = false;
		}

		return booEsBisiesto;
	}
	
	public boolean checkFecha() {
		boolean booExito = false;
		
		if (this.getbDia() > 0 && this.getbMes() > 0 && this.getShAnio() > 0) {
			booExito = true;
		}
		return booExito;
	}
	
	public String diaSemana(){
      
		String sDiaSemana = "";
		Calendar oCalendario = Calendar.getInstance();
		oCalendario.set(shAnio,bMes,bDia);
		int dia = oCalendario.get(Calendar.DAY_OF_WEEK);
		
		 if(dia==Calendar.SUNDAY){
		   sDiaSemana += "Domingo";
		 } else if(dia==Calendar.MONDAY){
			 sDiaSemana += "Lunes";
		 } else if(dia==Calendar.TUESDAY){
			 sDiaSemana += "Martes";
		 } else if(dia==Calendar.WEDNESDAY){
			 sDiaSemana += "Miercoles";
		 } else if(dia==Calendar.THURSDAY){
			 sDiaSemana += "Jueves";
		 } else if(dia==Calendar.FRIDAY){
			 sDiaSemana += "vViernes";
		 } else if(dia==Calendar.SATURDAY){
			 sDiaSemana += "Sabado";
		 }
		 
		 return sDiaSemana;
    }
	
	public String toString() {
		String sFecha = "";
		sFecha += diaSemana() + getbDia() +"/"+ getbMes() + "/" + getShAnio();
		return sFecha;
	}
}
