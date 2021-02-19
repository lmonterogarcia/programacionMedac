public class ClienteInversor extends Cliente {
        
    CarteraValoresProfesional oCarteraPro;

    public ClienteInversor(String sDni) {
        super(sDni);
        
    }

    public ClienteInversor(String sDni, String sNombre, String sApellidos, int iTelefono, byte bTipo, CarteraValoresProfesional oCarteraPro){
        super(sDni, sNombre, sApellidos, iTelefono, bTipo);
        setoCarteraPro(oCarteraPro);
    }


    public CarteraValoresProfesional getoCarteraPro() {
        return oCarteraPro;
    }

    public void setoCarteraPro(CarteraValoresProfesional oCarteraPro) {
        this.oCarteraPro = oCarteraPro;
    }
    
    public String toString() {
        String sMensaje = super.toString();
        if (oCarteraPro != null) {
            sMensaje += "Cartera de Valores\n" + oCarteraPro.toString();
        }
        return sMensaje;
     }
}
