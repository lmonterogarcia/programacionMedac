
public class ProgramadorBombillas {

	private byte bNumeroBombillas; //PK
	private Bombilla[] aBombillas; //NN
	
	public ProgramadorBombillas(byte bNumeroBombillas) {
		aBombillas =  new Bombilla[bNumeroBombillas];
		for (byte bContador = 0; bContador < aBombillas.length; bContador++) {
			aBombillas[bContador] = new Bombilla();
		}
	}
	
	public Bombilla[] getoBombillas() {
		return aBombillas;
	}
	public void setoBombillas(Bombilla[] oBombillas) {
		this.aBombillas = oBombillas;
	}
	public byte getbNumeroBombillas() {
		return bNumeroBombillas;
	}
	public void setbNumeroBombillas(byte bNumeroBombillas) {
		this.bNumeroBombillas = bNumeroBombillas;
	}
	
	/*
	 * ######## # CRUD # ########
	 */
	
	public void programa1() {
		System.out.println("--------------");
		for (byte bContador = 0; bContador < this.aBombillas.length; bContador++) {
			if (bContador % 2 == 0) {
				aBombillas[bContador].encender();
			} else {
				aBombillas[bContador].apagar();
			}
		}
		System.out.println(aBombillas);
		for (byte bContador = 0; bContador < this.aBombillas.length; bContador++) {
			aBombillas[bContador].cambiar();
		}
		System.out.println(aBombillas);
		System.out.println("--------------");
	}
	
	public void programa2() {
		
	}
	
	public void pprograma3() {
		
	}
	
	public String toString() {
		String sMostrar = "";
		
		for (int bContador = 0; bContador < this.aBombillas.length; bContador++) {
			sMostrar += this.aBombillas[bContador].mostrar() + " ";
		}
		
		return sMostrar;
	}
	
	
	
	
//	 Bombilla bombilla1;
//	 Bombilla bombilla2;
//	 Bombilla bombilla3;
//	 Bombilla bombilla4;
//	 Bombilla bombilla5;
//	 Bombilla bombilla6;
//	 
//	 
//	 
//	public Bombilla getBombilla1() {
//		return bombilla1;
//	}
//	public void setBombilla1(Bombilla bombilla1) {
//		this.bombilla1 = bombilla1;
//	}
//	public Bombilla getBombilla2() {
//		return bombilla2;
//	}
//	public void setBombilla2(Bombilla bombilla2) {
//		this.bombilla2 = bombilla2;
//	}
//	public Bombilla getBombilla3() {
//		return bombilla3;
//	}
//	public void setBombilla3(Bombilla bombilla3) {
//		this.bombilla3 = bombilla3;
//	}
//	public Bombilla getBombilla4() {
//		return bombilla4;
//	}
//	public void setBombilla4(Bombilla bombilla4) {
//		this.bombilla4 = bombilla4;
//	}
//	public Bombilla getBombilla5() {
//		return bombilla5;
//	}
//	public void setBombilla5(Bombilla bombilla5) {
//		this.bombilla5 = bombilla5;
//	}
//	public Bombilla getBombilla6() {
//		return bombilla6;
//	}
//	public void setBombilla6(Bombilla bombilla6) {
//		this.bombilla6 = bombilla6;
//	}
	 
	 
	 
}
