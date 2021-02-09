public abstract class Persona implements IPersona {
	private String nombre;
	private double edad;

	public Persona(String nombre, double edad) {
		setNombre(nombre);
		setEdad(edad);		
	}
	
	public String getNombre() {
		return nombre;
	}

	public double getEdad() {
		return edad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(double edad) {
		this.edad = edad;
	}

	public String toString() {
		int iAnios = (int)edad;
		int iMeses = (int)((this.edad - iAnios) * 12);
		String sResultado = "Hola, mi nombre es " + getNombre() + " y tengo " + iAnios + " años";
		if(iMeses != 0) {
			sResultado += " y " + iMeses + " meses";
		}		
		return sResultado;
	}
}