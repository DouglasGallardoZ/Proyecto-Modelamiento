package clases;

public class Operario extends Empleado {

	public Operario() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor de Operario
	 * @param cedula
	 * @param nombre
	 * @param nss
	 * @param domicilio
	 */
	public Operario(int cedula, String nombre, int nss, String domicilio) {
		super(cedula, nombre, nss, domicilio);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" Operario|";
	}
	
	/**
	 * Retorna verdadero si el empleado a consultar es operario
	 * caso contrario retorna falso
	 * @param oEmpleado
	 * @return
	 */
	public static boolean isOperario(Empleado oEmpleado) {
		try {
			Operario oP=(Operario)oEmpleado;
			return true;
		} catch (ClassCastException e) {
			// TODO: handle exception
			return false;
		}
	}

}
