package Laboral;

public class Empleado extends Persona {

	private int categoria;
	int anyos;
	
	
	/*
	 * En el constructor que posee todos los valores indicamos las condiciones
	 * de los atributos donde:
	 * categoria debe estar valores 1-10
	 * anyos debe ser valor positivo
	 */
	
	public Empleado (String nombre, String dni, char sexo, int categoria, int anyos) throws Exception {
		super(nombre, dni, sexo);
		if(categoria>0 && categoria <11) {
			this.categoria=categoria;
		} else {
			throw new Exception("Categoria incorrecta. Valor debe ser entre 1 y 10");
		}
		
		if(anyos>=0) {
			this.anyos=anyos;
		} else {
			throw new Exception("Anyos incorrecto. Valor debe ser positivo");
		}
		
	}

	/*
	 * En este constructor solicitado se entiende que:
	 * categoria:1
	 * anyos trabajados:0
	 */
	public Empleado(String nombre, String dni, char sexo) {
		super(nombre, dni, sexo);	
		this.categoria=1;
		this.anyos=0;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) throws Exception {
		if(categoria>0 && categoria <11) {
			this.categoria=categoria;
		} else {
			throw new Exception("Categoria incorrecta. Valor debe ser entre 1 y 10");
		}
	}
	
	public void incrAnyo() {
		anyos++;
		
	}
	
	/*
	 * @see Laboral.Persona#imprime()
	 */
	public String imprimir() {
		String datosempleado = super.imprime()+" ,categoria:"+categoria+" ,años:" +anyos+" ";
		return datosempleado;
	}
	

	
}
