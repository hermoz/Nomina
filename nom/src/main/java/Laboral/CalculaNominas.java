package Laboral;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CalculaNominas {

	public static void main(String[] args) throws Exception {
		
		/*
		 * 4.1. Cree el empleado: “James Cosling”, dni=32000032G, sexo=’M’, categoría=4, años=7
			4.2. Cree el empleado: “Ada Lovelace”, dni=32000031R, sexo=’F’
		 */
		Empleado emp = new Empleado("James Cosling","32000032G",'M',4,7);
		Empleado emp2 = new Empleado("Ada Lovelace","32000032G",'F');
		ObjectOutputStream out = null;

		//Llamamos al método escribe declarado en esta misma clase
		escribe(emp,emp2);
		
		//Incrementamos años trabajados del empleado 2
		emp2.incrAnyo();
		
		//Establecemos categoria de 9 años al empleado 1
		emp.setCategoria(9);
		
		//Imprimimos de nuevo para observar cambios
		escribe(emp,emp2);
			
		try {
			
			/*
			 * Definimos fichero llamado empleados.txt con los datos del enunciado para ambos empleados 
			 * Realizamos la escritura en un fichero empleados.txt actualizando los datos establecidos en el 
			 * apartado anterior
			 * 
			 * 	
			 * Declaramos un nuevo método en las clases llamado: escribeFichero
			 * para la escritura en el nuevo fichero con un formato distinto donde sólo aparezcan los valores
			 * separados por comas
			 */
			
			FileWriter escribir = new FileWriter("empleados.txt");
			BufferedWriter bw = new BufferedWriter(escribir);
			
			bw.write(emp.escribeFichero()+ "\n");
			bw.write(emp2.escribeFichero()+ "\n");
			
			bw.close();

	
			} catch (EOFException eof){
				System.out.println("error en fichero");			
			} catch (FileNotFoundException fnf) {
				System.out.println("archivo no encontrado");
			}
		
	
		
	try { 
		
		/*
		 * Definimos fichero binario de salida con informacion solicitada
		 * En ficheros binarios prescindimos de close y usamos finally para cerrar el flujo
		 */
		
		
		out= new ObjectOutputStream(new FileOutputStream("sueldos.dat"));
		
		out.writeUTF("Dni: " + emp.dni + ". Sueldo: " + Nomina.sueldo(emp) + "\n");
		out.writeUTF("Dni: " + emp2.dni + ". Sueldo: " + Nomina.sueldo(emp2) + "\n");

		//Input/Output Exception
		} catch (IOException e) {
			//este mensaje describe la excepcion
			System.out.println(e.getMessage()); 
			
		} finally {
			try {
				if(out != null) {
					out.close();
				}
				
			} catch (IOException e) {
				//este mensaje describe la excepcion
				System.out.println(e.getMessage());	
			}
	
		}
					
	}	
	
	/*
	 * Declare un método privado escribe que reciba los valores de los dos empleados 
	 * e imprima sus atributos y el sueldo que cada uno gana.
	 * Llamamos a los métodos declarados en las clases: SUELDO e IMPRIMIR
	 */
	
	public static void escribe(Empleado emp, Empleado emp2) {
		System.out.println("Datos: " + emp.imprimir() + " .Sueldo: " + Nomina.sueldo(emp));
		System.out.println("Datos: " + emp2.imprimir() + " .Sueldo: " + Nomina.sueldo(emp2));
	}
	


}
