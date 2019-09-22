package Laboral;

public class Persona {
	
	String nombre;
	String dni;
	char sexo;
	
	//Constructor con todos los atributos
	public Persona(String nombre, String dni, char sexo) {
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
	}
	
	//Constructor con los atributos solicitados
	public Persona (String nombre,char sexo) {
		this.nombre=nombre;
		this.sexo=sexo;
	}
	
		
	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public String imprime() {
		String datos="Nombre: " + nombre + " ,Dni: " + dni;
		return datos;
	}
	

}
