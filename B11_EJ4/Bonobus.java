abstract class BonoBus {
    private int idBonoBus;
    private short shLineaBus;
    private byte bDia;
    private byte bMes;
    private short shAnio;
    private byte bHoras;
    private byte bMinutos;
    private final short SHANIOMAX = 9999;

    public BonoBus(int idBonoBus) {
		setIdBonoBus(idBonoBus);
	}

	public int getIdBonoBus() {
		return idBonoBus;
	}

	public boolean setIdBonoBus(int idBonoBus) {
		boolean booExito = false;
        if (idBonoBus > 1000000 && idBonoBus <= 999999999) {
           this.idBonoBus = idBonoBus; 
           booExito = true;
        }
        return booExito;
	}

	public short getShLineaBus() {
		return shLineaBus;
	}  

	public boolean setShLineaBus(short shLineaBus) {
        boolean booExito = false;
        if (idBonoBus > 0 && idBonoBus <= 10) {
            this.shLineaBus = shLineaBus; 
           booExito = true;
        }
        return booExito;
	}

	public byte getbDia() {
		return bDia;
	}
    
	public boolean setbDia(byte bDia) {
		boolean booExito = false;
        if (bDia > 0 && bDia <= diaMaxFecha(getbMes(), esBisiesto(this.shAnio)) ) {
			this.bDia = bDia;
            booExito = true;
		} else {
			this.bDia = -1;
		}
        return booExito;
	}

	public byte getbMes() {
		return bMes;
	}

	public boolean setbMes(byte bMes) {
		boolean booExito = false;
        if (bMes > 0 && bMes <= 12 ) {
			this.bMes = bMes;
            booExito = true;
		} else {
			this.bMes = -1;
		}
        return booExito;
	}

	public short getShAnio() {
		return shAnio;
	}

	public boolean setShAnio(short shAnio) {
		boolean booExito = false;
        if (shAnio > 1 && shAnio < SHANIOMAX) {
			this.shAnio = shAnio;
            booExito = true;
		} else {
			this.shAnio = -1;
		}
        return booExito;
	}

	public byte getbHoras() {
		return bHoras;
	}

	public boolean setbHoras(byte bHoras) {
		boolean booExito = false;
		if (bHoras >= 0 && bHoras <= 23) {
			this.bHoras = bHoras;
			booExito = true;
		}
		return booExito;
	}

	public byte getbMinutos() {
		return bMinutos;
	}

	public boolean setbMinutos(byte bMinutos) {
		boolean booExito = false;
		if (bMinutos >= 0 && bMinutos <= 59) {
			this.bMinutos = bMinutos;
			booExito = true;
		}
		return booExito;
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

	public String toString() {
		return "### Id Bonobus " + idBonoBus + " ###\n\n";
	}

	public void BonoBus(int idBonoBus2) {
	}
	
    
    
}
